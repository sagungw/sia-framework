package com.sia.main.service.services;

import java.util.List;

import com.sia.main.domain.Pengguna;

public interface PenggunaService {

	public void insertInto(Pengguna pengguna);

	public void update(Pengguna pengguna);

	public void delete(Pengguna pengguna);

	public List<Pengguna> getAll();

	public Pengguna getById(String idPengguna);
	
}
