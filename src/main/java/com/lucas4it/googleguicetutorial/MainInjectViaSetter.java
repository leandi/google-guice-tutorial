package com.lucas4it.googleguicetutorial;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.lucas4it.googleguicetutorial.buiness.BusinessInterface;

/**
 * @author lfilipkiewicz
 * 
 * @Singleton annotation is setting the default binding per {@link Injector}
 */
@Singleton
public class MainInjectViaSetter {
    
    private BusinessInterface businessInterface;

    public void callBusinessInterface() {
        businessInterface.printMessage();
    }
    
    
    public BusinessInterface getBusinessInterface() {
        return businessInterface;
    }

    /**
     * Method must have parameters, which can be injected. All injecting classes must be added to Guice configuration.
     * The method can return a value but there is no posibility to get this value.
     * There can be many methods with Inject annotation and setting the same field. All will be called.
     * 
     * @param businessInterface
     */
    @Inject
    public void setBusinessInterface(BusinessInterface businessInterface) {
        this.businessInterface = businessInterface;
    }

}
