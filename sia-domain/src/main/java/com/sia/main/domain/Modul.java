package com.sia.main.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToMany;

@Entity
@Table(name = "modul")
public class Modul {
	
	@Id
	@Column(name = "id_modul")
	private String idModul;
	
	@Column(name = "nama_modul")
	private String namaModul;
	
	@Column(name = "a_modul_aktif")
	private boolean isActive;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "modul")
	private List<Menu> menus = new ArrayList<Menu>();

	protected Modul(String idModul, String namaModul, boolean isActive,
			List<Menu> menus) {
		super();
		this.idModul = idModul;
		this.namaModul = namaModul;
		this.isActive = isActive;
		this.menus = menus;
	}

	public String getIdModul() {
		return idModul;
	}

	public void setIdModul(String idModul) {
		this.idModul = idModul;
	}

	public String getNamaModul() {
		return namaModul;
	}

	public void setNamaModul(String namaModul) {
		this.namaModul = namaModul;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}
	
}
