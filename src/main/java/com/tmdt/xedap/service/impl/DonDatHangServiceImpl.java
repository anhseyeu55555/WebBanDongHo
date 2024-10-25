package com.tmdt.xedap.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tmdt.xedap.entity.CT_DonNhapHang;
import com.tmdt.xedap.entity.CT_DonDatHang_ID;
import com.tmdt.xedap.entity.DonDatHang;
import com.tmdt.xedap.entity.NhaCungCap;
import com.tmdt.xedap.entity.NhanVien;
import com.tmdt.xedap.entity.SanPham;
import com.tmdt.xedap.dto.CT_DonDatHangModel;
import com.tmdt.xedap.dto.DonDatHangModel;
import com.tmdt.xedap.repository.CT_DonDatHangRepository;
import com.tmdt.xedap.repository.DonDatHangRepository;
import com.tmdt.xedap.repository.NhaCungCapRepository;
import com.tmdt.xedap.repository.NhanVienRepository;
import com.tmdt.xedap.service.DonDatHangService;


@Service
public class DonDatHangServiceImpl implements DonDatHangService {

	@Autowired
	private DonDatHangRepository ddhRepository;
	
	@Autowired
	private CT_DonDatHangRepository ct_dhhRepository;
	
	@Autowired 
	private NhanVienRepository nvRepository;
	
	@Autowired 
	private NhaCungCapRepository nccRepository;
	

	
	@Override
	public List<DonDatHang> getListService() {
		// TODO Auto-generated method stub
		return ddhRepository.findAll(Sort.by(Sort.Order.desc("ngaydat")));
	}

	@Override
	public ResponseEntity<String> addDonDathang(DonDatHangModel ddhModel) {
		// TODO Auto-generated method stub
		try {
			NhaCungCap findNCC = nccRepository.findByMancc(ddhModel.getMancc());
			
			if(findNCC == null){
				return new ResponseEntity<String>("Mã nhà cung cấp không tồn tại!", HttpStatus.BAD_REQUEST);
			}
			
			NhanVien findNV = nvRepository.findByManv(ddhModel.getManv());
			
			if(findNV == null){
				return new ResponseEntity<String>("Mã nhân viên không tồn tại!", HttpStatus.BAD_REQUEST);
			}
			
			DonDatHang findDdh = ddhRepository.findByMaddh(ddhModel.getMaddh());
			
			if(findDdh != null){
				return new ResponseEntity<String>("Mã đơn hàng đặt đã tồn tại!", HttpStatus.BAD_REQUEST);
			}
			
			DonDatHang ddh = new DonDatHang();
			
			ddh.setMddh(ddhModel.getMaddh());
			ddh.setNhacungcap(findNCC);
			ddh.setNhanvien(findNV);
			ddh.setNgaydat(LocalDate.now());
		
			ddhRepository.save(ddh);
			
			try {
				
				List<CT_DonDatHangModel> listDS = ddhModel.getDs();
		
				
				for(CT_DonDatHangModel ds: listDS) {
					CT_DonNhapHang ct_ddh = new CT_DonNhapHang();
					CT_DonDatHang_ID ct_ddh_id = new CT_DonDatHang_ID(ddh.getMddh(), ds.getMasp());
					
					
				
					
					ct_ddh.setId(ct_ddh_id);
					ct_ddh.setDondathang(ddh);
					
					SanPham sp = new SanPham();
					sp.setMaSp(ds.getMasp());
					ct_ddh.setSanpham(sp);
					
					ct_ddh.setGia(ds.getGia());
					ct_ddh.setSoluong(ds.getSoluong());
					
					
					ct_dhhRepository.save(ct_ddh);
				}
			} catch (Exception e) {
				System.out.println(e);
				return new ResponseEntity<String>("Đã xảy ra lỗi, thêm chi tiết đơn hàng thất bại!", HttpStatus.BAD_REQUEST);
			}
			
			return new ResponseEntity<String>("Thêm đơn đạt hàng thành công!", HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<String>("Đã xảy ra lỗi, thêm danh mục thất bại!", HttpStatus.BAD_REQUEST);
		}
	}

}
