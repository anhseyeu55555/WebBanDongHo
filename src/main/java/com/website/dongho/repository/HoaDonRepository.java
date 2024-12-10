package com.website.dongho.repository;

import com.website.dongho.entity.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface HoaDonRepository extends JpaRepository<HoaDon, String> {
    @Query(value = "SELECT * FROM hoa_don WHERE mahd=?1", nativeQuery = true)
    HoaDon findByMahd(String mahd);
}
