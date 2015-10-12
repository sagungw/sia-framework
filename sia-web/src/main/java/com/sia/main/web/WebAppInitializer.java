package com.sia.main.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.eclipse.virgo.web.dm.ServerOsgiBundleXmlWebApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.DispatcherServlet;

import com.sia.main.plugin.modul.Module;

public class WebAppInitializer implements WebApplicationInitializer {
	
	private ModuleManager moduleManager;

	@Override
	public void onStartup(ServletContext servletContext)throws ServletException {
//		moduleManager = ModuleManager.getInstance();
//		if(moduleManager.getModules() != null && moduleManager.getModules().size() > 0){
//			ServletRegistration.Dynamic dispatcher;
//			for(Module module : moduleManager.getModules()) {
//				if( module.getModuleName() != null) {
//					dispatcher = servletContext.addServlet(module.getServletName(), module.getServlet());
//					dispatcher.setLoadOnStartup(1);
//					dispatcher.addMapping(module.getUrlMapping());
//				}
//			}
//		}
		
	}

}