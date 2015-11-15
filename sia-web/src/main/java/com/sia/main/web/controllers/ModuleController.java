package com.sia.main.web.controllers;

import java.io.IOException;
import java.util.ArrayList;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sia.main.domain.Menu;
import com.sia.main.domain.MenuPeran;
import com.sia.main.domain.Modul;
import com.sia.main.domain.Peran;
import com.sia.main.plugin.common.Response;
import com.sia.main.service.services.MenuPeranService;
import com.sia.main.service.services.MenuService;
import com.sia.main.service.services.ModulService;
import com.sia.main.service.services.PeranService;
import com.sia.main.web.json_model.RoleMenu;

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
		Response response = this.modulService.installModule(file, hostBundle);
		if(response.getData() != null) {
			session.setAttribute("moduleOnWizard", (Modul)response.getData());
			modelAndView.setViewName("redirect:/admin/module/uploadWizard/2");
		} else {
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
		List<RoleMenu> roleMenus = new ArrayList<RoleMenu>();
		for(Peran role: roles) {
			RoleMenu roleMenu = new RoleMenu();
			List<String> temp = new ArrayList<String>(); 
			for(MenuPeran menuPeran: role.getMenuPeranList()) {
				temp.add(menuPeran.getMenu().getIdMenu().toString());
			}
			roleMenu.setRoleId(role.getIdPeran().toString());
			roleMenu.setRoleMenus(temp.toArray(new String[temp.size()]));
			roleMenus.add(roleMenu);
		}
		modelAndView.addObject("roleMenus", roleMenus);
		modelAndView.setViewName("TambahModul2");
		return modelAndView;
	}
	
	@RequestMapping(value = "/uploadWizard/2/submit",  method = RequestMethod.POST)
	@ResponseBody
	public Response saveMenus(@RequestBody RoleMenu[] roleMenus, HttpSession session) {
		Modul modul = (Modul)session.getAttribute("moduleOnWizard");
		for(Menu menu: modul.getMenus()) {
			for(MenuPeran menuPeran: menu.getDaftarMenuPeran()) {
				this.menuPeranService.delete(menuPeran);
			}
		}
		List<MenuPeran> failures = new ArrayList<MenuPeran>();
		for(RoleMenu roleMenu: roleMenus) {
			Peran peran = this.peranService.getById(UUID.fromString(roleMenu.getRoleId()));
			for (String menuId : roleMenu.getRoleMenus()) {
				Menu menu = this.menuService.getById(UUID.fromString(menuId));
				MenuPeran menuPeran = new MenuPeran(null, peran, menu);
				MenuPeran result = (MenuPeran)this.menuPeranService.insertInto(menuPeran).getData();
				if(result == null)
					failures.add(menuPeran);
			}
		}
		session.setAttribute("moduleOnWizard", this.modulService.getById(modul.getIdModul()));
		if(failures.size() > 0) {
			StringBuilder sb = new StringBuilder();
			sb.append("Penambahan gagal pada: \n");
			for(MenuPeran menuPeran: failures) {
				sb.append("- Hak akses peran " + menuPeran.getPeran() + " untuk menu " + menuPeran.getMenu() + ".\n");
			}
			return new Response(Response.error, sb.toString(), null);
		} else {
			return new Response(Response.ok, "Penambahan hak akses menu pada peran berhasil.", null);
		}
	}
	
	@RequestMapping(value = "/uploadWizard/3", method = RequestMethod.GET)
	public ModelAndView uploadWizard3(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		if(session.getAttribute("uploadImageFailed") != null) {
			modelAndView.addObject("uploadImageFailed", (Response)session.getAttribute("uploadImageFailed"));
			session.removeAttribute("uploadImageFailed");
		}
		modelAndView.setViewName("TambahModul3");
		return modelAndView;
	}
	
	@RequestMapping(value = "/uploadWizard/3/submit", method = RequestMethod.POST)
	public ModelAndView saveImageAndIcon(@RequestParam("imageFile") Object imageFile, @RequestParam("iconName") String iconName, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		Modul module = (Modul)session.getAttribute("moduleOnWizard");
		MultipartFile file = (MultipartFile)imageFile;
		
		if(file.getSize() <= 2097152) {
			try {
				module.setGambar(file.getBytes());
				module.setNamaIconTemplate(iconName);
				this.modulService.update(module);
				modelAndView.setViewName("redirect:/admin/module/uploadWizard/4");
			} catch (IOException e) {
				session.setAttribute("uploadImageFailed", new Response(Response.error, "Peunggahan gambar gagal. Pesan Exception: " + e.getMessage(), null));
				modelAndView.setViewName("redirect:/admin/module/uploadWizard/3");
				e.printStackTrace();
			}
		} else {
			session.setAttribute("uploadImageFailed", new Response(Response.error, "Peunggahan gambar gagal. Ukuran gambar tidak boleh melebihi 2MB", null));
			modelAndView.setViewName("redirect:/admin/module/uploadWizard/3");
		}
		return modelAndView;
	}
	
	
	@RequestMapping(value = "/uploadWizard/4", method = RequestMethod.GET)
	public ModelAndView uploadWizard4(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		Modul modul = (Modul) session.getAttribute("moduleOnWizard");
		modelAndView.addObject("modul", modul);
		modelAndView.setViewName("TambahModul4");
		return modelAndView;
	}
	
	@RequestMapping(value = "/uploadWizard/4/end", method = RequestMethod.POST)
	public ModelAndView uploadWizardEnd(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		session.setAttribute("uploadWizardDone", new Response(Response.ok, "Modul berhasil ditambah", null));
		session.removeAttribute("moduleOnWizard");
		modelAndView.setViewName("redirect:/admin/module/");
		return modelAndView;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public @ResponseBody Response deleteModule(@RequestParam("idModul") String idModul) {
		Modul modul = modulService.getById(UUID.fromString(idModul));
		return this.modulService.uninstallModule(modul);
	}
	
}
