package com.website.dongho.service.impl;

import com.website.dongho.entity.CT_DonNhapHang;
import com.website.dongho.repository.CT_DonDatHangRepository;
import com.website.dongho.service.CT_DonNhapHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CT_DonNhapHangServiceImpl implements CT_DonNhapHangService {

	
	@Autowired
	private CT_DonDatHangRepository ct_ddh;

	@Override
	public List<CT_DonNhapHang> getDetailCTDdh(String maddh) {
		return ct_ddh.findBymaddh(maddh);
	}
}

