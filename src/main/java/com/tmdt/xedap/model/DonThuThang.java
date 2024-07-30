package com.tmdt.xedap.model;


public class DonThuThang {
    private int thang;
    private double tongDoanhThu;
	public DonThuThang() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DonThuThang(int thang, double tongDoanhThu) {
		super();
		this.thang = thang;
		this.tongDoanhThu = tongDoanhThu;
	}
	public int getThang() {
		return thang;
	}
	public void setThang(int thang) {
		this.thang = thang;
	}
	public double getTongDoanhThu() {
		return tongDoanhThu;
	}
	public void setTongDoanhThu(double tongDoanhThu) {
		this.tongDoanhThu = tongDoanhThu;
	}
	
	
  
}