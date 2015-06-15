package com.sia.main.web.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sia.main.domain.MenuPeran;
import com.sia.main.domain.Modul;
import com.sia.main.domain.Peran;
import com.sia.main.service.services.MenuPeranService;
import com.sia.main.service.services.ModulService;

@Controller
@RequestMapping(value = "/")
public class HomeController {

	@Autowired
	private MenuPeranService menuPeranService;
	
	@Autowired
	private ModulService modulService;
	
	@RequestMapping(value = "pilihModul", method = RequestMethod.GET)
	public ModelAndView showModule(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		if(session.getAttribute("userSession") == null) {
			modelAndView.setViewName("redirect:/account/login");
		}
		Peran peran = (Peran) session.getAttribute("roleSession");
		List<MenuPeran> roleMenus = this.menuPeranService.getByParam("where peran.idPeran = '" + peran.getIdPeran() + "'");
		List<Modul> moduleList = new ArrayList<Modul>();
		Map<Modul, Integer> map = new HashMap<>();
		
		for(MenuPeran menuPeran : roleMenus) {
			map.put(menuPeran.getMenu().getModul(), 0);
		}
		
		for (Map.Entry<Modul, Integer> entry : map.entrySet()) {
			moduleList.add(entry.getKey());
		}
		
		session.setAttribute("menuListSession", roleMenus);
		session.setAttribute("moduleListSession", moduleList);
		if(moduleList.size() > 1) {
			modelAndView.addObject("moduleList", moduleList);
			modelAndView.setViewName("PilihModul");
		} else {
			session.setAttribute("moduleSession", moduleList.get(0));
			modelAndView.setViewName("redirect:/account/login");                 //-----------> PERLU GANTI
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "pilihModul/", method = RequestMethod.POST)
	public ModelAndView chooseModule(HttpSession session, @RequestParam("idModul") UUID idModul) {
		ModelAndView modelAndView = new ModelAndView();
		Modul modul = this.modulService.getById(idModul);
		session.setAttribute("moduleSession", modul);
		modelAndView.setViewName("redirect:/account/login");    
		return modelAndView;
	}
	
}
