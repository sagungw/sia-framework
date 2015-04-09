package com.sia.main.plugin.modul;

public interface IModule {
	public void setModuleName(String moduleName);

	public String getModuleName();

	public void setServletName(String servletName);

	public String getServletName();

	public void setUrlMapping(String urlMapping);

	public String getUrlMapping();

	public void setServletContextConfiguration(Class servletContextConfiguration);

	public Class getServletContextConfiguration();

}
