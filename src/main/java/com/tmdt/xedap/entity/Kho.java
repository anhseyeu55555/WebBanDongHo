package com.tmdt.xedap.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "kho")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Kho {
    @Id
    private String maKho;

    @JoinColumn(name = "ten_kho")
    private String tenKho;

    @JoinColumn(name = "dia_chi_kho")
    private String diaChi;

    @OneToOne
    @JoinColumn(name = "macn", referencedColumnName = "macn")
    private ChiNhanh chiNhanh;

    @JsonIgnore
    @OneToMany(mappedBy = "kho")
    Set<CT_Kho> ctKho;

}
