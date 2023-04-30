package se.kth.iv1350.seminartask.model;

import se.kth.iv1350.seminartask.util.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
/**
 * 
 * A log that saves the entire sale
 * 
 */
public class SaleLog {
    
    private LocalDateTime saleDate;
    private RegisteredItems registeredItems;
    private Cash change;

    /**
     * Constructor method for an object representing the log for this entire sale.
     */
    public SaleLog(){
        
    }

    /**
     * Gets the saleDate the date and time for when this sale occurs
     * @return saleDate in ISO-8601 format. 
     */
    public LocalDateTime getSaleDate() {
        return this.saleDate;
    }

    /**
     * Gets the items that were purchased under this sale and saved to log.
     * @return array of data containers that representing the bought items and the amount bought 
     * during this sale
     */
    public ArrayList<ScannedItem> getScannedItems() {
        return this.registeredItems.getItems();
    }
    

    /**
     * @return a <code>Cash</code> instance representing 
     * the sum of all VAT that is applied to this sale.  
     */
    public Cash getTotalVAT() {
        return this.registeredItems.getTotalVAT();
    }

    /**
     * @return a <code>Cash</code> instance representing the
     * change after the payment has been made. 
     */
    public Cash getChange() {
        return this.change;
    }

    /**
     * @return a <code>Cash</code> instance representing the total price 
     * of all items bought during this sale. VAT not included.
     */
    public Cash getTotalPrice () {
        return this.registeredItems.getTotalPrice();
    }

    /**
     * Save the current date in ISO-8601 format. 
     */
    public void saveCurrentDate() {
        this.saleDate = LocalDateTime.now();
    }

    /**
     * 
     * @param registeredItems {@link se.kth.iv1350.seminartask.model.RegisteredItems RegisteredItems} instance to save 
     */
    public void saveRegistredItems(RegisteredItems registeredItems) {
        this.registeredItems = registeredItems;
    }

    /**
     * 
     * @param change the change to be saved to the log.
     */
    public void saveChange(Cash change) {
        this.change = change;
    }

}
