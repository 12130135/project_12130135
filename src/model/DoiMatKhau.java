package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DAO.ConnectDB;
import controller.DAO_DangNhap;

public class DoiMatKhau {
	static Connection con = null;
	static PreparedStatement ps;
	ResultSet rs;

	public static boolean doiMatKhau(String user, String pass) throws Exception {
		if (TaiKhoan.checkUser(user)) {
			String sql = "UPDATE taikhoan SET matkhau='" + pass
					+ "' WHERE tendangnhap = '" + user + "'";
			con = ConnectDB.getConnection();
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			return true;

		} else {
			// System.out.println("false");
			return false;
		}
	}
}
