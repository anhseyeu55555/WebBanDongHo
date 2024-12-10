package com.website.dongho.repository;

import com.website.dongho.dto.DonThuThangDto;
import com.website.dongho.entity.DonHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DonHangRepository extends JpaRepository<DonHang, String> {
    @Query(value = "SELECT * FROM don_hang where manv = ?1", nativeQuery = true)
    List<DonHang> listDonHangByMaNV(String manv);

    @Query(value = "SELECT * FROM don_hang where makh = ?1", nativeQuery = true)
    List<DonHang> listDonHangByMaKH(String makh);

    @Query(value = "SELECT * FROM don_hang where makh = ?1 and trang_thai = ?2", nativeQuery = true)
    List<DonHang> listDHByTrangThai(String makh, int trangthai);

    @Query(value = "SELECT * FROM don_hang where madh = ?1", nativeQuery = true)
    DonHang getDetailDH(String madh);

    @Query("SELECT new com.website.dongho.dto.DonThuThangDto(MONTH(dh.ngayDat), SUM(dh.tongTien)) " +
            "FROM DonHang dh " +
            "WHERE dh.trangThai = 3 AND YEAR(dh.ngayDat) = YEAR(CURDATE()) " +
            "GROUP BY MONTH(dh.ngayDat) ORDER BY dh.ngayDat")
    List<DonThuThangDto> getThongKeByYear();
}
