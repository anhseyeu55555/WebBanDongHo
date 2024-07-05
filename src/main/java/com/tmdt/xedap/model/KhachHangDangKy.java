package com.tmdt.xedap.model;

public class KhachHangDangKy {
	String username;
	String password;
	String hoten;
	String gioitinh;
	String sdt;
	String email;
	String diachi;
	
	
	public KhachHangDangKy() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public KhachHangDangKy(String username, String password, String hoten, String gioitinh, String sdt, String email,
			String diachi) {
		super();
		this.username = username;
		this.password = password;
		this.hoten = hoten;
		this.gioitinh = gioitinh;
		this.sdt = sdt;
		this.email = email;
		this.diachi = diachi;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	
	
}
