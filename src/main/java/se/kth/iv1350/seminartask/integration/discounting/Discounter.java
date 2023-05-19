package se.kth.iv1350.seminartask.integration.discounting;

import se.kth.iv1350.seminartask.util.DiscountParameterDTO;
import se.kth.iv1350.seminartask.model.SaleLog;

public interface Discounter {

    /**
     * Applies discount to the log based on given paramers
     * 
     * @param ParameterDTO {@link se.kth.iv1350.seminartask.util.DiscountParameterDTO DiscountParameterDTO} object
     * that includes all parameters related to the discount.
     * @param saleLog the object where the discount is saved
     */
    void discount(DiscountParameterDTO ParameterDTO, SaleLog saleLog); 
}
