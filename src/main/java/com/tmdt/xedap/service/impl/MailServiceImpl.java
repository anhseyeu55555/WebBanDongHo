package com.tmdt.xedap.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.tmdt.xedap.entity.KhachHang;
import com.tmdt.xedap.entity.NhanVien;
import com.tmdt.xedap.entity.TaiKhoan;
import com.tmdt.xedap.dto.ForgotPasswordModel;
import com.tmdt.xedap.dto.MailModel;
import com.tmdt.xedap.repository.KhachHangRepository;
import com.tmdt.xedap.repository.NhanVienRepository;
import com.tmdt.xedap.repository.TaiKhoanRepository;
import com.tmdt.xedap.service.MailService;

@Service
public class MailServiceImpl implements MailService {

	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private TaiKhoanRepository tkRespository;
	
	@Autowired
	private NhanVienRepository nvRepository;
	
	@Autowired
	private KhachHangRepository khRepository;
	
	
	@Value("${spring.mail.username}")
	private String fromMail;
	
	@Override
	public void sendMail(String mail, MailModel mailmodel) {
		// TODO Auto-generated method stub
		
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		
		simpleMailMessage.setFrom(fromMail);
		simpleMailMessage.setSubject(mailmodel.getSubject());
		simpleMailMessage.setText(mailmodel.getMessage());
		simpleMailMessage.setTo(mail);
		
		mailSender.send(simpleMailMessage);
		
	}

	@Override
	public ResponseEntity<String> forgotPassword(ForgotPasswordModel forgotPasswordModel) {
		// TODO Auto-generated method stub
		try {
			Boolean isCheckTaiKhoan = false;
			
			if(forgotPasswordModel.getQuyen() == 1 || forgotPasswordModel.getQuyen() == 3) {
				NhanVien findNV = nvRepository.findByEmail(forgotPasswordModel.getEmail());
				
				if(findNV == null) {
					isCheckTaiKhoan = false;
				} else if(!findNV.getSdt().equals(forgotPasswordModel.getSdt())){
					isCheckTaiKhoan = false;
				} else if(!findNV.getTaikhoan().getUsername().equals(forgotPasswordModel.getUsername())){
					isCheckTaiKhoan = false;
				} else {
					isCheckTaiKhoan = true;
				}
			}
			
			if(forgotPasswordModel.getQuyen() == 2) {
				KhachHang findKH = khRepository.findByEmail(forgotPasswordModel.getEmail());
				
				if(findKH == null) {
					isCheckTaiKhoan = false;
				} else if(!findKH.getSdt().equals(forgotPasswordModel.getSdt())){
					isCheckTaiKhoan = false;
				} else if(!findKH.getTaikhoan().getUsername().equals(forgotPasswordModel.getUsername())){
					isCheckTaiKhoan = false;
				} else {
					isCheckTaiKhoan = true;
				}
			}
			
			if(!isCheckTaiKhoan) {
				return new ResponseEntity<String>("Thông tin cung cấp không tồn tại, vui lòng kiểm tra lại!", HttpStatus.BAD_GATEWAY);
			}
			
			SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
			
			String passwordNew = "" + System.currentTimeMillis() % 10000000;
			
			TaiKhoan finTaiKhoan = tkRespository.findByUsername(forgotPasswordModel.getUsername());
			
			finTaiKhoan.setPassword(passwordNew);
			
			tkRespository.save(finTaiKhoan);
			
			simpleMailMessage.setFrom(fromMail);
			simpleMailMessage.setSubject("Lấy lại mật khẩu");
			simpleMailMessage.setText("Mật khẩu mới của bạn là " + passwordNew);
			simpleMailMessage.setTo(forgotPasswordModel.getEmail());
			
			mailSender.send(simpleMailMessage);
			
		
			
			return new ResponseEntity<String>("Lấy lại mật khẩu thành công!", HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<String>("Đã xảy ra lỗi, gửi mail thất bại!", HttpStatus.BAD_REQUEST);
		}
		
	}

	
}
