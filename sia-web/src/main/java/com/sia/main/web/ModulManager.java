package com.sia.main.web;

import java.util.ArrayList;
import java.util.List;

import com.sia.main.plugin.modul.Module;

public class ModulManager {
	
	private static ModulManager instance;
	
	private ModulManager() {	
	}
	
	public static ModulManager getInstance() {
		if(instance == null)
			instance = new ModulManager();
		return ModulManager.instance;
	}
	
	public static List<Module> getModules() {
		List<Module> modules = new ArrayList<Module>();
		return modules;
	}

}
