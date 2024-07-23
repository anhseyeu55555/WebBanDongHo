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

import com.tmdt.xedap.entity.HoaDon;
import com.tmdt.xedap.model.HoaDonModel;
import com.tmdt.xedap.service.HoaDonService;


@RestController
@CrossOrigin
public class HoaDonController {

	
	@Autowired
	private HoaDonService hdService;
	
	
	@GetMapping("/hoadon")
	public List<HoaDon> getAllHoaDon(){
		return hdService.getListService();
	}
	
	@PostMapping("/hoadon")
	public ResponseEntity<String> addHoaDon(@Validated @RequestBody HoaDonModel hdModel){
		
		return hdService.addHoaDon(hdModel);
	}
	
}
