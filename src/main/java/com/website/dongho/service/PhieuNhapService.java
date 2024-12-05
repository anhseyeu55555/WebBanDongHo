package com.website.dongho.service;

import com.website.dongho.dto.PhieuNhapDto;
import com.website.dongho.entity.PhieuNhap;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PhieuNhapService {
	
	List<PhieuNhap> getListService();
	
	ResponseEntity<String> addPhieuNhap(PhieuNhapDto pnModel);
}
