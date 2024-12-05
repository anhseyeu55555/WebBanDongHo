package com.website.dongho.repository;

import com.website.dongho.dto.DonThuThang;
import com.website.dongho.entity.DonHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

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
	
	
	@Query("SELECT new com.tmdt.dongho.model.DonThuThang(MONTH(dh.ngayDat), SUM(dh.tongTien)) " +
	           "FROM DonHang dh " +
	           "WHERE dh.trangThai = 3 AND YEAR(dh.ngayDat) = YEAR(CURDATE()) " +
	           "GROUP BY MONTH(dh.ngayDat) ORDER BY dh.ngayDat")
	List<DonThuThang> getThongKeByYear();
	
	
	
}
