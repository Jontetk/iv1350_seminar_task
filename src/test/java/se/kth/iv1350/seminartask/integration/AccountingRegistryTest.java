package se.kth.iv1350.seminartask.integration;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import se.kth.iv1350.seminartask.model.SaleLog;

public class AccountingRegistryTest {
    AccountingRegistry accReg = AccountingRegistry.getAccountingRegistry();
    @Test
    void testSaveSaleLogWithUnavalibleRegistry() {
        SaleLog saleLog = new SaleLog();
        accReg.setAvailability(false);
        try{
            accReg.saveSaleLog(saleLog);
            fail("Successfully saved saleLog with unavailible registry");
        } catch (Exception e) {
            accReg.setAvailability(true);
        }
    }
}
