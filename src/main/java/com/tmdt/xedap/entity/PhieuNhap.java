package com.tmdt.xedap.entity;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "phieu_nhap")
public class PhieuNhap {
	
	@Id
	private String mapn;
	
	private LocalDate ngaydat;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="maddh")
	private DonDatHang dondathang;
	    
	@ManyToOne
	@JoinColumn(name="manv")
	private NhanVien nhanvien;

	public PhieuNhap() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PhieuNhap(String mapn, LocalDate ngaydat, DonDatHang dondathang, NhanVien nhanvien) {
		super();
		this.mapn = mapn;
		this.ngaydat = ngaydat;
		this.dondathang = dondathang;
		this.nhanvien = nhanvien;
	}

	public String getMapn() {
		return mapn;
	}

	public void setMapn(String mapn) {
		this.mapn = mapn;
	}

	public LocalDate getNgaydat() {
		return ngaydat;
	}

	public void setNgaydat(LocalDate ngaydat) {
		this.ngaydat = ngaydat;
	}

	public DonDatHang getDondathang() {
		return dondathang;
	}

	public void setDondathang(DonDatHang dondathang) {
		this.dondathang = dondathang;
	}

	public NhanVien getNhanvien() {
		return nhanvien;
	}

	public void setNhanvien(NhanVien nhanvien) {
		this.nhanvien = nhanvien;
	}
	
	
}
