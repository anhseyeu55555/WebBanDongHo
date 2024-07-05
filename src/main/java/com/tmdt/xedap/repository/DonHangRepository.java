package com.tmdt.xedap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tmdt.xedap.entity.DonHang;

public interface DonHangRepository extends JpaRepository<DonHang, String>{

	
	// get lisst don hang theo nhan vine
	@Query(value = "SELECT * FROM don_hang where manv = ?1" ,nativeQuery = true)
	List<DonHang> listDonHangByMaNV(String manv);
	
	// get list don hang theo user
	@Query(value = "SELECT * FROM don_hang where makh = ?1" ,nativeQuery = true)
	List<DonHang> listDonHangByMaKH(String makh);
	
	
	// get list don hang chưa xác nhận
	@Query(value = "SELECT * FROM don_hang where makh = ?1 and trang_thai = ?2" ,nativeQuery = true)
	List<DonHang> listDHByTrangThai(String makh, int trangthai);
	
	
	//get don hang by ma don hang
	@Query(value = "SELECT * FROM don_hang where madh = ?1" ,nativeQuery = true)
	DonHang getDetailDH(String madh);
	
}