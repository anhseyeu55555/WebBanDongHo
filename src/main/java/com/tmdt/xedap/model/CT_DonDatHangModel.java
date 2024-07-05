package com.tmdt.xedap.model;

public class CT_DonDatHangModel {

	
	private String masp;
	private int soluong;
	private float gia;
	public CT_DonDatHangModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CT_DonDatHangModel(String masp, int soluong, float gia) {
		super();
		this.masp = masp;
		this.soluong = soluong;
		this.gia = gia;
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
	public float getGia() {
		return gia;
	}
	public void setGia(float gia) {
		this.gia = gia;
	}
	
	
	
	
	
}
