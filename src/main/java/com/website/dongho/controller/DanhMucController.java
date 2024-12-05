package com.website.dongho.controller;

import com.website.dongho.entity.DanhMuc;
import com.website.dongho.service.DanhMucService;
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
@RequestMapping("/danhmuc")
@RequiredArgsConstructor
public class DanhMucController {
    private final DanhMucService dmService;

    @GetMapping
    public List<DanhMuc> getAllDanhMuc() {
        return dmService.getListService();
    }

    @GetMapping("/{madm}")
    public ResponseEntity<DanhMuc> getDetailDanhMuc(@PathVariable("madm") String madm) {
        return dmService.getDetailDanhMuc(madm);
    }

    @PostMapping
    public ResponseEntity<String> addDanhMuc(@Validated @RequestBody DanhMuc danhmuc) {
        return dmService.addDanhMuc(danhmuc);
    }

    @DeleteMapping("/{madm}")
    public ResponseEntity<String> deleteDanhMuc(@PathVariable("madm") String madm) {
        return dmService.deleteDanhMuc(madm);
    }

    @PutMapping("/{madm}")
    public ResponseEntity<DanhMuc> updateDanhMuc(@PathVariable("madm") String madm, @Validated @RequestBody DanhMuc danhmuc) {
        return dmService.updateDanhMuc(madm, danhmuc);
    }

}
