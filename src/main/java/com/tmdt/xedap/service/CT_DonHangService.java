package com.tmdt.xedap.service;

import java.util.List;

import com.tmdt.xedap.entity.CT_DonHang;

public interface CT_DonHangService {

	List<CT_DonHang> getDetailByMadh(String madh);
}
