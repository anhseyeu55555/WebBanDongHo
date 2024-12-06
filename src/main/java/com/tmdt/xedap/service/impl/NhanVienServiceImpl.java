package com.tmdt.xedap.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tmdt.xedap.entity.NhanVien;
import com.tmdt.xedap.entity.Quyen;
import com.tmdt.xedap.entity.TaiKhoan;
import com.tmdt.xedap.dto.NhanVienDangKy;
import com.tmdt.xedap.repository.NhanVienRepository;
import com.tmdt.xedap.repository.TaiKhoanRepository;
import com.tmdt.xedap.service.NhanVienService;

@Service 
public class NhanVienServiceImpl implements NhanVienService{

	@Autowired
	private NhanVienRepository nvRepository;
	
	@Autowired
	private TaiKhoanRepository tkRepository;
	
	@Override
	public List<NhanVien> getListService() {
		// TODO Auto-generated method stub
		return nvRepository.findAll();
	}

	@Override
	public ResponseEntity<NhanVien> getDetailNV(String manv) {
		// TODO Auto-generated method stub
		try {
			NhanVien nv = nvRepository.findByManv(manv);
			
			if(nv == null) {
				return new ResponseEntity<NhanVien>(new NhanVien(), HttpStatus.BAD_REQUEST);
			}
			
			return new ResponseEntity<NhanVien>(nv, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<NhanVien>(new NhanVien(), HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<String> addNV(NhanVienDangKy nvdk) {
		// TODO Auto-generated method stub
		try {
			

			TaiKhoan findTK = tkRepository.findByUsername(nvdk.getUsername());

			if(findTK != null){
				return new ResponseEntity<String>("Username đã tồn tại!", HttpStatus.BAD_REQUEST);
			}
			
			NhanVien findNV = nvRepository.findByEmail(nvdk.getEmail());

			
			if(findNV != null){
				return new ResponseEntity<String>("Địa chỉ email đã tồn tại", HttpStatus.BAD_REQUEST);
			}
			
//			if(findNV.getSdt().equals(nvdk.getSdt())){
//				return new ResponseEntity<String>("Số điện thoại đã tồn tại", HttpStatus.BAD_REQUEST);
//			}

			TaiKhoan newTk = new TaiKhoan();
			newTk.setUsername(nvdk.getUsername());
			newTk.setPassword(nvdk.getPassword());
			newTk.setQuyen(new Quyen(3));
			
			
			
			NhanVien newNv = new NhanVien();
			newNv.setTaikhoan(newTk);
			newNv.setDiachi(nvdk.getDiachi());
			newNv.setEmail(nvdk.getEmail());
			newNv.setGioitinh(nvdk.getGioitinh());
			newNv.setHoten(nvdk.getHoten());
			newNv.setLuong(nvdk.getLuong());
			newNv.setSdt(nvdk.getSdt());
			String manv = "NV" +  System.currentTimeMillis() % 10000000;
			newNv.setManv(manv);
			
			tkRepository.save(newTk);
			nvRepository.save(newNv);
		
			return new ResponseEntity<String>("Thêm nhân viên thành công!", HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<String>("Đã xảy ra lỗi, thêm nhân viên thất bại!", HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<String> deleteNV(String manv) {
		try {
			NhanVien findNV = nvRepository.findByManv(manv);
			
			if(findNV == null){
				return new ResponseEntity<String>("Mã nhân viên không tồn tại!", HttpStatus.BAD_REQUEST);
			}
			
			nvRepository.deleteById(manv);
			tkRepository.deleteById(findNV.getTaikhoan().getUsername());
			return new ResponseEntity<String>("Xoá nhân viên thành công!", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Đã xảy ra lỗi, xoá nhân viên thất bại!", HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<NhanVien> updateNV(String manv, NhanVien nv) {
		try {
			NhanVien findNV = nvRepository.findByManv(manv);
			
			if(findNV  == null){
				return new ResponseEntity<NhanVien>(new NhanVien(), HttpStatus.BAD_REQUEST);
			}
			
			nv.setTaikhoan(findNV.getTaikhoan());
			
			nvRepository.save(nv);
			return new ResponseEntity<NhanVien>(nv, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<NhanVien>(new NhanVien(), HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<NhanVien> getDetailNVByUsername(String username) {
		try {
			NhanVien findNV = nvRepository.findByUsername(username);

			if(findNV == null){
				return new ResponseEntity<NhanVien>(new NhanVien(), HttpStatus.BAD_REQUEST);
			}
			

			return new ResponseEntity<NhanVien>(findNV, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<NhanVien>(new NhanVien(), HttpStatus.BAD_REQUEST);
		}
	}

}
