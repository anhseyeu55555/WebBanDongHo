package com.tmdt.xedap.model;

public class HoaDonModel {
	
	private String madh;
	private float thanhtien;
	
	
	public HoaDonModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public HoaDonModel(String madh, float thanhtien) {
		super();
		this.madh = madh;
		this.thanhtien = thanhtien;
	}
	
	
	public String getMadh() {
		return madh;
	}
	
	
	public void setMadh(String madh) {
		this.madh = madh;
	}
	
	
	public float getThanhtien() {
		return thanhtien;
	}
	
	
	public void setThanhtien(float thanhtien) {
		this.thanhtien = thanhtien;
	}
	
	

}
