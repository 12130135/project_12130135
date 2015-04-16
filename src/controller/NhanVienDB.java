package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DAO.ConnectDB;

import model.ThongTinNhanVien;

public class NhanVienDB {

	public static  ResultSet getdata(){
		ResultSet rs=null;
		String sqlCommand="select * from thongtinnv  ";
		PreparedStatement pst;
		try {
			pst=ConnectDB.getConnection().prepareStatement(sqlCommand);
			
			rs=pst.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
		
	}
	public static void  deleteID(String id){
		String sqlCommand="delete  from thongtinnv where  mnv = ? ";
		PreparedStatement pst;
		try {
			pst=ConnectDB.getConnection().prepareStatement(sqlCommand);
			pst.setString(1, id);
		
			if(pst.executeUpdate()>0){
			System.out.println("delete thành công");
			} else System.out.println("delete ko thanh cong");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString()+"delete ko thanh cong");
			e.printStackTrace();
		}
	}
	public static void  insert(ThongTinNhanVien s){
		String sqlCommand=" insert into thongtinnv value (?,?,?,?,?,?,?) ";
		PreparedStatement pst;
		try {
			pst=ConnectDB.getConnection().prepareStatement(sqlCommand);
			pst.setString(1, s.getMnv());
			pst.setString(2, s.getHoten());
			pst.setString(3, s.getNgaysinh());
			pst.setString(4,s.getGioitinh() );
			pst.setString(5, s.getSocmnd());
			pst.setString(6, s.getSdt());
			pst.setString(7, s.getDiachi());
			if(pst.executeUpdate()>0){
			System.out.println("intsert thành công");
			} else System.out.println("delete ko thanh cong");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("delete ko thanh cong");
			e.printStackTrace();
		}
	}
		public static void  updateID(String mnv,ThongTinNhanVien s){
			String sqlCommand=" update thongtinnv set ten = ?, ngaysinh = ? , gioitinh = ? , socmnd =? , sodienthoai =? , diachi =?  where mnv = ? ";
			PreparedStatement pst;
			try {
				pst=ConnectDB.getConnection().prepareStatement(sqlCommand);
				
				pst.setString(1, s.getHoten());
				pst.setString(2, s.getNgaysinh());
				pst.setString(3,s.getGioitinh() );
				pst.setString(4, s.getSocmnd());
				pst.setString(5, s.getSdt());
				pst.setString(6, s.getDiachi());
				pst.setString(7,mnv);
				
				
				if(pst.executeUpdate()>0){
				System.out.println("update thành công");
				} else System.out.println("update ko thanh cong");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("update ko thanh cong");
				e.printStackTrace();
			}
		}
		public static ResultSet search(String s){
			ResultSet rs=null;
//			String sql=" select * from nhanvien where mnv like ?  ";
			String sql="select mnv,ten,socmnd,gioitinh,ngaysinh,diachi,sodienthoai from thongtinnv where match(mnv,ten,socmnd,gioitinh,ngaysinh,diachi,sodienthoai) against(?)";
			try {
				PreparedStatement pst=ConnectDB.getConnection().prepareStatement(sql);
				pst.setString(1, s);
			 rs=pst.executeQuery();
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return rs;
			
		}
		public static ResultSet timKiem(String serch) {
//			String sql = "SELECT * FROM thongtinnv WHERE mnv LIKE'%"
//					+ serch + "%' OR ten LIKE'%" + serch
//					+ "%' OR socmnd LIKE'%" + serch
//					+ "%' OR gioitinh LIKE'%" + serch
//					+ "%' OR ngaysinh LIKE'%" + serch
//					+ "%' OR sodienthoai LIKE'%" + serch
//					+ "%' OR diachi LIKE'%" + serch + "%'";
			String sql = "SELECT * FROM thongtinnv WHERE mnv LIKE ? or ten like ? or socmnd like ? or gioitinh like ? or ngaysinh like ? or sodienthoai like ? or diachi like ?   " ;
					
			
			
			
			ResultSet rs=null;
			
			PreparedStatement pst ;
			try {
				
				pst=ConnectDB.getConnection().prepareStatement(sql);
				pst.setString(1,"%"+serch+"%" );
				pst.setString(2,"%"+serch+"%" );
				pst.setString(3,"%"+serch+"%" );
				pst.setString(4,"%"+serch+"%" );
				pst.setString(5,"%"+serch+"%" );
				pst.setString(6,"%"+serch+"%" );
				pst.setString(7,"%"+serch+"%" );
				rs=pst.executeQuery();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return rs;
			
			
		}
		public static  boolean check(String s){
			ResultSet rs=null;
			String sqlCommand="select mnv from thongtinnv  ";
			PreparedStatement pst;
			try {
				pst=ConnectDB.getConnection().prepareStatement(sqlCommand);
				rs=pst.executeQuery();
				while(rs.next()){
					if(rs.getString(1).equals(s)){
						return true;
					}
				}
				
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
			
			
			
		}
	public static void main(String[] args) {
		System.out.println(check("15"));
		
//		getdata ();
	}
}
