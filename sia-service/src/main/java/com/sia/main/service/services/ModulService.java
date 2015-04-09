package com.sia.main.service.services;

import java.util.List;

import com.sia.main.domain.Modul;

public interface ModulService {

	public void insertInto(Modul modul);

	public void update(Modul modul);

	public void delete(Modul modul);

	public List<Modul> getAll();

	public Modul getById(String idModul);
	
}
