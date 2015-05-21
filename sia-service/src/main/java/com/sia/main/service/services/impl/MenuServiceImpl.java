package com.sia.main.service.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.sia.main.data.repositories.MenuRepository;
import com.sia.main.domain.Menu;
import com.sia.main.service.services.MenuService;

@Service
public class MenuServiceImpl implements MenuService  {

	private MenuRepository menuRepository;
	
	public MenuRepository getMenuRepository() {
		return menuRepository;
	}

	public void setMenuRepository(MenuRepository menuRepository) {
		this.menuRepository = menuRepository;
	}

	@Override
	public void insertInto(Menu menu) {
		this.menuRepository.insertInto(menu);
	}

	@Override
	public void update(Menu menu) {
		this.menuRepository.update(menu);
	}

	@Override
	public void delete(Menu menu) {
		this.menuRepository.delete(menu);
	}

	@Override
	public List<Menu> getAll() {
		return this.menuRepository.getAll();
	}

	@Override
	public Menu getById(UUID idMenu) {
		return this.menuRepository.getById(idMenu);
	}

}
