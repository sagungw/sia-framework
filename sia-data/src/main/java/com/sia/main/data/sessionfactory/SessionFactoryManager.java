package com.sia.main.data.sessionfactory;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.sia.main.domain.MenuPeran;
import com.sia.main.domain.Menu;
import com.sia.main.domain.Modul;
import com.sia.main.domain.Pengguna;
import com.sia.main.domain.Peran;
import com.sia.main.domain.PeranPengguna;
import com.sia.main.domain.SatMan;
import com.sia.main.plugin.persistence.HibernateConfiguration;

public class SessionFactoryManager {

	private static SessionFactoryManager instance;
	
	private SessionFactory securitySessionFactory;
	
	private HibernateConfiguration securitySessionFactoryConfiguration;
	
	private SessionFactoryManager() {
	}
	
	public static SessionFactoryManager getInstance() {
		if(SessionFactoryManager.instance == null) {
			SessionFactoryManager.instance = new SessionFactoryManager();
		}
		return SessionFactoryManager.instance;
	}
	
	private void buildSecuritySessionFactory(HibernateConfiguration hibernateConfiguration, List<Class> domainClasses) {
		for(Class clazz : domainClasses) {
			this.securitySessionFactoryConfiguration.getConfiguration().addAnnotatedClass(clazz);
		}
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(this.securitySessionFactoryConfiguration.getConfiguration().getProperties()).buildServiceRegistry();
		this.securitySessionFactory = this.securitySessionFactoryConfiguration.getConfiguration().buildSessionFactory(serviceRegistry);
	}
	
	public SessionFactory getSecuritySessionFactory() {
		if(this.securitySessionFactory == null) {
			List<Class> domainClasses = new ArrayList<Class>();
			domainClasses.add(MenuPeran.class);
			domainClasses.add(Menu.class);
			domainClasses.add(Modul.class);
			domainClasses.add(Pengguna.class);
			domainClasses.add(Peran.class);
			domainClasses.add(PeranPengguna.class);
			domainClasses.add(SatMan.class);
			this.buildSecuritySessionFactory(this.securitySessionFactoryConfiguration, domainClasses);
		}
		return this.securitySessionFactory;		
	}

	public HibernateConfiguration getSecuritySessionFactoryConfiguration() {
		return securitySessionFactoryConfiguration;
	}

	public void setSecuritySessionFactoryConfiguration(
			HibernateConfiguration securitySessionFactoryConfiguration) {
		this.securitySessionFactoryConfiguration = securitySessionFactoryConfiguration;
	}
	
	
	
}
