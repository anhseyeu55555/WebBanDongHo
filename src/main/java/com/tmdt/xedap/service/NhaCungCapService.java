package com.tmdt.xedap.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.tmdt.xedap.entity.NhaCungCap;

public interface NhaCungCapService {

	
	List<NhaCungCap> getListService();
	
	ResponseEntity<NhaCungCap> getDetailNCC(String mancc);
	
	ResponseEntity<String> addNCC(NhaCungCap nhacungcap);
	
	ResponseEntity<String> deleteNCC(String mancc);
	
	ResponseEntity<NhaCungCap> updateNCC(String mancc, NhaCungCap nhacungcap);
}
