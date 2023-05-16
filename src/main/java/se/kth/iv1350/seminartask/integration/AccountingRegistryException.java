package se.kth.iv1350.seminartask.integration;


/**
 * 
 * Exception that signals something is wrong with the {@link se.kth.iv1350.seminartask.integration.AccountingRegistry AccountingRegistry}
 *
 * 
 */
public class AccountingRegistryException extends RuntimeException{
    /**
     * Exception for errors with the {@link se.kth.iv1350.seminartask.integration.AccountingRegistry AccountingRegistry} 
     * @param message The error message
     */
    AccountingRegistryException(String message) {
        super(message);

    }

}
