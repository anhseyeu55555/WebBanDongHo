package com.website.dongho.service;

import com.website.dongho.entity.GioHang;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface GioHangService {
    List<GioHang> getListGH(String makh);

    ResponseEntity<String> addGioHang(String makh, String masp, int soluong);

    ResponseEntity<String> deleteGioHangByKH(String makh);

    ResponseEntity<String> deleteGioHangByKHAndSP(String makh, String masp);

}
