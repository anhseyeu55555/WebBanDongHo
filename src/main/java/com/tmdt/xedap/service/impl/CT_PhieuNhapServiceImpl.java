package com.tmdt.xedap.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmdt.xedap.entity.CT_PhieuNhap;
import com.tmdt.xedap.repository.CT_PhieuNhapRepository;
import com.tmdt.xedap.service.CT_PhieuNhapService;

@Service
public class CT_PhieuNhapServiceImpl implements CT_PhieuNhapService {

	@Autowired
	private CT_PhieuNhapRepository ctpnRepository;
	
	
	@Override
	public List<CT_PhieuNhap> getDetailByMaPn(String mapn) {
		// TODO Auto-generated method stub
		return ctpnRepository.findByMapn(mapn);
	}

}
