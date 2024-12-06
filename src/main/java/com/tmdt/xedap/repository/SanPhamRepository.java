package com.tmdt.xedap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tmdt.xedap.entity.SanPham;

public interface SanPhamRepository extends JpaRepository<SanPham, String>{
	
	@Query(value="SELECT * FROM san_pham WHERE masp=?1", nativeQuery = true)
	SanPham findByMasp(String masp);
	
	@Query(value="SELECT * FROM san_pham WHERE slug=?1", nativeQuery = true)
	SanPham findBySlug(String slug);
	
	@Query(value = "select * from san_pham where madm = ?1 AND trangthai <> 2",nativeQuery = true)
	List<SanPham> getSPByMaDM(String madm);
	
	@Query(value = "select * from san_pham where math = ?1 AND trangthai <> 2",nativeQuery = true)
	List<SanPham> getSPByMaTH(String math);
	
	@Query(value = "select * from san_pham where mancc = ?1 AND trangthai <> 2",nativeQuery = true)
	List<SanPham> getSPByMaNcc(String mancc);
	
	@Query(value = "FROM SanPham WHERE tenSp LIKE %:search%")
	List<SanPham> getSPBySearch(String search);
	
	@Query(value = "SELECT sp.* FROM ct_don_hang ctdh JOIN san_pham sp ON ctdh.masp = sp.masp GROUP BY sp.masp, sp.tensp ORDER BY Sum(ctdh.soluong) DESC", nativeQuery = true)
	List<SanPham> getListBestSeller();
}
