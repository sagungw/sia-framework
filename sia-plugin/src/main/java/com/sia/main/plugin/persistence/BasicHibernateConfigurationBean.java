package com.sia.main.plugin.persistence;

import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;

public class BasicHibernateConfigurationBean implements BasicHibernateConfiguration {

	private BasicDataSource dataSource;
	
	private Properties hibernateProperties;
	
	public void setDataSource(BasicDataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public BasicDataSource getDataSource() {
		return this.dataSource;
	}

	public void setHibernateProperties(Properties hibernateProperties) {
		this.hibernateProperties = hibernateProperties;
	}
	
	@Override
	public Properties getHibernateProperties() {
		return this.hibernateProperties;
	}

}
