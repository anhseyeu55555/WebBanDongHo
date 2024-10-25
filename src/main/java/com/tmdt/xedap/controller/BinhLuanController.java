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

import com.tmdt.xedap.entity.BinhLuan;
import com.tmdt.xedap.dto.BinhLuanModel;
import com.tmdt.xedap.service.BinhLuanService;

@CrossOrigin
@RestController
public class BinhLuanController {

	
	@Autowired
	private BinhLuanService blService;
	
	@GetMapping("/binhluan")
	public List<BinhLuan> getAllBinhLuan(){

		return blService.getListService();
	}
	
	@GetMapping("/binhluan/{masp}")
	public List<BinhLuan> getAllBinhLuanByMaSP(@PathVariable("masp") String masp){

		return blService.getListBinhLuanByMaSP(masp);
	}
	
	@PostMapping("/binhluan")
	public ResponseEntity<String> addBinhLuan(@Validated @RequestBody BinhLuanModel blModel){
		
		return blService.addBinhLuan(blModel);
	}
	
	@DeleteMapping("/binhluan/{masp}")
	public ResponseEntity<String> deleteBinhLuan(@PathVariable("masp") String masp) {
		return blService.deleteBinhLuan(masp);
	}
	

	@PutMapping("/binhluan/{mabl}")
	public ResponseEntity<BinhLuan> updateDanhMuc(@PathVariable("mabl") String mabl, @Validated @RequestBody BinhLuanModel binhluanModel) {
		return blService.updateBinhLuan(mabl, binhluanModel);
	}
}

