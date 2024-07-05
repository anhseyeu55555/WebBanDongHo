package com.tmdt.xedap.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.tmdt.xedap.entity.PhieuNhap;
import com.tmdt.xedap.model.PhieuNhapModel;

public interface PhieuNhapService {
	
	List<PhieuNhap> getListService();
	
	ResponseEntity<String> addPhieuNhap(PhieuNhapModel pnModel);
}
