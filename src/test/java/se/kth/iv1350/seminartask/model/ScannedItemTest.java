package se.kth.iv1350.seminartask.model;

import org.junit.jupiter.api.Test;

import se.kth.iv1350.seminartask.util.ItemDTO;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.*;

public class ScannedItemTest {
    private ScannedItem scannedItemOne;
    private ScannedItem scannedItemTwo;
    @BeforeEach
    void Setup(){
        ItemDTO itemOne = new ItemDTO(1, null, null, 0);
        ItemDTO itemTwo = new ItemDTO(2, null, null, 0);
        scannedItemOne = new ScannedItem(itemOne, 10);
        scannedItemTwo = new ScannedItem(itemTwo, 5);
    }

    @Test
    void testEqualsSelf() {
        assertTrue(scannedItemOne.equals(scannedItemOne), "Object does not equal self");
    }
    
    @Test
    void testEqualsDifferentIds(){
        assertFalse(scannedItemOne.equals(scannedItemTwo), "Objects with different ids equal each other");
    }
}
