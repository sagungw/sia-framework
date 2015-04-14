package com.sia.main.service.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sia.main.data.repositories.MenuPeranRepository;
import com.sia.main.domain.MenuPeran;
import com.sia.main.service.services.MenuPeranService;

@Service
public class MenuPeranServiceImpl implements MenuPeranService {
	
	private MenuPeranRepository menuPeranRepository;
	
	@Override
	public void insertInto(MenuPeran menuPeran) {
		this.menuPeranRepository.insertInto(menuPeran);
	}

	@Override
	public void update(MenuPeran menuPeran) {
		this.menuPeranRepository.update(menuPeran);
	}

	@Override
	public void delete(MenuPeran menuPeran) {
		this.menuPeranRepository.delete(menuPeran);
	}

	@Override
	public List<MenuPeran> getAll() {
		return this.menuPeranRepository.getAll();
	}

	@Override
	public MenuPeran getById(String idMenuPeran) {
		return this.menuPeranRepository.getById(idMenuPeran);
	}

}
