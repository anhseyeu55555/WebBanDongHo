package com.website.dongho.service;

import com.website.dongho.dto.SanPhamDto;
import com.website.dongho.entity.SanPham;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SanPhamService {
    List<SanPham> getListService();

    ResponseEntity<SanPham> getDetailSPByMaSp(String masp);

    ResponseEntity<SanPham> getDetailSPBySlug(String slug);

    ResponseEntity<String> addSanPham(SanPhamDto sanpham);

    ResponseEntity<String> deleteSanPham(String masp);

    ResponseEntity<SanPham> updateSP(String masp, SanPham sanpham);

    List<SanPham> getListSanPhamByDM(String madm);

    List<SanPham> getListSanPhamByTH(String math);

    List<SanPham> getListSanPhamByNCC(String mancc);

    List<SanPham> getListSanPhamByNew();

    List<SanPham> getListSanPhamBySearch(String search);

    List<SanPham> getListSanPhamBestSeller();
}
