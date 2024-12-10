package com.website.dongho.service.impl;

import com.website.dongho.dto.ForgotPasswordDto;
import com.website.dongho.dto.MailDto;
import com.website.dongho.entity.KhachHang;
import com.website.dongho.entity.NhanVien;
import com.website.dongho.entity.TaiKhoan;
import com.website.dongho.repository.KhachHangRepository;
import com.website.dongho.repository.NhanVienRepository;
import com.website.dongho.repository.TaiKhoanRepository;
import com.website.dongho.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {

    private final JavaMailSender mailSender;

    private final TaiKhoanRepository tkRespository;

    private final NhanVienRepository nvRepository;

    private final KhachHangRepository khRepository;

    @Value("${spring.mail.username}")
    private String fromMail;

    @Override
    public void sendMail(String mail, MailDto mailmodel) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(fromMail);
        simpleMailMessage.setSubject(mailmodel.getSubject());
        simpleMailMessage.setText(mailmodel.getMessage());
        simpleMailMessage.setTo(mail);

        mailSender.send(simpleMailMessage);

    }

    @Override
    public ResponseEntity<String> forgotPassword(ForgotPasswordDto forgotPasswordDto) {
        try {
            boolean isCheckTaiKhoan = false;
            if (forgotPasswordDto.getQuyen() == 1 || forgotPasswordDto.getQuyen() == 3) {
                NhanVien findNV = nvRepository.findByEmail(forgotPasswordDto.getEmail());
                if (findNV != null && forgotPasswordDto.getSdt().equals(findNV.getSdt())) {
                    isCheckTaiKhoan = findNV.getTaikhoan().getUsername().equals(forgotPasswordDto.getUsername());
                }
            }

            if (forgotPasswordDto.getQuyen() == 2) {
                KhachHang findKH = khRepository.findByEmail(forgotPasswordDto.getEmail());
                if (findKH == null) {
                    isCheckTaiKhoan = false;
                } else if (!findKH.getSdt().equals(forgotPasswordDto.getSdt())) {
                    isCheckTaiKhoan = false;
                } else isCheckTaiKhoan = findKH.getTaikhoan().getUsername().equals(forgotPasswordDto.getUsername());
            }

            if (!isCheckTaiKhoan) {
                return new ResponseEntity<String>("Thông tin cung cấp không tồn tại, vui lòng kiểm tra lại!", HttpStatus.BAD_GATEWAY);
            }

            TaiKhoan finTaiKhoan = tkRespository.findByUsername(forgotPasswordDto.getUsername());
            String passwordNew = "" + System.currentTimeMillis() % 10000000;
            finTaiKhoan.setPassword(passwordNew);
            tkRespository.save(finTaiKhoan);

            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom(fromMail);
            simpleMailMessage.setSubject("Lấy lại mật khẩu");
            simpleMailMessage.setText("Mật khẩu mới của bạn là " + passwordNew);
            simpleMailMessage.setTo(forgotPasswordDto.getEmail());

            mailSender.send(simpleMailMessage);

            return new ResponseEntity<String>("Lấy lại mật khẩu thành công!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("Đã xảy ra lỗi, gửi mail thất bại!", HttpStatus.BAD_REQUEST);
        }
    }
}
