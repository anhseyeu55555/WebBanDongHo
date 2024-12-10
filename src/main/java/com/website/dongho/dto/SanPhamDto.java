package com.website.dongho.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SanPhamDto {
    private String masp;
    private String tensp;
    private String slug;
    private int soluong;
    private float dongia;
    private String chitietSP;
    private String image;
    private String image2;
    private String image3;
    private int trangthai;
    private String madm;
    private String math;
    private String mancc;
}
