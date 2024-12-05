package com.website.dongho.repository;

import com.website.dongho.entity.DonNhapHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface DonDatHangRepository extends JpaRepository<DonNhapHang, String>{

	
	@Query(value="select * from don_dat_hang where nhan_vien.manv = ?1", nativeQuery = true)
	DonNhapHang findByNV(String manv);
	

	@Query(value="SELECT * FROM don_dat_hang WHERE maddh=?1", nativeQuery = true)
	DonNhapHang findByMaddh(String maddh);
}
