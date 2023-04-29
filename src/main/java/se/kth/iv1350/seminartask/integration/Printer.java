package se.kth.iv1350.seminartask.integration;
import se.kth.iv1350.seminartask.model.*;
import static java.lang.System.out;
public class Printer {
    
    public Printer(){

    }
    /**
     * Prints The reciept using the data in the {@link se.kth.iv1350.seminartask.model.SaleLog SaleLog} 
     * @param currentSaleLog The sale log that the printer should print the reciept using
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
