package com.website.dongho.service.impl;

import com.website.dongho.dto.NhanVienDangKy;
import com.website.dongho.entity.NhanVien;
import com.website.dongho.entity.Quyen;
import com.website.dongho.entity.TaiKhoan;
import com.website.dongho.repository.NhanVienRepository;
import com.website.dongho.repository.TaiKhoanRepository;
import com.website.dongho.service.NhanVienService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NhanVienServiceImpl implements NhanVienService {
    private final NhanVienRepository nvRepository;

    private final TaiKhoanRepository tkRepository;

    @Override
    public List<NhanVien> getListService() {
        return nvRepository.findAll();
    }

    @Override
    public ResponseEntity<NhanVien> getDetailNV(String manv) {
        try {
            NhanVien nv = nvRepository.findByManv(manv);
            if (nv == null) {
                return new ResponseEntity<NhanVien>(new NhanVien(), HttpStatus.BAD_REQUEST);
            }

            return new ResponseEntity<NhanVien>(nv, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<NhanVien>(new NhanVien(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<String> addNV(NhanVienDangKy nvdk) {
        try {
            TaiKhoan findTK = tkRepository.findByUsername(nvdk.getUsername());
            if (findTK != null) {
                return new ResponseEntity<String>("Username đã tồn tại!", HttpStatus.BAD_REQUEST);
            }

            NhanVien findNV = nvRepository.findByEmail(nvdk.getEmail());
            if (findNV != null) {
                return new ResponseEntity<String>("Địa chỉ email đã tồn tại", HttpStatus.BAD_REQUEST);
            }

//			if(findNV.getSdt().equals(nvdk.getSdt())){
//				return new ResponseEntity<String>("Số điện thoại đã tồn tại", HttpStatus.BAD_REQUEST);
//			}

            TaiKhoan newTk = new TaiKhoan();
            newTk.setUsername(nvdk.getUsername());
            newTk.setPassword(nvdk.getPassword());
            newTk.setQuyen(new Quyen(3));

            NhanVien newNv = new NhanVien();
            newNv.setTaikhoan(newTk);
            newNv.setDiachi(nvdk.getDiachi());
            newNv.setEmail(nvdk.getEmail());
            newNv.setGioitinh(nvdk.getGioitinh());
            newNv.setHoten(nvdk.getHoten());
            newNv.setLuong(nvdk.getLuong());
            newNv.setSdt(nvdk.getSdt());
            String manv = "NV" + System.currentTimeMillis() % 10000000;
            newNv.setManv(manv);

            tkRepository.save(newTk);
            nvRepository.save(newNv);

            return new ResponseEntity<String>("Thêm nhân viên thành công!", HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<String>("Đã xảy ra lỗi, thêm nhân viên thất bại!", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<String> deleteNV(String manv) {
        try {
            NhanVien findNV = nvRepository.findByManv(manv);
            if (findNV == null) {
                return new ResponseEntity<String>("Mã nhân viên không tồn tại!", HttpStatus.BAD_REQUEST);
            }

            nvRepository.deleteById(manv);
            tkRepository.deleteById(findNV.getTaikhoan().getUsername());
            return new ResponseEntity<String>("Xoá nhân viên thành công!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("Đã xảy ra lỗi, xoá nhân viên thất bại!", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<NhanVien> updateNV(String manv, NhanVien nv) {
        try {
            NhanVien findNV = nvRepository.findByManv(manv);
            if (findNV == null) {
                return new ResponseEntity<NhanVien>(new NhanVien(), HttpStatus.BAD_REQUEST);
            }

            nv.setTaikhoan(findNV.getTaikhoan());
            nvRepository.save(nv);
            return new ResponseEntity<NhanVien>(nv, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<NhanVien>(new NhanVien(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<NhanVien> getDetailNVByUsername(String username) {
        try {
            NhanVien findNV = nvRepository.findByUsername(username);
            if (findNV == null) {
                return new ResponseEntity<NhanVien>(new NhanVien(), HttpStatus.BAD_REQUEST);
            }

            return new ResponseEntity<NhanVien>(findNV, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<NhanVien>(new NhanVien(), HttpStatus.BAD_REQUEST);
        }
    }
}
