package com.sia.main.web.osgi;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.sia.main.plugin.modul.Module;
import com.sia.main.web.ModuleManager;

public class WebBundleActivator implements BundleActivator {
	
	@Override
	public void start(final BundleContext context) throws Exception {
		System.out.println("SIA Web Bundle Activated");
		final ModuleManager moduleManager = ModuleManager.getInstance();
		new Thread() {
			@Override
			public void run() {
				ModuleServiceLocator serviceLocator = new ModuleServiceLocator(context);
				Module module = serviceLocator.getModuleService(0);
				System.out.println(module.getModuleName());
				moduleManager.addModule(module);
				System.out.println("sia web bundle: module resources found: " + module.getViewResources().length);
			}
		}.start();
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("SIA Web Bundle Deactivated");
	}

}
