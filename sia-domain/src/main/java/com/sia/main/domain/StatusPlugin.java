package com.sia.main.domain;

import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "status_plugin")
public class StatusPlugin {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Type(type = "pg-uuid")
	@Column(name = "id_status")
	private UUID idStatus;
	
	@Column(name = "nama_status")
	private String namaStatus;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "status")
	private List<Modul> modules;
	
	public StatusPlugin() {
	}
	
	public UUID getIdStatus() {
		return idStatus;
	}

	public void setIdStatus(UUID idStatus) {
		this.idStatus = idStatus;
	}

	public String getNamaStatus() {
		return namaStatus;
	}

	public void setNamaStatus(String namaStatus) {
		this.namaStatus = namaStatus;
	}

	public List<Modul> getModules() {
		return modules;
	}

	public void setModules(List<Modul> modules) {
		this.modules = modules;
	}
	
}
