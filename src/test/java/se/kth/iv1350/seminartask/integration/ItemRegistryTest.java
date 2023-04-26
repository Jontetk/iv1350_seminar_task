package se.kth.iv1350.seminartask.integration;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

public class ItemRegistryTest {
    ItemRegistry itemReg = new ItemRegistry();

    @Test
    void testSearchItemWithIdOfOne() {
        int expectedId =1 ;
        assertEquals(1, itemReg.searchItem(1).getItemID());
        

    }
}
