package com.tmdt.xedap.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tmdt.xedap.entity.CT_DonHang;
import com.tmdt.xedap.entity.CT_DonHang_ID;
import com.tmdt.xedap.entity.DonHang;
import com.tmdt.xedap.entity.HoaDon;
import com.tmdt.xedap.entity.KhachHang;
import com.tmdt.xedap.entity.NhanVien;
import com.tmdt.xedap.entity.SanPham;
import com.tmdt.xedap.dto.SanPhamDatHangModel;
import com.tmdt.xedap.dto.UpdateDonHangModel;
import com.tmdt.xedap.dto.DonHangModel;
import com.tmdt.xedap.dto.DonThuThang;
import com.tmdt.xedap.repository.CT_DonHangRepository;
import com.tmdt.xedap.repository.DonHangRepository;
import com.tmdt.xedap.repository.GioHangRepository;
import com.tmdt.xedap.repository.HoaDonRepository;
import com.tmdt.xedap.repository.KhachHangRepository;
import com.tmdt.xedap.repository.NhanVienRepository;
import com.tmdt.xedap.repository.SanPhamRepository;
import com.tmdt.xedap.service.DonHangService;

@Service
public class DonHangServiceImpl implements DonHangService{
	
	@Autowired
	private DonHangRepository dhRepository;
	
	@Autowired
	private CT_DonHangRepository ctdhRepository;
	
	@Autowired
	private KhachHangRepository khRepository;
	
	@Autowired
	private NhanVienRepository nvRepository;

	@Autowired
	private GioHangRepository ghRepository;
	
	@Autowired 
	private SanPhamRepository spRepository;
	
	@Autowired
	private HoaDonRepository hdRepository;
	

	@Override
	public List<DonHang> getListDonHangByKH(String makh) {
		// TODO Auto-generated method stub
		return dhRepository.listDonHangByMaKH(makh);
	}

	@Override
	public List<DonHang> getListDonHangByNV(String manv) {
		// TODO Auto-generated method stub
		return dhRepository.listDonHangByMaNV(manv);
	}

	@Override
	public List<DonHang> getListDonHangByTT(String makh, int trangthai) {
		// TODO Auto-generated method stub
		return dhRepository.listDHByTrangThai(makh, trangthai);
	}

	@Override
	public ResponseEntity<String> addDonHang(DonHangModel dhModel) {
		// TODO Auto-generated method stub
		try {
			KhachHang findKH = khRepository.findByMakh(dhModel.getMakh());
			
			if(findKH == null) {
				return new ResponseEntity<String>("Mã khách hàng không tồn tại!", HttpStatus.BAD_REQUEST);
			}
			
			DonHang dh = new DonHang();
			
			String maDH = "DH" +  System.currentTimeMillis() % 10000000;
			
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
			
			List<SanPhamDatHangModel> dsSanPham = dhModel.getDsSanPham();
			float tongTien = 0;
			for (SanPhamDatHangModel item: dsSanPham ) {
				tongTien += (item.getDongia() * item.getSoluong());
			}
			
			dh.setTongTien(tongTien);
		
			
			dhRepository.save(dh);
			
			
			HoaDon hd = new HoaDon();
			
			String mahd = "HD" +  System.currentTimeMillis() % 10000000;
			
			hd.setDonhang(dh);
			hd.setMahd(mahd);
			hd.setNgaylap(LocalDate.now());
			hd.setThanhtien(tongTien);
			hdRepository.save(hd);
			

			try {
				List<SanPhamDatHangModel> listDS = dhModel.getDsSanPham();
				
				for(SanPhamDatHangModel item: listDS) {
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
					
					SanPham updateSP = findSP;
//					int updateSoLuongSP = findSP.getSoLuong() - item.getSoluong();
//
//					if(updateSoLuongSP < 0) {
//						return new ResponseEntity<String>("Sản phẩm " + findSP.getTenSp() + " không đủ số lượng bán, vui lòng kiểm tra lại!", HttpStatus.BAD_REQUEST);
//					}
//
//					updateSP.setSoLuong(updateSoLuongSP);
					
					spRepository.save(updateSP);
					
					
					ctdhRepository.save(ctdh);
					
					ghRepository.deleteGioHangByMakhAndMasp(dhModel.getMakh(), findSP.getMaSp());
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
				return new ResponseEntity<String>("Đã xảy ra lỗi, thêm chi tiết đơn hàng thất bại!", HttpStatus.BAD_REQUEST);
			}
			return new ResponseEntity<String>("Thêm đơn hàng thành công!", HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<String>("Đã xảy ra lỗi, thêm đơn hàng thất bại!", HttpStatus.BAD_REQUEST);
		}
	
	}

	@Override
	public List<DonHang> getListService() {
		// TODO Auto-generated method stub
		return dhRepository.findAll();
	}

	@Override
	public ResponseEntity<String> updateDonHang(UpdateDonHangModel updateDHModel) {
		// TODO Auto-generated method stub
	try {
		DonHang findDH = dhRepository.getDetailDH(updateDHModel.getMadh());
		
		if(findDH == null) {
			return new ResponseEntity<String>("Đơn hàng không tồn tại", HttpStatus.BAD_REQUEST);
		}
		
		DonHang updateDH = findDH;
		updateDH.setTrangThai(updateDHModel.getTrangthai());
		updateDH.setHinhThucThanhToan(updateDHModel.getHinhThucThanhToan());
	
		NhanVien findNV = nvRepository.findByManv(updateDHModel.getManv());
	
		NhanVien findNVGH = nvRepository.findByManv(updateDHModel.getManvgh());
		
		if(findNVGH != null) {
			updateDH.setGiaohang(findNVGH);
		}
		
		if(updateDHModel.getTrangthai() == 4) {
			List<CT_DonHang> findCTDH = ctdhRepository.findBymadh(findDH.getMadh());
			for(CT_DonHang item: findCTDH) {		
				SanPham findSP = spRepository.findByMasp(item.getSanpham().getMaSp());
				
				SanPham updateSP = findSP;
				//todo change soluong to kho
//				int updateSoLuongSP = findSP.getSoLuong() + item.getSoluong();
//
//				updateSP.setSoLuong(updateSoLuongSP);
				
				spRepository.save(updateSP);
			}
			
		}
		
		updateDH.setNhanvien(findNV);
		
		dhRepository.save(updateDH);
		
		return new ResponseEntity<String>("Update đơn hàng thành công!", HttpStatus.OK);
	} catch (Exception e) {
		// TODO: handle exception
		return new ResponseEntity<String>("Đã xảy ra lỗi, thêm đơn hàng thất bại!", HttpStatus.BAD_REQUEST);
	}
	}

	@Override
	public double[] getThongKeByYear(){
		  List<DonThuThang> doanhThuList = dhRepository.getThongKeByYear();
		  
		  double[] doanhThuThang = new double[12];

	        for (DonThuThang item : doanhThuList) {
	            doanhThuThang[item.getThang() - 1] = item.getTongDoanhThu();
	        }
	       
	       return doanhThuThang;
	
	}

}
