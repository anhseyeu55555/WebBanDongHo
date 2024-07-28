package com.tmdt.xedap.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.tmdt.xedap.entity.SanPham;
import com.tmdt.xedap.model.SanPhamModel;

public interface SanPhamService {
	
	List<SanPham> getListService();
	
	ResponseEntity<SanPham> getDetailSPByMaSp(String masp);
	ResponseEntity<SanPham> getDetailSPBySlug(String slug);
	
	ResponseEntity<String> addSanPham(SanPhamModel sanpham);
	
	ResponseEntity<String> deleteSanPham(String masp);
	
	ResponseEntity<SanPham> updateSP(String masp, SanPham sanpham);
	
	
	List<SanPham> getListSanPhamByDM(String madm);
	List<SanPham> getListSanPhamByTH(String math);
	List<SanPham> getListSanPhamByNCC(String mancc);
	List<SanPham> getListSanPhamByNew();
	List<SanPham> getListSanPhamBySearch(String search);
	List<SanPham> getListSanPhamBestSeller();
}
