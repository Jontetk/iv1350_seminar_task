package se.kth.iv1350.seminartask.controller;

import se.kth.iv1350.seminartask.integration.*;
import se.kth.iv1350.seminartask.model.*;

public class Controller {
    RegistryCreator creator;
    Printer printer;
    RegisteredItems regitems;
    public Controller(RegistryCreator creator, Printer printer){
        this.creator = creator;
        this.printer = printer;
    }


    public void startSale(){
        /*TODO Implement after implementing RegisteredItems class */
        RegisteredItems this.regItems = new RegisteredItems();
     
    }
}
