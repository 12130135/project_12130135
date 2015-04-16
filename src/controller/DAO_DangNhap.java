package controller;

import model.TaiKhoan;

public interface DAO_DangNhap {
	
	public boolean checkUser(String tenDangNhap);

	public boolean checkLogin(String tenDangNhap, String MatKhau);

	public boolean addUser(TaiKhoan taiKhoan);

	public TaiKhoan getUser(String Tendangnhap);

	public String getPhanQuyen(String TaiKhoan);

	public boolean setPassword(String tenDangNhap, String matKhau,
			String NewMatKhau);
}
