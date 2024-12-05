package com.website.dongho.service;

import com.website.dongho.entity.CT_PhieuNhap;

import java.util.List;

public interface CT_PhieuNhapService {

	List<CT_PhieuNhap> getDetailByMaPn(String mapn);
}
