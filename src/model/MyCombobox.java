package model;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class MyCombobox {
	// list đơn vị tính
	private JComboBox<String> listDonViTinh;

	// list nhóm hàng
	private JComboBox<String> listNhomHang;

	// list nhà cung cấp
	private JComboBox<String> listNhaCungCap;

	// list giới tính
	private JComboBox<String> listGioiTinh;

	private JComboBox<String> listBan;

	public JComboBox<String> getListDonViTinh() {
		DefaultComboBoxModel<String> tenDonViTinh = new DefaultComboBoxModel<String>();
		tenDonViTinh.addElement("");
		tenDonViTinh.addElement("Kg");
		tenDonViTinh.addElement("Gram");
		tenDonViTinh.addElement("Ly");
		tenDonViTinh.addElement("Dĩa");

		this.listDonViTinh = new JComboBox<>(tenDonViTinh);
		this.listDonViTinh.setSelectedIndex(0);
		return listDonViTinh;
	}

	public JComboBox<String> getListBan() {
		DefaultComboBoxModel<String> Ban = new DefaultComboBoxModel<String>();
		Ban.addElement(" Bàn 1 ");
		Ban.addElement(" Bàn 2 ");
		Ban.addElement(" Bàn 3 ");
		Ban.addElement(" Bàn 4 ");
		Ban.addElement(" Bàn 5 ");
		Ban.addElement(" Bàn 6 ");
		Ban.addElement(" Bàn 7 ");
		Ban.addElement(" Bàn 8 ");
		Ban.addElement(" Bàn 9 ");
		Ban.addElement(" Bàn 10 ");
		Ban.addElement(" Bàn 11 ");
		Ban.addElement(" Bàn 12 ");
		Ban.addElement(" Bàn 13 ");
		Ban.addElement(" Bàn 14 ");
		Ban.addElement(" Bàn 15 ");
		Ban.addElement(" Bàn 16 ");
		Ban.addElement(" Bàn 17 ");
		Ban.addElement(" Bàn 18 ");
		Ban.addElement(" Bàn 19 ");
		Ban.addElement(" Bàn 20 ");
		Ban.addElement(" Bàn 21 ");
		Ban.addElement(" Bàn 22 ");
		Ban.addElement(" Bàn 23 ");
		Ban.addElement(" Bàn 24 ");
		Ban.addElement(" Bàn 25 ");
		Ban.addElement(" Bàn 26 ");
		Ban.addElement(" Bàn 27 ");
		Ban.addElement(" Bàn 28 ");
		Ban.addElement(" Bàn 29 ");
		Ban.addElement(" Bàn 30 ");
		Ban.addElement(" Bàn 31 ");
		Ban.addElement(" Bàn 32 ");
		Ban.addElement(" Bàn 33 ");
		Ban.addElement(" Bàn 34 ");
		Ban.addElement(" Bàn 35 ");
		Ban.addElement(" Bàn 36 ");
		this.listBan = new JComboBox<>(Ban);
		this.listBan.setSelectedIndex(0);
		return listBan;
	}

	public JComboBox<String> getListNhomHang() {
		DefaultComboBoxModel<String> tenNhomHang = new DefaultComboBoxModel<String>();
		tenNhomHang.addElement("");
		tenNhomHang.addElement("Nước Uống");
		tenNhomHang.addElement("Thức Ăn");
		tenNhomHang.addElement("Kem");
		tenNhomHang.addElement("Thuốc Lá");

		this.listNhomHang = new JComboBox<String>(tenNhomHang);
		this.listNhomHang.setSelectedIndex(0);
		return listNhomHang;
	}

	public JComboBox<String> getListNhaCungCap() {
		DefaultComboBoxModel<String> nhaCungCap = new DefaultComboBoxModel<String>();
		nhaCungCap.addElement("");
		nhaCungCap.addElement("StarBuck Đức");
		nhaCungCap.addElement("Coffe Thu Hà");
		nhaCungCap.addElement("Coffee Lâm Đồng");
		nhaCungCap.addElement("Bảo Lộc Tea");
		nhaCungCap.addElement("Coffee Thái Nguyên");
		nhaCungCap.addElement("Khác");


		this.listNhaCungCap = new JComboBox<String>(nhaCungCap);
		this.listNhaCungCap.setSelectedIndex(0);
		return listNhaCungCap;
	}

	public JComboBox<String> getListGioiTinh() {
		DefaultComboBoxModel<String> gioiTinh = new DefaultComboBoxModel<String>();
		//gioiTinh.addElement("");
		gioiTinh.addElement("Nam");
		gioiTinh.addElement("Nữ");

		this.listGioiTinh = new JComboBox<String>(gioiTinh);
		this.listGioiTinh.setSelectedIndex(0);
		return listGioiTinh;
	}

}
