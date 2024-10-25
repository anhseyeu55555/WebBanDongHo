package com.tmdt.xedap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tmdt.xedap.dto.ForgotPasswordModel;
import com.tmdt.xedap.dto.MailModel;
import com.tmdt.xedap.service.MailService;

@RestController
@CrossOrigin
@RequestMapping("/mail")
public class MailController {
	
	@Autowired
	private MailService mailService;
	
	
	@PostMapping("/send/{mail}")
	public String sendMail(@PathVariable("mail") String mail, @RequestBody MailModel mailmodel)
	{
		mailService.sendMail(mail, mailmodel);
		return "Gửi mail thành công!";
	}

	
	@PostMapping("/forgot-password")
	public ResponseEntity<String> sendMail(@RequestBody ForgotPasswordModel forgotPasswordModel)
	{
		return mailService.forgotPassword(forgotPasswordModel);
	}
}
