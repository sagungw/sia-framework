package com.sia.main.service.module.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
	public void addModule(Module module) {
		this.modules.add(module);
	}

	@Override
	public void replaceModule(UUID toBeReplaced, Module toReplace) {
		try {
			this.modules.set(this.modules.indexOf(this.getModuleById(toBeReplaced)), toReplace);
		} catch(NullPointerException npe) {
			throw new NullPointerException("modul dengan id " + toBeReplaced + " tidak ditemukan pada OSGi module manager");
		}
		
	}
	
	@Override
	public void removeModule(UUID moduleId) {
		try {
			this.modules.remove(this.getModuleById(moduleId));
		} catch(NullPointerException npe) {
			throw new NullPointerException("modul dengan id " + moduleId + " tidak ditemukan pada OSGi module manager");
		}
		
	}

	@Override
	public void setModules(List<Module> modules) {
		this.modules = modules;
	}

	@Override
	public List<Module> getModules() {
		return this.modules;
	}

	@Override
	public Module getModuleById(UUID moduleId) {
		Module moduleFound = null;
		for(Module module : this.modules) {
			if(module.getModuleId().toString().equals(moduleId.toString())) {
				moduleFound = module;
			}
		}
		return moduleFound;
	}
	
}
