package com.sia.main.service.services.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.wiring.FrameworkWiring;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sia.main.data.dao.ModulDAO;
import com.sia.main.data.dao.StatusPluginDAO;
import com.sia.main.domain.Menu;
import com.sia.main.domain.Modul;
import com.sia.main.domain.StatusPlugin;
import com.sia.main.plugin.common.Response;
import com.sia.main.service.module.OsgiModuleReader;
import com.sia.main.service.services.MenuService;
import com.sia.main.service.services.ModulService;
import com.sia.main.service.util.ModuleWriter;

@Service
public class ModulServiceImpl implements ModulService {

	private String installedModuleLocation;

	private String temporaryModuleLocation;
	
	private ModulDAO modulDAO;

	private StatusPluginDAO statusPluginDAO;

	private MenuService menuService;
	
	private OsgiModuleReader moduleReader;

	public void setInstalledModuleLocation(String installedModuleLocation) {
		this.installedModuleLocation = installedModuleLocation;
	}

	public void setTemporaryModuleLocation(String temporaryModuleLocation) {
		this.temporaryModuleLocation = temporaryModuleLocation;
	}

	public void setModulDAO(ModulDAO modulDAO) {
		this.modulDAO = modulDAO;
	}

	public void setStatusPluginDAO(StatusPluginDAO statusPluginDAO) {
		this.statusPluginDAO = statusPluginDAO;
	}

	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}

	public void setModuleReader(OsgiModuleReader moduleReader) {
		this.moduleReader = moduleReader;
	}

	@Override
	public Response installModule(Object modulFile, Object hostBundleObj) {
		try {
			MultipartFile multipartFile = (MultipartFile) modulFile;
			ModuleWriter moduleToDiskWritter = new ModuleWriter();
			moduleToDiskWritter.writeToDisk(multipartFile, this.temporaryModuleLocation);
			File tempFile = moduleToDiskWritter.getFile(this.temporaryModuleLocation, multipartFile.getOriginalFilename());
			Bundle hostBundle = (Bundle) hostBundleObj;
			Modul modul = this.saveModule(tempFile.getAbsolutePath(), hostBundle);
			moduleToDiskWritter.writeToDisk(multipartFile, this.installedModuleLocation);
			moduleToDiskWritter.deleteFromDisk(tempFile.toPath());
			return new Response(Response.ok, "Modul berhasil ditambah", modul);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response(Response.error, "Modul gagal ditambah. " + e.getMessage(), null);
		}
	}

	private Modul saveModule(String filePath, Bundle hostBundle) throws Exception {
		Modul res = null;
		BundleContext bundleContext = FrameworkUtil.getBundle(this.getClass()).getBundleContext();
		filePath = "file:" + filePath;
		try {
			Bundle bundle = bundleContext.installBundle(filePath);
			Bundle systemBundle = bundleContext.getBundle(0);
			FrameworkWiring fw = systemBundle.adapt(FrameworkWiring.class);
			ArrayList<Bundle> bundles = new ArrayList<Bundle>();
			bundles.add(bundle); 
			fw.resolveBundles(bundles);
			Modul modul = this.moduleReader.readModule(bundle, hostBundle);
			StatusPlugin statusPlugin = this.statusPluginDAO.getByParam("where namaStatus = 'STARTED'").get(0);
			modul.setStatus(statusPlugin);
			modul.setOsgiBundleId(String.valueOf(bundle.getBundleId()));
			modul.setNamaServlet("");
			res = this.insertInto(modul);
			if (res != null) { 
				for(Menu menu : modul.getMenus()) {
					menu.setModul(res);
					this.menuService.insertInto(menu);
				}
				for(Menu menuOld : this.menuService.getByParam("where modul.idModul = '" + res.getIdModul() + "'")){
					boolean found = false;
					for(Menu menuNew : modul.getMenus()) {
						if(menuOld.getNamaMenu().equals(menuNew.getNamaMenu())) {
							found = true;
						}
					}
					if(!found) {
						this.menuService.delete(menuOld);
					}
				}
			} else {
				bundle.uninstall();
				throw new Exception("Modul dengan nama " + modul.getNamaModul() + " sudah ada dan pemetaan url " + modul.getUrlMapping() + " sudah digunakan");
			}
		} catch (BundleException e) {
			throw new BundleException("Instalasi modul ke dalam container OSGi gagal. Pesan Exception: " + e.getMessage());
		} catch (Exception e) {
			throw e;
		}
		return res;
	}

	private Modul insertInto(Modul modul) {
		List<Modul> usedNameModules = this.getByParam("where namaModul = '" + modul.getNamaModul() + "'");
		List<Modul> usedUrlModules = this.getByParam("where urlMapping = '" + modul.getUrlMapping() + "'");
		if ((usedNameModules != null && usedNameModules.size() > 0) && (!usedNameModules.get(0).getUrlMapping().equals(modul.getUrlMapping())) && (usedUrlModules != null && usedUrlModules.size() > 0)) {
			return null;
		}
		if ((usedNameModules == null || usedNameModules.size() == 0) && (usedUrlModules == null || usedUrlModules.size() == 0)) {
			this.modulDAO.insert(modul);
			return this.getByParam("where namaModul = '" + modul.getNamaModul() + "'").get(0);
		} else {
			return this.update(modul);
		}
	}

	@Override
	public Modul update(Modul modul) {
		Modul toBeUpdated = null;
		List<Modul> modules = this.getByParam("where namaModul = '" + modul.getNamaModul() + "'");
		if(modules != null) {
			toBeUpdated = modules.get(0);
		} else {
			this.getByParam("where urlMapping = '" + modul.getUrlMapping() + "'").get(0);
		}
		toBeUpdated.setNamaModul(modul.getNamaModul());
		toBeUpdated.setVersi(modul.getVersi());
		toBeUpdated.setStatus(modul.getStatus());
		toBeUpdated.setOsgiBundleId(modul.getOsgiBundleId());
		toBeUpdated.setUrlMapping(modul.getUrlMapping());
		toBeUpdated.setLokasiKonfigServlet(modul.getLokasiKonfigServlet());
		toBeUpdated.setNamaServlet(modul.getNamaServlet());
		this.modulDAO.update(toBeUpdated);
		return toBeUpdated;
	}

	@Override
	public Response uninstallModule(Modul modul) {
		try {
			BundleContext bundleContext = FrameworkUtil.getBundle(this.getClass()).getBundleContext();
			Bundle bundle = bundleContext.getBundle(modul.getOsgiBundleId());
			bundle.uninstall();
			for(Menu menu : modul.getMenus()){
				this.menuService.delete(menu);
			}
			this.modulDAO.delete(modul);
			return new Response(Response.ok, "Modul berhasil dihapus", modul);
		} catch (BundleException e) {
			e.printStackTrace();
			return new Response(Response.error, "Modul gagal dihapus. Pesan Exception: " + e.getMessage(), null);
		}
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
	
}
