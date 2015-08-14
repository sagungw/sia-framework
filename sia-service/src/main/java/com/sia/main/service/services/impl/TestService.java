package com.sia.main.service.services.impl;

import java.util.List;
import java.util.UUID;

import com.sia.main.domain.Pengguna;
import com.sia.main.service.services.GenericService;

public class TestService implements GenericService<Pengguna>{

	@Override
	public Pengguna insert(Pengguna object) {
		System.out.println("inserting");
		return null;
	}

	@Override
	public Pengguna update(Pengguna object) {
		System.out.println("updating");
		return null;
	}

	@Override
	public Pengguna delete(Pengguna object) {
		System.out.println("deleting");
		return null;
	}

	@Override
	public Pengguna getById(UUID id) {
		System.out.println("getById");
		return null;
	}

	@Override
	public List<Pengguna> getAll() {
		System.out.println("getAll");
		return null;
	}

	@Override
	public List<Pengguna> getByParam(String queryParam) {
		System.out.println("getByParam");
		return null;
	}

}
