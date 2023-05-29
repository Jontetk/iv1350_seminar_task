package se.kth.iv1350.seminartask.statup;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MainTest {
    private ByteArrayOutputStream outContent;
    private PrintStream originalSysOut;


    @BeforeEach 
    void setUpStreams() {
       originalSysOut = System.out;
       outContent = new ByteArrayOutputStream();
       System.setOut(new PrintStream(outContent));
    }
    @AfterEach
    void cleanUpStreams() {
        outContent = null;
        System.setOut(originalSysOut);
    }

    
    @Test
    void testMain() throws IOException{
        String[] args = null;
        Main.main(args);
        String result = outContent.toString();
        String expected = "Item id:";
        assertTrue(result.contains(expected),"Incorrect main and view");
        
    }
}
