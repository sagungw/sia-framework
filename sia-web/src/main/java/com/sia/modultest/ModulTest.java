package com.sia.modultest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.sia.main.plugin.modul.HasMenu;
import com.sia.main.plugin.modul.Module;
import com.sia.main.plugin.modul.ModuleMenu;
import com.sia.modultest.menu.MenuLain;
import com.sia.modultest.menu.MenuUtama;

public class ModulTest extends Module implements HasMenu {

	public ModulTest() {
		this.moduleName = "moduletest";
		this.servletName = "testServlet";
		this.urlMapping = "/moduletest/*";
	}
	
	@Override
	public Boolean getHasMenuStatus() {
		return true;
	}

	@Override
	public List<ModuleMenu> getModuleMenu() {
		List<ModuleMenu> menus = new ArrayList<ModuleMenu>();
		menus.add(new MenuUtama());
		menus.add(new MenuLain());
		return menus;
	}

	@Override
	public DispatcherServlet buildServlet() {
		XmlWebApplicationContext webApplicationContext = new XmlWebApplicationContext();
		webApplicationContext
				.setConfigLocation("/WEB-INF/spring/appServlet/testservlet.xml");
		this.servlet = new DispatcherServlet(webApplicationContext);
		return this.servlet;
	}

	@Override
	public DispatcherServlet buildServlet(
			WebApplicationContext webApplicationContext) {
		this.servlet = new DispatcherServlet(webApplicationContext);
		return this.servlet;
	}

}
