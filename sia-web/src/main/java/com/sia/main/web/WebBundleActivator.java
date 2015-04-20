package com.sia.main.web;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class WebBundleActivator implements BundleActivator {

	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("WebBundleActivator started");
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("WebBundleActivator stopped");
	}

}
