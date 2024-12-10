package com.website.dongho.repository;

import com.website.dongho.entity.PhieuNhap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PhieuNhapRepository extends JpaRepository<PhieuNhap, String> {
    @Query(value = "SELECT * FROM phieu_nhap WHERE mapn=?1", nativeQuery = true)
    PhieuNhap findByMapn(String mapn);
}


