package se.kth.iv1350.seminartask.integration;

/**
 * 
 * Responsible for creating all the registries and returning them with gettters
 */
public class RegistryCreator {
    ItemRegistry itemRegistry;
    AccountingRegistry accountingRegistry;
    DiscountRegistry discountRegistry;

   /**
    * Creates an object instance responsible for registries
    * All registry objects are initated under instatiation of the class
    */
    public RegistryCreator() {
        this.itemRegistry = ItemRegistry.getItemRegistry();
        this.accountingRegistry = AccountingRegistry.getAccountingRegistry();
        this.discountRegistry = DiscountRegistry.getDiscountRegistry();
    }


/**
 * Gets an {@link se.kth.iv1350.seminartask.integration.ItemRegistry ItemRegistry} for later searching for items
 * @return {@link se.kth.iv1350.seminartask.integration.ItemRegistry ItemRegistry} object 
 */
public ItemRegistry getItemRegistry() {
    return itemRegistry;
}

/**
 * Gets an {@link se.kth.iv1350.seminartask.integration.AccountingRegistry AccountingRegistry} for saving the {@link se.kth.iv1350.seminartask.model.SaleLog SaleLog}
 * @return {@link se.kth.iv1350.seminartask.integration.AccountingRegistry AccountingRegistry} object
 */
public AccountingRegistry getAccountingRegistry() {
    return accountingRegistry;
}


/**
 * @return an {@link se.kth.iv1350.seminartask.integration.DiscountRegistry} object.  
 */
public DiscountRegistry getDiscountRegistry(){
    return discountRegistry;
}

        
}
