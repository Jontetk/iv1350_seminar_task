package se.kth.iv1350.seminartask.model;


import se.kth.iv1350.seminartask.util.*;
import java.util.ArrayList;

public class RegisteredItems {
    ArrayList<ScannedItem> items;
    Cash totalPrice;
    Cash totalVAT;
    
    public ArrayList<ScannedItem> getItems() {
        return items;
    }
    public Cash getTotalPrice() {
        return totalPrice;
    }
    public Cash getTotalVAT() {
        return totalVAT;
    }

    public void addItem() {
        /*TODO Implement addItem */
    }
    
}
