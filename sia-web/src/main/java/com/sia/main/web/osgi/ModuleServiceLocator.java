package com.sia.main.web.osgi;

import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

import com.sia.main.plugin.modul.Module;
import com.sia.main.service.services.ModulService;

public class ModuleServiceLocator {
	
	private ServiceTracker serviceTracker;
	
	private boolean isOpen = false;
	
	public ModuleServiceLocator() {
	}
	
	public ModuleServiceLocator(BundleContext bundleContext) {
		this.serviceTracker = new ServiceTracker(bundleContext, Module.class.getName(), null);
//		this.serviceTracker = new ServiceTracker(bundleContext, ModulService.class.getName(), null);
		this.serviceTracker.open();
		this.isOpen = true;
	}
	
	public Module getModuleService(long timeout) {
		Module module = null;
		ModulService modulService = null;
		try {
			module = Module.class.cast(timeout == -1 ? this.serviceTracker.getService() : this.serviceTracker.waitForService(timeout));
			System.out.println(module.getModuleName());
//			modulService = ModulService.class.cast(timeout == -1 ? this.serviceTracker.getService() : this.serviceTracker.waitForService(timeout));
		} catch(Exception e) {
			e.printStackTrace();
		}
		return module;
	}
	
	public void close() {
		this.serviceTracker.close();
		this.isOpen = false;
	}

}
