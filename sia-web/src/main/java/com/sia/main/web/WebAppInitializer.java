package com.sia.main.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.springframework.web.WebApplicationInitializer;

import com.sia.main.plugin.modul.Module;
import com.sia.main.service.module.ModuleManager;
import com.sia.main.web.osgi.ServiceLocator;

public class WebAppInitializer implements WebApplicationInitializer {
	
	@Override
	public void onStartup(ServletContext servletContext)throws ServletException {
		
		BundleContext bundleContext = FrameworkUtil.getBundle(this.getClass()).getBundleContext();
		ModuleManager moduleManager;
		
		ServiceLocator<ModuleManager> serviceLocator = new ServiceLocator<ModuleManager>(bundleContext, ModuleManager.class);
		moduleManager = serviceLocator.getService(0);
		
		if(moduleManager != null) {
			System.out.println("modules found in WebAppInitializer:");
			for(Module module: moduleManager.getModules()) {
				System.out.println(module.getModuleName());
			}
		} else {
			System.out.println("moduleManager null");
		}
		
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