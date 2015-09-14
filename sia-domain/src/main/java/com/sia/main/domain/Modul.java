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
	
	@Column(name = "lokasi_konf_servlet", nullable = true)
	private String lokasiKonfigurasiServlet;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "modul")
	private List<Menu> menus = new ArrayList<Menu>();

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "status_modul", nullable = false)
	private StatusPlugin status;
	
	@Column(name = "osgi_bundle_id", nullable = false)
	private String osgiBundleId; 
	
	public Modul(){
	}

	public Modul(UUID idModul, String namaModul, String urlMapping,
			String versi, String lokasiKonfigurasiServlet, List<Menu> menus,
			StatusPlugin status, String osgiBundleId) {
		super();
		this.idModul = idModul;
		this.namaModul = namaModul;
		this.urlMapping = urlMapping;
		this.versi = versi;
		this.lokasiKonfigurasiServlet = lokasiKonfigurasiServlet;
		this.menus = menus;
		this.status = status;
		this.osgiBundleId = osgiBundleId;
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

	public StatusPlugin getStatus() {
		return status;
	}

	public void setStatus(StatusPlugin statusPlugin) {
		this.status = statusPlugin;
	}

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	public String getLokasiKonfigurasiServlet() {
		return lokasiKonfigurasiServlet;
	}

	public void setLokasiKonfigurasiServlet(String lokasiKonfigurasiServlet) {
		this.lokasiKonfigurasiServlet = lokasiKonfigurasiServlet;
	}

	public String getOsgiBundleId() {
		return osgiBundleId;
	}

	public void setOsgiBundleId(String osgiBundleId) {
		this.osgiBundleId = osgiBundleId;
	}

}
