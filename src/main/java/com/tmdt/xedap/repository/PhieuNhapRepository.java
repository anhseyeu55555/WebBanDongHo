package com.tmdt.xedap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tmdt.xedap.entity.PhieuNhap;

public interface PhieuNhapRepository extends JpaRepository<PhieuNhap, String> {

	@Query(value="SELECT * FROM phieu_nhap WHERE mapn=?1", nativeQuery = true)
	PhieuNhap findByMapn(String mapn);
	
}


