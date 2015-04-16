package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import view.DatBan_Panel;
import model.HoaDon;
import model.MatHang;

public class DAO_HoaDon {

	public static List<HoaDon> loadDatabase() {
		String sql = "SELECT * FROM hoadon_1";
		Connection conn = null;
		ArrayList<HoaDon> danhsachHoaDon = new ArrayList<HoaDon>();
		try {
			conn = ConnectDB.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			// danh sach MH
			while (rs.next()) {
				// phương thức này vừa dể kiểm tra xem còn hàng nào nữa không
				HoaDon hoaDon = new HoaDon();

				hoaDon.setMaMatHang(rs.getString(1));
				hoaDon.setTenMatHang(rs.getString(2));
				hoaDon.setSoLuong(rs.getInt(3));
				hoaDon.setDonViTinh(rs.getString(4));
				hoaDon.setGia(rs.getDouble(5));
				hoaDon.setThanhtien(rs.getDouble(6));
				hoaDon.setId_Ban(rs.getString(7));
				hoaDon.setNgay(rs.getString(8));
				hoaDon.setMaKhachHang(rs.getString(9));

				// add truyen vao danh sach
				danhsachHoaDon.add(hoaDon);
			}

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
		return danhsachHoaDon;
	}

	public static boolean checkMaHoaDon(String maMH) {
		boolean check = false;
		String sql = "SELECT hoadon_1.mamathang FROM hoadon_1 WHERE hoadon_1.mamathang = (?)";
		Connection conn = null;

		conn = conn = ConnectDB.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, maMH);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("+ Check thành công với MÃ Hoá Đơn: "
						+ rs.getString("mamathang"));
				check = true;
			}
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
		return check;
	}

	public static int laySoLuong(String maMH) {
		int soluong = 0;
		String sql = "SELECT hoadon_1.soluong FROM hoadon_1 WHERE hoadon_1.mamathang = (?)";
		Connection conn = null;

		conn = conn = ConnectDB.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, maMH);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("+ Lấy số lượng: " + rs.getInt("soluong"));
				soluong = rs.getInt("soluong");
			}
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
		return soluong;
	}

	public static int updateSoLuong(String maMH, int i) {
		HoaDon hd = new HoaDon();
		hd = layHoaDon(maMH);

		String maMatHang = hd.getMaMatHang();
		String tenMatHang = hd.getTenMatHang();
		int soluong = hd.getSoLuong();
		String donvitinh = hd.getDonViTinh();
		double gia = hd.getGia();
		double thanhtien = hd.getThanhtien();
		String idban = hd.getId_Ban();
		String ngay = hd.getNgay();
		String maKhachHang = hd.getMaKhachHang();

//		int sl = soluong + 1;
		double tt = i * gia;

		String maBan = DatBan_Panel.getTf_maKH_HD_1().getText();
		String ngay_2 = DatBan_Panel.getDatePicker_1().getJFormattedTextField()
				.getText().trim();
		String maKH_a = DatBan_Panel.getTf_maKH_HD_1().getText();

		int abc = updateHoaDon(maMatHang, tenMatHang, i, donvitinh, gia, tt,
				maBan, ngay_2, maKH_a);

		return abc;
	}

	public static int updateHoaDon(String maMatHang, String tenMatHang, int sl,
			String donvitinh, double gia, double tt, String idban, String ngay,
			String maKhachHang) {
		String sql = " UPDATE hoadon_1 SET hoadon_1.tenmathang = ?,hoadon_1.soluong = ?,hoadon_1.donvitinh = ?,hoadon_1.gia = ?,hoadon_1.thanhtien = ?,hoadon_1.id_ban = ?,hoadon_1.ngay = ?,hoadon_1.makhachhang = ? WHERE hoadon_1.mamathang = ?";
		Connection cn = null;
		int result = -1;
		try {
			cn = ConnectDB.getConnection();
			PreparedStatement ps = cn.prepareStatement(sql);

			ps.setString(9, maMatHang);
			ps.setString(1, tenMatHang);
			ps.setInt(2, sl);
			ps.setString(3, donvitinh);
			ps.setDouble(4, gia);
			ps.setDouble(5, tt);
			ps.setString(6, idban);
			ps.setString(7, ngay);
			ps.setString(8, maKhachHang);

			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				cn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	private static HoaDon layHoaDon(String maMH) {
		boolean check = false;
		String sql = "SELECT * FROM hoadon_1 WHERE hoadon_1.mamathang = (?)";
		Connection conn = ConnectDB.getConnection();
		HoaDon hd = new HoaDon();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, maMH);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				hd.setMaMatHang(rs.getString("mamathang"));
				hd.setTenMatHang((rs.getString("tenmathang")));
				hd.setSoLuong((Integer.parseInt(rs.getString("soluong"))));
				hd.setDonViTinh((rs.getString("donvitinh")));
				hd.setGia((Double.parseDouble(rs.getString("gia"))));
				hd.setThanhtien((Double.parseDouble(rs.getString("thanhtien"))));
				hd.setId_Ban((rs.getString("id_ban")));
				hd.setNgay((rs.getString("ngay")));
				hd.setMaKhachHang((rs.getString("makhachhang")));
			}
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
		return hd;
	}

	public static boolean themHD(String maMH, String tenMH, int soluong,
			String donvitinh, double gia, double thanhtien, String id_ban,
			String ngay, String makhachhang) {

		String sql = "INSERT INTO hoadon_1 (mamathang, tenmathang, soluong, donvitinh, gia, thanhtien, id_ban, ngay, makhachhang ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Connection conn = null;
		boolean check = false;
		try {
			conn = ConnectDB.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, maMH);
			ps.setString(2, tenMH);
			ps.setInt(3, soluong);
			ps.setString(4, donvitinh);
			ps.setDouble(5, gia);
			ps.setDouble(6, thanhtien);
			ps.setString(7, id_ban);
			ps.setString(8, ngay);
			ps.setString(9, makhachhang);

			System.out.println(ps);

			int res = ps.executeUpdate();
			if (res != 0) {
				check = true;
			}
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
		return check;
	}

	public static double thanhtoan() {
		double abc = 0;
		String sql = "SELECT hoadon_1.thanhtien FROM hoadon_1 ";
		Connection conn = ConnectDB.getConnection();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				double a = rs.getDouble("thanhtien");
				abc = abc + a;
			}
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
		return abc;
	}

	public static void xoaHD() {
		String sql = "DELETE * From hoadon_1 ";

		Connection conn = ConnectDB.getConnection();

		try {
			Statement ps = conn.createStatement();
			ps.execute(sql);
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
	}

	public static void main(String[] args) {
		// int i = updateSoLuong("12", 1);
		// int y = updateHoaDon("12", "thien", 2, "kg", 515, 51, "Bàn 1",
		// "20/1/2015", "12");
		// int i = laySoLuong("12");
		// System.out.println(i);
		// HoaDon hd = layHoaDon("12");
		// System.out.println(hd.toString());

//		double abc = thanhtoan();
//		System.out.println(abc);
		
		xoaHD();
	}

}
