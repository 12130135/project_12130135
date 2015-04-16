package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class ABC_ThucDon extends JFrame implements ActionListener{
	public static JButton btn_them, btn_nhaplai, btn_thoat;
	private static JTextField tf_MaMatHang;
	private static JTextField tf_TenMatHang;
	private static JTextField tf_SoLuong;
	private static JTextField tf_DonViTinh;
	private static JTextField tf_Gia;
	private static JFrame frame;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ABC_ThucDon frame = new ABC_ThucDon();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ABC_ThucDon() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(127, 255, 212));
		panel.setBorder(new LineBorder(Color.ORANGE, 1, true));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblThmThcn = new JLabel("Thêm Thực Đơn");
		lblThmThcn.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(lblThmThcn);

		JPanel panel_1fs = new JPanel();
		contentPane.add(panel_1fs, BorderLayout.CENTER);
		panel_1fs.setLayout(new BorderLayout(0, 0));

		JPanel panel_chucnang = new JPanel();
		panel_chucnang.setBorder(new TitledBorder(new LineBorder(new Color(0,
				255, 0), 1, true), "Ph\u00EDm ch\u1EE9c n\u0103ng: ",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1fs.add(panel_chucnang, BorderLayout.SOUTH);
		panel_chucnang.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10));

		btn_them = new JButton("Thêm");
		btn_them.setIcon(new ImageIcon(ABC_ThucDon.class
				.getResource("/images/valid.png")));
		panel_chucnang.add(btn_them);

		btn_nhaplai = new JButton("Nhập lại");
		btn_nhaplai.setIcon(new ImageIcon(ABC_ThucDon.class
				.getResource("/images/refresh.png")));
		panel_chucnang.add(btn_nhaplai);

		btn_thoat = new JButton("");
		btn_thoat.setIcon(new ImageIcon(ABC_ThucDon.class
				.getResource("/images/exit.png")));
		panel_chucnang.add(btn_thoat);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.GREEN, 1, true));
		panel_1fs.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 8));

		JLabel lblMMh = new JLabel("Mã MH:  ");
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
		panel_4.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));

		JLabel lblNewLabel = new JLabel("Tên MH:  ");
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
		panel_6.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));

		JLabel lblSLng = new JLabel("Số Lượng:  ");
		panel_6.add(lblSLng);

		tf_SoLuong = new JTextField();
		panel_6.add(tf_SoLuong);
		tf_SoLuong.setColumns(15);

		JPanel panel_7 = new JPanel();
		panel_5.add(panel_7, BorderLayout.CENTER);
		panel_7.setLayout(new BorderLayout(0, 0));

		JPanel panel_8 = new JPanel();
		panel_7.add(panel_8, BorderLayout.NORTH);
		panel_8.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));

		JLabel lblvt = new JLabel("ĐVT:  ");
		panel_8.add(lblvt);

		tf_DonViTinh = new JTextField();
		panel_8.add(tf_DonViTinh);
		tf_DonViTinh.setColumns(15);

		JPanel panel_9 = new JPanel();
		panel_7.add(panel_9, BorderLayout.CENTER);
		panel_9.setLayout(new BorderLayout(0, 0));

		JPanel panel_10 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_10.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel_9.add(panel_10, BorderLayout.NORTH);

		JLabel lblGi = new JLabel("Giá:  ");
		panel_10.add(lblGi);

		tf_Gia = new JTextField();
		panel_10.add(tf_Gia);
		tf_Gia.setColumns(15);

		btn_nhaplai.addActionListener(this);
		btn_them.addActionListener(this);
		btn_thoat.addActionListener(this);
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn_nhaplai) {
			clearSoLuong();
		} else if (e.getSource() == btn_them) {
		} else if (e.getSource() == btn_thoat) {
		}
	}

	private void clearSoLuong() {
		tf_SoLuong.setText("");
	}

	public static JButton getBtn_them() {
		return btn_them;
	}

	public static JButton getBtn_nhaplai() {
		return btn_nhaplai;
	}

	public static JButton getBtn_thoat() {
		return btn_thoat;
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

	public static JFrame getFrame() {
		return frame;
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public static void setBtn_them(JButton btn_them) {
		ABC_ThucDon.btn_them = btn_them;
	}

	public static void setBtn_nhaplai(JButton btn_nhaplai) {
		ABC_ThucDon.btn_nhaplai = btn_nhaplai;
	}

	public static void setBtn_thoat(JButton btn_thoat) {
		ABC_ThucDon.btn_thoat = btn_thoat;
	}

	public static void setTf_MaMatHang(JTextField tf_MaMatHang) {
		ABC_ThucDon.tf_MaMatHang = tf_MaMatHang;
	}

	public static void setTf_TenMatHang(JTextField tf_TenMatHang) {
		ABC_ThucDon.tf_TenMatHang = tf_TenMatHang;
	}

	public static void setTf_SoLuong(JTextField tf_SoLuong) {
		ABC_ThucDon.tf_SoLuong = tf_SoLuong;
	}

	public static void setTf_DonViTinh(JTextField tf_DonViTinh) {
		ABC_ThucDon.tf_DonViTinh = tf_DonViTinh;
	}

	public static void setTf_Gia(JTextField tf_Gia) {
		ABC_ThucDon.tf_Gia = tf_Gia;
	}

	public static void setFrame(JFrame frame) {
		ABC_ThucDon.frame = frame;
	}

	public void setContentPane(JPanel contentPane) {
		this.contentPane = contentPane;
	}
	
	

}
