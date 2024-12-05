package com.website.dongho.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "don_hang")
public class DonHang {

    @Id
    private String madh;

    private int hinhThucThanhToan;
    private LocalDate ngayDat;
    private float tongTien;
    private int trangThai;
    private String hoTen;
    private String diaChi;
    private String sdt;
    private String email;
    private String ghichu;

    @ManyToOne
    @JoinColumn(name = "manv")
    private NhanVien nhanvien;

    @ManyToOne
    @JoinColumn(name = "manvgh")
    private NhanVien giaohang;


    @ManyToOne
    @JoinColumn(name = "makh")
    private KhachHang khachhang;

    @JsonIgnore
    @OneToOne(mappedBy = "donhang", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private HoaDon hoadon;
}
