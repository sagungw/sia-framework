package com.sia.main.service.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.sia.main.data.repositories.MenuPeranRepository;
import com.sia.main.domain.MenuPeran;
import com.sia.main.service.services.MenuPeranService;

@Service
public class MenuPeranServiceImpl implements MenuPeranService {
	
	private MenuPeranRepository menuPeranRepository;
	
	public void setMenuPeranRepository(MenuPeranRepository menuPeranRepository) {
		this.menuPeranRepository = menuPeranRepository;
	}
	
	public MenuPeranRepository getMenuPeranRepository() {
		return this.menuPeranRepository;
	}
	
	@Override
	public MenuPeran insertInto(MenuPeran menuPeran) {
		List<MenuPeran> daftarMenuPeran = this.getByParam("where peran.idPeran = '" + menuPeran.getPeran().getIdPeran() + "' and menu.idMenu = '" + menuPeran.getMenu().getIdMenu() + "'");
		if(daftarMenuPeran != null && daftarMenuPeran.size() > 0) {
			return null;
		}
		this.menuPeranRepository.insertInto(menuPeran);
		return menuPeran;
	}

	@Override
	public MenuPeran update(MenuPeran menuPeran) {
		List<MenuPeran> daftarMenuPeran = this.getByParam("where peran.idPeran = '" + menuPeran.getPeran().getIdPeran() + "' and menu.idMenu = '" + menuPeran.getMenu().getIdMenu() + "' and idMenuPeran != '" + menuPeran.getIdMenuPeran() + "'");
		if(daftarMenuPeran != null && daftarMenuPeran.size() > 0) {
			return null;
		}
		this.menuPeranRepository.update(menuPeran);
		return menuPeran;
	}

	@Override
	public void delete(MenuPeran menuPeran) {
		this.menuPeranRepository.delete(menuPeran);
	}

	@Override
	public List<MenuPeran> getAll() {
		return this.menuPeranRepository.getAll();
	}

	@Override
	public MenuPeran getById(UUID idMenuPeran) {
		return this.menuPeranRepository.getById(idMenuPeran);
	}

	@Override
	public List<MenuPeran> getByParam(String queryParam) {
		return this.menuPeranRepository.getByParam(queryParam);
	}

}
