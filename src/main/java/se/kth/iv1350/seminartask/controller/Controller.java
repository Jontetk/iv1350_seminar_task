package se.kth.iv1350.seminartask.controller;

import java.util.ArrayList;

import se.kth.iv1350.seminartask.integration.*;
import se.kth.iv1350.seminartask.model.*;
import se.kth.iv1350.seminartask.util.Cash;
import se.kth.iv1350.seminartask.util.ItemDTO;

public class Controller {
    ItemRegistry itemRegistry;
    AccountingRegistry accountingRegistry;
    Printer printer;
    RegisteredItems registeredItems;
    CashRegister cashRegister;

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

    /*TODO  think about endSale method */
    public void endSale(){
    }

    
    public ArrayList<ScannedItem> getAllRegistered(){
        return this.registeredItems.getItems();
    }


    /*TODO COMPLETE THIS IF NEEDED */
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

     // NOT IMPLELEMTED
    public Cash amountPaid(Cash paidAmount){

        return null; /*Temp return val */
    }

    // NOT IMPLELEMTED
    public SaleLog getReceipt(){

        return null; // temporary
    }
}
