package com.tmdt.xedap.service;

import java.util.List;

import com.tmdt.xedap.entity.CT_PhieuNhap;

public interface CT_PhieuNhapService {

	List<CT_PhieuNhap> getDetailByMaPn(String mapn);
}
