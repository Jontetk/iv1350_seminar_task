package se.kth.iv1350.seminartask.controller;

import se.kth.iv1350.seminartask.integration.*;
import se.kth.iv1350.seminartask.model.*;

public class Controller {
    RegistryCreator creator;
    Printer printer;
    RegisteredItems regItems;

    /**
     * 
     * @param creator registry creator, used to fetch registry objects for use
     * @param printer for printing receipts
     */
    public Controller(RegistryCreator creator, Printer printer){
        this.creator = creator;
        this.printer = printer;
    }

    /**
     * Initate new object to store all bought items during sale
     */
    public void startSale(){
        this.regItems = new RegisteredItems();
     
    }
}
