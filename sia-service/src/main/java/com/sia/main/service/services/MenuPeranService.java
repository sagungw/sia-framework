package com.sia.main.service.services;

import java.util.List;
import java.util.UUID;

import com.sia.main.domain.MenuPeran;

public interface MenuPeranService {

	public MenuPeran insertInto(MenuPeran menuPeran);

	public MenuPeran update(MenuPeran menuPeran);

	public void delete(MenuPeran menuPeran);

	public List<MenuPeran> getAll();

	public MenuPeran getById(UUID idMenuPeran);
	
	public List<MenuPeran> getByParam(String queryParam);
	
}
