package com.sia.main.service.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.sia.main.data.repositories.PeranPenggunaRepository;
import com.sia.main.domain.PeranPengguna;
import com.sia.main.service.services.PeranPenggunaService;

@Service
public class PeranPenggunaServiceImpl implements PeranPenggunaService{

	private PeranPenggunaRepository peranPenggunaRepository;
	
	@Override
	public void insertInto(PeranPengguna peranPengguna) {
		this.peranPenggunaRepository.insertInto(peranPengguna);
	}

	@Override
	public void update(PeranPengguna peranPengguna) {
		this.peranPenggunaRepository.update(peranPengguna);
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

}
