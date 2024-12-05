package com.tmdt.xedap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tmdt.xedap.entity.DonNhapHang;


public interface DonDatHangRepository extends JpaRepository<DonNhapHang, String>{

	
	@Query(value="from DonNhapHang dnh where dnh.nhanvien.manv = ?1")
	DonNhapHang findByNV(String manv);
	

	@Query(value="FROM DonNhapHang WHERE mddh=:maddh")
	DonNhapHang findByMaddh(String maddh);
}
