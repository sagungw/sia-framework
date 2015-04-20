package com.sia.main.domain;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "peran_pengguna")
public class PeranPengguna {
	
	@Id
	@GeneratedValue(generator = "uuid-generator")
	@GenericGenerator(name = "uuid-generator", strategy = "uuid2")
	@Column(name = "id_peran_pengguna")
	private UUID idPeranPengguna;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pengguna", nullable = false)
	private Pengguna pengguna;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_peran", nullable = false)
	private Peran peran;

	protected PeranPengguna(UUID idPeranPengguna, Pengguna pengguna, Peran peran) {
		super();
		this.idPeranPengguna = idPeranPengguna;
		this.pengguna = pengguna;
		this.peran = peran;
	}

	public UUID getIdPeranPengguna() {
		return idPeranPengguna;
	}

	public void setIdPeranPengguna(UUID idPeranPengguna) {
		this.idPeranPengguna = idPeranPengguna;
	}

	public Pengguna getPengguna() {
		return pengguna;
	}

	public void setPengguna(Pengguna pengguna) {
		this.pengguna = pengguna;
	}

	public Peran getPeran() {
		return peran;
	}

	public void setPeran(Peran peran) {
		this.peran = peran;
	}
	
}
