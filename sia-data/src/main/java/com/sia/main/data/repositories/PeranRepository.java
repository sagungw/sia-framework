package com.sia.main.data.repositories;

import java.util.List;
import java.util.UUID;

import com.sia.main.domain.Peran;

public interface PeranRepository {

	public void insertInto(Peran peran);

	public void update(Peran peran);

	public void delete(Peran peran);

	public List<Peran> getAll();
	
	public Peran getById(UUID idPeran);

	public List<Peran> getPeranWithParam(String param);
	
}
