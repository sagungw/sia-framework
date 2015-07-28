package com.sia.main.plugin.persistence;

import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;

public interface BasicSpringOrmHibernateConfig {

	public BasicDataSource getDataSource();
	
	public Properties getHibernateProperties();
	
}
