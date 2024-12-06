package com.tmdt.xedap.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tmdt.xedap.entity.NhanVien;


public interface NhanVienRepository extends JpaRepository<NhanVien, String> {

	@Query(value="FROM NhanVien nv WHERE nv.manv=:manv")
	NhanVien findByManv(String manv);
	
	@Query(value="from NhanVien nv where nv.taikhoan=:username")
	NhanVien findByUsername(String username);
	

	@Query(value="from NhanVien nv where nv.email=:email")
	NhanVien findByEmail(String email);
	
}
