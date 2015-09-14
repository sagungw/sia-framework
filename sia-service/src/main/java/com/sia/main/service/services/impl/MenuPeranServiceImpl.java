package com.sia.main.service.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.sia.main.data.dao.MenuPeranDAO;
import com.sia.main.domain.MenuPeran;
import com.sia.main.service.services.MenuPeranService;

@Service
public class MenuPeranServiceImpl implements MenuPeranService {

	private MenuPeranDAO menuPeranDAO;

	public void setMenuPeranDAO(MenuPeranDAO menuPeranDAO) {
		this.menuPeranDAO = menuPeranDAO;
	}

	public MenuPeranDAO getMenuPeranDAO() {
		return this.menuPeranDAO;
	}

	@Override
	public MenuPeran insertInto(MenuPeran menuPeran) {
		List<MenuPeran> daftarMenuPeran = this
				.getByParam("where peran.idPeran = '"
						+ menuPeran.getPeran().getIdPeran()
						+ "' and menu.idMenu = '"
						+ menuPeran.getMenu().getIdMenu() + "'");
		if (daftarMenuPeran != null && daftarMenuPeran.size() > 0) {
			return null;
		}
		this.menuPeranDAO.insert(menuPeran);
		return menuPeran;
	}

	@Override
	public MenuPeran update(MenuPeran menuPeran) {
		List<MenuPeran> daftarMenuPeran = this
				.getByParam("where peran.idPeran = '"
						+ menuPeran.getPeran().getIdPeran()
						+ "' and menu.idMenu = '"
						+ menuPeran.getMenu().getIdMenu()
						+ "' and idMenuPeran != '" + menuPeran.getIdMenuPeran()
						+ "'");
		if (daftarMenuPeran != null && daftarMenuPeran.size() > 0) {
			return null;
		}
		this.menuPeranDAO.update(menuPeran);
		return menuPeran;
	}

	@Override
	public MenuPeran delete(MenuPeran menuPeran) {
		this.menuPeranDAO.delete(menuPeran);
		return menuPeran;
	}

	@Override
	public List<MenuPeran> getAll() {
		return this.menuPeranDAO.getAll();
	}

	@Override
	public MenuPeran getById(UUID idMenuPeran) {
		return this.menuPeranDAO.getById(idMenuPeran);
	}

	@Override
	public List<MenuPeran> getByParam(String queryParam) {
		return this.menuPeranDAO.getByParam(queryParam);
	}

}
