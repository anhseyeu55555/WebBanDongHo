package com.tmdt.xedap.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.tmdt.xedap.entity.NhanVien;
import com.tmdt.xedap.dto.NhanVienDangKy;


public interface NhanVienService {

	List<NhanVien> getListService();
	
	ResponseEntity<NhanVien> getDetailNV(String manv);
	
	ResponseEntity<NhanVien> getDetailNVByUsername(String username);
	
	ResponseEntity<String> addNV(NhanVienDangKy nvdk);
	
	ResponseEntity<String> deleteNV(String manv);
	
	ResponseEntity<NhanVien> updateNV(String manv, NhanVien nv);
}
