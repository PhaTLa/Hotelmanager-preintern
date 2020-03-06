package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Roomdetail {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private int roomnumber;
	private String roomstatus;
	private int pricehour;
	private int priceday;
	private String des;
	private int idprice;
	
	public Roomdetail() {
		
	}

	public Roomdetail(int id, int roomnumber, String roomstatus, int pricehour, int priceday, String des,int idtype) {
		super();
		this.id=id;
		this.roomnumber = roomnumber;
		this.roomstatus = roomstatus;
		this.pricehour = pricehour;
		this.priceday = priceday;
		this.des = des;
		this.idprice=idtype;
	}

	
	public int getRoomnumber() {
		return roomnumber;
	}

	public void setRoomnumber(int roomnumber) {
		this.roomnumber = roomnumber;
	}

	public String getRoomstatus() {
		return roomstatus;
	}

	public void setRoomstatus(String roomstatus) {
		this.roomstatus = roomstatus;
	}

	public int getPricehour() {
		return pricehour;
	}

	public void setPricehour(int pricehour) {
		this.pricehour = pricehour;
	}

	public int getPriceday() {
		return priceday;
	}

	public void setPriceday(int priceday) {
		this.priceday = priceday;
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

	public int getIdprice() {
		return idprice;
	}

	public void setIdprice(int idtype) {
		this.idprice = idtype;
	}
	
}
