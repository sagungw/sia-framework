package com.sia.main.data.sessionfactory;

import org.hibernate.SessionFactory;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.sia.main.plugin.persistence.HibernateConfiguration;

@SuppressWarnings("rawtypes")
public class SessionFactoryManager {

	private static SessionFactoryManager instance;

	private HibernateConfiguration securitySessionFactoryConfiguration;
	
	private SessionFactory securitySessionFactory;
	
	private Class[] annotatedDomainClasses;
	
	private SessionFactoryManager() {
	}
	
	public static SessionFactoryManager getInstance() {
		if(SessionFactoryManager.instance == null) {
			SessionFactoryManager.instance = new SessionFactoryManager();
		}
		return SessionFactoryManager.instance;
	}
	
	public HibernateConfiguration getSecuritySessionFactoryConfiguration() {
		return securitySessionFactoryConfiguration;
	}

	public void setSecuritySessionFactoryConfiguration(
			HibernateConfiguration securitySessionFactoryConfiguration) {
		this.securitySessionFactoryConfiguration = securitySessionFactoryConfiguration;
	}
	
	public void setSecuritySessionFactory(SessionFactory securitySessionFactory) {
		this.securitySessionFactory = securitySessionFactory;
	}
	
	public SessionFactory getSecuritySessionFactory() {
		if(this.securitySessionFactory == null) {
			this.buildSecuritySessionFactory(this.securitySessionFactoryConfiguration, this.annotatedDomainClasses);
		}
		return this.securitySessionFactory;		
	}
	
	public Class[] getAnnotatedDomainClasses() {
		return annotatedDomainClasses;
	}

	public void setAnnotatedDomainClasses(Class[] annotatedDomainClasses) {
		this.annotatedDomainClasses = annotatedDomainClasses;
	}
	
	private void buildSecuritySessionFactory(HibernateConfiguration hibernateConfiguration, Class[] domainClasses) {
		for(Class clazz : domainClasses) {
			this.securitySessionFactoryConfiguration.getConfiguration().addAnnotatedClass(clazz);
		}
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(this.securitySessionFactoryConfiguration.getConfiguration().getProperties()).buildServiceRegistry();
		this.securitySessionFactory = this.securitySessionFactoryConfiguration.getConfiguration().buildSessionFactory(serviceRegistry);
	}
	
}
