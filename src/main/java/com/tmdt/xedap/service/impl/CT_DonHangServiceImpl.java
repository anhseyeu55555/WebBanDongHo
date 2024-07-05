package com.tmdt.xedap.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmdt.xedap.entity.CT_DonHang;
import com.tmdt.xedap.repository.CT_DonHangRepository;
import com.tmdt.xedap.service.CT_DonHangService;

@Service
public class CT_DonHangServiceImpl implements CT_DonHangService{

	@Autowired
	private CT_DonHangRepository ctdhRepository;
	
	@Override
	public List<CT_DonHang> getDetailByMadh(String madh) {
		// TODO Auto-generated method stub
		return ctdhRepository.findBymadh(madh);
	}

}
