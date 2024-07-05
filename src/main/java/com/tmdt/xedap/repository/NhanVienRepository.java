package com.tmdt.xedap.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tmdt.xedap.entity.NhanVien;


public interface NhanVienRepository extends JpaRepository<NhanVien, String> {

	@Query(value="SELECT * FROM nhan_vien WHERE manv=?1", nativeQuery = true)
	NhanVien findByManv(String manv);
	
	@Query(value="select * from nhan_vien where tai_khoan.username = ?1", nativeQuery = true)
	NhanVien findByUsername(String username);
	

}
