package se.kth.iv1350.seminartask.integration;

import se.kth.iv1350.seminartask.model.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.FileWriter;



public class TotalRevenueFileOutput implements SaleObserver {
    PrintWriter revenueStream = null;
    private double totalIncome;
    public TotalRevenueFileOutput() throws IOException{
        totalIncome = 0;
        revenueStream = new PrintWriter(
                    new FileWriter("TotalRevenue"), true);

    }
    public void newSale(SaleLog saleLog) {
        totalIncome += saleLog.getTotalPrice().getAmount()+saleLog.getTotalVAT().getAmount();
        
        revenueStream.println(totalIncome);

    }
    
}
