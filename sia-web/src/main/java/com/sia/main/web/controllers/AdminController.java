package com.sia.main.web.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sia.main.domain.Pengguna;
import com.sia.main.service.services.GenericService;
import com.sia.main.service.services.ModulService;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
	
	private static String defaultHomePage = "/admin/dashboard";  
	
	private String homePage; 
	
	@Autowired
	private ModulService modulService;
	
	@Autowired
	private GenericService<Pengguna> penggunaService;
	
	public String getHomePage() {
		return this.homePage != null ? this.homePage : AdminController.defaultHomePage;
	}

	public void setHomePage(String homePage) {
		this.homePage = homePage;
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:" + this.getHomePage());
		return modelAndView;
	}
	
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public ModelAndView viewDashboard(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("installedModules", this.modulService.getAll());
		modelAndView.setViewName("Dashboard");
		return modelAndView;
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public void test() {
		penggunaService.insert(null);
		penggunaService.update(null);
		penggunaService.delete(null);
		penggunaService.getById(null);
		penggunaService.getAll();
		penggunaService.getByParam("");
	}
	
}
