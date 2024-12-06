package com.tmdt.xedap.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PhieuNhapModel {

    private String mapn;
    private String manv;
    private String maddh;
    private List<CT_DonDatHangModel> ds;
}
