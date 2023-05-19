package se.kth.iv1350.seminartask.util;

import se.kth.iv1350.seminartask.integration.discounting.Discounter;
import se.kth.iv1350.seminartask.model.ScannedItem;



/**
 * a DTO that is used to provide necessary information to perform a discount
 * 
 */
public final class DiscountParameterDTO {
 
    
    private Discounter strategy;
    private String name;
    private double minNeededTotal;
    private ScannedItem itemAndAmountNeeded;

    private Cash fixedDiscountAmount; 

    
    /***
     * creates an instance of DiscountParameterDTO
     * 
     * @param strategy {@link se.kth.iv1350.seminartask.integration.discounting.Discounter Discounter} type 
     * object that provides an implementaion of the discounting method. 
     * 
     * @param name name of the discount 
     * @param minNeededTotal minimum amount of total required to be eligible for the discount 
     * @param itemAndAmountNeeded {@link se.kth.iv1350.seminartask.model.ScannedItem ScannedItem} type object
     * that specifies the item and the amount needed to qualify for an discount
     * @param discountAmount amount discounted in object type {@link se.kth.iv1350.seminartask.util.Cash Cash}
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


