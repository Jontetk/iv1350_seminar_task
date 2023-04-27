package se.kth.iv1350.seminartask.integration;

public class AccountingRegistry {
	SaleLog currentSaleLog

	/**
	 * Class that should save the sale log for each sale to an external database
	 * 
	 * 
	 */
    AccountingRegistry() {

	}
	/**
	 * 
	 * @param currentSaleLog The <code>SaleLog</code> that should be saved in the <code>AccountRegistry</code>
	 */
	public void saveSaleLog(SaleLog currentSaleLog) {
		this.currentSaleLog = currentSaleLog;
	}
}
