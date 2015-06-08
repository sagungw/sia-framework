package com.sia.main.domain;

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
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name="sat_man")
public class SatMan{
	
	@Id
	@Column(name="id_sat_man")
	@GeneratedValue(generator="uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Type(type="pg-uuid")
	private UUID idSatMan; 
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sat_id_sat_man", nullable = false)
	private SatMan satManInduk;
	
	@Column(name="nm_sat_man")
	private String nmSatMan;
	
	@Column(name="a_sat_man_aktif")
	private boolean aSatManAktif; 
 
	@Transient
	private List<SatMan> child;
	
	public SatMan() {
		
	}
	
	public UUID getIdSatMan() {
		return idSatMan;
	}

	public void setIdSatMan(UUID idSatMan) {
		this.idSatMan = idSatMan;
	}
	
	public SatMan getSatManInduk() {
		return satManInduk;
	}

	public void setSatManInduk(SatMan satManInduk) {
		this.satManInduk = satManInduk;
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