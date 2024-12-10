package com.website.dongho.controller;

import com.website.dongho.dto.NhanVienDangKy;
import com.website.dongho.entity.NhanVien;
import com.website.dongho.service.NhanVienService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/nhanvien")
@RequiredArgsConstructor
public class NhanVienController {
    private final NhanVienService nvService;

    @GetMapping
    public List<NhanVien> getAllNV() {
        return nvService.getListService();
    }

    @GetMapping("/{manv}")
    public ResponseEntity<NhanVien> getDetailNV(@PathVariable("manv") String manv) {
        ResponseEntity<NhanVien> nvDetail = nvService.getDetailNV(manv);
        return nvDetail;
    }

    @GetMapping("/profile/{username}")
    public ResponseEntity<NhanVien> getDetailNVByUsername(@PathVariable("username") String username) {
        ResponseEntity<NhanVien> nvDetail = nvService.getDetailNVByUsername(username);
        return nvDetail;
    }

    @PostMapping
    public ResponseEntity<String> addNV(@Validated @RequestBody NhanVienDangKy nvdk) {

        return nvService.addNV(nvdk);
    }

    @DeleteMapping("/{manv}")
    public ResponseEntity<String> deleteNhanVien(@PathVariable("manv") String manv) {
        return nvService.deleteNV(manv);
    }

    @PutMapping("/{manv}")
    public ResponseEntity<NhanVien> updateNhanVien(@PathVariable("manv") String manv, @Validated @RequestBody NhanVien nhanvien) {
        return nvService.updateNV(manv, nhanvien);
    }
}
