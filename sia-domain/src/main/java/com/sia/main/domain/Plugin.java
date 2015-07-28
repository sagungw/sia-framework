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
import org.hibernate.annotations.Type;

@Entity
@Table(name = "plugin")
public class Plugin {
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Type(type = "pg-uuid")
	@Column(name = "id_plugin")
	private UUID idPlugin;
	
	@Column(name = "nama_plugin", nullable = false)
	private String namaPlugin;
	
	@Column(name = "versi", nullable = false)
	private String versi;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "status_plugin", nullable = false)
	private StatusPlugin statusPlugin;
	
	public Plugin() {
		
	}
	
	public Plugin(UUID idPlugin, String namaPlugin, String versi,
			StatusPlugin statusPlugin) {
		super();
		this.idPlugin = idPlugin;
		this.namaPlugin = namaPlugin;
		this.versi = versi;
		this.statusPlugin = statusPlugin;
	}

	public UUID getIdPlugin() {
		return idPlugin;
	}

	public void setIdPlugin(UUID idPlugin) {
		this.idPlugin = idPlugin;
	}

	public String getNamaPlugin() {
		return namaPlugin;
	}

	public void setNamaPlugin(String namaPlugin) {
		this.namaPlugin = namaPlugin;
	}

	public String getVersi() {
		return versi;
	}

	public void setVersi(String versi) {
		this.versi = versi;
	}

	public StatusPlugin getStatusPlugin() {
		return statusPlugin;
	}

	public void setStatusPlugin(StatusPlugin statusPlugin) {
		this.statusPlugin = statusPlugin;
	}
	
}
