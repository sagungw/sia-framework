package com.sia.main.data.repositories;

import java.util.List;
import java.util.UUID;

import com.sia.main.domain.Menu;

public interface MenuRepository {

	public void insertInto(Menu menu);

	public void update(Menu menu);

	public void delete(Menu menu);

	public List<Menu> getAll();

	public Menu getById(UUID idMenu);
	
}
