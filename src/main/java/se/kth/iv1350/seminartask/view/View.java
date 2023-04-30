package se.kth.iv1350.seminartask.view;
import java.util.ArrayList;
import se.kth.iv1350.seminartask.model.*;
import se.kth.iv1350.seminartask.util.ItemDTO;
import se.kth.iv1350.seminartask.controller.*;
import se.kth.iv1350.seminartask.util.*;
import static java.lang.System.out;
import static java.lang.System.in;
import java.util.Scanner;

public class View {
    public View(Controller controller) {
        Scanner scanner = new Scanner(in);
        controller.startSale();
        boolean scanning = true;
        int itemID;
        int amount;
        ItemDTO selectedItem;
        String keepScanning;
        while (scanning) {
            out.print("\nItem id:");
            itemID = scanner.nextInt();
            out.print("\nAmount:");
            amount = scanner.nextInt();
            out.println("\nThe current items are:\n");
            if (controller.getAllRegistered().size() != 0){

                for(ScannedItem scannedItem : controller.getAllRegistered()){
        
                    out.println(scannedItem.getItem().getDescription()+ " x "+scannedItem.getAmount()+"\n");

                }
            }
            selectedItem = controller.selectItem(itemID,amount);
            if (selectedItem != null)
                out.println(selectedItem.getDescription()+" x "+amount+"\n");
            
            
            else
                out.println("The last item was invalid please try again\n");
            out.print("Want to keep scanning? [y/n]:");
            keepScanning = scanner.next();
            if (keepScanning.toLowerCase().equals("n"))
                scanning = false;
            
        }
        Cash totalPrice = controller.getTotal();
        out.println("Total price to pay:"+totalPrice.getAmount() +totalPrice.getCurrency());
        out.println("Payment:");
        
  

    }
}
