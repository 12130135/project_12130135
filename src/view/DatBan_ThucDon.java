package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;

import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ThreadFactory;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import DAO.ThucdonDB;

import javax.swing.JLabel;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.ListSelectionModel;

import model.HoaDon;
import model.MatHang;
import model.ThucDon;
import controller.Controller_HoaDon;
import controller.Controller_MatHang;
import controller.Controller_ThucDon;

public class DatBan_ThucDon extends JFrame implements ActionListener,
		MouseListener {
	public static JScrollPane scroll;
	static DefaultTableModel datamodel;
	static Vector columnames = new Vector();
	static Vector record = null;

	private JPanel contentPane_1;
	private static JTable table;
	ThucdonDB td = new ThucdonDB();
	private JTextField tf_timkiem;
	public static JButton btn_capnhat, btn_thoat, btn_timkiem;
	int i = 0;
	private JButton btn_them;
	public static int row;
	public static ABC_ThucDon abc_ThucDon;
	private JPanel panel_search;
	private static JTextField tf_MaMatHang;
	private static JTextField tf_TenMatHang;
	private static JTextField tf_SoLuong;
	private static JTextField tf_DonViTinh;
	private static JTextField tf_Gia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DatBan_ThucDon frame = new DatBan_ThucDon();
					frame.setVisible(true);
					frame.setLocation(1041, 100);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DatBan_ThucDon() {
		setResizable(false);
		setTitle("Thực Đơn");
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				DatBan_ThucDon.class.getResource("/image/coffee_mo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 325, 504);
		contentPane_1 = new JPanel();
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane_1);
		contentPane_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_se = new JPanel();
		contentPane_1.add(panel_se, BorderLayout.NORTH);
		panel_se.setLayout(new BorderLayout(0, 0));

		panel_search = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_search.getLayout();
		flowLayout_1.setVgap(3);
		panel_search.setBorder(new TitledBorder(new LineBorder(new Color(0,
				255, 0), 1, true), "T\u00ECm ki\u1EBFm", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel_se.add(panel_search, BorderLayout.NORTH);

		JLabel lblNewLaabel = new JLabel("Tìm kiếm");
		panel_search.add(lblNewLaabel);

		tf_timkiem = new JTextField();
		tf_timkiem.setText("");
		panel_search.add(tf_timkiem);
		tf_timkiem.setColumns(16);

		btn_timkiem = new JButton("");
		btn_timkiem.setIcon(new ImageIcon(DatBan_ThucDon.class
				.getResource("/images/find.png")));
		panel_search.add(btn_timkiem);

		JPanel panel_1fs = new JPanel();
		panel_se.add(panel_1fs, BorderLayout.CENTER);
		panel_1fs.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.GREEN, 1, true));
		panel_1fs.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new FlowLayout(FlowLayout.RIGHT, 3, 3));

		JLabel lblMMh = new JLabel("Mã MH:  ");
		lblMMh.setForeground(Color.ORANGE);
		lblMMh.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_2.add(lblMMh);

		tf_MaMatHang = new JTextField();
		tf_MaMatHang.setBackground(Color.WHITE);
		panel_2.add(tf_MaMatHang);
		tf_MaMatHang.setColumns(15);

		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0, 0));

		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4, BorderLayout.NORTH);
		panel_4.setLayout(new FlowLayout(FlowLayout.RIGHT, 3, 3));

		JLabel lblNewLabel = new JLabel("Tên MH:  ");
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_4.add(lblNewLabel);

		tf_TenMatHang = new JTextField();
		tf_TenMatHang.setText("");
		panel_4.add(tf_TenMatHang);
		tf_TenMatHang.setColumns(15);

		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new BorderLayout(0, 0));

		JPanel panel_6 = new JPanel();
		panel_5.add(panel_6, BorderLayout.NORTH);
		panel_6.setLayout(new FlowLayout(FlowLayout.RIGHT, 3, 3));

		JLabel lblSLng = new JLabel("Số Lượng:  ");
		lblSLng.setForeground(Color.ORANGE);
		lblSLng.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_6.add(lblSLng);

		tf_SoLuong = new JTextField();
		panel_6.add(tf_SoLuong);
		tf_SoLuong.setColumns(15);

		JPanel panel_7 = new JPanel();
		panel_5.add(panel_7, BorderLayout.CENTER);
		panel_7.setLayout(new BorderLayout(0, 0));

		JPanel panel_8 = new JPanel();
		panel_7.add(panel_8, BorderLayout.NORTH);
		panel_8.setLayout(new FlowLayout(FlowLayout.RIGHT, 3, 3));

		JLabel lblvt = new JLabel("ĐVT:  ");
		lblvt.setForeground(Color.ORANGE);
		lblvt.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_8.add(lblvt);

		tf_DonViTinh = new JTextField();
		panel_8.add(tf_DonViTinh);
		tf_DonViTinh.setColumns(15);

		JPanel panel_9 = new JPanel();
		panel_7.add(panel_9, BorderLayout.CENTER);
		panel_9.setLayout(new BorderLayout(0, 0));

		JPanel panel_10 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_10.getLayout();
		flowLayout.setVgap(3);
		flowLayout.setHgap(3);
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel_9.add(panel_10, BorderLayout.NORTH);

		JLabel lblGi = new JLabel("Giá:  ");
		lblGi.setForeground(Color.ORANGE);
		lblGi.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_10.add(lblGi);

		tf_Gia = new JTextField();
		panel_10.add(tf_Gia);
		tf_Gia.setColumns(15);

		JPanel contentPane = new JPanel();
		contentPane_1.add(contentPane, BorderLayout.CENTER);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel_button = new JPanel();
		panel_button.setBorder(new LineBorder(Color.GREEN, 1, true));
		contentPane.add(panel_button, BorderLayout.SOUTH);
		panel_button.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 3));

		btn_them = new JButton("Thêm");
		btn_them.setIcon(new ImageIcon(DatBan_ThucDon.class
				.getResource("/images/valid.png")));
		panel_button.add(btn_them);

		btn_capnhat = new JButton("Cập Nhật");
		btn_capnhat.setIcon(new ImageIcon(DatBan_ThucDon.class
				.getResource("/images/refresh.png")));
		panel_button.add(btn_capnhat);

		btn_thoat = new JButton("Thoát");
		btn_thoat.setIcon(new ImageIcon(DatBan_ThucDon.class
				.getResource("/images/exit.png")));
		panel_button.add(btn_thoat);

		table = new JTable();
		columnames.add(" ID MH ");
		columnames.add(" Tên Mặt Hàng ");
		columnames.add(" ĐVT ");
		columnames.add(" Giá ");

		datamodel = new DefaultTableModel(record, columnames);
		table.setModel(datamodel);

		table.setFillsViewportHeight(true);

		JScrollPane scrollPane = new JScrollPane(table);
		contentPane.add(scrollPane, BorderLayout.CENTER);

		// scrollPane.setColumnHeaderView(table);
		loadData();
		btn_capnhat.addActionListener(this);
		btn_timkiem.addActionListener(this);
		btn_them.addActionListener(this);
		btn_thoat.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnExitActionPerformed(evt);
			}
		});
		row = table.getSelectedRow();
		System.out.println("+ sas " + row);
		table.addMouseListener(this);
	}

	private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {
		this.dispose();
	}

	public static void loadData() {
		loadDatabase_DAO();

	}

	private static void loadDatabase_DAO() {
		List<ThucDon> list = Controller_ThucDon.loadDatabase();
		record = null;
		datamodel = new DefaultTableModel(record, columnames);
		table.setModel(datamodel);

		for (ThucDon thucdon : list) {
			record = new Vector();
			record.addElement(thucdon.getMaMH());
			record.addElement(thucdon.getTenMH());
			record.addElement(thucdon.getDonViTinh());
			record.addElement(thucdon.getGiaBan());

			datamodel.addRow(record);
		}

	}

	private void timkiem(String search) {
		List<ThucDon> list = Controller_ThucDon.timKiem(search);
		record = null;
		datamodel = new DefaultTableModel(record, columnames);
		table.setModel(datamodel);

		for (ThucDon thucdon : list) {
			record = new Vector();
			record.addElement(thucdon.getMaMH());
			record.addElement(thucdon.getTenMH());
			record.addElement(thucdon.getDonViTinh());
			record.addElement(thucdon.getGiaBan());
			datamodel.addRow(record);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String maMH = tf_MaMatHang.getText();
		String tenMH = tf_TenMatHang.getText();
		String soLuong = tf_SoLuong.getText();
		String dvt = tf_DonViTinh.getText();
		String gia = tf_Gia.getText();

		if (e.getSource() == btn_capnhat) {
			loadData();
			JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
		} else if (e.getSource() == btn_timkiem) {
			String search = tf_timkiem.getText();
			if (search.equals("")) {
				JOptionPane.showMessageDialog(this,
						"Bạn chưa nhập thông tin cần tìm kiếm!");
			} else {
				timkiem(search);
			}
		} else if (e.getSource() == btn_them) {
			int si = addMatHangVaoHoaDon(maMH, tenMH, dvt, gia);
			DatBan_Panel.loadDatabase_1();
			if (si == 1) {
				JOptionPane.showMessageDialog(this,
						"Đã thêm MH vào chi tiết Hoá Đơn!");
			} else {
				JOptionPane.showMessageDialog(this, "Đã tăng số lượng mặt hàng!");
			}
		}
	}

	private int addMatHangVaoHoaDon(String maMH, String tenMH, String dvt,
			String gia) {
		int abc = 0;
		boolean checkABC = false;
		if (Controller_HoaDon.checkMaHoaDon(maMH) == true) {
			int i = Controller_HoaDon.laySoLuong(maMH);
			i = i +1;
			int y = Controller_HoaDon.updateSoLuong(maMH, i);
			if (y == 1) {

			} else {
				JOptionPane.showMessageDialog(null,
						"Chưa tăng được số lượng Mặt Hàng có mã là: " + maMH);
			}
		} else {
			double g = Double.parseDouble(gia);
			int soluong = 1;
			double thanhtien = g * soluong;
			String id_ban = DatBan_Panel.getTf_soban_1().getText();
			String ngay = DatBan_Panel.getDatePicker_1()
					.getJFormattedTextField().getText();
			String makhachhang = DatBan_Panel.getTf_maKH_HD_1().getText();

			checkABC = Controller_HoaDon.themHD(maMH, tenMH, soluong, dvt, g,
					thanhtien, id_ban, ngay, makhachhang);
			if (checkABC == true) {
				JOptionPane.showMessageDialog(null, "+ Đã thêm");
			} else {
				JOptionPane.showMessageDialog(null, "+ Chưa thêm");
			}
		}
		if (checkABC == true) {
			abc = 1;
		} else {
			abc = 0;
		}
		return abc;
	}

	@Override
	public void mouseClicked(MouseEvent o) {
		if (o.getSource().equals(DatBan_ThucDon.getTable())) {
			table = DatBan_ThucDon.getTable();

			int row = table.getSelectedRow();

			getTf_MaMatHang().setText((String) datamodel.getValueAt(row, 0));
			getTf_TenMatHang().setText((String) datamodel.getValueAt(row, 1));

			getTf_DonViTinh().setText((String) datamodel.getValueAt(row, 2));
			getTf_Gia().setText(
					(String) String.valueOf(datamodel.getValueAt(row, 3)));
			getTf_MaMatHang().setEditable(false);

			System.out.println("+ Row chọn trong Hoá Don: " + row);

		}

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {

		// ABC_ThucDon.getTf_MaMatHang().setText(
		// (String) datamodel.getValueAt(row, 0));
		// ABC_ThucDon.getTf_TenMatHang().setText(
		// (String) datamodel.getValueAt(row, 1));

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public static JScrollPane getScroll() {
		return scroll;
	}

	public static DefaultTableModel getDatamodel() {
		return datamodel;
	}

	public static Vector getColumnames() {
		return columnames;
	}

	public static Vector getRecord() {
		return record;
	}

	public JPanel getContentPane_1() {
		return contentPane_1;
	}

	public static JTable getTable() {
		return table;
	}

	public ThucdonDB getTd() {
		return td;
	}

	public JTextField getTf_timkiem() {
		return tf_timkiem;
	}

	public static JButton getBtn_capnhat() {
		return btn_capnhat;
	}

	public static JButton getBtn_thoat() {
		return btn_thoat;
	}

	public static JButton getBtn_timkiem() {
		return btn_timkiem;
	}

	public int getI() {
		return i;
	}

	public JButton getBtn_them() {
		return btn_them;
	}

	public static void setScroll(JScrollPane scroll) {
		DatBan_ThucDon.scroll = scroll;
	}

	public static void setDatamodel(DefaultTableModel datamodel) {
		DatBan_ThucDon.datamodel = datamodel;
	}

	public static void setColumnames(Vector columnames) {
		DatBan_ThucDon.columnames = columnames;
	}

	public static void setRecord(Vector record) {
		DatBan_ThucDon.record = record;
	}

	public void setContentPane_1(JPanel contentPane_1) {
		this.contentPane_1 = contentPane_1;
	}

	public static void setTable(JTable table) {
		DatBan_ThucDon.table = table;
	}

	public void setTd(ThucdonDB td) {
		this.td = td;
	}

	public void setTf_timkiem(JTextField tf_timkiem) {
		this.tf_timkiem = tf_timkiem;
	}

	public static void setBtn_capnhat(JButton btn_capnhat) {
		DatBan_ThucDon.btn_capnhat = btn_capnhat;
	}

	public static void setBtn_thoat(JButton btn_thoat) {
		DatBan_ThucDon.btn_thoat = btn_thoat;
	}

	public static void setBtn_timkiem(JButton btn_timkiem) {
		DatBan_ThucDon.btn_timkiem = btn_timkiem;
	}

	public void setI(int i) {
		this.i = i;
	}

	public void setBtn_them(JButton btn_them) {
		this.btn_them = btn_them;
	}

	public static int getRow() {
		return row;
	}

	public static ABC_ThucDon getAbc_ThucDon() {
		return abc_ThucDon;
	}

	public JPanel getPanel_search() {
		return panel_search;
	}

	public static JTextField getTf_MaMatHang() {
		return tf_MaMatHang;
	}

	public static JTextField getTf_TenMatHang() {
		return tf_TenMatHang;
	}

	public static JTextField getTf_SoLuong() {
		return tf_SoLuong;
	}

	public static JTextField getTf_DonViTinh() {
		return tf_DonViTinh;
	}

	public static JTextField getTf_Gia() {
		return tf_Gia;
	}

	public static void setRow(int row) {
		DatBan_ThucDon.row = row;
	}

	public static void setAbc_ThucDon(ABC_ThucDon abc_ThucDon) {
		DatBan_ThucDon.abc_ThucDon = abc_ThucDon;
	}

	public void setPanel_search(JPanel panel_search) {
		this.panel_search = panel_search;
	}

	public static void setTf_MaMatHang(JTextField tf_MaMatHang) {
		DatBan_ThucDon.tf_MaMatHang = tf_MaMatHang;
	}

	public static void setTf_TenMatHang(JTextField tf_TenMatHang) {
		DatBan_ThucDon.tf_TenMatHang = tf_TenMatHang;
	}

	public static void setTf_SoLuong(JTextField tf_SoLuong) {
		DatBan_ThucDon.tf_SoLuong = tf_SoLuong;
	}

	public static void setTf_DonViTinh(JTextField tf_DonViTinh) {
		DatBan_ThucDon.tf_DonViTinh = tf_DonViTinh;
	}

	public static void setTf_Gia(JTextField tf_Gia) {
		DatBan_ThucDon.tf_Gia = tf_Gia;
	}

}
