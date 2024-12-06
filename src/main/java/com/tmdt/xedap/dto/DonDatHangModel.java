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
public class DonDatHangModel {


    private String maddh;
    private String mancc;
    private String manv;
    private List<CT_DonDatHangModel> ds;
}
