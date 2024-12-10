package com.website.dongho.controller;

import com.website.dongho.dto.Login;
import com.website.dongho.dto.LoginRes;
import com.website.dongho.service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class TaiKhoanController {

    @Autowired
    private TaiKhoanService tkService;

    @PostMapping("/login")
    public ResponseEntity<LoginRes> login(@Validated @RequestBody Login dataLogin) {
        return tkService.login(dataLogin);
    }

    @PutMapping("/change-password")
    public ResponseEntity<String> changPassword(@Validated @RequestBody Login dataChangePassword) {
        return tkService.changePassword(dataChangePassword);
    }

    @GetMapping("/taikhoan/{username}")
    public ResponseEntity<LoginRes> getDetailTaiKhoan(@PathVariable("username") String username) {
        return tkService.getDetailTaiKhoan(username);
    }

}
