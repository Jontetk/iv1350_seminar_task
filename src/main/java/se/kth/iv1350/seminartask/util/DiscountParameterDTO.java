package se.kth.iv1350.seminartask.util;

import se.kth.iv1350.seminartask.integration.discounting.Discounter;
import se.kth.iv1350.seminartask.model.ScannedItem;

public final class DiscountParameterDTO {
 
    // This class is going to give the necessary 
    // discount reletad arguments for the strategy 
    private Discounter strategy;
    private String name;
    private double minNeededTotal; // Can perhaps be cash??
    private ScannedItem itemAndAmountNeeded;

    private Cash fixedDiscountAmount; 

    
    /***
     * 
     * @param strategy
     * @param name
     * @param minNeededTotal
     * @param itemAndAmountNeeded
     * @param discountAmount
     */
    public DiscountParameterDTO(Discounter strategy, String name, double minNeededTotal, ScannedItem itemAndAmountNeeded, Cash discountAmount) {
        this.strategy = strategy;
        this.name = name;
        this.minNeededTotal = minNeededTotal;
        this.itemAndAmountNeeded = itemAndAmountNeeded;
        this.fixedDiscountAmount = discountAmount;
    }

    public Discounter getStrategy() {
        return strategy;
    }
    public String getName() {
        return name;
    }
    
    public double getMinNeededTotal() {
        return minNeededTotal;
    }

    public Cash getfixedDiscountAmount() {
        return fixedDiscountAmount;
    }

    public ScannedItem getItemAndAmountNeeded() {
        return itemAndAmountNeeded;
    }

    

}


