package model;

public class ThucDon {
	String maMH;
	String tenMH;
	String donViTinh;
	double giaBan;

	public ThucDon() {
		// TODO Auto-generated constructor stub
	}

	public ThucDon(String maMH, String tenMH, String donViTinh, double giaBan) {
		super();
		this.maMH = maMH;
		this.tenMH = tenMH;
		this.donViTinh = donViTinh;
		this.giaBan = giaBan;
	}

	public String getMaMH() {
		return maMH;
	}

	public void setMaMH(String maMH) {
		this.maMH = maMH;
	}

	public String getTenMH() {
		return tenMH;
	}

	public void setTenMH(String tenMH) {
		this.tenMH = tenMH;
	}

	public String getDonViTinh() {
		return donViTinh;
	}

	public void setDonViTinh(String donViTinh) {
		this.donViTinh = donViTinh;
	}

	public double getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}

	@Override
	public String toString() {
		return "MD_ThucDon [maMH=" + maMH + ", tenMH=" + tenMH + ", donViTinh="
				+ donViTinh + ", giaBan=" + giaBan + "]";
	}

}
