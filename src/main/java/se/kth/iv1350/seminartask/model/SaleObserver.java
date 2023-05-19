package se.kth.iv1350.seminartask.model;

/**
 * A listener interface for recieving notifications about 
 * processed sales. The classes that need such notifications 
 * implement this interface and the intances of such objects 
 * are registered to with {@link se.kth.iv1350.seminartask.controller.Controller#addSaleObserver(SaleObserver) addSaleObserver(SaleObserver)} 
 * When a sale is processed that objects {@link #newSale()} method is invoked.
 * 
 */

public interface SaleObserver {
    /**
     * Invoked when a new sale has been processed. 
     * 
     * @param log The log for the sale that has been processed.
     */
    void newSale(SaleLog log);
}
