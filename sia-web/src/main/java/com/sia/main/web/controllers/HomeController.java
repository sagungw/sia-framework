package com.sia.main.web.controllers;

import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sia.main.domain.Pengguna;
import com.sia.main.service.services.PenggunaService;

@Controller
public class HomeController {
	
	@Autowired
	private PenggunaService penggunaService;
	
	@RequestMapping(value = {"/home", "/"}, method = RequestMethod.GET)
	public ModelAndView home(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		String id = "e65d4bfc-e3a5-4855-8041-6e149250ef04";
		Pengguna pengguna = this.penggunaService.getById(UUID.fromString(id));
		session.setAttribute("userSession", pengguna);
		
		modelAndView.setViewName("Welcome");
		return modelAndView;
	}
	
}
