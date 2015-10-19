package com.sia.main.service.services;

import java.util.List;
import java.util.UUID;

import com.sia.main.domain.Modul;
import com.sia.main.plugin.modul.Module;

public interface ModulService {

	public Modul installModule(Object modulFile, Object hostBundle);
	
	public Modul uninstallModule(Modul modul);
	
	public Modul insertInto(Modul modul);

	public Modul update(Modul modul);

	public Modul delete(Modul modul);

	public List<Modul> getAll();

	public Modul getById(UUID idModul);
	
	public List<Modul> getByParam(String queryParam);
	
	public void addModule(Module module);
	
	public List<Module> getModules();
	
}
