package com.tmdt.xedap.model;

import java.util.List;

public class PhieuNhapModel {
	
	private String mapn;
	private String manv;
	private String maddh;
	private List<CT_DonDatHangModel> ds;
	
	
	public PhieuNhapModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public PhieuNhapModel(String mapn, String manv, String maddh, List<CT_DonDatHangModel> ds) {
		super();
		this.mapn = mapn;
		this.manv = manv;
		this.maddh = maddh;
		this.ds = ds;
	}


	public String getMapn() {
		return mapn;
	}


	public void setMapn(String mapn) {
		this.mapn = mapn;
	}


	public String getManv() {
		return manv;
	}


	public void setManv(String manv) {
		this.manv = manv;
	}


	public String getMaddh() {
		return maddh;
	}


	public void setMaddh(String maddh) {
		this.maddh = maddh;
	}


	public List<CT_DonDatHangModel> getDs() {
		return ds;
	}


	public void setDs(List<CT_DonDatHangModel> ds) {
		this.ds = ds;
	}
	
}
