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

import com.tmdt.xedap.entity.KhachHang;
import com.tmdt.xedap.dto.KhachHangDangKy;
import com.tmdt.xedap.service.KhachHangService;

@RestController
@CrossOrigin
public class KhachHangController {
	
	
	@Autowired
	KhachHangService khService;
	
	
	@GetMapping("/user")
	public List<KhachHang> getAllKH(){
		return khService.getListService();
	}
	
	@GetMapping("/user/{makh}")
	public ResponseEntity<KhachHang> getDetailKH(@PathVariable("makh") String makh) {
		 ResponseEntity<KhachHang> khDetail = khService.getDetailKH(makh);
		return khDetail;
	}
	
	@GetMapping("/user/username/{username}")
	public ResponseEntity<KhachHang> getDetailKhByUsername(@PathVariable("username") String username) {
		 ResponseEntity<KhachHang> khDetail = khService.getDetailKHByUsername(username);
		return khDetail;
	}
	
	@PostMapping("/user")
	public ResponseEntity<String> registerUser(@Validated @RequestBody KhachHangDangKy khdk){	
		return khService.registerUser(khdk);
	}
	
	
	@DeleteMapping("/user/{makh}")
	public ResponseEntity<String> deleteUser(@PathVariable("makh") String makh) {
		return khService.deleteKH(makh);
	}
	
	
	@PutMapping("/user/{makh}")
	public ResponseEntity<KhachHang> updateUser(@PathVariable("makh") String makh, @Validated @RequestBody KhachHang khachhang) {
		return khService.updateUser(makh,khachhang);
	}
}
