package se.kth.iv1350.seminartask.model;


import se.kth.iv1350.seminartask.util.*;
import java.util.ArrayList;

/**
 * The registred items for the current sale
 * 
 */
public class RegisteredItems {
    private ArrayList<ScannedItem> items;
    private Cash totalPrice;
    private Cash totalVAT;
    private Cash totalDiscount;

    /**
     * Creates the RegistredItems object for saving registred items
     * 
     */
    public RegisteredItems(){
        this.items = new ArrayList<ScannedItem>();
        this.totalPrice = new Cash(0.0, "I$");
        this.totalVAT = new Cash(0.0, "I$");
        this.totalDiscount = new Cash(0.0, "I$");
    }


    /**
     * Gets the total discount for
     * @return The total discount
     */
    public Cash getTotalDiscount() {
        return totalDiscount;
    }
    /**
     * Adds to the total discount
     * @param discount The added disocunt
     */
    public void addTotalDiscount(Cash discount) {
        this.totalDiscount.saveAmount(discount.getAmount() + this.totalDiscount.getAmount());
    }

    /**
     * Gets all the items
     * @return An {@link java.util.ArrayList ArrayList} containing {@link se.kth.iv1350.seminartask.model.ScannedItem ScannedItem} Objects
     */
    public ArrayList<ScannedItem> getItems() {
        return items;
    }
    /**
     * Gets the total price excluding VAT for the sale
     * @return The price for the sale as a {@link se.kth.iv1350.seminartask.util.Cash Cash} Object
     */
    public Cash getTotalPrice() {
        return totalPrice;
    }
    /**
     * Gets the total VAT for the sale
     * @return The vat for the sale as a {@link se.kth.iv1350.seminartask.util.Cash Cash} Object
     */
    public Cash getTotalVAT() {
        return totalVAT;
    }


    
    /**
     * Adds the selected {@link se.kth.iv1350.seminartask.util.ItemDTO ItemDTO} to the Registred items
     * If the item already exists its amount is added to the other items
     * @param currentItem The {@link se.kth.iv1350.seminartask.util.ItemDTO ItemDTO } to be saved
     * @param itemAmount The amount of the item
     */
    public void addItem(ItemDTO currentItem,int itemAmount) {   
        
        double itemsCashAmount = currentItem.getPrice().getAmount() * itemAmount; 
        double vatRate = currentItem.getVatRate();
        totalPrice.saveAmount(itemsCashAmount+totalPrice.getAmount());
        totalVAT.saveAmount((itemsCashAmount * vatRate)+totalVAT.getAmount());
        ScannedItem currentScannedItem = new ScannedItem(currentItem, itemAmount);
        int index = 0 ;
        if (items.contains(currentScannedItem)){
            index = items.indexOf(currentScannedItem);
            items.get(index).increaseAmount(currentScannedItem.getAmount());
        }
        else          
            items.add(currentScannedItem);
            
            

    }
    
}
