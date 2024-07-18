package com.tmdt.xedap.service;

import org.springframework.http.ResponseEntity;

import com.tmdt.xedap.model.Login;
import com.tmdt.xedap.model.LoginRes;

public interface TaiKhoanService {

	ResponseEntity<LoginRes> login(Login dataLogin);
	
	ResponseEntity<String> changePassword(Login dataLogin);
}
