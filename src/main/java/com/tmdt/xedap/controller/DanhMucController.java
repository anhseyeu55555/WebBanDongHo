package com.tmdt.xedap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tmdt.xedap.entity.DanhMuc;
import com.tmdt.xedap.service.DanhMucService;

@RestController
@CrossOrigin
public class DanhMucController {

	
	@Autowired
	DanhMucService dmService;

	
	@GetMapping("/danhmuc")
	public List<DanhMuc> getAllDanhMuc(){

		return dmService.getListService();
	}
	
	@GetMapping("/danhmuc/{madm}")
	public ResponseEntity<DanhMuc> getDetailDanhMuc(@PathVariable("madm") String madm) {
		 ResponseEntity<DanhMuc> dmDetail = dmService.getDetailDanhMuc(madm);
		return dmDetail;
	}
	
	
	@PostMapping("/danhmuc")
	public ResponseEntity<String> addDanhMuc(@Validated @RequestBody DanhMuc danhmuc){
		
		return dmService.addDanhMuc(danhmuc);
	}
	
	@DeleteMapping("/danhmuc/{madm}")
	public ResponseEntity<String> deleteDanhMuc(@PathVariable("madm") String madm) {
		return dmService.deleteDanhMuc(madm);
	}

	
	@PutMapping("/danhmuc/{madm}")
	public ResponseEntity<DanhMuc> updateDanhMuc(@PathVariable("madm") String madm, @Validated @RequestBody DanhMuc danhmuc) {
		return dmService.updateDanhMuc(madm,danhmuc);
	}

}
