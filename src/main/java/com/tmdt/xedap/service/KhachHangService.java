package com.tmdt.xedap.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.tmdt.xedap.entity.KhachHang;
import com.tmdt.xedap.dto.KhachHangDangKy;


public interface KhachHangService {
	
	List<KhachHang> getListService();
	
	ResponseEntity<KhachHang> getDetailKH(String makh);
	
	ResponseEntity<KhachHang> getDetailKHByUsername(String username);

	
	ResponseEntity<String> registerUser(KhachHangDangKy khdk);
	
	ResponseEntity<String> deleteKH(String makh);
	
	ResponseEntity<KhachHang> updateUser(String makh, KhachHang kh);

}
