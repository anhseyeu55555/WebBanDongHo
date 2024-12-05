package com.website.dongho.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DonHangModel {
    private int hinhThucThanhToan;
    private String hoTen;
    private String diaChi;
    private String sdt;
    private String email;
    private String ghichu;
    private String makh;

    private List<SanPhamNhapHangDto> dsSanPham;
}
