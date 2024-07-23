package com.tmdt.xedap.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tmdt.xedap.entity.DonHang;
import com.tmdt.xedap.entity.HoaDon;
import com.tmdt.xedap.model.HoaDonModel;
import com.tmdt.xedap.repository.DonHangRepository;
import com.tmdt.xedap.repository.HoaDonRepository;
import com.tmdt.xedap.service.HoaDonService;

@Service
public class HoaDonServiceImpl implements HoaDonService{

	@Autowired
	private HoaDonRepository hdRepository;
	
	@Autowired
	private DonHangRepository dhRepository;
	
	@Override
	public List<HoaDon> getListService() {
		// TODO Auto-generated method stub
		return hdRepository.findAll();
	}

	@Override
	public ResponseEntity<String> addHoaDon(HoaDonModel hdModel) {
		try {
			DonHang findDH = dhRepository.getDetailDH(hdModel.getMadh());
			
			if(findDH == null){
				return new ResponseEntity<String>("Mãd đơn hàng không tồn tại!", HttpStatus.BAD_REQUEST);
			}
			
			HoaDon hd = new HoaDon();
			
			String maHD = "HD" +  System.currentTimeMillis() % 10000000;
			
			
			hd.setDonhang(findDH);
			hd.setMahd(maHD);
			hd.setNgaylap(LocalDate.now());
			hd.setThanhtien(hdModel.getThanhtien());
			
			hdRepository.save(hd);
			
			return new ResponseEntity<String>("Thêm hoá đơn thành công!", HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<String>("Đã xảy ra lỗi, thêm hoá đơn thất bại!", HttpStatus.BAD_REQUEST);
		}
	
	}

}
