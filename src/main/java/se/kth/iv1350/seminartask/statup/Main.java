package se.kth.iv1350.seminartask.statup;
import se.kth.iv1350.seminartask.controller.*;
import se.kth.iv1350.seminartask.integration.*;
import se.kth.iv1350.seminartask.model.*;
import se.kth.iv1350.seminartask.util.ItemDTO;
import se.kth.iv1350.seminartask.view.*;

import java.util.ArrayList;
import se.kth.iv1350.seminartask.util.*;

public class Main {
    public static void main(String[] args) {
        RegistryCreator registryCreator = new RegistryCreator();
        Printer printer = new Printer();
        Controller controller = new Controller(registryCreator, printer);
        View view = new View(controller);

       

        

    }
}
