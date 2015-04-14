package com.sia.main.service.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sia.main.data.repositories.PenggunaRepository;
import com.sia.main.domain.Pengguna;
import com.sia.main.service.services.PenggunaService;

@Service
public class PenggunaServiceImpl implements PenggunaService {

	private PenggunaRepository penggunaRepository;
	
	@Override
	public void insertInto(Pengguna pengguna) {
		this.penggunaRepository.insertInto(pengguna);
	}

	@Override
	public void update(Pengguna pengguna) {
		this.penggunaRepository.update(pengguna);
	}

	@Override
	public void delete(Pengguna pengguna) {
		this.penggunaRepository.delete(pengguna);
	}

	@Override
	public List<Pengguna> getAll() {
		return this.penggunaRepository.getAll();
	}

	@Override
	public Pengguna getById(String idPengguna) {
		return this.penggunaRepository.getById(idPengguna);
	}

}
