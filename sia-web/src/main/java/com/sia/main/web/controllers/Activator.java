package com.sia.main.web.controllers;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("sia web activated");
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("sia web not activated");
	}

}
