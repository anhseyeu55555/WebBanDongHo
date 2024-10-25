package com.tmdt.xedap.repository;

import com.tmdt.xedap.entity.BinhLuan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BinhLuanRepository extends JpaRepository<BinhLuan, String> {

    @Query(value = "FROM BinhLuan b WHERE SanPham.maSp=?1")
    List<BinhLuan> getListBinhLuanByMaSP(String maSp);

    BinhLuan findByMaBl(String maBl);

    List<BinhLuan> getAllBinhLuanOrderByTimeDesc();
}
