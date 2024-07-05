package com.tmdt.xedap.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.tmdt.xedap.entity.DanhMuc;

public interface DanhMucService {

	List<DanhMuc> getListService();
	
	ResponseEntity<DanhMuc> getDetailDanhMuc(String maDM);
	
	ResponseEntity<String> addDanhMuc(DanhMuc danhmuc);
	
	ResponseEntity<String> deleteDanhMuc(String maDM);
	
	ResponseEntity<DanhMuc> updateDanhMuc(String madm, DanhMuc danhmuc);
}
