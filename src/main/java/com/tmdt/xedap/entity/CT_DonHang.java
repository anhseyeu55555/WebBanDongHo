package com.tmdt.xedap.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "ct_don_hang")
public class CT_DonHang implements Serializable{

	
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CT_DonHang_ID id;
	
	private int soluong;
	private float gia;
	
	@JsonIgnore
	@ManyToOne
	@MapsId("madh")
	@JoinColumn(name ="madh")
	private DonHang donhang;
	
	@ManyToOne
	@MapsId("masp")
	@JoinColumn(name ="masp")
	private SanPham sanpham;
	

	
	public CT_DonHang() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CT_DonHang(CT_DonHang_ID id, int soluong, float gia, SanPham sanpham, DonHang donhang) {
		super();
		this.id = id;
		this.soluong = soluong;
		this.gia = gia;
		this.sanpham = sanpham;
		this.donhang = donhang;
	}

	public CT_DonHang_ID getId() {
		return id;
	}

	public void setId(CT_DonHang_ID id) {
		this.id = id;
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

	public SanPham getSanpham() {
		return sanpham;
	}

	public void setSanpham(SanPham sanpham) {
		this.sanpham = sanpham;
	}

	public DonHang getDonhang() {
		return donhang;
	}

	public void setDonhang(DonHang donhang) {
		this.donhang = donhang;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
}
