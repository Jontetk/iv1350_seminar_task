package se.kth.iv1350.seminartask.integration;
import se.kth.iv1350.seminartask.model.*;
import static java.lang.System.out;
public class Printer {
    
    public Printer(){

    }

    public void printReceipt(SaleLog currentSaleLog)
    {
        /*TODO Test it see page 163. and fix float format
         *
         */
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
