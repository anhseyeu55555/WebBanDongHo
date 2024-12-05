package com.website.dongho.service;

import com.website.dongho.dto.BinhLuanDto;
import com.website.dongho.entity.BinhLuan;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BinhLuanService {

	
	List<BinhLuan> getListService();
	
	List<BinhLuan> getListBinhLuanByMaSP(String masp);
	
	ResponseEntity<String> deleteBinhLuan(String maBL);
	
	ResponseEntity<String> addBinhLuan(BinhLuanDto binhluanDto);
	
	ResponseEntity<BinhLuan> updateBinhLuan(String mabl, BinhLuanDto binhluanDto);
	

}
