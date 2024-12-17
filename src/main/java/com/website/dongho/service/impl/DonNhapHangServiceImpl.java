package com.website.dongho.service.impl;

import com.website.dongho.dto.CT_DonNhaphangDto;
import com.website.dongho.dto.DonNhapHangDto;
import com.website.dongho.entity.CT_DonNhapHang;
import com.website.dongho.entity.CT_DonNhapHang_ID;
import com.website.dongho.entity.DonNhapHang;
import com.website.dongho.entity.NhaCungCap;
import com.website.dongho.entity.NhanVien;
import com.website.dongho.entity.SanPham;
import com.website.dongho.repository.CT_DonNhapHangRepository;
import com.website.dongho.repository.DonNhapHangRepository;
import com.website.dongho.repository.NhaCungCapRepository;
import com.website.dongho.repository.NhanVienRepository;
import com.website.dongho.repository.SanPhamRepository;
import com.website.dongho.service.DonNhapHangService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;


@Service
@RequiredArgsConstructor
public class DonNhapHangServiceImpl implements DonNhapHangService {
    private final DonNhapHangRepository ddhRepository;

    private final CT_DonNhapHangRepository ct_dhhRepository;

    private final NhanVienRepository nvRepository;

    private final NhaCungCapRepository nccRepository;

    private final SanPhamRepository sanPhamRepository;

    @Override
    public List<DonNhapHang> getListService() {
        return ddhRepository.findAll(Sort.by(Sort.Order.desc("ngaydat")));
    }

    @Override
    public ResponseEntity<String> addDonDathang(DonNhapHangDto ddhModel) {
        try {
            NhaCungCap findNCC = nccRepository.findByMancc(ddhModel.getMancc());

            if (findNCC == null) {
                return new ResponseEntity<String>("Mã nhà cung cấp không tồn tại!", HttpStatus.BAD_REQUEST);
            }

            NhanVien findNV = nvRepository.findByManv(ddhModel.getManv());

            if (findNV == null) {
                return new ResponseEntity<String>("Mã nhân viên không tồn tại!", HttpStatus.BAD_REQUEST);
            }

            DonNhapHang findDdh = ddhRepository.findByMadnh(ddhModel.getMaddh());

            if (findDdh != null) {
                return new ResponseEntity<String>("Mã đơn hàng đặt đã tồn tại!", HttpStatus.BAD_REQUEST);
            }

            DonNhapHang ddh = new DonNhapHang();
            ddh.setMadnh(ddhModel.getMaddh());
            ddh.setNhacungcap(findNCC);
            ddh.setNhanvien(findNV);
            ddh.setNgaydat(LocalDate.now());
            ddhRepository.save(ddh);

            try {
                List<CT_DonNhaphangDto> listDS = ddhModel.getDs();
                for (CT_DonNhaphangDto ds : listDS) {
                    CT_DonNhapHang ct_ddh = new CT_DonNhapHang();
                    CT_DonNhapHang_ID ct_ddh_id = new CT_DonNhapHang_ID(ddh.getMadnh(), ds.getMasp());
                    ct_ddh.setId(ct_ddh_id);
                    ct_ddh.setDondathang(ddh);

                    SanPham sp = new SanPham();
                    sp.setMasp(ds.getMasp());
                    ct_ddh.setSanpham(sp);
                    ct_ddh.setGia(ds.getGia());
                    ct_ddh.setSoluong(ds.getSoluong());

                    SanPham sanPhamDb = sanPhamRepository.findByMasp(ds.getMasp());
                    if (Objects.isNull(sanPhamDb)) {
                        throw new BadRequestException("Mã Sản Phẩm không tồn tại!!");
                    }

                    int soluong = sanPhamDb.getSoluong() + ds.getSoluong();
                    sanPhamDb.setSoluong(soluong);

                    sanPhamRepository.save(sanPhamDb);
                    ct_dhhRepository.save(ct_ddh);
                }
            } catch (Exception e) {
                System.out.println(e);
                return new ResponseEntity<String>("Đã xảy ra lỗi, thêm chi tiết đơn hàng thất bại!", HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<String>("Thêm đơn nhập hàng thành công!", HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<String>("Đã xảy ra lỗi, thêm đơn nhập hàng thất bại!", HttpStatus.BAD_REQUEST);
        }
    }
}
