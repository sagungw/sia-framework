package com.sia.main.web.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.util.UUID;

import javax.servlet.http.HttpSession;

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

import com.sia.main.domain.Modul;
import com.sia.main.plugin.modul.Module;
import com.sia.main.service.services.ModulService;
import com.sia.main.web.AjaxResponse;

@Controller
@RequestMapping(value = "/admin/modul")
public class ModuleController {
	
	@Autowired
	private ModulService modulService;
	
	private static BundleContext bundleContext;
	
	private static String installedModuleLocation = "C://SIA-Modul//installed";
	
	private static String temporaryModuleLocation = "C://SIA-Modul//temp";
	
	private AjaxResponse response = null;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView mainPage(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("PengelolaanModul");
		modelAndView.addObject("moduleList", modulService.getAll());
		if(this.response!=null)
			modelAndView.addObject("commandResult", this.response);
		return modelAndView;
	}
	
	@RequestMapping(value = "/unggahModul", method = RequestMethod.POST)
	public ModelAndView uploadModule(@RequestParam("file") Object file) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/admin/modul/");
		MultipartFile multipartFile = (MultipartFile) file;
		if(multipartFile != null) {
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
					System.out.println("ok");
					response = new AjaxResponse("Ok", "Modul berhasil ditambah", null);
				} else {
					System.out.println("fail1");
					response = new AjaxResponse("Fail", "Modul gagal ditambah", null);
				}
				Files.deleteIfExists(tempFile.toPath());
			} catch (Exception e) {
				System.out.println("fail2");
				response = new AjaxResponse("Fail", "Modul gagal ditambah", null);
				e.printStackTrace();
			}
		} else {	
			System.out.println("fail3");
			response = new AjaxResponse("Fail", "Modul gagal ditambah", null);
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
			ServiceReference rf = bundle.getRegisteredServices()[0];
			Module module = (Module)bundleContext.getService(rf);
			System.out.println(module.getModuleName());
			Modul modul = new Modul();
			modul.setNamaModul(module.getModuleName());
			modul.setStatus(bundle.getState());
			modul.setUrlMapping(module.getUrlMapping());
			modul.setVersi(bundle.getVersion().toString());
			res = modulService.insertInto(modul);
			if(res == null) {
				bundle.uninstall();
			}
		} catch (BundleException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	@RequestMapping(value = "/hapusModul", method = RequestMethod.POST)
	public ModelAndView deleteModule(@RequestParam("idModul") String idModul) {
		ModelAndView modelAndView = new ModelAndView();
		
		return modelAndView;
	}
	
}
