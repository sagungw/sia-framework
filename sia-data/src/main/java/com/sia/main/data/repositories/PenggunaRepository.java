package com.sia.main.data.repositories;

import java.util.List;
import java.util.UUID;

import com.sia.main.domain.Pengguna;

public interface PenggunaRepository {

	public void insertInto(Pengguna pengguna);

	public void update(Pengguna pengguna);

	public void delete(Pengguna pengguna);

	public List<Pengguna> getAll();

	public Pengguna getById(UUID idPengguna);

}
