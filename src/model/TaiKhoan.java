package model;

import DAO.DAO_DangNhap_Impl;
import controller.DAO_DangNhap; 

public class TaiKhoan {
	private String user;
	private String pass;
	private String phanquyen;

	private static DAO_DangNhap dao = new DAO_DangNhap_Impl();

	public TaiKhoan() {
	}

	public TaiKhoan(String user, String pass) {
		super();
		this.user = user;
		this.pass = pass;
	}

	public TaiKhoan(String user, String pass, String phanquyen) {
		super();
		this.user = user;
		this.pass = pass;
		this.phanquyen = phanquyen;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getPhanquyen() {
		return phanquyen;
	}

	public void setPhanquyen(String phanquyen) {
		this.phanquyen = phanquyen;
	}

	public static boolean checkLogin(String user, String pass) {
		return dao.checkLogin(user, pass);
	}

	public String getPhanQuyen(String u) {
		System.out.println(dao.getPhanQuyen(u));
		return dao.getPhanQuyen(u);
	
	}

	public static boolean checkUser(String user) {
		return dao.checkUser(user);
	}
	
	public static boolean addUser(TaiKhoan taiKhoan){
		return dao.addUser(taiKhoan);
	}

	@Override
	public String toString() {
		String s = "+ User: " + this.user + ", Pass: " + this.pass;
		return s;
	}

}
