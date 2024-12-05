package com.website.dongho.controller;

import com.website.dongho.dto.DonNhapHangDto;
import com.website.dongho.entity.CT_DonNhapHang;
import com.website.dongho.entity.DonNhapHang;
import com.website.dongho.service.CT_DonNhapHangService;
import com.website.dongho.service.DonNhapHangService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/donnhaphang")
@RequiredArgsConstructor
public class DonNhapHangController {
    private final DonNhapHangService donNhapHangService;
    private final CT_DonNhapHangService ctDonNhapHangService;

    @GetMapping
    public List<DonNhapHang> getAllDanhMuc() {
        return donNhapHangService.getListService();
    }

    @GetMapping("/chitiet/{madnh}")
    public List<CT_DonNhapHang> getCT_Dnh(@PathVariable("madnh") String madnh) {
        return ctDonNhapHangService.getDetailCTDdh(madnh);
    }

    @PostMapping
    public ResponseEntity<String> addDonNhapHang(@Validated @RequestBody DonNhapHangDto ddhModel) {
        return donNhapHangService.addDonDathang(ddhModel);
    }
}
