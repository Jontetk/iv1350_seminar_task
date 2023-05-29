package se.kth.iv1350.seminartask.integration;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

    }
}
