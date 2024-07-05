package com.tmdt.xedap.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "quyen")
public class Quyen {

	@Id
	private int maquyen;
	private String tenquyen;
	
	@JsonIgnore
	@OneToMany(mappedBy = "quyen")
	private List<TaiKhoan> ListTk;
	
	
	public Quyen() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Quyen(int maquyen) {
		super();
		this.maquyen = maquyen;
	}


	public int getMaquyen() {
		return maquyen;
	}


	public void setMaquyen(int maquyen) {
		this.maquyen = maquyen;
	}


	public String getTenquyen() {
		return tenquyen;
	}


	public void setTenquyen(String tenquyen) {
		this.tenquyen = tenquyen;
	}


	public List<TaiKhoan> getListTk() {
		return ListTk;
	}


	public void setListTk(List<TaiKhoan> listTk) {
		ListTk = listTk;
	}
}
