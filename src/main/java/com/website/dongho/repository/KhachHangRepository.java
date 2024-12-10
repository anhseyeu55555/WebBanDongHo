package com.website.dongho.repository;

import com.website.dongho.entity.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface KhachHangRepository extends JpaRepository<KhachHang, String>{
	@Query(value="SELECT * FROM khach_hang WHERE makh=?1", nativeQuery = true)
	KhachHang findByMakh(String makh);
	
	@Query(value="select * from khach_hang where username = ?1", nativeQuery = true)
	KhachHang findByUsername(String username);

	@Query(value="select * from khach_hang where email = ?1", nativeQuery = true)
	KhachHang findByEmail(String email);
	
}
