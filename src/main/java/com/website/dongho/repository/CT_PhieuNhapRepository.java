package com.website.dongho.repository;

import com.website.dongho.entity.CT_PhieuNhap;
import com.website.dongho.entity.CT_PhieuNhap_ID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CT_PhieuNhapRepository extends JpaRepository<CT_PhieuNhap, CT_PhieuNhap_ID>{
	@Query(value="SELECT * FROM ct_phieu_nhap WHERE mapn=?1", nativeQuery = true)
	List<CT_PhieuNhap> findByMapn(String mapn);
}
