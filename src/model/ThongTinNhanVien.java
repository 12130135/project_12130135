package model;

public class ThongTinNhanVien {
	private String mnv;
	private String hoten;
	private String socmnd;
	private String gioitinh;
	private String ngaysinh;
	private String sdt;
	private String diachi;
	public ThongTinNhanVien(String mnv, String hoten, String socmnd,
			String gioitinh, String ngaysinh, String sdt, String diachi) {
		super();
		this.mnv = mnv;
		this.hoten = hoten;
		this.socmnd = socmnd;
		this.gioitinh = gioitinh;
		this.ngaysinh = ngaysinh;
		this.sdt = sdt;
		this.diachi = diachi;
	}
	public String getMnv() {
		return mnv;
	}
	public void setMnv(String mnv) {
		this.mnv = mnv;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getSocmnd() {
		return socmnd;
	}
	public void setSocmnd(String socmnd) {
		this.socmnd = socmnd;
	}
	public String getGioitinh() {
		return gioitinh;
	}
	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}
	public String getNgaysinh() {
		return ngaysinh;
	}
	public void setNgaysinh(String ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	
}
