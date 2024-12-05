package com.website.dongho.service.impl;

import com.website.dongho.entity.CT_DonHang;
import com.website.dongho.repository.CT_DonHangRepository;
import com.website.dongho.service.CT_DonHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CT_DonHangServiceImpl implements CT_DonHangService{

	@Autowired
	private CT_DonHangRepository ctdhRepository;
	
	@Override
	public List<CT_DonHang> getDetailByMadh(String madh) {
		return ctdhRepository.findBymadh(madh);
	}

}
