package com.website.dongho.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
@Table(name = "phieu_nhap")
public class PhieuNhap {

    @Id
    private String mapn;

    private LocalDate ngaydat;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "madnh")
    private DonNhapHang donnhaphang;

    @ManyToOne
    @JoinColumn(name = "manv")
    private NhanVien nhanvien;
}
