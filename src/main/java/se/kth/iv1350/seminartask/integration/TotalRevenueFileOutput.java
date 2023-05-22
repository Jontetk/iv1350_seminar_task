package se.kth.iv1350.seminartask.integration;

import se.kth.iv1350.seminartask.model.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.FileWriter;


/**
 * 
 * Observer that prints to file
 */
public class TotalRevenueFileOutput implements SaleObserver {
    PrintWriter revenueStream = null;
    private double totalIncome;
    private int saleNum = 0;
    /**
     * Creator for the totalrevenuefileout
     * @throws IOException 
     */
    public TotalRevenueFileOutput() throws IOException{
        totalIncome = 0;
        revenueStream = new PrintWriter(
                    new FileWriter("TotalRevenue"), true);

    }
    /**
     * method for the observer to print revenue to file since program was started
     */
    public void newSale(SaleLog log) {
        totalIncome += log.getTotalPrice().getAmount()+log.getTotalVAT().getAmount()-log.getTotalDiscount().getAmount();
        
        revenueStream.println("Total after sale"+(++saleNum)+": "+totalIncome);

    }
    
}
