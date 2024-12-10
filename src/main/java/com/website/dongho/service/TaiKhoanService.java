package com.website.dongho.service;

import com.website.dongho.dto.Login;
import com.website.dongho.dto.LoginRes;
import org.springframework.http.ResponseEntity;

public interface TaiKhoanService {

    ResponseEntity<LoginRes> login(Login dataLogin);

    ResponseEntity<String> changePassword(Login dataLogin);

    ResponseEntity<LoginRes> getDetailTaiKhoan(String username);
}
