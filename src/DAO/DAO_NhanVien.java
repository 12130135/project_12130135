package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.KhachHang;
import model.NhanVien;

public class DAO_NhanVien {
	private final static Connection conn = ConnectDB.getConnection();

	public static List<NhanVien> loadDatabase() {
		String sql = "SELECT * FROM nhanvien";
		Connection conn = null;
		ArrayList<NhanVien> danhsachNhanVien = new ArrayList<NhanVien>();
		try {
			conn = ConnectDB.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			// danh sach NV
			while (rs.next()) {
				// phương thức này vừa dể kiểm tra xem còn Nhân Viên nào nữa
				// không
				NhanVien nhanVien = new NhanVien();

				nhanVien.setMnv(rs.getString(1));
				nhanVien.setHoten(rs.getString(2));
				nhanVien.setSocmnd(rs.getString(3));
				nhanVien.setGioitinh(rs.getString(4));
				nhanVien.setNgaysinh(rs.getString(5));
				nhanVien.setSdt(rs.getString(6));
				nhanVien.setDiachi(rs.getString(7));

				danhsachNhanVien.add(nhanVien);
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
		return danhsachNhanVien;
	}

	public static boolean themNhanVien(NhanVien nhanVien) {
		String sql = "INSERT INTO nhanvien (manhanvien, tennhanvien, socmnd, gioitinh, ngaysinh, sodienthoai, diachi ) VALUES (?, ?, ?, ?, ?, ?, ?)";
		Connection conn = null;
		boolean check = false;
		try {
			conn = ConnectDB.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, nhanVien.getMnv());
			ps.setString(2, nhanVien.getHoten());
			ps.setString(3, nhanVien.getSocmnd());
			ps.setString(4, nhanVien.getGioitinh());
			ps.setString(5, nhanVien.getNgaysinh());
			ps.setString(6, nhanVien.getSdt());
			ps.setString(7, nhanVien.getDiachi());
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

	public static boolean checkMaNhanVien(String check) {
		boolean checkMNV = false;
		String sql = "SELECT nhanvien.manhanvien FROM nhanvien WHERE nhanvien.manhanvien =(?)";
		Connection conn = null;
		NhanVien result = new NhanVien();
		try {
			conn = ConnectDB.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, check);
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("+ Mã nhân viên: " + rs.getString(1)
						+ " đã tồn tại");
				checkMNV = true;
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
		return checkMNV;
	}

	public static int xoaNhanVien(String maNhanVien) {
		String sql = "DELETE FROM nhanvien WHERE nhanvien.manhanvien = (?)";
		Connection conn = null;
		boolean check = false;
		int result = -1;
		try {
			conn = ConnectDB.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, maNhanVien);
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

	public static int suaNhanVien(String maNhanVien, String tenNhanVien,
			String soCMND, String gioiTinh, String ngaySinh,
			String soDienThoai, String diaChi) {
		String sql = " UPDATE nhanvien SET tennhanvien = ?,socmnd = ?,gioitinh = ?,ngaysinh = ?,sodienthoai = ?,diachi = ? WHERE manhanvien = ?";
		Connection cn = null;
		int result = -1;
		try {
			cn = ConnectDB.getConnection();
			PreparedStatement ps = cn.prepareStatement(sql);

			ps.setString(7, maNhanVien);
			ps.setString(1, tenNhanVien);
			ps.setString(2, soCMND);
			ps.setString(3, gioiTinh);
			ps.setString(4, ngaySinh);
			ps.setString(5, soDienThoai);
			ps.setString(6, diaChi);

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

	public static List<NhanVien> timKiem(String serch) {
		String sql = "SELECT * FROM nhanvien WHERE nhanvien.manhanvien LIKE'%"
				+ serch + "%' OR nhanvien.tennhanvien LIKE'%" + serch
				+ "%' OR nhanvien.socmnd LIKE'%" + serch
				+ "%' OR nhanvien.gioitinh LIKE'%" + serch
				+ "%' OR nhanvien.ngaysinh LIKE'%" + serch
				+ "%' OR nhanvien.sodienthoai LIKE'%" + serch
				+ "%' OR nhanvien.diachi LIKE'%" + serch + "%'";
		Connection cn = null;
		ArrayList<NhanVien> danhsachNhanVien = new ArrayList<NhanVien>();
		try {
			cn = ConnectDB.getConnection();
			PreparedStatement ps = cn.prepareStatement(sql);
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			// danh sach truyen
			while (rs.next()) {
				// phương thức này vừa dể kiểm tra xem còn hàng nào nữa không
				NhanVien nhanVien = new NhanVien();

				nhanVien.setMnv(rs.getString(1));
				nhanVien.setHoten(rs.getString(2));
				nhanVien.setSocmnd(rs.getString(3));
				nhanVien.setGioitinh(rs.getString(4));
				nhanVien.setNgaysinh(rs.getString(5));
				nhanVien.setSdt(rs.getString(6));
				nhanVien.setDiachi(rs.getString(7));

				// add truyen vao danh sach
				danhsachNhanVien.add(nhanVien);
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
		return danhsachNhanVien;
	}
	// public static void main(String[] args) {
	// DAO_NhanVien dao = new DAO_NhanVien();
	// dao.suaNhanVien("11", "tenNhanVien", "gioitinh", "diachi", "sodienthoai",
	// "email", "chucVu", "ghiChu");
	// }
}
