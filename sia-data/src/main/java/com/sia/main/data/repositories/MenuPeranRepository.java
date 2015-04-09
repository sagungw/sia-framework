package com.sia.main.data.repositories;

import java.util.List;

import com.sia.main.domain.MenuPeran;

public interface MenuPeranRepository {
	
	public void insertInto(MenuPeran menuPeran);

	public void update(MenuPeran menuPeran);

	public void delete(MenuPeran menuPeran);

	public List<MenuPeran> getAll();

	public MenuPeran getById(String idMenuPeran);
	
}
