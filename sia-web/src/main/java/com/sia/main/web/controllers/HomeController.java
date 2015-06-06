package com.sia.main.web.controllers;

import javax.servlet.http.HttpSession;

import org.eclipse.gemini.blueprint.context.BundleContextAware;
import org.osgi.framework.BundleContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import com.sia.main.plugin.modul.Module;
import com.sia.main.web.ModuleManager;

@Controller
@RequestMapping(value = "/home")
public class HomeController {
	
	@Autowired
	private ModuleManager moduleManager;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		if (session.getAttribute("userSession") == null) {
			modelAndView.setViewName("redirect:/account/login");
		} else {
			session.setAttribute("modules", moduleManager.getModules());
			modelAndView.setViewName("Home");
		}
		return modelAndView;
	}

}
