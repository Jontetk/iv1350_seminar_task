package se.kth.iv1350.seminartask.view;

import se.kth.iv1350.seminartask.model.*;

public class TotalRevenueView implements SaleObserver{
    private double totalIncome = 0;

    public void newSale(SaleLog log){
        totalIncome += log.getTotalPrice().getAmount();
        System.out.printf("TotalRevenue: %f" ,totalIncome);
    }
    
}
