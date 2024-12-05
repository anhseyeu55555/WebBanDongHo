package com.website.dongho.service;

import com.website.dongho.entity.NhaCungCap;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface NhaCungCapService {

	
	List<NhaCungCap> getListService();
	
	ResponseEntity<NhaCungCap> getDetailNCC(String mancc);
	
	ResponseEntity<String> addNCC(NhaCungCap nhacungcap);
	
	ResponseEntity<String> deleteNCC(String mancc);
	
	ResponseEntity<NhaCungCap> updateNCC(String mancc, NhaCungCap nhacungcap);
}
