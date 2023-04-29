package se.kth.iv1350.seminartask.controller;

import java.util.ArrayList;

import se.kth.iv1350.seminartask.integration.*;
import se.kth.iv1350.seminartask.model.*;

import se.kth.iv1350.seminartask.util.Cash;
import se.kth.iv1350.seminartask.util.ItemDTO;

public class Controller {
    private ItemRegistry itemRegistry;
    private AccountingRegistry accountingRegistry;
    private Printer printer;
    private RegisteredItems registeredItems;
    private CashRegister cashRegister;
    private SaleLog currentSaleLog;
    

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
        

    }

    /**
     * Initate new object to store all bought items during sale
     */
    public void startSale(){
        this.registeredItems = new RegisteredItems();
     
    }

    /**
     * @deprecated
     * Not implemented
     */
    public void endSale(){
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
     */
    public ItemDTO selectItem(int id, int amount)
    {
        ItemDTO item = itemRegistry.searchItem(id);
        boolean itemFound = item != null;
        if(itemFound)
            {
                registeredItems.addItem(item,amount);
            }
        return item;
    }

    /**
     * The selectItem method for when amount is not given. The amount defaults to 1.
     * 
     * @param id the id of the seearched item
     * @return {@link se.kth.iv1350.seminartask.util.ItemDTO ItemDTO} instance. 
     * The value is null if id is not found in <Code>ItemRegistry</Code> 
     */
    public ItemDTO selectItem(int id){
        return selectItem(id ,1);
    }

    /**
     * gets the change amount based on the given payment and sale total
     * @param paidAmount the amount of money paid by customer
     * @return change
     */
    public Cash amountPaid(Cash paidAmount){
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
        Cash totalprice = registeredItems.getTotalPrice();
        return totalprice;
    }


    
    /**
     * gets the current SaleLog
     * @return the current {@link se.kth.iv1350.seminartask.model.SaleLog SaleLog} 
     */
    public SaleLog getReceipt(){
        accountingRegistry.saveSaleLog(currentSaleLog);
        printer.printReceipt(currentSaleLog);
        return currentSaleLog; 
    }

}
