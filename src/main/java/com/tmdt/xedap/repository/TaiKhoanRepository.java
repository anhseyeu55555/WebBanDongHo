package com.tmdt.xedap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.tmdt.xedap.entity.TaiKhoan;

import jakarta.transaction.Transactional;

public interface TaiKhoanRepository extends JpaRepository<TaiKhoan, String>{

	@Query(value="SELECT * FROM tai_khoan WHERE ten_tai_khoan=?1", nativeQuery = true)
	TaiKhoan findByUsername(String username);
	
	
//	@Transactional
//	@Modifying
//	@Query(value="delete from tai_khoan tk where tk.username = ?1", nativeQuery = true)
//	void deleteTaiKhoanByUsername(String username);
}
