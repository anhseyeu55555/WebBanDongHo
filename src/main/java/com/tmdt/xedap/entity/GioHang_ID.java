package com.tmdt.xedap.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GioHang_ID implements Serializable {
    private static final long serialVersionUID = 1L;
    private String makh;
    private String masp;
}
