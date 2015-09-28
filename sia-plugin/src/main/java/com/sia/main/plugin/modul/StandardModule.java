package com.sia.main.plugin.modul;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class StandardModule implements Module {

	private String pluginName;
	
	private String pluginVersion;
	
	private List<Menu> menus;
	
	private String moduleName;
	
	private String urlMapping;
	
	private String servletConfigurationPath;
	
	private DispatcherServlet servlet;
	
	private String viewResourceLocation;
	
	public StandardModule(String pluginName, String pluginVersion,
			List<Menu> menus, String moduleName, String urlMapping,
			String servletConfigurationPath, String viewResourceLocation) {
		super();
		this.pluginName = pluginName;
		this.pluginVersion = pluginVersion;
		this.menus = menus;
		this.moduleName = moduleName;
		this.setUrlMapping(urlMapping);
		System.out.println("urlMapping: " + this.urlMapping);
		this.servletConfigurationPath = servletConfigurationPath;
		this.viewResourceLocation = viewResourceLocation;
		this.buildServlet();
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

	public void setServletConfigurationPath(String servletConfigurationPath) {
		this.servletConfigurationPath = servletConfigurationPath;
	}

	@Override
	public String getServletConfigurationPath() {
		return this.servletConfigurationPath;
	}
	
	public void setViewResourceLocation(String viewResourceLocation) {
		this.viewResourceLocation = viewResourceLocation;
	}
	
	public String getViewResourceLocation() {
		return viewResourceLocation;
	}

	@Override
	public String getServletName() {
		//building servlet name based on the given module name;
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
	
	public void setServlet(DispatcherServlet servlet) {
		this.servlet = servlet;
	}
	
	@Override
	public DispatcherServlet getServlet() {
		return this.servlet;
	}

	@Override
	public File[] getViewResources() {
		File[] files = null;
		Bundle bundle = FrameworkUtil.getBundle(getClass());
		try {
			Enumeration<URL> resources = bundle.getResources(this.getViewResourceLocation());
			if(resources.hasMoreElements()) {
				URL url = resources.nextElement();
				File filesInUrl = new File(url.toURI());
				files = filesInUrl.listFiles();
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return files;
	}

	@Override
	public List<byte[]> getViewResourcesBytes() {
		File[] viewResources = this.getViewResources();
		List<byte[]> viewResourcesInBytes = new ArrayList<byte[]>();
		for(File file: viewResources) {
			try {
				FileInputStream inputStream = new FileInputStream(file);
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				byte[] buffer = new byte[2048];
				int read = 0;
				while((read = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer, 0, read);
				}
				viewResourcesInBytes.add(outputStream.toByteArray());
				inputStream.close();
				outputStream.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				return null;
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		}
		return viewResourcesInBytes;
	}
	
	public void buildServlet(){
		XmlWebApplicationContext context = new XmlWebApplicationContext();
		context.setConfigLocation("classpath*:" + this.servletConfigurationPath);
		this.setServlet(new DispatcherServlet(context));
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

}
