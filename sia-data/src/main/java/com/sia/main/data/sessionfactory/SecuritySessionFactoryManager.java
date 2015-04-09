package com.sia.main.data.sessionfactory;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.sia.main.plugin.persistence.HibernateConfiguration;

public class SecuritySessionFactoryManager {

	private static SessionFactory securitySessionFactory;
	
	private static HibernateConfiguration sessionFactoryConfiguration;
	
	private static List<Class> annotatedClasses;

	private SecuritySessionFactoryManager() {}

	private static void buildSecuritySessionFactory() {
		for(Class clazz : SecuritySessionFactoryManager.annotatedClasses) {
			SecuritySessionFactoryManager.sessionFactoryConfiguration.getConfiguration().addAnnotatedClass(clazz);
		}
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(SecuritySessionFactoryManager.sessionFactoryConfiguration.getConfiguration().getProperties()).buildServiceRegistry();
		SecuritySessionFactoryManager.securitySessionFactory = SecuritySessionFactoryManager.sessionFactoryConfiguration.getConfiguration().buildSessionFactory(serviceRegistry);
	}
	
	public static SessionFactory getSessionFactory() {
		if(SecuritySessionFactoryManager.securitySessionFactory == null) {
			SecuritySessionFactoryManager.buildSecuritySessionFactory();
		}
		return SecuritySessionFactoryManager.securitySessionFactory;		
	}

	public static void setSessionFactoryConfiguration(HibernateConfiguration sessionFactoryConfiguration) {
		SecuritySessionFactoryManager.sessionFactoryConfiguration = sessionFactoryConfiguration;
	}
	
	public static void setAnnotatedClasses(List<Class> classes) {
		SecuritySessionFactoryManager.annotatedClasses = classes;
	}
	
	public static void addAnnotatedClass(Class clazz) {
		if(SecuritySessionFactoryManager.annotatedClasses == null) {
			SecuritySessionFactoryManager.annotatedClasses = new ArrayList<Class>();
		}
		SecuritySessionFactoryManager.annotatedClasses.add(clazz);
	}
	
}
