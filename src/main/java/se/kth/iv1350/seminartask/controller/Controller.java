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
    private Cash totalPriceWithVAT;

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
     * Searches item in registery and returns it while adding item and its amount to the <Code>RegisteredItems</Code> 
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
                ScannedItem currentScanneditem = new ScannedItem(item, amount);
                registeredItems.addItem(currentScanneditem);
            }
        return item;
    }

    /**
     * gets the change amount based on the given payment and sale total
     * @param paidAmount the amount of money paid by customer
     * @return change
     */
    public Cash amountPaid(Cash paidAmount){
    // totalPriceWithVAT = currentSaleLog.

        Cash change = cashRegister.addPayment(paidAmount, registeredItems.getTotalPrice());
        return change; 
    }

    /**
     * 
     * @return
     */
    public Cash getTotal(){
        currentSaleLog = new SaleLog();
        currentSaleLog.saveRegistredItems(registeredItems);
        Cash totalprice = registeredItems.getTotalPrice();
        return totalprice;
    }


    
    
    public SaleLog getReceipt(){
        accountingRegistry.saveSaleLog(currentSaleLog);
        printer.printReceipt(currentSaleLog);
        return currentSaleLog; 
    }

}
