package com.tmdt.xedap.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "tai_khoan")
public class TaiKhoan {

	@Id
	private String username;
	
	@JsonIgnore
	private String password;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maquyen")
	private Quyen quyen;

	@JsonIgnore
	@OneToMany(mappedBy = "taikhoan")
	private List<KhachHang> listKH;
	
	@JsonIgnore
	@OneToMany(mappedBy = "taikhoan")
	List<NhanVien> listNV;

	public TaiKhoan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TaiKhoan(String username, String password, Quyen quyen, List<KhachHang> listKH, List<NhanVien> listNV) {
		super();
		this.username = username;
		this.password = password;
		this.quyen = quyen;
		this.listKH = listKH;
		this.listNV = listNV;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Quyen getQuyen() {
		return quyen;
	}

	public void setQuyen(Quyen quyen) {
		this.quyen = quyen;
	}

	public List<KhachHang> getListKH() {
		return listKH;
	}

	public void setListKH(List<KhachHang> listKH) {
		this.listKH = listKH;
	}

	public List<NhanVien> getListNV() {
		return listNV;
	}

	public void setListNV(List<NhanVien> listNV) {
		this.listNV = listNV;
	}
	
	
}
