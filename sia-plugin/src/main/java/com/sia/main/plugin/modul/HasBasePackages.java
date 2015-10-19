package com.sia.main.plugin.modul;

import java.util.List;

public interface HasBasePackages {
	
	public void addBasePackage(String basePackage);
	
	public void setBasePackages(List<String> basePackages);
	
	public List<String> getBasePackages();
}
