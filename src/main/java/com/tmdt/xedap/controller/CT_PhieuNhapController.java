package com.tmdt.xedap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tmdt.xedap.entity.CT_PhieuNhap;
import com.tmdt.xedap.service.CT_PhieuNhapService;


@CrossOrigin
@RestController
public class CT_PhieuNhapController {
	
	@Autowired
	private CT_PhieuNhapService ctpnService;
	
	@GetMapping("/phieunhap/detail/{mapn}")
	public List<CT_PhieuNhap> getDetailDH(@PathVariable("mapn") String mapn) {
		return ctpnService.getDetailByMaPn(mapn);
	}

}
