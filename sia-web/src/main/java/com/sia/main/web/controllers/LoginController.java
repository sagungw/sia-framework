package com.sia.main.web.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sia.main.domain.Pengguna;
import com.sia.main.service.services.PenggunaService;

@Controller
@RequestMapping(value = "/account")
public class LoginController {

	private PenggunaService penggunaService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		if (session.getAttribute("userSession") == null) {
			modelAndView.setViewName("login");
		} else {
			modelAndView.setViewName("redirect:/home/");
		}
		return modelAndView;
	}

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ModelAndView authenticate(HttpSession session, String username,
			String password) {
		ModelAndView modelAndView = new ModelAndView();

		Pengguna pengguna = penggunaService.getPenggunaByUsername(username);
		if (pengguna != null && pengguna.getPassword().equals(password)) {
			session.setAttribute("userSession", pengguna);
			modelAndView.setViewName("redirect:/home/");
		} else {
			session.setAttribute("loginSuccess", "false");
			modelAndView.setViewName("redirect:/account/login");
		}
		return modelAndView;
	}

}
