package com.sia.main.plugin.modul.servlet;

import java.io.IOException;
import java.util.Map;

import org.springframework.core.io.Resource;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.AbstractUrlBasedView;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.sia.main.plugin.ModuleServiceManager;
import com.sia.main.plugin.modul.Module;

public class ModuleViewResolver extends InternalResourceViewResolver {
	
	private String moduleName;
	
	private Map<String, String> viewMap;
	
	private String viewType;
	
	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getViewType() {
		return viewType;
	}

	public void setViewType(String viewType) {
		this.viewType = viewType;
	}
	
	public void buildViewMap() {
		System.out.println("building view map . . .");
		ModuleServiceManager moduleManager = ModuleServiceManager.getInstance();
		System.out.println("finding corresponding module . . .");
		boolean found = false;
		for(Module m : moduleManager.getModules()) {
			if(m.getModuleName().equals(this.moduleName)) {
				found = true;
				System.out.println("corresponding module found");
				System.out.println("module name: " + m.getModuleName());
				System.out.println("module servlet name: " + m.getServletName());
				System.out.println("view resources found: " + m.getViewResources().length);
				System.out.println("retrieving resources from module. . .");
				for(Resource resource : m.getViewResources()) {
					try {
						this.viewMap.put(resource.getURL().toString(), resource.getURL().toString());
						System.out.println("resource added to view map: " + resource.getURL().toString());
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				System.out.println("view map is succesfully built");
				break;
			}
		}
		if(!found) {
			System.out.println("corresponding module not found");
		}
	}
	
	@Override
	protected AbstractUrlBasedView buildView(String viewName) throws Exception {
		InternalResourceView view = (InternalResourceView) super.buildView(viewName);
		this.buildViewMap();
		return view;
	}

}
