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

import DAO.DAO_ThucDon;
import controller.Action;
import controller.Controller_MatHang;
import controller.Controller_ThucDon;
import model.ChecNgay;
import model.Export_File_Excell;
import model.MatHang;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import javax.swing.JButton;
import javax.swing.ImageIcon;

public class Panel_Button_AllTextField_MatHang extends JPanel implements
		ActionListener {
	
	private static JTextField tf_MaMatHang;
	private static JTextField tf_TenMatHang;
	private static JTextField tf_Gia;
	static JComboBox<String> listDonViTinh = new MyCombobox()
			.getListDonViTinh();
	static JComboBox<String> listNhomHang = new MyCombobox().getListNhomHang();
	static JComboBox<String> listNhaCungCap = new MyCombobox()
			.getListNhaCungCap();

	private static UtilDateModel model;
	private static JDatePanelImpl datePanel;
	private static JDatePickerImpl datePicker;
	private static JTextField tf_SoLuong;
	static Panel_Button_AllTextField_MatHang ql = null;
	private static JButton bt_chon, bt_sua, bt_them, bt_xoa, bt_inan,
			bt_thongke, bt_thoat;

	/**
	 * Create the panel.
	 */
	public Panel_Button_AllTextField_MatHang() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel_button = new JPanel();
		panel_button.setBorder(new LineBorder(Color.GREEN, 1, true));
		add(panel_button, BorderLayout.SOUTH);
		panel_button.setBorder(new TitledBorder(new LineBorder(new Color(0,
				255, 0), 1, true), "C\u00F4ng c\u1EE5", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel_button.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 3));

		// Button chọn Giao diện
		bt_chon = new JButton("Làm lại");
		bt_chon.setIcon(new ImageIcon(Panel_Button_AllTextField_MatHang.class
				.getResource("/images/valid.png")));
		bt_chon.setToolTipText("chọn");
		bt_chon.setFont(new Font("Arial", Font.BOLD, 12));
		panel_button.add(bt_chon);

		bt_sua = new JButton("Sửa");
		bt_sua.setToolTipText("sửa");
		bt_sua.setSelectedIcon(new ImageIcon(
				Panel_Button_AllTextField_MatHang.class
						.getResource("/images/edit.png")));
		bt_sua.setIcon(new ImageIcon(Panel_Button_AllTextField_MatHang.class
				.getResource("/images/edit.png")));
		bt_sua.setFont(new Font("Arial", Font.BOLD, 12));
		panel_button.add(bt_sua);

		bt_them = new JButton("Thêm");
		bt_them.setFont(new Font("Arial", Font.BOLD, 12));
		bt_them.setSelectedIcon(new ImageIcon(
				Panel_Button_AllTextField_MatHang.class
						.getResource("/images/new.png")));
		bt_them.setToolTipText("thêm");
		bt_them.setIcon(new ImageIcon(Panel_Button_AllTextField_MatHang.class
				.getResource("/images/new.png")));
		panel_button.add(bt_them);

		bt_xoa = new JButton("Xóa");
		bt_xoa.setSelectedIcon(new ImageIcon(
				Panel_Button_AllTextField_MatHang.class
						.getResource("/images/delete.png")));
		bt_xoa.setIcon(new ImageIcon(Panel_Button_AllTextField_MatHang.class
				.getResource("/images/delete.png")));
		bt_xoa.setToolTipText("xóa");
		bt_xoa.setFont(new Font("Arial", Font.BOLD, 12));
		panel_button.add(bt_xoa);

		bt_inan = new JButton("In Ấn");
		bt_inan.setToolTipText("in ấn");
		bt_inan.setIcon(new ImageIcon(Panel_Button_AllTextField_MatHang.class
				.getResource("/image/inan.png")));
		bt_inan.setFont(new Font("Arial", Font.BOLD, 12));
		panel_button.add(bt_inan);

		bt_thongke = new JButton("In Thống Kê");
		bt_thongke.setToolTipText("thống kê");
		bt_thongke.setIcon(new ImageIcon(
				Panel_Button_AllTextField_MatHang.class
						.getResource("/image/thongke.png")));
		bt_thongke.setFont(new Font("Arial", Font.BOLD, 12));
		panel_button.add(bt_thongke);

		bt_thoat = new JButton("Thoát");
		bt_thoat.setToolTipText("bấm để thoát");
		bt_thoat.setIcon(new ImageIcon(Panel_Button_AllTextField_MatHang.class
				.getResource("/image/exit.png")));
		bt_thoat.setFont(new Font("Arial", Font.BOLD, 12));
		panel_button.add(bt_thoat);
		// End - JPanel _ Button ============================

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(255, 200, 0),
				1, true), "Nh\u1EADp th\u00F4ng tin m\u1EB7t h\u00E0ng",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		// JPanel panel_All = new JPanel();
		// panel.add(panel_All, BorderLayout.NORTH);

		JPanel panel_All_1 = new JPanel();
		panel.add(panel_All_1, BorderLayout.NORTH);
		panel_All_1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		JLabel lblMMtHng = new JLabel("Mã Mặt Hàng:  ");
		panel_All_1.add(lblMMtHng);

		tf_MaMatHang = new JTextField();
		panel_All_1.add(tf_MaMatHang);
		tf_MaMatHang.setColumns(15);

		JLabel lblTnMtHng = new JLabel("     Tên Mặt Hàng:  ");
		panel_All_1.add(lblTnMtHng);

		tf_TenMatHang = new JTextField();
		panel_All_1.add(tf_TenMatHang);
		tf_TenMatHang.setColumns(15);

		JLabel lblGi = new JLabel("    Giá:  ");
		panel_All_1.add(lblGi);

		tf_Gia = new JTextField();
		panel_All_1.add(tf_Gia);
		tf_Gia.setColumns(15);

		JLabel lblnVTnh = new JLabel("   Đơn Vị Tính:  ");
		panel_All_1.add(lblnVTnh);

		panel_All_1.add(listDonViTinh);

		JPanel panel_All_2 = new JPanel();
		panel.add(panel_All_2, BorderLayout.SOUTH);
		panel_All_2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		JLabel lblSLng = new JLabel("     Số Lượng:   ");
		panel_All_2.add(lblSLng);

		tf_SoLuong = new JTextField();
		panel_All_2.add(tf_SoLuong);
		tf_SoLuong.setColumns(13);

		JLabel lblNhmHng = new JLabel("        Nhóm Hàng:  ");
		panel_All_2.add(lblNhmHng);

		panel_All_2.add(listNhomHang);

		JLabel lblNgyNhp = new JLabel("       Ngày Nhập:  ");
		panel_All_2.add(lblNgyNhp);

		GridBagConstraints gb = new GridBagConstraints();
		model = new UtilDateModel();
		datePanel = new JDatePanelImpl(model);
		datePicker = new JDatePickerImpl(datePanel);
		datePicker.getJFormattedTextField().setToolTipText("Click chọn ngày");
		// datePicker.getJButton().addKeyListener(action);
		// datePicker.getJFormattedTextField().addKeyListener(action);
		datePicker.getJFormattedTextField().setText(ChecNgay.now1());
		gb.gridx = 1;
		gb.gridy = 3;
		gb.insets = new Insets(0, 0, 15, 5);
		gb.anchor = GridBagConstraints.WEST;

		panel_All_2.add(datePicker, gb);

		JLabel lblNhCungCp = new JLabel("   Nhà Cung Cấp:  ");
		panel_All_2.add(lblNhCungCp);
		panel_All_2.add(listNhaCungCap);

		bt_chon.addActionListener(this);
		bt_sua.addActionListener(this);
		bt_them.addActionListener(this);
		bt_xoa.addActionListener(this);
		bt_thoat.addActionListener(this);
		bt_thongke.addActionListener(this);
		bt_inan.addActionListener(this);

	}

	public Panel_Button_AllTextField_MatHang(QL_MatHang_Panel ql_MatHang_Panel) {
		// TODO Auto-generated constructor stub
	}

	public static JDatePickerImpl getDatePicker() {
		return datePicker;
	}

	public static void setDatePicker(JDatePickerImpl datePicker) {
		Panel_Button_AllTextField_MatHang.datePicker = datePicker;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String maMH = tf_MaMatHang.getText();
		String tenMatHang = tf_TenMatHang.getText();
		String gia = tf_Gia.getText();
		String donViTinh = listDonViTinh.getItemAt(listDonViTinh
				.getSelectedIndex());
		String soLuong = tf_SoLuong.getText();
		String nhomHang = listNhomHang.getItemAt(listNhomHang
				.getSelectedIndex());
		String ngay = ql.getDatePicker().getJFormattedTextField().getText()
				.trim();
		String nhaCungCap = listNhaCungCap.getItemAt(listNhaCungCap
				.getSelectedIndex());
		
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
				QL_MatHang_Panel.Export_Excell();
				JOptionPane.showMessageDialog(this, "Xuất File thành công!");
			}
		} else if (e.getSource() == bt_inan) {
			try {
				MessageFormat header = new MessageFormat("Danh sách mặt hàng");
				JTable table = QL_MatHang_Panel.getTable();
				table.print(JTable.PrintMode.FIT_WIDTH, header, null);

			} catch (Exception e2) {
				// TODO: handle exception
			}
		} else if (e.getSource() == bt_them) {
			if (tf_MaMatHang.getText().equals("")) {
				JOptionPane
						.showMessageDialog(this, "Bạn chưa nhập khoá chính!");
			} else {
				boolean checkMaMatHang = Controller_MatHang
						.checkMaMatHang(tf_MaMatHang.getText());
				if (checkMaMatHang == true) {
					JOptionPane.showMessageDialog(this,
							"Mã Mặt Hàng đã tồn tại trong hệ thống!");
				} else {
					Double g;
					try {
						g = Double.parseDouble(gia);
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null,
								"Cột 'Giá' nhập Không phải là số");
						return;
					}

					int s;
					try {
						s = Integer.parseInt(soLuong);
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null,
								"Cột 'Số Lượng' không phải là số");
						return;
					}
					boolean c = Controller_MatHang.themMH(maMH, tenMatHang, g,
							donViTinh, s, nhomHang, ngay, nhaCungCap);
					if (c == true) {
						QL_MatHang_Panel.loadDatabase();
						clearAllTextField();
						JOptionPane.showMessageDialog(this, "Thêm thành công!");
						boolean themHD = Controller_ThucDon.themThucDon(maMH,
								tenMatHang, donViTinh, g);
						if (themHD == true) {
//							JOptionPane.showMessageDialog(this,
//									"Thực đơn đã được cập nhật!");
							DatBan_ThucDon.loadData();
						} else {
							JOptionPane.showMessageDialog(this,
									"chưa thêm được mặt hàng vào thực đơn!");

						}
					}
				}
			}
		} else if (e.getSource() == bt_xoa) {
			int row = QL_MatHang_Panel.table.getSelectedRow();
			System.out.println("+ Row hiện tại: " + row);
			if (row != -1) {
				String s1 = (String) QL_MatHang_Panel.datamodel.getValueAt(row,
						0);
				Icon icon = new ImageIcon(getClass().getResource(
						"/image/delete.png"));
				int ia = JOptionPane.showConfirmDialog(this,
						"Bạn thực sự muốn xóa ?", "Xóa mặt hàng",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE, icon);
				if (ia == 0) {
					int i = Controller_MatHang.xoaMatHang(s1);
					if (i == 1) {
						QL_MatHang_Panel.datamodel.removeRow(row);
						JOptionPane.showMessageDialog(this, "Xóa thành công");
						tf_MaMatHang.setEditable(true);
						
						boolean abc = DAO_ThucDon.xoa(s1);
						if(abc = true){
							JOptionPane.showMessageDialog(this, "Đã cập nhật lại Thực Đơn!");
							DatBan_ThucDon.loadData();
						}
					} else {
						JOptionPane.showMessageDialog(this, "Xóa thất bại");
					}
				}
			} else {
				JOptionPane.showMessageDialog(this, "Xóa thất bại");
			}
			clearAllTextField();
		} else if (e.getSource() == bt_sua) {
			int row = QL_MatHang_Panel.table.getSelectedRow();
			int result = 0;
			String s1 = (String) QL_MatHang_Panel.datamodel.getValueAt(row, 0);

			QL_MatHang_Panel.datamodel.removeRow(row);
			Double g;
			try {
				g = Double.parseDouble(gia);
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null,
						"Cột 'Giá' nhập Không phải là số");
				return;
			}

			int s;
			try {
				s = Integer.parseInt(soLuong);
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null,
						"Cột 'Số Lượng' không phải là số");
				return;
			}
			int i = Controller_MatHang.suaMatHang(maMH, tenMatHang, g,
					donViTinh, s, nhomHang, ngay, nhaCungCap);
			if (i == 1) {
				QL_MatHang_Panel.loadDatabase();
				JOptionPane.showMessageDialog(this, "Sửa thành công");
			} else {
				JOptionPane.showMessageDialog(this, "Sửa thất bại");
			}

			clearAllTextField();
			tf_MaMatHang.setEditable(true);

		} else if (e.getSource() == bt_chon) {
			tf_MaMatHang.setEditable(true);
			clearAllTextField();
		}

	}

	private void clearAllTextField() {
		tf_MaMatHang.setText("");
		tf_TenMatHang.setText("");
		tf_Gia.setText("");
		listDonViTinh.setSelectedIndex(0);
		tf_SoLuong.setText("");
		listNhomHang.setSelectedIndex(0);
		listNhaCungCap.setSelectedIndex(0);
		ql.setDatePicker(datePicker);
	}

	public static JTextField getTf_MaMatHang() {
		return tf_MaMatHang;
	}

	public static JTextField getTf_TenMatHang() {
		return tf_TenMatHang;
	}

	public static JTextField getTf_Gia() {
		return tf_Gia;
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

	public static UtilDateModel getModel() {
		return model;
	}

	public static JDatePanelImpl getDatePanel() {
		return datePanel;
	}

	public static JTextField getTf_SoLuong() {
		return tf_SoLuong;
	}

	public static Panel_Button_AllTextField_MatHang getQl() {
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

	public static void setTf_MaMatHang(JTextField tf_MaMatHang) {
		Panel_Button_AllTextField_MatHang.tf_MaMatHang = tf_MaMatHang;
	}

	public static void setTf_TenMatHang(JTextField tf_TenMatHang) {
		Panel_Button_AllTextField_MatHang.tf_TenMatHang = tf_TenMatHang;
	}

	public static void setTf_Gia(JTextField tf_Gia) {
		Panel_Button_AllTextField_MatHang.tf_Gia = tf_Gia;
	}

	public static void setListDonViTinh(JComboBox<String> listDonViTinh) {
		Panel_Button_AllTextField_MatHang.listDonViTinh = listDonViTinh;
	}

	public static void setListNhomHang(JComboBox<String> listNhomHang) {
		Panel_Button_AllTextField_MatHang.listNhomHang = listNhomHang;
	}

	public static void setListNhaCungCap(JComboBox<String> listNhaCungCap) {
		Panel_Button_AllTextField_MatHang.listNhaCungCap = listNhaCungCap;
	}

	public static void setModel(UtilDateModel model) {
		Panel_Button_AllTextField_MatHang.model = model;
	}

	public static void setDatePanel(JDatePanelImpl datePanel) {
		Panel_Button_AllTextField_MatHang.datePanel = datePanel;
	}

	public static void setTf_SoLuong(JTextField tf_SoLuong) {
		Panel_Button_AllTextField_MatHang.tf_SoLuong = tf_SoLuong;
	}

	public static void setQl(Panel_Button_AllTextField_MatHang ql) {
		Panel_Button_AllTextField_MatHang.ql = ql;
	}

	public static void setBt_chon(JButton bt_chon) {
		Panel_Button_AllTextField_MatHang.bt_chon = bt_chon;
	}

	public static void setBt_sua(JButton bt_sua) {
		Panel_Button_AllTextField_MatHang.bt_sua = bt_sua;
	}

	public static void setBt_them(JButton bt_them) {
		Panel_Button_AllTextField_MatHang.bt_them = bt_them;
	}

	public static void setBt_xoa(JButton bt_xoa) {
		Panel_Button_AllTextField_MatHang.bt_xoa = bt_xoa;
	}

	public static void setBt_inan(JButton bt_inan) {
		Panel_Button_AllTextField_MatHang.bt_inan = bt_inan;
	}

	public static void setBt_thongke(JButton bt_thongke) {
		Panel_Button_AllTextField_MatHang.bt_thongke = bt_thongke;
	}

	public static void setBt_thoat(JButton bt_thoat) {
		Panel_Button_AllTextField_MatHang.bt_thoat = bt_thoat;
	}

}
