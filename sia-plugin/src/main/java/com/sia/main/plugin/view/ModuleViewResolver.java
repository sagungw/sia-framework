package com.sia.main.plugin.view;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.AbstractUrlBasedView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.sia.main.plugin.modul.Module;

public class ModuleViewResolver extends InternalResourceViewResolver {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	private Module module;

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	} 
	
	@Override
	protected View loadView(String viewName, Locale locale) throws Exception {
		AbstractUrlBasedView view = buildView(viewName);
		View result = applyLifeCycleMethods(view, viewName);
		return (view.checkResource(locale) ? result : null);
	} 
	
	private View applyLifeCycleMethods(View view, String viewName) {
		try {
			return (View) module.getServlet().getWebApplicationContext().getAutowireCapableBeanFactory().initializeBean(view, viewName);
		} catch(NullPointerException npe) {
			if(logger.isErrorEnabled())
				logger.error("module instance is null");
			npe.printStackTrace();
			return null;
		}
	}
	
}
