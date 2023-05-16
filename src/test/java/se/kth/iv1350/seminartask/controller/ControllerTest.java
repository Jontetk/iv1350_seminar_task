package se.kth.iv1350.seminartask.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import se.kth.iv1350.seminartask.integration.RegistryCreator;
import se.kth.iv1350.seminartask.util.*;


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
    void testSelectItemValidIds(int id) { 
        int actualId = 0;

        int expectedId = id;
        try {
           actualId =  controller.selectItem(id).getItemID(); 
        } catch (Exception e) {}
        
        assertEquals(expectedId, actualId, "Ids should be the same");
    

    }


    @ParameterizedTest
    @ValueSource(ints = {-1, 0, -7, -10})
    void testSelectItemInvalidIds(int id) {
        try {
            assertNull(controller.selectItem(id),"invalid item fetched"); 
        } catch (Exception e) {}
        

    }


    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6})
    void testAmountPaidForBigPayment(int id) {
        double paidAmount = Double.MAX_VALUE;
        try {
            controller.selectItem(id, 4); 
        } catch (Exception e) {}
        
        double priceWithVAT = controller.getTotal().getAmount();

        double actualChangeAmount = controller.calculateChange(new Cash(paidAmount, "I$")).getAmount();
        double expectedChangeAmount = paidAmount-priceWithVAT;
        assertEquals(expectedChangeAmount, actualChangeAmount,"Wrong change amount");
    }

    




    // TODO CHANGE THIS TEST
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6})

    void testAmountPaidForSmallPayment(int id) {
        double paidAmount = Double.MIN_VALUE;
        try {
            controller.selectItem(id, 4);
            controller.calculateChange(new Cash(paidAmount, "I$"));
            fail("Successfully made the payment");
        } catch (Exception e) {
            
        }
        
       
    }

}


