package com.website.dongho.service.impl;

import com.website.dongho.dto.CT_DonNhaphangDto;
import com.website.dongho.dto.PhieuNhapDto;
import com.website.dongho.entity.CT_PhieuNhap;
import com.website.dongho.entity.CT_PhieuNhap_ID;
import com.website.dongho.entity.DonNhapHang;
import com.website.dongho.entity.NhanVien;
import com.website.dongho.entity.PhieuNhap;
import com.website.dongho.entity.SanPham;
import com.website.dongho.repository.CT_PhieuNhapRepository;
import com.website.dongho.repository.DonNhapHangRepository;
import com.website.dongho.repository.NhanVienRepository;
import com.website.dongho.repository.PhieuNhapRepository;
import com.website.dongho.service.PhieuNhapService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PhieuNhapServiceImpl implements PhieuNhapService {

    private final PhieuNhapRepository pnRepository;

    private final NhanVienRepository nvRepository;

    private final DonNhapHangRepository donNhapHangRepository;

    private final CT_PhieuNhapRepository ct_pnRepository;

    @Override
    public List<PhieuNhap> getListService() {
        return pnRepository.findAll(Sort.by(Sort.Order.desc("ngaydat")));
    }

    @Override
    public ResponseEntity<String> addPhieuNhap(PhieuNhapDto pnModel) {
        try {
            DonNhapHang findDDH = donNhapHangRepository.findByMadnh(pnModel.getMaddh());
            if (findDDH == null) {
                return new ResponseEntity<String>("Mã đơn đặt hàng không tồn tại!", HttpStatus.BAD_REQUEST);
            }

            NhanVien findNV = nvRepository.findByManv(pnModel.getManv());
            if (findNV == null) {
                return new ResponseEntity<String>("Mã nhân viên không tồn tại!", HttpStatus.BAD_REQUEST);
            }

            PhieuNhap findPN = pnRepository.findByMapn(pnModel.getMapn());
            if (findPN != null) {
                return new ResponseEntity<String>("Mã phiếu nhập đã tồn tại", HttpStatus.BAD_REQUEST);
            }

            PhieuNhap pn = new PhieuNhap();
            String maPN = "PN" + System.currentTimeMillis() % 10000000;
            pn.setMapn(maPN);
            pn.setDonnhaphang(findDDH);
            pn.setNhanvien(findNV);
            pn.setNgaydat(LocalDate.now());

            pnRepository.save(pn);

            try {
                List<CT_DonNhaphangDto> listDS = pnModel.getDs();
                for (CT_DonNhaphangDto ds : listDS) {
                    CT_PhieuNhap ct_pn = new CT_PhieuNhap();
                    CT_PhieuNhap_ID ct_pn_id = new CT_PhieuNhap_ID(pnModel.getMaddh(), ds.getMasp());

                    ct_pn.setId(ct_pn_id);
                    ct_pn.setPhieunhap(pn);

                    SanPham sp = new SanPham();
                    sp.setMasp(ds.getMasp());

                    ct_pn.setSanpham(sp);
                    ct_pn.setGia(ds.getGia());
                    ct_pn.setSoluong(ds.getSoluong());

                    ct_pnRepository.save(ct_pn);
                }
            } catch (Exception e) {
                System.out.println(e);
                return new ResponseEntity<String>("Đã xảy ra lỗi, thêm chi tiết phiếu nhập thất bài!", HttpStatus.OK);
            }

            return new ResponseEntity<String>("Thêm phiếu nhập thành công!", HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<String>("Đã xảy ra lỗi, thêm phiếu nhập thất bại!", HttpStatus.BAD_REQUEST);
        }
    }
}
