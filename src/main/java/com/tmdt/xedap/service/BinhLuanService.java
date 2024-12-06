package com.tmdt.xedap.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.tmdt.xedap.entity.BinhLuan;
import com.tmdt.xedap.dto.BinhLuanModel;
public interface BinhLuanService {

	
	List<BinhLuan> getListService();
	
	List<BinhLuan> getListBinhLuanByMaSP(String masp);
	
	ResponseEntity<String> deleteBinhLuan(String maBL);
	
	ResponseEntity<String> addBinhLuan(BinhLuanModel binhluanModel);
	
	ResponseEntity<BinhLuan> updateBinhLuan(String mabl, BinhLuanModel binhluanModel);
	

}
