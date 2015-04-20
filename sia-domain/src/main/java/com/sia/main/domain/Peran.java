package com.sia.main.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "peran")
public class Peran {
	
	@Id
	@GeneratedValue(generator = "uuid-generator")
	@GenericGenerator(name = "uuid-generator", strategy = "uuid2")
	@Column(name = "id_peran")
	private UUID idPeran;
	
	@Column(name = "nama_peran")
	private String namaPeran;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "peran")
	private List<PeranPengguna> peranPenggunas = new ArrayList<PeranPengguna>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "peran")
	private List<MenuPeran> menuPerans = new ArrayList<MenuPeran>();

	protected Peran(UUID idPeran, String namaPeran,
			List<PeranPengguna> peranPenggunas, List<MenuPeran> menuPerans) {
		this.idPeran = idPeran;
		this.namaPeran = namaPeran;
		this.peranPenggunas = peranPenggunas;
		this.menuPerans = menuPerans;
	}

	public UUID getIdPeran() {
		return idPeran;
	}

	public void setIdPeran(UUID idPeran) {
		this.idPeran = idPeran;
	}

	public String getNamaPeran() {
		return namaPeran;
	}

	public void setNamaPeran(String namaPeran) {
		this.namaPeran = namaPeran;
	}

	public List<PeranPengguna> getPeranPenggunas() {
		return peranPenggunas;
	}

	public void setPeranPenggunas(List<PeranPengguna> peranPenggunas) {
		this.peranPenggunas = peranPenggunas;
	}

	public List<MenuPeran> getMenuPerans() {
		return menuPerans;
	}

	public void setMenuPerans(List<MenuPeran> menuPerans) {
		this.menuPerans = menuPerans;
	}
	
}
