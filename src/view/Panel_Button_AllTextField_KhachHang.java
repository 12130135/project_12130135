package view;

import javax.swing.JPanel; 

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.MessageFormat;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import model.MyCombobox;
import javax.swing.border.TitledBorder;
import javax.swing.JSpinner;

import controller.Action;
import controller.Controller_KhachHang;
import model.ChecNgay;
import model.Export_File_Excell;
import model.MatHang;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import javax.swing.JButton;
import javax.swing.ImageIcon;

public class Panel_Button_AllTextField_KhachHang extends JPanel implements
		ActionListener {
	private static JTextField tf_MaKhachHang;
	private static JTextField tf_TenKhachHang;
	private static JTextField tf_DiaChi;
	private static JTextField tf_Email, tf_GhiChu;
	static JComboBox<String> listDonViTinh = new MyCombobox()
			.getListDonViTinh();
	static JComboBox<String> listNhomHang = new MyCombobox().getListNhomHang();
	static JComboBox<String> listNhaCungCap = new MyCombobox()
			.getListNhaCungCap();
	static JComboBox<String> listGioiTinh = new MyCombobox().getListGioiTinh();

	private static UtilDateModel model;
	private static JDatePanelImpl datePanel;
	private static JDatePickerImpl datePicker;
	private static JTextField tf_SoDienThoai;
	static Panel_Button_AllTextField_KhachHang ql = null;
	private static JButton bt_chon, bt_sua, bt_them, bt_xoa, bt_inan,
			bt_thongke, bt_thoat;

	/**
	 * Create the panel.
	 */
	public Panel_Button_AllTextField_KhachHang() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel_button_abc = new JPanel();
		panel_button_abc.setBorder(new LineBorder(Color.GREEN, 1, true));
		add(panel_button_abc, BorderLayout.SOUTH);
		panel_button_abc.setBorder(new TitledBorder(new LineBorder(new Color(0,
				255, 0), 1, true), "C\u00F4ng c\u1EE5", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel_button_abc.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 3));

		// Button chọn Giao diện
		bt_chon = new JButton("Làm lại");
		bt_chon.setIcon(new ImageIcon(Panel_Button_AllTextField_KhachHang.class
				.getResource("/images/valid.png")));
		bt_chon.setToolTipText("chọn");
		bt_chon.setFont(new Font("Arial", Font.BOLD, 12));
		panel_button_abc.add(bt_chon);

		bt_sua = new JButton("Sửa");
		bt_sua.setToolTipText("sửa");
		bt_sua.setSelectedIcon(new ImageIcon(
				Panel_Button_AllTextField_KhachHang.class
						.getResource("/images/edit.png")));
		bt_sua.setIcon(new ImageIcon(Panel_Button_AllTextField_KhachHang.class
				.getResource("/images/edit.png")));
		bt_sua.setFont(new Font("Arial", Font.BOLD, 12));
		panel_button_abc.add(bt_sua);

		bt_them = new JButton("Thêm");
		bt_them.setFont(new Font("Arial", Font.BOLD, 12));
		bt_them.setSelectedIcon(new ImageIcon(
				Panel_Button_AllTextField_KhachHang.class
						.getResource("/images/new.png")));
		bt_them.setToolTipText("thêm");
		bt_them.setIcon(new ImageIcon(Panel_Button_AllTextField_KhachHang.class
				.getResource("/images/new.png")));
		panel_button_abc.add(bt_them);

		bt_xoa = new JButton("Xóa");
		bt_xoa.setSelectedIcon(new ImageIcon(
				Panel_Button_AllTextField_KhachHang.class
						.getResource("/images/delete.png")));
		bt_xoa.setIcon(new ImageIcon(Panel_Button_AllTextField_KhachHang.class
				.getResource("/images/delete.png")));
		bt_xoa.setToolTipText("xóa");
		bt_xoa.setFont(new Font("Arial", Font.BOLD, 12));
		panel_button_abc.add(bt_xoa);

		bt_inan = new JButton("In Ấn");
		bt_inan.setToolTipText("in ấn");
		bt_inan.setIcon(new ImageIcon(Panel_Button_AllTextField_KhachHang.class
				.getResource("/image/inan.png")));
		bt_inan.setFont(new Font("Arial", Font.BOLD, 12));
		panel_button_abc.add(bt_inan);

		bt_thongke = new JButton("In Thống Kê");
		bt_thongke.setToolTipText("thống kê");
		bt_thongke.setIcon(new ImageIcon(
				Panel_Button_AllTextField_KhachHang.class
						.getResource("/image/thongke.png")));
		bt_thongke.setFont(new Font("Arial", Font.BOLD, 12));
		panel_button_abc.add(bt_thongke);

		bt_thoat = new JButton("Thoát");
		bt_thoat.setToolTipText("bấm để thoát");
		bt_thoat.setIcon(new ImageIcon(
				Panel_Button_AllTextField_KhachHang.class
						.getResource("/image/exit.png")));
		bt_thoat.setFont(new Font("Arial", Font.BOLD, 12));
		panel_button_abc.add(bt_thoat);
		// End - JPanel _ Button ============================

		JPanel panel_abc = new JPanel();
		panel_abc.setBorder(new TitledBorder(new LineBorder(new Color(255, 200,
				0), 1, true), "Nh\u1EADp th\u00F4ng tin m\u1EB7t h\u00E0ng",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panel_abc, BorderLayout.CENTER);
		panel_abc.setLayout(new BorderLayout(0, 0));

		// JPanel panel_All = new JPanel();
		// panel.add(panel_All, BorderLayout.NORTH);

		JPanel panel_All_1 = new JPanel();
		panel_abc.add(panel_All_1, BorderLayout.NORTH);
		panel_All_1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		JLabel lblMMtHng = new JLabel("Mã KháchHàng:  ");
		panel_All_1.add(lblMMtHng);

		tf_MaKhachHang = new JTextField();
		panel_All_1.add(tf_MaKhachHang);
		tf_MaKhachHang.setColumns(15);

		JLabel lblTnMtHng = new JLabel("     Tên Khách Hàng:  ");
		panel_All_1.add(lblTnMtHng);

		tf_TenKhachHang = new JTextField();
		panel_All_1.add(tf_TenKhachHang);
		tf_TenKhachHang.setColumns(15);

		JLabel lblGi = new JLabel("    Giới Tính:  ");
		panel_All_1.add(lblGi);

		panel_All_1.add(listGioiTinh);

		JLabel lblnVTnh = new JLabel("   Địa Chỉ:  ");
		panel_All_1.add(lblnVTnh);

		tf_DiaChi = new JTextField();
		panel_All_1.add(tf_DiaChi);
		tf_DiaChi.setColumns(15);

		JPanel panel_All_2 = new JPanel();
		panel_abc.add(panel_All_2, BorderLayout.SOUTH);
		panel_All_2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		JLabel lblSLng = new JLabel("     Số Điện Thoại:   ");
		panel_All_2.add(lblSLng);

		tf_SoDienThoai = new JTextField();
		panel_All_2.add(tf_SoDienThoai);
		tf_SoDienThoai.setColumns(13);

		JLabel lblNhmHng = new JLabel("        Email:  ");
		panel_All_2.add(lblNhmHng);

		tf_Email = new JTextField();
		panel_All_2.add(tf_Email);
		tf_Email.setColumns(13);

		JLabel lblNhCungCp = new JLabel("   Ghi Chú:  ");
		panel_All_2.add(lblNhCungCp);

		tf_GhiChu = new JTextField();
		panel_All_2.add(tf_GhiChu);
		tf_GhiChu.setColumns(20);

		bt_chon.addActionListener(this);
		bt_sua.addActionListener(this);
		bt_them.addActionListener(this);
		bt_xoa.addActionListener(this);
		bt_thoat.addActionListener(this);
		bt_thongke.addActionListener(this);
		bt_inan.addActionListener(this);

	}

	public Panel_Button_AllTextField_KhachHang(QL_KhachHang_Panel QL_KhachHang_Panel) {
		// TODO Auto-generated constructor stub
	}

	public static JDatePickerImpl getDatePicker() {
		return datePicker;
	}

	public static void setDatePicker(JDatePickerImpl datePicker) {
		Panel_Button_AllTextField_KhachHang.datePicker = datePicker;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String maKH = tf_MaKhachHang.getText();
		String tenKhachHang = tf_TenKhachHang.getText();
		String gioiTinh = listGioiTinh.getItemAt(listGioiTinh
				.getSelectedIndex());
		String diaChi = tf_DiaChi.getText();
		String soDienThoai = tf_SoDienThoai.getText();
		String email = tf_Email.getText();
		String ghiChu = tf_GhiChu.getText();

		if (e.getSource() == bt_thoat) {
			int i = JOptionPane.showConfirmDialog(this,
					"Bạn thực sự muốn thoát ?", "In Thống Kê",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (i == 0) {
				System.exit(0);
			}
		} else if (e.getSource() == bt_thongke) {

			int i = JOptionPane
					.showConfirmDialog(
							this,
							"Bạn thực sự muốn In ra File Excel với Path là: D:\\ListMatHang.xls",
							"In Thống Kê", JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE);
			if (i == 0) {
				QL_KhachHang_Panel.Export_Excell();
				JOptionPane.showMessageDialog(this, "Xuất File thành công!");
			}
		} else if (e.getSource() == bt_inan) {
			try {
				MessageFormat header = new MessageFormat("Danh sách khách hàng");
				JTable table = QL_KhachHang_Panel.getTable();
				table.print(JTable.PrintMode.FIT_WIDTH, header, null);

			} catch (Exception e2) {
				// TODO: handle exception
			}
		} else if (e.getSource() == bt_them) {
			if (tf_MaKhachHang.getText().equals("")) {
				JOptionPane
						.showMessageDialog(this, "Bạn chưa nhập khoá chính!");
			} else {
				boolean checkMaMatHang = Controller_KhachHang
						.checkMaKhachHang(tf_MaKhachHang.getText());
				if (checkMaMatHang == true) {
					JOptionPane.showMessageDialog(this,
							"Mã Khách Hàng đã tồn tại trong hệ thống!");
				} else {
					boolean c = Controller_KhachHang.themKH(maKH, tenKhachHang,
							gioiTinh, diaChi, soDienThoai, email, ghiChu);
					if (c == true) {
						QL_KhachHang_Panel.loadDatabase();
						clearAllTextField();
						JOptionPane.showMessageDialog(this, "Thêm thành công!");
					}
				}
			}
		} else if (e.getSource() == bt_xoa) {
			int row = QL_KhachHang_Panel.table.getSelectedRow();
			System.out.println("+ Row hiện tại: " + row);
			if (row != -1) {
				String s1 = (String) QL_KhachHang_Panel.datamodel.getValueAt(row,
						0);
				Icon icon = new ImageIcon(getClass().getResource(
						"/image/delete.png"));
				int ia = JOptionPane.showConfirmDialog(this,
						"Bạn thực sự muốn xóa ?", "Xóa khách hàng",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE, icon);
				if (ia == 0) {
					int i = Controller_KhachHang.xoaKhachHang(s1);
					if (i == 1) {
						QL_KhachHang_Panel.datamodel.removeRow(row);
						JOptionPane.showMessageDialog(this, "Xóa thành công");
						tf_MaKhachHang.setEditable(true);
					} else {
						JOptionPane.showMessageDialog(this, "Xóa thất bại");
					}
				}
			} else {
				JOptionPane.showMessageDialog(this, "Xóa thất bại");
			}
			clearAllTextField();
		} else if (e.getSource() == bt_sua) {
			int row = QL_KhachHang_Panel.table.getSelectedRow();
			int result = 0;
			String s1 = (String) QL_KhachHang_Panel.datamodel.getValueAt(row, 0);

			QL_KhachHang_Panel.datamodel.removeRow(row);
			int i = Controller_KhachHang.suaKhachHang(maKH, tenKhachHang, gioiTinh,
					diaChi, soDienThoai, email, ghiChu);
			if (i == 1) {
				// QL_KhachHang_Panel.datamodel.removeRow(row);
				JOptionPane.showMessageDialog(this, "Sửa thành công");
			} else {
				JOptionPane.showMessageDialog(this, "Sửa thất bại");
			}

			clearAllTextField();
			tf_MaKhachHang.setEditable(true);

		} else if (e.getSource() == bt_chon) {
			tf_MaKhachHang.setEditable(true);
			clearAllTextField();
		}

	}

	private void clearAllTextField() {
		tf_MaKhachHang.setText("");
		tf_TenKhachHang.setText("");
		listGioiTinh.setSelectedIndex(0);
		tf_DiaChi.setText("");
		tf_SoDienThoai.setText("");
		tf_Email.setText("");
		tf_GhiChu.setText("");
	}

	public static JTextField getTf_MaKhachHang() {
		return tf_MaKhachHang;
	}

	public static JTextField getTf_TenKhachHang() {
		return tf_TenKhachHang;
	}

	public static JTextField getTf_DiaChi() {
		return tf_DiaChi;
	}

	public static JTextField getTf_Email() {
		return tf_Email;
	}

	public static JTextField getTf_GhiChu() {
		return tf_GhiChu;
	}

	public static JComboBox<String> getListDonViTinh() {
		return listDonViTinh;
	}

	public static JComboBox<String> getListNhomHang() {
		return listNhomHang;
	}

	public static JComboBox<String> getListNhaCungCap() {
		return listNhaCungCap;
	}

	public static JComboBox<String> getListGioiTinh() {
		return listGioiTinh;
	}

	public static UtilDateModel getModel() {
		return model;
	}

	public static JDatePanelImpl getDatePanel() {
		return datePanel;
	}

	public static JTextField getTf_SoDienThoai() {
		return tf_SoDienThoai;
	}

	public static Panel_Button_AllTextField_KhachHang getQl() {
		return ql;
	}

	public static JButton getBt_chon() {
		return bt_chon;
	}

	public static JButton getBt_sua() {
		return bt_sua;
	}

	public static JButton getBt_them() {
		return bt_them;
	}

	public static JButton getBt_xoa() {
		return bt_xoa;
	}

	public static JButton getBt_inan() {
		return bt_inan;
	}

	public static JButton getBt_thongke() {
		return bt_thongke;
	}

	public static JButton getBt_thoat() {
		return bt_thoat;
	}

	public static void setTf_MaKhachHang(JTextField tf_MaKhachHang) {
		Panel_Button_AllTextField_KhachHang.tf_MaKhachHang = tf_MaKhachHang;
	}

	public static void setTf_TenKhachHang(JTextField tf_TenKhachHang) {
		Panel_Button_AllTextField_KhachHang.tf_TenKhachHang = tf_TenKhachHang;
	}

	public static void setTf_DiaChi(JTextField tf_DiaChi) {
		Panel_Button_AllTextField_KhachHang.tf_DiaChi = tf_DiaChi;
	}

	public static void setTf_Email(JTextField tf_Email) {
		Panel_Button_AllTextField_KhachHang.tf_Email = tf_Email;
	}

	public static void setTf_GhiChu(JTextField tf_GhiChu) {
		Panel_Button_AllTextField_KhachHang.tf_GhiChu = tf_GhiChu;
	}

	public static void setListDonViTinh(JComboBox<String> listDonViTinh) {
		Panel_Button_AllTextField_KhachHang.listDonViTinh = listDonViTinh;
	}

	public static void setListNhomHang(JComboBox<String> listNhomHang) {
		Panel_Button_AllTextField_KhachHang.listNhomHang = listNhomHang;
	}

	public static void setListNhaCungCap(JComboBox<String> listNhaCungCap) {
		Panel_Button_AllTextField_KhachHang.listNhaCungCap = listNhaCungCap;
	}

	public static void setListGioiTinh(JComboBox<String> listGioiTinh) {
		Panel_Button_AllTextField_KhachHang.listGioiTinh = listGioiTinh;
	}

	public static void setModel(UtilDateModel model) {
		Panel_Button_AllTextField_KhachHang.model = model;
	}

	public static void setDatePanel(JDatePanelImpl datePanel) {
		Panel_Button_AllTextField_KhachHang.datePanel = datePanel;
	}

	public static void setTf_SoDienThoai(JTextField tf_SoDienThoai) {
		Panel_Button_AllTextField_KhachHang.tf_SoDienThoai = tf_SoDienThoai;
	}

	public static void setQl(Panel_Button_AllTextField_KhachHang ql) {
		Panel_Button_AllTextField_KhachHang.ql = ql;
	}

	public static void setBt_chon(JButton bt_chon) {
		Panel_Button_AllTextField_KhachHang.bt_chon = bt_chon;
	}

	public static void setBt_sua(JButton bt_sua) {
		Panel_Button_AllTextField_KhachHang.bt_sua = bt_sua;
	}

	public static void setBt_them(JButton bt_them) {
		Panel_Button_AllTextField_KhachHang.bt_them = bt_them;
	}

	public static void setBt_xoa(JButton bt_xoa) {
		Panel_Button_AllTextField_KhachHang.bt_xoa = bt_xoa;
	}

	public static void setBt_inan(JButton bt_inan) {
		Panel_Button_AllTextField_KhachHang.bt_inan = bt_inan;
	}

	public static void setBt_thongke(JButton bt_thongke) {
		Panel_Button_AllTextField_KhachHang.bt_thongke = bt_thongke;
	}

	public static void setBt_thoat(JButton bt_thoat) {
		Panel_Button_AllTextField_KhachHang.bt_thoat = bt_thoat;
	}

}
