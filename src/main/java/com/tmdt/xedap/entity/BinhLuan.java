package com.tmdt.xedap.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Entity
@Table(name = "binh_luan")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BinhLuan {

    @Id
    private String maBl;
    private String noiDung;

    @JoinColumn(name = "ngaybinhluan")
    private Date ngayBinhLuan;

    @ManyToOne
    @JoinColumn(name = "makh")
    private KhachHang khachHang;

    @ManyToOne
    @JoinColumn(name = "masp")
    private SanPham sanPham;

}
