package com.sia.main.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;

import com.sia.main.plugin.modul.Module;

public class WebAppInitializer implements WebApplicationInitializer {
	
	private ModuleManager moduleManager;
	
	@Override
	public void onStartup(ServletContext servletContext)throws ServletException {
		moduleManager = ModuleManager.getInstance();
		if(moduleManager.getModules() != null && moduleManager.getModules().size() > 0){
			ServletRegistration.Dynamic dispatcher;
			for(Module m : moduleManager.getModules()) {
				if( m.getModuleName() != null) {
					dispatcher = servletContext.addServlet(m.getServletName(), m.getServlet());
					dispatcher.setLoadOnStartup(1);
					dispatcher.addMapping(m.getUrlMapping());
				}
			}
		}
	}
	
}
