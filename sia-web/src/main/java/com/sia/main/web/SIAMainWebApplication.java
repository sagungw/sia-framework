package com.sia.main.web;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.sia.main.domain.Modul;
import com.sia.main.plugin.ApplicationInitializer;
import com.sia.main.service.services.ModulService;
import com.sia.main.web.osgi.ServiceLocator;

public class SIAMainWebApplication implements ApplicationInitializer {

	private static SIAMainWebApplication instance;
	
	private ServletContext servletContext;
	
	private ServletRegistration.Dynamic dispatcher;
	
	private String moduleContextPathPrefix;
	
	private String additionalModuleConfigLocation;
	
	public static SIAMainWebApplication getInstance() {
		if(instance == null) {
			instance = new SIAMainWebApplication(); 
		}
		return instance;
	}
	
	private SIAMainWebApplication() {
		this.moduleContextPathPrefix = "/modul";
		this.additionalModuleConfigLocation = "/WEB-INF/spring-beans/servlet/sia-modul-servlet.xml";
	}
	
	public ServletContext getServletContext() {
		return servletContext;
	}

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	public ServletRegistration.Dynamic getDispatcher() {
		return dispatcher;
	}

	public void setDispatcher(ServletRegistration.Dynamic dispatcher) {
		this.dispatcher = dispatcher;
	}

	public String getModuleContextPathPrefix() {
		return moduleContextPathPrefix;
	}

	public void setModuleContextPathPrefix(String moduleContextPathPrefix) {
		this.moduleContextPathPrefix = moduleContextPathPrefix;
	}

	public String getAdditionalModuleConfigLocation() {
		return additionalModuleConfigLocation;
	}

	public void setAdditionalModuleConfigLocation(
			String additionalModuleConfigLocation) {
		this.additionalModuleConfigLocation = additionalModuleConfigLocation;
	}

	@Override
	public void init() {
		this.registerServlet();
	}
	
	private void registerServlet() {
		ModulService modulService = this.getModulService();
		if(modulService != null) {
			List<Modul> modules =  modulService.getByParam("where status = 'ACTIVE'");
			if(modules != null && modules.size() > 0) {
				for(Modul module: modules) {
					List<String> servletConfigLocations = module.getServletConfigLocationList();
					servletConfigLocations.add(this.additionalModuleConfigLocation);
					XmlWebApplicationContext context = new XmlWebApplicationContext();
					context.setConfigLocations(servletConfigLocations.toArray(new String[servletConfigLocations.size()]));
					this.dispatcher = this.servletContext.addServlet(module.getNamaServlet(), new DispatcherServlet(context));
					this.dispatcher.addMapping(this.moduleContextPathPrefix + module.getUrlMapping());
					this.dispatcher.setLoadOnStartup(0);
				}
			}
		}
	}
	
	private ModulService getModulService() {
		BundleContext bundleContext = FrameworkUtil.getBundle(this.getClass()).getBundleContext();
		ServiceLocator<ModulService> serviceLocator = new ServiceLocator<ModulService>(bundleContext, ModulService.class);
		return serviceLocator.getService(0);
	}

}
