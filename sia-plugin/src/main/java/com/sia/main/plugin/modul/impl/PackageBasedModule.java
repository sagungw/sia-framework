package com.sia.main.plugin.modul.impl;

import java.util.ArrayList;
import java.util.List;

import com.sia.main.plugin.modul.HasBasePackages;
import com.sia.main.plugin.modul.Menu;
import com.sia.main.plugin.modul.Module;

public class PackageBasedModule implements Module, HasBasePackages {

	private String pluginName;
	
	private String pluginVersion;
	
	private String moduleName;
	
	private List<Menu> menus;
	
	private List<String> basePackages;
	
	public PackageBasedModule() {
		this.menus = new ArrayList<Menu>();
		this.basePackages = new ArrayList<String>();
	}
	
	public PackageBasedModule(String pluginName, String pluginVersion, String moduleName, List<Menu> menus, List<String> basePackages) {
		this.pluginName = pluginName;
		this.pluginVersion = pluginVersion;
		this.moduleName = moduleName;
		this.menus = menus;
		this.basePackages = basePackages;
	}

	@Override
	public void setPluginName(String pluginName) {
		this.pluginName = pluginName;
	}

	@Override
	public String getPluginName() {
		return this.pluginName;
	}

	@Override
	public void setPluginVersion(String pluginVersion) {
		this.pluginVersion = pluginVersion;
	}

	@Override
	public String getPluginVersion() {
		return this.pluginVersion;
	}

	@Override
	public void addMenu(Menu menu) {
		this.menus.add(menu);
	}

	@Override
	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	@Override
	public List<Menu> getMenus() {
		return this.menus;
	}

	@Override
	public void addBasePackage(String basePackage) {
		this.basePackages.add(basePackage);
	}

	@Override
	public void setBasePackages(List<String> basePackages) {
		this.basePackages = basePackages;
	}

	@Override
	public List<String> getBasePackages() {
		return this.basePackages;
	}

	@Override
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	@Override
	public String getModuleName() {
		return this.moduleName;
	}

}
