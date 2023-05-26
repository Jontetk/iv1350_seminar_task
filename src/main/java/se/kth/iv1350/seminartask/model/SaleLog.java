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
    private StringBuilder appliedDiscounts;
    private boolean discountApplied = false;
    private ArrayList<SaleObserver> saleObservers = new ArrayList<SaleObserver>();
    /**
     * Constructor method for an object representing the log for this entire sale.
     */
    public SaleLog(){
        appliedDiscounts = new StringBuilder();
    }

    /**
     * Gets the saleDate the date and time for when this sale occurs
     * @return saleDate in ISO-8601 format. 
     */
    public LocalDateTime getSaleDate() {
        return this.saleDate;
    }
    /**
     * Gets the price with vat and dicounts applied
     * @return
     */
    public Cash getTotalWithAllApplied() {
        double totalPrice = this.registeredItems.getTotalPrice().getAmount();
        double totalVAT = this.registeredItems.getTotalVAT().getAmount();
        double totalDiscount = this.registeredItems.getTotalDiscount().getAmount();
        Cash totalAll = new Cash(totalPrice+totalVAT-totalDiscount,this.registeredItems.getTotalPrice().getCurrency());
        return totalAll;
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
     * Gets the total discount
     * @return the total discount
     */
    public void addAppliedDiscount(String discountName) {
        appliedDiscounts.append(discountName);
        appliedDiscounts.append(" ,");
        discountApplied = true;
    }
    public String getAppliedDiscounts() {

        if (discountApplied)
        appliedDiscounts.deleteCharAt(appliedDiscounts.length()-1);
        
            
        return appliedDiscounts.toString();


    }
    public Cash getTotalDiscount() {
        return this.registeredItems.getTotalDiscount();
    }
    /**
     * Adds to the total discount
     * @param discount The discount to be added
     */
    public void addTotalDiscount(Cash discount) {
        this.registeredItems.addTotalDiscount(discount);
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
     * Saves the change and notifies observers as the sale is complete when the change is saved
     * @param change the change to be saved to the log.
     */
    public void saveChange(Cash change) {
        this.change = change;
        this.notifyAllObservers();
    }
    /**
     * 
     * Adds multiple observers to the list of observers. These observers
     * are notified when <Code>notifyAllObservers</Code> is evoked
     * @param obs an arraylist of objects that implements SaleObserver class
     */
    public void addSaleObservers(ArrayList<SaleObserver> obs) {
        saleObservers.addAll(obs);
        
    }

    /**
     * Notifies all observers with the total
     * 
     */
    private void notifyAllObservers() {
        for (SaleObserver observer : saleObservers){
            observer.newSale(this.getTotalWithAllApplied());
        }
    }

}
