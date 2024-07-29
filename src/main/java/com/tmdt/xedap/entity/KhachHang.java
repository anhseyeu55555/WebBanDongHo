package com.tmdt.xedap.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "khach_hang")
public class KhachHang {
	
	@Id
	private String makh;
	
	@Column(name = "hoten")
	private String hoTen;
	@Column(name = "gioitinh")
	private String gioiTinh;
	private String sdt;
	private String diaChi;
	private String email;
	
	
	@ManyToOne
	@JoinColumn(name = "username")
	private TaiKhoan taikhoan;
	

	@JsonIgnore
	@OneToMany(mappedBy = "khachhang")
	private List<DonHang> listDH;
	
	@JsonIgnore
	@OneToMany(mappedBy = "khachhang")
	private List<BinhLuan> listBL;
	

	public KhachHang() {
		super();
		// TODO Auto-generated constructor stub
	}


	public KhachHang(String makh, String hoTen, String gioiTinh, String sdt, String diaChi, String email,
			TaiKhoan taikhoan, List<DonHang> listDH, List<BinhLuan> listBL) {
		super();
		this.makh = makh;
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.sdt = sdt;
		this.diaChi = diaChi;
		this.email = email;
		this.taikhoan = taikhoan;
		this.listDH = listDH;
		this.listBL = listBL;
	}


	public String getMakh() {
		return makh;
	}


	public void setMakh(String makh) {
		this.makh = makh;
	}


	public String getHoTen() {
		return hoTen;
	}


	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}


	public String getGioiTinh() {
		return gioiTinh;
	}


	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}


	public String getSdt() {
		return sdt;
	}


	public void setSdt(String sdt) {
		this.sdt = sdt;
	}


	public String getDiaChi() {
		return diaChi;
	}


	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public TaiKhoan getTaikhoan() {
		return taikhoan;
	}


	public void setTaikhoan(TaiKhoan taikhoan) {
		this.taikhoan = taikhoan;
	}


	public List<DonHang> getListDH() {
		return listDH;
	}


	public void setListDH(List<DonHang> listDH) {
		this.listDH = listDH;
	}


	public List<BinhLuan> getListBL() {
		return listBL;
	}


	public void setListBL(List<BinhLuan> listBL) {
		this.listBL = listBL;
	}

	
}
