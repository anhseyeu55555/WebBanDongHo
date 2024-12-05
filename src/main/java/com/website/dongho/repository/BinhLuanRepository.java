package com.website.dongho.repository;

import com.website.dongho.entity.BinhLuan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BinhLuanRepository extends JpaRepository<BinhLuan, String> {

	
	@Query(value="SELECT * FROM binh_luan WHERE masp=?1", nativeQuery = true)
	List<BinhLuan> getListBinhLuanByMaSP(String masp);
	
	@Query(value="SELECT * FROM binh_luan WHERE mabl=?1", nativeQuery = true)
	BinhLuan findByMaBL(String mabl);
	
	@Query(value="SELECT * FROM binh_luan ORDER BY time DESC", nativeQuery = true)
	List<BinhLuan> getListBinhLuanSort();
}
