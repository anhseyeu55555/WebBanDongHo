package com.website.dongho.service.impl;

import com.website.dongho.entity.ThuongHieu;
import com.website.dongho.repository.ThuongHieuRepository;
import com.website.dongho.service.ThuongHieuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ThuongHieuServiceImpl implements ThuongHieuService {
    private final ThuongHieuRepository thRepository;

    @Override
    public List<ThuongHieu> getListService() {
        return thRepository.findAll();
    }

    @Override
    public ResponseEntity<ThuongHieu> getDetailThuongHieu(String math) {
        try {
            ThuongHieu th = thRepository.findByMath(math);
            if (th == null) {
                return new ResponseEntity<ThuongHieu>(new ThuongHieu(), HttpStatus.BAD_REQUEST);
            }

            return new ResponseEntity<ThuongHieu>(th, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<ThuongHieu>(new ThuongHieu(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<String> addThuongHieu(ThuongHieu thuonghieu) {
        try {
            ThuongHieu findTH = thRepository.findByMath(thuonghieu.getMath());
            if (findTH != null) {
                return new ResponseEntity<String>("Mã thương hiệu đã tồn tại!", HttpStatus.BAD_REQUEST);
            }

            thRepository.save(thuonghieu);
            return new ResponseEntity<String>("Thêm thương hiệu thành công!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("Đã xảy ra lỗi, thêm thương hiệu thất bại!", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<String> deleteThuongHieu(String math) {
        try {
            ThuongHieu findTH = thRepository.findByMath(math);
            if (findTH == null) {
                return new ResponseEntity<String>("Mã thương hiệu không tồn tại!", HttpStatus.BAD_REQUEST);
            }

            thRepository.deleteById(math);
            return new ResponseEntity<String>("Xoá thương hiệu thành công!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("Đã xảy ra lỗi, xoá thương hiệu thất bại!", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<ThuongHieu> updateThuongHieu(String math, ThuongHieu thuonghieu) {
        try {
            ThuongHieu findTH = thRepository.findByMath(math);
            if (findTH == null) {
                return new ResponseEntity<ThuongHieu>(new ThuongHieu(), HttpStatus.BAD_REQUEST);
            }

            thRepository.save(thuonghieu);
            return new ResponseEntity<ThuongHieu>(thuonghieu, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<ThuongHieu>(new ThuongHieu(), HttpStatus.BAD_REQUEST);
        }
    }
}
