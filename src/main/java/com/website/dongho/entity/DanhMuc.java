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

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "danh_muc")
public class DanhMuc {
    @Id
    String madm;
    String tendm;

    @JsonIgnore
    @OneToMany(mappedBy = "danhmuc")
    private Collection<SanPham> sanpham;
}
