package se.kth.iv1350.seminartask.integration;


public class RegistryCreator {
    ItemRegistry itemRegistry;
    AccountingRegistry accountingRegistry;

   /**
    * Creates an object instance responsible for registries
    * All registry objects are initated under instatiation of the class
    */
    public RegistryCreator() {
        this.itemRegistry = new ItemRegistry();
        this.accountingRegistry = new AccountingRegistry();
    }


/**
 * 
 * @return an item registry object 
 */
public ItemRegistry getRegistry() {
    return itemRegistry;
}

/**
 * 
 * @return an account registry object
 */
public AccountingRegistry getAccountingRegistry() {
    return accountingRegistry;
}
        
}
