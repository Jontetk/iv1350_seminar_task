package se.kth.iv1350.seminartask.model;
import se.kth.iv1350.seminartask.util.*;

/**
 * 
 * 
 * Class for keeping track of the amount and what type a specific item in the sale is
 */

public class ScannedItem {
    private ItemDTO item;
	private int amount;

    /**
     * 
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
		return item;
	}
    /**
     * 
     * @return The amount of the item
     */
	public int getAmount() {
		return amount;
	}
}
