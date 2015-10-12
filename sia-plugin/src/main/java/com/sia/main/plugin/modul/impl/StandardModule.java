package com.sia.main.plugin.modul.impl;

import java.util.List;

import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.sia.main.plugin.modul.Menu;
import com.sia.main.plugin.modul.Module;

public class StandardModule implements Module {

	private String pluginName;
	
	private String pluginVersion;
	
	private List<Menu> menus;
	
	private String moduleName;
	
	private String urlMapping;
	
	private String servletConfigLocation;
	
	private DispatcherServlet servlet;
	
	private List<String> basePackages;
	
	public StandardModule(String pluginName, String pluginVersion,
			List<Menu> menus, String moduleName, String urlMapping,
			String servletConfigLocation, List<String> basePackages) {
		this.pluginName = pluginName;
		this.pluginVersion = pluginVersion;
		this.menus = menus;
		this.moduleName = moduleName;
		this.setUrlMapping(urlMapping);
		this.servletConfigLocation = servletConfigLocation;
		this.servlet = this.buildServlet(this.servletConfigLocation);
		this.basePackages = basePackages;
	}

	public StandardModule() {
	}

	public void setPluginName(String pluginName) {
		this.pluginName = pluginName;
	}

	@Override
	public String getPluginName() {
		return this.pluginName;
	}

	public void setPluginVersion(String pluginVersion) {
		this.pluginVersion = pluginVersion;
	}

	@Override
	public String getPluginVersion() {
		return this.pluginVersion;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	@Override
	public List<Menu> getMenus() {
		return this.menus;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	@Override
	public String getModuleName() {
		return this.moduleName;
	}

	public void setUrlMapping(String urlMapping) {
		this.urlMapping = this.standardizeUrlMapping(urlMapping);
	}

	@Override
	public String getUrlMapping() {
		return this.urlMapping;
	}

	public void setServletConfigLocation(String servletConfigLocation) {
		this.servletConfigLocation = servletConfigLocation;
	}

	@Override
	public String getServletConfigLocation() {
		return this.servletConfigLocation;
	}

	@Override
	public DispatcherServlet getServlet() {
		return servlet;
	}

	public void setServlet(DispatcherServlet servlet) {
		this.servlet = servlet;
	}

	private DispatcherServlet buildServlet(String contextLocation) {
		XmlWebApplicationContext context = new XmlWebApplicationContext();
		context.setConfigLocation("classpath*:" + contextLocation);
		DispatcherServlet servlet = new DispatcherServlet(context);
		return servlet;
	}
	
	@Override
	public String getServletName() {
		StringBuilder servletName = new StringBuilder();
		int i = 0;
		String[] moduleName = this.getModuleName().toLowerCase().split(" ");
		for(String string: moduleName) {
			if(i > 0) servletName.append('-');
			servletName.append(string);
			i++;
		}
		servletName.append("-servlet");
		return servletName.toString();
	}
	
	private String standardizeUrlMapping(String urlMapping) {
		StringBuilder result = new StringBuilder();
		result.append("/modul");
		if(urlMapping.charAt(0) != '/') {
			result.append('/');
		}
		if(urlMapping.charAt(urlMapping.length()-1) != '*') {
			if(urlMapping.charAt(urlMapping.length()-1) != '/') {
				result.append(urlMapping + "/*");
			} else {
				result.append(urlMapping + "*");
			}
		}
		return result.toString();
	}

	@Override
	public List<String> getBasePackages() {
		return basePackages;
	}

	public void setBasePackages(List<String> basePackages) {
		this.basePackages = basePackages;
	}

	
	
}
