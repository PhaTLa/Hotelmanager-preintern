package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="types")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Type implements Serializable {
	public final static long serialVersionUID = 3L;
	
	@Column(name="roomtype")
	private String roomType;
	@Column(name="des")
	private String des;
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	public Type() {
		
	}

	public Type(String roomType, String des, int id) {
		super();
		this.roomType = roomType;
		this.des = des;
		this.id = id;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
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
	
}
