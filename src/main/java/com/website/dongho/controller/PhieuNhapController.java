package com.website.dongho.controller;

import com.website.dongho.dto.PhieuNhapDto;
import com.website.dongho.entity.PhieuNhap;
import com.website.dongho.service.PhieuNhapService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/phieunhap")
@RequiredArgsConstructor
public class PhieuNhapController {
    private final PhieuNhapService pnService;

    @GetMapping
    public List<PhieuNhap> getAllPhieuNhap() {
        return pnService.getListService();
    }

    @PostMapping
    public ResponseEntity<String> addPhieuNhap(@Validated @RequestBody PhieuNhapDto pnModel) {

        return pnService.addPhieuNhap(pnModel);
    }
}
