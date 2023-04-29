package se.kth.iv1350.seminartask.integration;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.seminartask.model.*;
import se.kth.iv1350.seminartask.util.*;


public class ItemRegistryTest {
    ItemRegistry itemReg = new ItemRegistry();

    @Test
    void testSearchItemWithIdOfOne() {
        int expectedId = 1;
        assertEquals(expectedId, itemReg.searchItem(1).getItemID());
        

    }

    @Test
    void testSearchItemWithIdofFive() {
        int expectedId =5;
        assertEquals(expectedId, itemReg.searchItem(5).getItemID());
    }

    @Test
    void testSearchItemWithInvalidId() {
        assertNull(itemReg.searchItem(-1), "Item with Inalid Id was fetched ");
    }
    @Test
    void testUpdateInventory() {
        ItemDTO item = new ItemDTO(1,"Milk",(new Cash(15,"I$")),0.34,100);
        RegisteredItems regItems = new RegisteredItems();
        regItems.addItem(item, 10);
        SaleLog currentSaleLog = new SaleLog();
        currentSaleLog.saveRegistredItems(regItems);
        itemReg.updateInventory(currentSaleLog);
        int excpectedAmount = 90;
        int actualAmount = itemReg.searchItem(1).getStoredItems();
        assertEquals(excpectedAmount, actualAmount,"The amount was not correct");

    }

    

}
