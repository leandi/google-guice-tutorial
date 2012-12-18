package com.lucas4it.googleguicetutorial.module;

import com.google.inject.AbstractModule;
import com.lucas4it.googleguicetutorial.buiness.BusinessInterface;
import com.lucas4it.googleguicetutorial.buiness.BusinessInterfaceImplB;

/**
 *
 * @author lfilipkiewicz
 */
public class BusinessInterfaceModuleAlternative extends AbstractModule {
    
    /**
     * Default scope is set to Singleton within {@link MainAlternative }.
     */
    @Override
    protected void configure() {
        bind(BusinessInterface.class).to(BusinessInterfaceImplB.class);
    }
    
}
