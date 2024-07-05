package com.tmdt.xedap.entity;

import java.util.Collection;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "nha_cung_cap")
public class NhaCungCap {

	@Id
	String mancc;
	String tenncc;
	String sdt;
	String email;
	String diachi;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "nhacungcap")
	private Collection<SanPham> sanpham;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "nhacungcap")
	private Set<DonDatHang> dondathang;


	public NhaCungCap() {
		super();
		// TODO Auto-generated constructor stub
	}


	public NhaCungCap(String mancc, String tenncc, String sdt, String email, String diachi, Collection<SanPham> sanpham,
			Set<DonDatHang> dondathang) {
		super();
		this.mancc = mancc;
		this.tenncc = tenncc;
		this.sdt = sdt;
		this.email = email;
		this.diachi = diachi;
		this.sanpham = sanpham;
		this.dondathang = dondathang;
	}


	public String getMancc() {
		return mancc;
	}


	public void setMancc(String mancc) {
		this.mancc = mancc;
	}


	public String getTenncc() {
		return tenncc;
	}


	public void setTenncc(String tenncc) {
		this.tenncc = tenncc;
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


	public Collection<SanPham> getSanpham() {
		return sanpham;
	}


	public void setSanpham(Collection<SanPham> sanpham) {
		this.sanpham = sanpham;
	}


	public Set<DonDatHang> getDondathang() {
		return dondathang;
	}


	public void setDondathang(Set<DonDatHang> dondathang) {
		this.dondathang = dondathang;
	}


	

	
}
