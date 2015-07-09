package com.sia.main.plugin.modul;

import java.io.File;
import java.util.List;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public interface Module {

	public String getModuleName();

	public String getServletName();

	public String getUrlMapping();
	
	public String getServletConfLocation();
	
	public void buildServlet();
	
	public void buildServlet(WebApplicationContext webApplicationContext);
	
	public DispatcherServlet getServlet();
	
	public File[] getViewResources();
	
	public List<byte[]> getViewResourcesInBytes();
	
}
