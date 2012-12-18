package com.lucas4it.googleguicetutorial;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.lucas4it.googleguicetutorial.buiness.BusinessInterface;
import com.lucas4it.googleguicetutorial.module.BusinessInterfaceModule;
import com.lucas4it.googleguicetutorial.module.BusinessInterfaceModuleAlternative;

/**
 * @author lfilipkiewicz
 * 
 * Tutorials links:
 * http://4programmers.net/Java/Guice
 * http://4programmers.net/Java/Guice/Metody_wstrzykiwania_zale%C5%BCno%C5%9Bci
 * 
 * 
 */
public class Main {
    
    @Inject
    private BusinessInterface businessInterface;
    
    
    public void callBusinessInterface() {
        businessInterface.printMessage();
    }
    
    
    public static void main (String[] args) {
        Injector guiceInjector = Guice.createInjector(new BusinessInterfaceModule());
        Main main = guiceInjector.getInstance(Main.class);
        
        System.out.println("Checking Main default scope...");
        System.out.println("1st getInstance() : " + main.toString());
        
        main = guiceInjector.getInstance(Main.class);
        System.out.println("2st getInstance() : " + main.toString());
        
        System.out.println("Calling Main class...");
        main.callBusinessInterface();
        
        
        Injector guiceInjectorAlternative = Guice.createInjector(new BusinessInterfaceModuleAlternative());
        MainAlternative mainAlternative = guiceInjectorAlternative.getInstance(MainAlternative.class);
        
        System.out.println("Checking MainAlternative scope...");
        System.out.println("1st getInstance() : " + mainAlternative.toString());
        
        mainAlternative = guiceInjectorAlternative.getInstance(MainAlternative.class);
        System.out.println("2st getInstance() : " + mainAlternative.toString());
        
        System.out.println("Calling MainAlternative class...");
        mainAlternative.callBusinessInterface();
        
        
        
        Injector guiceInjectorViaSetter = Guice.createInjector(new BusinessInterfaceModule());
        MainInjectViaSetter mainInjectViaSetter = guiceInjectorViaSetter.getInstance(MainInjectViaSetter.class);
        
        System.out.println("Calling MainInjectViaSetter class...");
        mainInjectViaSetter.callBusinessInterface();
             
    }
    
    
    /**
     * Google Guice must have non-private default constructor.
     */
    public Main() {
        
    }
    
    public Main(String fake) {
        
    }
            
}
