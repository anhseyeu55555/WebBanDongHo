package com.website.dongho.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class GioHang_ID implements Serializable {
    private static final long serialVersionUID = 1L;
    private String makh;
    private String masp;
}
