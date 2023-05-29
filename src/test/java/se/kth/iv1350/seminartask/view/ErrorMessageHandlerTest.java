package se.kth.iv1350.seminartask.view;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class ErrorMessageHandlerTest {
    private ByteArrayOutputStream outContent;
    private PrintStream originalSysOut;
    private ErrorMessageHandler errorMsg = new ErrorMessageHandler(); 

@BeforeEach
void setUpStreams() {
    
    originalSysOut = System.out;
    outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
}
@AfterEach
void CleanUpStreams() {
    outContent = null;
    System.setOut(originalSysOut);
}

@Test
void testErrorMesssageHandler(){
    
    try {
        throw new Exception("This is an exception message");
    } catch (Exception e) {
        errorMsg.showErrorMessage(e.getMessage());
        String  result = outContent.toString();

        assertTrue(result.contains("Error: "+e.getMessage()+" at Time"),"Error message text not correctly displayed" );
    }
}


}
