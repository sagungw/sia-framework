package com.sia.main.plugin.modul;

import java.io.File;
import java.util.List;

import org.springframework.web.servlet.DispatcherServlet;

public interface Module extends Plugin, HasMenu {

	public String getModuleName();

	public String getUrlMapping();
	
	public String getServletConfigurationPath();
	
	public String getServletName();
	
	public DispatcherServlet getServlet();
	
	public File[] getViewResources();
	
	public List<byte[]> getViewResourcesBytes();
	
}
