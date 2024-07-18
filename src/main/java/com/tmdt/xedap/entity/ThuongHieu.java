package com.tmdt.xedap.entity;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "thuong_hieu")
public class ThuongHieu {
	
	@Id
	String math;
	String tenth;
	String slug;
	
	@JsonIgnore
	@OneToMany(mappedBy = "thuonghieu")
	private Collection<SanPham> sanpham;


	public ThuongHieu() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ThuongHieu(String math, String tenth, String slug, Collection<SanPham> sanpham) {
		super();
		this.math = math;
		this.tenth = tenth;
		this.slug = slug;
		this.sanpham = sanpham;
	}


	public String getMath() {
		return math;
	}


	public void setMath(String math) {
		this.math = math;
	}


	public String getTenth() {
		return tenth;
	}


	public void setTenth(String tenth) {
		this.tenth = tenth;
	}


	public String getSlug() {
		return slug;
	}


	public void setSlug(String slug) {
		this.slug = slug;
	}


	public Collection<SanPham> getSanpham() {
		return sanpham;
	}


	public void setSanpham(Collection<SanPham> sanpham) {
		this.sanpham = sanpham;
	}


}
