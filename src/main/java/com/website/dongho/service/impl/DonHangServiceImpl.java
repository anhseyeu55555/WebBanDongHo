package com.website.dongho.service.impl;

import com.website.dongho.dto.DonHangModel;
import com.website.dongho.dto.DonThuThangDto;
import com.website.dongho.dto.SanPhamNhapHangDto;
import com.website.dongho.dto.UpdateDonHangDto;
import com.website.dongho.entity.CT_DonHang;
import com.website.dongho.entity.CT_DonHang_ID;
import com.website.dongho.entity.DonHang;
import com.website.dongho.entity.HoaDon;
import com.website.dongho.entity.KhachHang;
import com.website.dongho.entity.NhanVien;
import com.website.dongho.entity.SanPham;
import com.website.dongho.repository.CT_DonHangRepository;
import com.website.dongho.repository.DonHangRepository;
import com.website.dongho.repository.GioHangRepository;
import com.website.dongho.repository.HoaDonRepository;
import com.website.dongho.repository.KhachHangRepository;
import com.website.dongho.repository.NhanVienRepository;
import com.website.dongho.repository.SanPhamRepository;
import com.website.dongho.service.DonHangService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DonHangServiceImpl implements DonHangService {
    private final DonHangRepository dhRepository;

    private final CT_DonHangRepository ctdhRepository;

    private final KhachHangRepository khRepository;

    private final NhanVienRepository nvRepository;

    private final GioHangRepository ghRepository;

    private final SanPhamRepository spRepository;

    private final HoaDonRepository hdRepository;

    @Override
    public List<DonHang> getListDonHangByKH(String makh) {
        return dhRepository.listDonHangByMaKH(makh);
    }

    @Override
    public List<DonHang> getListDonHangByNV(String manv) {
        return dhRepository.listDonHangByMaNV(manv);
    }

    @Override
    public List<DonHang> getListDonHangByTT(String makh, int trangthai) {
        return dhRepository.listDHByTrangThai(makh, trangthai);
    }

    @Override
    public ResponseEntity<String> addDonHang(DonHangModel dhModel) {
        try {
            KhachHang findKH = khRepository.findByMakh(dhModel.getMakh());

            if (findKH == null) {
                return new ResponseEntity<String>("Mã khách hàng không tồn tại!", HttpStatus.BAD_REQUEST);
            }

            DonHang dh = new DonHang();
            String maDH = "DH" + System.currentTimeMillis() % 10000000;
            dh.setMadh(maDH);
            dh.setHinhThucThanhToan(dhModel.getHinhThucThanhToan());
            dh.setNgayDat(LocalDate.now());
            dh.setTrangThai(0);
            dh.setKhachhang(findKH);
            dh.setHoTen(dhModel.getHoTen());
            dh.setDiaChi(dhModel.getDiaChi());
            dh.setSdt(dhModel.getSdt());
            dh.setEmail(dhModel.getEmail());
            dh.setGhichu(dhModel.getGhichu());

            List<SanPhamNhapHangDto> dsSanPham = dhModel.getDsSanPham();
            float tongTien = 0;
            for (SanPhamNhapHangDto item : dsSanPham) {
                tongTien += (item.getDongia() * item.getSoluong());
            }
            dh.setTongTien(tongTien);
            dhRepository.save(dh);

            HoaDon hd = new HoaDon();
            String mahd = "HD" + System.currentTimeMillis() % 10000000;
            hd.setDonhang(dh);
            hd.setMahd(mahd);
            hd.setNgaylap(LocalDate.now());
            hd.setThanhtien(tongTien);
            hdRepository.save(hd);

            try {
                List<SanPhamNhapHangDto> listDS = dhModel.getDsSanPham();
                for (SanPhamNhapHangDto item : listDS) {
                    CT_DonHang ctdh = new CT_DonHang();
                    CT_DonHang_ID ctdh_id = new CT_DonHang_ID(maDH, item.getMasp());
                    ctdh.setId(ctdh_id);
                    ctdh.setDonhang(dh);
                    ctdh.setSoluong(item.getSoluong());
                    ctdh.setGia(item.getDongia());

                    SanPham findSP = spRepository.findByMasp(item.getMasp());
//					SanPham sp = new SanPham();
//					sp.setMasp(item.getMasp());
                    ctdh.setSanpham(findSP);

                    int updateSoLuongSP = findSP.getSoluong() - item.getSoluong();

                    if (updateSoLuongSP < 0) {
                        return new ResponseEntity<String>("Sản phẩm " + findSP.getTensp() + " không đủ số lượng bán, vui lòng kiểm tra lại!", HttpStatus.BAD_REQUEST);
                    }
                    findSP.setSoluong(updateSoLuongSP);

                    spRepository.save(findSP);
                    ctdhRepository.save(ctdh);

                    ghRepository.deleteGioHangByMakhAndMasp(dhModel.getMakh(), findSP.getMasp());
                }
            } catch (Exception e) {
                System.out.println(e);
                return new ResponseEntity<String>("Đã xảy ra lỗi, thêm chi tiết đơn hàng thất bại!", HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<String>("Thêm đơn hàng thành công!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("Đã xảy ra lỗi, thêm đơn hàng thất bại!", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public List<DonHang> getListService() {
        return dhRepository.findAll();
    }

    @Override
    public ResponseEntity<String> updateDonHang(UpdateDonHangDto updateDHModel) {
        try {
            DonHang findDH = dhRepository.getDetailDH(updateDHModel.getMadh());
            if (findDH == null) {
                return new ResponseEntity<String>("Đơn hàng không tồn tại", HttpStatus.BAD_REQUEST);
            }

            findDH.setTrangThai(updateDHModel.getTrangthai());
            findDH.setHinhThucThanhToan(updateDHModel.getHinhThucThanhToan());

            NhanVien findNV = nvRepository.findByManv(updateDHModel.getManv());

            NhanVien findNVGH = nvRepository.findByManv(updateDHModel.getManvgh());

            if (findNVGH != null) {
                findDH.setGiaohang(findNVGH);
            }

            if (updateDHModel.getTrangthai() == 4) {
                List<CT_DonHang> findCTDH = ctdhRepository.findBymadh(findDH.getMadh());
                for (CT_DonHang item : findCTDH) {
                    SanPham findSP = spRepository.findByMasp(item.getSanpham().getMasp());
                    int updateSoLuongSP = findSP.getSoluong() + item.getSoluong();
                    findSP.setSoluong(updateSoLuongSP);

                    spRepository.save(findSP);
                }
            }

            findDH.setNhanvien(findNV);
            dhRepository.save(findDH);

            return new ResponseEntity<String>("Update đơn hàng thành công!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("Đã xảy ra lỗi, thêm đơn hàng thất bại!", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public double[] getThongKeByYear() {
        List<DonThuThangDto> doanhThuList = dhRepository.getThongKeByYear();
        double[] doanhThuThang = new double[12];

        for (DonThuThangDto item : doanhThuList) {
            doanhThuThang[item.getThang() - 1] = item.getTongDoanhThu();
        }

        return doanhThuThang;
    }
}
