package se.kth.iv1350.seminartask.integration;
import java.util.HashMap;
import java.util.ArrayList;
import se.kth.iv1350.seminartask.util.*;

public class DiscountRegistry {
    // Here we are going to have an customer ID, 
    // discountObject hasmap. 
    private HashMap<Integer,ArrayList<DiscountParameterDTO>> discounts = new HashMap<Integer,ArrayList<DiscountParameterDTO>>();

    public DiscountRegistry(){
        

    }

    public ArrayList<DiscountParameterDTO> getEligibleDiscounts(int customerID) {
        return discounts.get(customerID);
    }
}
