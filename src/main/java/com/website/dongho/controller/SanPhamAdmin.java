package com.website.dongho.controller;

import com.website.dongho.entity.SanPham;
import com.website.dongho.service.SanPhamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/admin/sanpham")
@RequiredArgsConstructor
public class SanPhamAdmin {
    private final SanPhamService spService;

    @GetMapping("/{masp}")
    public ResponseEntity<SanPham> getDetailSPByMaSP(@PathVariable("masp") String masp) {
        return spService.getDetailSPByMaSp(masp);
    }
}
