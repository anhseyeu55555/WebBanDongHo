package com.tmdt.xedap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.tmdt.xedap.entity.GioHang;
import com.tmdt.xedap.entity.GioHang_ID;

import jakarta.transaction.Transactional;

public interface GioHangRepository extends JpaRepository<GioHang, GioHang_ID> {

	@Query(value="SELECT * FROM gio_hang WHERE makh=?1", nativeQuery = true)
	List<GioHang> getGioHangByMakh(String makh);
	
	@Query(value="SELECT * FROM gio_hang WHERE makh=?1 and masp=?2", nativeQuery = true)
	GioHang getDetailGioHangByMakhAndMasp(String makh, String masp);
	
	@Transactional
	@Modifying
	@Query(value="delete from gio_hang where makh=?1", nativeQuery = true)
	void deleteGioHangByMakh(String makh);
	
	@Transactional
	@Modifying
	@Query(value="delete from gio_hang where makh=?1 and masp=?2", nativeQuery = true)
	void deleteGioHangByMakhAndMasp(String makh, String masp);
}
