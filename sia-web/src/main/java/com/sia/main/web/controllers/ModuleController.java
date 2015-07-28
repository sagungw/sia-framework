package com.sia.main.web.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.util.UUID;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sia.main.domain.Menu;
import com.sia.main.domain.Modul;
import com.sia.main.domain.StatusPlugin;
import com.sia.main.plugin.modul.Module;
import com.sia.main.service.services.MenuService;
import com.sia.main.service.services.ModulService;
import com.sia.main.service.services.StatusPluginService;
import com.sia.main.web.utils.AjaxResponse;

@Controller
@RequestMapping(value = "/admin/module")
public class ModuleController {
	
	@Autowired
	private ModulService modulService;
	
	@Autowired
	private MenuService menuService;
	
	@Autowired
	private StatusPluginService statusPluginService;
	
	private static BundleContext bundleContext;
	
	private static String installedModuleLocation = "D://Agung//Dokumen//Data Kuliah//Kuliah dan Tugas//Project//Tugas Akhir//siaframework-installedmodules//installed";
	
	private static String temporaryModuleLocation = "D://Agung//Dokumen//Data Kuliah//Kuliah dan Tugas//Project//Tugas Akhir//siaframework-installedmodules//temp";
	
	private static AjaxResponse exception = new AjaxResponse("exception", "Java Exception caught upon uploading", null);
	
	private static AjaxResponse existed = new AjaxResponse("existed", "url mapping sudah digunakan modul lain", null);
	
	private static AjaxResponse success = new AjaxResponse("success", "modul berhasil ditambah", null);
	
	private boolean isInUploadWizard = false;
	
	private AjaxResponse response = null;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView mainPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("PengelolaanModul");
		modelAndView.addObject("moduleList", modulService.getAll());
		return modelAndView;
	}
	
	@RequestMapping(value = "/uploadWizard/1", method = RequestMethod.GET)
	public ModelAndView uploadWizard1() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("TambahModul1");
		this.isInUploadWizard = true;
		if(response != null) {
			modelAndView.addObject("response", response);
			if(response.getData() != null) {
				modelAndView.addObject("modul", (Modul)response.getData());
			}
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "/uploadWizard/1/upload", method = RequestMethod.POST)
	public ModelAndView uploadModule(@RequestParam("file") Object file) {
		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.setViewName("redirect:/uploadWizard/1");
		MultipartFile multipartFile = (MultipartFile) file;
		try {
			File tempFile = this.getFile(temporaryModuleLocation, multipartFile.getOriginalFilename());
			byte[] bytes = multipartFile.getBytes();
			BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(tempFile));
			outputStream.write(bytes);
			outputStream.close();
			
			Modul modul = this.installModule(tempFile.getAbsolutePath());
			if(modul != null) { 
				File installedFile = this.getFile(installedModuleLocation, multipartFile.getOriginalFilename());
				outputStream = new BufferedOutputStream(new FileOutputStream(installedFile));
				outputStream.write(bytes);
				outputStream.close();
				response = success;
				response.setData(modul);
			} else {
				response = existed;
			}
			Files.deleteIfExists(tempFile.toPath());
		} catch (NullPointerException e) {
			response = exception;
			e.printStackTrace();
		} catch (Exception e) {
			response = exception;
			e.printStackTrace();
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
		bundleContext = FrameworkUtil.getBundle(this.getClass()).getBundleContext();
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
	
	@RequestMapping(value = "/hapusModul", method = RequestMethod.POST)
	public ModelAndView deleteModule(@RequestParam("idModul") UUID idModul) {
		System.out.println(idModul);
		ModelAndView modelAndView = new ModelAndView();
//		Modul modul = modulService.getById(idModul);
//		try {
//			Bundle bundle = bundleContext.getBundle(modul.getIdBundle());
//			bundle.uninstall();
//			modulService.delete(modul);
//			response = new AjaxResponse("Ok", "Modul berhasil dihapus", null);
//		} catch (BundleException e) {
//			response = new AjaxResponse("Fail", "Modul gagal dihapus", null);
//			e.printStackTrace();
//		}
		modelAndView.setViewName("redirect:/admin/modul/");
		return modelAndView;
	}
	
}
