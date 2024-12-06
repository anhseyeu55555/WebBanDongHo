package com.tmdt.xedap.service;

import org.springframework.http.ResponseEntity;

import com.tmdt.xedap.dto.Login;
import com.tmdt.xedap.dto.LoginRes;

public interface TaiKhoanService {

	ResponseEntity<LoginRes> login(Login dataLogin);
	
	ResponseEntity<String> changePassword(Login dataLogin);
	
	ResponseEntity<LoginRes> getDetailTaiKhoan(String username);
}
