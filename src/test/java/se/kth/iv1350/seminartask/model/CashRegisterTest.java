package se.kth.iv1350.seminartask.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.seminartask.util.*;

public class CashRegisterTest {
    private CashRegister register;
    @BeforeEach
    void setup(){
        register = new CashRegister(new Cash(1000,"I$")); 
    }

    
    @Test
    void testAddingPaymentTotal() {
        
        register.addPayment(new Cash(25,"I$"), new Cash(10,"I$"));
        double excpectedTotal = 1010;
        double actualTotal = register.getCashInRegister().getAmount();
        assertEquals(excpectedTotal, actualTotal,"Wrong total after adding payment");
    }
    @Test
    void testWrongCurrency() {
        
        assertNull(register.addPayment(new Cash(25,"I€"), new Cash(10,"I$")), "Wrong currency was not detected");
    }
    @Test 
    void testChangeReturn() {
        double excpectedChange = 15;
        double actualChange = register.addPayment(new Cash(25,"I$"), new Cash(10,"I$")).getAmount();
        assertEquals(excpectedChange, actualChange, "Change was not the value it should have been");
        
    }

    @Test 
    void voidtestAddPaymentInsufficientPaymentForTotalPrice(){
        double excpectedChange = 0;
        double actualChange = register.addPayment(new Cash(10, "I$"), new Cash(30, "I$")).getAmount();
        assertEquals(excpectedChange, actualChange,"What?");
    }
    
}
