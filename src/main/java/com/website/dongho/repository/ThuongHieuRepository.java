package com.website.dongho.repository;

import com.website.dongho.entity.ThuongHieu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ThuongHieuRepository extends JpaRepository<ThuongHieu, String>{

	
	@Query(value="SELECT * FROM thuong_hieu WHERE math=?1", nativeQuery = true)
	ThuongHieu findByMath(String math);
}

