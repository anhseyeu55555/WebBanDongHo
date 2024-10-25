package com.tmdt.xedap.service;

import java.util.List;

import org.springframework.http.ResponseEntity;


import com.tmdt.xedap.entity.DonDatHang;
import com.tmdt.xedap.dto.DonDatHangModel;

public interface DonDatHangService {

	
	List<DonDatHang> getListService();
	
	ResponseEntity<String> addDonDathang(DonDatHangModel ddhModel);
}
