package com.website.dongho.controller;

import com.website.dongho.entity.NhaCungCap;
import com.website.dongho.service.NhaCungCapService;
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
@RequiredArgsConstructor
@RequestMapping("/nhacungcap")
public class NhaCungCapController {
    private final NhaCungCapService nccService;

    @GetMapping
    public List<NhaCungCap> getAllNhaCungCap() {

        return nccService.getListService();
    }

    @GetMapping("/{mancc}")
    public ResponseEntity<NhaCungCap> getDetailNhaCungCap(@PathVariable("mancc") String mancc) {
        ResponseEntity<NhaCungCap> nccDetail = nccService.getDetailNCC(mancc);
        return nccDetail;
    }

    @PostMapping
    public ResponseEntity<String> addNhaCungCap(@Validated @RequestBody NhaCungCap nhacungcap) {

        return nccService.addNCC(nhacungcap);
    }

    @DeleteMapping("/{mancc}")
    public ResponseEntity<String> deleteNhaCungCap(@PathVariable("mancc") String mancc) {
        return nccService.deleteNCC(mancc);
    }

    @PutMapping("/{mancc}")
    public ResponseEntity<NhaCungCap> updateNhaCungCap(@PathVariable("mancc") String mancc, @Validated @RequestBody NhaCungCap nhacungcap) {
        return nccService.updateNCC(mancc, nhacungcap);
    }
}
