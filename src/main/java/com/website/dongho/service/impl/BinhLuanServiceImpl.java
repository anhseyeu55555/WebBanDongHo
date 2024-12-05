package com.website.dongho.service.impl;

import com.website.dongho.dto.BinhLuanDto;
import com.website.dongho.entity.BinhLuan;
import com.website.dongho.entity.KhachHang;
import com.website.dongho.entity.SanPham;
import com.website.dongho.repository.BinhLuanRepository;
import com.website.dongho.repository.KhachHangRepository;
import com.website.dongho.repository.SanPhamRepository;
import com.website.dongho.service.BinhLuanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class BinhLuanServiceImpl implements BinhLuanService {
	
	@Autowired 
	private BinhLuanRepository blRepository;
	
	@Autowired
	private KhachHangRepository khRepository;
	
	@Autowired 
	private SanPhamRepository spRepository;

	@Override
	public List<BinhLuan> getListService() {
		return blRepository.getListBinhLuanSort();
	}

	@Override
	public List<BinhLuan> getListBinhLuanByMaSP(String masp) {
		return blRepository.getListBinhLuanByMaSP(masp);
	}

	@Override
	public ResponseEntity<String> deleteBinhLuan(String maBL) {
		try {
			BinhLuan findBinhLuan = blRepository.findByMaBL(maBL);
			
			if(findBinhLuan == null){
				return new ResponseEntity<String>("Bình luận không tồn tại!", HttpStatus.BAD_REQUEST);
			}
			
			blRepository.deleteById(maBL);
			return new ResponseEntity<String>("Xoá bình luận thành công!", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Đã xảy ra lỗi, xoá bình luận thất bại!", HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<String> addBinhLuan(BinhLuanDto binhluanDto) {
		try {
			KhachHang findKH = khRepository.findByMakh(binhluanDto.getMakh());
			
			
			if(findKH == null){
				return new ResponseEntity<String>("khách hàng không tồn tại!", HttpStatus.BAD_REQUEST);
			}
			
			SanPham findSP = spRepository.findByMasp(binhluanDto.getMasp());
			
			if(findSP == null){
				return new ResponseEntity<String>("Sản phẩm không tồn tại!", HttpStatus.BAD_REQUEST);
			}
			
			BinhLuan bl = new BinhLuan();
			
			
			String maBL = "BL" +  System.currentTimeMillis() % 10000000;
			bl.setMabl(maBL);
			
			bl.setNoidung(binhluanDto.getNoidung());
			bl.setSanpham(findSP);
			bl.setKhachhang(findKH);
			
			Date date = new Date();
			bl.setTime(date);
			
			blRepository.save(bl);
			return new ResponseEntity<String>("Thêm bình luận thành công!", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Đã xảy ra lỗi, thêm bình luận thất bại!", HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<BinhLuan> updateBinhLuan(String mabl, BinhLuanDto binhluanDto) {
		try {
			BinhLuan findBL = blRepository.findByMaBL(mabl);
			
			if(findBL == null){
				return new ResponseEntity<BinhLuan>(new BinhLuan(), HttpStatus.BAD_REQUEST);
			}
			
			KhachHang findKH = khRepository.findByMakh(binhluanDto.getMakh());
			
			
			if(!findKH.getMakh().equals(findBL.getKhachhang().getMakh())){
				return new ResponseEntity<BinhLuan>(new BinhLuan(), HttpStatus.BAD_REQUEST);
			}
			
			SanPham findSP = spRepository.findByMasp(binhluanDto.getMasp());
			
			if(!findSP.getMasp().equals(findBL.getSanpham().getMasp())){
				return new ResponseEntity<BinhLuan>(new BinhLuan(), HttpStatus.BAD_REQUEST);
			}
			
			BinhLuan updateBL = findBL;
			updateBL.setNoidung(binhluanDto.getNoidung());
			
			blRepository.save(updateBL);
			return new ResponseEntity<BinhLuan>(updateBL, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<BinhLuan>(new BinhLuan(), HttpStatus.BAD_REQUEST);
		}
	}

}
