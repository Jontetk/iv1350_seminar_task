package se.kth.iv1350.seminartask.view;


import se.kth.iv1350.seminartask.model.*;

     /**
     * An observer that writes the total income since the program start  to console 
     */
public class TotalRevenueView extends TotalRevenuePrint{
    

   /**
    * constructor of the object, the total income is 0 when object is created
    */
    public TotalRevenueView(){
        super();

    }

  
    @Override
    protected void doShowTotalIncome() throws Exception{
        System.out.format("TotalRevenue: %.3f \n\n" ,totalIncome);
    }

    
    @Override
    protected void handleErrors(Exception e){
        new ErrorMessageHandler().showErrorMessage("An error occured during console printout");
        
    }
}

