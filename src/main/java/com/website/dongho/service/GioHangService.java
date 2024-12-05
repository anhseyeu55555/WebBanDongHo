package com.website.dongho.service;

import com.website.dongho.entity.GioHang;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface GioHangService {

	
	//get lisst
	List<GioHang> getListGH(String makh);
	
	//add sản phẩm vào giỏ hàng
	ResponseEntity<String> addGioHang(String makh, String masp, int soluong);
	
	//xoá tất cả item trong giỏ hàng
	ResponseEntity<String> deleteGioHangByKH(String makh);
	
	//xoá 1 sản phẩm trong giỏ hàng
	ResponseEntity<String> deleteGioHangByKHAndSP(String makh, String masp);
	
}
