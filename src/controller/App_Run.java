package controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import view.MainFrame;
import view.V_DangNhap;

public class App_Run {
	public final static V_DangNhap dangNhap = new V_DangNhap();// trong pakege
																// view
	static String text_User;

	public static void main(String[] args) {
		dangNhap.setVisible(true);
		DateFormat ngaygio = new SimpleDateFormat("YYYY-MM-DD hh:mm:ss");
		Date date = new Date();
		String day = ngaygio.format(date);
		System.out.println("thoi gian he thong la:" + (day));
		System.out.println("done");
		System.out.println("+ Run điều hướng có Username: " + text_User);
	}
}
