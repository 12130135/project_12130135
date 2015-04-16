package controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JTable;

import view.Panel_Button_AllTextField_MatHang;
import view.QL_MatHang_Panel;
import DAO.DAO_MatHang;
import model.MatHang;

public class Controller_MatHang {

	public static List<MatHang> loadDatabase() {
		return DAO_MatHang.loadDatabase();
	}

	public static boolean checkMaMatHang(String check) {
		return DAO_MatHang.checkMaMatHang(check);
	}

	public static String taoMaMatHang() {
		return DAO_MatHang.taoKhoaChinh();
	}

	public static boolean themMH(String maMH, String tenMatHang, double gia,
			String donViTinh, int soLuong, String nhomHang, String ngay,
			String nhaCungCap) {

		MatHang matHang = new MatHang();

		matHang.setMaMatHang(maMH);
		matHang.setTenMatHang(tenMatHang);
		matHang.setGiaMatHang(gia);
		matHang.setDonViTinh(donViTinh);
		matHang.setSoLuong(soLuong);
		matHang.setNhomHang(nhomHang);
		matHang.setNgayNhap(ngay);
		matHang.setNhaCungCap(nhaCungCap);
		boolean checkAdd = DAO_MatHang.themMatHang(matHang);

		return checkAdd;
	}

	public static int xoaMatHang(String maMatHang) {
		return DAO_MatHang.xoaMatHang(maMatHang);
	}

	public static int suaMatHang(String maMH, String tenMatHang, double gia,
			String donViTinh, int soluong, String nhomHang, String ngay,
			String nhaCungCap) {
		// TODO Auto-generated method stub
		return DAO_MatHang.suaMatHang(maMH, tenMatHang, gia, donViTinh,
				soluong, nhomHang, ngay, nhaCungCap);
	}

	public static List<MatHang> timKiem(String serch) {
		// TODO Auto-generated method stub
		return DAO_MatHang.timKiem(serch);
	}

	public static boolean checkMaKhachHang(String text) {
		// TODO Auto-generated method stub
		return false;
	}

	public static boolean themMH(String maKH, String tenKhachHang,
			String gioiTinh, String diaChi, String soDienThoai, String email,
			String ghiChu) {
		// TODO Auto-generated method stub
		return false;
	}
}
