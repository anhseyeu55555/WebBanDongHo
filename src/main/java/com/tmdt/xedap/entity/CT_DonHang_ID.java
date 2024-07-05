package com.tmdt.xedap.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class CT_DonHang_ID implements Serializable {

	private static final long serialVersionUID = 1L;
	private String madh;
	private String masp;
	public CT_DonHang_ID() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CT_DonHang_ID(String madh, String masp) {
		super();
		this.madh = madh;
		this.masp = masp;
	}
	public String getMadh() {
		return madh;
	}
	public void setMadh(String madh) {
		this.madh = madh;
	}
	public String getMasp() {
		return masp;
	}
	public void setMasp(String masp) {
		this.masp = masp;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
