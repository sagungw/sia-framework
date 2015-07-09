package com.sia.main.plugin.osgi;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class PluginBundleActivator implements BundleActivator {

	@Override
	public void start(final BundleContext context) throws Exception {
		System.out.println("SIA Plugin Bundle Activated");
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("SIA Plugin Bundle Deactivated");
	}

}
