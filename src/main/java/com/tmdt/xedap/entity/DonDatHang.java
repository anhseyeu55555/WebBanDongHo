package com.tmdt.xedap.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table (name = "don_dat_hang")
public class DonDatHang {
	
	@Id
	@Column(name="maddh", unique = true, nullable = false)
	private String mddh;
	
	@Column(name="ngaydat", nullable=false)
	private LocalDate ngaydat;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="mancc", nullable = false)
	private NhaCungCap nhacungcap;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="manv", nullable = false)
	private NhanVien nhanvien;

	@JsonIgnore
	@OneToOne(mappedBy="dondathang", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private PhieuNhap phieunhap;
	
	public DonDatHang() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DonDatHang(String mddh, LocalDate ngaydat, NhaCungCap nhacungcap, NhanVien nhanvien, PhieuNhap phieunhap) {
		super();
		this.mddh = mddh;
		this.ngaydat = ngaydat;
		this.nhacungcap = nhacungcap;
		this.nhanvien = nhanvien;
		this.phieunhap = phieunhap;
	}

	public String getMddh() {
		return mddh;
	}

	public void setMddh(String mddh) {
		this.mddh = mddh;
	}

	public LocalDate getNgaydat() {
		return ngaydat;
	}

	public void setNgaydat(LocalDate ngaydat) {
		this.ngaydat = ngaydat;
	}

	public NhaCungCap getNhacungcap() {
		return nhacungcap;
	}

	public void setNhacungcap(NhaCungCap nhacungcap) {
		this.nhacungcap = nhacungcap;
	}

	public NhanVien getNhanvien() {
		return nhanvien;
	}

	public void setNhanvien(NhanVien nhanvien) {
		this.nhanvien = nhanvien;
	}

	public PhieuNhap getPhieunhap() {
		return phieunhap;
	}

	public void setPhieunhap(PhieuNhap phieunhap) {
		this.phieunhap = phieunhap;
	}
}
