package com.sia.main.web.controllers;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Enumeration;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sia.main.domain.Pengguna;
import com.sia.main.service.services.ModulService;
import com.sia.main.service.services.PenggunaService;

@Controller
public class HomeController {

	@Autowired
	private ModulService moduleService;
	
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
	
	@RequestMapping(value = {"/asdf"}, method = RequestMethod.GET)
	public ModelAndView asdf(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		Bundle bundle = FrameworkUtil.getBundle(this.getClass());
		URL url = bundle.getResource("/module-detail/module-com.sia.main.web-addition.xml");
		System.out.println("File found: " + url.getFile());
		String url2 = url.getFile().replace("file:/", "");
			File file = new File(url2);
			System.out.println("abs: " + file.getAbsolutePath());
			System.out.println("p: " + file.getPath());
			try {
				System.out.println("can: " + file.getCanonicalPath());
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		modelAndView.setViewName("Welcome");
		return modelAndView;
	}
	
}
