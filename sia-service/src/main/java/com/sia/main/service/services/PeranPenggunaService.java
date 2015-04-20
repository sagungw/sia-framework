package com.sia.main.service.services;

import java.util.List;
import java.util.UUID;

import com.sia.main.domain.PeranPengguna;

public interface PeranPenggunaService {

	public void insertInto(PeranPengguna peranPengguna);

	public void update(PeranPengguna peranPengguna);

	public void delete(PeranPengguna peranPengguna);

	public List<PeranPengguna> getAll();

	public PeranPengguna getById(UUID idPeranPengguna);
	
}
