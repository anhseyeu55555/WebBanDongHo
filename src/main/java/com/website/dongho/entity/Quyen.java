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

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "quyen")
public class Quyen {

    @Id
    private int maquyen;
    private String tenquyen;

    @JsonIgnore
    @OneToMany(mappedBy = "quyen")
    private List<TaiKhoan> ListTk;

    public Quyen(int maquyen) {
        super();
        this.maquyen = maquyen;
    }
}
