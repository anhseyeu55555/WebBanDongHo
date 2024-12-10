package com.website.dongho.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DonNhapHangDto {
	private String madnh;
	private String mancc;
	private String manv;
	private List<CT_DonNhaphangDto> ds;
}
