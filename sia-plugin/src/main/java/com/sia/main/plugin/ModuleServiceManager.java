package com.sia.main.plugin;

import java.util.ArrayList;
import java.util.List;

import com.sia.main.plugin.modul.Module;

public class ModuleServiceManager {

	private static ModuleServiceManager instance;
	
	private List<Module> modules;
	
	private ModuleServiceManager() {
		
	}
	
	public static ModuleServiceManager getInstance() {
		if(ModuleServiceManager.instance == null) {
			ModuleServiceManager.instance = new ModuleServiceManager();
		}
		return ModuleServiceManager.instance;
	}

	public List<Module> getModules() {
		return modules;
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
	
	public Module getModuleByName(String moduleName) {
		Module module = null;
		for(Module m : this.modules) {
			if(m.getModuleName().equals(moduleName)) {
				module = m;
				break;
			}
		}
		return module;
	}
	
}
