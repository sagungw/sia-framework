package com.sia.main.service.services;

import java.util.List;

import com.sia.main.domain.Menu;

public interface MenuService {

	public void insertInto(Menu menu);

	public void update(Menu menu);

	public void delete(Menu menu);

	public List<Menu> getAll();

	public Menu getById(String idMenu);
	
}
