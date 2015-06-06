package com.sia.main.service.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.sia.main.data.repositories.PeranRepository;
import com.sia.main.domain.Peran;
import com.sia.main.service.services.PeranService;

@Service
public class PeranServiceImpl implements PeranService {
	
	private PeranRepository peranRepository;
	
	public PeranRepository getPeranRepository() {
		return peranRepository;
	}

	public void setPeranRepository(PeranRepository peranRepository) {
		this.peranRepository = peranRepository;
	}

	@Override
	public boolean insertInto(Peran peran) {
		boolean success = false;
		for(Peran p : this.getAll()) {
			if(peran.getNamaPeran().equalsIgnoreCase(p.getNamaPeran())) {
				success = true;
				break;
			}
		}
		if(success)
			this.peranRepository.insertInto(peran);
		return success;
	}

	@Override
	public boolean update(Peran peran) {
		boolean success = true;
		int found = 0;
		for(Peran p : this.getAll()) {
			if(peran.getNamaPeran().equalsIgnoreCase(p.getNamaPeran())) {
				found++;
			}
		}
		if(found > 1) 
			success = false;
		if(success)
			this.peranRepository.update(peran);
		return success;
	}
	
	@Override
	public boolean update(String namaPeranLama, String namaPeranBaru) {
		
		return false;
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
	public Peran getById(UUID idPeran) {
		return this.peranRepository.getById(idPeran);
	}
	
}
