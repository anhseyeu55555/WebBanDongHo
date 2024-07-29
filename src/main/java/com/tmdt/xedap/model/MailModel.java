package com.tmdt.xedap.model;


public class MailModel {
	private String subject;
	private String message;
	
	
	public MailModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public MailModel(String subject, String message) {
		super();
		this.subject = subject;
		this.message = message;
	}
	
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
