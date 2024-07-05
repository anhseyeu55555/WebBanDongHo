package com.tmdt.xedap.model;

public class SanPhamDatHangModel {
	
	String masp;
	int soluong;
	float dongia;
	
	
	public SanPhamDatHangModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public SanPhamDatHangModel(String masp, int soluong, float dongia) {
		super();
		this.masp = masp;
		this.soluong = soluong;
		this.dongia = dongia;
	}
	
	public String getMasp() {
		return masp;
	}
	public void setMasp(String masp) {
		this.masp = masp;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public float getDongia() {
		return dongia;
	}
	public void setDongia(float dongia) {
		this.dongia = dongia;
	}
	
	
}
