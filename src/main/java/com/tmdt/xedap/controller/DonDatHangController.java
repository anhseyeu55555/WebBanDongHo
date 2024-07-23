package com.tmdt.xedap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tmdt.xedap.entity.CT_DonDatHang;
import com.tmdt.xedap.entity.DonDatHang;
import com.tmdt.xedap.model.DonDatHangModel;
import com.tmdt.xedap.service.CT_DonDatHangService;
import com.tmdt.xedap.service.DonDatHangService;


@RestController
@CrossOrigin
public class DonDatHangController {

	@Autowired
	private DonDatHangService ddhService;
	
	@Autowired 
	private CT_DonDatHangService ct_ddhService;
	
	
	@GetMapping("/dondathang")
	public List<DonDatHang> getAllDanhMuc(){

		return ddhService.getListService();
	}
	
	@GetMapping("/dondathang/chitiet/{maddh}")
	public List<CT_DonDatHang> getCT_Ddh(@PathVariable("maddh") String maddh){

		return ct_ddhService.getDetailCTDdh(maddh);
	}
	
	
	@PostMapping("/dondathang")
	public ResponseEntity<String> addDonDatHang(@Validated @RequestBody DonDatHangModel ddhModel){
		
		return ddhService.addDonDathang(ddhModel);
	}
	

	
}
