package com.tmdt.xedap.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tmdt.xedap.entity.CT_DonDatHang;
import com.tmdt.xedap.entity.CT_DonDatHang_ID;
import com.tmdt.xedap.entity.CT_PhieuNhap;
import com.tmdt.xedap.entity.CT_PhieuNhap_ID;
import com.tmdt.xedap.entity.DonDatHang;
import com.tmdt.xedap.entity.NhaCungCap;
import com.tmdt.xedap.entity.NhanVien;
import com.tmdt.xedap.entity.PhieuNhap;
import com.tmdt.xedap.entity.SanPham;
import com.tmdt.xedap.model.CT_DonDatHangModel;
import com.tmdt.xedap.model.PhieuNhapModel;
import com.tmdt.xedap.repository.CT_PhieuNhapRepository;
import com.tmdt.xedap.repository.DonDatHangRepository;
import com.tmdt.xedap.repository.NhanVienRepository;
import com.tmdt.xedap.repository.PhieuNhapRepository;
import com.tmdt.xedap.service.PhieuNhapService;

@Service
public class PhieuNhapServiceImpl implements PhieuNhapService
{
	
	@Autowired
	private PhieuNhapRepository pnRepository;
	
	@Autowired 
	private NhanVienRepository nvRepository;
	
	@Autowired 
	private DonDatHangRepository ddhRepository;
	
	@Autowired
	private CT_PhieuNhapRepository ct_pnRepository;
	

	@Override
	public List<PhieuNhap> getListService() {
		// TODO Auto-generated method stub
		return pnRepository.findAll(Sort.by(Sort.Order.desc("ngaydat")));
	}

	@Override
	public ResponseEntity<String> addPhieuNhap(PhieuNhapModel pnModel) {
		// TODO Auto-generated method stub
		try {
			DonDatHang findDDH = ddhRepository.findByMaddh(pnModel.getMaddh());
			
			if(findDDH == null){
				return new ResponseEntity<String>("Mã đơn đặt hàng không tồn tại!", HttpStatus.BAD_REQUEST);
			}
			
			NhanVien findNV = nvRepository.findByManv(pnModel.getManv());
			
			if(findNV == null){
				return new ResponseEntity<String>("Mã nhân viên không tồn tại!", HttpStatus.BAD_REQUEST);
			}
			
			PhieuNhap findPN = pnRepository.findByMapn(pnModel.getMapn());
			
			if(findPN != null){
				return new ResponseEntity<String>("Mã phiếu nhập đã tồn tại", HttpStatus.BAD_REQUEST);
			}
			
			PhieuNhap pn = new PhieuNhap();
		
			pn.setMapn(pnModel.getMapn());
			pn.setDondathang(findDDH);
			pn.setNhanvien(findNV);
			pn.setNgaydat(LocalDate.now());
		
			pnRepository.save(pn);
			
			try {
				List<CT_DonDatHangModel> listDS = pnModel.getDs();
		
				
				for(CT_DonDatHangModel ds: listDS) {
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
				// TODO: handle exception
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
