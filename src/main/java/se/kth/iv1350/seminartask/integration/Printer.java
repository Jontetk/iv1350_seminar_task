package se.kth.iv1350.seminartask.integration;
import se.kth.iv1350.seminartask.model.*;
import static java.lang.System.out;

import java.io.File;
import java.io.PrintStream;
public class Printer {
    
    /**
     *  Creates an object that represents a printer
     */
    public Printer(){

    }
    
    /**
     * Prints a receipt for this sale based on the information on the log.
     * Item description, price and unit price is given for every item bought.
     * Total with and without VAT and chage for the sale is also given on the receipt
     * @param currentSaleLog the log for the current sale. 
     */
    public void printReceipt(SaleLog currentSaleLog)
    {
        File file = new File("reciept.txt");
        file.createNewFile();
        PrintStream recieptPrintStream = new PrintStream(file);
        for (ScannedItem item : currentSaleLog.getScannedItems()) {
            double itemPrice = item.getItem().getPrice().getAmount()*item.getAmount();
            double itemVat = item.getItem().getVatRate()*itemPrice; 
            String itemCurrency = item.getItem().getPrice().getCurrency();
            recieptPrintStream.println(item.getItem().getDescription() +" x " + item.getAmount()+" "+ itemPrice+itemCurrency);
            recieptPrintStream.println("Unit price: "+ item.getItem().getPrice().getAmount()+itemCurrency+" VAT Price: "+itemVat+itemCurrency);
            recieptPrintStream.println("");
        }
        double totalPriceWithVat = currentSaleLog.getTotalPrice().getAmount() + currentSaleLog.getTotalVAT().getAmount();
        double totalVat = currentSaleLog.getTotalVAT().getAmount();
        recieptPrintStream.println("Total with VAT: " + totalPriceWithVat);
        recieptPrintStream.println("Total VAT: "+ totalVat);
        recieptPrintStream.println("Change: "+currentSaleLog.getChange().getAmount());


    }
}
