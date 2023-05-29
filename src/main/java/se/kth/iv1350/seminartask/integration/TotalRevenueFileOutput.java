package se.kth.iv1350.seminartask.integration;

import se.kth.iv1350.seminartask.model.*;
import se.kth.iv1350.seminartask.util.Cash;

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
     * 
     */
    public TotalRevenueFileOutput() {
        this.totalIncome = 0;
        try{
        this.revenueStream = new PrintWriter(
                    new FileWriter("TotalRevenue.txt"), true);
        } catch(IOException e){}

    }
    /**
     * Returns the revenueStream
     * @return The revenueStream
     */
    public PrintWriter getRevenueStream() {
        return revenueStream;
    }
    
    public void setRevenueStream(PrintWriter newRevenueStream) {
        this.revenueStream = newRevenueStream;
    }
    /**
     * method for the observer to print revenue to file since program was started
     */
    public void newSale(Cash totalPriceWithVATandDiscount) {
        totalIncome += totalPriceWithVATandDiscount.getAmount();
        
        revenueStream.println("Total after sale"+(++saleNum)+": "+totalIncome);

    }
    
}
