package se.kth.iv1350.seminartask.view;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import se.kth.iv1350.seminartask.model.RegisteredItems;
import se.kth.iv1350.seminartask.model.SaleLog;
import se.kth.iv1350.seminartask.util.Cash;
import se.kth.iv1350.seminartask.util.ItemDTO;


public class TotalRevenueViewTest {
    private ByteArrayOutputStream outContent;
    private PrintStream originalSysOut;

@BeforeEach
public void setUpStreams() {
    originalSysOut = System.out;
    outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
}
@AfterEach
public void CleanUpStreams() {
    outContent = null;
    System.setOut(originalSysOut);
}


    
    @ParameterizedTest
    @ValueSource(doubles = {1, 100, java.lang.Math.PI,1.3333, 99.100001, Double.MAX_VALUE})
    public void testTotalRevenueView(){
        TotalRevenueView totalRevenueView = new TotalRevenueView();
        double revenueAmount = 100.31;
        Cash revenue = new Cash(revenueAmount, "I$"); 
        totalRevenueView.newSale(revenue);

        String result = outContent.toString();
        assertTrue(result.contains(String.format("%.3f", revenueAmount)), "Wrong revenue amount or format");





        

    }

}
