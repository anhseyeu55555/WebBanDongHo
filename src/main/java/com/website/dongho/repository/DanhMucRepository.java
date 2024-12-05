package com.website.dongho.repository;

import com.website.dongho.entity.DanhMuc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



public interface DanhMucRepository extends JpaRepository<DanhMuc, String>{

	@Query(value="SELECT * FROM danh_muc WHERE madm=?1", nativeQuery = true)
	DanhMuc findByMadm(String maDM);
}
