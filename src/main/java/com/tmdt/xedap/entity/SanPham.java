package com.tmdt.xedap.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
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
import java.util.Set;

@Entity
@Table(name = "san_pham")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SanPham {

    @Id
    private String maSp;

    private String tenSp;
    private String slug;
    private float donGia;

    @Column(name = "mo_ta")
    private String chiTietSp;

    @Column(name = "hinh_anh")
    private List<String> image;

    private int trangThai;

    @ManyToOne
    @JoinColumn(name = "math")
    private ThuongHieu thuongHieu;

    @ManyToOne
    @JoinColumn(name = "madm")
    private DanhMuc danhMuc;

    @ManyToOne
    @JoinColumn(name = "mancc")
    private NhaCungCap nhaCungCap;

    @JsonIgnore
    @OneToMany(mappedBy = "sanpham")
    private List<GioHang> gioHangs;

    @JsonIgnore
    @OneToMany(mappedBy = "sanpham")
    private List<CT_DonNhapHang> donNhapHangs;

    @JsonIgnore
    @OneToMany(mappedBy = "sanPham")
    private List<BinhLuan> binhLuan;

    @JsonIgnore
    @OneToMany(mappedBy = "sanPham")
    Set<CT_Kho> ctKho;
}
