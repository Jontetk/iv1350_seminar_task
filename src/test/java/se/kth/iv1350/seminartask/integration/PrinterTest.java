package se.kth.iv1350.seminartask.integration;


import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

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
        LocalDate currentDate = LocalDate.now();
        String formattedDateString = currentDate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
    
        
        LocalTime currentTime = LocalTime.now();
        String formattedTimeString = currentTime.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM));

        ItemDTO testItem1 = new ItemDTO(15, "testItem", new Cash(14.15, "I$"), 0.1, 15);
        int testItem1amount = 4;
        ItemDTO testItem2 = new ItemDTO(17, "otherTestItem", new Cash(20.20, "I$"), 0.16, 15);
        int testItem2amount = 10;
        RegisteredItems registeredItems = new RegisteredItems();
        registeredItems.addItem(testItem1, testItem1amount);
        registeredItems.addItem(testItem2, testItem2amount);
        Cash discount = new Cash(50.10, "I$");
        registeredItems.addTotalDiscount(discount);
        Cash change = new Cash(1000.10, "I$");

        String discountName ="Discount1,";

        SaleLog sale = new SaleLog();
        sale.saveRegistredItems(registeredItems);
        sale.addAppliedDiscount(discountName);
        sale.saveChange(change);
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
        assertTrue(result.contains(expectedMessageForTestItem2), "Message for the second item is invalid");
        double VATitem1 = testitem1price*testItem1.getVatRate();
        double VATitem2 = testitem2price*testItem2.getVatRate();
        double TotalVAT = VATitem1 + VATitem2;

        assertTrue(result.contains(testItem1.getPrice().getAmount()+"I$"+" VAT Price: "+VATitem1), "Incorrect unit price or VAT rate for item1 ");
        assertTrue(result.contains(testItem2.getPrice().getAmount()+"I$"+" VAT Price: "+VATitem2), "Incorrect unit price or VAT rate for item2");
        
        assertTrue(result.contains(discountName), "DiscountMessage");
        assertTrue(result.contains(discount.getAmount()+""), "Wrong discount amount");
        assertTrue(result.contains(TotalVAT+""), "Incorrect Total VAT");
        assertTrue(result.contains((testitem1price+testitem2price+TotalVAT-discount.getAmount())+""), "Incorrect Total price");

        assertTrue(result.contains(formattedDateString), "Wrong date or formatting");   
        assertTrue(result.contains(formattedTimeString), "Wrong time or format");
        assertTrue(result.contains(change.getAmount()+""), "Wrong change amount");
        

        
    



    


    }
}
