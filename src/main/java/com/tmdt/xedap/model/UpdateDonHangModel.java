package com.tmdt.xedap.model;

public class UpdateDonHangModel {

	private String madh;
	private String manv;
	private String manvgh;
	private int trangthai;
	private int hinhThucThanhToan;
	
	
	public UpdateDonHangModel() {
		super();
		// TODO Auto-generated constructor stub
	}


	public UpdateDonHangModel(String madh, String manv, String manvgh, int trangthai, int hinhThucThanhToan) {
		super();
		this.madh = madh;
		this.manv = manv;
		this.manvgh = manvgh;
		this.trangthai = trangthai;
		this.hinhThucThanhToan = hinhThucThanhToan;
	}


	public String getMadh() {
		return madh;
	}


	public void setMadh(String madh) {
		this.madh = madh;
	}


	public String getManv() {
		return manv;
	}


	public void setManv(String manv) {
		this.manv = manv;
	}


	public String getManvgh() {
		return manvgh;
	}


	public void setManvgh(String manvgh) {
		this.manvgh = manvgh;
	}


	public int getTrangthai() {
		return trangthai;
	}


	public void setTrangthai(int trangthai) {
		this.trangthai = trangthai;
	}


	public int getHinhThucThanhToan() {
		return hinhThucThanhToan;
	}


	public void setHinhThucThanhToan(int hinhThucThanhToan) {
		this.hinhThucThanhToan = hinhThucThanhToan;
	}
}
