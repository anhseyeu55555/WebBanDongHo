package com.website.dongho.service;

import com.website.dongho.dto.HoaDonDto;
import com.website.dongho.entity.HoaDon;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface HoaDonService {

	List<HoaDon> getListService();
	
	ResponseEntity<String> addHoaDon(HoaDonDto hdModel);
}
