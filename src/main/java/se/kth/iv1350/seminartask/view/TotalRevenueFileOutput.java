package se.kth.iv1350.seminartask.view;

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
public class TotalRevenueFileOutput extends TotalRevenuePrint {
    PrintWriter revenueStream = null;

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
    public void doShowTotalIncome() {

        
        revenueStream.println("Total after sale"+(saleNum)+": "+totalIncome);

    }
    public void handleErrors(Exception e) {
        ErrorMessageHandler errorMsgHandler = new ErrorMessageHandler()
        errorMsgHandler.showErrorMessage(e.toString());
    }
    
}
