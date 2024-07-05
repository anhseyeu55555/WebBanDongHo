package com.tmdt.xedap.model;

public class LoginRes {
	private String username;
	private int quyen;
	
	
	public LoginRes() {
		super();
		// TODO Auto-generated constructor stub
	}


	public LoginRes(String username, int quyen) {
		super();
		this.username = username;
		this.quyen = quyen;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public int getQuyen() {
		return quyen;
	}


	public void setQuyen(int quyen) {
		this.quyen = quyen;
	}
}
