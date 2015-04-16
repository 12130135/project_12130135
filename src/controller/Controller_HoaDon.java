package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JTextField;

import DAO.ConnectDB;
import DAO.DAO_HoaDon;
import model.HoaDon;

public class Controller_HoaDon {

	public static List<HoaDon> loadDatabase_1() {

		return DAO_HoaDon.loadDatabase();
	}

	public static boolean checkMaHoaDon(String maMH) {
		return DAO_HoaDon.checkMaHoaDon(maMH);
	}

	public static int laySoLuong(String maMH) {
		// TODO Auto-generated method stub
		return DAO_HoaDon.laySoLuong(maMH);
	}

	public static int updateSoLuong(String maMH, int i) {
		return DAO_HoaDon.updateSoLuong(maMH, i);

	}

	public static boolean themHD(String maMH, String tenMH, int soluong,
			String donvitinh, double gia, double thanhtien, String id_ban,
			String ngay, String makhachhang) {
		return DAO_HoaDon.themHD(maMH, tenMH, soluong, donvitinh, gia,
				thanhtien, id_ban, ngay, makhachhang);
	}

	public static double thanhtoan() {
		return HoaDon.thanhtoan();
	}

	public static int xoaHD(String maMHHD) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM hoadon_1 WHERE hoadon_1.mamathang = (?)";
		Connection conn = null;
		boolean check = false;
		int result = -1;
		try {
			conn = ConnectDB.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, maMHHD);
			System.out.println(ps);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

}
