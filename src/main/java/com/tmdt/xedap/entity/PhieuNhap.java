package com.tmdt.xedap.entity;

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
@Table(name = "phieu_nhap")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PhieuNhap {

    @Id
    private String mapn;
    private LocalDate ngaydat;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "maddh")
    private DonNhapHang dondathang;

    @ManyToOne
    @JoinColumn(name = "manv")
    private NhanVien nhanvien;
}
