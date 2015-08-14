package com.sia.main.web.osgi;

import java.util.Map;

import org.eclipse.gemini.blueprint.service.importer.OsgiServiceLifecycleListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sia.main.plugin.modul.Module;

public class ModuleReferenceListener implements OsgiServiceLifecycleListener { 

	private static Logger logger = LoggerFactory.getLogger(ModuleReferenceListener.class);
	
	@Override
	public void bind(Object service, Map properties) throws Exception {
		if(logger.isInfoEnabled()) {
			Module module = (Module) service;
			logger.info("module " + module.getModuleName() + " added");
		}
	}

	@Override
	public void unbind(Object service, Map properties) throws Exception {
		if(logger.isInfoEnabled()) {
			Module module = (Module) service;
			logger.info("module " + module.getModuleName() + " removed");
		}
	}

}
