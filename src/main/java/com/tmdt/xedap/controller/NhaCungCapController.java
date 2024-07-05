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
import com.tmdt.xedap.entity.NhaCungCap;
import com.tmdt.xedap.service.DanhMucService;
import com.tmdt.xedap.service.NhaCungCapService;

@RestController
@CrossOrigin
public class NhaCungCapController {

	@Autowired
	NhaCungCapService nccService;

	
	@GetMapping("/nhacungcap")
	public List<NhaCungCap> getAllNhaCungCap(){

		return nccService.getListService();
	}
	
	@GetMapping("/nhacungcap/{mancc}")
	public ResponseEntity<NhaCungCap> getDetailNhaCungCap(@PathVariable("mancc") String mancc) {
		 ResponseEntity<NhaCungCap> nccDetail = nccService.getDetailNCC(mancc);
		return nccDetail;
	}
	
	
	@PostMapping("/nhacungcap")
	public ResponseEntity<String> addNhaCungCap(@Validated @RequestBody NhaCungCap nhacungcap){
		
		return nccService.addNCC(nhacungcap);
	}
	
	@DeleteMapping("/nhacungcap/{mancc}")
	public ResponseEntity<String> deleteNhaCungCap(@PathVariable("mancc") String mancc) {
		return nccService.deleteNCC(mancc);
	}

	
	@PutMapping("/nhacungcap/{mancc}")
	public ResponseEntity<NhaCungCap> updateNhaCungCap(@PathVariable("mancc") String mancc, @Validated @RequestBody NhaCungCap nhacungcap) {
		return nccService.updateNCC(mancc,nhacungcap);
	}

}
