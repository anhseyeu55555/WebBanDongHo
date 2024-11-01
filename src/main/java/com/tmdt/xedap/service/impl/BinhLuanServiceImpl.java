package com.tmdt.xedap.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tmdt.xedap.entity.BinhLuan;
import com.tmdt.xedap.entity.KhachHang;
import com.tmdt.xedap.entity.SanPham;
import com.tmdt.xedap.dto.BinhLuanModel;
import com.tmdt.xedap.repository.BinhLuanRepository;
import com.tmdt.xedap.repository.KhachHangRepository;
import com.tmdt.xedap.repository.SanPhamRepository;
import com.tmdt.xedap.service.BinhLuanService;


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
		// TODO Auto-generated method stub
		return blRepository.getAllBinhLuanOrderByNgayBinhLuanDesc();
	}

	@Override
	public List<BinhLuan> getListBinhLuanByMaSP(String masp) {
		// TODO Auto-generated method 
		return blRepository.getListBinhLuanByMaSP(masp);
	}

	@Override
	public ResponseEntity<String> deleteBinhLuan(String maBL) {
		// TODO Auto-generated method stub
		try {
			BinhLuan findBinhLuan = blRepository.findByMaBl(maBL);
			
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
	public ResponseEntity<String> addBinhLuan(BinhLuanModel binhluanModel) {
		// TODO Auto-generated method stub
		try {
			KhachHang findKH = khRepository.findByMakh(binhluanModel.getMakh());
			
			
			if(findKH == null){
				return new ResponseEntity<String>("khách hàng không tồn tại!", HttpStatus.BAD_REQUEST);
			}
			
			SanPham findSP = spRepository.findByMasp(binhluanModel.getMasp());
			
			if(findSP == null){
				return new ResponseEntity<String>("Sản phẩm không tồn tại!", HttpStatus.BAD_REQUEST);
			}
			
			BinhLuan bl = new BinhLuan();
			
			
			String maBL = "BL" +  System.currentTimeMillis() % 10000000;
			bl.setMaBl(maBL);
			
			bl.setNoiDung(binhluanModel.getNoidung());
			bl.setSanPham(findSP);
			bl.setKhachHang(findKH);
			
			Date date = new Date();
			bl.setNgayBinhLuan(date);
			
			blRepository.save(bl);
			return new ResponseEntity<String>("Thêm bình luận thành công!", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Đã xảy ra lỗi, thêm bình luận thất bại!", HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<BinhLuan> updateBinhLuan(String mabl, BinhLuanModel binhluanModel) {
		// TODO Auto-generated method stub
		try {
			BinhLuan findBL = blRepository.findByMaBl(mabl);
			
			if(findBL == null){
				return new ResponseEntity<BinhLuan>(new BinhLuan(), HttpStatus.BAD_REQUEST);
			}
			
			KhachHang findKH = khRepository.findByMakh(binhluanModel.getMakh());
			
			
			if(!findKH.getMakh().equals(findBL.getKhachHang().getMakh())){
				return new ResponseEntity<BinhLuan>(new BinhLuan(), HttpStatus.BAD_REQUEST);
			}
			
			SanPham findSP = spRepository.findByMasp(binhluanModel.getMasp());
			
			if(!findSP.getMaSp().equals(findBL.getSanPham().getMaSp())){
				return new ResponseEntity<BinhLuan>(new BinhLuan(), HttpStatus.BAD_REQUEST);
			}
			
			BinhLuan updateBL = findBL;
			updateBL.setNoiDung(binhluanModel.getNoidung());
			
			blRepository.save(updateBL);
			return new ResponseEntity<BinhLuan>(updateBL, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<BinhLuan>(new BinhLuan(), HttpStatus.BAD_REQUEST);
		}
	}

}
