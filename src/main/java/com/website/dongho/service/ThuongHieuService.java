package com.website.dongho.service;

import com.website.dongho.entity.ThuongHieu;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface ThuongHieuService {
    List<ThuongHieu> getListService();

    ResponseEntity<ThuongHieu> getDetailThuongHieu(String math);

    ResponseEntity<String> addThuongHieu(ThuongHieu thuonghieu);

    ResponseEntity<String> deleteThuongHieu(String math);

    ResponseEntity<ThuongHieu> updateThuongHieu(String math, ThuongHieu thuonghieu);
}
