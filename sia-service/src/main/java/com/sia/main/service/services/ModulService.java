package com.sia.main.service.services;

import java.util.List;
import java.util.UUID;

import com.sia.main.domain.Modul;

public interface ModulService {

	public Modul installModule(Object modulFile, Object hostBundle);
	
	public Modul uninstallModule(Modul modul);
	
	public Modul insertInto(Modul modul);

	public Modul update(Modul modul);

	public Modul delete(Modul modul);

	public List<Modul> getAll();

	public Modul getById(UUID idModul);
	
	public List<Modul> getByParam(String queryParam);
	
}
