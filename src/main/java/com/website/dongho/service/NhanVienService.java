package com.website.dongho.service;

import com.website.dongho.dto.NhanVienDangKy;
import com.website.dongho.entity.NhanVien;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface NhanVienService {

    List<NhanVien> getListService();

    ResponseEntity<NhanVien> getDetailNV(String manv);

    ResponseEntity<NhanVien> getDetailNVByUsername(String username);

    ResponseEntity<String> addNV(NhanVienDangKy nvdk);

    ResponseEntity<String> deleteNV(String manv);

    ResponseEntity<NhanVien> updateNV(String manv, NhanVien nv);
}
