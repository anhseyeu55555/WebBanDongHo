package com.tmdt.xedap.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.tmdt.xedap.entity.KhachHang;
import com.tmdt.xedap.model.KhachHangDangKy;


public interface KhachHangService {
	
	List<KhachHang> getListService();
	
	ResponseEntity<KhachHang> getDetailKH(String makh);
	
	ResponseEntity<String> registerUser(KhachHangDangKy khdk);
	
	ResponseEntity<String> deleteKH(String makh);
	
	ResponseEntity<KhachHang> updateUser(String makh, KhachHang kh);

}
