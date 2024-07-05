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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tmdt.xedap.entity.GioHang;
import com.tmdt.xedap.model.GioHangModel;
import com.tmdt.xedap.service.GioHangService;

@RestController
@CrossOrigin
public class GioHangController {
	
	@Autowired
	private GioHangService ghService;
	
	
	@GetMapping("/giohang/{makh}")
	public List<GioHang> getListGHByMaKH(@PathVariable("makh") String makh)
	{
		return ghService.getListGH(makh);
	}
	
	
	@PostMapping("/giohang")
	public ResponseEntity<String> addCart (@Validated @RequestBody GioHangModel ghModel ){
		return ghService.addGioHang(ghModel.getMakh(), ghModel.getMasp(), ghModel.getSoluong());
	}
	
	@DeleteMapping("/giohang/{makh}")
	public ResponseEntity<String> deleteAllCart(@PathVariable("makh") String makh)
	{
		return ghService.deleteGioHangByKH(makh);
	}
	
	@DeleteMapping("/giohang/{makh}/{masp}")
	public ResponseEntity<String> deleteCartBySp(@PathVariable("makh") String makh,@PathVariable("masp") String masp){
		return ghService.deleteGioHangByKHAndSP(makh, masp);
	}
	
}
