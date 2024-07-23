package com.tmdt.xedap.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "don_hang")
public class DonHang {

	@Id
	private String madh;
	
	private int hinhThucThanhToan;
	private LocalDate ngayDat;
	private float tongTien;
	private int trangThai;
	private String hoTen;
	private String diaChi;
	private String sdt;
	private String email;
	private String ghichu;
	
	@ManyToOne
	@JoinColumn(name = "manv", nullable = true)
	private NhanVien nhanvien;
	
	@ManyToOne
	@JoinColumn(name = "manvgh", nullable = true)
	private NhanVien giaohang;
	
	
	@ManyToOne
	@JoinColumn(name = "makh")
	private KhachHang khachhang;
	
	@JsonIgnore
	@OneToOne(mappedBy = "donhang", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private HoaDon hoadon;
	
	public DonHang() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DonHang(String madh, int hinhThucThanhToan, LocalDate ngayDat, float tongTien, int trangThai, String hoTen,
			String diaChi, String sdt, String email, String ghichu, NhanVien nhanvien, NhanVien giaohang,
			KhachHang khachhang, HoaDon hoadon) {
		super();
		this.madh = madh;
		this.hinhThucThanhToan = hinhThucThanhToan;
		this.ngayDat = ngayDat;
		this.tongTien = tongTien;
		this.trangThai = trangThai;
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.sdt = sdt;
		this.email = email;
		this.ghichu = ghichu;
		this.nhanvien = nhanvien;
		this.giaohang = giaohang;
		this.khachhang = khachhang;
		this.hoadon = hoadon;
	}

	public String getMadh() {
		return madh;
	}

	public void setMadh(String madh) {
		this.madh = madh;
	}

	public int getHinhThucThanhToan() {
		return hinhThucThanhToan;
	}

	public void setHinhThucThanhToan(int hinhThucThanhToan) {
		this.hinhThucThanhToan = hinhThucThanhToan;
	}

	public LocalDate getNgayDat() {
		return ngayDat;
	}

	public void setNgayDat(LocalDate ngayDat) {
		this.ngayDat = ngayDat;
	}

	public float getTongTien() {
		return tongTien;
	}

	public void setTongTien(float tongTien) {
		this.tongTien = tongTien;
	}

	public int getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
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

	public NhanVien getNhanvien() {
		return nhanvien;
	}

	public void setNhanvien(NhanVien nhanvien) {
		this.nhanvien = nhanvien;
	}

	public NhanVien getGiaohang() {
		return giaohang;
	}

	public void setGiaohang(NhanVien giaohang) {
		this.giaohang = giaohang;
	}

	public KhachHang getKhachhang() {
		return khachhang;
	}

	public void setKhachhang(KhachHang khachhang) {
		this.khachhang = khachhang;
	}

	public HoaDon getHoadon() {
		return hoadon;
	}

	public void setHoadon(HoaDon hoadon) {
		this.hoadon = hoadon;
	}
	
	

}
