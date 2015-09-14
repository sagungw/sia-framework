package com.sia.main.service.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.sia.main.data.dao.MenuDAO;
import com.sia.main.domain.Menu;
import com.sia.main.service.services.MenuService;

@Service
public class MenuServiceImpl implements MenuService  {

	private MenuDAO menuDAO;
	
	public MenuDAO getMenuDAO() {
		return menuDAO;
	}

	public void setMenuDAO(MenuDAO menuDAO) {
		this.menuDAO = menuDAO;
	}

	@Override
	public Menu insertInto(Menu menu) {
		this.menuDAO.insert(menu);
		return menu;
	}

	@Override
	public Menu update(Menu menu) {
		this.menuDAO.update(menu);
		return menu;
	}

	@Override
	public Menu delete(Menu menu) {
		this.menuDAO.delete(menu);
		return menu;
	}

	@Override
	public List<Menu> getAll() {
		return this.menuDAO.getAll();
	}

	@Override
	public Menu getById(UUID idMenu) {
		return this.menuDAO.getById(idMenu);
	}

	@Override
	public List<Menu> getByParam(String queryParam) {
		// TODO Auto-generated method stub
		return null;
	}

}
