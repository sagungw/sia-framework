package com.sia.main.web.controllers;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sia.main.domain.Menu;
import com.sia.main.domain.MenuPeran;
import com.sia.main.domain.Modul;
import com.sia.main.domain.Peran;
import com.sia.main.service.services.MenuPeranService;
import com.sia.main.service.services.MenuService;
import com.sia.main.service.services.ModulService;
import com.sia.main.service.services.PeranService;
import com.sia.main.service.services.StatusPluginService;
import com.sia.main.web.model.RoleMenu;
import com.sia.main.web.model.Response;

@Controller
@RequestMapping(value = "/admin/module")
public class ModuleController {
	
	@Autowired
	private PeranService peranService;
	
	@Autowired
	private ModulService modulService;
	
	@Autowired
	private MenuService menuService;
	
	@Autowired
	private MenuPeranService menuPeranService;
	
	@Autowired
	private StatusPluginService statusPluginService;
	
	private static String success = "success";
	
	private static String existed = "existed";
	
	private static String exception = "exception";
	
	@RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
	public ModelAndView mainPage(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		if(session.getAttribute("uploadWizardDone") != null) {
			modelAndView.addObject("uploadWizardDone", (Response)session.getAttribute("uploadWizardDone"));
			session.removeAttribute("uploadWizardDone");
		}
		modelAndView.addObject("moduleList", modulService.getAll());
		modelAndView.setViewName("PengelolaanModul");
		return modelAndView;
	}
	
	@RequestMapping(value = "/uploadWizard/1", method = RequestMethod.GET)
	public ModelAndView uploadWizard1(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		if(session.getAttribute("uploadFailed") != null) {
			modelAndView.addObject("uploadFailed", (Response)session.getAttribute("uploadFailed"));
			session.removeAttribute("uploadFailed");
		}
		modelAndView.setViewName("TambahModul1");
		return modelAndView;
	}
	
	@RequestMapping(value = "/uploadWizard/1/upload", method = RequestMethod.POST)
	public ModelAndView uploadModule(@RequestParam("file") Object file, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		Bundle hostBundle = FrameworkUtil.getBundle(this.getClass());
		Modul modul = this.modulService.installModule(file, hostBundle);
		if(modul != null) {
			session.setAttribute("moduleOnWizard", modul);
			modelAndView.setViewName("redirect:/admin/module/uploadWizard/2");
		} else {
			Response response = new Response(exception, "Modul gagal ditambahkan", null);
			session.setAttribute("uploadFailed", response);
			modelAndView.setViewName("redirect:/admin/module/uploadWizard/1");
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "/uploadWizard/2",  method = RequestMethod.GET)
	public ModelAndView uploadWizard2(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		Modul modul = (Modul)session.getAttribute("moduleOnWizard");
		List<Peran> roles = peranService.getAll();
		modelAndView.addObject("roles", roles);
		modelAndView.addObject("menus", modul.getMenus());
		modelAndView.setViewName("TambahModul2");
		return modelAndView;
	}
	
	@RequestMapping(value = "/uploadWizard/2/submit",  method = RequestMethod.POST)
	@ResponseBody
	public Response saveMenus(@RequestBody RoleMenu[] roleMenus) {
		MenuPeran result = null;
		for(RoleMenu roleMenu: roleMenus) {
			for (String menuId : roleMenu.getRoleMenus()) {
				Menu menu = this.menuService.getById(UUID.fromString(menuId));
				Peran peran = this.peranService.getById(UUID.fromString(roleMenu.getRoleId()));
				MenuPeran menuPeran = new MenuPeran(null, peran, menu);
				result = this.menuPeranService.insertInto(menuPeran);
				if(result == null) {
					break;
				}
			}
			if(result == null) {
				break;
			}
		}
		if(result != null) {
			return new Response(success, "hak akses menu berhasil ditambah", success); 
		} else {
			return new Response(existed, "hak akses menu gagal ditambah", null);
		}
		
	}
	
	@RequestMapping(value = "/uploadWizard/3", method = RequestMethod.GET)
	public ModelAndView uploadWizard3(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		Modul modul = (Modul) session.getAttribute("moduleOnWizard");
		modelAndView.addObject("modul", modul);
		modelAndView.setViewName("TambahModul3");
		return modelAndView;
	}
	
	@RequestMapping(value = "/uploadWizard/3/end", method = RequestMethod.POST)
	public ModelAndView uploadWizardEnd(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		session.setAttribute("uploadWizardDone", new Response(success, "Modul berhasil ditambah", null));
		session.removeAttribute("moduleOnWizard");
		modelAndView.setViewName("redirect:/admin/module/");
		return modelAndView;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public @ResponseBody Response deleteModule(@RequestParam("idModul") String idModul) {
		Modul modul = modulService.getById(UUID.fromString(idModul));
		Response response = null;
		if(this.modulService.uninstallModule(modul) != null) {
			response = new Response(success, "Modul berhasil dihapus", null);
		} else {
			response = new Response(exception, "Modul gagal dihapus", null);
		}
		return response;
	}
	
}
