package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import model.MatHang;
import model.TaiKhoan;

public class DAO_MatHang {
	private final static Connection conn = ConnectDB.getConnection();

	public static List<MatHang> loadDatabase() {
		String sql = "SELECT * FROM mathang";
		Connection conn = null;
		ArrayList<MatHang> danhsachMatHang = new ArrayList<MatHang>();
		try {
			conn = ConnectDB.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			// danh sach MH
			while (rs.next()) {
				// phương thức này vừa dể kiểm tra xem còn hàng nào nữa không
				MatHang matHang = new MatHang();

				matHang.setMaMatHang(rs.getString(1));
				matHang.setTenMatHang(rs.getString(2));
				matHang.setGiaMatHang(rs.getDouble(3));
				matHang.setDonViTinh(rs.getString(4));
				matHang.setSoLuong(rs.getInt(5));
				matHang.setNhomHang(rs.getString(6));
				matHang.setNgayNhap(rs.getString(7));
				matHang.setNhaCungCap(rs.getString(8));

				// add truyen vao danh sach
				danhsachMatHang.add(matHang);
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
		return danhsachMatHang;
	}

	public static boolean themMatHang(MatHang matHang) {
		String sql = "INSERT INTO mathang (mamathang, tenmathang, giamathang, donvitinh, soluong, nhomhang, ngaynhap, nhacungcap ) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		Connection conn = null;
		boolean check = false;
		try {
			conn = ConnectDB.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, matHang.getMaMatHang());
			ps.setString(2, matHang.getTenMatHang());
			ps.setDouble(3, matHang.getGiaMatHang());
			ps.setString(4, matHang.getDonViTinh());
			ps.setInt(5, matHang.getSoLuong());
			ps.setString(6, matHang.getNhomHang());
			ps.setString(7, matHang.getNgayNhap());
			ps.setString(8, matHang.getNhaCungCap());
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

	public static boolean checkMaMatHang(String check) {
		boolean checkMMH = false;
		String sql = "SELECT mathang.mamathang FROM mathang WHERE mathang.mamathang =(?)";
		Connection conn = null;
		MatHang result = new MatHang();
		try {
			conn = ConnectDB.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, check);
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				System.out.println("+ Mã mặt hàng: " + rs.getString(1)
						+ " đã tồn tại");
				checkMMH = true;
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
		return checkMMH;
	}

	public static String taoKhoaChinh() {
		boolean checkMMH = false;
		String sql = "SELECT mathang.mamathang FROM mathang";
		Connection conn = null;
		try {
			conn = ConnectDB.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			boolean cuoicung = rs.last();
			// System.out.println(rs.getString(1).);
			// while (rs.last()) {
			// System.out.println("+ Lấy: " + rs.getString("mamathang"));
			// }

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public static int xoaMatHang(String maMatHang) {
		String sql = "DELETE FROM mathang WHERE mathang.mamathang = (?)";
		Connection conn = null;
		boolean check = false;
		int result = -1;
		try {
			conn = ConnectDB.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, maMatHang);
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

	public static int suaMatHang(String maMH, String tenMatHang, double gia,
			String donViTinh, int soluong, String nhomHang, String ngay,
			String nhaCungCap) {
		String sql = " UPDATE mathang SET tenmathang = ?,giamathang = ?,donvitinh = ?,soluong = ?,nhomhang = ?,ngaynhap = ?,nhacungcap = ? WHERE mamathang = ?";
		Connection cn = null;
		int result = -1;
		try {
			cn = ConnectDB.getConnection();
			PreparedStatement ps = cn.prepareStatement(sql);

			ps.setString(8, maMH);
			ps.setString(1, tenMatHang);
			ps.setDouble(2, gia);
			ps.setString(3, donViTinh);
			ps.setInt(4, soluong);
			ps.setString(5, nhomHang);
			ps.setString(6, ngay);
			ps.setString(7, nhaCungCap);

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

	public static List<MatHang> timKiem(String serch) {
		String sql = "SELECT * FROM mathang WHERE mathang.mamathang LIKE'%"
				+ serch + "%' OR mathang.tenmathang LIKE'%" + serch
				+ "%' OR mathang.giamathang LIKE'%" + serch
				+ "%' OR mathang.donvitinh LIKE'%" + serch
				+ "%' OR mathang.soluong LIKE'%" + serch
				+ "%' OR mathang.nhomhang LIKE'%" + serch
				+ "%' OR mathang.ngaynhap LIKE'%" + serch
				+ "%' OR mathang.nhacungcap LIKE'%" + serch + "%'";
		Connection cn = null;
		ArrayList<MatHang> danhsachMatHang = new ArrayList<MatHang>();
		try {
			cn = ConnectDB.getConnection();
			PreparedStatement ps = cn.prepareStatement(sql);
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			// danh sach truyen
			while (rs.next()) {
				// phương thức này vừa dể kiểm tra xem còn hàng nào nữa không
				MatHang matHang = new MatHang();

				matHang.setMaMatHang(rs.getString(1));
				matHang.setTenMatHang(rs.getString(2));
				matHang.setGiaMatHang(rs.getDouble(3));
				matHang.setDonViTinh(rs.getString(4));
				matHang.setSoLuong(rs.getInt(5));
				matHang.setNhomHang(rs.getString(6));
				matHang.setNgayNhap(rs.getString(7));
				matHang.setNhaCungCap(rs.getString(8));

				// add truyen vao danh sach
				danhsachMatHang.add(matHang);
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
		return danhsachMatHang;
	}

	public static void main(String[] args) {
		MatHang matHang = new MatHang();
		matHang.setMaMatHang("104");
		matHang.setTenMatHang("Thiện");
		matHang.setGiaMatHang(2.0);
		matHang.setDonViTinh("Kg");
		matHang.setSoLuong(1);
		matHang.setNhomHang("a");
		matHang.setNgayNhap("12/3/2014");
		matHang.setNhaCungCap("B");
		// boolean check = new DAO_MatHang().themMatHang(matHang);
		// System.out.println(check);

		// boolean check = new DAO_MatHang().checkMaMatHang("105");
		// System.out.println(check);

		// int i = xoaMatHang("108");
		// System.out.println(i);

		int i = suaMatHang(matHang.getMaMatHang(), matHang.getTenMatHang(),
				matHang.getGiaMatHang(), matHang.getDonViTinh(),
				matHang.getSoLuong(), matHang.getNhomHang(),
				matHang.getNgayNhap(), matHang.getNhaCungCap());
		System.out.println(i);

	}

}
