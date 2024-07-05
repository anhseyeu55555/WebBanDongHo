package com.tmdt.xedap.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class GioHang_ID  implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	private String makh;
	private String masp;
	public GioHang_ID() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GioHang_ID(String makh, String masp) {
		super();
		this.makh = makh;
		this.masp = masp;
	}
	public String getMakh() {
		return makh;
	}
	public void setMakh(String makh) {
		this.makh = makh;
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
