package com.website.dongho.controller;

import com.website.dongho.entity.CT_PhieuNhap;
import com.website.dongho.service.CT_PhieuNhapService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/phieunhap/detail")
@RequiredArgsConstructor
public class CT_PhieuNhapController {
    private final CT_PhieuNhapService ctpnService;

    @GetMapping("/{mapn}")
    public List<CT_PhieuNhap> getDetailDH(@PathVariable("mapn") String mapn) {
        return ctpnService.getDetailByMaPn(mapn);
    }

}
