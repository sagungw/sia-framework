package com.sia.main.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.sia.main.plugin.modul.HasServlet;
import com.sia.main.plugin.modul.Module;
import com.sia.main.service.module.ModuleManager;
import com.sia.main.web.osgi.ServiceLocator;

public class WebAppInitializer implements WebApplicationInitializer { 
	
	@Override
	public void onStartup(ServletContext servletContext)throws ServletException {
		ModuleManager moduleManager = this.getOsgiModuleManager();
		if(moduleManager != null && moduleManager.getModules().size() > 0) {
			ServletRegistration.Dynamic dispatcher;
			for(Module module: moduleManager.getModules()) {
				HasServlet servletModule = (HasServlet) module;
				servletModule.getServletConfigLocations().add("/WEB-INF/spring-beans/servlet/sia-modul-servlet.xml");
				XmlWebApplicationContext context = new XmlWebApplicationContext();
				context.setConfigLocations(servletModule.getServletConfigLocations().toArray(new String[servletModule.getServletConfigLocations().size()]));
				dispatcher = servletContext.addServlet(servletModule.getServletName(), new DispatcherServlet(context));
				dispatcher.addMapping(servletModule.getUrlMapping());
				dispatcher.setLoadOnStartup(0);
			}
		}
		
	}
	
	private ModuleManager getOsgiModuleManager() {
		BundleContext bundleContext = FrameworkUtil.getBundle(this.getClass()).getBundleContext();
		ServiceLocator<ModuleManager> serviceLocator = new ServiceLocator<ModuleManager>(bundleContext, ModuleManager.class);
		return serviceLocator.getService(0);
	}

}