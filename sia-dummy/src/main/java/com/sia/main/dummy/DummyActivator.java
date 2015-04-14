package com.sia.main.dummy;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import com.sia.main.dummy.services.DummyService;
import com.sia.main.dummy.services.impl.DummyServiceImpl;

public class DummyActivator implements BundleActivator {

	private ServiceRegistration registration;
	
	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("dummy activated");
		registration = context.registerService(DummyService.class.getName(), new DummyServiceImpl(), null);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		
	}
	
	
}
