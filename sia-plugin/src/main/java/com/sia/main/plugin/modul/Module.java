package com.sia.main.plugin.modul;

public interface Module extends Plugin, HasMenu {
	
	public void setModuleName(String moduleName);
	
	public String getModuleName();

}
