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
	public void insertInto(Modul modul) {
		this.modulRepository.insertInto(modul);
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

}
