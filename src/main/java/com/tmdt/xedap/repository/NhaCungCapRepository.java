package com.tmdt.xedap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tmdt.xedap.entity.NhaCungCap;

public interface NhaCungCapRepository extends JpaRepository<NhaCungCap, String>{

	@Query(value="SELECT * FROM nha_cung_cap WHERE mancc=?1", nativeQuery = true)
	NhaCungCap findByMancc(String mancc);
}
