package se.kth.iv1350.seminartask.controller;

import se.kth.iv1350.seminartask.integration.RegistryCreator;


public class Controller {
    RegistryCreator creator;
    Printer printer;
    public Controller(RegistryCreator creator, Printer printer){
        this.creator = creator;
        this.printer = printer;
    }


    public RegisteredItems startSale(){
        /*TODO Implement after implementing RegisteredItems class */
    }
}
