package com.tmdt.xedap.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "nhan_vien")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NhanVien {
    @Id
    String manv;

    @Column(name = "tennv")
    String hoten;

    String gioitinh;
    String sdt;

    @Column(name = "dia_chi_vat_li")
    String diachi;

    @Column(name = "dia_chi_email")
    String email;

    float luong;

    @JsonIgnore
    @OneToMany(mappedBy = "nhanvien")
    List<DonHang> listDH;
    @JsonIgnore
    @OneToMany(mappedBy = "giaohang")
    List<DonHang> listDHGH;

    @ManyToOne
    @JoinColumn(name = "ten_tai_khoan")
    private TaiKhoan taikhoan;

    @JsonIgnore
    @OneToMany(mappedBy = "nhanvien")
    private List<DonNhapHang> dondathang;

    @JsonIgnore
    @OneToOne(mappedBy = "nhanVien")
    private ChiNhanh chiNhanh;
}
