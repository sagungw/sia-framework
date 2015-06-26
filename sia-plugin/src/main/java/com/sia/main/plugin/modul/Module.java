package com.sia.main.plugin.modul;

import org.springframework.core.io.Resource;
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
	
	public WebApplicationContext getWebApplicationContext();
	
	public void initViewResources();
	
	public Resource[] getViewResources();
	
}
