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
public class MainAlternative {
    
    @Inject
    private BusinessInterface businessInterface;
    
    
    public void callBusinessInterface() {
        businessInterface.printMessage();
    }

}
