package com.tmdt.xedap.entity;


import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table (name = "gio_hang")
public class GioHang {

	@EmbeddedId
	private GioHang_ID id;
	
	private int soluong;
	
	
	@ManyToOne
	@MapsId("makh")
	@JoinColumn(name="makh")
	private KhachHang khachhang;
	
	@ManyToOne
	@MapsId("masp")
	@JoinColumn(name="masp")
	private SanPham sanpham;


	public GioHang() {
		super();
		// TODO Auto-generated constructor stub
	}


	public GioHang(GioHang_ID id, int soluong, KhachHang khachhang, SanPham sanpham) {
		super();
		this.id = id;
		this.soluong = soluong;
		this.khachhang = khachhang;
		this.sanpham = sanpham;
	}


	public GioHang_ID getId() {
		return id;
	}


	public void setId(GioHang_ID id) {
		this.id = id;
	}


	public int getSoluong() {
		return soluong;
	}


	public void setSoluong(int soluong) {
		this.soluong = soluong;
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
