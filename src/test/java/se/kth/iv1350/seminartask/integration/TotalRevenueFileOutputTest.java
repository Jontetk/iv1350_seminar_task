package se.kth.iv1350.seminartask.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import se.kth.iv1350.seminartask.util.Cash;

public class TotalRevenueFileOutputTest {
    private ByteArrayOutputStream outContent;
    private PrintWriter originalRevenueStream;
    private TotalRevenueFileOutput totalRevenueFileOutput = new TotalRevenueFileOutput();
    private double total = 0;
    private int saleNum = 0;



    @BeforeEach
    public void setUpStreams() {

        originalRevenueStream = totalRevenueFileOutput.getRevenueStream();
        outContent = new ByteArrayOutputStream();
        totalRevenueFileOutput.setRevenueStream(new PrintWriter(outContent));
    }
    @AfterEach
    public void cleanUpStrams() {
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
        assertTrue(expected.contains(result), "incorrect printout");
        }
    }

        