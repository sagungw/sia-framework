package com.sia.main.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.sia.main.plugin.modul.Module;
import com.sia.main.service.module.ModuleManager;
import com.sia.main.web.osgi.ServiceLocator;

public class WebAppInitializer implements WebApplicationInitializer {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass()); 
	
	@Override
	public void onStartup(ServletContext servletContext)throws ServletException {
		
	}
	
	private ModuleManager getOsgiModuleManager() {
		ModuleManager moduleManager;
		BundleContext bundleContext = FrameworkUtil.getBundle(this.getClass()).getBundleContext();
		ServiceLocator<ModuleManager> serviceLocator = new ServiceLocator<ModuleManager>(bundleContext, ModuleManager.class);
		moduleManager = serviceLocator.getService(0);
		return moduleManager;
	}

}