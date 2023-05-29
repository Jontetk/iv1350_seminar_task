package se.kth.iv1350.seminartask.integration;


import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;

import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import se.kth.iv1350.seminartask.model.RegisteredItems;
import se.kth.iv1350.seminartask.model.SaleLog;
import se.kth.iv1350.seminartask.util.Cash;
import se.kth.iv1350.seminartask.util.ItemDTO;

public class PrinterTest {
    
    private ByteArrayOutputStream outContent;
    private Printer printer;

    @BeforeEach
    void setUpStreams() {
        try {
            printer = new Printer();
            
            outContent = new ByteArrayOutputStream();
            printer.setCurrentPrintStream(new PrintStream(outContent));
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
       

    @AfterEach
    void CleanUpStreams() {
        outContent = null;
        printer.setCurrentPrintStream(System.out);
    }

    @Test
    void testPrintReceipt() {
        LocalDate currenTime = LocalDate.now();
        // String formattedDateString = currenTime.format(DateTimeFormatter.ISO_DATE);
        String formattedDateString =  currenTime.getYear() + "-" + currenTime.getMonthValue() +"-"+currenTime.getDayOfMonth();
        

        ItemDTO testItem1 = new ItemDTO(15, "testItem", new Cash(14.15, "I$"), 0.1, 15);
        int testItem1amount = 4;
        ItemDTO testItem2 = new ItemDTO(17, "otherTestItem", new Cash(20.20, "I$"), 0.16, 15);
        int testItem2amount = 10;
        RegisteredItems registeredItems = new RegisteredItems();
        registeredItems.addItem(testItem1, testItem1amount);
        registeredItems.addItem(testItem2, testItem2amount);
        registeredItems.addTotalDiscount(new Cash(50.10, "I$"));
        Cash change = new Cash(1000.10, "I$");

        String discounts ="Discount1,";

        SaleLog sale = new SaleLog();
        sale.saveRegistredItems(registeredItems);
        sale.saveChange(change);
        sale.addAppliedDiscount(discounts);
        sale.saveCurrentDate();
        
        
           try {
            printer.printReceipt(sale);
           } catch (Exception e) {
            fail("Couldnt print receipt", e);
           }
        
        String result = outContent.toString();
        double testitem1price = testItem1.getPrice().getAmount() *testItem1amount;
        String expectedMessageForTestItem1 = testItem1.getDescription()+" x " + testItem1amount+" "+ testitem1price+"I$";
        
        double testitem2price = testItem2.getPrice().getAmount() *testItem2amount;
        String expectedMessageForTestItem2 = testItem2.getDescription()+" x " + testItem2amount+" "+ testitem2price+"I$";

        assertTrue(result.contains(expectedMessageForTestItem1), "Message for the first item is invalid");
        assertTrue(result.contains(expectedMessageForTestItem1), "Message for the second item is invalid");

        assertTrue(result.contains(discounts), "DiscountMessage");

        // assertTrue(result.contains(formattedDateString+"  "), "Expected "+formattedDateString);
           

        
        
        
    



    


    }
}
