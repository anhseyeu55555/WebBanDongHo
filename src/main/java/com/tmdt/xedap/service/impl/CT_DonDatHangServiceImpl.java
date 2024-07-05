package com.tmdt.xedap.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmdt.xedap.entity.CT_DonDatHang;
import com.tmdt.xedap.repository.CT_DonDatHangRepository;
import com.tmdt.xedap.service.CT_DonDatHangService;

@Service
public class CT_DonDatHangServiceImpl implements CT_DonDatHangService{

	
	@Autowired
	private CT_DonDatHangRepository ct_ddh;

	@Override
	public List<CT_DonDatHang> getDetailCTDdh(String maddh) {
		return ct_ddh.findBymaddh(maddh);
	}
}

