package com.tmdt.xedap.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.tmdt.xedap.entity.HoaDon;
import com.tmdt.xedap.model.HoaDonModel;

public interface HoaDonService {

	List<HoaDon> getListService();
	
	ResponseEntity<String> addHoaDon(HoaDonModel hdModel);
}
