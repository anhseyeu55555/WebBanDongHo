package com.tmdt.xedap.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name = "tai_khoan")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaiKhoan {
    @Id
    @Column(name = "ten_tai_khoan")
    private String username;

    @JsonIgnore
    @OneToMany(mappedBy = "taikhoan")
    List<NhanVien> listNV;

    @JsonIgnore
    @Column(name = "mat_khau")
    private String password;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ma_quyen")
    private Quyen quyen;

    @JsonIgnore
    @OneToMany(mappedBy = "taikhoan")
    private List<KhachHang> listKH;
}
