package com.website.dongho.repository;


import com.website.dongho.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface NhanVienRepository extends JpaRepository<NhanVien, String> {

    @Query(value = "SELECT * FROM nhan_vien WHERE manv=?1", nativeQuery = true)
    NhanVien findByManv(String manv);

    @Query(value = "select * from nhan_vien where username = ?1", nativeQuery = true)
    NhanVien findByUsername(String username);

    @Query(value = "select * from nhan_vien where email = ?1", nativeQuery = true)
    NhanVien findByEmail(String email);

}
