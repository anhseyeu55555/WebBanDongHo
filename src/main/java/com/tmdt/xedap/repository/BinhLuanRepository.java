package com.tmdt.xedap.repository;

import com.tmdt.xedap.entity.BinhLuan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BinhLuanRepository extends JpaRepository<BinhLuan, String> {

    @Query(value = "FROM BinhLuan bl JOIN FETCH SanPham sp WHERE sp.maSp=: masp")
    List<BinhLuan> getListBinhLuanByMaSP(String maSp);

    BinhLuan findByMaBl(String maBl);

    @Query(value = "FROM BinhLuan b ORDER BY b.ngayBinhLuan desc")
    List<BinhLuan> getAllBinhLuan();
}
