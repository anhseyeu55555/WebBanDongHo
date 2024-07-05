package com.tmdt.xedap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tmdt.xedap.entity.CT_DonHang;
import com.tmdt.xedap.service.CT_DonHangService;

@RestController
@CrossOrigin
public class CT_DonHangController {

	@Autowired
	private CT_DonHangService ctdhService;
	
	@GetMapping("/donhang/detail/{madh}")
	public List<CT_DonHang> getDetailDH(@PathVariable("madh") String madh) {
		return ctdhService.getDetailByMadh(madh);
	}
}
