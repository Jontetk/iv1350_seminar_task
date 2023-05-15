package se.kth.iv1350.seminartask.integration;
import se.kth.iv1350.seminartask.util.*;
import se.kth.iv1350.seminartask.model.*;
public class ItemRegistry {
    
    // Local attributes to simulate an external database

    private ItemDTO[] items = {new ItemDTO(1,"Test_item_Do_Not_Change",(new Cash(1500,"I$")),0.04,100),
    new ItemDTO(2,"Test_item2_Do_Not_Change",(new Cash(35,"I$")),0.04,100),
    new ItemDTO(3,"Iphone",new Cash(1500000,"I$"),0.01,15000),
    new ItemDTO(4,"Pear",new Cash(150000000,"I$"),10,60),
    new ItemDTO(5,"Cookie",new Cash(25,"I$"),0.21,25),
    new ItemDTO(6,"Candy",new Cash(100,"I$"),0.1,99999999),
    new ItemDTO(7,"Milk",(new Cash(15,"I$")),0.3,100)};
    
    private boolean dataBaseAvailable = true;

    public void setAvailability(boolean condition){
        this.dataBaseAvailable = condition;
    }


    /**
     * Communicates with an external item database
     *
     * 
     */

    ItemRegistry () {
    
    }
    /**
     * Searches through the item database for an item with a certain item id
     * 
     * @param id The item of the wanted item
     * @return The {@link se.kth.iv1350.seminartask.util.ItemDTO ItemDTO} for the wanted item
     *  
     */
    public ItemDTO searchItem (int id) throws ItemRegistryException
    {
        if (this.dataBaseAvailable == false){
            throw new ItemRegistryException("Registery Not running");
            
        }
        for (ItemDTO item : items) {
            if (item.getItemID() == id) 
                return item;
            
        }
        throw new IdNotFoundException("The ID "+id+"was not found");

    }
    /**
     * Updates the inventory depending on which items were bought in the {@link se.kth.iv1350.seminartask.model.SaleLog SaleLog} 
     * @param currentSaleLog The {@link se.kth.iv1350.seminartask.model.SaleLog SaleLog} containing the purchased items
     */
    public void updateInventory (SaleLog currentSaleLog) {
        for(ScannedItem scannedItem : currentSaleLog.getScannedItems()) {
            for (ItemDTO item : items) {
                if (scannedItem.getItem().getItemID() == item.getItemID()) {
                    item.saveStoredItems(item.getStoredItems()-scannedItem.getAmount());
                    break;
                }
            }

        }
    }
}
