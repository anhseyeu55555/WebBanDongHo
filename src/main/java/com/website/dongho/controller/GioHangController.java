package com.website.dongho.controller;

import com.website.dongho.dto.GioHangDto;
import com.website.dongho.entity.GioHang;
import com.website.dongho.service.GioHangService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/giohang")
@RequiredArgsConstructor
public class GioHangController {
    private final GioHangService ghService;

    @GetMapping("/{makh}")
    public List<GioHang> getListGHByMaKH(@PathVariable("makh") String makh) {
        return ghService.getListGH(makh);
    }

    @PostMapping
    public ResponseEntity<String> addCart(@Validated @RequestBody GioHangDto ghModel) {
        return ghService.addGioHang(ghModel.getMakh(), ghModel.getMasp(), ghModel.getSoluong());
    }

    @DeleteMapping("/{makh}")
    public ResponseEntity<String> deleteAllCart(@PathVariable("makh") String makh) {
        return ghService.deleteGioHangByKH(makh);
    }

    @DeleteMapping("/{makh}/{masp}")
    public ResponseEntity<String> deleteCartBySp(@PathVariable("makh") String makh, @PathVariable("masp") String masp) {
        return ghService.deleteGioHangByKHAndSP(makh, masp);
    }

}
