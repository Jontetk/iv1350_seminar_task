package se.kth.iv1350.seminartask.model;


import se.kth.iv1350.seminartask.util.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;



class RegisteredItemsTest {
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
        item1 = new ItemDTO(1, null, new Cash(10, "I$"), 0.1,1);
        item2 = new ItemDTO(2, null, new Cash(20, "I$"), 0.2,1);
        item3 = new ItemDTO(3, null, new Cash(30, "I$"), 0.3,1);
        item4 = new ItemDTO(4, null, new Cash(40, "I$"), 0.4,1);

        scanneditem1 = new ScannedItem(item1, 2);
        scanneditem2 = new ScannedItem(item2, 5);
        scanneditem3 = new ScannedItem(item3, 1);
        scanneditem4 = new ScannedItem(item4, 7);
        regItems = new RegisteredItems();
        regItems.addItem(item1,2);
        regItems.addItem(item2,5);
        regItems.addItem(item3,1);
        regItems.addItem(item4,7);

       
    }
    @Test
    void testCreatingRegestredItem() {
        RegisteredItems newRegItems = new RegisteredItems();
        Cash currentCash = new Cash(40, "I$");
        ItemDTO newItem = new ItemDTO(5, null,currentCash, 0.4,1);
        newRegItems.addItem(newItem, 1);

        assertEquals(newRegItems.getItems().get(0).getItem(), newItem, "The Item was not added correctly");


    }
    @Test
    void testAddNewItemContainsNewItem() {
        ItemDTO newItem = new ItemDTO(5, null, new Cash(40, "I$"), 0.4,1);
        ScannedItem newScannedItem = new ScannedItem(newItem, 1);
        regItems.addItem(newItem, 1);
        assertTrue(regItems.getItems().contains(newScannedItem),"The item was not added correctly");
    }
    @Test
    void testAddNewItemCorrectVatAndPrice() {
        ItemDTO newItem = new ItemDTO(5, null, new Cash(40, "I$"), 0.4,1);
        regItems.addItem(newItem, 1);
        double excpectedcashamount = 470;
        double excpectedvatamount = 159;
        assertEquals(excpectedcashamount, regItems.getTotalPrice().getAmount(), "Total price does not match excpected");
        assertEquals(excpectedvatamount, regItems.getTotalVAT().getAmount(), "Total vat does not match excpected");
    }
    @Test
    void testAddItemAlreadyExistCorrectArraySize() {
        int excpectedsize = 4;
        regItems.addItem(item2, 10);
        int actualsize = regItems.getItems().size();
        assertEquals(excpectedsize, actualsize,  "Array size should not increase");
        
    
    }
    @Test
    void testAddItemAlreadyExistCorrectAmount() {
        ScannedItem newScannedItem = new ScannedItem(item2, 10);
        int excpectedAmount = 5+10;
        regItems.addItem(item2, 10);

        int indexItem2 = regItems.getItems().indexOf(newScannedItem);  
        int actualAmount = regItems.getItems().get(indexItem2).getAmount();
        assertEquals(excpectedAmount, actualAmount, "Amounts after item adding is not correct");

    }

}
