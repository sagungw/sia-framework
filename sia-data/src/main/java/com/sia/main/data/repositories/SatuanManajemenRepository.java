package com.sia.main.data.repositories;

import java.util.List;
import java.util.UUID;

import com.sia.main.domain.SatMan;

public interface SatuanManajemenRepository {

	public void insertInto(SatMan satuanManajemen);

	public void update(SatMan satuanManajemen);

	public void delete(SatMan satuanManajemen);

	public List<SatMan> getAll();

	public SatMan getById(UUID idSatuanManajemen);
	
}
