package com.sia.main.web.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sia.main.service.services.ModulService;

@Controller
@RequestMapping(value = "/admin/modul")
public class ModuleController {
	
	@Autowired
	private ModulService modulService;
	
	@RequestMapping(value = "/")
	public ModelAndView mainPage(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("PengelolaanModul");
		modelAndView.addObject("moduleList", modulService.getAll());
		return modelAndView;
	}
	
}
