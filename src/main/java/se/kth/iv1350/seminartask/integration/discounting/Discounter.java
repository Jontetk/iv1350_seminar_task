package se.kth.iv1350.seminartask.integration.discounting;

import se.kth.iv1350.seminartask.util.DiscountParameterDTO;
import se.kth.iv1350.seminartask.model.SaleLog;

public interface Discounter {

    /**
     * 
     * 
     * @param ParameterDTO
     * @param saleLog
     */
    void discount(DiscountParameterDTO ParameterDTO, SaleLog saleLog); 
}
