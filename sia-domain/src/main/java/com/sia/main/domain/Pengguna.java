package com.sia.main.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "pengguna")
public class Pengguna {

	@Id
	@GeneratedValue(generator = "uuid-generator")
	@GenericGenerator(name = "uuid-generator", strategy = "uuid2")
	@Column(name = "id_pengguna")
	private UUID idPengguna;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_sat_man", nullable = false)
	private SatuanManajemen satuanManajemen;
	
	@Column(name = "username", unique = true)
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "a_pengguna_aktif")
	private boolean statusKeaktifan;
	
	@Column(name = "kode_reset_password", unique = true, nullable = true)
	private String kodeResetPassword;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pengguna")
	private List<PeranPengguna> peranPenggunas = new ArrayList<PeranPengguna>();

	protected Pengguna(UUID idPengguna, SatuanManajemen satuanManajemen,
			String username, String password, boolean statusKeaktifan,
			String kodeResetPassword, List<PeranPengguna> peranPenggunas) {
		super();
		this.idPengguna = idPengguna;
		this.satuanManajemen = satuanManajemen;
		this.username = username;
		this.password = password;
		this.statusKeaktifan = statusKeaktifan;
		this.kodeResetPassword = kodeResetPassword;
		this.peranPenggunas = peranPenggunas;
	}

	public UUID getIdPengguna() {
		return idPengguna;
	}

	public void setIdPengguna(UUID idPengguna) {
		this.idPengguna = idPengguna;
	}

	public SatuanManajemen getSatuanManajemen() {
		return satuanManajemen;
	}

	public void setSatuanManajemen(SatuanManajemen satuanManajemen) {
		this.satuanManajemen = satuanManajemen;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isStatusKeaktifan() {
		return statusKeaktifan;
	}

	public void setStatusKeaktifan(boolean statusKeaktifan) {
		this.statusKeaktifan = statusKeaktifan;
	}

	public String getKodeResetPassword() {
		return kodeResetPassword;
	}

	public void setKodeResetPassword(String kodeResetPassword) {
		this.kodeResetPassword = kodeResetPassword;
	}

	public List<PeranPengguna> getPeranPenggunas() {
		return peranPenggunas;
	}

	public void setPeranPenggunas(List<PeranPengguna> peranPenggunas) {
		this.peranPenggunas = peranPenggunas;
	}
	
}
