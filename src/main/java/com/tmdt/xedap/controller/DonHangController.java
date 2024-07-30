package com.tmdt.xedap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tmdt.xedap.entity.DonHang;
import com.tmdt.xedap.model.DonHangModel;
import com.tmdt.xedap.model.UpdateDonHangModel;
import com.tmdt.xedap.service.DonHangService;

@RestController
@CrossOrigin
public class DonHangController {

	@Autowired
	private DonHangService dhService;
	
	
	@GetMapping("/admin/donhang")
	public List<DonHang> getAllDonHang() {
		return dhService.getListService();
	}
	
	@GetMapping("/admin/donhang/nhanvien/{manv}")
	public List<DonHang> getDHByNV(@PathVariable("manv") String manv) {
		return dhService.getListDonHangByNV(manv);
	}
	
	@GetMapping("/donhang/user/{makh}")
	public List<DonHang> getDHByKH(@PathVariable("makh") String makh) {
		return dhService.getListDonHangByKH(makh);
	}
	
	@GetMapping("/donhang/user/{makh}/{trangthai}")
	public List<DonHang> getDHByKHAndTT(@PathVariable("makh") String makh,@PathVariable("trangthai") int trangthai) {
		return dhService.getListDonHangByTT(makh, trangthai);
	}
	
	@PostMapping("/donhang/user")
	public ResponseEntity<String> addDonHangByKH(@Validated @RequestBody DonHangModel dhModel) {
		return dhService.addDonHang(dhModel);
	}
	
	@PutMapping("donhang/user")
	public ResponseEntity<String> updateDonHangByNV(@Validated @RequestBody UpdateDonHangModel updateDHModel) {
		return dhService.updateDonHang(updateDHModel);
	}
	
	@GetMapping("/donhang/thongke")
	public double[] getThongKeByYear(){
		return  dhService.getThongKeByYear();
	}
	
}
