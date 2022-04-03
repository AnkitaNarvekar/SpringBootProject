package com.ankita.SportShoesProject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long oid;
	
	@Column(name = "order_user_name",nullable=false,length=20)
	private String oname;
	
	@Column(name = "order_product_name",nullable=false,length=20)
	private String oproduct;
	
	@Column(name = "date",nullable=false,length=20)
	private String date;

	@Column(name = "order_category",nullable=false,length=20)
	private String ocategory;

	public Long getOid() {
		return oid;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}

	public String getOname() {
		return oname;
	}

	public void setOname(String oname) {
		this.oname = oname;
	}

	public String getOproduct() {
		return oproduct;
	}

	public void setOproduct(String oproduct) {
		this.oproduct = oproduct;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getOcategory() {
		return ocategory;
	}

	public void setOcategory(String ocategory) {
		this.ocategory = ocategory;
	}

	@Override
	public String toString() {
		return "Order [oid=" + oid + ", oname=" + oname + ", oproduct=" + oproduct + ", date=" + date + ", ocategory="
				+ ocategory + "]";
	}

	public Order(Long oid, String oname, String oproduct, String date, String ocategory) {
		super();
		this.oid = oid;
		this.oname = oname;
		this.oproduct = oproduct;
		this.date = date;
		this.ocategory = ocategory;
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
