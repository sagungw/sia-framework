package com.sia.main.plugin;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class PluginBundleActivator implements BundleActivator {

	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("Plugin Bundle Activated");
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("Plugin Bundle Deactivated");
	}

}
