package com.sia.main.web.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sia.main.domain.Pengguna;
import com.sia.main.service.services.PenggunaService;

@Controller
@RequestMapping(value = "/account")
public class LoginController {
	
	@Autowired
	private PenggunaService penggunaService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		if (session.getAttribute("userSession") == null) {
			modelAndView.setViewName("Login");
		} else {
			modelAndView.setViewName("redirect:/home/");
		}
		return modelAndView;
	}

	@RequestMapping(value = "/login/error", method = RequestMethod.GET)
	public ModelAndView loginFalse(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		if (session.getAttribute("userSession") == null) {
			boolean status = false;
			modelAndView.addObject("status", status);
			modelAndView.setViewName("Login");
		} else {
			modelAndView.setViewName("redirect:/home/");
		}
		return modelAndView;
	}

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ModelAndView authenticate(HttpSession session, String username, String password) {
		ModelAndView modelAndView = new ModelAndView();
		List<Pengguna> penggunaList = penggunaService.getByParam("where username = '" + username + "' and statusKeaktifan = true"); 
		Pengguna pengguna = penggunaList.size() > 0 ? penggunaList.get(0) : null;
		if (pengguna != null && pengguna.getPassword().equals(password)) {
			session.setAttribute("userSession", pengguna);
			modelAndView.setViewName("redirect:/session/chooseUserRole");
		} else {
			modelAndView.setViewName("redirect:/account/login/error");
		}
		return modelAndView;
	}

}
