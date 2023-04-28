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

        ItemDTO  item1 = new ItemDTO(1, "Milk", new Cash(10, "I$"), 0.1);
        ItemDTO item2 = new ItemDTO(2, "Shit", new Cash(20, "I$"), 0.2);
        ItemDTO item3 = new ItemDTO(3, "Ice", new Cash(30, "I$"), 0.3);
        ItemDTO item4 = new ItemDTO(4, "Water", new Cash(40, "I$"), 0.4);

        ScannedItem scanneditem1 = new ScannedItem(item1, 2);
        ScannedItem scanneditem2 = new ScannedItem(item2, 5);
        ScannedItem scanneditem3 = new ScannedItem(item3, 1);
        ScannedItem scanneditem4 = new ScannedItem(item4, 7);
        ArrayList<ScannedItem> items = new ArrayList<ScannedItem>();
        items.add(scanneditem1);
        items.add(scanneditem2);
        items.add(scanneditem3);
        items.add(scanneditem4);
        Cash price = new Cash (100,"I$");
        Cash vat = new Cash(30,"I$");
        RegisteredItems regItems = new RegisteredItems(items,price,vat);
        SaleLog saleLog = new SaleLog();
        saleLog.saveRegistredItems(regItems);
        CashRegister register = new CashRegister(new Cash(500,"I$"));
        Cash change = register.addPayment(new Cash(100000,"I$"), new Cash(130,"I$"));
        saleLog.saveChange(change);
        printer.printReceipt(saleLog);

        

    }
}
