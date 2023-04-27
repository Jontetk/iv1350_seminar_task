package se.kth.iv1350.seminartask.model;


import se.kth.iv1350.seminartask.util.*;
import java.util.ArrayList;

public class RegisteredItems {
    ArrayList<ScannedItem> items;
    Cash totalPrice;
    Cash totalVAT;
    
    public RegisteredItems(){
        items = new ArrayList<ScannedItem>();
        totalPrice = new Cash(0.0, "");
        totalVAT = new Cash(0.0, "");
    }

    /**
     * @deprecated Only for testing???
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


    /*TODO ADD fucntions to calculate totalVat & price in this method below */
    /*so it updates those when new items are added */

    public void addItem(ScannedItem currentScannedItem) {   
        /*TODO CODE SMELL: MESSAGE CHAIN  BLOATED CODE?*/
        int itemAmount = currentScannedItem.getAmount();
        double itemsCashAmount = currentScannedItem.getItem().getPrice().getAmount() * itemAmount; 
        String itemCurrency = currentScannedItem.getItem().getPrice().getCurrency();
        totalPrice = new Cash(itemsCashAmount, itemCurrency);
        totalVAT = new Cash(totalPrice.getAmount() * currentScannedItem.getItem().getVatRate() * itemAmount,itemCurrency ); 
        /*TODO Implement addItem */
    }
    
}
