package com.tmdt.xedap.service;

import org.springframework.http.ResponseEntity;

import com.tmdt.xedap.dto.ForgotPasswordModel;
import com.tmdt.xedap.dto.MailModel;

public interface MailService {

	 void sendMail(String mail, MailModel mailmodel);
	 
	 ResponseEntity<String> forgotPassword(ForgotPasswordModel forgotPasswordModel);
}
