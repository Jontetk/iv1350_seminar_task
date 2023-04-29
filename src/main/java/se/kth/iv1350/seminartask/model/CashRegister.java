package se.kth.iv1350.seminartask.model;
import se.kth.iv1350.seminartask.util.*;



public class CashRegister {
    
private Cash cashInRegister;
    


    /**
    * Keeps track of the cash in the register and calculates the change
    * @param cashInRegister The cash that should be in the register from the start
    */
    public CashRegister(Cash cashInRegister) {
        this.cashInRegister = cashInRegister;
	
    }


    /**
    * Adds the paid amount to the <code>CashRegister</code> and returns the change that should be given to the customer
    * @param paidAmount The amount the customer paid
    * @param totalPrice The price of the total sale
    * @return The change that the customer should get back. 
    */
    public Cash addPayment(Cash paidAmount,Cash totalPrice) { 
        if (paidAmount.getCurrency() != totalPrice.getCurrency()){
            return null;
    }
        double currentInReg = this.cashInRegister.getAmount();
        this.cashInRegister.saveAmount(currentInReg+totalPrice.getAmount());
        if (paidAmount.getAmount()-totalPrice.getAmount() < 0) 
            return null;
        else
            return new Cash(paidAmount.getAmount()-totalPrice.getAmount(),totalPrice.getCurrency());
		
	}
        /**
        * 
        * @return The cash in the register
        */
        public Cash getCashInRegister() {
            return cashInRegister;
        }
}
