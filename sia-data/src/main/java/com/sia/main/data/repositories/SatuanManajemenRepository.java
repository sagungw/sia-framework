package com.sia.main.data.repositories;

import java.util.List;

import com.sia.main.domain.SatuanManajemen;

public interface SatuanManajemenRepository {

	public void insertInto(SatuanManajemen satuanManajemen);

	public void update(SatuanManajemen satuanManajemen);

	public void delete(SatuanManajemen satuanManajemen);

	public List<SatuanManajemen> getAll();

	public SatuanManajemen getById(String idSatuanManajemen);
	
}
