package com.sia.main.web;

import java.util.Map;

import org.eclipse.gemini.blueprint.service.importer.OsgiServiceLifecycleListener;

public class ModuleReferenceListener implements OsgiServiceLifecycleListener {

	@Override
	public void bind(Object service, Map properties) throws Exception {
		System.out.println("Module added");
	}

	@Override
	public void unbind(Object service, Map properties) throws Exception {
		System.out.println("Module removed");
	}

}
