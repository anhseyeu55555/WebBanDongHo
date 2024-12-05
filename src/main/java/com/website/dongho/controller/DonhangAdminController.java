package com.website.dongho.controller;

import com.website.dongho.entity.DonHang;
import com.website.dongho.service.DonHangService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/admin/donhang")
@RequiredArgsConstructor
public class DonhangAdminController {
    private final DonHangService dhService;

    @GetMapping
    public List<DonHang> getAllDonHang() {
        return dhService.getListService();
    }

    @GetMapping("/nhanvien/{manv}")
    public List<DonHang> getDHByNV(@PathVariable("manv") String manv) {
        return dhService.getListDonHangByNV(manv);
    }
}
