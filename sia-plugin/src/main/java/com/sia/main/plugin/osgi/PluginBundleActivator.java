package com.sia.main.plugin.osgi;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.sia.main.plugin.ModuleServiceManager;
import com.sia.main.plugin.modul.Module;

public class PluginBundleActivator implements BundleActivator {

	@Override
	public void start(final BundleContext context) throws Exception {
		System.out.println("SIA Plugin Bundle Activated");
		final ModuleServiceManager moduleServiceManager = ModuleServiceManager.getInstance();
		new Thread() {
			@Override
			public void run() {
				ModuleServiceLocator serviceLocator = new ModuleServiceLocator(context);
				Module module = serviceLocator.getModuleService(0);
				System.out.println("plugin bundle service locator: " + module.getModuleName());
				moduleServiceManager.addModule(module);
				System.out.println("plugin bundle: module resources found: " + module.getViewResources().length);
			}
		}.start();
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("SIA Plugin Bundle Deactivated");
	}

}
