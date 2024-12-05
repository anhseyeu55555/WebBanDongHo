package com.website.dongho.repository;

import com.website.dongho.entity.CT_DonNhapHang;
import com.website.dongho.entity.CT_DonNhapHang_ID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CT_DonDatHangRepository extends JpaRepository<CT_DonNhapHang, CT_DonNhapHang_ID>{
	@Query(value="SELECT * FROM donghodb.ct_don_nhap_hang WHERE madnh=?1", nativeQuery = true)
	List<CT_DonNhapHang> findBymaddh(String maddh);
}
