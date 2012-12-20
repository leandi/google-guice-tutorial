package com.lucas4it.googleguicetutorial;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.lucas4it.googleguicetutorial.buiness.BusinessInterface;
import com.lucas4it.googleguicetutorial.module.BusinessInterfaceModule;
import com.lucas4it.googleguicetutorial.module.BusinessInterfaceModuleAlternative;
import com.lucas4it.googleguicetutorial.module.BusinessInterfaceModuleBindViaInterface;

/**
 * @author lfilipkiewicz
 * 
 * Tutorials links:
 * http://4programmers.net/Java/Guice
 * http://4programmers.net/Java/Guice/Metody_wstrzykiwania_zale%C5%BCno%C5%9Bci
 * http://www.espeo.pl/2009/08/18/google-guice-dependency-injection-framework
 * http://www.ibm.com/developerworks/java/library/j-guice/index.html
 * 
 */
public class Main {

    @Inject
    private BusinessInterface businessInterface;
    
    
    public void callBusinessInterface() {
        businessInterface.printMessage();
    }
    
    
    public static void main (String[] args) {
        testGuiceInjectorNoScope();
        testGuiceInjectorDefaultSingletonAnnotation();
        testGuiceInjectorViaSetter();
        testGuiceInjectorViaBindingAnnotation();
        testGuiceInjectorViaNamedAnnotation();
    }
    

    private static void testGuiceInjectorViaNamedAnnotation() {
        Injector guiceInjectorViaNamedAnnotation = Guice.createInjector(new BusinessInterfaceModuleBindViaInterface());
        MainInjectViaNamedAnnotation mainInjectViaNamedAnnotation = guiceInjectorViaNamedAnnotation.getInstance(MainInjectViaNamedAnnotation.class);
        
        System.out.println("Calling MainInjectViaNamedAnnotation class...");
        mainInjectViaNamedAnnotation.callBusinessInterface();
    }
    
    
    private static void testGuiceInjectorViaBindingAnnotation() {
        Injector guiceInjectorViaBindingAnnotation = Guice.createInjector(new BusinessInterfaceModuleBindViaInterface());
        MainInjectViaBindingAnnotation mainInjectViaBindingAnnotation = guiceInjectorViaBindingAnnotation.getInstance(MainInjectViaBindingAnnotation.class);
        
        System.out.println("Calling MainInjectViaBindingAnnotation class...");
        mainInjectViaBindingAnnotation.callBusinessInterface();
    }
    
    private static void testGuiceInjectorViaSetter() {
        Injector guiceInjectorViaSetter = Guice.createInjector(new BusinessInterfaceModule());
        MainInjectViaSetter mainInjectViaSetter = guiceInjectorViaSetter.getInstance(MainInjectViaSetter.class);
        
        System.out.println("Calling MainInjectViaSetter class...");
        mainInjectViaSetter.callBusinessInterface();
    }
    
       private static void testGuiceInjectorDefaultSingletonAnnotation() {
        Injector guiceInjectorAlternative = Guice.createInjector(new BusinessInterfaceModuleAlternative());
        MainAlternative mainAlternative = guiceInjectorAlternative.getInstance(MainAlternative.class);
        
        System.out.println("Checking MainAlternative scope...");
        System.out.println("1st getInstance() : " + mainAlternative.toString());
        
        mainAlternative = guiceInjectorAlternative.getInstance(MainAlternative.class);
        System.out.println("2st getInstance() : " + mainAlternative.toString());
        
        System.out.println("Calling MainAlternative class...");
        mainAlternative.callBusinessInterface();
    }

    private static void testGuiceInjectorNoScope() {
        Injector guiceInjector = Guice.createInjector(new BusinessInterfaceModule());
        Main main = guiceInjector.getInstance(Main.class);
        
        System.out.println("Checking Main default scope...");
        System.out.println("1st getInstance() : " + main.toString());
        
        main = guiceInjector.getInstance(Main.class);
        System.out.println("2st getInstance() : " + main.toString());
        
        System.out.println("Calling Main class...");
        main.callBusinessInterface();
    }
    
    /**
     * Google Guice must have non-private default constructor.
     */
    public Main() {
        
    }
    
    public Main(String fake) {
        
    }
            
}
