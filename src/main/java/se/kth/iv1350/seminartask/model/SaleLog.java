package se.kth.iv1350.seminartask.model;

import se.kth.iv1350.seminartask.util.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class SaleLog {
    
    private LocalDateTime saleDate;
    private RegisteredItems registeredItems;
    private Cash change;

    public SaleLog(){
        this.saleDate = LocalDateTime.now();
    }
    public LocalDateTime getSaleDate() {
        return this.saleDate;
    }
    public ArrayList<ScannedItem> getScannedItems() {
        return this.registeredItems.getItems();
    }
    public Cash getTotalVAT() {
        return this.registeredItems.getTotalVAT();
    }
    public Cash getChange() {
        return this.change;
    }
    public void saveRegistredItems(RegisteredItems registeredItems) {
        this.registeredItems = registeredItems;
    }
    public void saveChange(Cash change) {
        this.change = change;
    }
    
    /*TODO implement other methods of the class */
    

}
