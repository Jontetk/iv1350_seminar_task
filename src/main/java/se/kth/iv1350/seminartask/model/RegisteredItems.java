package se.kth.iv1350.seminartask.model;


import se.kth.iv1350.seminartask.util.*;
import java.util.ArrayList;

public class RegisteredItems {
    ArrayList<ScannedItem> items;
    Cash totalPrice;
    Cash totalVAT;
    
    public RegisteredItems(){
        items = new ArrayList<ScannedItem>();
    }

    public RegisteredItems(ArrayList<ScannedItem> items){
        this.items.addAll(items);
    }


    public ArrayList<ScannedItem> getItems() {
        return items;
    }
    public Cash getTotalPrice() {
        return totalPrice;
    }
    public Cash getTotalVAT() {
        return totalVAT;
    }


    /*TODO ADD fucntions to calculate totalVat & price in this method below */
    /*so it updates those when new items are added */
    public void addItem() {
        /*TODO Implement addItem */
    }
    
}
