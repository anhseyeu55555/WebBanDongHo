package com.tmdt.xedap.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "binh_luan")
public class BinhLuan {

	@Id
	private String mabl;
	private String noidung;
	
	private Date time;
	
	@ManyToOne
	@JoinColumn(name="makh")
	private KhachHang khachhang;
	
	@ManyToOne
	@JoinColumn(name="masp")
	private SanPham sanpham;

	public BinhLuan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BinhLuan(String mabl, String noidung, Date time, KhachHang khachhang, SanPham sanpham) {
		super();
		this.mabl = mabl;
		this.noidung = noidung;
		this.time = time;
		this.khachhang = khachhang;
		this.sanpham = sanpham;
	}

	public String getMabl() {
		return mabl;
	}

	public void setMabl(String mabl) {
		this.mabl = mabl;
	}

	public String getNoidung() {
		return noidung;
	}

	public void setNoidung(String noidung) {
		this.noidung = noidung;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public KhachHang getKhachhang() {
		return khachhang;
	}

	public void setKhachhang(KhachHang khachhang) {
		this.khachhang = khachhang;
	}

	public SanPham getSanpham() {
		return sanpham;
	}

	public void setSanpham(SanPham sanpham) {
		this.sanpham = sanpham;
	}
}
