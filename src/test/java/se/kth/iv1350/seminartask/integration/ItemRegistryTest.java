package se.kth.iv1350.seminartask.integration;
import se.kth.iv1350.seminartask.util.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


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

    

}
