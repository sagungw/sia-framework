package com.sia.main.web;

import java.util.ArrayList;
import java.util.List;

import com.sia.main.plugin.modul.Module;

public class ModuleManager {
	
	private static ModuleManager instance;
	
	private static List<Module> modules;
	
	private ModuleManager() {	
	}
	
	public static ModuleManager getInstance() {
		if(instance == null)
			instance = new ModuleManager();
		return ModuleManager.instance;
	}
	
	public static List<Module> getModules() {
		if(ModuleManager.modules == null) {
			ModuleManager.modules = new ArrayList<Module>();
		}
		return ModuleManager.modules;
	}
	
	public static void setModules(List<Module> modules) {
		ModuleManager.modules = modules;
	} 

}
