package com.sia.main.data.sessionfactory;

import java.util.Map;

import org.eclipse.gemini.blueprint.service.importer.OsgiServiceLifecycleListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sia.main.plugin.persistence.HibernateConfiguration;

public class HibernateConfigReferenceListener implements OsgiServiceLifecycleListener{

	private static final Logger logger = LoggerFactory.getLogger(HibernateConfigReferenceListener.class);
	
	@Override
	public void bind(Object object, Map map) throws Exception {
		if(logger.isInfoEnabled()) {
			HibernateConfiguration hibernateConfiguration = (HibernateConfiguration) object;
			logger.info(hibernateConfiguration.getClass().getName() + " Configuration service found");
		}
	}

	@Override
	public void unbind(Object object, Map map) throws Exception {
		if(logger.isInfoEnabled()) {
			HibernateConfiguration hibernateConfiguration = (HibernateConfiguration) object;
			logger.info(hibernateConfiguration.getClass().getName() + " Configuration service removed");
		}
	}

}
