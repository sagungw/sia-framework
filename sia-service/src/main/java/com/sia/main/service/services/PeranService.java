package com.sia.main.service.services;

import java.util.List;
import java.util.UUID;

import com.sia.main.domain.Peran;

public interface PeranService {

	public boolean insertInto(Peran peran);

	public boolean update(Peran peran);
	
	public boolean update(String namaPeranLama, String namaPeranBaru);

	public void delete(Peran peran);

	public List<Peran> getAll();

	public Peran getById(UUID idPeran);
	
}
