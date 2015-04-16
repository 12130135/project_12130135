package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Properties;

import javax.swing.JOptionPane;

public class ConnectDB {
	private static volatile ConnectDB instance = null;

	public static Connection getConnection() {
		String url = "jdbc:mysql://localhost/project_tkhdt?setUnicode=true&characterEncoding=UTF-8";
		String user = "root";
		String psw = "";
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Properties props = new Properties();
			props.put("charSet", "UTF-8");

			con = DriverManager.getConnection(url, user, psw);
		} catch (Exception e) {
			System.out.println("+ Kết nối database thất bại!");
		}
		System.out.println("+ Connect đến Database Thành Công!.");
		return con;
	}

	public static ConnectDB getInstance(){
		if(instance == null){
			synchronized (ConnectDB.class) {
				instance = new ConnectDB();
			}
		}
		return instance;
	}

	public static void disConnect() {
		Connection conn = null;
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// try {
		// ConnectDB obj = new ConnectDB();
		// // obj.taoKetNoiKieu3();
		// obj.openConnetion();
		// obj.getConnection();
		// System.out.println("+ Connect with Database Complete!!!");
		// } catch (SQLException e) {
		// e.printStackTrace();
		// }
	}

}