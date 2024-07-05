package com.tmdt.xedap.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tmdt.xedap.entity.CT_DonHang;
import com.tmdt.xedap.entity.CT_DonHang_ID;

public interface CT_DonHangRepository extends JpaRepository<CT_DonHang, CT_DonHang_ID>{
	@Query(value="SELECT * FROM ct_don_hang WHERE madh=?1", nativeQuery = true)
	List<CT_DonHang> findBymadh(String madh);
}
