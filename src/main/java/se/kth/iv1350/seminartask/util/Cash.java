package se.kth.iv1350.seminartask.util;

/**
 * Represents an amount of money with a certain currency.
 */
public class Cash {
    private double amount;
    private String currency;
    /**
     * Creates a new instance representing with 
     * specified amount and currency
     * 
     * @param amount The amount represented by the instance
     * @param currency The currency type of the instance
     */
    public Cash(double amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }
    
    /**
     * 
     * @return amount of the <code> Cash </code> instance 
     */
    public double getAmount() {
        return this.amount; 
    }

    /**
     * 
     * @return currecy type of the <code> Cash </code> instance 
     */
    public String getCurrency() {
        return this.currency; 
    }
    /**
     * Changes the amount in the object to the <code>newamount</code>
     * @param newamount The amount to set the amount of the object to
     * 
     */
    public void saveAmount(double newamount) {
        this.amount = newamount;
    }


}
