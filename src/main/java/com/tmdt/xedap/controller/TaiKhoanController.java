package com.tmdt.xedap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tmdt.xedap.model.Login;
import com.tmdt.xedap.model.LoginRes;
import com.tmdt.xedap.service.TaiKhoanService;

@RestController
@CrossOrigin
public class TaiKhoanController {

	@Autowired 
	private TaiKhoanService tkService;
	
	@PostMapping("/login")
	public ResponseEntity<LoginRes> login(@Validated @RequestBody Login dataLogin){
		return tkService.login(dataLogin);
	}

}