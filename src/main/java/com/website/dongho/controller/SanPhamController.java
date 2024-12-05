package com.website.dongho.controller;

import com.website.dongho.dto.SanPhamDto;
import com.website.dongho.entity.SanPham;
import com.website.dongho.service.SanPhamService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/sanpham")
@RequiredArgsConstructor
public class SanPhamController {
    private final SanPhamService spService;

    @GetMapping
    public List<SanPham> getAllSanPham() {

        return spService.getListService();
    }

    @GetMapping("/{slug}")
    public ResponseEntity<SanPham> getDetailSPBySlug(@PathVariable("slug") String slug) {
        return spService.getDetailSPBySlug(slug);
    }

    @GetMapping("/danhmuc/{madm}")
    public List<SanPham> getDetailSPByDM(@PathVariable("madm") String madm) {
        return spService.getListSanPhamByDM(madm);
    }

    @GetMapping("/thuonghieu/{math}")
    public List<SanPham> getDetailSPByTH(@PathVariable("math") String math) {
        return spService.getListSanPhamByTH(math);
    }

    @GetMapping("/nhacungcap/{mancc}")
    public List<SanPham> getDetailSPByNCC(@PathVariable("mancc") String mancc) {
        return spService.getListSanPhamByNCC(mancc);
    }

    @GetMapping("/search")
    public List<SanPham> getDetailSPBySearch(@RequestParam("query") String query) {
        return spService.getListSanPhamBySearch(query);
    }

    @GetMapping("/best-seller")
    public List<SanPham> getListSPBestSeller() {
        return spService.getListSanPhamBestSeller();
    }

    @PostMapping
    public ResponseEntity<String> addSanPham(@Validated @RequestBody SanPhamDto sanpham) {
        return spService.addSanPham(sanpham);
    }

    @DeleteMapping("/{masp}")
    public ResponseEntity<String> deleteNhaCungCap(@PathVariable("masp") String masp) {
        return spService.deleteSanPham(masp);
    }

    @PutMapping("/{masp}")
    public ResponseEntity<SanPham> updateNhaCungCap(@PathVariable("masp") String masp, @Validated @RequestBody SanPham sanpham) {
        return spService.updateSP(masp, sanpham);
    }
}
