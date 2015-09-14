package com.sia.main.web.osgi;

import java.util.ArrayList;
import java.util.List;

import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class ServiceLocator<T> {
	
	private ServiceTracker serviceTracker;
	
	private Class<T> clazz;
	
	public ServiceLocator() {
	}
	
	public ServiceLocator(BundleContext bundleContext, Class<T> clazz) {
		this.clazz = clazz;
		this.serviceTracker = new ServiceTracker(bundleContext, this.clazz.getName(), null);
		this.serviceTracker.open();
	}
	
	public T getService(long timeout) {
		T service = null;
		try {
			service = this.clazz.cast(timeout == -1 ? this.serviceTracker.getService() : this.serviceTracker.waitForService(timeout));
		} catch(Exception e) {
			e.printStackTrace();
		}
		return service;
	}
	
	public List<T> getServices() {
		Object[] serviceObjects = this.serviceTracker.getServices();
		List<T> services = new ArrayList<T>();
		for(Object serviceObject: serviceObjects) {
			services.add(this.clazz.cast(serviceObject));
		}
		return services;
	}
	
	public void close() {
		this.serviceTracker.close();
	}

}
