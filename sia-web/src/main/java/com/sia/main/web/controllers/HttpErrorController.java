package com.sia.main.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/error")
public class HttpErrorController {

	@RequestMapping(value = "/404", method = RequestMethod.GET)
	public ModelAndView error404() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("404");
		return modelAndView;
	}
	
	@RequestMapping(value = "/401", method = RequestMethod.GET)
	public ModelAndView error401() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("401");
		return modelAndView;
	}
	
}
