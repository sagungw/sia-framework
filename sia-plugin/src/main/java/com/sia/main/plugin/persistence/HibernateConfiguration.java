package com.sia.main.plugin.persistence;

import java.util.Properties;

import org.hibernate.cfg.Configuration;

import com.sia.main.plugin.modul.Plugin;

public abstract class HibernateConfiguration extends Plugin{
	
	protected Configuration dbAccessConfiguration;

	public abstract void setConfigurationProperties();
	
	public abstract void setConfigurationProperties(Configuration configuration);
	
	public abstract void setConfigurationProperties(Properties properties);
	
	public abstract Configuration getConfiguration();
	
}
