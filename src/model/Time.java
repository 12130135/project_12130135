package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {
	public static String layThoiGian() {
		DateFormat ngaygio = new SimpleDateFormat("hh:mm:ss - DD-MM-YYYY");
		Date date = new Date();
		String day = ngaygio.format(date);
		return day;
	}
	public static void main(String[] args) {
		System.out.println(layThoiGian());
	}
}
