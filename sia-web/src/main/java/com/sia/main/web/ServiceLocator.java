package com.sia.main.web;

import javax.naming.ServiceUnavailableException;

import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

import com.sia.main.dummy.services.DummyService;

public class ServiceLocator {
	
	private ServiceTracker serviceTracker;

	public ServiceLocator(BundleContext context) {
		this.serviceTracker = new ServiceTracker(context, DummyService.class.getName(), null);
		serviceTracker.open();
	}
	
	public DummyService getService(long timeout) throws ServiceUnavailableException {
		DummyService dummyService = null;
		try {
			dummyService = DummyService.class.cast(timeout == -1 ? serviceTracker.getService() : serviceTracker.waitForService(timeout));
		} catch(InterruptedException ie) {
			throw new RuntimeException(ie);
		}
		if(dummyService == null) {
			throw new ServiceUnavailableException();
		}
		serviceTracker.close();
		return dummyService;
	}
	
}
