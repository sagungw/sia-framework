package com.sia.main.plugin.modul.servlet;

import org.springframework.web.servlet.view.AbstractUrlBasedView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

public class OsgiModuleViewResolver extends UrlBasedViewResolver {

	@Override
	public  AbstractUrlBasedView buildView(String viewName) {
		return null;
	}
	
}
