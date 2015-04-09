package com.sia.main.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "satuan_manajemen")
public class SatuanManajemen {
	
	@Id
	@Column(name = "id_sat_man")
	private String idSatuanManajemen;
	
	@Column(name = "nama_sat_man")
	private String namaSatuanManajemen;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sat_id_sat_man", nullable = true)
	private SatuanManajemen satuanManajemen;
	
	@Column(name = "a_sat_man_aktif")
	private String statusKeaktifan;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "satuanManajemen")
	private List<SatuanManajemen> satuanManajemens = new ArrayList<SatuanManajemen>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "satuanManajemen")
	private List<Pengguna> pengguna = new ArrayList<Pengguna>();

	protected SatuanManajemen(String idSatuanManajemen,
			String namaSatuanManajemen, SatuanManajemen satuanManajemen,
			String statusKeaktifan, List<SatuanManajemen> satuanManajemens,
			List<Pengguna> pengguna) {
		this.idSatuanManajemen = idSatuanManajemen;
		this.namaSatuanManajemen = namaSatuanManajemen;
		this.satuanManajemen = satuanManajemen;
		this.statusKeaktifan = statusKeaktifan;
		this.satuanManajemens = satuanManajemens;
		this.pengguna = pengguna;
	}

	public String getIdSatuanManajemen() {
		return idSatuanManajemen;
	}

	public void setIdSatuanManajemen(String idSatuanManajemen) {
		this.idSatuanManajemen = idSatuanManajemen;
	}

	public String getNamaSatuanManajemen() {
		return namaSatuanManajemen;
	}

	public void setNamaSatuanManajemen(String namaSatuanManajemen) {
		this.namaSatuanManajemen = namaSatuanManajemen;
	}

	public SatuanManajemen getSatuanManajemen() {
		return satuanManajemen;
	}

	public void setSatuanManajemen(SatuanManajemen satuanManajemen) {
		this.satuanManajemen = satuanManajemen;
	}

	public String getStatusKeaktifan() {
		return statusKeaktifan;
	}

	public void setStatusKeaktifan(String statusKeaktifan) {
		this.statusKeaktifan = statusKeaktifan;
	}

	public List<SatuanManajemen> getSatuanManajemens() {
		return satuanManajemens;
	}

	public void setSatuanManajemens(List<SatuanManajemen> satuanManajemens) {
		this.satuanManajemens = satuanManajemens;
	}

	public List<Pengguna> getPengguna() {
		return pengguna;
	}

	public void setPengguna(List<Pengguna> pengguna) {
		this.pengguna = pengguna;
	}

}
