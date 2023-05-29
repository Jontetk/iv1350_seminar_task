package se.kth.iv1350.seminartask.integration;
import se.kth.iv1350.seminartask.model.*;
import static java.lang.System.out;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;


/**
 * 
 * Object that represents a printer that should print the reciept
 * 
 */
public class Printer {
    private File file;
    private PrintStream recieptPrintStream;
    
    /**
     *  Creates an object that represents a printer
     */
    public Printer() throws IOException{
        this.file = new File("reciept.txt");
        this.file.createNewFile();
        this.recieptPrintStream = new PrintStream(file);
    }


    public PrintStream getCurrentPrintStream() {
        return recieptPrintStream;
    }
    public void setCurrentPrintStream(PrintStream newPrintStream) {
        this.recieptPrintStream = newPrintStream;
    }
    
    /**
     * Prints a receipt for this sale based on the information on the log.
     * Item description, price and unit price is given for every item bought.
     * Total with and without VAT and chage for the sale is also given on the receipt
     * @param currentSaleLog the log for the current sale. 
     */
    public void printReceipt(SaleLog currentSaleLog) throws IOException
    {

        for (ScannedItem item : currentSaleLog.getScannedItems()) {
            double itemPrice = item.getItem().getPrice().getAmount()*item.getAmount();
            double itemVat = item.getItem().getVatRate()*itemPrice; 
            String itemCurrency = item.getItem().getPrice().getCurrency();
            recieptPrintStream.println(item.getItem().getDescription() +" x " + item.getAmount()+" "+ itemPrice+itemCurrency);
            recieptPrintStream.println("Unit price: "+ item.getItem().getPrice().getAmount()+itemCurrency+" VAT Price: "+itemVat+itemCurrency);
            recieptPrintStream.println("");
        }
        double totalPriceWithVat = currentSaleLog.getTotalWithAllApplied().getAmount();
        double totalVat = currentSaleLog.getTotalVAT().getAmount();
        recieptPrintStream.println("Applied discounts: " + currentSaleLog.getAppliedDiscounts());
        recieptPrintStream.println("Total Discount: "+ currentSaleLog.getTotalDiscount().getAmount());
        recieptPrintStream.println("Total with VAT: " + totalPriceWithVat);
        recieptPrintStream.println("Total VAT: "+ totalVat);
        recieptPrintStream.println("Change: "+currentSaleLog.getChange().getAmount());
        recieptPrintStream.println("\n"+currentSaleLog.getSaleDate().getYear()+"-"+currentSaleLog.getSaleDate().getMonthValue()+"-"+currentSaleLog.getSaleDate().getDayOfMonth());
        recieptPrintStream.print(currentSaleLog.getSaleDate().getHour()+":"+currentSaleLog.getSaleDate().getMinute()+":"+currentSaleLog.getSaleDate().getSecond());
        recieptPrintStream.close();
    }
}
