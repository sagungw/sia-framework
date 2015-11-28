package com.sia.main.web;

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
		modul.setNamaIconTemplate("fa fa-puzzle-piece");
		menus.add(new Menu(UUID.randomUUID(), modul, "Tambah Modul", "/admin/module/uploadWizard/1", null));
		menus.add(new Menu(UUID.randomUUID(), modul, "Kelola Modul", "/admin/module", null));
		modul.setMenus(menus);
		modules.add(modul);
		
		modul = new AdministratorModule();
		menus = new ArrayList<Menu>();
		modul.setIdModul(UUID.randomUUID());
		modul.setNamaModul("Hak Akses");
		modul.setNamaIconTemplate("fa fa-key");
		menus.add(new Menu(UUID.randomUUID(), modul, "Kelola Pengguna", "/admin/user", null));
		menus.add(new Menu(UUID.randomUUID(), modul, "Kelola Peran", "/admin/role", null));
		menus.add(new Menu(UUID.randomUUID(), modul, "Kelola Hak Akses Pengguna", "/admin/userRole", null));
		modul.setMenus(menus);
		modules.add(modul);
	}
	
}
