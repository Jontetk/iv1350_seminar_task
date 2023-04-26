package se.kth.iv1350.seminartask.util;

public class ItemDTO {
    private int ItemID;
    private String description;
    private Cash price;
    private float VatRate;


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
