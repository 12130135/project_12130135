package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.KhachHang;

public class DAO_KhachHang {
	private final static Connection conn = ConnectDB.getConnection();

	public static List<KhachHang> loadDatabase() {
		String sql = "SELECT * FROM khachhang";
		Connection conn = null;
		ArrayList<KhachHang> danhsachKhachHang = new ArrayList<KhachHang>();
		try {
			conn = ConnectDB.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			// danh sach KH
			while (rs.next()) {
				// phương thức này vừa dể kiểm tra xem còn Khách hàng nào nữa
				// không
				KhachHang khachHang = new KhachHang();

				khachHang.setMaKhachHang(rs.getString(1));
				khachHang.setTenKhachHang(rs.getString(2));
				khachHang.setGioiTinh(rs.getString(3));
				khachHang.setDiaChi(rs.getString(4));
				khachHang.setSoDienThoai(rs.getString(5));
				khachHang.setEmail(rs.getString(6));
				khachHang.setGhiChu(rs.getString(7));

				danhsachKhachHang.add(khachHang);
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
		return danhsachKhachHang;
	}

	public static boolean themKhachHang(KhachHang khachHang) {
		String sql = "INSERT INTO khachhang (makhachhang, tenkhachhang, gioitinh, diachi, sodienthoai, email, ghichu ) VALUES (?, ?, ?, ?, ?, ?, ?)";
		Connection conn = null;
		boolean check = false;
		try {
			conn = ConnectDB.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, khachHang.getMaKhachHang());
			ps.setString(2, khachHang.getTenKhachHang());
			ps.setString(3, khachHang.getGioiTinh());
			ps.setString(4, khachHang.getDiaChi());
			ps.setString(5, khachHang.getSoDienThoai());
			ps.setString(6, khachHang.getEmail());
			ps.setString(7, khachHang.getGhiChu());
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

	public static boolean checkMaKhachHang(String check) {
		boolean checkMKH = false;
		String sql = "SELECT khachhang.makhachhang FROM khachhang WHERE khachhang.makhachhang =(?)";
		Connection conn = null;
		KhachHang result = new KhachHang();
		try {
			conn = ConnectDB.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, check);
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("+ Mã khách hàng: " + rs.getString(1)
						+ " đã tồn tại");
				checkMKH = true;
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
		return checkMKH;
	}

	public static int xoaKhachHang(String maKhachHang) {
		String sql = "DELETE FROM khachhang WHERE khachhang.makhachhang = (?)";
		Connection conn = null;
		boolean check = false;
		int result = -1;
		try {
			conn = ConnectDB.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, maKhachHang);
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

	public static int suaKhachHang(String maMH, String tenKhachHang,
			String gioitinh, String diachi, String sodienthoai, String email,
			String ghiChu) {
		String sql = " UPDATE khachhang SET tenkhachhang = ?,gioitinh = ?,diachi = ?,sodienthoai = ?,email = ?,ghichu = ? WHERE makhachhang = ?";
		Connection cn = null;
		int result = -1;
		try {
			cn = ConnectDB.getConnection();
			PreparedStatement ps = cn.prepareStatement(sql);

			ps.setString(7, maMH);
			ps.setString(1, tenKhachHang);
			ps.setString(2, gioitinh);
			ps.setString(3, diachi);
			ps.setString(4, sodienthoai);
			ps.setString(5, email);
			ps.setString(6, ghiChu);

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

	public static List<KhachHang> timKiem(String serch) {
		String sql = "SELECT * FROM khachhang WHERE khachhang.makhachhang LIKE'%"
				+ serch
				+ "%' OR khachhang.tenkhachhang LIKE'%"
				+ serch
				+ "%' OR khachhang.gioitinh LIKE'%"
				+ serch
				+ "%' OR khachhang.diachi LIKE'%"
				+ serch
				+ "%' OR khachhang.sodienthoai LIKE'%"
				+ serch
				+ "%' OR khachhang.email LIKE'%"
				+ serch
				+ "%' OR khachhang.ghichu LIKE'%" + serch + "%'";
		Connection cn = null;
		ArrayList<KhachHang> danhsachKhachHang = new ArrayList<KhachHang>();
		try {
			cn = ConnectDB.getConnection();
			PreparedStatement ps = cn.prepareStatement(sql);
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			// danh sach truyen
			while (rs.next()) {
				// phương thức này vừa dể kiểm tra xem còn hàng nào nữa không
				KhachHang KhachHang = new KhachHang();

				KhachHang.setMaKhachHang(rs.getString(1));
				KhachHang.setTenKhachHang(rs.getString(2));
				KhachHang.setGioiTinh(rs.getString(3));
				KhachHang.setDiaChi(rs.getString(4));
				KhachHang.setSoDienThoai(rs.getString(5));
				KhachHang.setEmail(rs.getString(6));
				KhachHang.setGhiChu(rs.getString(7));

				// add truyen vao danh sach
				danhsachKhachHang.add(KhachHang);
			}

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
		return danhsachKhachHang;
	}
}
