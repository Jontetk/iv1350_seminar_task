package se.kth.iv1350.seminartask.view;
import se.kth.iv1350.seminartask.model.*;
import se.kth.iv1350.seminartask.util.ItemDTO;
import se.kth.iv1350.seminartask.controller.*;
import se.kth.iv1350.seminartask.util.*;
import static java.lang.System.out;

import java.io.IOException;

import static java.lang.System.in;
import java.util.Scanner;
/**
 * 
 * The view which communicates with the user
 */
public class View {
    /**
     * The view which communicates with the controller and the user
     * @param controller the {@link se.kth.iv1350.seminartask.controller Controller} that the view should use 
     * 
     */
    public View(Controller controller) throws IOException{
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
            while (amount <= 0) {
                out.print("\nAmount:");
                amount = scanner.nextInt();
            }
            out.println("\nThe current items are:\n");
            if (controller.getAllRegistered().size() != 0){

                for(ScannedItem scannedItem : controller.getAllRegistered()){
        
                    out.println(scannedItem.getItem().getDescription()+ " x "+scannedItem.getAmount()+"\n");

                }
            }
            selectedItem = controller.selectItem(itemID,amount);
            if (selectedItem != null){
                out.println("Last scanned item:");
                out.println(selectedItem.getDescription()+" x "+amount+"\n");
            }
            
            else
                out.println("The last item was invalid please try again\n");
            out.print("Want to keep scanning? [y/n]:");
            keepScanning = scanner.next();
            if (keepScanning.toLowerCase().equals("n"))
                scanning = false;
            
        }
        Cash totalPrice = controller.getTotal();
        out.println("\nTotal price to pay:"+totalPrice.getAmount() +totalPrice.getCurrency());
        out.print("Payment:");
        double payment = scanner.nextDouble();
        String currency = "I$";       
        Cash totalPay = new Cash(payment, currency);
        Cash change = controller.calculateChange(totalPay);
        while (change == null) {
            out.println("\nThat is not enoguh. Total price to pay:"+totalPrice.getAmount() +totalPrice.getCurrency());
            out.print("Payment:");
            payment = scanner.nextDouble();
            currency = "I$";       
            totalPay = new Cash(payment, currency);
            change = controller.calculateChange(totalPay);
        }
        out.println("Change:"+change.getAmount()+change.getCurrency()+"\n");
        SaleLog currentSaleLog = controller.getReceipt();
        for (ScannedItem item : currentSaleLog.getScannedItems()) {
            double itemPrice = item.getItem().getPrice().getAmount()*item.getAmount();
            double itemVat = item.getItem().getVatRate()*itemPrice; 
            String itemCurrency = item.getItem().getPrice().getCurrency();
            out.println(item.getItem().getDescription() +" x " + item.getAmount()+" "+ itemPrice+itemCurrency);
            out.println("Unit price: "+ item.getItem().getPrice().getAmount()+itemCurrency+" VAT Price: "+itemVat+itemCurrency);
            out.println("");
        }
        double totalPriceWithVat = currentSaleLog.getTotalPrice().getAmount() + currentSaleLog.getTotalVAT().getAmount();
        double totalVat = currentSaleLog.getTotalVAT().getAmount();
        out.println("Total with VAT: " + totalPriceWithVat);
        out.println("Total VAT: "+ totalVat);
        out.println("Change: "+currentSaleLog.getChange().getAmount());
        out.println("\n"+currentSaleLog.getSaleDate().getYear()+"-"+currentSaleLog.getSaleDate().getMonthValue()+"-"+currentSaleLog.getSaleDate().getDayOfMonth());
        out.println(currentSaleLog.getSaleDate().getHour()+":"+currentSaleLog.getSaleDate().getMinute()+":"+currentSaleLog.getSaleDate().getSecond());

        controller.endSale();
        scanner.close();
    }   
    
}
