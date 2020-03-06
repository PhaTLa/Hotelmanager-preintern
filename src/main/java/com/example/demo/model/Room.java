package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="rooms")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Room implements Serializable {
	private static final long serialVersionUID = 2L;
	@Column(name="roomnumber")
	private int number;
	@Column(name="roomstatus")
	private String status;
	@Column(name="idprice")
	private int idprice;
	@Id
//	@GeneratedValue(strategy =GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	
	public Room() {
		
		
	}

	public Room(int number, String status, int id,int idprice ) {
		
		this.number = number;
		this.status = status;
		this.idprice = idprice;
		this.id = id;
		
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdprice() {
		return idprice;
	}

	public void setIdprice(int idprice) {
		this.idprice = idprice;
	}

	
	
	
}
