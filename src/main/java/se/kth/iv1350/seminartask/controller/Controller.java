package se.kth.iv1350.seminartask.controller;

import se.kth.iv1350.seminartask.integration.*;
import se.kth.iv1350.seminartask.model.*;
import se.kth.iv1350.seminartask.util.Cash;

public class Controller {
    ItemRegistry itemRegistry;
    AccountingRegistry accountingRegistry;
    Printer printer;
    RegisteredItems regItems;
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
        this.regItems = new RegisteredItems();
     
    }
}
