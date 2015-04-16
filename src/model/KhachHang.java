package model;

//private String tenKhachHang;
//private String gioiTinh;
//private String ghiChu;

public class KhachHang {
	private String maKhachHang;
	private String tenKhachHang;
	private String gioiTinh;
	private String diaChi;
	private String soDienThoai;
	private String Email;
	private String ghiChu;

	public KhachHang() {
		// TODO Auto-generated constructor stub
	}

	public KhachHang(String maKhachHang, String tenKhachHang, String gioiTinh,
			String diaChi, String soDienThoai, String email, String ghiChu) {
		super();
		this.maKhachHang = maKhachHang;
		this.tenKhachHang = tenKhachHang;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		Email = email;
		this.ghiChu = ghiChu;
	}

	public String getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	@Override
	public String toString() {
		return "MD_KhachHang_Vip [maKhachHang=" + maKhachHang
				+ ", tenKhachHang=" + tenKhachHang + ", gioiTinh=" + gioiTinh
				+ ", diaChi=" + diaChi + ", soDienThoai=" + soDienThoai
				+ ", Email=" + Email + ", ghiChu=" + ghiChu + "]";
	}

}
