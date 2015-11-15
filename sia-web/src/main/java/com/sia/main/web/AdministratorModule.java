package com.sia.main.web;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.sia.main.domain.Menu;
import com.sia.main.domain.Modul;

public class AdministratorModule extends Modul {

	private static AdministratorModule instance;
	
	public static AdministratorModule getInstance() {
		if(instance == null) {
			instance = new AdministratorModule();
		}
		return instance;
	}
	
	private AdministratorModule() {
		this.setIdModul(UUID.randomUUID());
		this.setNamaModul("Modul Admin");
		List<Menu> menus = new ArrayList<Menu>();
		menus.add(new Menu(UUID.randomUUID(), this, "Dasbor", "/admin/home", null));
		menus.add(new Menu(UUID.randomUUID(), this, "Tambah Modul", "/admin/module/uploadWizard/1", null));
		menus.add(new Menu(UUID.randomUUID(), this, "Kelola Modul", "/admin/module", null));
		menus.add(new Menu(UUID.randomUUID(), this, "Kelola Pengguna", "/admin/user", null));
		menus.add(new Menu(UUID.randomUUID(), this, "Kelola Peran", "/admin/role", null));
		menus.add(new Menu(UUID.randomUUID(), this, "Kelola Hak Akses Pengguna", "/admin/userRole", null));
		this.setMenus(menus);
	}
	
}
