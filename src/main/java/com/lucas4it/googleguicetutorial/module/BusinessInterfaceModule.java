package com.lucas4it.googleguicetutorial.module;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.lucas4it.googleguicetutorial.buiness.BusinessInterface;
import com.lucas4it.googleguicetutorial.buiness.BusinessInterfaceImplA;

/**
 *
 * @author lfilipkiewicz
 */
public class BusinessInterfaceModule extends AbstractModule {
    
    /**
     * Default scope is NO_SCOPE (new instance injected each time).
     */
    @Override
    protected void configure() {
        bind(BusinessInterface.class).to(BusinessInterfaceImplA.class);
    }
    
}
