package com.tmdt.xedap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tmdt.xedap.entity.DanhMuc;



public interface DanhMucRepository extends JpaRepository<DanhMuc, String>{

	@Query(value="SELECT * FROM danh_muc WHERE madm=?1", nativeQuery = true)
	DanhMuc findByMadm(String maDM);
}
