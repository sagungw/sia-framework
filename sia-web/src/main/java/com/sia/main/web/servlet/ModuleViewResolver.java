package com.sia.main.web.servlet;

import org.springframework.web.servlet.view.AbstractUrlBasedView;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.sia.main.plugin.modul.Module;

public class ModuleViewResolver extends InternalResourceViewResolver {
	
	private Module module;
	
	private String viewType;
	
	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}
		
	public String getViewType() {
		return viewType;
	}

	public void setViewType(String viewType) {
		this.viewType = viewType;
	}
	
	@Override
	protected AbstractUrlBasedView buildView(String viewName) throws Exception {
		InternalResourceView view = (InternalResourceView) super.buildView(viewName);
		
		return view;
	}

}
