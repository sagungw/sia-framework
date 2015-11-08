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
	
	@Column(name = "url_mapping", nullable = true)
	private String urlMapping;
	
	@Column(name = "versi", nullable = false)
	private String versi;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "status_modul", nullable = false)
	private StatusPlugin status;
	
	@Column(name = "osgi_bundle_id", nullable = false)
	private String osgiBundleId;
	
	@Column(name = "lokasi_konf_servlet", nullable = false)
	private String lokasiKonfigServlet;
	
	@Column(name = "nama_servlet", nullable = false)
	private String namaServlet;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "modul")
	private List<Menu> menus;
	
	public Modul(){
		this.menus = new ArrayList<Menu>();
	}

	public Modul(UUID idModul, String namaModul, String urlMapping,
			String versi, StatusPlugin status,String osgiBundleId, 
			String lokasiKonfigServlet, String namaServlet, List<Menu> menus) {
		super();
		this.idModul = idModul;
		this.namaModul = namaModul;
		this.setUrlMapping(urlMapping);
		this.versi = versi;
		this.status = status;
		this.osgiBundleId = osgiBundleId;
		this.lokasiKonfigServlet = lokasiKonfigServlet;
		this.setNamaServlet(namaServlet);
		this.menus = menus;
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
		this.urlMapping = this.standardizeUrlMapping(urlMapping);
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

	public void setStatus(StatusPlugin status) {
		this.status = status;
	}

	public String getOsgiBundleId() {
		return osgiBundleId;
	}

	public void setOsgiBundleId(String osgiBundleId) {
		this.osgiBundleId = osgiBundleId;
	}

	public String getLokasiKonfigServlet() {
		return lokasiKonfigServlet;
	}
	
	public List<String> getServletConfigLocationList() {
		List<String> configLocations = new ArrayList<String>();
		String locs = this.lokasiKonfigServlet.replace(" ", "");
		for(String loc : locs.split(",")) {
			configLocations.add(loc);
		}
		return configLocations;
	}

	public void setLokasiKonfigServlet(String lokasiKonfigServlet) {
		this.lokasiKonfigServlet = lokasiKonfigServlet;
	}

	public void setNamaServlet(String namaServlet) {
		if(namaServlet.equals("") || namaServlet == null) {
			this.namaServlet = standardizeServletName(this.namaModul);
		} else {
			this.namaServlet = standardizeServletName(namaServlet);
		}
	}

	public String getNamaServlet() {
		return namaServlet;
	}

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}
	
	public void addMenu(Menu menu) {
		this.menus.add(menu);
	}

	private String standardizeUrlMapping(String urlMapping) {
		if(urlMapping != null && !urlMapping.equals("")) {
			StringBuilder result = new StringBuilder();
			if(urlMapping.charAt(0) != '/') {
				result.append('/');
			}
			if(urlMapping.charAt(urlMapping.length()-1) != '*') {
				if(urlMapping.charAt(urlMapping.length()-1) != '/') {
					result.append(urlMapping + "/*");
				} else {
					result.append(urlMapping + "*");
				}
			} else {
				result.append(urlMapping);
			}
			return result.toString();
		} else {
			return null;
		}
	}
	
	private String standardizeServletName(String servletName) {
		if(servletName != null && !servletName.equals("")) {
			StringBuilder servletNameSb = new StringBuilder();
			int i = 0;
			String[] moduleName = servletName.toLowerCase().split(" ");
			for(String string: moduleName) {
				if(i > 0) servletNameSb.append('-');
				servletNameSb.append(string);
				i++;
			}
			if(!servletName.toLowerCase().contains("-servlet")) 
				servletNameSb.append("-servlet");
			return servletNameSb.toString();
		} else {
			return "";
		}
	}
	
}
