package se.kth.iv1350.seminartask.model;


import se.kth.iv1350.seminartask.util.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Arrays;
import java.util.ArrayList;


public class RegisteredItemsTest {
    private ScannedItem scanneditem1;
    private ScannedItem scanneditem2;
    private ScannedItem scanneditem3;
    private ScannedItem scanneditem4;
    private ItemDTO item1;
    private ItemDTO item2;
    private ItemDTO item3;
    private ItemDTO item4;
    private RegisteredItems regItems;



    @BeforeEach
    void Setup() {
        item1 = new ItemDTO(1, null, new Cash(10, "I$"), 0.1);
        item2 = new ItemDTO(2, null, new Cash(20, "I$"), 0.2);
        item3 = new ItemDTO(3, null, new Cash(30, "I$"), 0.3);
        item4 = new ItemDTO(4, null, new Cash(40, "I$"), 0.4);

        scanneditem1 = new ScannedItem(item1, 2);
        scanneditem2 = new ScannedItem(item1, 5);
        scanneditem3 = new ScannedItem(item1, 1);
        scanneditem4 = new ScannedItem(item1, 7);
        ArrayList<ScannedItem> items = new ArrayList<ScannedItem>();
        items.add(scanneditem1);
        items.add(scanneditem2);
        items.add(scanneditem3);
        items.add(scanneditem4);
        Cash price = new Cash (100,"I$");
        Cash vat = new Cash(30,"I$");
        regItems = new RegisteredItems(items,price,vat);
    }

    @Test
    void testAddItem() {
        ItemDTO newitem = new ItemDTO(5, null, new Cash(40, "I$"), 0.4);
        ScannedItem newscScannedItem = new ScannedItem(newitem, 1);
        regItems.addItem(newscScannedItem);
        assertTrue(regItems.getItems().contains(newscScannedItem));
    }
    @Test
    void testAddItem1() {
        ItemDTO newitem = new ItemDTO(5, null, new Cash(40, "I$"), 0.4);
        ScannedItem newscScannedItem = new ScannedItem(newitem, 1);
        regItems.addItem(newscScannedItem);
        double excpectedcashamount = 140;
        double excpectedvatamount = 46;
        assertEquals(excpectedcashamount, regItems.totalPrice.getAmount(), "Total price does not match excpected");
        assertEquals(excpectedvatamount, regItems.totalVAT.getAmount(), "Total vat does not match excpected");
    }
    @Test
    void testAddItem2() {
        ScannedItem newscScannedItem = new ScannedItem(item2, 10);
        int excpectedsize = regItems.getItems().size();
        regItems.addItem(newscScannedItem);
        int actualsize = regItems.getItems().size();
        assertEquals(excpectedsize, actualsize,  "wrong"+Arrays.toString(regItems.getItems().toArray())+);
        
    }
}
