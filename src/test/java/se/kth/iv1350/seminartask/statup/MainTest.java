package se.kth.iv1350.seminartask.statup;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MainTest {
    private ByteArrayOutputStream outContent;
    private PrintStream originalSysOut;
    private InputStream originalSysIn;
    private ByteArrayInputStream inContent;

    @BeforeEach 
    void setUpStreams() {
        originalSysIn = System.in;
        originalSysOut = System.out;
        outContent = new ByteArrayOutputStream();
        String inString ="1 1 n 0 300000 n";

        inContent = new ByteArrayInputStream(inString.getBytes());
        System.setIn(inContent);
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
