package se.kth.iv1350.seminartask.integration.discounting;

import se.kth.iv1350.seminartask.model.SaleLog;
import se.kth.iv1350.seminartask.model.ScannedItem;
import se.kth.iv1350.seminartask.util.Cash;
import se.kth.iv1350.seminartask.util.DiscountParameterDTO;

public class MultipleOfSameItemDiscount implements Discounter{
    public MultipleOfSameItemDiscount(){

    }
    /***
     * Applies discount if a certain amount of a specified item has been bought by customer.
     * This specifed discount may be applied multiple times.
     * The amount the discount applies is once per the specified amount of the items. 
     * 
     */
    @Override
    public void discount(DiscountParameterDTO parameterDTO, SaleLog saleLog){
        int index = saleLog.getScannedItems().indexOf(parameterDTO.getItemAndAmountNeeded());
        if(index != -1)
        {
        ScannedItem saleItem = saleLog.getScannedItems().get(index);
        int discountApplicationCount = saleItem.getAmount()/ parameterDTO.getItemAndAmountNeeded().getAmount();
        
        Double discountAmount = parameterDTO.getFixedDiscountAmount().getAmount() * discountApplicationCount;
        Cash discountInCash = new Cash(discountAmount, "I$");
        saleItem.setDiscount(discountInCash);
        saleLog.addTotalDiscount(discountInCash);
        saleLog.addAppliedDiscount(parameterDTO.getName());

        }
       


    }
    
}
