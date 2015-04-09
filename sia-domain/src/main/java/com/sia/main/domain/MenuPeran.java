package com.sia.main.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "menu_peran")
public class MenuPeran {
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_peran", nullable = false)
	private Peran peran;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_menu", nullable = false)
	private Menu menu;

	protected MenuPeran(Peran peran, Menu menu) {
		this.peran = peran;
		this.menu = menu;
	}

	public Peran getPeran() {
		return peran;
	}

	public void setPeran(Peran peran) {
		this.peran = peran;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

}
