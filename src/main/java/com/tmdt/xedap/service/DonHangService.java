package com.tmdt.xedap.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.tmdt.xedap.entity.DonHang;
import com.tmdt.xedap.model.DonHangModel;
import com.tmdt.xedap.model.DonThuThang;
import com.tmdt.xedap.model.UpdateDonHangModel;

public interface DonHangService {
	
	List<DonHang> getListService();
	
	List<DonHang> getListDonHangByKH(String makh);
	
	List<DonHang> getListDonHangByNV(String manv);
	
	List<DonHang> getListDonHangByTT(String makh, int trangthai);
	
	ResponseEntity<String> addDonHang(DonHangModel dhModel);
	
	ResponseEntity<String> updateDonHang(UpdateDonHangModel updateDHModel);
	
	double[] getThongKeByYear();
}
