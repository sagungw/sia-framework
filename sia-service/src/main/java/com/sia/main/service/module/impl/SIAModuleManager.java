package com.sia.main.service.module.impl;

import java.util.ArrayList;
import java.util.List;

import com.sia.main.plugin.modul.Module;
import com.sia.main.service.module.ModuleManager;

public class SIAModuleManager implements ModuleManager {

	private static SIAModuleManager instance;
	
	private List<Module> modules;
	
	@SuppressWarnings("unused")
	private static SIAModuleManager getInstance() {
		if(instance == null)
			instance = new SIAModuleManager();
		return instance;
	}  
	
	private SIAModuleManager() {
		this.modules = new ArrayList<Module>();
	}
	
	@Override
	public void removeModuleByName(String moduleName) {
		for(Module module : this.modules) {
			if(module.getModuleName().equals(moduleName)) {
				this.modules.remove(module);
				break;
			}
		}
	}

	@Override
	public void addModule(Module module) {
		this.modules.add(module);
	}

	@Override
	public void setModules(List<Module> modules) {
		this.modules = modules;
	}

	@Override
	public List<Module> getModules() {
		return this.modules;
	}
	
}
