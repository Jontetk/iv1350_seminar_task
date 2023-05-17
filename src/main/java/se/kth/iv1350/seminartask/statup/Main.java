package se.kth.iv1350.seminartask.statup;
import se.kth.iv1350.seminartask.controller.*;
import se.kth.iv1350.seminartask.integration.*;
import java.util.Scanner;
import se.kth.iv1350.seminartask.view.*;

import java.io.IOException;
import static java.lang.System.in;

public class Main {
    /**
     * 
     * Runs the program by creating the {@link se.kth.iv1350.seminartask.integration.RegistryCreator RegistryCreator}, {@link se.kth.iv1350.seminartask.integration.Printer Printer}, {@link se.kth.iv1350.seminartask.controller.Controller Controller} and finally running the {@link se.kth.iv1350.seminartask.view.View View} 
     * 
     */
    public static void main(String[] args) throws IOException{
        RegistryCreator registryCreator = new RegistryCreator();
        Printer printer = new Printer();
        Controller controller = new Controller(registryCreator, printer);
        Scanner scanner = new Scanner(in);
        new View(controller,scanner);


       

        scanner.close();

    }
}
