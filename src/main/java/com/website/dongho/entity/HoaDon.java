package com.website.dongho.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
@Table(name = "hoa_don")
public class HoaDon {

    @Id
    private String mahd;

    private LocalDate ngaylap;

    private float thanhtien;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "madh")
    private DonHang donhang;
}
