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
@Table(name = "ct_phieu_nhap")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CT_PhieuNhap implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private CT_PhieuNhap_ID id;

    private int soluong;

    private float gia;


    @ManyToOne
    @MapsId("masp")
    @JoinColumn(name = "masp")
    private SanPham sanpham;


    @JsonIgnore
    @ManyToOne
    @MapsId("mapn")
    @JoinColumn(name = "mapn")
    private PhieuNhap phieunhap;

}
