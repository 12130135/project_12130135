package controller;

import java.util.List;

import DAO.DAO_ThucDon;
import model.ThucDon;

public class Controller_ThucDon {

	public static List<ThucDon> timKiem(String search) {
		// TODO Auto-generated method stub
		return DAO_ThucDon.timkiem(search);
	}

	public static List<ThucDon> loadDatabase() {
		// TODO Auto-generated method stub
		return DAO_ThucDon.loadDatabase();
	}

	public static boolean themThucDon(String maMatHang, String tenMatHang,
			String donViTinh, double gia) {
		return DAO_ThucDon.themThucDon(maMatHang, tenMatHang, donViTinh, gia);
	}

}
