package com.sia.main.plugin.modul;

public abstract class Module extends Plugin implements IModule {

	protected String moduleName;
	protected String servletName;
	protected String urlMapping;
	protected Class servletContextConfiguration;

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

	public void setServletContextConfiguration(Class servletContextConfiguration) {
		this.servletContextConfiguration = servletContextConfiguration;
	}

	public Class getServletContextConfiguration() {
		return this.servletContextConfiguration;
	}

}
