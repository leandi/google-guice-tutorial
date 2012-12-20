package com.lucas4it.googleguicetutorial;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import com.lucas4it.googleguicetutorial.buiness.BusinessInterface;
import com.lucas4it.googleguicetutorial.buiness.BusinessInterfaceB;

/**
 * @author lfilipkiewicz
 * 
 * @Singleton annotation is setting the default binding per {@link Injector}
 */
@Singleton
public class MainInjectViaBindingAnnotation {
    
    private BusinessInterface businessInterface;

    public void callBusinessInterface() {
        businessInterface.printMessage();
    }

    
    @Inject
    public MainInjectViaBindingAnnotation(@BusinessInterfaceB BusinessInterface businessInterface) {
        this.businessInterface = businessInterface;
    }

}
