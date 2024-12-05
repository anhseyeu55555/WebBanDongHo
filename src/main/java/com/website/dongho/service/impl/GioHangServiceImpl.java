package com.website.dongho.service.impl;

import com.website.dongho.entity.GioHang;
import com.website.dongho.entity.GioHang_ID;
import com.website.dongho.entity.KhachHang;
import com.website.dongho.entity.SanPham;
import com.website.dongho.repository.GioHangRepository;
import com.website.dongho.repository.KhachHangRepository;
import com.website.dongho.repository.SanPhamRepository;
import com.website.dongho.service.GioHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

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
		return ghRepository.getGioHangByMakh(makh);
	}

	@Override
	public ResponseEntity<String> addGioHang(String makh, String masp, int soluong) {
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
				gh.setSoluong(soluong);
			}
			else
			{
				gh.setSoluong(findSPGioHang.getSoluong() + soluong);
			}
			
			ghRepository.save(gh);
			return new ResponseEntity<String>("Thêm sản phẩm vào giỏ hàng thành công!", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Đã xảy ra lỗi, thêm sản phẩm vào giỏ hàng thất bại!", HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<String> deleteGioHangByKH(String makh) {
		try {
			ghRepository.deleteGioHangByMakh(makh);
			return new ResponseEntity<String>("Đã xoá tất cả các sản phẩm trong giỏ hàng!", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Đã xảy ra lỗi, xoá giỏ hàng thất bại", HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<String> deleteGioHangByKHAndSP(String makh, String masp) {
		try {
			ghRepository.deleteGioHangByMakhAndMasp(makh, masp);
			return new ResponseEntity<String>("Đã xoá sản phẩm thành công!", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Đã xảy ra lỗi, xoá sản phẩm thất bại!", HttpStatus.BAD_REQUEST);
		}
	}

}
