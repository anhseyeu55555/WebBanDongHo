package com.tmdt.xedap.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class CT_DonDatHang_ID implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String maddh;
	private String masp;
	
	
	public CT_DonDatHang_ID() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public CT_DonDatHang_ID(String maddh, String masp) {
		super();
		this.maddh = maddh;
		this.masp = masp;
	}
	
	
	public String getMaddh() {
		return maddh;
	}
	public void setMaddh(String maddh) {
		this.maddh = maddh;
	}
	public String getMasp() {
		return masp;
	}
	public void setMasp(String masp) {
		this.masp = masp;
	}

	
	
}
