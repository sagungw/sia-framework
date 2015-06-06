package com.sia.main.plugin.persistence;

import java.util.Properties;

import org.hibernate.cfg.Configuration;

import com.sia.main.plugin.modul.Plugin;

public interface HibernateConfiguration extends Plugin{

	public void setConfigurationProperties();
	
	public void setConfigurationProperties(Configuration configuration);
	
	public void setConfigurationProperties(Properties properties);
	
	public Configuration getConfiguration();
	
}
