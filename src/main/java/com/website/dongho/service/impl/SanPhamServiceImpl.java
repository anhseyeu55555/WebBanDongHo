package com.website.dongho.service.impl;

import com.website.dongho.dto.SanPhamDto;
import com.website.dongho.entity.DanhMuc;
import com.website.dongho.entity.NhaCungCap;
import com.website.dongho.entity.SanPham;
import com.website.dongho.entity.ThuongHieu;
import com.website.dongho.repository.DanhMucRepository;
import com.website.dongho.repository.NhaCungCapRepository;
import com.website.dongho.repository.SanPhamRepository;
import com.website.dongho.repository.ThuongHieuRepository;
import com.website.dongho.service.SanPhamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SanPhamServiceImpl implements SanPhamService {
    private final SanPhamRepository spRepository;

    private final DanhMucRepository dmRepository;

    private final ThuongHieuRepository thRepository;

    private final NhaCungCapRepository nccRepository;

    @Override
    public List<SanPham> getListService() {
        return spRepository.findAll();
    }

    @Override
    public ResponseEntity<SanPham> getDetailSPBySlug(String slug) {
        try {
            SanPham sp = spRepository.findBySlug(slug);
            if (sp == null) {
                return new ResponseEntity<SanPham>(new SanPham(), HttpStatus.BAD_REQUEST);
            }

            return new ResponseEntity<SanPham>(sp, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<SanPham>(new SanPham(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<SanPham> getDetailSPByMaSp(String masp) {
        try {
            SanPham sp = spRepository.findByMasp(masp);
            if (sp == null) {
                return new ResponseEntity<SanPham>(new SanPham(), HttpStatus.BAD_REQUEST);
            }

            return new ResponseEntity<SanPham>(sp, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<SanPham>(new SanPham(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<String> addSanPham(SanPhamDto sanpham) {
        try {
            SanPham findSlugSP = spRepository.findBySlug(sanpham.getSlug());
            if (findSlugSP != null) {
                return new ResponseEntity<String>("Tên sản phẩm đã tồn tại!", HttpStatus.BAD_REQUEST);
            }

            SanPham findMaSP = spRepository.findByMasp(sanpham.getMasp());
            if (findMaSP != null) {
                return new ResponseEntity<String>("Mã sản phẩm đã tồn tại!", HttpStatus.BAD_REQUEST);
            }

            DanhMuc findDM = dmRepository.findByMadm(sanpham.getMadm());
            if (findDM == null) {
                return new ResponseEntity<String>("Mã danh mục không tồn tại!", HttpStatus.BAD_REQUEST);
            }

            ThuongHieu findTH = thRepository.findByMath(sanpham.getMath());
            if (findTH == null) {
                return new ResponseEntity<String>("Mã thương hiệu tồn tại!", HttpStatus.BAD_REQUEST);
            }

            NhaCungCap findNCC = nccRepository.findByMancc(sanpham.getMancc());
            if (findNCC == null) {
                return new ResponseEntity<String>("Mã nhà cung cấp tồn tại!", HttpStatus.BAD_REQUEST);
            }

            SanPham dataAddSP = new SanPham();
            dataAddSP.setMasp(sanpham.getMasp());
            dataAddSP.setTensp(sanpham.getTensp());
            dataAddSP.setSlug(sanpham.getSlug());
            dataAddSP.setSoluong(sanpham.getSoluong());
            dataAddSP.setDongia(sanpham.getDongia());
            dataAddSP.setChitietSP(sanpham.getChitietSP());
            dataAddSP.setImage(sanpham.getImage());
            dataAddSP.setTrangthai(sanpham.getTrangthai());
            dataAddSP.setThuonghieu(findTH);
            dataAddSP.setDanhmuc(findDM);
            dataAddSP.setNhacungcap(findNCC);

            spRepository.save(dataAddSP);
            return new ResponseEntity<String>("Thêm sản phẩm thành công!", HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<String>("Đã xảy ra lỗi, thêm sản phẩm thất bại!", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<String> deleteSanPham(String masp) {
        try {
            SanPham findSP = spRepository.findByMasp(masp);
            if (findSP == null) {
                return new ResponseEntity<String>("Mã sản phẩm không tồn tại!", HttpStatus.BAD_REQUEST);
            }

            spRepository.deleteById(masp);
            return new ResponseEntity<String>("Xoá sản phẩm thành công!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("Đã xảy ra lỗi, xoá sản phẩm thất bại!", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<SanPham> updateSP(String masp, SanPham sanpham) {
        try {
            SanPham findSP = spRepository.findByMasp(masp);
            if (findSP == null) {
                return new ResponseEntity<SanPham>(new SanPham(), HttpStatus.BAD_REQUEST);
            }

            spRepository.save(sanpham);
            return new ResponseEntity<SanPham>(sanpham, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<SanPham>(new SanPham(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public List<SanPham> getListSanPhamByDM(String madm) {
        return spRepository.getSPByMaDM(madm);
    }

    @Override
    public List<SanPham> getListSanPhamByTH(String math) {
        return spRepository.getSPByMaTH(math);
    }

    @Override
    public List<SanPham> getListSanPhamByNCC(String mancc) {
        return spRepository.getSPByMaNcc(mancc);
    }

    @Override
    public List<SanPham> getListSanPhamByNew() {
        return spRepository.getSPByNew();
    }

    @Override
    public List<SanPham> getListSanPhamBySearch(String search) {
        return spRepository.getSPBySearch(search);
    }

    @Override
    public List<SanPham> getListSanPhamBestSeller() {
        return spRepository.getListBestSeller();
    }
}
