package com.sia.main.service.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
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
	public Peran insertInto(Peran peran) {
		List<Peran> peranList = this.getPeranWithParam(" where namaPeran = '" + peran.getNamaPeran() + "'");
		Peran result = null;
		if(peranList == null || peranList.size() == 0) {
			this.peranRepository.insertInto(peran);
			result = peran;
		}
		return result;
	}

	@Override
	public Peran update(Peran peran) {
		List<Peran> peranList = this.getPeranWithParam(" where namaPeran = '" + peran.getNamaPeran() + "' and idPeran != '" + peran.getIdPeran() + "'");
		Peran result = null;
		if(peranList == null || peranList.size() == 0) {
			this.peranRepository.update(peran);
			result = peran;
		}
		return result;
	}
	
	@Override
	public Peran delete(Peran peran) {
		try {
			this.peranRepository.delete(peran);
			return peran;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Peran> getAll() {
		return this.peranRepository.getAll();
	}

	@Override
	public Peran getById(UUID idPeran) {
		return this.peranRepository.getById(idPeran);
	}

	@Override
	public List<Peran> getPeranWithParam(String param) {
		return this.peranRepository.getPeranWithParam(param);
	}
	
}
