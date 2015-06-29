package com.sia.main.web;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.web.WebApplicationInitializer;

import com.sia.main.plugin.modul.Module;

public class WebAppInitializer implements WebApplicationInitializer {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

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
					Resource[] resources = m.getViewResources();
					System.out.println("web app: resource found: " + resources.length);
					for(int i = 0; i < resources.length; i++) {
						System.out.println("resources found");
						System.out.println("view resource found: " + resources[i].getFilename());
					}
				}
			}
		}
	}
	
}
