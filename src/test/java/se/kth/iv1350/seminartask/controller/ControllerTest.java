package se.kth.iv1350.seminartask.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;



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
        
        int expectedId = id;
        int actualId =  controller.selectItem(id).getItemID();
        assertEquals(expectedId, actualId, "Ids should be the same");
    

    }


    @ParameterizedTest
    @ValueSource(ints = {-1, 0, -7, -10})
    void testSelectItemInvalidIds(int id) {
        assertNull(controller.selectItem(id),"invalid item fetched");

    }


    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6})
    void testAmountPaidForBigPayment(int id) {
        double paidAmount = Double.MAX_VALUE;
        controller.selectItem(id, 4); 
        double priceWithVAT = controller.getTotal().getAmount();

        double actualChangeAmount = controller.calculateChange(new Cash(paidAmount, "I$")).getAmount();
        double expectedChangeAmount = paidAmount-priceWithVAT;
        assertEquals(expectedChangeAmount, actualChangeAmount,"Wrong change amount");
    }

    
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6})

    void testAmountPaidForSmallPayment(int id) {
        double paidAmount = Double.MIN_VALUE;
        controller.selectItem(id, 4);
        controller.getTotal();
        Cash actualChangeAmount = controller.calculateChange(new Cash(paidAmount, "I$"));
        assertNull(actualChangeAmount,"Wrong change amount");
    }

}


