package com.website.dongho.controller;

import com.website.dongho.dto.BinhLuanDto;
import com.website.dongho.entity.BinhLuan;
import com.website.dongho.service.BinhLuanService;
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

@CrossOrigin
@RestController
@RequestMapping("binhluan")
@RequiredArgsConstructor
public class BinhLuanController {
    private final BinhLuanService blService;

    @GetMapping
    public List<BinhLuan> getAllBinhLuan() {

        return blService.getListService();
    }

    @GetMapping("/{masp}")
    public List<BinhLuan> getAllBinhLuanByMaSP(@PathVariable("masp") String masp) {

        return blService.getListBinhLuanByMaSP(masp);
    }

    @PostMapping
    public ResponseEntity<String> addBinhLuan(@Validated @RequestBody BinhLuanDto binhLuanDto) {

        return blService.addBinhLuan(binhLuanDto);
    }

    @DeleteMapping("/{masp}")
    public ResponseEntity<String> deleteBinhLuan(@PathVariable("masp") String masp) {
        return blService.deleteBinhLuan(masp);
    }
    @PutMapping("/{mabl}")
    public ResponseEntity<BinhLuan> updateDanhMuc(@PathVariable("mabl") String mabl, @Validated @RequestBody BinhLuanDto binhluanDto) {
        return blService.updateBinhLuan(mabl, binhluanDto);
    }
}

