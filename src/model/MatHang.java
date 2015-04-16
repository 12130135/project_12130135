package model;

import jxl.biff.formula.ParseContext;

public class MatHang {
	private String maMatHang;
	private String tenMatHang;
	private double giaMatHang;
	private String donViTinh;
	private int soLuong;
	private String nhomHang;
	private String ngayNhap;
	private String nhaCungCap;

	public MatHang() {
		// TODO Auto-generated constructor stub
	}

	public MatHang(String maMatHang, String tenMatHang, double giaMatHang,
			String donViTinh, int soLuong, String nhomHang, String ngayNhap,
			String nhaCungCap) {
		super();
		maMatHang = maMatHang;
		this.tenMatHang = tenMatHang;
		this.giaMatHang = giaMatHang;
		this.donViTinh = donViTinh;
		this.soLuong = soLuong;
		this.nhomHang = nhomHang;
		this.ngayNhap = ngayNhap;
		this.nhaCungCap = nhaCungCap;
	}

	public String getMaMatHang() {
		return maMatHang;
	}

	public void setMaMatHang(String maMatHang) {
		this.maMatHang = maMatHang;
	}

	public String getTenMatHang() {
		return tenMatHang;
	}

	public void setTenMatHang(String tenMatHang) {
		this.tenMatHang = tenMatHang;
	}

	public double getGiaMatHang() {
		return giaMatHang;
	}

	public void setGiaMatHang(Double string) {
		this.giaMatHang = string;
	}

	public String getDonViTinh() {
		return donViTinh;
	}

	public void setDonViTinh(String donViTinh) {
		this.donViTinh = donViTinh;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public String getNhomHang() {
		return nhomHang;
	}

	public void setNhomHang(String nhomHang) {
		this.nhomHang = nhomHang;
	}

	public String getNgayNhap() {
		return ngayNhap;
	}

	public void setNgayNhap(String ngayNhap) {
		this.ngayNhap = ngayNhap;
	}

	public String getNhaCungCap() {
		return nhaCungCap;
	}

	public void setNhaCungCap(String nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String s = "- Mặt hàng| mã mặt hàng: " + this.maMatHang
				+ ", tên mặt hàng: " + this.tenMatHang + ", giá mặt hàng: "
				+ this.giaMatHang + ", đơn vị tính: " + this.donViTinh
				+ ", số lượng: " + this.soLuong + ", nhóm hàng: "
				+ this.nhomHang + ", ngày nhập: " + this.ngayNhap
				+ ", nhà cung cấp: " + this.nhaCungCap;
		return s;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MatHang other = (MatHang) obj;
		if (maMatHang == null) {
			if (other.maMatHang != null)
				return false;
		} else if (!maMatHang.equals(other.maMatHang))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((maMatHang == null) ? 0 : maMatHang.hashCode());
		return result;
	}


}
