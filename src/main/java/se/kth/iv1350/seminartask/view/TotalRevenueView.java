package se.kth.iv1350.seminartask.view;

import se.kth.iv1350.seminartask.model.*;
import se.kth.iv1350.seminartask.util.Cash;

     /**
     * An observer that writes the total income since the program start  to console 
     */
public class TotalRevenueView implements SaleObserver{
    private double totalIncome;

   /**
    * constructor of the object, the total income is 0 wwhen object is created
    */
    public TotalRevenueView(){
        totalIncome =0;
    }
    public void newSale(Cash totalPriceWithVATandDiscount){
        totalIncome += totalPriceWithVATandDiscount.getAmount();
        System.out.format("TotalRevenue: %.3f \n\n" ,totalIncome);
    }
    
}
