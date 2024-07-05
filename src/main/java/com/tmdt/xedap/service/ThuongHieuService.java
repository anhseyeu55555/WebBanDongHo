package com.tmdt.xedap.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.tmdt.xedap.entity.ThuongHieu;


public interface ThuongHieuService {

	List<ThuongHieu> getListService();
	
	ResponseEntity<ThuongHieu> getDetailThuongHieu(String math);
	
	ResponseEntity<String> addThuongHieu(ThuongHieu thuonghieu);
	
	ResponseEntity<String> deleteThuongHieu(String math);
	
	ResponseEntity<ThuongHieu> updateThuongHieu(String math, ThuongHieu thuonghieu);
}
