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
import org.hibernate.annotations.Type;

@Entity
@Table(name = "menu")
public class Menu {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Type(type = "pg-uuid")
	@Column(name = "id_menu")
	private UUID idMenu;

	@Column(name = "nama_menu", nullable = false)
	private String namaMenu;

	@Column(name = "url_pattern", nullable = false)
	private String urlPattern;

	@Column(name = "home_url", nullable = false)
	private String homeUrl;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_modul", nullable = false)
	private Modul modul;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "menu")
	private List<MenuPeran> daftarMenuPeran = new ArrayList<MenuPeran>();

	public Menu() {
		
	}
	
	protected Menu(UUID idMenu, String namaMenu, String urlPattern,
			String homeUrl, Modul modul, List<MenuPeran> daftarMenuPeran) {
		this.idMenu = idMenu;
		this.namaMenu = namaMenu;
		this.urlPattern = urlPattern;
		this.homeUrl = homeUrl;
		this.modul = modul;
		this.daftarMenuPeran = daftarMenuPeran;
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

	public String getUrlPattern() {
		return urlPattern;
	}

	public void setUrlPattern(String urlPattern) {
		this.urlPattern = urlPattern;
	}

	public String getHomeUrl() {
		return homeUrl;
	}

	public void setHomeUrl(String homeUrl) {
		this.homeUrl = homeUrl;
	}

	public Modul getModul() {
		return modul;
	}

	public void setModul(Modul modul) {
		this.modul = modul;
	}

	public List<MenuPeran> getDaftarMenuPeran() {
		return daftarMenuPeran;
	}

	public void setDaftarMenuPeran(List<MenuPeran> daftarMenuPeran) {
		this.daftarMenuPeran = daftarMenuPeran;
	}
	
}
