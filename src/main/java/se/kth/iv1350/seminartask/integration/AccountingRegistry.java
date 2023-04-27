package se.kth.iv1350.seminartask.integration;
import se.kth.iv1350.seminartask.model.*;
public class AccountingRegistry {
	SaleLog currentSaleLog;

	/**
	 * Saves the sale log for each sale to an external database
	 * 
	 * 
	 */
    AccountingRegistry() {

	}
	/**
	 * Saves the <code>SaleLog</code> for the current sale to the accounting database
	 * 
	 * @param currentSaleLog The <code>SaleLog</code> that should be saved in the <code>AccountRegistry</code>
	 */
	public void saveSaleLog(SaleLog currentSaleLog) {
		this.currentSaleLog = currentSaleLog;
	}
}
