package se.kth.iv1350.seminartask.statup;
import se.kth.iv1350.seminartask.controller.*;
import se.kth.iv1350.seminartask.integration.*;

import se.kth.iv1350.seminartask.view.*;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException{
        RegistryCreator registryCreator = new RegistryCreator();
        Printer printer = new Printer();
        Controller controller = new Controller(registryCreator, printer);
        new View(controller);

       

        

    }
}
