package com.sia.main.web;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.sia.main.domain.Modul;
import com.sia.main.service.services.ModulService;
import com.sia.main.web.osgi.ServiceLocator;

public class WebAppInitializer implements WebApplicationInitializer { 
	
	@Override
	public void onStartup(ServletContext servletContext)throws ServletException {
		ModulService modulService = this.getModulService();
		if(modulService != null) {
			List<Modul> modules =  modulService.getByParam("where status.namaStatus = 'STARTED'");
			if(modules != null && modules.size() > 0) {
				ServletRegistration.Dynamic dispatcher;
				for(Modul module: modules) {
					List<String> servletConfigLocations = module.getServletConfigLocationList();
					servletConfigLocations.add("/WEB-INF/spring-beans/servlet/sia-modul-servlet.xml");
					XmlWebApplicationContext context = new XmlWebApplicationContext();
					context.setConfigLocations(servletConfigLocations.toArray(new String[servletConfigLocations.size()]));
					dispatcher = servletContext.addServlet(module.getNamaServlet(), new DispatcherServlet(context));
					dispatcher.addMapping("/modul" + module.getUrlMapping());
					dispatcher.setLoadOnStartup(0);
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