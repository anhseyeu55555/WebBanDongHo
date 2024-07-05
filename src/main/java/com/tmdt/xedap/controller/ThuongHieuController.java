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

import com.tmdt.xedap.entity.ThuongHieu;
import com.tmdt.xedap.service.ThuongHieuService;



@RestController
@CrossOrigin
public class ThuongHieuController {

	
	@Autowired
	ThuongHieuService thService;

	
	@GetMapping("/thuonghieu")
	public List<ThuongHieu> getAllThuongHieu(){

		return thService.getListService();
	}
	
	@GetMapping("/thuonghieu/{math}")
	public ResponseEntity<ThuongHieu> getDetailThuongHieu(@PathVariable("math") String math) {
		 ResponseEntity<ThuongHieu> thDetail = thService.getDetailThuongHieu(math);
		return thDetail;
	}
	
	
	@PostMapping("/thuonghieu")
	public ResponseEntity<String> addThuongHieu(@Validated @RequestBody ThuongHieu thuonghieu){
		return thService.addThuongHieu(thuonghieu);
	}
	
	@DeleteMapping("/thuonghieu/{math}")
	public ResponseEntity<String> deleteThuongHieu(@PathVariable("math") String math) {
		return thService.deleteThuongHieu(math);
	}

	
	@PutMapping("/thuonghieu/{math}")
	public ResponseEntity<ThuongHieu> updateDanhMuc(@PathVariable("math") String math, @Validated @RequestBody ThuongHieu thuonghieu) {
		return thService.updateThuongHieu(math,thuonghieu);
	}

}
