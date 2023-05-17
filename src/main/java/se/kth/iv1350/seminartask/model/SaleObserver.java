package se.kth.iv1350.seminartask.model;

/**
 * A listener interface for recieving notifications about 
 * processed sales. The classes that need such notifications 
 * implement this interface and the intances of such objects 
 * are registered to with 
 * When a sale is processed that objects {@link #newSale()} method is invoked.
 * 
 */

 // TODO ADD addSaleObserver method to controller to so view can add observers
public interface SaleObserver {
    void newSale(SaleLog log);
}
