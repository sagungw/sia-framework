package com.sia.main.web;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.sia.main.domain.Modul;
import com.sia.main.plugin.modul.Module;

public class WebAppInitializer implements WebApplicationInitializer {
	
	private final Logger logger = LoggerFactory.getLogger(WebAppInitializer.class);

	private ModuleManager moduleManager;
	
	@Override
	public void onStartup(ServletContext servletContext)throws ServletException {
		System.out.println("ON STARTUP: ");
		moduleManager = ModuleManager.getInstance();
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.scan(basePackages);
		if(moduleManager.getModules() != null && moduleManager.getModules().size() > 0){
			ServletRegistration.Dynamic dispatcher;
			for(Module m : moduleManager.getModules()) {
				if( m.getModuleName() != null) {
					System.out.println(m.getModuleName());
					System.out.println(m.getServletName());
					System.out.println(m.getServlet().getClass().getName());
					dispatcher = servletContext.addServlet(m.getServletName(), m.getServlet());
					dispatcher.setLoadOnStartup(1);
					dispatcher.addMapping("/sia-web" + m.getUrlMapping() + "*");
				} else {
					System.out.println("NULL");
				}
			}
		} else {
			System.out.println("No modules");
		}
		System.out.println("Startup end");
//		List<Modul> modules = moduleManager.getModulesFromDb(); 
//		if(modules != null && modules.size() > 0) {
//			ServletRegistration.Dynamic dispatcher;
//			for(Modul m : modules) {
//					System.out.println(m.getNamaModul());
//					XmlWebApplicationContext context = new XmlWebApplicationContext();
//					context.setConfigLocation(m.getLokasiKonfigurasiServlet());
//					dispatcher = servletContext.addServlet(m.getNamaServlet(), new DispatcherServlet(context));
//					dispatcher.setLoadOnStartup(1);
//					dispatcher.addMapping(m.getUrlMapping() + "*");
//			}
//		} else {
//			System.out.println("No modules");
//		}
//		
	}
	
}
