package com.website.dongho.service.impl;

import com.website.dongho.dto.HoaDonDto;
import com.website.dongho.entity.DonHang;
import com.website.dongho.entity.HoaDon;
import com.website.dongho.repository.DonHangRepository;
import com.website.dongho.repository.HoaDonRepository;
import com.website.dongho.service.HoaDonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HoaDonServiceImpl implements HoaDonService {
    private final HoaDonRepository hdRepository;

    private final DonHangRepository dhRepository;

    @Override
    public List<HoaDon> getListService() {
        return hdRepository.findAll();
    }

    @Override
    public ResponseEntity<String> addHoaDon(HoaDonDto hdModel) {
        try {
            DonHang findDH = dhRepository.getDetailDH(hdModel.getMadh());
            if (findDH == null) {
                return new ResponseEntity<String>("Mãd đơn hàng không tồn tại!", HttpStatus.BAD_REQUEST);
            }

            HoaDon hd = new HoaDon();
            String maHD = "HD" + System.currentTimeMillis() % 10000000;
            hd.setDonhang(findDH);
            hd.setMahd(maHD);
            hd.setNgaylap(LocalDate.now());
            hd.setThanhtien(hdModel.getThanhtien());
            hdRepository.save(hd);

            return new ResponseEntity<String>("Thêm hoá đơn thành công!", HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<String>("Đã xảy ra lỗi, thêm hoá đơn thất bại!", HttpStatus.BAD_REQUEST);
        }
    }
}
