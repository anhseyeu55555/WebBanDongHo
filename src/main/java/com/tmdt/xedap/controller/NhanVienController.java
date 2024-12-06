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

import com.tmdt.xedap.entity.NhanVien;
import com.tmdt.xedap.dto.NhanVienDangKy;
import com.tmdt.xedap.service.NhanVienService;

@RestController
@CrossOrigin
public class NhanVienController {

	@Autowired
	NhanVienService nvService;
	
	
	@GetMapping("/nhanvien")
	public List<NhanVien> getAllNV(){
		return nvService.getListService();
	}
	
	@GetMapping("/nhanvien/{manv}")
	public ResponseEntity<NhanVien> getDetailNV(@PathVariable("manv") String manv) {
		 ResponseEntity<NhanVien> nvDetail = nvService.getDetailNV(manv);
		return nvDetail;
	}
	
	@GetMapping("/nhanvien/profile/{username}")
	public ResponseEntity<NhanVien> getDetailNVByUsername(@PathVariable("username") String username){
		ResponseEntity<NhanVien> nvDetail = nvService.getDetailNVByUsername(username);
		return nvDetail;
	}
	
	@PostMapping("/nhanvien")
	public ResponseEntity<String> addNV(@Validated @RequestBody NhanVienDangKy nvdk){
		
		return nvService.addNV(nvdk);
	}
	
	
	@DeleteMapping("/nhanvien/{manv}")
	public ResponseEntity<String> deleteNhanVien(@PathVariable("manv") String manv) {
		return nvService.deleteNV(manv);
	}
	
	@PutMapping("/nhanvien/{manv}")
	public ResponseEntity<NhanVien> updateNhanVien(@PathVariable("manv") String manv, @Validated @RequestBody NhanVien nhanvien) {
		return nvService.updateNV(manv,nhanvien);
	}
}
