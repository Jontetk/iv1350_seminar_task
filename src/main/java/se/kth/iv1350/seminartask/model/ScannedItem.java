package se.kth.iv1350.seminartask.model;
import se.kth.iv1350.seminartask.util.*;


public class ScannedItem {
    private ItemDTO item;
	private int amount;

    /**
     * Creates the object for the amount and what type a specific item in the sale is
     * @param item The type of item which should be added
     * @param amount The amount of the item that should be added
     */
    public ScannedItem(ItemDTO item, int amount) {
        this.item = item;
        this.amount = amount;
	}
    /**
     * 
     * @param amount Amount to increase the amount of a scanned item with
     */
	public void increaseAmount(int amount) {
        this.amount += amount;
	}
    /**
     * 
     * @return The scanned item 
     */
	public ItemDTO getItem() {
		return this.item;
	}
    /**
     * 
     * @return The amount of the item
     */
	public int getAmount() {
		return this.amount;
	}
    
    
    @Override
    public boolean equals(Object obj) {
        if(obj == null)
            return false;

        if (obj.getClass() != this.getClass())
            return false;

        int thisID = this.getItem().getItemID();
        int objID = ((ScannedItem)obj).getItem().getItemID();
       

        return thisID == objID;
    }
}
