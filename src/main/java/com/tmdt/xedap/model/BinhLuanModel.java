package com.tmdt.xedap.model;

public class BinhLuanModel {

	private String noidung;
	private String makh;
	private String masp;
	
	
	public BinhLuanModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public BinhLuanModel(String noidung, String makh, String masp) {
		super();
		this.noidung = noidung;
		this.makh = makh;
		this.masp = masp;
	}
	
	
	public String getNoidung() {
		return noidung;
	}
	public void setNoidung(String noidung) {
		this.noidung = noidung;
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
	
	
}
