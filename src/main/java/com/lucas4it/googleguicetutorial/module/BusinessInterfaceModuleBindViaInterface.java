/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucas4it.googleguicetutorial.module;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import com.lucas4it.googleguicetutorial.buiness.BusinessInterface;
import com.lucas4it.googleguicetutorial.buiness.BusinessInterfaceA;
import com.lucas4it.googleguicetutorial.buiness.BusinessInterfaceB;
import com.lucas4it.googleguicetutorial.buiness.BusinessInterfaceImplA;
import com.lucas4it.googleguicetutorial.buiness.BusinessInterfaceImplB;

/**
 *
 * @author lfilipkiewicz
 */
public class BusinessInterfaceModuleBindViaInterface extends AbstractModule {

    @Override
    protected void configure() {
        bind(BusinessInterface.class).annotatedWith(BusinessInterfaceA.class).to(BusinessInterfaceImplA.class);
        bind(BusinessInterface.class).annotatedWith(BusinessInterfaceB.class).to(BusinessInterfaceImplB.class);
        
        bind(BusinessInterface.class).annotatedWith(Names.named("A")).to(BusinessInterfaceImplA.class);
        bind(BusinessInterface.class).annotatedWith(Names.named("B")).to(BusinessInterfaceImplB.class);
    }
    
}
