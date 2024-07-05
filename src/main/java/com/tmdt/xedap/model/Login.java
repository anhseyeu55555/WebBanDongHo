package com.tmdt.xedap.model;

public class Login {

	private String username;
	private String password;
	private int maquyen;
	
	
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Login(String username, String password, int maquyen) {
		super();
		this.username = username;
		this.password = password;
		this.maquyen = maquyen;
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


	public int getMaquyen() {
		return maquyen;
	}


	public void setMaquyen(int maquyen) {
		this.maquyen = maquyen;
	}
	
	
	
	
}
