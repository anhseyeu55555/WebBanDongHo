package com.website.dongho.service;

import com.website.dongho.dto.ForgotPasswordDto;
import com.website.dongho.dto.MailDto;
import org.springframework.http.ResponseEntity;

public interface MailService {
    void sendMail(String mail, MailDto mailmodel);

    ResponseEntity<String> forgotPassword(ForgotPasswordDto forgotPasswordDto);
}
