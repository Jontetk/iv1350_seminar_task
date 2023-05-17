package se.kth.iv1350.seminartask.view;

import se.kth.iv1350.seminartask.model.*;

public class TotalRevenueView implements SaleObserver{
    private double totalIncome;

    public TotalRevenueView(){
        totalIncome =0;
    }


    public void newSale(SaleLog log){
        totalIncome += log.getTotalPrice().getAmount() + log.getTotalVAT().getAmount();
    System.out.format("TotalRevenue: %.3f \n" ,totalIncome);
    }
    
}
