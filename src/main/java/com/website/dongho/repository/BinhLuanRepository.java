package com.website.dongho.repository;

import com.website.dongho.entity.BinhLuan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BinhLuanRepository extends JpaRepository<BinhLuan, String> {
    @Query(value = "FROM BinhLuan bl WHERE bl.sanpham.masp = :masp")
    List<BinhLuan> getListBinhLuanByMaSP(String masp);

    @Query(value = "FROM BinhLuan bl WHERE bl.mabl = :mabl")
    BinhLuan findByMaBL(String mabl);

    @Query(value = "FROM BinhLuan bl ORDER BY bl.time DESC")
    List<BinhLuan> getListBinhLuanSort();
}
