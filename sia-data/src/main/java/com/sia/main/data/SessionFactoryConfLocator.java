package com.sia.main.data;

import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

import com.sia.main.plugin.persistence.HibernateConfiguration;

public class SessionFactoryConfLocator {

	private ServiceTracker serviceTracker;

	public SessionFactoryConfLocator(BundleContext context) {
		serviceTracker = new ServiceTracker(context,
				HibernateConfiguration.class.getName(), null);
		serviceTracker.open();
	}

	public HibernateConfiguration getSessionFactoryConfiguration(long timeout)
			throws ServiceUnavailableException {
		HibernateConfiguration service = null;
		try {
			service = HibernateConfiguration.class
					.cast(timeout == -1 ? serviceTracker.getService()
							: serviceTracker.waitForService(timeout));
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		if (service == null)
			throw new ServiceUnavailableException();
		return service;
	}

	public void close() {
		serviceTracker.close();
	}

	public static class ServiceUnavailableException extends Exception {
	}

}
