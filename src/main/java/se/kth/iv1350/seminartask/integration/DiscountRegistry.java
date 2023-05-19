package se.kth.iv1350.seminartask.integration;
import java.util.HashMap;
import java.util.ArrayList;
import se.kth.iv1350.seminartask.util.*;


    /**
     * A registry that stores that stores a hasmap mapping customer IDs to an 
     * array of discounts that they eligible for
     */

public class DiscountRegistry {
    
    
    private HashMap<Integer,ArrayList<DiscountParameterDTO>> discounts = new HashMap<Integer,ArrayList<DiscountParameterDTO>>();

    public DiscountRegistry(){
        

    }

    /**
     * 
     * @param customerID Id for the customer that the discounts are fetched 
     * @return an array list of DiscountParameterDTOs that a customer is eligible for
     */
    public ArrayList<DiscountParameterDTO> getEligibleDiscounts(int customerID) {
        return discounts.get(customerID);
    }
}
