package se.kth.iv1350.seminartask.model;

import se.kth.iv1350.seminartask.util.*;
import java.time.LocalDateTime;


public class SaleLog {
    Cash totalDiscount;
    LocalDateTime saleDate;
    RegisteredItems registeredItems;
    public SaleLog(){
        this.saleDate = LocalDateTime.now();
    }
    public Cash getTotalDiscount() {
        return totalDiscount;
    }
    public LocalDateTime getSaleDate() {
        return saleDate;
    }
    public RegisteredItems getRegisteredItems() {
        return registeredItems;
    }
    
    /*TODO implement other methods of the class */
    

}
