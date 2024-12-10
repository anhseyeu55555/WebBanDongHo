package com.website.dongho.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "nha_cung_cap")
public class NhaCungCap {

    @Id
    String mancc;

    String tenncc;
    String sdt;
    String email;
    String diachi;

    @JsonIgnore
    @OneToMany(mappedBy = "nhacungcap")
    private Collection<SanPham> sanpham;

    @JsonIgnore
    @OneToMany(mappedBy = "nhacungcap")
    private Set<DonNhapHang> dondathang;
}
