package com.tmdt.xedap.model;

import java.util.List;

public class DonDatHangModel {

	
	private String maddh;
	private String mancc;
	private String manv;
	private List<CT_DonDatHangModel> ds;
	
	
	public DonDatHangModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
	



	public DonDatHangModel(String maddh, String mancc, String manv, List<CT_DonDatHangModel> ds) {
		super();
		this.maddh = maddh;
		this.mancc = mancc;
		this.manv = manv;
		this.ds = ds;
	}







	public String getMaddh() {
		return maddh;
	}




	public void setMaddh(String maddh) {
		this.maddh = maddh;
	}




	public String getMancc() {
		return mancc;
	}




	public void setMancc(String mancc) {
		this.mancc = mancc;
	}




	public String getManv() {
		return manv;
	}




	public void setManv(String manv) {
		this.manv = manv;
	}




	public List<CT_DonDatHangModel> getDs() {
		return ds;
	}




	public void setDs(List<CT_DonDatHangModel> ds) {
		this.ds = ds;
	}

}
