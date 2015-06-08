package com.sia.main.service.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.sia.main.data.repositories.ModulRepository;
import com.sia.main.domain.Modul;
import com.sia.main.service.services.ModulService;

@Service
public class ModulServiceImpl implements ModulService {

	private ModulRepository modulRepository;
	
	public ModulRepository getModulRepository() {
		return modulRepository;
	}

	public void setModulRepository(ModulRepository modulRepository) {
		this.modulRepository = modulRepository;
	}

	@Override
	public Modul insertInto(Modul modul) {
		if(this.getModuleWithParam("where urlMapping like '" + modul.getUrlMapping() + "'").size() > 0) {
			return null;
		}
		if(this.getModuleWithParam("where namaModul like '" + modul.getNamaModul() + "'").size() == 0) {
			this.modulRepository.insertInto(modul);
		} else {
			this.update(modul);
		}
		return modul;
	}

	@Override
	public void update(Modul modul) {
		this.modulRepository.update(modul);
	}

	@Override
	public void delete(Modul modul) {
		this.modulRepository.delete(modul);
	}

	@Override
	public List<Modul> getAll() {
		return this.modulRepository.getAll();
	}

	@Override
	public Modul getById(UUID idModul) {
		return this.modulRepository.getById(idModul);
	}

	@Override
	public List<Modul> getModuleWithParam(String queryParam) {
		return this.modulRepository.getModuleWithParam(queryParam);
	}

	
}
