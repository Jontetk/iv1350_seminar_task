package se.kth.iv1350.seminartask.integration;


public class RegistryCreator {
    ItemRegistry registry;
    

   /**
    * Creates an object instance responsible for registries
    * All registry objects are initated under instatiation of the class
    */
    public RegistryCreator() {
        this.registry = new ItemRegistry();
        
    }

/*TODO MAKE BETTER COMMENT HERE 
        |
        V           */
/**
 * 
 * @return item regisry object 
 */
public ItemRegistry getRegistry() {
    return registry;
}
        
}
