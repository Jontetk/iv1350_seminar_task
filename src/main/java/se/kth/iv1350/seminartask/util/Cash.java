package se.kth.iv1350.seminartask.util;

/**
 * Represents an amount of money with a certain currency.
 */
public class Cash {
    private float amount;
    private String currency;
    /**
     * Creates a new instance representing Cash with 
     * specified amount and currency
     * 
     * @param amount The cash amount represented by the instance
     * @param currency The currency type of the instance
     */
    public Cash(float amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }
    
    public float getAmount() {
        return this.amount; 
    }

    public String getCurrency() {
        return this.currency; 
    }


}
