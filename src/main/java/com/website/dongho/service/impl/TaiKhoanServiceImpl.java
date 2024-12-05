package com.website.dongho.service.impl;

import com.website.dongho.dto.Login;
import com.website.dongho.dto.LoginRes;
import com.website.dongho.entity.TaiKhoan;
import com.website.dongho.repository.TaiKhoanRepository;
import com.website.dongho.service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TaiKhoanServiceImpl implements TaiKhoanService{

	@Autowired
	private TaiKhoanRepository tkRespository;
	
	@Override
	public ResponseEntity<LoginRes> login(Login dataLogin) {
		try {
			TaiKhoan findTaiKhoan = tkRespository.findByUsername(dataLogin.getUsername());
			
		
		
			if(!findTaiKhoan.getPassword().equals(dataLogin.getPassword())) {
				return new ResponseEntity<LoginRes>(new LoginRes(), HttpStatus.BAD_REQUEST);
			}
			
			LoginRes res = new LoginRes();
			
			res.setUsername(findTaiKhoan.getUsername());
			res.setQuyen(findTaiKhoan.getQuyen().getMaquyen());
			
			
			
			return new ResponseEntity<LoginRes>(res, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<LoginRes>(new LoginRes(), HttpStatus.BAD_REQUEST);
		}
	
	}

	@Override
	public ResponseEntity<String> changePassword(Login dataLogin) {
		try {
			TaiKhoan findTaiKhoan = tkRespository.findByUsername(dataLogin.getUsername());
			
		

			if(findTaiKhoan == null) {
				return new ResponseEntity<String>("Tài khoản không tồn tại!", HttpStatus.BAD_REQUEST);
			}
	
			TaiKhoan tk = new TaiKhoan();
			
			tk.setPassword(dataLogin.getPassword());
			tk.setUsername(findTaiKhoan.getUsername());
			tk.setQuyen(findTaiKhoan.getQuyen());
			
			
			tkRespository.save(tk);
			
			
			
			return new ResponseEntity<String>("Đổi mật khẩu thành công!", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Đổi mật khẩu thất bại, vui lòng kiểm tra lại!", HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<LoginRes> getDetailTaiKhoan(String username) {
		try {
			TaiKhoan findTaiKhoan = tkRespository.findByUsername(username);
			
		
		
			if(findTaiKhoan == null) {
				return new ResponseEntity<LoginRes>(new LoginRes(), HttpStatus.BAD_REQUEST);
			}
			
			LoginRes res = new LoginRes();
			
			res.setUsername(findTaiKhoan.getUsername());
			res.setQuyen(findTaiKhoan.getQuyen().getMaquyen());
			
			
			
			return new ResponseEntity<LoginRes>(res, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<LoginRes>(new LoginRes(), HttpStatus.BAD_REQUEST);
		}
	}

}
