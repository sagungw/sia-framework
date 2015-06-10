package com.sia.main.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sia.main.domain.Modul;
import com.sia.main.plugin.modul.Module;
import com.sia.main.service.services.ModulService;

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

	public void init() {
		if(modules != null) {
			for(Module module : modules) {
				System.out.print("Module Manager: ");
				System.out.println(module.getModuleName());
			}
		}
	}
	
	public List<Module> getModules() {
		return this.modules;
	}
	
	public void setModules(List<Module> modules) {
		this.modules = modules;
	}
}
