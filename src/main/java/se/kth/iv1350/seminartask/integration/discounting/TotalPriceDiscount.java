package se.kth.iv1350.seminartask.integration.discounting;

import se.kth.iv1350.seminartask.model.SaleLog;
import se.kth.iv1350.seminartask.util.DiscountParameterDTO;

public class TotalPriceDiscount implements Discounter {
    public TotalPriceDiscount(){

    }
    
    public void discount(DiscountParameterDTO parameterDTO, SaleLog saleLog){
        if(saleLog.getTotalPrice().getAmount() >= parameterDTO.getMinNeededTotal())
            saleLog.addTotalDiscount(parameterDTO.getfixedDiscountAmount());

    }
}
