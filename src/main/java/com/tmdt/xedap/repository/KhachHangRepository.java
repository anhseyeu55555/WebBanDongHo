package com.tmdt.xedap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tmdt.xedap.entity.KhachHang;
import com.tmdt.xedap.entity.NhanVien;

public interface KhachHangRepository extends JpaRepository<KhachHang, String>{

	@Query(value="SELECT * FROM khach_hang WHERE makh=?1", nativeQuery = true)
	KhachHang findByMakh(String makh);
	
	@Query(value="select * from khach_hang where tai_khoan.username = ?1", nativeQuery = true)
	NhanVien findByUsername(String username);
	
}
