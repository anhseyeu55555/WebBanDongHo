package com.tmdt.xedap.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;


@Embeddable
public class CT_PhieuNhap_ID implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private String mapn;
	private String masp;
	
	
	public CT_PhieuNhap_ID() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CT_PhieuNhap_ID(String mapn, String masp) {
		super();
		this.mapn = mapn;
		this.masp = masp;
	}


	public String getMapn() {
		return mapn;
	}


	public void setMapn(String mapn) {
		this.mapn = mapn;
	}


	public String getMasp() {
		return masp;
	}


	public void setMasp(String masp) {
		this.masp = masp;
	}
	
	
}
