package com.sia.main.plugin.modul;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public abstract class Module extends Plugin implements IModule {

	protected String moduleName;
	protected String servletName;
	protected String urlMapping;
	protected DispatcherServlet servlet;

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getModuleName() {
		return this.moduleName;
	}

	public void setServletName(String servletName) {
		this.servletName = servletName;
	}

	public String getServletName() {
		return this.servletName;
	}

	public void setUrlMapping(String urlMapping) {
		this.urlMapping = urlMapping;
	}

	public String getUrlMapping() {
		return this.urlMapping;
	}

	public abstract DispatcherServlet buildServlet();

	public abstract DispatcherServlet buildServlet(WebApplicationContext webApplicationContext);
	
}
