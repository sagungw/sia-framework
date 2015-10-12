package com.sia.main.service.util;

import org.osgi.framework.Bundle;

import com.sia.main.plugin.modul.Module;

public interface OsgiModuleReader {

	public Module readModule(Bundle moduleBundle);
	
}
