package com.tmdt.xedap.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "nhan_vien")
public class NhanVien {

	@Id
	String manv;
	
	String hoten;
	String gioitinh;
	String sdt;
	String diachi;
	String email;
	float luong;
	
	@ManyToOne
	@JoinColumn(name = "username")
	private TaiKhoan taikhoan;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "nhanvien")
	private List<DonDatHang> dondathang;
	
	@JsonIgnore
	@OneToMany(mappedBy = "nhanvien")
	List<DonHang> listDH;
	
	@JsonIgnore
	@OneToMany(mappedBy = "giaohang")
	List<DonHang> listDHGH;

	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NhanVien(String manv, String hoten, String gioitinh, String sdt, String diachi, String email, float luong,
			TaiKhoan taikhoan, List<DonDatHang> dondathang, List<DonHang> listDH, List<DonHang> listDHGH) {
		super();
		this.manv = manv;
		this.hoten = hoten;
		this.gioitinh = gioitinh;
		this.sdt = sdt;
		this.diachi = diachi;
		this.email = email;
		this.luong = luong;
		this.taikhoan = taikhoan;
		this.dondathang = dondathang;
		this.listDH = listDH;
		this.listDHGH = listDHGH;
	}

	public String getManv() {
		return manv;
	}

	public void setManv(String manv) {
		this.manv = manv;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public String getGioitinh() {
		return gioitinh;
	}

	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public float getLuong() {
		return luong;
	}

	public void setLuong(float luong) {
		this.luong = luong;
	}

	public TaiKhoan getTaikhoan() {
		return taikhoan;
	}

	public void setTaikhoan(TaiKhoan taikhoan) {
		this.taikhoan = taikhoan;
	}

	public List<DonDatHang> getDondathang() {
		return dondathang;
	}

	public void setDondathang(List<DonDatHang> dondathang) {
		this.dondathang = dondathang;
	}

	public List<DonHang> getListDH() {
		return listDH;
	}

	public void setListDH(List<DonHang> listDH) {
		this.listDH = listDH;
	}

	public List<DonHang> getListDHGH() {
		return listDHGH;
	}

	public void setListDHGH(List<DonHang> listDHGH) {
		this.listDHGH = listDHGH;
	}



	
}
