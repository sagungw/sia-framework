package com.sia.main.web.osgi;

import java.util.List;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.sia.main.plugin.modul.Module;
import com.sia.main.web.ModuleManager;

public class WebBundleActivator implements BundleActivator {
	
	@Override
	public void start(final BundleContext context) throws Exception {
		final ModuleManager moduleManager = ModuleManager.getInstance();
		new Thread() {
			@Override
			public void run() {
				ServiceLocator<Module> serviceLocator = new ServiceLocator<Module>(context, Module.class);
				List<Module> modules = serviceLocator.getServices();
				System.out.println("MODULES FOUND : " + modules.size());
				for(Module module: modules) {
					moduleManager.addModule(module);
				}
			}
		}.start();
	}

	@Override
	public void stop(BundleContext context) throws Exception {
	}

}
