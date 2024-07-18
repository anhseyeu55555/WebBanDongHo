package com.tmdt.xedap.entity;


import java.util.Collection;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "danh_muc")
public class DanhMuc {
	
	
	@Id
	String madm;
	String tendm;
	String slug;
	
	@JsonIgnore
	@OneToMany(mappedBy = "danhmuc")
	private Collection<SanPham> sanpham;

	public DanhMuc() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DanhMuc(String madm, String tendm, String slug, Collection<SanPham> sanpham) {
		super();
		this.madm = madm;
		this.tendm = tendm;
		this.slug = slug;
		this.sanpham = sanpham;
	}

	public String getMadm() {
		return madm;
	}

	public void setMadm(String madm) {
		this.madm = madm;
	}

	public String getTendm() {
		return tendm;
	}

	public void setTendm(String tendm) {
		this.tendm = tendm;
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
