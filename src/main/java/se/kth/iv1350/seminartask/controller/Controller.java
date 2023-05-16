package se.kth.iv1350.seminartask.controller;

import java.io.IOException;
import java.util.ArrayList;

import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.Logger.*;

import se.kth.iv1350.seminartask.integration.*;
import se.kth.iv1350.seminartask.model.*;

import se.kth.iv1350.seminartask.util.Cash;
import se.kth.iv1350.seminartask.util.ItemDTO;


/**
 * 
 * Controller for running the program
 */
public class Controller {
    private ItemRegistry itemRegistry;
    private AccountingRegistry accountingRegistry;
    private Printer printer;
    private RegisteredItems registeredItems;
    private CashRegister cashRegister;
    private SaleLog currentSaleLog;

    private static Logger logger = Logger.getLogger(Controller.class.getName());
    

    /**
     * 
     * @param creator registry creator, used to fetch registry objects for use
     * @param printer for printing receipts
     */
    public Controller(RegistryCreator creator, Printer printer){
        this.printer = printer;
        this.itemRegistry = creator.getItemRegistry();
        this.accountingRegistry = creator.getAccountingRegistry();
        this.cashRegister = new CashRegister(new Cash(10000,"I$"));
        try {
            logger.addHandler(new FileHandler("controller%g.log"));
        } catch (Exception e) {}

    }

    /**
     * Initate new object to store all bought items during sale
     */
    public void startSale(){
        this.registeredItems = new RegisteredItems();
     
    }

    

    /**
     * Returns an array of all items bought by customer
     * 
     * @return an array of {@link se.kth.iv1350.seminartask.model.ScannedItem ScannedItem} 
     * representing all bought items 
     */
    public ArrayList<ScannedItem> getAllRegistered(){
        return this.registeredItems.getItems();
    }


    /**
     * Searches item in registery and returns it while adding item 
     * and its amount to the <Code>RegisteredItems</Code> 
     * 
     * @param id the id of the seearched item
     * @param amount  the amount of items to be bought
     * @return {@link se.kth.iv1350.seminartask.util.ItemDTO ItemDTO} instance. 
     * The value is null if id is not found in <Code>ItemRegistry</Code> 
     * @throws IdNotFoundException if given id could not be found in the itemRegistry
     * @throws OperationFailedException if unable to do find item for any other reason.
     */
    public ItemDTO selectItem(int id, int amount) throws  IdNotFoundException, OperationFailedException
    {   
        ItemDTO item = null;
        try {
            item = itemRegistry.searchItem(id);
            registeredItems.addItem(item, amount);
        } catch (ItemRegistryException itemRegExc) {
            logger.log(Level.SEVERE, "Operation Failed",itemRegExc );
            throw new OperationFailedException("Could not find the item.",itemRegExc);
        }
       
        return item;
    }

    /**
     * The selectItem method for when amount is not given. The amount defaults to 1.
     * 
     * @param id the id of the seearched item
     * @return {@link se.kth.iv1350.seminartask.util.ItemDTO ItemDTO} instance. 
     * The value is null if id is not found in <Code>ItemRegistry</Code> 
     * @throws IdNotFoundException if given id could not be found in the itemRegistry
     * @throws OperationFailedException if unable to do find item for any other reason.
     */
    public ItemDTO selectItem(int id) throws  IdNotFoundException, OperationFailedException
    {
        return selectItem(id ,1);
    }

    /**
     * gets the change amount based on the given payment and sale total
     * @param paidAmount the amount of money paid by customer
     * @return cash instance representing change, is null if paid amount is lower
     * than the total payment needed
     */
    public Cash calculateChange(Cash paidAmount){
        double totalVatAmount = currentSaleLog.getTotalVAT().getAmount();
        double totalPriceAmount = currentSaleLog.getTotalPrice().getAmount();
        String currencyType = currentSaleLog.getTotalPrice().getCurrency();
        Cash totalPriceWithVAT = new Cash(totalPriceAmount+totalVatAmount, currencyType);

        Cash change = cashRegister.addPayment(paidAmount, totalPriceWithVAT);
        if (change != null )
            currentSaleLog.saveChange(change);
        return change; 
    }

    /**
     * gets the current total
     * @return the current total as a {@link se.kth.iv1350.seminartask.util.Cash Cash} object
     */
    public Cash getTotal(){
        currentSaleLog = new SaleLog();
        currentSaleLog.saveRegistredItems(registeredItems);
        double totalPrice = registeredItems.getTotalPrice().getAmount();
        double totalVat = registeredItems.getTotalVAT().getAmount();
        String currencyType = currentSaleLog.getTotalPrice().getCurrency();
        Cash totalPriceWithVAT = new Cash(totalPrice+totalVat, currencyType);
        return totalPriceWithVAT;
    }


    
    /**
     * 
     * Saves the current date to SaleLog ann prints a receipt, then gets the current SaleLog
     * @return the current {@link se.kth.iv1350.seminartask.model.SaleLog SaleLog} 
     */
    public SaleLog getReceipt()throws IOException {
        currentSaleLog.saveCurrentDate();
        printer.printReceipt(currentSaleLog);
        return currentSaleLog; 
    }


    /**
     * 
     * save the log to the accounting registery
     * and update inventory using the information in sale log
     * @throws OperationFailedException if unable to save to the database
     */
    public void endSale() throws OperationFailedException{
        try{
        accountingRegistry.saveSaleLog(currentSaleLog);
        } 
        catch (AccountingRegistryException accountRegException) {
            logger.log(Level.SEVERE,"Problem occured in accounting Database", accountRegException);
            throw new OperationFailedException("Could not save to the accounting database",accountRegException);
        }
        try{
        itemRegistry.updateInventory(currentSaleLog);
        } 
        catch (ItemRegistryException itemRegException) {
            logger.log(Level.SEVERE,"Problem occured in inventory Database", itemRegException);
            throw new OperationFailedException("Could not save to the inventory database",itemRegException);
        }
    }
}
