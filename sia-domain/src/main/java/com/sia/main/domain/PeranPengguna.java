package com.sia.main.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "peran_pengguna")
public class PeranPengguna {
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pengguna", nullable = false)
	private Pengguna pengguna;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_peran", nullable = false)
	private Peran peran;

	protected PeranPengguna(Pengguna pengguna, Peran peran) {
		super();
		this.pengguna = pengguna;
		this.peran = peran;
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
