package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;

import javax.swing.border.LineBorder;
import javax.swing.text.html.Option;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.DropMode;

import model.TaiKhoan;
import net.miginfocom.swing.MigLayout;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import controller.Action;
import controller.App_Run;

import java.awt.Toolkit;
import java.awt.Window.Type;
import java.sql.Time;
import java.util.Timer;

public class V_DangNhap extends JFrame {

	private JPanel contentPane;
	private static JTextField textField_user;
	private static JPasswordField passwordField;
	final public JLabel label_SuKien;
	public JLabel welcome_login;

	public static String text;

	private static TaiKhoan user;
	private Action action;

	/**
	 * Create the frame.
	 */
	public V_DangNhap() {

		setResizable(false);
		setType(Type.POPUP);
		setTitle("Login start");
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				V_DangNhap.class.getResource("/images/home.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 429, 308);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel_ChaoMung = new JPanel();
		panel_ChaoMung.setBorder(new LineBorder(new Color(0, 255, 0), 1, true));
		contentPane.add(panel_ChaoMung, BorderLayout.NORTH);
		panel_ChaoMung.setLayout(new GridLayout(2, 0, 5, 9));

		JLabel lblWelcomeToLogin = new JLabel("Welcome to Login!");
		lblWelcomeToLogin.setForeground(new Color(60, 179, 113));
		lblWelcomeToLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToLogin.setLabelFor(this);
		lblWelcomeToLogin.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
		panel_ChaoMung.add(lblWelcomeToLogin);

		// label sự kiện
		label_SuKien = new JLabel("");
		label_SuKien.setHorizontalAlignment(SwingConstants.CENTER);
		panel_ChaoMung.add(label_SuKien);
		label_SuKien.setFont(new Font("Times New Roman", Font.BOLD, 16));
		label_SuKien.setForeground(new Color(255, 0, 0));
		label_SuKien.setBounds(86, 40, 300, 28);
		label_SuKien.setText("Thời gian hệ thống: " + model.Time.layThoiGian());

		JPanel panel_footer = new JPanel();
		panel_footer.setBorder(new LineBorder(new Color(0, 255, 0), 1, true));
		FlowLayout fl_panel_footer = (FlowLayout) panel_footer.getLayout();
		fl_panel_footer.setVgap(3);
		contentPane.add(panel_footer, BorderLayout.SOUTH);

		JLabel lblCopyrightProduction = new JLabel(
				"Copyright! @ Production Group 15 ");
		panel_footer.add(lblCopyrightProduction);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(255, 0, 0), 1, true));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		// -****************** Sử lý sự kiện ***************************-
		JPanel panel_nut_button = new JPanel();
		panel_nut_button.setBorder(new LineBorder(new Color(0, 255, 255), 1,
				true));
		panel.add(panel_nut_button, BorderLayout.SOUTH);
		FlowLayout fl_panel_nut_button = new FlowLayout(FlowLayout.RIGHT, 15, 0);
		fl_panel_nut_button.setAlignOnBaseline(true);
		panel_nut_button.setLayout(fl_panel_nut_button);

		JButton btnngNhp = new JButton("Đăng Nhập");
		btnngNhp.setHorizontalAlignment(SwingConstants.RIGHT);
		btnngNhp.setIcon(new ImageIcon(V_DangNhap.class
				.getResource("/images/locked.png")));
		panel_nut_button.add(btnngNhp);

		// **************************************bổ sung
		btnngNhp.addActionListener(new ActionListener() {
			// Button Đăng Nhập=============================
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String tenTaiKhoan = textField_user.getText();
				String matKhau = passwordField.getText();
				boolean checkLogin;
				checkLogin = TaiKhoan.checkLogin(tenTaiKhoan, matKhau);
				if (checkLogin == true) {
					label_SuKien.setText("Bạn đã đăng nhập thành công!");
					contentPane.repaint();
					V_DangNhap.this.repaint();

					App_Run.dangNhap.setVisible(false);
					// đăng nhập thành công chuyển sang MainFrame.
					// App_Run.mainFrame = new MainFrame();
					new MainFrame();

					label_SuKien.setText("Bạn đã đăng nhập thành công!");
					contentPane.repaint();
					V_DangNhap.this.repaint();
				} else {
					if (tenTaiKhoan.equals("") && matKhau.equals("")) {
						label_SuKien
								.setText("Bạn chưa nhập Tên Tài Khoản và Mật Khẩu");
						contentPane.repaint();
						V_DangNhap.this.repaint();
					} else {
						boolean checkUser = TaiKhoan.checkUser(tenTaiKhoan);
						if (checkUser == true) {
							if (matKhau.equals("")) {
								label_SuKien
										.setText("Bạn chưa nhập Mật Khẩu!. *vui lòng thử lại* ");
								contentPane.repaint();
								V_DangNhap.this.repaint();
							} else {

								label_SuKien
										.setText("Bạn đã nhập sai Mật Khẩu!. *vui lòng thử lại* ");
								contentPane.repaint();
								V_DangNhap.this.repaint();
							}
						} else {
							label_SuKien
									.setText("Tên Đăng Nhập không tồn tại!. *vui lòng thử lại* ");
							contentPane.repaint();
							V_DangNhap.this.repaint();
						}
					}
				}
			}
		});

		JButton btnHy = new JButton("Hủy");
		btnHy.setIcon(new ImageIcon(V_DangNhap.class
				.getResource("/images/cancel.png")));
		panel_nut_button.add(btnHy);
		btnHy.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent huy) {
				// System.exit(0);
				thongBAo(huy);
			}

			private void thongBAo(ActionEvent huy) {
				int click = JOptionPane.showConfirmDialog(
						null,
						"Bạn muốn thoát",
						"Thoát!",
						JOptionPane.YES_NO_OPTION);
				if (click == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});

		// ========================================================================
		JPanel panel_user_pass = new JPanel();
		panel.add(panel_user_pass, BorderLayout.CENTER);
		panel_user_pass.setLayout(null);

		JLabel lblTnngNhp = new JLabel(" Tên Đăng Nhập");
		lblTnngNhp.setIcon(new ImageIcon(V_DangNhap.class
				.getResource("/images/user.png")));
		lblTnngNhp.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblTnngNhp.setBounds(20, 21, 176, 32);
		panel_user_pass.add(lblTnngNhp);

		JLabel lblMtKhu = new JLabel(" Mật Khẩu");
		lblMtKhu.setIcon(new ImageIcon(V_DangNhap.class
				.getResource("/images/key.png")));
		lblMtKhu.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblMtKhu.setBounds(23, 75, 160, 34);
		panel_user_pass.add(lblMtKhu);

		textField_user = new JTextField();
		textField_user.setBounds(206, 23, 173, 30);
		panel_user_pass.add(textField_user);
		textField_user.setColumns(20);

		passwordField = new JPasswordField();
		passwordField.setActionCommand("pass");
		passwordField.setBounds(206, 75, 173, 30);
		panel_user_pass.add(passwordField);
	}

	public static JTextField getTextField_user() {
		return textField_user;
	}

	public void setTextField_user(JTextField textField_user) {
		this.textField_user = textField_user;
	}

	public static JPasswordField getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}

	public JLabel getLabel_SuKien() {
		return label_SuKien;
	}

	public static String getPhanQuyen(String u) {
		return user.getPhanQuyen(u);
	}
}
