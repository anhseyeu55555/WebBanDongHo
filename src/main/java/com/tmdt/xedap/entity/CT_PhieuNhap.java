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
@Table(name = "ct_phieu_nhap")
public class CT_PhieuNhap implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private CT_PhieuNhap_ID id;
	
	private int soluong;
	
	private float gia;
	
	
	@ManyToOne
	@MapsId("masp")
	@JoinColumn(name ="masp")
	private SanPham sanpham;
	
	
	@JsonIgnore
	@ManyToOne
	@MapsId("mapn")
	@JoinColumn(name ="mapn")
	private PhieuNhap phieunhap;

	public CT_PhieuNhap() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CT_PhieuNhap(CT_PhieuNhap_ID id, int soluong, float gia, SanPham sanpham, PhieuNhap phieunhap) {
		super();
		this.id = id;
		this.soluong = soluong;
		this.gia = gia;
		this.sanpham = sanpham;
		this.phieunhap = phieunhap;
	}

	public CT_PhieuNhap_ID getId() {
		return id;
	}

	public void setId(CT_PhieuNhap_ID id) {
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

	public PhieuNhap getPhieunhap() {
		return phieunhap;
	}

	public void setPhieunhap(PhieuNhap phieunhap) {
		this.phieunhap = phieunhap;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
}
