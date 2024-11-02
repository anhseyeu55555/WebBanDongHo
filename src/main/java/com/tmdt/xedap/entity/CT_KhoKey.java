package com.tmdt.xedap.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@EqualsAndHashCode
@Embeddable
@Getter
@Setter
public class CT_KhoKey implements Serializable {
    @Column(name = "masp")
    private String masp;

    @Column(name = "maKho")
    private String maKho;
}
