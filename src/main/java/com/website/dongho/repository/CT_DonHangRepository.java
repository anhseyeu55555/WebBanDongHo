package com.website.dongho.repository;


import com.website.dongho.entity.CT_DonHang;
import com.website.dongho.entity.CT_DonHang_ID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CT_DonHangRepository extends JpaRepository<CT_DonHang, CT_DonHang_ID> {
    @Query(value = "SELECT * FROM ct_don_hang WHERE madh=?1", nativeQuery = true)
    List<CT_DonHang> findBymadh(String madh);
}
