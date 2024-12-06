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

@Entity
@Table(name = "gio_hang")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GioHang {

    @EmbeddedId
    private GioHang_ID id;

    private int soluong;

    @ManyToOne
    @MapsId("makh")
    @JoinColumn(name = "makh")
    private KhachHang khachhang;

    @ManyToOne
    @MapsId("masp")
    @JoinColumn(name = "masp")
    private SanPham sanpham;
}
