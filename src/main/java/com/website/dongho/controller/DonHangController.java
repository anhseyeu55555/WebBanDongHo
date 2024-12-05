package com.website.dongho.controller;

import com.website.dongho.dto.DonHangModel;
import com.website.dongho.dto.UpdateDonHangDto;
import com.website.dongho.entity.DonHang;
import com.website.dongho.service.DonHangService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@RequestMapping("/donhang")
@RequiredArgsConstructor
public class DonHangController {
    private final DonHangService dhService;

    @GetMapping("/user/{makh}")
    public List<DonHang> getDHByKH(@PathVariable("makh") String makh) {
        return dhService.getListDonHangByKH(makh);
    }

    @GetMapping("/user/{makh}/{trangthai}")
    public List<DonHang> getDHByKHAndTT(@PathVariable("makh") String makh, @PathVariable("trangthai") int trangthai) {
        return dhService.getListDonHangByTT(makh, trangthai);
    }

    @PostMapping("/user")
    public ResponseEntity<String> addDonHangByKH(@Validated @RequestBody DonHangModel dhModel) {
        return dhService.addDonHang(dhModel);
    }

    @PutMapping("/user")
    public ResponseEntity<String> updateDonHangByNV(@Validated @RequestBody UpdateDonHangDto updateDHModel) {
        return dhService.updateDonHang(updateDHModel);
    }

    @GetMapping("/thongke")
    public double[] getThongKeByYear() {
        return dhService.getThongKeByYear();
    }
}
