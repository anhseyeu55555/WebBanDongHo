package com.website.dongho.entity;

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
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ct_don_hang")
public class CT_DonHang implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private CT_DonHang_ID id;

    private int soluong;
    private float gia;

    @JsonIgnore
    @ManyToOne
    @MapsId("madh")
    @JoinColumn(name = "madh")
    private DonHang donhang;

    @ManyToOne
    @MapsId("masp")
    @JoinColumn(name = "masp")
    private SanPham sanpham;
}
