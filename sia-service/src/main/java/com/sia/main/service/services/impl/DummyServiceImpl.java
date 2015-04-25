package com.sia.main.service.services.impl;

import org.springframework.stereotype.Service;

import com.sia.main.service.services.DummyService;

@Service
public class DummyServiceImpl implements DummyService{

	@Override
	public void sayHello() {
		System.out.println("HELLO");
	}

}
