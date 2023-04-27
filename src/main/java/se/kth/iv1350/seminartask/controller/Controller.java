package se.kth.iv1350.seminartask.controller;

import se.kth.iv1350.seminartask.integration.*;
import se.kth.iv1350.seminartask.model.*;

public class Controller {
    RegistryCreator creator;
    Printer printer;
    public Controller(RegistryCreator creator, Printer printer){
        this.creator = creator;
        this.printer = printer;
    }


    public RegisteredItems startSale(){
        /*TODO Implement after implementing RegisteredItems class */
        RegisteredItems regItems = new RegisteredItems();
        return regItems;
    }
}
