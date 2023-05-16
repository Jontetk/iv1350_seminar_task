package se.kth.iv1350.seminartask.integration;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.seminartask.model.*;
import se.kth.iv1350.seminartask.util.*;


public class ItemRegistryTest {
    ItemRegistry itemReg = new ItemRegistry();

    @Test
    void testSearchItemWithIdOfOne() {
        try {
            int expectedId = 1;
            assertEquals(expectedId, itemReg.searchItem(1).getItemID());
        } catch (Exception e) {}
       
        

    }

    @Test
    void testSearchItemWithIdofFive() {
        try {
        int expectedId =5;
        assertEquals(expectedId, itemReg.searchItem(5).getItemID());  
        } catch (Exception e) {}
        
    }

   
    @Test
    void testUpdateInventory() {
        int actualAmount=0;
        
        ItemDTO item = new ItemDTO(1,"Test_item_Do_Not_Change",(new Cash(1500,"I$")),0.04,100);
        RegisteredItems regItems = new RegisteredItems();
        regItems.addItem(item, 10);
        SaleLog currentSaleLog = new SaleLog();
        currentSaleLog.saveRegistredItems(regItems);
        itemReg.updateInventory(currentSaleLog);
        int excpectedAmount = 90;
        try {
            actualAmount = itemReg.searchItem(1).getStoredItems();
        } catch (Exception e) {}
        
        assertEquals(excpectedAmount, actualAmount,"The amount was not correct");

    }

    @Test
    void testSearchItemWithInvalidId() {
        int id = -1; 
        try {
            itemReg.searchItem(id);
            fail("Succesfully searched with item that does not exist in registry");
        } catch (IdNotFoundException idExc) {
            assertTrue(idExc.getMessage().contains(Integer.toString(id)), "Message does not contain id:"+Integer.toString(id));
        }
        
    }

}
