package com.website.dongho.service;

import com.website.dongho.dto.DonNhapHangDto;
import com.website.dongho.entity.DonNhapHang;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DonNhapHangService {
    List<DonNhapHang> getListService();

    ResponseEntity<String> addDonDathang(DonNhapHangDto ddhModel);
}
