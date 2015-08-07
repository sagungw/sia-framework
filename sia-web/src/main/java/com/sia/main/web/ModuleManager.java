package com.sia.main.web;

import java.util.ArrayList;
import java.util.List;

import com.sia.main.plugin.modul.Module;

public class ModuleManager {
	
	private List<Module> modules;
	
	private static ModuleManager instance;
	
	private ModuleManager(){
	}
	
	public static ModuleManager getInstance() {
		if(ModuleManager.instance == null) {
			ModuleManager.instance = new ModuleManager();
		}
		return ModuleManager.instance;
	}

	public List<Module> getModules() {
		return this.modules;
	}
	
	public void setModules(List<Module> modules) {
		this.modules = modules;
	}
	
	public void addModule(Module module) {
		if(this.modules == null) {
			this.modules = new ArrayList<Module>();
		}
		this.modules.add(module);
	}
	
	public void removeModule(String moduleName) {
		int index = 0;
		boolean found = false;
		for(Module module: this.modules) {
			if(module.getModuleName().equals(moduleName)) {
				found = true;
				break;
			} else {
				index++;
			}
		}
		if(found) {
			this.modules.remove(index);
		}		
	}

}
