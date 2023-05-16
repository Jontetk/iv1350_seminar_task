package se.kth.iv1350.seminartask.integration;
/**
 * 
 * Exception for when an id was not found
 */
public class IdNotFoundException extends Exception{
    /**
     * Exception for when a requested id was not found in a database
     * @param message The error message
     */
    IdNotFoundException(String message) {
        super(message);
    }

}
