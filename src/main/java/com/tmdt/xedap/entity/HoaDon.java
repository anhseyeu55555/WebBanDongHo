package com.tmdt.xedap.entity;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "hoa_don")
public class HoaDon {

	@Id
	private String mahd;
	
	private LocalDate ngaylap;
	
	private float thanhtien;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="madh")
	private DonHang donhang;

	public HoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HoaDon(String mahd, LocalDate ngaylap, float thanhtien, DonHang donhang) {
		super();
		this.mahd = mahd;
		this.ngaylap = ngaylap;
		this.thanhtien = thanhtien;
		this.donhang = donhang;
	}

	public String getMahd() {
		return mahd;
	}

	public void setMahd(String mahd) {
		this.mahd = mahd;
	}

	public LocalDate getNgaylap() {
		return ngaylap;
	}

	public void setNgaylap(LocalDate ngaylap) {
		this.ngaylap = ngaylap;
	}

	public float getThanhtien() {
		return thanhtien;
	}

	public void setThanhtien(float thanhtien) {
		this.thanhtien = thanhtien;
	}

	public DonHang getDonhang() {
		return donhang;
	}

	public void setDonhang(DonHang donhang) {
		this.donhang = donhang;
	}
}
