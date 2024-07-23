package com.tmdt.xedap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tmdt.xedap.entity.HoaDon;


public interface HoaDonRepository extends JpaRepository<HoaDon, String> {

	@Query(value="SELECT * FROM hoa_don WHERE mahd=?1", nativeQuery = true)
	HoaDon findByMahd(String mahd);
}
