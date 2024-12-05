package com.website.dongho.controller;

import com.website.dongho.entity.ThuongHieu;
import com.website.dongho.service.ThuongHieuService;
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
@RequestMapping("thuonghieu")
@RequiredArgsConstructor
public class ThuongHieuController {
    private final ThuongHieuService thService;

    @GetMapping
    public List<ThuongHieu> getAllThuongHieu() {

        return thService.getListService();
    }

    @GetMapping("/{math}")
    public ResponseEntity<ThuongHieu> getDetailThuongHieu(@PathVariable("math") String math) {
        ResponseEntity<ThuongHieu> thDetail = thService.getDetailThuongHieu(math);
        return thDetail;
    }

    @PostMapping
    public ResponseEntity<String> addThuongHieu(@Validated @RequestBody ThuongHieu thuonghieu) {
        return thService.addThuongHieu(thuonghieu);
    }

    @DeleteMapping("/{math}")
    public ResponseEntity<String> deleteThuongHieu(@PathVariable("math") String math) {
        return thService.deleteThuongHieu(math);
    }

    @PutMapping("/{math}")
    public ResponseEntity<ThuongHieu> updateDanhMuc(@PathVariable("math") String math, @Validated @RequestBody ThuongHieu thuonghieu) {
        return thService.updateThuongHieu(math, thuonghieu);
    }
}
