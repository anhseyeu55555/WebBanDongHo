package com.tmdt.xedap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tmdt.xedap.entity.CT_DonNhapHang;
import com.tmdt.xedap.entity.CT_DonDatHang_ID;

public interface CT_DonDatHangRepository extends JpaRepository<CT_DonNhapHang, CT_DonDatHang_ID>{

	@Query(value="SELECT * FROM xedap.ct_don_nhap_hang WHERE maddh=?1", nativeQuery = true)
	List<CT_DonNhapHang> findBymaddh(String maddh);
}
