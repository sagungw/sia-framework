package com.sia.main.service.services;

import java.util.List;

import com.sia.main.domain.Peran;

public interface PeranService {

	public void insertInto(Peran peran);

	public void update(Peran peran);

	public void delete(Peran peran);

	public List<Peran> getAll();

	public Peran getById(String idPeran);
	
}
