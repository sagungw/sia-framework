package com.sia.main.service.services;

import java.util.List;
import java.util.UUID;

import com.sia.main.domain.SatuanManajemen;

public interface SatuanManajemenService {

	public void insertInto(SatuanManajemen satuanManajemen);

	public void update(SatuanManajemen satuanManajemen);

	public void delete(SatuanManajemen satuanManajemen);

	public List<SatuanManajemen> getAll();

	public SatuanManajemen getById(UUID idSatuanManajemen);

}
