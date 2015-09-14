package com.sia.main.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sia.main.service.services.StatusPluginService;

@Controller
@RequestMapping(value = "/admin/modulePluginStatus")
public class OSGIBundleStatusController {

	@Autowired
	private StatusPluginService statusPluginService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView viewModulePluginStatus() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("statusPluginList", this.statusPluginService.getAll());
		modelAndView.setViewName("StatusPlugin.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value = "/refresh", method = RequestMethod.POST)
	public ModelAndView refreshStatus(@RequestParam("refresh") String refresh) {
		ModelAndView modelAndView = new ModelAndView();
		this.statusPluginService.refreshFrameworkStatusList();
		modelAndView.setViewName("redirect:/admin/modulePluginStatus/");
		return modelAndView;
	}
	
}