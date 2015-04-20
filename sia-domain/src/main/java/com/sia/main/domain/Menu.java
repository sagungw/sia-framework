package com.sia.main.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "menu")
public class Menu {

	@Id
	@GeneratedValue(generator = "uuid-generator")
	@GenericGenerator(name = "uuid-generator", strategy = "uuid2")
	@Column(name = "id_menu")
	private UUID idMenu;
	
	@Column(name = "nama_menu")
	private String namaMenu;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_modul", nullable = false)
	private Modul modul;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "menu")
	private List<MenuPeran> menuPerans = new ArrayList<MenuPeran>();

	protected Menu(UUID idMenu, String namaMenu, Modul modul,
			List<MenuPeran> menuPerans) {
		this.idMenu = idMenu;
		this.namaMenu = namaMenu;
		this.modul = modul;
		this.menuPerans = menuPerans;
	}

	public UUID getIdMenu() {
		return idMenu;
	}

	public void setIdMenu(UUID idMenu) {
		this.idMenu = idMenu;
	}

	public String getNamaMenu() {
		return namaMenu;
	}

	public void setNamaMenu(String namaMenu) {
		this.namaMenu = namaMenu;
	}

	public Modul getModul() {
		return modul;
	}

	public void setModul(Modul modul) {
		this.modul = modul;
	}

	public List<MenuPeran> getMenuPerans() {
		return menuPerans;
	}

	public void setMenuPerans(List<MenuPeran> menuPerans) {
		this.menuPerans = menuPerans;
	}
	
}
