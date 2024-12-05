package com.website.dongho.repository;

import com.website.dongho.entity.CT_DonNhapHang;
import com.website.dongho.entity.CT_DonNhapHang_ID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CT_DonDatHangRepository extends JpaRepository<CT_DonNhapHang, CT_DonNhapHang_ID>{

	@Query(value="SELECT * FROM ct_don_dat_hang WHERE maddh=?1", nativeQuery = true)
	List<CT_DonNhapHang> findBymaddh(String maddh);
}
