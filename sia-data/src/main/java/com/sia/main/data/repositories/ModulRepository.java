package com.sia.main.data.repositories;

import java.util.List;
import java.util.UUID;

import com.sia.main.domain.Modul;

public interface ModulRepository {
	
	public void insertInto(Modul modul);

	public void update(Modul modul);

	public void delete(Modul modul);

	public List<Modul> getAll();

	public Modul getById(UUID idModul);
}
