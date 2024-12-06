package com.tmdt.xedap.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "chi_nhanh")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChiNhanh {
    @Id
    private String macn;

    private String tenCN;

    private String diaChi;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "manv", referencedColumnName = "manv")
    private NhanVien nhanVien;

    @JsonIgnore
    @OneToOne(mappedBy = "chiNhanh")
    private Kho kho;
}
