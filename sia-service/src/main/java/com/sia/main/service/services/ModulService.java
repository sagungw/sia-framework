package com.sia.main.service.services;

import java.util.List;
import java.util.UUID;

import com.sia.main.domain.Modul;

public interface ModulService {

	public Modul insertInto(Modul modul);

	public void update(Modul modul);

	public void delete(Modul modul);

	public List<Modul> getAll();

	public Modul getById(UUID idModul);
	
	public List<Modul> getModuleWithParam(String queryParam);
	
}
