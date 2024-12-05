package com.website.dongho.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tai_khoan")
public class TaiKhoan {
    @Id
    private String username;

    @JsonIgnore
    private String password;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maquyen")
    private Quyen quyen;

    @JsonIgnore
    @OneToMany(mappedBy = "taikhoan")
    private List<KhachHang> listKH;

    @JsonIgnore
    @OneToMany(mappedBy = "taikhoan")
    List<NhanVien> listNV;


}
