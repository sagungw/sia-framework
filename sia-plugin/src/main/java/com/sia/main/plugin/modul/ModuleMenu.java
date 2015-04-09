package com.sia.main.plugin.modul;

public abstract class ModuleMenu implements IModuleMenu, Accessable {

	protected String name;

	public void setName(String menuName) {
		this.name = menuName;
	}

	public String getName() {
		return this.name;
	}

	
}
