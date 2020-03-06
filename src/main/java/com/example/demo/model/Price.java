package com.example.demo.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="prices")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Price implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Column(name="perhour")
	private int perHour;
	@Column(name="perday")
	private int perDay;
	@Column(name="des")
	private String des;
	@Column(name="idtype")
	private int idType;
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	
	public Price() {
		
	}

	

	public Price(int perHour, int perDay, String des, int idType, int id) {
		super();
		this.perHour = perHour;
		this.perDay = perDay;
		this.des = des;
		this.idType = idType;
		this.id = id;
	}



	public int getPerH() {
		return perHour;
	}

	public void setPerH(int perH) {
		this.perHour = perH;
	}

	public int getPerD() {
		return perDay;
	}

	public void setPerD(int perD) {
		this.perDay = perD;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdType() {
		return idType;
	}

	public void setIdType(int idType) {
		this.idType = idType;
	}
	
}
