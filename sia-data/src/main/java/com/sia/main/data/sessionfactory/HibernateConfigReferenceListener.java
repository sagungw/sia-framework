package com.sia.main.data.sessionfactory;

import java.util.Map;

import org.eclipse.gemini.blueprint.service.importer.OsgiServiceLifecycleListener;

public class HibernateConfigReferenceListener implements OsgiServiceLifecycleListener{

	@Override
	public void bind(Object object, Map map) throws Exception {
		System.out.println("SIA-WEB INFO: Hibernate DB Configuration service found");
	}

	@Override
	public void unbind(Object object, Map map) throws Exception {
		System.out.println("SIA-WEB INFO: Hibernate DB Configuration service removed");
	}

}
