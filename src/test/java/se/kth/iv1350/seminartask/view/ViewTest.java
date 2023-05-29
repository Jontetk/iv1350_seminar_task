package se.kth.iv1350.seminartask.view;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.util.Scanner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.seminartask.integration.*;
import se.kth.iv1350.seminartask.controller.*;



public class ViewTest {
    private ByteArrayOutputStream outContent;
    private PrintStream originalSysOut;
    private InputStream originalSysIn;
    private ByteArrayInputStream inContent;
    RegistryCreator registryCreator;
    Printer printer;
    Controller controller;
    Scanner scanner;

    @BeforeEach 
    void setUpStreams() {
        originalSysIn = System.in;
        originalSysOut = System.out;
        outContent = new ByteArrayOutputStream();
        String inString ="-1 1 y 7 4 y 5 1 n 1 10 80 n";

        inContent = new ByteArrayInputStream(inString.getBytes());
        System.setIn(inContent);
        System.setOut(new PrintStream(outContent));
        registryCreator = new RegistryCreator();
        try {
        printer = new Printer();
        controller = new Controller(registryCreator, printer);
        } catch(IOException e) {}
        scanner = new Scanner(System.in);
    }
    @AfterEach
    void cleanUpStreams() {
        outContent = null;
        System.setOut(originalSysOut);
        inContent = null;
        System.setIn(originalSysIn);
    }

    
    
    @Test
    void testView() throws IOException{
        View view = new View(controller,scanner);
        String expected = "Item id:\nAmount:\nThe current items are:\n\r\nThe last item was invalid please try again\n\r\nWant to keep scanning? [y/n]:\nItem id:\nAmount:\nThe current items are:\n\r\nLast scanned item:\r\nMilk x 4\n\r\nWant to keep scanning? [y/n]:\nItem id:\nAmount:\nThe current items are:\n\r\nMilk x 4\n\r\nLast scanned item:\r\nCookie x 1\n\r\nWant to keep scanning? [y/n]:Enter customerID :\r\n\nTotal price to pay:78.25I$\r\nPayment:\nThat is not enoguh. Total price to pay:78.25I$\r\nPayment:Change:1.75I$\n\r\nTotalRevenue: 78,250 \n\nMilk x 4 60.0I$\r\nUnit price: 15.0I$ VAT Price: 18.0I$\r\n\r\nCookie x 1 25.0I$\r\nUnit price: 25.0I$ VAT Price: 5.25I$\r\n\r\nApplied discounts: 50% off all milk\r\nTotal Discount: 30.0\r\nTotal VAT: 23.25\r\nTotal with VAT and discount: 78.25\r\nChange: 1.75";
        String scanAgainExpected = "Want to scan again? [y/n]";
        String result = outContent.toString();
        assertTrue(result.contains(expected),"Incorrect printout");
        assertTrue(result.contains(scanAgainExpected),"Incorrect printout");
    }
}
