package com.website.dongho.repository;

import com.website.dongho.entity.DonNhapHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface DonNhapHangRepository extends JpaRepository<DonNhapHang, String>{

	
	@Query(value="from DonNhapHang dnh where dnh.nhanvien.manv = :manv")
	DonNhapHang findByNV(String manv);
	

	@Query(value="SELECT * FROM don_nhap_hang WHERE madnh=?1", nativeQuery = true)
	DonNhapHang findByMadnh(String madnh);
}
