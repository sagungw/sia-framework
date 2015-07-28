package com.sia.main.plugin.persistence;

import java.util.Properties;

import org.hibernate.cfg.Configuration;

public interface HibernateConfiguration {

	public void setConfigurationProperties();
	
	public void setConfigurationProperties(Configuration configuration);
	
	public void setConfigurationProperties(Properties properties);
	
	public Configuration getConfiguration();
	
}
