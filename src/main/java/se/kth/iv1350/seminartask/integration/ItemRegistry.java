package se.kth.iv1350.seminartask.integration;
import se.kth.iv1350.seminartask.util.*;
public class ItemRegistry {

    private ItemDTO[] items = {new ItemDTO(1,"Milk",(new Cash(15,"I$")),0.34),
    new ItemDTO(2,"Iphone",new Cash(1500000,"I$"),0.01),
    new ItemDTO(2,"Iphone",new Cash(1500000,"I$"),0.01)}

    ItemRegistry () {

    }
    public ItemDTO searchItem (int id) {
        for (ItemDTO item : items) {
            (if item.getItemID() == id) 
                return item;
            
        }

    }
}
