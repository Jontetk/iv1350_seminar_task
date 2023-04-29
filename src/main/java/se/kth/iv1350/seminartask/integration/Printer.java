package se.kth.iv1350.seminartask.integration;
import se.kth.iv1350.seminartask.model.*;
import static java.lang.System.out;
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


    }
}
