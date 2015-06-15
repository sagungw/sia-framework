package com.sia.main.plugin.modul;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public interface Module extends Plugin {
	
	public void setModuleName(String moduleName);

	public String getModuleName();

	public void setServletName(String servletName);

	public String getServletName();

	public void setUrlMapping(String urlMapping);

	public String getUrlMapping();
	
	public String getServletConfLocation();
	
	public void buildServlet();
	
	public void buildServlet(WebApplicationContext webApplicationContext);
	
	public DispatcherServlet getServlet();

}
