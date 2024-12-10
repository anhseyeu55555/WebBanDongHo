package com.website.dongho.controller;

import com.website.dongho.dto.ForgotPasswordDto;
import com.website.dongho.dto.MailDto;
import com.website.dongho.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/mail")
@RequiredArgsConstructor
public class MailController {
    private final MailService mailService;

    @PostMapping("/send/{mail}")
    public String sendMail(@PathVariable("mail") String mail, @RequestBody MailDto mailmodel) {
        mailService.sendMail(mail, mailmodel);
        return "Gửi mail thành công!";
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<String> sendMail(@RequestBody ForgotPasswordDto forgotPasswordDto) {
        return mailService.forgotPassword(forgotPasswordDto);
    }
}
