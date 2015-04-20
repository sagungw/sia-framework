package com.sia.main.service.services.impl;

import com.sia.main.service.services.DummyService;

public class DummyServiceImpl implements DummyService {

	@Override
	public void insertInto() {
		System.out.println("DUMMY INSERTED");
	}

	@Override
	public void update() {
		System.out.println("DUMMY UPDATED");
	}

	@Override
	public void delete() {
		System.out.println("DUMMY DELETED");
	}

}
