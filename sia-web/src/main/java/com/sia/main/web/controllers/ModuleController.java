package com.sia.main.web.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;
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
import com.sia.main.domain.StatusPlugin;
import com.sia.main.plugin.modul.Module;
import com.sia.main.plugin.modul.StandardMenu;
import com.sia.main.plugin.modul.StandardModule;
import com.sia.main.service.services.MenuPeranService;
import com.sia.main.service.services.MenuService;
import com.sia.main.service.services.ModulService;
import com.sia.main.service.services.PeranService;
import com.sia.main.service.services.StatusPluginService;
import com.sia.main.web.ModuleManager;
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
	
	private static String installedModuleLocation = "D://Agung//Dokumen//Data Kuliah//Kuliah dan Tugas//Project//Tugas Akhir//siaframework-installedmodules//installed";
	
	private static String temporaryModuleLocation = "D://Agung//Dokumen//Data Kuliah//Kuliah dan Tugas//Project//Tugas Akhir//siaframework-installedmodules//temp";
	
	private static String success = "success";
	
	private static String existed = "existed";
	
	private static String exception = "exception";
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView mainPage(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		session.removeAttribute("moduleOnWizard");
		modelAndView.setViewName("PengelolaanModul");
		List<Modul> modules = modulService.getAll();
		modelAndView.addObject("moduleList", modulService.getAll());
		return modelAndView;
	}
	
	@RequestMapping(value = "/uploadWizard/1", method = RequestMethod.GET)
	public ModelAndView uploadWizard1() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("TambahModul1");
		return modelAndView;
	}
	
	@RequestMapping(value = "/uploadWizard/1/upload", method = RequestMethod.POST)
	public ModelAndView uploadModule(@RequestParam("file") Object file, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		MultipartFile multipartFile = (MultipartFile) file;
		Response response = null;
		try {
//			File tempFile = this.getFile(temporaryModuleLocation, multipartFile.getOriginalFilename());
//			byte[] bytes = multipartFile.getBytes();
//			BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(tempFile));
//			outputStream.write(bytes);
//			outputStream.close();
//			
//			Modul modul = this.installModule(tempFile.getAbsolutePath());
//			if(modul != null) { 
//				File installedFile = this.getFile(installedModuleLocation, multipartFile.getOriginalFilename());
//				outputStream = new BufferedOutputStream(new FileOutputStream(installedFile));
//				outputStream.write(bytes);
//				outputStream.close();
//				response = success;
//				response.setData(modul);
//			} else {
//				response = existed;
//			}
//			Files.deleteIfExists(tempFile.toPath());
			List<com.sia.main.plugin.modul.Menu> menus = new ArrayList<com.sia.main.plugin.modul.Menu>();
			menus.add(new StandardMenu("test1", "/test1/", "/test1/*"));
			menus.add(new StandardMenu("test2", "/test2/", "/test2/*"));
			menus.add(new StandardMenu("test3", "/test3/", "/test3/*"));
			Module module = new StandardModule("", "1.0", menus, "test", "/test/", "/META-INF/spring/module-test-servlet.xml", "WEB-INF/views/");
			StatusPlugin statusPlugin = this.statusPluginService.getByParam("where namaStatus = 'STARTED'").get(0);
			Modul modul = new Modul();
			modul.setIdModul(UUID.randomUUID());
			modul.setNamaModul(module.getModuleName());
			modul.setUrlMapping(module.getUrlMapping());
			modul.setVersi(module.getPluginVersion());
			modul.setLokasiKonfigurasiServlet(module.getServletConfigurationPath());
			modul.setStatus(statusPlugin);
			List<Menu> menuList = new ArrayList<Menu>();
			for(com.sia.main.plugin.modul.Menu i : module.getMenus()) {
				Menu menu = new Menu();
				menu.setIdMenu(UUID.randomUUID());
				menu.setNamaMenu(i.getMenuName());
				menu.setHomeUrl(i.getUrl());
				menu.setUrlPattern(i.getUrlPattern());
				menu.setModul(modul);
				menuList.add(menu);
			}
			modul.setMenus(menuList);
			session.setAttribute("moduleOnWizard", modul);
			response = new Response(success, "modul berhasil ditambah", null);
			response.setData(modul);
		} catch (NullPointerException e) {
			response = new Response(exception, "modul gagal ditambah", null);
			e.printStackTrace();
		} catch (Exception e) {
			response = new Response(exception, "modul gagal ditambah", null);
			e.printStackTrace();
		}
		modelAndView.setViewName("redirect:/admin/module/uploadWizard/2");
		return modelAndView;
	}
	
	@RequestMapping(value = "/uploadWizard/2",  method = RequestMethod.GET)
	public ModelAndView uploadWizard2(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		Modul modul = (Modul)session.getAttribute("moduleOnWizard");
		if(modul != null) {
			List<Peran> roles = peranService.getAll();
			modelAndView.addObject("roles", roles);
			modelAndView.addObject("menus", modul.getMenus());
			modelAndView.setViewName("TambahModul2");
		} else {
			System.out.println("modul null");
			modelAndView.setViewName("redirect:/admin/module/uploadWizard/1");
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "/uploadWizard/2/submit",  method = RequestMethod.POST)
	public @ResponseBody Response saveMenus(@RequestBody RoleMenu roleMenu) {
		MenuPeran result = null;
		for (String menuId : roleMenu.getRoleMenus()) {
			Menu menu = menuService.getById(UUID.fromString(menuId));
			Peran peran = peranService.getById(UUID.fromString(roleMenu.getRoleId()));
			MenuPeran menuPeran = new MenuPeran(null, peran, menu);
			result = menuPeranService.insertInto(menuPeran);
			if(result == null) {
				break;
			}
		}
		if(result != null) {
			return new Response(success, "hak akses menu berhasil ditambah", result); 
		} else {
			return new Response(existed, "hak akses menu gagal ditambah", result);
		}
	}
	
	@RequestMapping(value = "/uploadWizard/3", method = RequestMethod.GET)
	public ModelAndView uploadWizard3(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		Modul modul = (Modul) session.getAttribute("moduleOnWizard");
		if(modul != null) {
			modelAndView.addObject("modul", modul);
			modelAndView.setViewName("TambahModul3");
		} else {
			modelAndView.setViewName("redirect:/admin/module/uploadWizard/1");
		}
		
		return modelAndView;
	}
	
	private File getFile(String path, String fileName) {
		File directory = new File(path + File.separator);
		if(!directory.exists())
			directory.mkdirs();
		File file = new File(directory.getAbsoluteFile() + File.separator + fileName);
		return file;
	}
	
	private Modul installModule(String filePath) {
		Modul res = null;
		BundleContext bundleContext = FrameworkUtil.getBundle(this.getClass()).getBundleContext();
		filePath = "file:" + filePath;
		try {
			Bundle bundle = bundleContext.installBundle(filePath);
			bundle.start();
			ServiceReference reference =  bundle.getRegisteredServices()[0];
			Module module = (Module)bundleContext.getService(reference);
			StatusPlugin statusPlugin = this.statusPluginService.getByParam("where namaStatus = 'STARTED'").get(0);
			Modul modul = new Modul();
			modul.setNamaModul(module.getModuleName());
			modul.setUrlMapping(module.getUrlMapping());
			modul.setVersi(module.getPluginVersion());
			modul.setLokasiKonfigurasiServlet(module.getServletConfigurationPath());
			modul.setStatus(statusPlugin);
			res = this.modulService.insertInto(modul);
			if(res != null) {
				for(com.sia.main.plugin.modul.Menu i : module.getMenus()) {
					Menu menu = new Menu();
					menu.setNamaMenu(i.getMenuName());
					menu.setHomeUrl(i.getUrl());
					menu.setUrlPattern(i.getUrlPattern());
					menu.setModul(res);
					this.menuService.insertInto(menu);
				}
			} else {
				bundle.stop();
			}
		} catch (BundleException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public @ResponseBody Response deleteModule(@RequestParam("idModul") String idModul) {
		Modul modul = modulService.getById(UUID.fromString(idModul));
		Response response = null;
		try {
			BundleContext bundleContext = FrameworkUtil.getBundle(this.getClass()).getBundleContext();
			Bundle bundle = bundleContext.getBundle(modul.getOsgiBundleId());
			ServiceReference reference =  bundle.getRegisteredServices()[0];
			Module module = (Module)bundleContext.getService(reference);
			bundle.uninstall();
			ModuleManager moduleManager = ModuleManager.getInstance();
			moduleManager.removeModule(module.getModuleName());
			modulService.delete(modul);
			response = new Response("Ok", "Modul berhasil dihapus", null);
		} catch (BundleException e) {
			response = new Response("Fail", "Modul gagal dihapus", null);
			e.printStackTrace();
		}
		return response;
	}
	
}
