package com.sia.main.domain;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="sat_man")
public class SatMan{
	
	@Id
	@Column(name="id_sat_man")
	@GeneratedValue(generator="uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@org.hibernate.annotations.Type(type="pg-uuid")
	private UUID idSatMan; 
	
	@Column(name="sat_id_sat_man")
	@org.hibernate.annotations.Type(type="pg-uuid")
	private UUID idSatManInduk;
	
	@Column(name="nm_sat_man")
	private String nmSatMan;
	
	@Column(name="a_sat_man_aktif")
	private boolean aSatManAktif; 
 
	@Transient
	private List<SatMan> child;
	
	public UUID getIdSatMan() {
		return idSatMan;
	}

	public void setIdSatMan(UUID idSatMan) {
		this.idSatMan = idSatMan;
	}

	public UUID getIdSatManInduk() {
		return idSatManInduk;
	}

	public void setIdSatManInduk(UUID idSatManInduk) {
		this.idSatManInduk = idSatManInduk;
	}

	public String getNmSatMan() {
		return nmSatMan;
	}

	public void setNmSatMan(String nmSatMan) {
		this.nmSatMan = nmSatMan;
	}

	public boolean getaSatManAktif() {
		return aSatManAktif;
	}

	public void setaSatManAktif(boolean aSatManAktif) {
		this.aSatManAktif = aSatManAktif;
	}

	public List<SatMan> getChild() {
		return child;
	}

	public void setChild(List<SatMan> child) {
		this.child = child;
	}
	
}