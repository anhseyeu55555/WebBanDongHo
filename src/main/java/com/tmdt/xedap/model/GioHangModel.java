package com.tmdt.xedap.model;

public class GioHangModel {

	
	private String makh;
	private String masp;
	private int soluong;
	
	
	public GioHangModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public GioHangModel(String makh, String masp, int soluong) {
		super();
		this.makh = makh;
		this.masp = masp;
		this.soluong = soluong;
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
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	
	
	
}
