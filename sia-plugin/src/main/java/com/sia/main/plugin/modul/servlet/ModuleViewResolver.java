package com.sia.main.plugin.modul.servlet;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.AbstractUrlBasedView;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.sia.main.plugin.modul.Module;

public class ModuleViewResolver implements ViewResolver {
	
	private Module module;
	
	public ModuleViewResolver(){
		super();
	}
	
	public void init() {
		
	}
	
	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}
	
	@Override
	public View resolveViewName(String viewName, Locale locale) throws Exception {
		InternalResourceView view = new InternalResourceView();
		File[] files = this.module.getViewResources();
		for(File file: files) {
			String completeFileName = file.getName();
			String fileName = completeFileName.split("\\.")[0];
			if(viewName.equals(fileName)) {
				view.setUrl(file.getCanonicalPath());
				break;
			} 
		}
		return view;
	}

}
