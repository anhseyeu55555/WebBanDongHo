package com.tmdt.xedap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tmdt.xedap.entity.DonDatHang;


public interface DonDatHangRepository extends JpaRepository<DonDatHang, String>{

	
	@Query(value="select * from don_dat_hang where nhan_vien.manv = ?1", nativeQuery = true)
	DonDatHang findByNV(String manv);
	

	@Query(value="SELECT * FROM don_dat_hang WHERE maddh=?1", nativeQuery = true)
	DonDatHang findByMaddh(String maddh);
}
