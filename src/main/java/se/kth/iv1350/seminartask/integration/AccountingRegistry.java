package se.kth.iv1350.seminartask.integration;
import se.kth.iv1350.seminartask.model.*;

	/**
	 * Saves the sale log for each sale to an external database
	 * 
	 * 
	 */
public class AccountingRegistry {
	SaleLog currentSaleLog;
	private boolean dataBaseAvailable = true;

	private static final AccountingRegistry ACCOUNTING_REGISTRY = new AccountingRegistry(); 
	

	/**
	 * 
	 * @return the only instance of this singleton.
	 */
    public static AccountingRegistry getAccountingRegistry() {
		return ACCOUNTING_REGISTRY;
	}
	
	private AccountingRegistry(){

	}
	/**
     * Simulates the availibility for the database
     * @param condition The availability of the database
     */
	public void setAvailability(boolean condition){
        this.dataBaseAvailable = condition;
	}
	/**
	 * Saves the <code>SaleLog</code> for the current sale to the accounting database
	 * 
	 * @param currentSaleLog The <code>SaleLog</code> that should be saved in the <code>AccountRegistry</code>
	 * @throws AccountingRegistryException if an errror occured in the registry
	 * 
	 */
	public void saveSaleLog(SaleLog currentSaleLog) throws AccountingRegistryException{
		if (this.dataBaseAvailable == false) 
			throw new AccountingRegistryException("Registery Not running");
		this.currentSaleLog = currentSaleLog;
	}
}
