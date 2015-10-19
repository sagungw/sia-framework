package com.sia.main.service.module;

import org.osgi.framework.Bundle;

import com.sia.main.plugin.modul.Module;

public interface OsgiModuleReader {

	public Module readModule(Bundle moduleBundle, Bundle hostBundle);
	
}
