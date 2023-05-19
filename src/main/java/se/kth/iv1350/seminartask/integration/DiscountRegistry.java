package se.kth.iv1350.seminartask.integration;
import java.util.HashMap;
import java.util.ArrayList;

import se.kth.iv1350.seminartask.integration.discounting.*;
import se.kth.iv1350.seminartask.util.*;
import se.kth.iv1350.seminartask.model.*;

public class DiscountRegistry {
    // Here we are going to have an customer ID, 
    // discountObject hasmap. 
    private HashMap<Integer,ArrayList<DiscountParameterDTO>> discounts = new HashMap<Integer,ArrayList<DiscountParameterDTO>>();

    public DiscountRegistry(){
        ArrayList<DiscountParameterDTO> custom_discounts = new ArrayList<DiscountParameterDTO>();
        custom_discounts.add(new DiscountParameterDTO(new MultipleOfSameItemDiscount(), "50% off all milk", 0, new ScannedItem(new ItemDTO(7,"Milk",(new Cash(15,"I$")),0.3,100),1), new Cash(15/2,"I$")));
        custom_discounts.add(new DiscountParameterDTO(new MultipleOfSameItemDiscount(), "3 cookies for price of 1", 0, new ScannedItem(new ItemDTO(5,"Cookie",new Cash(25,"I$"),0.21,25),3), new Cash(50,"I$")));
        custom_discounts.add(new DiscountParameterDTO(new TotalPriceDiscount(), "300 I$ off if more or euqal to 15000 I$", 15000, null, new Cash(300,"I$")));
        discounts.put(1,custom_discounts);
        custom_discounts = new ArrayList<DiscountParameterDTO>();
        custom_discounts.add(new DiscountParameterDTO(new MultipleOfSameItemDiscount(), "500000 I$ off all pears", 0, new ScannedItem(new ItemDTO(4,"Pear",new Cash(150000000,"I$"),10,60),1), new Cash(500000,"I$")));
        custom_discounts.add(new DiscountParameterDTO(new TotalPriceDiscount(), "50 I$ off if more or equal to 100 I$", 50, null, new Cash(50,"I$")));
        custom_discounts.add(new DiscountParameterDTO(new TotalPriceDiscount(), "300 I$ off if more or euqal to 15000 I$", 15000, null, new Cash(300,"I$")));
        discounts.put(2,custom_discounts);
    }  

    public ArrayList<DiscountParameterDTO> getEligibleDiscounts(int customerID) {
        return discounts.get(customerID);
    }
}
