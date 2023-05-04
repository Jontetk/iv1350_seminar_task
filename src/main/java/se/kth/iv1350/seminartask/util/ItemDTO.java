package se.kth.iv1350.seminartask.util;



/**
 * A data object for the items
 * 
 */
public final class ItemDTO {
    private final int ItemID;
    private final String description;
    private final Cash price;
    private final double VatRate;
    private int storedItems;

    /**
     * 
     * @param ItemID The id for the item
     * @param description The description for the item
     * @param price The price of the item as a <code>Cash</code> object
     * @param vatRate The VatRate of the item
     * @param storedItems The amount of items that is stored in the inventory
     */

     public ItemDTO(int ItemID, String description, Cash price,double vatRate,int storedItems) {
        this.ItemID = ItemID;
        this.description = description;
        this.price = price;
        this.VatRate = vatRate;
        this.storedItems = storedItems;
    }
    /**
     * 
     * @return The itemID of the <code>itemDTO</code>
     */
    public int getItemID() {
        
        return this.ItemID;

    }
    /**
     * 
     * @return The description of the <code>itemDTO</code>
     */
    public String getDescription() {
        return this.description;
    }
    /**
     * 
     * @return The price of the <code>itemDTO</code>
     */
    public Cash getPrice() {
        return this.price;
    }
    /**
     * 
     * @return The VatRate of the <code>itemDTO</code>
     */
    public double getVatRate() {
        return this.VatRate; 
    }
    /**
     * 
     * @return The amount of the item stored for use in the {@link se.kth.iv1350.seminartask.integration.ItemRegistry ItemRegistry}
     */
    public int getStoredItems() {
        return this.storedItems;
    }
    /**
     * 
     * @param storeditems The amount of the item stored for use in the {@link se.kth.iv1350.seminartask.integration.ItemRegistry ItemRegistry}
     */
    public void saveStoredItems(int storeditems) {
        this.storedItems = storeditems;
    }
    
}
