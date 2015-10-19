package com.sia.main.web.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sia.main.domain.Pengguna;
import com.sia.main.plugin.modul.Module;
import com.sia.main.plugin.modul.impl.PackageBasedModule;
import com.sia.main.service.module.ModuleManager;
import com.sia.main.service.services.ModulService;
import com.sia.main.service.services.PenggunaService;

@Controller
public class HomeController {

	@Autowired
	private ModulService moduleService;
	
	@Autowired
	private PenggunaService penggunaService;
	
	@Autowired
	private ModuleManager moduleManager;
	
	@RequestMapping(value = {"/home", "/"}, method = RequestMethod.GET)
	public ModelAndView home(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		String id = "e65d4bfc-e3a5-4855-8041-6e149250ef04";
		Pengguna pengguna = this.penggunaService.getById(UUID.fromString(id));
		session.setAttribute("userSession", pengguna);
		
		System.out.println("modules from moduleManager:");
		for(Module module: this.moduleManager.getModules()) {
			System.out.println(module.getModuleName());
		} 
		
		System.out.println("modules from moduleManager in moduleService:");
		for(Module module: this.moduleService.getModules()) {
			System.out.println(module.getModuleName());
		} 
		
		modelAndView.setViewName("Welcome");
		return modelAndView;
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.POST)
	public ModelAndView test(@RequestParam("name") String moduleName, @RequestParam("version") String moduleVersion, @RequestParam("package") String packages) {
		ModelAndView modelAndView = new ModelAndView();
		
		List<String> basePackages = new ArrayList<String>();
		basePackages.add(packages);
		
		Module module = new PackageBasedModule(moduleName, moduleVersion, moduleName, null, basePackages);
		this.moduleService.addModule(module);
		
		modelAndView.setViewName("redirect:/home");
		return modelAndView;
	}
	
}
