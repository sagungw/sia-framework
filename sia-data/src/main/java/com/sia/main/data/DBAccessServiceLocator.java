package com.sia.main.data;

import javax.naming.ServiceUnavailableException;

import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

import com.sia.main.plugin.persistence.HibernateConfiguration;

public class DBAccessServiceLocator {
	
	private ServiceTracker serviceTracker;

	public DBAccessServiceLocator(BundleContext context) {
		this.serviceTracker = new ServiceTracker(context, HibernateConfiguration.class.getName(), null);
		serviceTracker.open();
	}
	
	public HibernateConfiguration getDBAccessService(long timeout) throws ServiceUnavailableException {
		HibernateConfiguration hibernateConfiguration = null;
		try {
			hibernateConfiguration = HibernateConfiguration.class.cast(timeout == -1 ? serviceTracker.getService() : serviceTracker.waitForService(timeout));
		} catch(InterruptedException ie) {
			throw new RuntimeException(ie);
		}
		if(hibernateConfiguration == null) {
			throw new ServiceUnavailableException();
		}
		serviceTracker.close();
		return hibernateConfiguration;
	}
	
}
