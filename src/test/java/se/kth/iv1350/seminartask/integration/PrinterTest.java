package se.kth.iv1350.seminartask.integration;


import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javafx.util.converter.LocalDateStringConverter;
import se.kth.iv1350.seminartask.model.RegisteredItems;
import se.kth.iv1350.seminartask.model.SaleLog;
import se.kth.iv1350.seminartask.util.Cash;
import se.kth.iv1350.seminartask.util.ItemDTO;

public class PrinterTest {
    private ByteArrayOutputStream outContent;
    private PrintStream originalSystemOut;

    @BeforeEach
    void setUpStreams() {
        originalSystemOut = System.out;
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(originalSystemOut));
    }

    @AfterEach
    void CleanUpStreams() {
        outContent = null;
        System.setOut(originalSystemOut);
    }

    @Test
    void testPrintReceipt() {
        LocalDateTime time = LocalDateTime.of(2020, 6, 4, 12, 35, 10);
        ItemDTO testItem = new ItemDTO(15, "testItem", new Cash(14.15, "I$"), 0.1, 15);
        int testItemamount = 4;
        ItemDTO testItem2 = new ItemDTO(17, "otherTestItem", new Cash(20.20, "I$"), 0.16, 15);
        int testItem2amount = 10;
        RegisteredItems registeredItems = new RegisteredItems();
        registeredItems.addItem(testItem, testItemamount);
        registeredItems.addItem(testItem2, testItem2amount);
        registeredItems.addTotalDiscount(new Cash(50.10, "I$"));
        Cash change = new Cash(1000.10, "I$");
        String discounts ="Discount1,";

        SaleLog sale = new SaleLog();
        sale.saveRegistredItems(registeredItems);
        sale.saveChange(change);
        sale.addAppliedDiscount(discounts);
        
        try {
            Printer printer = new Printer();
            printer.printReceipt(sale);
            String result = outContent.toString();
            

       

        } catch (Exception e) {
            fail("Could not instantiate printer object");
        }
        
        
    



    


    }
}
