package com.sia.main.service.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sia.main.data.repositories.MenuRepository;
import com.sia.main.data.repositories.ModulRepository;
import com.sia.main.domain.Modul;
import com.sia.main.service.services.ModulService;

@Service
public class ModulServiceImpl implements ModulService {
	
	private ModulRepository modulRepository;

	private MenuRepository menuRepository;
	
	public ModulRepository getModulRepository() {
		return modulRepository;
	}

	public void setModulRepository(ModulRepository modulRepository) {
		this.modulRepository = modulRepository;
	}
	
	public MenuRepository getMenuRepository() {
		return menuRepository;
	}

	public void setMenuRepository(MenuRepository menuRepository) {
		this.menuRepository = menuRepository;
	}

	@Override
	public Modul insertInto(Modul modul) {
		// Modul di-insert-into jika: 
		//		tidak ada modul di basis data dengan nama yang sama dengan modul yang akan di-insert-into
		//		dan
		//		tidak ada modul di basis data dengan url mapping yang sama dengan modul yang akan di-insert-into
		// Modul akan ditolak jika:
		//		ada modul pada basis data dengan nama yang sama dengan modul yang akan di-insert-into
		//		dan
		//		modul pada basis data dengan nama yang sama dengan modul yang akan di-insert-into tidak memiliki url mapping yang sama dengan modul yang akan di-insert-into
		//		dan
		//		ada modul pada basis data dengan url mapping yang sama dengan modul yang akan di-insert-into
		// Modul akan di-update jika:
		//		tidak memenuhi kriteria di atas
		
		Modul res = null;
		List<Modul> temps = this.getByParam("where namaModul = '" + modul.getNamaModul() + "'");
		List<Modul> temps2 = this.getByParam("where urlMapping = '" + modul.getUrlMapping() + "'");
		if((temps != null && temps.size() > 0) && (!temps.get(0).getUrlMapping().equals(modul.getUrlMapping())) && (temps2 != null && temps2.size() > 0)) {
			System.out.println("DENIED");
			return null;
		}
		if((temps == null || temps.size() == 0) && (temps2 == null || temps2.size() == 0) ) {
			System.out.println("INSERTED");
			this.modulRepository.insertInto(modul);
			res =  this.getByParam("where namaModul = '" + modul.getNamaModul() + "'").get(0);
		} else {
			System.out.println("UPDATED");
			res = this.update(modul);
		}
		return res;
	}

	@Override
	public Modul update(Modul modul) {
		Modul toBeUpdate = this.getByParam("where namaModul = '" + modul.getNamaModul() + "'").get(0);
		toBeUpdate.setNamaModul(modul.getNamaModul());
		toBeUpdate.setLokasiKonfigurasiServlet(modul.getLokasiKonfigurasiServlet());
		toBeUpdate.setStatus(modul.getStatus());
		toBeUpdate.setUrlMapping(modul.getUrlMapping());
		toBeUpdate.setVersi(modul.getVersi());
		this.modulRepository.update(toBeUpdate);
		return toBeUpdate;
	}

	@Override
	public Modul delete(Modul modul) {
		this.modulRepository.delete(modul);
		return modul;
	}

	@Override
	public List<Modul> getAll() {
		return this.modulRepository.getAll();
	}

	@Override
	public Modul getById(UUID idModul) {
		return this.modulRepository.getById(idModul);
	}

	@Override
	public List<Modul> getByParam(String queryParam) {
		return this.modulRepository.getByParam(queryParam);
	}

}
