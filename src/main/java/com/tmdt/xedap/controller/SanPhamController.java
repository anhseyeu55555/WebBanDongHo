package com.tmdt.xedap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tmdt.xedap.entity.NhaCungCap;
import com.tmdt.xedap.entity.SanPham;
import com.tmdt.xedap.model.SanPhamModel;
import com.tmdt.xedap.service.SanPhamService;

@RestController
@CrossOrigin
public class SanPhamController {
	
	@Autowired
	private SanPhamService spService;

	@GetMapping("/sanpham")
	public List<SanPham> getAllSanPham(){

		return spService.getListService();
	}
	
	@GetMapping("/admin/sanpham/{masp}")
	public ResponseEntity<SanPham> getDetailSPByMaSP(@PathVariable("masp") String masp) {
		 ResponseEntity<SanPham> spDetail = spService.getDetailSPByMaSp(masp);
		return spDetail;
	}
	
	@GetMapping("/sanpham/{slug}")
	public ResponseEntity<SanPham> getDetailSPBySlug(@PathVariable("slug") String slug) {
		 ResponseEntity<SanPham> spDetail = spService.getDetailSPBySlug(slug);
		return spDetail;
	}
	
	@GetMapping("/sanpham/danhmuc/{madm}")
	public List<SanPham> getDetailSPByDM(@PathVariable("madm") String madm) {
		List<SanPham> listSP = spService.getListSanPhamByDM(madm);
		return listSP;
	}
	
	
	@GetMapping("/sanpham/thuonghieu/{math}")
	public List<SanPham>getDetailSPByTH(@PathVariable("math") String math) {
		List<SanPham> listSP = spService.getListSanPhamByTH(math);
		return listSP;
	}
	
	@GetMapping("/sanpham/nhacungcap/{mancc}")
	public List<SanPham> getDetailSPByNCC(@PathVariable("mancc") String mancc) {
		List<SanPham> listSP = spService.getListSanPhamByNCC(mancc);
		return listSP;
	}
	
	@PostMapping("/sanpham")
	public ResponseEntity<String> addSanPham(@Validated @RequestBody SanPhamModel sanpham){
		
		return spService.addSanPham(sanpham);
	}
	
	@DeleteMapping("/sanpham/{masp}")
	public ResponseEntity<String> deleteNhaCungCap(@PathVariable("masp") String masp) {
		return spService.deleteSanPham(masp);
	}

	
	@PutMapping("/sanpham/{masp}")
	public ResponseEntity<SanPham> updateNhaCungCap(@PathVariable("masp") String masp, @Validated @RequestBody SanPham sanpham) {
		return spService.updateSP(masp,sanpham);
	}
}
