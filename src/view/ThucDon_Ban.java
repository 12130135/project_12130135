package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;

import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import DAO.ThucdonDB;

import javax.swing.JLabel;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class ThucDon_Ban extends JFrame implements ActionListener {

	private JPanel contentPane_1;
	private JTable table;
	ThucdonDB td = new ThucdonDB();
	private JTextField textField;
	public static JButton btn_capnhat, btn_thoat, btn_timkiem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThucDon_Ban frame = new ThucDon_Ban();
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
	public ThucDon_Ban() {
		setResizable(false);
		setTitle("Thực Đơn");
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				ThucDon_Ban.class.getResource("/image/coffee_mo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 325, 425);
		contentPane_1 = new JPanel();
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane_1);
		contentPane_1.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel.setBorder(new TitledBorder(new LineBorder(new Color(255, 200, 0),
				1, true), "T\u00ECm ki\u1EBFm", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		contentPane_1.add(panel, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("Tìm kiếm");
		panel.add(lblNewLabel);

		textField = new JTextField();
		textField.setText("");
		panel.add(textField);
		textField.setColumns(16);

		btn_timkiem = new JButton("");
		btn_timkiem.setIcon(new ImageIcon(ThucDon_Ban.class
				.getResource("/images/find.png")));
		panel.add(btn_timkiem);

		JPanel contentPane = new JPanel();
		contentPane_1.add(contentPane, BorderLayout.CENTER);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel_button = new JPanel();
		panel_button.setBorder(new LineBorder(Color.GREEN, 1, true));
		contentPane.add(panel_button, BorderLayout.SOUTH);
		panel_button.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 3));

		btn_capnhat = new JButton("Cập Nhật");
		btn_capnhat.setIcon(new ImageIcon(ThucDon_Ban.class
				.getResource("/images/refresh.png")));
		panel_button.add(btn_capnhat);

		btn_thoat = new JButton("Thoát");
		btn_thoat.setIcon(new ImageIcon(ThucDon_Ban.class
				.getResource("/images/exit.png")));
		panel_button.add(btn_thoat);
		table = new JTable();
		JScrollPane scrollPane = new JScrollPane(table);
		contentPane.add(scrollPane, BorderLayout.CENTER);

		// scrollPane.setColumnHeaderView(table);
		loadData();
		btn_capnhat.addActionListener(this);
		btn_timkiem.addActionListener(this);
		btn_thoat.addActionListener(this);
	}

	public void loadData() {
		DefaultTableModel df = new DefaultTableModel();
		String[] thucdon = { "Mã mặt hàng", " Tên mặt hàng", " Đơn vị",
				" Giá bán" };

		df.setColumnIdentifiers(thucdon);
		ResultSet rs = td.getdata();
		try {
			ResultSetMetaData md = rs.getMetaData();
			int colNumber = md.getColumnCount();
			String[] name = new String[colNumber];

			while (rs.next()) {
				for (int i = 0; i < colNumber; i++) {
					name[i] = rs.getString(i + 1);
				}
				df.addRow(name);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		table.setModel(df);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn_capnhat) {
			loadData();
			JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
		} else if (e.getSource() == btn_thoat) {
			int click = JOptionPane.showConfirmDialog(null, "Bạn muốn thoát",
					"Thoát!", JOptionPane.YES_NO_OPTION);
			if (click == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		} else if (e.getSource() == btn_timkiem) {

		}
	}

}
