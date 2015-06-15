package com.sia.main.service.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.sia.main.data.repositories.PenggunaRepository;
import com.sia.main.domain.Pengguna;
import com.sia.main.service.services.PenggunaService;

@Service
public class PenggunaServiceImpl implements PenggunaService {

	private PenggunaRepository penggunaRepository;
	
	public PenggunaRepository getPenggunaRepository() {
		return penggunaRepository;
	}

	public void setPenggunaRepository(PenggunaRepository penggunaRepository) {
		this.penggunaRepository = penggunaRepository;
	}

	@Override
	public Pengguna insertInto(Pengguna pengguna) {
		List<Pengguna> penggunaList = this.getByParam("where username = '" + pengguna.getUsername() + "'");
		if(penggunaList != null && penggunaList.size() > 0) {
			return null;
		}
		this.penggunaRepository.insertInto(pengguna);
		return pengguna;
	}

	@Override
	public Pengguna update(Pengguna pengguna) {
		List<Pengguna> penggunaList = this.getByParam("where username = '" + pengguna.getUsername() + "' and idPengguna != '" + pengguna.getIdPengguna() + "'");
		if(penggunaList != null && penggunaList.size() > 0) {
			return null;
		}
		this.penggunaRepository.update(pengguna);
		return pengguna;
	}

	@Override
	public Pengguna delete(Pengguna pengguna) {
		pengguna.setStatusKeaktifan(false);
		return this.update(pengguna);
	}

	@Override
	public List<Pengguna> getAll() {
		return this.penggunaRepository.getAll();
	}

	@Override
	public Pengguna getById(UUID idPengguna) {
		return this.penggunaRepository.getById(idPengguna);
	}

	@Override
	public List<Pengguna> getByParam(String queryParam) {
		return this.penggunaRepository.getByParam(queryParam);
	}

}
