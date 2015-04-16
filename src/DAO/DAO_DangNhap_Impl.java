package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import controller.DAO_DangNhap;
import model.TaiKhoan;

public class DAO_DangNhap_Impl implements DAO_DangNhap {

	// kiểm tra tên đăng nhập
	public boolean checkUser(String tenDangNhap) {

		boolean checkTenDangNhap = false;
		String sql = "SELECT taikhoan.tendangnhap FROM taikhoan WHERE taikhoan.tendangnhap = (?)";
		Connection conn = null;

		conn = ConnectDB.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, tenDangNhap);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("+ Check thành công với Tên Đăng Nhập: "
						+ rs.getString("tendangnhap"));
				checkTenDangNhap = true;
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
		return checkTenDangNhap;
	}

	// kiểm tra đăng nhập
	public boolean checkLogin(String tenDangNhap, String MatKhau) {
		boolean checkTenDangNhap = false;
		String sql = "SELECT * FROM taikhoan WHERE taikhoan.tendangnhap = (?) AND taikhoan.matkhau = (?)";
		Connection conn = null;
		conn = conn = ConnectDB.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, tenDangNhap);
			ps.setString(2, MatKhau);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				System.out.println("+ Check thành công Đăng Nhập: "
						+ rs.getString("tendangnhap") + ", "
						+ rs.getString("matkhau"));
				checkTenDangNhap = true;
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
		return checkTenDangNhap;
	}

	// phuong thuc 1 cap them tai khoản
	public boolean addUser(TaiKhoan taiKhoan) {
		try {
			Statement stmt = ConnectDB.getConnection().createStatement();
			if (!checkUser(taiKhoan.getUser())) {
				String sql = "INSERT INTO taikhoan (tendangnhap,matkhau,phanquyen) VALUES ( '"
						+ taiKhoan.getUser()
						+ "', '"
						+ taiKhoan.getPass()
						+ "', '" + taiKhoan.getPhanquyen() + "')";
				int res = stmt.executeUpdate(sql);
				if (res != 0) {
					stmt.close();
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	// lấy database để đăng nhập

	public TaiKhoan getUser(String Tendangnhap) {
		String sql = "SELECT * FROM DangNhapQuanTri WHERE Tendangnhap =?";
		TaiKhoan result = new TaiKhoan();
		Connection cn = null;
		try {
			cn = ConnectDB.getConnection();
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, Tendangnhap);// em them dau nhay
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				result.setPass(rs.getString(2));
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
		return result;
	}

	@Override
	public String getPhanQuyen(String TaiKhoan) {
		return getUser(TaiKhoan).getPhanquyen();
	}

	@Override
	public boolean setPassword(String tenDangNhap, String matKhau,
			String NewMatKhau) {
		// TODO Auto-generated method stub
		return false;
	}

	public static boolean doiMatKhau(String user, String pass) throws Exception {
		if (TaiKhoan.checkUser(user)) {
			String sql = "UPDATE taikhoan SET matkhau='" + pass
					+ "' WHERE tendangnhap = '" + user + "'";
			Connection con = ConnectDB.getConnection();
			PreparedStatement ps;
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		// test từng phương thức!
		// 1. Check Tên Tài Khoản
		DAO_DangNhap_Impl dn = new DAO_DangNhap_Impl();
		boolean check = false;
		// check = dn.kiemtraTenDangNhap("thien");
		// System.out.println(check);

		// 2. Check Tài Khoản
		// check = dn.kiemTraDangNhap("thien", "123456");
		// System.out.println(check);

		// 3.thêm Tài khoản
		TaiKhoan tk = new TaiKhoan();
		tk.setUser("admin");
		tk.setPass("123456");
		tk.setPhanquyen("1");
		boolean i = dn.addUser(tk);
		if (i == false) {
			System.out.println("- Tên tài Đăng nhập đã tồn tại!");
		} else {
			System.out.println("- Thêm tài khoản thành công");
		}
	}

}
