package com.tmdt.xedap.model;

import java.util.List;

public class DonHangModel {
	
	private int hinhThucThanhToan;
	private String hoTen;
	private String diaChi;
	private String sdt;
	private String email;
	private String ghichu;
	private String makh;
	
	private List<SanPhamDatHangModel> dsSanPham;
	
	public DonHangModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DonHangModel(int hinhThucThanhToan, String hoTen, String diaChi, String sdt, String email, String ghichu,
			String makh, List<SanPhamDatHangModel> dsSanPham) {
		super();
		this.hinhThucThanhToan = hinhThucThanhToan;
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.sdt = sdt;
		this.email = email;
		this.ghichu = ghichu;
		this.makh = makh;
		this.dsSanPham = dsSanPham;
	}

	public int getHinhThucThanhToan() {
		return hinhThucThanhToan;
	}

	public void setHinhThucThanhToan(int hinhThucThanhToan) {
		this.hinhThucThanhToan = hinhThucThanhToan;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGhichu() {
		return ghichu;
	}

	public void setGhichu(String ghichu) {
		this.ghichu = ghichu;
	}

	public String getMakh() {
		return makh;
	}

	public void setMakh(String makh) {
		this.makh = makh;
	}

	public List<SanPhamDatHangModel> getDsSanPham() {
		return dsSanPham;
	}

	public void setDsSanPham(List<SanPhamDatHangModel> dsSanPham) {
		this.dsSanPham = dsSanPham;
	}


}
