package com.sia.main.service.module;

import java.util.List;

import com.sia.main.plugin.modul.Module;

public interface ModuleManager {

	public void addModule(Module module);
	
	public void removeModuleByName(String moduleName);
	
	public void setModules(List<Module> modules);
	
	public List<Module> getModules();
	
}
