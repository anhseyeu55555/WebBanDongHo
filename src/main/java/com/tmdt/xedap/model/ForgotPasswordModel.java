package com.tmdt.xedap.model;

public class ForgotPasswordModel {
	
	private String username;
	private String email;
	private String sdt;
	private int quyen;
	
	
	public ForgotPasswordModel() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ForgotPasswordModel(String username, String email, String sdt, int quyen) {
		super();
		this.username = username;
		this.email = email;
		this.sdt = sdt;
		this.quyen = quyen;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getSdt() {
		return sdt;
	}


	public void setSdt(String sdt) {
		this.sdt = sdt;
	}


	public int getQuyen() {
		return quyen;
	}


	public void setQuyen(int quyen) {
		this.quyen = quyen;
	}
	
	
	
	

}
