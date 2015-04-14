package com.sia.main.web.controllers;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sia.main.web.SomeGlobalClass;

@Controller
@RequestMapping(value = "/home")
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(HttpSession session) {
		logger.info(SomeGlobalClass.aGlobalVariable.getString());
		ModelAndView modelAndView = new ModelAndView();
		if(session.getAttribute("userSession") == null) {
			modelAndView.setViewName("redirect:/login/");
		} else {
			modelAndView.setViewName("home");
		}
		return modelAndView;
	}
	
}
