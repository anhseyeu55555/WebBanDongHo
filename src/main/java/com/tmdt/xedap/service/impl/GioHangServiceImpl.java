package com.tmdt.xedap.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tmdt.xedap.entity.GioHang;
import com.tmdt.xedap.entity.GioHang_ID;
import com.tmdt.xedap.entity.KhachHang;
import com.tmdt.xedap.entity.SanPham;
import com.tmdt.xedap.repository.GioHangRepository;
import com.tmdt.xedap.repository.KhachHangRepository;
import com.tmdt.xedap.repository.SanPhamRepository;
import com.tmdt.xedap.service.GioHangService;

@Service
public class GioHangServiceImpl implements GioHangService {
	
	@Autowired
	private GioHangRepository ghRepository;
	
	@Autowired
	private SanPhamRepository spRepository;
	
	@Autowired
	private KhachHangRepository khRepository;
	
	

	@Override
	public List<GioHang> getListGH(String makh) {
		// TODO Auto-generated method stub
		return ghRepository.getGioHangByMakh(makh);
	}

	@Override
	public ResponseEntity<String> addGioHang(String makh, String masp, int soluong) {
		// TODO Auto-generated method stub
		try {
			SanPham findSP = spRepository.findByMasp(masp);
			
			if(findSP == null) {
				return new ResponseEntity<String>("Sản phẩm không tồn tại!", HttpStatus.BAD_REQUEST);
			}
			
			KhachHang findKH = khRepository.findByMakh(makh);
			
			if(findKH == null) {
				return new ResponseEntity<String>("Khách hàng không tồn tại!", HttpStatus.BAD_REQUEST);
			}
			
			GioHang_ID gh_id = new GioHang_ID(makh, masp);
			GioHang gh = new GioHang();
			
			gh.setId(gh_id);
			
			gh.setSanpham(findSP);
			gh.setKhachhang(findKH);
			
			
			GioHang findSPGioHang =  ghRepository.getDetailGioHangByMakhAndMasp(makh, masp);
			
			
			if(findSPGioHang == null) {
				gh.setSoluong(1);
			}
			else
			{
				gh.setSoluong(findSPGioHang.getSoluong() + 1);
			}
			
			ghRepository.save(gh);
			return new ResponseEntity<String>("Thêm sản phẩm vào giỏ hàng thành công!", HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<String>("Đã xảy ra lỗi, thêm sản phẩm vào giỏ hàng thất bại!", HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<String> deleteGioHangByKH(String makh) {
		// TODO Auto-generated method stub
		try {
			ghRepository.deleteGioHangByMakh(makh);
			return new ResponseEntity<String>("Đã xoá tất cả các sản phẩm trong giỏ hàng!", HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<String>("Đã xảy ra lỗi, xoá giỏ hàng thất bại", HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<String> deleteGioHangByKHAndSP(String makh, String masp) {
		// TODO Auto-generated method stub
		try {
			ghRepository.deleteGioHangByMakhAndMasp(makh, masp);
			return new ResponseEntity<String>("Đã xoá sản phẩm thành công!", HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<String>("Đã xảy ra lỗi, xoá sản phẩm thất bại!", HttpStatus.BAD_REQUEST);
		}
	}

}
