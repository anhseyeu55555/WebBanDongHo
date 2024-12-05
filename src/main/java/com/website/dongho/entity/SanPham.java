package com.website.dongho.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "san_pham")
public class SanPham {
    @Id
    private String masp;

    private String tensp;
    private String slug;
    private int soluong;
    private float dongia;
    private String chitietSP;
    private String image;
    private String image2;
    private String image3;
    private int trangthai;

    @ManyToOne
    @JoinColumn(name = "math")
    private ThuongHieu thuonghieu;

    @ManyToOne
    @JoinColumn(name = "madm")
    private DanhMuc danhmuc;

    @ManyToOne
    @JoinColumn(name = "mancc")
    private NhaCungCap nhacungcap;

    @JsonIgnore
    @OneToMany(mappedBy = "sanpham")
    private List<GioHang> listGioHang;

    @JsonIgnore
    @OneToMany(mappedBy = "sanpham")
    private List<CT_DonNhapHang> listCTDDH;

    @JsonIgnore
    @OneToMany(mappedBy = "sanpham")
    private List<BinhLuan> binhluan;
}
