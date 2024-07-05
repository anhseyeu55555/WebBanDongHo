package com.tmdt.xedap.model;

public class SanPhamModel {
	
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
	
	private String madm;
	private String math;
	private String mancc;
	
	
	public SanPhamModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SanPhamModel(String masp, String tensp, String slug, int soluong, float dongia, String chitietSP,
			String image, String image2, String image3, int trangthai, String madm, String math, String mancc) {
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
		this.madm = madm;
		this.math = math;
		this.mancc = mancc;
	}
	
	


	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
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


	public String getMadm() {
		return madm;
	}


	public void setMadm(String madm) {
		this.madm = madm;
	}


	public String getMath() {
		return math;
	}


	public void setMath(String math) {
		this.math = math;
	}


	public String getMancc() {
		return mancc;
	}


	public void setMancc(String mancc) {
		this.mancc = mancc;
	}


	
}
