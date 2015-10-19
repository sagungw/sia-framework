package com.sia.main.plugin.modul;

import org.springframework.web.servlet.DispatcherServlet;

public interface HasServlet {

	public void setUrlMapping(String urlMapping);
	
	public String getUrlMapping();
	
	public void setServletConfigLocation(String servletConfigLocation);
	
	public String getServletConfigLocation();
	
	public void setServletName(String servletName);
	
	public String getServletName();
	
	public void setServlet(DispatcherServlet servlet);
	
	public DispatcherServlet getServlet();
	
}
