package com.sia.main.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "modul")
public class Modul {
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Type(type = "pg-uuid")
	@Column(name = "id_modul")
	private UUID idModul;
	
	@Column(name = "nama_modul", nullable = false)
	private String namaModul;
	
	@Column(name = "url_mapping", nullable = false)
	private String urlMapping;
	
	@Column(name = "versi", nullable = false)
	private String versi;
	
	@Column(name = "status", nullable = false)
	private int status;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "modul")
	private List<Menu> menus = new ArrayList<Menu>();

	public Modul(){
		
	}
	
	public Modul(UUID idModul, String namaModul,
			String urlMapping, String versi, int status, List<Menu> menus) {
		super();
		this.idModul = idModul;
		this.namaModul = namaModul;
		this.urlMapping = urlMapping;
		this.versi = versi;
		this.status = status;
		this.menus = menus;
	}

	public UUID getIdModul() {
		return idModul;
	}

	public void setIdModul(UUID idModul) {
		this.idModul = idModul;
	}

	public String getNamaModul() {
		return namaModul;
	}

	public void setNamaModul(String namaModul) {
		this.namaModul = namaModul;
	}

	public String getUrlMapping() {
		return urlMapping;
	}

	public void setUrlMapping(String urlMapping) {
		this.urlMapping = urlMapping;
	}

	public String getVersi() {
		return versi;
	}

	public void setVersi(String versi) {
		this.versi = versi;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int i) {
		this.status = i;
	}

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}
	
}
