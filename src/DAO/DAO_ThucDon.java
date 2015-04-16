package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.MatHang;
import model.ThucDon;

public class DAO_ThucDon {

	public static List<ThucDon> timkiem(String search) {
		String sql = "SELECT * FROM thucdon WHERE thucdon.mamh LIKE'%" + search
				+ "%' OR thucdon.tenmh LIKE'%" + search
				+ "%' OR thucdon.donvitinh LIKE'%" + search
				+ "%' OR thucdon.giaban LIKE'%" + search + "%'";
		Connection conn = null;
		ArrayList<ThucDon> thucdon = new ArrayList<ThucDon>();
		try {
			conn = ConnectDB.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ThucDon td = new ThucDon();

				td.setMaMH(rs.getString(1));
				td.setTenMH(rs.getString(2));
				td.setDonViTinh(rs.getString(3));
				td.setGiaBan(rs.getDouble(4));

				// add truyen vao danh sach
				thucdon.add(td);
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
		return thucdon;
	}

	public static List<ThucDon> loadDatabase() {
		String sql = "SELECT * FROM thucdon";
		Connection conn = null;
		ArrayList<ThucDon> thucdon = new ArrayList<ThucDon>();
		try {
			conn = ConnectDB.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			// danh sach MH
			while (rs.next()) {
				// phương thức này vừa dể kiểm tra xem còn hàng nào nữa không
				ThucDon td = new ThucDon();

				td.setMaMH(rs.getString(1));
				td.setTenMH(rs.getString(2));
				td.setDonViTinh(rs.getString(3));
				td.setGiaBan(rs.getDouble(4));
				// add truyen vao danh sach
				thucdon.add(td);
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
		return thucdon;
	}

	public static boolean themThucDon(String maMatHang, String tenMatHang,
			String donViTinh, double gia) {
		String sql = "INSERT INTO thucdon (mamh, tenmh, donvitinh, giaban ) VALUES (?, ?, ?, ?)";
		Connection conn = null;
		boolean check = false;
		
		try {
			ThucDon thucdon = new ThucDon();
			conn = ConnectDB.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			
			ps.setString(1, maMatHang);
			ps.setString(2, tenMatHang);
			ps.setString(3, donViTinh);
			ps.setDouble(4, gia);
			
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

	public static boolean xoa(String s1) {
		String sql = "DELETE FROM thucdon WHERE thucdon.mamh = (?)";
		Connection conn = null;
		boolean check = false;
		int result = -1;
		try {
			conn = ConnectDB.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, s1);
			System.out.println(ps);
			result = ps.executeUpdate();
			if(result ==1){
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
	public static void main(String[] args) {
//		themThucDon("1", "huong khung", "kg", 2);
		xoa("12");
	}

}
