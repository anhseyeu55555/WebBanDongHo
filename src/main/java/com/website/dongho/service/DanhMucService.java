package com.website.dongho.service;

import com.website.dongho.entity.DanhMuc;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DanhMucService {
    List<DanhMuc> getListService();

    ResponseEntity<DanhMuc> getDetailDanhMuc(String maDM);

    ResponseEntity<String> addDanhMuc(DanhMuc danhmuc);

    ResponseEntity<String> deleteDanhMuc(String maDM);

    ResponseEntity<DanhMuc> updateDanhMuc(String madm, DanhMuc danhmuc);
}
