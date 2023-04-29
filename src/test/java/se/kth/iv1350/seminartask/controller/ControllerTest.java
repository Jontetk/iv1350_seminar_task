package se.kth.iv1350.seminartask.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import se.kth.iv1350.seminartask.integration.RegistryCreator;

/*TODO FIX THIS TEST STUFF */
public class ControllerTest {
    RegistryCreator registryCreator = new RegistryCreator();

    Controller controller = new Controller(registryCreator, null);
     
       
    /*
    @ParameterizedTest 
    @ValueSource(ints = {1,2,3,4})
    */
    @Test
    void testSelectItem() { 
       int expectedId = 4;
       int actualId =  controller.selectItem(4).getItemID();
       assertEquals(expectedId, actualId, "Ids should be the same");
    

    }
}
