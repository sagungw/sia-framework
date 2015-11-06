package com.sia.main.service.module;

import java.util.List;
import java.util.UUID;

import com.sia.main.plugin.modul.Module;

public interface ModuleManager {

	public void addModule(Module module);
	
	public void replaceModule(UUID toBeReplaced, Module toReplace);
	
	public void removeModule(UUID moduleId);
	
	public void setModules(List<Module> modules);
	
	public List<Module> getModules();
	
	public Module getModuleById(UUID moduleId);
	
}
