package com.sia.main.service.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.sia.main.data.repositories.SatuanManajemenRepository;
import com.sia.main.domain.SatuanManajemen;
import com.sia.main.service.services.SatuanManajemenService;

@Service
public class SatuanManajemenServiceImpl implements SatuanManajemenService {

	private SatuanManajemenRepository satuanManajemenRepository;
	
	public SatuanManajemenRepository getSatuanManajemenRepository() {
		return satuanManajemenRepository;
	}

	public void setSatuanManajemenRepository(
			SatuanManajemenRepository satuanManajemenRepository) {
		this.satuanManajemenRepository = satuanManajemenRepository;
	}

	@Override
	public void insertInto(SatuanManajemen satuanManajemen) {
		this.satuanManajemenRepository.insertInto(satuanManajemen);
	}

	@Override
	public void update(SatuanManajemen satuanManajemen) {
		this.satuanManajemenRepository.update(satuanManajemen);
	}

	@Override
	public void delete(SatuanManajemen satuanManajemen) {
		this.satuanManajemenRepository.delete(satuanManajemen);
	}

	@Override
	public List<SatuanManajemen> getAll() {
		return this.satuanManajemenRepository.getAll();
	}

	@Override
	public SatuanManajemen getById(UUID idSatuanManajemen) {
		return this.satuanManajemenRepository.getById(idSatuanManajemen);
	}

}
