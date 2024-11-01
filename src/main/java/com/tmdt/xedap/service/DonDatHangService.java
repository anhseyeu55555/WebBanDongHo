package com.tmdt.xedap.service;

import java.util.List;

import org.springframework.http.ResponseEntity;


import com.tmdt.xedap.entity.DonNhapHang;
import com.tmdt.xedap.dto.DonDatHangModel;

public interface DonDatHangService {

	
	List<DonNhapHang> getListService();
	
	ResponseEntity<String> addDonDathang(DonDatHangModel ddhModel);
}
