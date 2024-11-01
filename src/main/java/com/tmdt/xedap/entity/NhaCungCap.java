package com.tmdt.xedap.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "nha_cung_cap")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NhaCungCap {

    @Id
    String mancc;
    String tenncc;
    String sdt;

    @JoinColumn(name = "dia_chi_email")
    String email;

    @JoinColumn(name = "dia_chi_vat_li")
    String diachi;

    @JsonIgnore
    @OneToMany(mappedBy = "nhaCungCap")
    private Collection<SanPham> sanpham;

    @JsonIgnore
    @OneToMany(mappedBy = "nhacungcap")
    private Set<DonNhapHang> dondathang;
}
