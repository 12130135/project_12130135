package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import model.DoiMatKhau;
import model.TaiKhoan;

public class DoiMatKhau_Panel extends JPanel {
	static JTextField textUser = new JTextField();
	static JPasswordField textPass = new JPasswordField();
	static JPasswordField textRe_pass = new JPasswordField();
	TitlePanel title_Panel;

	/**
	 * Create the panel.
	 */
	public DoiMatKhau_Panel() {
		
		JLabel lbliMtKhu = new JLabel();
		add(lbliMtKhu);

		title_Panel = new TitlePanel("Quản Lý Mặt Hàng");
		//panel_Title.add(title_Panel);
		
		
		final JPanel pTaiKhoan = new JPanel();
		
		lbliMtKhu.setBorder(new TitledBorder("Đổi Mật Khẩu"));
		lbliMtKhu.setPreferredSize(new Dimension(485,250));
		pTaiKhoan.add(lbliMtKhu);
		pTaiKhoan.add(title_Panel, BorderLayout.PAGE_END);
		
		final JLabel lThongBao = new JLabel("");
		lThongBao.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lThongBao.setForeground(new Color(255, 0, 0));
		lThongBao.setBounds(70, 200, 350, 30);
		lbliMtKhu.add(lThongBao);
		
		JLabel user = new JLabel("Tên đăng nhập:");
		user.setBounds(70, 20, 173, 30);
		lbliMtKhu.add(user);
		
		JLabel pass = new JLabel("Mật khẩu mới:");
		pass.setBounds(70, 60, 173, 30);
		lbliMtKhu.add(pass);
		
		JLabel re_pass = new JLabel("Nhập lại mật khẩu:");
		re_pass.setBounds(70, 100, 173, 30);
		lbliMtKhu.add(re_pass);
		
		JButton click = new JButton("Hoàn tất");
		click.setBounds(110, 160, 100, 30);
		lbliMtKhu.add(click);
		
		click.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String user = textUser.getText();
				String pass = textPass.getText();
				String re_pass = textRe_pass.getText();
				try {

					if(  !pass.equals("")&& !re_pass.equals("")){
						if(!pass.equals(re_pass)){
							lThongBao.setText("Mật khẩu nhập lại không đúng!");
							pTaiKhoan.repaint();
							DoiMatKhau_Panel.this.repaint();
						}
						else if (DoiMatKhau.doiMatKhau(user, pass)) {
						
						lThongBao.setText("Bạn đã thay đổi mật khẩu thành công!");
						clearTextField();
						pTaiKhoan.repaint();
						DoiMatKhau_Panel.this.repaint();
						
					//	Run_DieuHuong.dmk.setVisible(false);
					} 
						}else {
						if (user.equals("") && pass.equals("")) {
							lThongBao
									.setText("Bạn chưa nhập Tên Tài Khoản và Mật Khẩu");
							pTaiKhoan.repaint();
							DoiMatKhau_Panel.this.repaint();
						} else {
							boolean checkUser = TaiKhoan
									.checkUser(user);
							if (checkUser == true) {
								if (pass.equals("")) {
									lThongBao
											.setText("Bạn chưa nhập Mật Khẩu!. *vui lòng thử lại* ");
									pTaiKhoan.repaint();
									DoiMatKhau_Panel.this.repaint();
								} else {

									lThongBao
											.setText("Bạn chưa nhập đầy đủ!. *vui lòng thử lại* ");
									pTaiKhoan.repaint();
									DoiMatKhau_Panel.this.repaint();
								}
							} else {
								lThongBao
										.setText("Tên Đăng Nhập không tồn tại!. *vui lòng thử lại* ");
								pTaiKhoan.repaint();
								DoiMatKhau_Panel.this.repaint();
							}
						}
					}
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				
			
			
		}

			private void clearTextField() {
				textPass.setText("");
				textUser.setText("");
				textRe_pass.setText("");
			}

				
			});
		
		JButton huy = new JButton("Hủy");
		huy.setBounds(250, 160, 100, 30);
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
		lbliMtKhu.add(huy);
		
		textUser.setBounds(250, 20, 173, 30);
		lbliMtKhu.add(textUser);
		
		textPass.setBounds(250, 60, 173, 30);
		lbliMtKhu.add(textPass);
		
		textRe_pass.setBounds(250, 100, 173, 30);
		lbliMtKhu.add(textRe_pass);
		
		add(lbliMtKhu, BorderLayout.LINE_START );
		
	//	getRootPane().add(pTaiKhoan, BorderLayout.CENTER);
		
		setBounds(200, 200, 429, 308);
	//	setTitle("Đổi mật khẩu");
		setVisible(true);
		setSize(500, 300);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
		public static void main(String[] args) {
			DoiMatKhau_Panel dmk = new DoiMatKhau_Panel();
			dmk.setVisible(true);
		}
	}
