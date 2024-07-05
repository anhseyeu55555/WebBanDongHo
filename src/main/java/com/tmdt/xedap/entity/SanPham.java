package com.tmdt.xedap.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "san_pham")
public class SanPham {

	@Id
	private String masp;
	
	private String tensp;
	private String slug;
	private int soluong;
	private float dongia;
	private String chitietSP;
	private String image;
	private String image2;
	private String image3;
	private int trangthai;
	
	@ManyToOne
	@JoinColumn(name = "math")
	private ThuongHieu thuonghieu;
	
	@ManyToOne
	@JoinColumn(name = "madm")
	private DanhMuc danhmuc;
	
	@ManyToOne
	@JoinColumn(name = "mancc")
	private NhaCungCap nhacungcap;
	
	@JsonIgnore
	@OneToMany(mappedBy = "sanpham")
	List<GioHang> listGioHang;
	
	@JsonIgnore
	@OneToMany(mappedBy = "sanpham")
	List<CT_DonDatHang> listCTDDH;

	public SanPham() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SanPham(String masp, String tensp, String slug, int soluong, float dongia, String chitietSP, String image,
			String image2, String image3, int trangthai, ThuongHieu thuonghieu, DanhMuc danhmuc, NhaCungCap nhacungcap,
			List<GioHang> listGioHang, List<CT_DonDatHang> listCTDDH) {
		super();
		this.masp = masp;
		this.tensp = tensp;
		this.slug = slug;
		this.soluong = soluong;
		this.dongia = dongia;
		this.chitietSP = chitietSP;
		this.image = image;
		this.image2 = image2;
		this.image3 = image3;
		this.trangthai = trangthai;
		this.thuonghieu = thuonghieu;
		this.danhmuc = danhmuc;
		this.nhacungcap = nhacungcap;
		this.listGioHang = listGioHang;
		this.listCTDDH = listCTDDH;
	}

	public String getMasp() {
		return masp;
	}

	public void setMasp(String masp) {
		this.masp = masp;
	}

	public String getTensp() {
		return tensp;
	}

	public void setTensp(String tensp) {
		this.tensp = tensp;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public float getDongia() {
		return dongia;
	}

	public void setDongia(float dongia) {
		this.dongia = dongia;
	}

	public String getChitietSP() {
		return chitietSP;
	}

	public void setChitietSP(String chitietSP) {
		this.chitietSP = chitietSP;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getImage2() {
		return image2;
	}

	public void setImage2(String image2) {
		this.image2 = image2;
	}

	public String getImage3() {
		return image3;
	}

	public void setImage3(String image3) {
		this.image3 = image3;
	}

	public int getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(int trangthai) {
		this.trangthai = trangthai;
	}

	public ThuongHieu getThuonghieu() {
		return thuonghieu;
	}

	public void setThuonghieu(ThuongHieu thuonghieu) {
		this.thuonghieu = thuonghieu;
	}

	public DanhMuc getDanhmuc() {
		return danhmuc;
	}

	public void setDanhmuc(DanhMuc danhmuc) {
		this.danhmuc = danhmuc;
	}

	public NhaCungCap getNhacungcap() {
		return nhacungcap;
	}

	public void setNhacungcap(NhaCungCap nhacungcap) {
		this.nhacungcap = nhacungcap;
	}

	public List<GioHang> getListGioHang() {
		return listGioHang;
	}

	public void setListGioHang(List<GioHang> listGioHang) {
		this.listGioHang = listGioHang;
	}

	public List<CT_DonDatHang> getListCTDDH() {
		return listCTDDH;
	}

	public void setListCTDDH(List<CT_DonDatHang> listCTDDH) {
		this.listCTDDH = listCTDDH;
	}


}
