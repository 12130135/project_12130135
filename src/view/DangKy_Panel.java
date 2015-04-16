package view;

import java.awt.BorderLayout; 
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import model.TaiKhoan;

public class DangKy_Panel extends JPanel {
	static JTextField textUser = new JTextField();
	static JTextField textChucVu = new JTextField();
	static JPasswordField textPass = new JPasswordField();
	static JPasswordField textRe_pass = new JPasswordField();
	private JPanel title_Panel;
	private JPanel dangKy;

	/**
	 * Create the panel.
	 */
	public DangKy_Panel() {
		JLabel lblHi = new JLabel();

		// JPanel panel_Title = new JPanel();
		// panel_Title.setBorder(new LineBorder(Color.ORANGE, 1, true));
		// FlowLayout fl_panel_Title = (FlowLayout) panel_Title.getLayout();
		// panel_Title.setPreferredSize(new Dimension(485,250));
		// add(panel_Title, BorderLayout.CENTER);
		//
		// title_Panel = new TitlePanel("");
		// panel_Title.add(title_Panel);

		dangKy = new JPanel();
		lblHi.setBorder(new TitledBorder("Đăng ký"));
		lblHi.setPreferredSize(new Dimension(580, 370));
		dangKy.add(lblHi);

		final JLabel lThongBao = new JLabel("");
		lThongBao.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lThongBao.setForeground(new Color(255, 0, 0));
		lThongBao.setBounds(90, 315, 350, 30);
		lblHi.add(lThongBao);

		JLabel user = new JLabel("Tên đăng nhập:");
		user.setBounds(90, 30, 173, 30);
		lblHi.add(user);

		JLabel pass = new JLabel("Mật khẩu:");
		pass.setBounds(90, 90, 173, 30);
		lblHi.add(pass);

		JLabel re_pass = new JLabel("Nhập lại mật khẩu:");
		re_pass.setBounds(90, 150, 173, 30);
		lblHi.add(re_pass);

		JLabel chucVu = new JLabel("Chức vụ:");
		chucVu.setBounds(90, 210, 173, 30);
		lblHi.add(chucVu);

		final JRadioButton radCo = new JRadioButton();
		radCo.setBounds(300, 200, 173, 30);
		final JRadioButton radKhong = new JRadioButton();
		radKhong.setBounds(300, 230, 173, 30);
		radCo.setText("Quyền quản lý");
		radKhong.setText("Thường");

		lblHi.add(radCo);
		lblHi.add(radKhong);

		final ButtonGroup btnGroup = new ButtonGroup();
		btnGroup.add(radKhong);
		btnGroup.add(radCo);

		JButton click = new JButton("Hoàn tất");
		click.setBounds(150, 270, 100, 30);
		lblHi.add(click);

		click.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String user = textUser.getText();
				int lent = user.length();
				String chucVu = "0";
				String pass = textPass.getText();
				String re_pass = textRe_pass.getText();

				if (radCo.isSelected()) {
					chucVu = "1";
				}
				if (user.equals("")) {
					lThongBao.setText("Bạn chưa nhập tên tài khoản!");
					dangKy.repaint();
					DangKy_Panel.this.repaint();
				} else if (lent < 6) {
					lThongBao.setText("Tên Đăng Nhập phải lớn hơn 6 ký tự");
					dangKy.repaint();
					DangKy_Panel.this.repaint();
				} else if (!pass.equals(re_pass)) {
					lThongBao.setText("Bạn đã nhập lại mật khẩu sai!");
					dangKy.repaint();
					DangKy_Panel.this.repaint();
				} else if (TaiKhoan.checkUser(user) == true) {
					lThongBao.setText("Tên tài khoản đã tồn tại!");
					dangKy.repaint();
					DangKy_Panel.this.repaint();
				} else {
					TaiKhoan taikhoan = new TaiKhoan(user, pass, chucVu);
					boolean abc = TaiKhoan.addUser(taikhoan);
					if (abc == true) {
						lThongBao.setText("Đăng ký thành công!");
						dangKy.repaint();
						DangKy_Panel.this.repaint();
						clearTextField();
					} else {
						lThongBao.setText("Đăng ký không thành công!");
						dangKy.repaint();
						DangKy_Panel.this.repaint();
					}
				}

				// try {if(radCo.isSelected()){
				// chucVu="1";
				// }
				//
				// if(user.equals("")){
				// lThongBao.setText("Bạn chưa nhập tài khoản!");
				// dangKy.repaint();
				// DangKy_Panel.this.repaint();
				// }else if(user.length()<6){
				// lThongBao.setText("Tài khoản có độ dài quá ngắn!");
				// dangKy.repaint();
				// DangKy_Panel.this.repaint();
				// }else if(pass.equals("")){
				// lThongBao.setText("Bạn chưa nhập mật khẩu!");
				// dangKy.repaint();
				// DangKy_Panel.this.repaint();
				// }else if(pass.length()<6){
				// lThongBao.setText("Mật khẩu có độ dài quá ngắn!");
				// dangKy.repaint();
				// DangKy_Panel.this.repaint();
				// }else if(re_pass.equals("")){
				// lThongBao.setText("Bạn chưa nhập đầy đủ!");
				// dangKy.repaint();
				// DangKy_Panel.this.repaint();
				// }else if(DangKy.checkUser(user)){
				// lThongBao.setText("Tên tài khoản đã tồn tại!");
				// dangKy.repaint();
				// DangKy_Panel.this.repaint();
				// }else if(pass.equals(re_pass)){
				// if (DangKy.dangKy(user, pass, chucVu)){
				// lThongBao.setText("Bạn đã đăng ký thành công!");
				// clearTextField();
				// dangKy.repaint();
				// DangKy_Panel.this.repaint();
				//
				// }
				// }else {
				// lThongBao.setText("Mật khẩu không trùng khớp!");
				// dangKy.repaint();
				// DangKy_Panel.this.repaint();
				// }
				// } catch (Exception e2) {
				//
				// }

			}

			private void clearTextField() {
				textPass.setText("");
				textUser.setText("");
				textRe_pass.setText("");
				textChucVu.setText("");

				btnGroup.clearSelection();

			}
		});

		JButton huy = new JButton("Hủy");
		huy.setBounds(300, 270, 100, 30);
		huy.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent huy) {
				// System.exit(0);
				thongBAo(huy);
			}

			private void thongBAo(ActionEvent huy) {
				int click = JOptionPane.showConfirmDialog(null,
						"Bạn muốn thoát", "Thoát!", JOptionPane.YES_NO_OPTION);

				if (click == JOptionPane.YES_OPTION) {
					lThongBao.setText("");
					setVisible(false);
				}
			}
		});
		lblHi.add(huy);

		textUser.setBounds(300, 30, 173, 30);
		lblHi.add(textUser);

		textPass.setBounds(300, 90, 173, 30);
		lblHi.add(textPass);

		textRe_pass.setBounds(300, 150, 173, 30);
		lblHi.add(textRe_pass);

		// textChucVu.setBounds(300, 210, 173, 30);
		// lblHi.add(textChucVu);

		add(dangKy, BorderLayout.CENTER);

	}
}
