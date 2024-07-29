package com.tmdt.xedap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tmdt.xedap.entity.BinhLuan;

public interface BinhLuanRepository extends JpaRepository<BinhLuan, String> {

	
	@Query(value="SELECT * FROM binh_luan WHERE masp=?1", nativeQuery = true)
	List<BinhLuan> getListBinhLuanByMaSP(String masp);
	
	@Query(value="SELECT * FROM binh_luan WHERE mabl=?1", nativeQuery = true)
	BinhLuan findByMaBL(String mabl);
}
