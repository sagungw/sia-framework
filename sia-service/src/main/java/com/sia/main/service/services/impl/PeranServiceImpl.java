package com.sia.main.service.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sia.main.data.repositories.PeranRepository;
import com.sia.main.domain.Peran;
import com.sia.main.service.services.PeranService;

@Service
public class PeranServiceImpl implements PeranService {

	private PeranRepository peranRepository;
	
	@Override
	public void insertInto(Peran peran) {
		this.peranRepository.insertInto(peran);
	}

	@Override
	public void update(Peran peran) {
		this.peranRepository.update(peran);
	}

	@Override
	public void delete(Peran peran) {
		this.peranRepository.delete(peran);
	}

	@Override
	public List<Peran> getAll() {
		return this.peranRepository.getAll();
	}

	@Override
	public Peran getById(String idPeran) {
		return this.peranRepository.getById(idPeran);
	}

}
