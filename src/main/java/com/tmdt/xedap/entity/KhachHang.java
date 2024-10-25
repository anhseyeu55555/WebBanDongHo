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

@Entity
@Table(name = "khach_hang")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KhachHang {

    @Id
    private String makh;

    @Column(name = "hoten")
    private String hoTen;
    @Column(name = "gioitinh")
    private String gioiTinh;
    private String sdt;
    private String diaChi;
    private String email;

    @ManyToOne
    @JoinColumn(name = "username")
    private TaiKhoan taikhoan;

    @JsonIgnore
    @OneToMany(mappedBy = "khachhang")
    private List<DonHang> listDH;

    @JsonIgnore
    @OneToMany(mappedBy = "khachHang")
    private List<BinhLuan> listBL;
}
