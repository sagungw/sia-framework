package com.sia.main.service.services.impl;

import java.util.List;
import java.util.UUID;

import com.sia.main.data.repositories.PeranPenggunaRepository;
import com.sia.main.domain.PeranPengguna;
import com.sia.main.service.services.PeranPenggunaService;

public class PeranPenggunaServiceImpl implements PeranPenggunaService {
	
	private PeranPenggunaRepository peranPenggunaRepository;
	
	public PeranPenggunaRepository getPeranPenggunaRepository() {
		return peranPenggunaRepository;
	}

	public void setPeranPenggunaRepository(PeranPenggunaRepository peranPenggunaRepository) {
		this.peranPenggunaRepository = peranPenggunaRepository;
	}

	@Override
	public PeranPengguna insertInto(PeranPengguna peranPengguna) {
		String query = "where peran.idPeran = '" + peranPengguna.getPeran().getIdPeran() + "' and pengguna.idPengguna = '" + peranPengguna.getPengguna().getIdPengguna() + "'";
		List<PeranPengguna> result = this.peranPenggunaRepository.getByParam(query);
		if(result != null && result.size() > 0) {
			return null;	
		}
		this.peranPenggunaRepository.insertInto(peranPengguna);
		return peranPengguna;
	}

	@Override
	public PeranPengguna update(PeranPengguna peranPengguna) {
		String query = "where peran.idPeran = '" + peranPengguna.getPeran().getIdPeran() + "' and pengguna.idPengguna = '" + peranPengguna.getPengguna().getIdPengguna() + "' and idPeranPengguna != '" + peranPengguna.getIdPeranPengguna() + "'";
		List<PeranPengguna> result = this.peranPenggunaRepository.getByParam(query);
		if(result != null && result.size() > 0) {
			return null;	
		}
		this.peranPenggunaRepository.update(peranPengguna);
		return peranPengguna;
	}

	@Override
	public void delete(PeranPengguna peranPengguna) {
		this.peranPenggunaRepository.delete(peranPengguna);
	}

	@Override
	public List<PeranPengguna> getAll() {
		return this.peranPenggunaRepository.getAll();
	}

	@Override
	public PeranPengguna getById(UUID idPeranPengguna) {
		return this.peranPenggunaRepository.getById(idPeranPengguna);
	}

	@Override
	public List<PeranPengguna> getByParam(String queryParam) {
		return this.peranPenggunaRepository.getByParam(queryParam);
	}

}
