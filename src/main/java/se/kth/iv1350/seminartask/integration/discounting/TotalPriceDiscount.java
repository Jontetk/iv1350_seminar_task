package se.kth.iv1350.seminartask.integration.discounting;

import se.kth.iv1350.seminartask.model.SaleLog;
import se.kth.iv1350.seminartask.util.DiscountParameterDTO;

public class TotalPriceDiscount implements Discounter {
    public TotalPriceDiscount(){

    }
    
    /***
     * A fixed amount of discount is applied to log if the total price of the sale exceeds 
     * a specifed amount in the parameterDTO. 
     */
    @Override
    public void discount(DiscountParameterDTO parameterDTO, SaleLog saleLog){
        if(saleLog.getTotalPrice().getAmount() >= parameterDTO.getMinNeededTotal()){
            saleLog.addTotalDiscount(parameterDTO.getFixedDiscountAmount());
            saleLog.addAppliedDiscount(parameterDTO.getName());
        }

    }
}
