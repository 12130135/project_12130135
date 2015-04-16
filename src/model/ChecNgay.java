package model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

public class ChecNgay {
	private static final SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");

	public static String now() {
		Date d = new Date(System.currentTimeMillis());
		return f.format(d);
	}
	@SuppressWarnings("deprecation")
	public static String now1() {
		Date d = new Date(System.currentTimeMillis());
		return f.format(new Date(d.getYear(), d.getMonth(), d.getDate()));
	}


	public static boolean ktNgay(String stringNgay) {
			StringTokenizer st2 = new StringTokenizer(stringNgay, "-/");
			String ngay="", thang="", nam="";
			ngay = st2.nextToken();
			thang = st2.nextToken();
			nam = st2.nextToken();
			int n=0;
			int thangTmp=0;
			try{
			n = Integer.parseInt((nam + "").substring(2,
					(nam + "").length())) + 100;
			thangTmp = Integer.parseInt(thang) - 1;
			}catch (Exception e){
				e.printStackTrace();
				return false;
			}
			@SuppressWarnings("deprecation")
			Date d = new Date(n, thangTmp, Integer.parseInt(ngay));
			if(d.before(new Date(System.currentTimeMillis()))) return false;
		return true;
	}
	
	@SuppressWarnings("deprecation")
	public static boolean kTra2Ngay(String d1, String d2){
		Date da = new Date(Integer.parseInt(getNgay(d1))-1, Integer.parseInt(getThang(d1)), Integer.parseInt(getNam(d1)));
		Date db = new Date(Integer.parseInt(getNgay(d2)), Integer.parseInt(getThang(d2)), Integer.parseInt(getNam(d2)));
	return da.before(db);
	}
	

	public static String getNgay(String ngay) {
		StringTokenizer st = new StringTokenizer(ngay, " /*-");
		return st.nextToken();
	}

	public static String getThang(String ngay) {
		StringTokenizer st = new StringTokenizer(ngay, " /*-");
		st.nextToken();
		return st.nextToken();
	}

	public static String getNam(String ngay) {
		StringTokenizer st = new StringTokenizer(ngay, " /*-");
		st.nextToken();
		st.nextToken();
		return st.nextToken();
	}

	public static void main(String[] args) {
//		System.out.println(ktNgay("26-05-2014"));
		System.out.println(now1());
//		Date d = new Date();
		System.out.println(kTra2Ngay("20-01-2014", "18-02-2014"));
	}
}
