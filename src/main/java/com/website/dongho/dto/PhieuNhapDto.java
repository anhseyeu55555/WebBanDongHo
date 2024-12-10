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
public class PhieuNhapDto {
    private String mapn;
    private String manv;
    private String maddh;
    private List<CT_DonNhaphangDto> ds;
}
