package com.tmdt.xedap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tmdt.xedap.entity.ThuongHieu;

public interface ThuongHieuRepository extends JpaRepository<ThuongHieu, String>{

	
	@Query(value="FROM ThuongHieu th WHERE th.math=:math")
	ThuongHieu findByMath(String math);
}

