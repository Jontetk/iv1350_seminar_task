package se.kth.iv1350.seminartask.model;


import se.kth.iv1350.seminartask.util.*;
import java.util.ArrayList;

public class RegisteredItems {
    ArrayList<ScannedItem> items;
    Cash totalPrice;
    Cash totalVAT;
    
    public RegisteredItems(){
        items = new ArrayList<ScannedItem>();
        totalPrice = new Cash(0.0, "I$");
        totalVAT = new Cash(0.0, "I$");
    }

    /**
     * @deprecated Only for testing 
     * @param items
     */
    public RegisteredItems(ArrayList<ScannedItem> items, Cash price, Cash vat){
        this.items.addAll(items);
        this.totalPrice = price;
        this.totalVAT = vat;
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


    

    public void addItem(ScannedItem currentScannedItem) {   
        
        int itemAmount = currentScannedItem.getAmount();
        double itemsCashAmount = currentScannedItem.getItem().getPrice().getAmount() * itemAmount; 
        double vatRate = currentScannedItem.getItem().getVatRate();

        totalPrice.changeAmount(itemsCashAmount);
        totalVAT.changeAmount(itemsCashAmount * vatRate);
        /*TODO UPDATE ARRAYLIST WITH ITEM */
        int index = 0 ;
        if (items.contains(currentScannedItem))
             index = items.indexOf(currentScannedItem);
             items.get(index).increaseAmount(currentScannedItem.getAmount());

            

    }
    
}
