package com.tmdt.xedap.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tmdt.xedap.entity.TaiKhoan;
import com.tmdt.xedap.model.Login;
import com.tmdt.xedap.model.LoginRes;
import com.tmdt.xedap.repository.TaiKhoanRepository;
import com.tmdt.xedap.service.TaiKhoanService;

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

}
