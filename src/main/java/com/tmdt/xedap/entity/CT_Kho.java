package com.tmdt.xedap.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "ct_kho")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CT_Kho {
    @EmbeddedId
    private CT_KhoKey maCtKho;

    private int soLuong;

    private Date ngayNhapKho;

    @ManyToOne
    @MapsId("masp")
    @JoinColumn(name = "masp")
    private SanPham sanPham;

    @ManyToOne
    @MapsId("maKho")
    @JoinColumn(name = "maKho")
    private Kho kho;
}
