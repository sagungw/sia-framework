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
import org.hibernate.annotations.Type;

@Entity
@Table(name = "peran")
public class Peran {
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Type(type = "pg-uuid")
	@Column(name = "id_peran")
	private UUID idPeran;
	
	@Column(name = "nama_peran")
	private String namaPeran;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "peran")
	private List<PeranPengguna> peranPenggunaList = new ArrayList<PeranPengguna>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "peran")
	private List<MenuPeran> menuPeranList = new ArrayList<MenuPeran>();
	
	public Peran() {
		
	}

	public Peran(UUID idPeran, String namaPeran,
			List<PeranPengguna> peranPenggunaList, List<MenuPeran> menuPeranList) {
		super();
		this.idPeran = idPeran;
		this.namaPeran = namaPeran;
		this.peranPenggunaList = peranPenggunaList;
		this.menuPeranList = menuPeranList;
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

	public List<PeranPengguna> getPeranPenggunaList() {
		return peranPenggunaList;
	}

	public void setPeranPenggunaList(List<PeranPengguna> peranPenggunaList) {
		this.peranPenggunaList = peranPenggunaList;
	}

	public List<MenuPeran> getMenuPeranList() {
		return menuPeranList;
	}

	public void setMenuPeranList(List<MenuPeran> menuPeranList) {
		this.menuPeranList = menuPeranList;
	}
	
}
