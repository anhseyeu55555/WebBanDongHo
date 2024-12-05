package com.website.dongho.controller;

import com.website.dongho.dto.KhachHangDangKyDto;
import com.website.dongho.entity.KhachHang;
import com.website.dongho.service.KhachHangService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/user")
public class KhachHangController {
    private final KhachHangService khService;

    @GetMapping
    public List<KhachHang> getAllKH() {
        return khService.getListService();
    }

    @GetMapping("/{makh}")
    public ResponseEntity<KhachHang> getDetailKH(@PathVariable("makh") String makh) {
        ResponseEntity<KhachHang> khDetail = khService.getDetailKH(makh);
        return khDetail;
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<KhachHang> getDetailKhByUsername(@PathVariable("username") String username) {
        ResponseEntity<KhachHang> khDetail = khService.getDetailKHByUsername(username);
        return khDetail;
    }

    @PostMapping
    public ResponseEntity<String> registerUser(@Validated @RequestBody KhachHangDangKyDto khdk) {
        return khService.registerUser(khdk);
    }

    @DeleteMapping("/{makh}")
    public ResponseEntity<String> deleteUser(@PathVariable("makh") String makh) {
        return khService.deleteKH(makh);
    }

    @PutMapping("/{makh}")
    public ResponseEntity<KhachHang> updateUser(@PathVariable("makh") String makh, @Validated @RequestBody KhachHang khachhang) {
        return khService.updateUser(makh, khachhang);
    }
}
