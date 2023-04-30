package se.kth.iv1350.seminartask.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.nio.channels.SelectableChannel;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import se.kth.iv1350.seminartask.integration.ItemRegistry;
import se.kth.iv1350.seminartask.integration.RegistryCreator;
import se.kth.iv1350.seminartask.model.RegisteredItems;
import se.kth.iv1350.seminartask.model.ScannedItem;
import se.kth.iv1350.seminartask.util.*;


public class ControllerTest {
    RegistryCreator registryCreator = new RegistryCreator();

    Controller controller = new Controller(registryCreator, null);
     
    @BeforeEach
    void setup() {
        controller.startSale();
    }    
   
    @ParameterizedTest 
    @ValueSource(ints = {1,2,3,4})
    void testSelectItemValidIds(int id) { 
        
        int expectedId = id;
        int actualId =  controller.selectItem(id).getItemID();
        assertEquals(expectedId, actualId, "Ids should be the same");
    

    }


    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 7, 10})
    void testSelectItemInvalidIds(int id) {
        assertNull(controller.selectItem(id),"invalid item fetched");

    }

    @Test
    void testAmountPaid() {
        controller.selectItem(1, 1); //15 dollars per unit
        controller.selectItem(4)

    }

    @Test
    void testGetTotal() {
        
    }


}