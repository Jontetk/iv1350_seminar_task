package se.kth.iv1350.seminartask.util;

import se.kth.iv1350.seminartask.model.ScannedItem;

public final class DiscountParameterDTO {
    // TODO Put fields for the discount strategy
    // This class is going to give the necessary 
    // discount reletad arguments for the strategy 
    /**
     * 
     */
    private double minNeededTotal; // Can perhaps be cash??
    private ScannedItem itemAndAmountNeeded;


    private Cash discountAmount; // Fixed amount not procent

    public double getMinNeededTotal() {
        return minNeededTotal;
    }

    public Cash getDiscountAmount() {
        return discountAmount;
    }

    public ScannedItem getItemAndAmountNeeded() {
        return itemAndAmountNeeded;
    }


}


