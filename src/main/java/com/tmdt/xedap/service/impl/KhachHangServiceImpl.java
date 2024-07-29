package com.tmdt.xedap.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tmdt.xedap.entity.KhachHang;
import com.tmdt.xedap.entity.Quyen;
import com.tmdt.xedap.entity.TaiKhoan;
import com.tmdt.xedap.model.KhachHangDangKy;
import com.tmdt.xedap.repository.KhachHangRepository;
import com.tmdt.xedap.repository.TaiKhoanRepository;
import com.tmdt.xedap.service.KhachHangService;

@Service
public class KhachHangServiceImpl implements KhachHangService{
	
	@Autowired
	private KhachHangRepository khRepository;
	
	@Autowired
	private TaiKhoanRepository tkRepository;
	

	@Override
	public List<KhachHang> getListService() {
		// TODO Auto-generated method stub
		return khRepository.findAll();
	}

	@Override
	public ResponseEntity<KhachHang> getDetailKH(String makh) {
		// TODO Auto-generated method stub
		try {
			KhachHang kh = khRepository.findByMakh(makh);
			
			if(kh == null) {
				return new ResponseEntity<KhachHang>(new KhachHang(), HttpStatus.BAD_REQUEST);
			}
			
			return new ResponseEntity<KhachHang>(kh, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<KhachHang>(new KhachHang(), HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<String> registerUser(KhachHangDangKy khdk) {
		// TODO Auto-generated method stub
		try {
			TaiKhoan findTK = tkRepository.findByUsername(khdk.getUsername());

			if(findTK != null){
				return new ResponseEntity<String>("Username đã tồn tại!", HttpStatus.BAD_REQUEST);
			}
			
			KhachHang findKH = khRepository.findByEmail(khdk.getEmail());
			
			if(findKH != null){
				return new ResponseEntity<String>("Địa chỉ email đã tồn tại", HttpStatus.BAD_REQUEST);
			}
//			
//			if(findNV.getSdt().equals(nvdk.getSdt())){
//				return new ResponseEntity<String>("Số điện thoại đã tồn tại", HttpStatus.BAD_REQUEST);
//			}

			TaiKhoan newTk = new TaiKhoan();
			newTk.setUsername(khdk.getUsername());
			newTk.setPassword(khdk.getPassword());
			newTk.setQuyen(new Quyen(2));
			
			
			
			KhachHang newKH = new KhachHang();
			newKH.setTaikhoan(newTk);
			newKH.setDiaChi(khdk.getDiachi());
			newKH.setEmail(khdk.getEmail());
			newKH.setGioiTinh(khdk.getGioitinh());
			newKH.setHoTen(khdk.getHoten());
			newKH.setSdt(khdk.getSdt());
			String maKH = "KH" +  System.currentTimeMillis() % 10000000;
			newKH.setMakh(maKH);
			
			tkRepository.save(newTk);
			khRepository.save(newKH);
		
			return new ResponseEntity<String>("Đăng ký thành công!", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Đã xảy ra lỗi, đăng ký thất bại!", HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<String> deleteKH(String makh) {
		// TODO Auto-generated method stub
		try {
			KhachHang findKH = khRepository.findByMakh(makh);
			
			if(findKH == null){
				return new ResponseEntity<String>("Mã user không tồn tại!", HttpStatus.BAD_REQUEST);
			}
			
			khRepository.deleteById(makh);
			tkRepository.deleteById(findKH.getTaikhoan().getUsername());
			return new ResponseEntity<String>("Xoá user thành công!", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Đã xảy ra lỗi, xoá user thất bại!", HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<KhachHang> updateUser(String makh, KhachHang kh) {
		// TODO Auto-generated method stub
		try {
			KhachHang findKH = khRepository.findByMakh(makh);
			
			if(findKH  == null){
				return new ResponseEntity<KhachHang>(new KhachHang(), HttpStatus.BAD_REQUEST);
			}
			
			kh.setTaikhoan(findKH.getTaikhoan());
			
			khRepository.save(kh);
			return new ResponseEntity<KhachHang>(kh, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<KhachHang>(new KhachHang(), HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<KhachHang> getDetailKHByUsername(String username) {
		// TODO Auto-generated method stub
		try {
			KhachHang kh = khRepository.findByUsername(username);
			
			if(kh == null) {
				return new ResponseEntity<KhachHang>(new KhachHang(), HttpStatus.BAD_REQUEST);
			}
			
			return new ResponseEntity<KhachHang>(kh, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<KhachHang>(new KhachHang(), HttpStatus.BAD_REQUEST);
		}
	}

}
