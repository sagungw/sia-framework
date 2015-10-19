package com.sia.main.service.services.impl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.FrameworkUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sia.main.data.dao.ModulDAO;
import com.sia.main.domain.Menu;
import com.sia.main.domain.Modul;
import com.sia.main.domain.StatusPlugin;
import com.sia.main.plugin.modul.Module;
import com.sia.main.service.module.ModuleManager;
import com.sia.main.service.module.OsgiModuleReader;
import com.sia.main.service.services.MenuService;
import com.sia.main.service.services.ModulService;
import com.sia.main.service.services.StatusPluginService;

@Service
public class ModulServiceImpl implements ModulService {

	private String installedModuleLocation;

	private String temporaryModuleLocation;
	
	private ModulDAO modulDAO;

	private StatusPluginService statusPluginService;

	private MenuService menuService;
	
	private OsgiModuleReader moduleReader;
	
	private ModuleManager moduleManager;

	public String getInstalledModuleLocation() {
		return installedModuleLocation;
	}

	public void setInstalledModuleLocation(String installedModuleLocation) {
		this.installedModuleLocation = installedModuleLocation;
	}

	public String getTemporaryModuleLocation() {
		return temporaryModuleLocation;
	}

	public void setTemporaryModuleLocation(String temporaryModuleLocation) {
		this.temporaryModuleLocation = temporaryModuleLocation;
	}

	public ModulDAO getModulDAO() {
		return modulDAO;
	}

	public void setModulDAO(ModulDAO modulDAO) {
		this.modulDAO = modulDAO;
	}

	public StatusPluginService getStatusPluginService() {
		return statusPluginService;
	}

	public void setStatusPluginService(StatusPluginService statusPluginService) {
		this.statusPluginService = statusPluginService;
	}

	public MenuService getMenuService() {
		return menuService;
	}

	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}

	public OsgiModuleReader getModuleReader() {
		return moduleReader;
	}

	public void setModuleReader(OsgiModuleReader moduleReader) {
		this.moduleReader = moduleReader;
	}

	public ModuleManager getModuleManager() {
		return moduleManager;
	}

	public void setModuleManager(ModuleManager moduleManager) {
		this.moduleManager = moduleManager;
	}

	@Override
	public Modul installModule(Object modulFile, Object hostBundleObj) {
		try {
			MultipartFile multipartFile = (MultipartFile) modulFile;
			File tempFile = this.getFile(this.temporaryModuleLocation,
					multipartFile.getOriginalFilename());
			byte[] bytes = multipartFile.getBytes();
			BufferedOutputStream outputStream = new BufferedOutputStream(
					new FileOutputStream(tempFile));
			outputStream.write(bytes);
			outputStream.close();

			Bundle hostBundle = (Bundle) hostBundleObj;
			
			Modul modul = this.saveModule(tempFile.getAbsolutePath(), hostBundle);
			if (modul != null) {
				File installedFile = this.getFile(this.installedModuleLocation,
						multipartFile.getOriginalFilename());
				outputStream = new BufferedOutputStream(new FileOutputStream(
						installedFile));
				outputStream.write(bytes);
				outputStream.close();
			} else {
				return null;
			}
			Files.deleteIfExists(tempFile.toPath());
			return modul;
		} catch (NullPointerException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private File getFile(String path, String fileName) {
		File directory = new File(path + File.separator);
		if (!directory.exists())
			directory.mkdirs();
		File file = new File(directory.getAbsoluteFile() + File.separator
				+ fileName);
		return file;
	}

	private Modul saveModule(String filePath, Bundle hostBundle) {
		Modul res = null;
		BundleContext bundleContext = FrameworkUtil.getBundle(this.getClass())
				.getBundleContext();
		filePath = "file:" + filePath;
		try {
			Bundle bundle = bundleContext.installBundle(filePath);
			Module module = this.moduleReader.readModule(bundle, hostBundle);
			StatusPlugin statusPlugin = this.statusPluginService.getByParam("where namaStatus = 'STARTED'").get(0);
			Modul modul = new Modul();
			modul.setNamaModul(module.getModuleName());
			modul.setVersi(module.getPluginVersion());
			modul.setStatus(statusPlugin);
			modul.setOsgiBundleId(String.valueOf(bundle.getBundleId()));
			res = this.insertInto(modul);
			if (res != null) {
				this.moduleManager.addModule(module);
				List<Menu> menuList = new ArrayList<Menu>(); 
				for (com.sia.main.plugin.modul.Menu i : module.getMenus()) {
					Menu menu = new Menu();
					menu.setNamaMenu(i.getMenuName());
					menu.setUrlMenu(i.getUrl());
					menu.setModul(res);
					menuList.add(menu);
					this.menuService.insertInto(menu);
				}
				res.setMenus(menuList);
			} else {
				bundle.uninstall();
			}
		} catch (BundleException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public Modul insertInto(Modul modul) {
		// Modul di-insert-into jika:
		// tidak ada modul di basis data dengan nama yang sama dengan modul yang
		// akan di-insert-into
		// dan
		// tidak ada modul di basis data dengan url mapping yang sama dengan
		// modul yang akan di-insert-into
		// Modul akan ditolak jika:
		// ada modul pada basis data dengan nama yang sama dengan modul yang
		// akan di-insert-into
		// dan
		// modul pada basis data dengan nama yang sama dengan modul yang akan
		// di-insert-into tidak memiliki url mapping yang sama dengan modul yang
		// akan di-insert-into
		// dan
		// ada modul pada basis data dengan url mapping yang sama dengan modul
		// yang akan di-insert-into
		// Modul akan di-update jika:
		// tidak memenuhi kriteria di atas

		Modul res = null;
		List<Modul> temps = this.getByParam("where namaModul = '"
				+ modul.getNamaModul() + "'");
		List<Modul> temps2 = this.getByParam("where urlMapping = '"
				+ modul.getUrlMapping() + "'");
		if ((temps != null && temps.size() > 0)
				&& (!temps.get(0).getUrlMapping().equals(modul.getUrlMapping()))
				&& (temps2 != null && temps2.size() > 0)) {
			return null;
		}
		if ((temps == null || temps.size() == 0)
				&& (temps2 == null || temps2.size() == 0)) {
			this.modulDAO.insert(modul);
			res = this.getByParam(
					"where namaModul = '" + modul.getNamaModul() + "'").get(0);
		} else {
			res = this.update(modul);
		}
		return res;
	}

	@Override
	public Modul update(Modul modul) {
		Modul toBeUpdated = this.getByParam(
				"where namaModul = '" + modul.getNamaModul() + "'").get(0);
		toBeUpdated.setNamaModul(modul.getNamaModul());
		toBeUpdated.setStatus(modul.getStatus());
		toBeUpdated.setUrlMapping(modul.getUrlMapping());
		toBeUpdated.setVersi(modul.getVersi());
		this.modulDAO.update(toBeUpdated);
		return toBeUpdated;
	}

	@Override
	public Modul uninstallModule(Modul modul) {
		try {
			BundleContext bundleContext = FrameworkUtil.getBundle(
					this.getClass()).getBundleContext();
			Bundle bundle = bundleContext.getBundle(modul.getOsgiBundleId());
			bundle.uninstall();
			this.delete(modul);
			return modul;
		} catch (BundleException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Modul delete(Modul modul) {
		this.moduleManager.removeModuleByName(modul.getNamaModul());
		this.modulDAO.delete(modul);
		return modul;
	}

	@Override
	public List<Modul> getAll() {
		return this.modulDAO.getAll();
	}

	@Override
	public Modul getById(UUID idModul) {
		return this.modulDAO.getById(idModul);
	}

	@Override
	public List<Modul> getByParam(String queryParam) {
		return this.modulDAO.getByParam(queryParam);
	}
	
	@Override
	public void addModule(Module module) {
		this.moduleManager.addModule(module);
	}
	
	@Override
	public List<Module> getModules() {
		return this.moduleManager.getModules();
	}
	
}
