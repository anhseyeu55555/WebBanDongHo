package com.tmdt.xedap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tmdt.xedap.entity.ThuongHieu;

public interface ThuongHieuRepository extends JpaRepository<ThuongHieu, String>{

	
	@Query(value="SELECT * FROM thuong_hieu WHERE math=?1", nativeQuery = true)
	ThuongHieu findByMath(String math);
}

