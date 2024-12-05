package com.website.dongho.service;

import com.website.dongho.dto.DonHangModel;
import com.website.dongho.dto.UpdateDonHangDto;
import com.website.dongho.entity.DonHang;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DonHangService {
	
	List<DonHang> getListService();
	
	List<DonHang> getListDonHangByKH(String makh);
	
	List<DonHang> getListDonHangByNV(String manv);
	
	List<DonHang> getListDonHangByTT(String makh, int trangthai);
	
	ResponseEntity<String> addDonHang(DonHangModel dhModel);
	
	ResponseEntity<String> updateDonHang(UpdateDonHangDto updateDHModel);
	
	double[] getThongKeByYear();
}
