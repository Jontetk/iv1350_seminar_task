package se.kth.iv1350.seminartask.util;

public class ItemDTO {
    private int ItemID;
    private String description;
    private Cash price;
    private double VatRate;
    /**
     * 
     * @param ItemID The id for the item
     * @param description The description for the item
     * @param price The price of the item as a <code>Cash</code> object
     * @param vatRate The VatRate of the item
     */

    public ItemDTO(int ItemID, String description, Cash price,double vatRate) {
        this.ItemID = ItemID;
        this.description = description;
        this.price = price;
        this.VatRate = vatRate;
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
    
}
