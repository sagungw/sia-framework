package com.sia.main.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sia.main.web.jsonmodel.RoleMenu;

@Controller
@RequestMapping(value = "/example")
public class ExampleController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView view() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("example");
		return modelAndView;
	}
	
	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	public @ResponseBody String submit(@RequestBody RoleMenu roleMenu) {
		System.out.println("id: " + roleMenu.getRoleId());
		System.out.println("menu: " + roleMenu.getRoleMenus()[0]);
		System.out.println("menu: " + roleMenu.getRoleMenus()[1]);
		System.out.println("menu: " + roleMenu.getRoleMenus()[2]);
		return "success";
	}
	
}

