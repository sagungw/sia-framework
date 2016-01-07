package com.sia.main.web;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.sia.main.domain.Menu;
import com.sia.main.domain.Modul;

public class AdministratorModuleManager {

	private static AdministratorModuleManager instance;
	
	public static AdministratorModuleManager getInstance() {
		if(instance == null) {
			instance = new AdministratorModuleManager();
		}
		return instance;
	}
	
	private List<Modul> modules;
	
	public List<Modul> getModules() {
		return modules;
	}

	public void setModules(List<Modul> modules) {
		this.modules = modules;
	}

	private AdministratorModuleManager() {
		this.modules = new ArrayList<Modul>();
		
		AdministratorModule modul = new AdministratorModule();
		List<Menu> menus = new ArrayList<Menu>();
		modul = new AdministratorModule();
		modul.setIdModul(UUID.randomUUID());
		modul.setNamaModul("Modul");
		modul.setLokasiKonfigServlet("/WEB-INF/spring-beans/servlet/sia-servlet.xml");
		modul.setUrlMapping("/admin/*");
		modul.setNamaIconTemplate("fa fa-puzzle-piece");
		File imageFile = new File("D:\\modul.png");
		try {
			modul.setGambar(Files.readAllBytes(imageFile.toPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		menus.add(new Menu(UUID.randomUUID(), modul, "Tambah Modul", "/module/uploadWizard/1", null));
		menus.add(new Menu(UUID.randomUUID(), modul, "Kelola Modul", "/module", null));
		modul.setMenus(menus);
		modules.add(modul);
		
		modul = new AdministratorModule();
		menus = new ArrayList<Menu>();
		modul.setIdModul(UUID.randomUUID());
		modul.setNamaModul("Hak Akses");
		modul.setLokasiKonfigServlet("/WEB-INF/spring-beans/servlet/sia-servlet.xml");
		modul.setUrlMapping("/admin/*");
		modul.setNamaIconTemplate("fa fa-key");
		imageFile = new File("D:\\hak akses.png");
		try {
			modul.setGambar(Files.readAllBytes(imageFile.toPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		menus.add(new Menu(UUID.randomUUID(), modul, "Kelola Pengguna", "/user", null));
		menus.add(new Menu(UUID.randomUUID(), modul, "Kelola Peran", "/role", null));
		modul.setMenus(menus);
		modules.add(modul);
	}
	
}
