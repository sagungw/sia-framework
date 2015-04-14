package com.sia.main.web;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.sia.main.dummy.services.DummyService;

public class WebBundleActivator implements BundleActivator {

	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("web activated");
		SomeGlobalClass.aGlobalVariable = getDummyService(context);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
	}
	
	public DummyService getDummyService(BundleContext context) {
		ServiceReference ref = context.getServiceReference(DummyService.class.getName());
		
		DummyService dummyService = (DummyService) context.getService(ref);
		return dummyService;
	}

}
