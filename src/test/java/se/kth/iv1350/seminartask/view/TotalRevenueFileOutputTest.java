package se.kth.iv1350.seminartask.view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import se.kth.iv1350.seminartask.util.Cash;
import se.kth.iv1350.seminartask.view.TotalRevenueFileOutput;

public class TotalRevenueFileOutputTest {
    private StringWriter outContent;
    private PrintWriter originalRevenueStream;
    private TotalRevenueFileOutput totalRevenueFileOutput = new TotalRevenueFileOutput();
    private double total = 0;
    private int saleNum = 0;



    @BeforeEach
    void setUpStreams() {

        originalRevenueStream = totalRevenueFileOutput.getRevenueStream();
        outContent = new StringWriter();
        totalRevenueFileOutput.setRevenueStream(new PrintWriter(outContent));
    }
    @AfterEach
    void cleanUpStrams() {
        outContent = null;
        totalRevenueFileOutput.setRevenueStream(originalRevenueStream);
    }

    
    @ParameterizedTest
    @ValueSource(doubles = {10,20,30,40})
    void testNewSale(double amount) {
        total += amount;
        saleNum++;
        Cash paid = new Cash(amount,"I$");
        totalRevenueFileOutput.newSale(paid);
        String result = outContent.toString();
        String expected = "Total after sale"+saleNum+": "+total;
        assertTrue(result.contains(expected), "Incorrect printout");
        }
    }

        