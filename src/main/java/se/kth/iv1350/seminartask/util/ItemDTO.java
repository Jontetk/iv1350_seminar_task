package se.kth.iv1350.seminartask.util;

public class ItemDTO {
    private int ItemID;
    private String description;
    private Cash price;
    private float VatRate;
    /**
     * 
     * @param ItemID The id for the item
     * @param description The description for the item
     * @param price The price of the item as a Cash object
     * @param vatRate The VatRate of the item
     */

    public ItemDTO(int ItemID, String description, Cash price,float vatRate) {
        this.ItemID = ItemID;
        this.description = description;
        this.price = price;
        this.VatRate = vatRate;
    }
    public int getItemID() {
        return this.ItemID;

    }
    public String getDescription() {
        return this.description;
    }
    public Cash getPrice() {
        return this.price;
    }
    public float getVatRate() {
        return this.VatRate; 
    }
    
}
