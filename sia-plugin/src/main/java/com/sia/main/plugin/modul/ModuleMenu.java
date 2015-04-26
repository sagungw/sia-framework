package com.sia.main.plugin.modul;

public abstract class ModuleMenu implements IModuleMenu, Accessable {

	protected String name;
	
	protected String url;

	public void setName(String menuName) {
		this.name = menuName;
	}

	public String getName() {
		return this.name;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getUrl() {
		return this.url;
	}
	
}
