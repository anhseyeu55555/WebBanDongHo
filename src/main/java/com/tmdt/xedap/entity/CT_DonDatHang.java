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
@Table (name = "ct_don_dat_hang")
public class CT_DonDatHang implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private CT_DonDatHang_ID id;
	
	private int soluong;
	
	private float gia;
	
	@JsonIgnore
	@ManyToOne
	@MapsId("maddh")
	@JoinColumn(name ="maddh")
	DonDatHang dondathang;
	
	@ManyToOne
	@MapsId("masp")
	@JoinColumn(name ="masp")
	SanPham sanpham;

	public CT_DonDatHang() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CT_DonDatHang(CT_DonDatHang_ID id, int soluong, float gia, DonDatHang dondathang, SanPham sanpham) {
		super();
		this.id = id;
		this.soluong = soluong;
		this.gia = gia;
		this.dondathang = dondathang;
		this.sanpham = sanpham;
	}

	public CT_DonDatHang_ID getId() {
		return id;
	}

	public void setId(CT_DonDatHang_ID id) {
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

	public DonDatHang getDondathang() {
		return dondathang;
	}

	public void setDondathang(DonDatHang dondathang) {
		this.dondathang = dondathang;
	}

	public SanPham getSanpham() {
		return sanpham;
	}

	public void setSanpham(SanPham sanpham) {
		this.sanpham = sanpham;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	
	
}
