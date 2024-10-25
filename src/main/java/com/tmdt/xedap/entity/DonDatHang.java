package com.tmdt.xedap.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
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
@Table(name = "don_nhap_hang")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DonDatHang {
    @Id
    @Column(name = "maddh", unique = true, nullable = false)
    private String mddh;

    @Column(name = "ngaydat", nullable = false)
    private LocalDate ngaydat;

    @ManyToOne(optional = false)
    @JoinColumn(name = "mancc", nullable = false)
    private NhaCungCap nhacungcap;

    @ManyToOne(optional = false)
    @JoinColumn(name = "manv", nullable = false)
    private NhanVien nhanvien;

    @JsonIgnore
    @OneToOne(mappedBy = "dondathang", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private PhieuNhap phieunhap;
}
