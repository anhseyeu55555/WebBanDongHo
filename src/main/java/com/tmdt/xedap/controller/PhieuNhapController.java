package com.tmdt.xedap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tmdt.xedap.entity.PhieuNhap;
import com.tmdt.xedap.dto.PhieuNhapModel;
import com.tmdt.xedap.service.PhieuNhapService;

@RestController
@CrossOrigin
public class PhieuNhapController {

	
	@Autowired
	private PhieuNhapService pnService;
	
	
	@GetMapping("/phieunhap")
	public List<PhieuNhap> getAllPhieuNhap(){

		return pnService.getListService();
	}
	
	
	@PostMapping("/phieunhap")
	public ResponseEntity<String> addPhieuNhap(@Validated @RequestBody PhieuNhapModel pnModel){
		
		return pnService.addPhieuNhap(pnModel);
	}
}
