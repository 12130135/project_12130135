package model;

import DAO.DAO_HoaDon;

public class HoaDon {
	private String maMatHang;
	private String tenMatHang;
	private int soLuong;
	private String donViTinh;
	private double gia;
	private double thanhtien;
	private String id_Ban;
	private String ngay;
	private String maKhachHang;

	public HoaDon() {
		// TODO Auto-generated constructor stub
	}

	public HoaDon(String maMatHang, String tenMatHang, int soLuong,
			String donViTinh, double gia, double thanhtien) {
		super();
		this.maMatHang = maMatHang;
		this.tenMatHang = tenMatHang;
		this.soLuong = soLuong;
		this.donViTinh = donViTinh;
		this.gia = gia;
		this.thanhtien = thanhtien;
	}

	public HoaDon(String maMatHang, String tenMatHang, int soLuong,
			String donViTinh, double gia, double thanhtien, String id_Ban,
			String ngay, String maKhachHang) {
		super();
		this.maMatHang = maMatHang;
		this.tenMatHang = tenMatHang;
		this.soLuong = soLuong;
		this.donViTinh = donViTinh;
		this.gia = gia;
		this.thanhtien = thanhtien;
		this.id_Ban = id_Ban;
		this.ngay = ngay;
		this.maKhachHang = maKhachHang;
	}

	public String getMaMatHang() {
		return maMatHang;
	}

	public String getTenMatHang() {
		return tenMatHang;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public String getDonViTinh() {
		return donViTinh;
	}

	public double getGia() {
		return gia;
	}

	public double getThanhtien() {
		return thanhtien;
	}

	public String getId_Ban() {
		return id_Ban;
	}

	public String getNgay() {
		return ngay;
	}

	public String getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaMatHang(String maMatHang) {
		this.maMatHang = maMatHang;
	}

	public void setTenMatHang(String tenMatHang) {
		this.tenMatHang = tenMatHang;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public void setDonViTinh(String donViTinh) {
		this.donViTinh = donViTinh;
	}

	public void setGia(double gia) {
		this.gia = gia;
	}

	public void setThanhtien(double thanhtien) {
		this.thanhtien = thanhtien;
	}

	public void setId_Ban(String id_Ban) {
		this.id_Ban = id_Ban;
	}

	public void setNgay(String ngay) {
		this.ngay = ngay;
	}

	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((donViTinh == null) ? 0 : donViTinh.hashCode());
		long temp;
		temp = Double.doubleToLongBits(gia);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((id_Ban == null) ? 0 : id_Ban.hashCode());
		result = prime * result
				+ ((maKhachHang == null) ? 0 : maKhachHang.hashCode());
		result = prime * result
				+ ((maMatHang == null) ? 0 : maMatHang.hashCode());
		result = prime * result + ((ngay == null) ? 0 : ngay.hashCode());
		result = prime * result + soLuong;
		result = prime * result
				+ ((tenMatHang == null) ? 0 : tenMatHang.hashCode());
		temp = Double.doubleToLongBits(thanhtien);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HoaDon other = (HoaDon) obj;
		if (donViTinh == null) {
			if (other.donViTinh != null)
				return false;
		} else if (!donViTinh.equals(other.donViTinh))
			return false;
		if (Double.doubleToLongBits(gia) != Double.doubleToLongBits(other.gia))
			return false;
		if (id_Ban == null) {
			if (other.id_Ban != null)
				return false;
		} else if (!id_Ban.equals(other.id_Ban))
			return false;
		if (maKhachHang == null) {
			if (other.maKhachHang != null)
				return false;
		} else if (!maKhachHang.equals(other.maKhachHang))
			return false;
		if (maMatHang == null) {
			if (other.maMatHang != null)
				return false;
		} else if (!maMatHang.equals(other.maMatHang))
			return false;
		if (ngay == null) {
			if (other.ngay != null)
				return false;
		} else if (!ngay.equals(other.ngay))
			return false;
		if (soLuong != other.soLuong)
			return false;
		if (tenMatHang == null) {
			if (other.tenMatHang != null)
				return false;
		} else if (!tenMatHang.equals(other.tenMatHang))
			return false;
		if (Double.doubleToLongBits(thanhtien) != Double
				.doubleToLongBits(other.thanhtien))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "HoaDon [maMatHang=" + maMatHang + ", tenMatHang=" + tenMatHang
				+ ", soLuong=" + soLuong + ", donViTinh=" + donViTinh
				+ ", gia=" + gia + ", thanhtien=" + thanhtien + ", id_Ban="
				+ id_Ban + ", ngay=" + ngay + ", maKhachHang=" + maKhachHang
				+ "]";
	}

	public static double thanhtoan() {
		double abc = DAO_HoaDon.thanhtoan();
		return abc;
	}

}
