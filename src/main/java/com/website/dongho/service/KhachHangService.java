package com.website.dongho.service;

import com.website.dongho.dto.KhachHangDangKyDto;
import com.website.dongho.entity.KhachHang;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface KhachHangService {
	
	List<KhachHang> getListService();
	
	ResponseEntity<KhachHang> getDetailKH(String makh);
	
	ResponseEntity<KhachHang> getDetailKHByUsername(String username);

	
	ResponseEntity<String> registerUser(KhachHangDangKyDto khdk);
	
	ResponseEntity<String> deleteKH(String makh);
	
	ResponseEntity<KhachHang> updateUser(String makh, KhachHang kh);

}
