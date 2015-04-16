package controller;

import java.util.List;

import DAO.DAO_KhachHang;
import DAO.DAO_KhachHang;
import model.KhachHang;
import model.KhachHang;

public class Controller_KhachHang {

	public static List<KhachHang> loadDatabase() {
		return DAO_KhachHang.loadDatabase();
	}

	public static List<KhachHang> timKiem(String serch) {
		return DAO_KhachHang.timKiem(serch);
	}

	public static boolean checkMaKhachHang(String check) {
		return DAO_KhachHang.checkMaKhachHang(check);
	}

	public static boolean themKH(String maKH, String tenKhachHang,
			String gioiTinh, String diaChi, String soDienThoai, String email,
			String ghiChu) {

		KhachHang khachhang = new KhachHang();

		khachhang.setMaKhachHang(maKH);
		khachhang.setTenKhachHang(tenKhachHang);
		khachhang.setGioiTinh(gioiTinh);
		khachhang.setDiaChi(diaChi);
		khachhang.setSoDienThoai(soDienThoai);
		khachhang.setEmail(email);
		khachhang.setGhiChu(ghiChu);
		boolean checkAdd = DAO_KhachHang.themKhachHang(khachhang);

		return checkAdd;
	}

	public static int xoaKhachHang(String s1) {
		// TODO Auto-generated method stub
		return DAO_KhachHang.xoaKhachHang(s1);
	}

	public static int suaKhachHang(String maKH, String tenKhachHang,
			String gioiTinh, String diaChi, String soDienThoai, String email,
			String ghiChu) {
		// TODO Auto-generated method stub
		return DAO_KhachHang.suaKhachHang(maKH, tenKhachHang, gioiTinh, diaChi,
				soDienThoai, email, ghiChu);
	}

}
