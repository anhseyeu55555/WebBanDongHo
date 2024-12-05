package com.website.dongho.repository;

import com.website.dongho.entity.TaiKhoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TaiKhoanRepository extends JpaRepository<TaiKhoan, String>{

	@Query(value="SELECT * FROM tai_khoan WHERE username=?1", nativeQuery = true)
	TaiKhoan findByUsername(String username);
	
	
//	@Transactional
//	@Modifying
//	@Query(value="delete from tai_khoan tk where tk.username = ?1", nativeQuery = true)
//	void deleteTaiKhoanByUsername(String username);
}
