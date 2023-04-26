package se.kth.iv1350.seminartask.integration;
import se.kth.iv1350.seminartask.util.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ItemRegistryTest {
    ItemRegistry itemReg = new ItemRegistry();

    @Test
    void testSearchItemWithIdOfOne() {
        int expecteditem = 1;
        assertEquals(expecteditem, itemReg.searchItem(1).getItemID());
        

    }
}
