package controller;

import java.util.List;

import model.NhanVien;
import model.NhanVien;
import DAO.DAO_KhachHang;
import DAO.DAO_NhanVien;

public class Controller_NhanVien {

	public static List<NhanVien> loadDatabase() {
		return DAO_NhanVien.loadDatabase();
	}

	public static List<NhanVien> timKiem(String serch) {
		return DAO_NhanVien.timKiem(serch);
	}

	public static boolean checkMaNhanVien(String check) {
		return DAO_NhanVien.checkMaNhanVien(check);
	}

	public static boolean themNV(String maNV, String tenNhanVien,
			String socmnd, String gioitinh, String ngaysinh,
			String sodienthoai, String diachi) {

		NhanVien nhanVien = new NhanVien();

		nhanVien.setMnv(maNV);
		nhanVien.setHoten(tenNhanVien);
		nhanVien.setSocmnd(socmnd);
		nhanVien.setGioitinh(gioitinh);
		nhanVien.setNgaysinh(ngaysinh);
		nhanVien.setSdt(sodienthoai);
		nhanVien.setDiachi(diachi);
		boolean checkAdd = DAO_NhanVien.themNhanVien(nhanVien);
		return checkAdd;
	}

	public static int xoaNhanVien(String s1) {
		return DAO_NhanVien.xoaNhanVien(s1);
	}

	public static int suaNhanVien(String maNV, String tenNhanVien,
			String soCMND, String gioiTinh, String ngaySinh,
			String soDienThoai, String diaChi) {
		// TODO Auto-generated method stub
		return DAO_NhanVien.suaNhanVien(maNV, tenNhanVien, soCMND, gioiTinh,
				ngaySinh, soDienThoai, diaChi);
	}

}
