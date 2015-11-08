package com.sia.main.service.module;

import org.osgi.framework.Bundle;

import com.sia.main.domain.Modul;

public interface OsgiModuleReader {

	public Modul readModule(Bundle moduleBundle, Bundle hostBundle) throws Exception;
	
}
