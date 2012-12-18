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
public class MainInjectViaConstructor {
    
    private BusinessInterface businessInterface;

    public void callBusinessInterface() {
        businessInterface.printMessage();
    }

    
    /**
     * Only one constructor can be marked with Inject annotation.
     * The constructor can have parameters only which are managed by Guice or marked with annotation @Assisted.
     * If the class has many constructors which should be used according to the needs they should be marked with @AssistedInject
     * 
     * Dependency Injection via constructor is creating ready-to-use object with all injected dependencies.
     * 
     * Dependency Injection with setter or annotated field gives the opportunity to get an object not fully initiated 
     * (between constructor call and a finish of injection).
     * 
     * @param businessInterface
     */
    @Inject
    public MainInjectViaConstructor(BusinessInterface businessInterface) {
        this.businessInterface = businessInterface;
    }
    
    
    
}
