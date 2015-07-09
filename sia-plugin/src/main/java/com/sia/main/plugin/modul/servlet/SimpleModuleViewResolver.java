package com.sia.main.plugin.modul.servlet;

import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceView;

import com.sia.main.plugin.modul.Module;

public class SimpleModuleViewResolver implements ViewResolver {

	private Map<String, View> viewMap;
	
	private Module module;
	
	public Map<String, View> getViewMap() {
		return viewMap;
	}

	public void setViewMap(Map<String, View> viewMap) {
		this.viewMap = viewMap;
	}
	
	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	@Override
	public View resolveViewName(String viewName, Locale locale)
			throws Exception {
		if(this.viewMap == null) {
			this.buildViewMap();
		}
		return this.viewMap.get(viewName);
	}
	
	private void buildViewMap() {
		this.viewMap = new HashMap<String, View>();
		File[] viewResources = this.module.getViewResources();
		for(File file : viewResources) {
			InternalResourceView view = new InternalResourceView();
			String key = file.getName().split("\\.")[0];
			view.setUrl(file.getPath());
			System.out.println("path: " + file.getPath());
			this.viewMap.put(key, view);
		}
	}
	
	public void init() {
		this.buildViewMap();
	}

}
