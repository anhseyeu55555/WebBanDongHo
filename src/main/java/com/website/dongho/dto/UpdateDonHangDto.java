package com.website.dongho.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateDonHangDto {

    private String madh;
    private String manv;
    private String manvgh;
    private int trangthai;
    private int hinhThucThanhToan;
}
