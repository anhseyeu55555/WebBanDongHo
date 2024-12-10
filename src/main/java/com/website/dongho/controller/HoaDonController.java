package com.website.dongho.controller;

import com.website.dongho.dto.HoaDonDto;
import com.website.dongho.entity.HoaDon;
import com.website.dongho.service.HoaDonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/hoadon")
@RequiredArgsConstructor
public class HoaDonController {
    private final HoaDonService hdService;

    @GetMapping
    public List<HoaDon> getAllHoaDon() {
        return hdService.getListService();
    }

    @PostMapping
    public ResponseEntity<String> addHoaDon(@Validated @RequestBody HoaDonDto hdModel) {
        return hdService.addHoaDon(hdModel);
    }

}
