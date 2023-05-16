package se.kth.iv1350.seminartask.integration;

/**
 * 
 * Exception for something that is wrong with the {@link se.kth.iv1350.seminartask.integration.ItemRegistry ItemRegistry}
 * 
 */

public class ItemRegistryException extends RuntimeException{
/**
 * Exception for errors within the {@link se.kth.iv1350.seminartask.integration.ItemRegistry ItemRegistry}
 * @param message The error message for the exception
 */
    ItemRegistryException(String message){
        super(message);
    }
}