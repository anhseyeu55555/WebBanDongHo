package com.website.dongho.service;

import com.website.dongho.entity.CT_DonHang;

import java.util.List;

public interface CT_DonHangService {
    List<CT_DonHang> getDetailByMadh(String madh);
}
