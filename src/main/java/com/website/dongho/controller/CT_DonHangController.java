package com.website.dongho.controller;

import com.website.dongho.entity.CT_DonHang;
import com.website.dongho.service.CT_DonHangService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/donhang/detail")
@RequiredArgsConstructor
public class CT_DonHangController {
    private final CT_DonHangService ctdhService;

    @GetMapping("/{madh}")
    public List<CT_DonHang> getDetailDH(@PathVariable("madh") String madh) {
        return ctdhService.getDetailByMadh(madh);
    }
}
