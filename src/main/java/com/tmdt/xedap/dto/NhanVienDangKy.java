package com.tmdt.xedap.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NhanVienDangKy {
    String username;
    String password;
    String hoten;
    String gioitinh;
    String sdt;
    String email;
    String diachi;
    float luong;
}
