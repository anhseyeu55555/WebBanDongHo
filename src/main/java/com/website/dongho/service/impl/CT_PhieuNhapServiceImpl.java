package com.website.dongho.service.impl;

import com.website.dongho.entity.CT_PhieuNhap;
import com.website.dongho.repository.CT_PhieuNhapRepository;
import com.website.dongho.service.CT_PhieuNhapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CT_PhieuNhapServiceImpl implements CT_PhieuNhapService {

	@Autowired
	private CT_PhieuNhapRepository ctpnRepository;
	
	
	@Override
	public List<CT_PhieuNhap> getDetailByMaPn(String mapn) {
		return ctpnRepository.findByMapn(mapn);
	}

}
