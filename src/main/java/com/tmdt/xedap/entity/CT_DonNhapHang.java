package com.tmdt.xedap.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

import java.io.Serializable;

@Entity
@Table(name = "ct_don_nhap_hang")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CT_DonNhapHang implements Serializable {

    private static final long serialVersionUID = 1L;
    @JsonIgnore
    @ManyToOne
    @MapsId("maddh")
    @JoinColumn(name = "maddh")
    DonDatHang dondathang;

    @ManyToOne
    @MapsId("masp")
    @JoinColumn(name = "masp")
    SanPham sanpham;

    @EmbeddedId
    private CT_DonDatHang_ID id;
    private int soluong;
    private float gia;
}
