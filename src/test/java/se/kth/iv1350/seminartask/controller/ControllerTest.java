package se.kth.iv1350.seminartask.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import se.kth.iv1350.seminartask.integration.RegistryCreator;


public class ControllerTest {

    private Controller controller;
    
    

    RegistryCreator registryCreator = new RegistryCreator();


    @BeforeEach
    void setUp() {
        controller = new Controller(registryCreator, null);
        controller.startSale();
    }
       
   
    @ParameterizedTest 
    @ValueSource(ints = {1,2,3,4})
    void testSelectItem(int id) { 
        controller.startSale();
        int expectedId = id;
        int actualId =  controller.selectItem(id).getItemID();
        assertEquals(expectedId, actualId, "Ids should be the same");
    

    }
}
