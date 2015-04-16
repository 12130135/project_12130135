package view;

import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import java.awt.FlowLayout;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.BoxLayout;

public class TroGiup_Panel extends JPanel {

	/**
	 * Create the panel.
	 */
	public TroGiup_Panel() {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 28, 1002, 493);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JLabel dangnhap = new JLabel("Đăng nhập ");
		dangnhap.setIcon(new ImageIcon(TroGiup_Panel.class.getResource("/image2/longga.png")));
		panel.add(dangnhap);
		
		JLabel lblNewLabel_1 = new JLabel("Bạn diền tên tài khoản và mật khẩu sau dó click dang nhập dể vào hệ thống.");
		panel.add(lblNewLabel_1);
		
		JLabel dangnhaptrogip = new JLabel("");
		dangnhaptrogip.setIcon(new ImageIcon(TroGiup_Panel.class.getResource("/image2/dangnhapht.jpg")));
		panel.add(dangnhaptrogip);
		
		JLabel lblNewLabel_3 = new JLabel("Trang giới thiệu hiện ra giúp người dùng hiểu hơn về ứng dụng của chúng tui đồng thời menu ứng dụng giúp cho khách hàng tương tác dễ dàng với hệ thống ");
		lblNewLabel_3.setIcon(new ImageIcon(TroGiup_Panel.class.getResource("/image2/longga.png")));
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(TroGiup_Panel.class.getResource("/image2/gioithieu.png")));
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Giao diện quản lý phục vụ khách hàng");
		lblNewLabel_5.setIcon(new ImageIcon("image2/longga.png"));
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Thiết kế đơn giản nhưng hiệu quả Quản lý bán hàng, quản lý bàn, quản lý việc tách, ghép hóa đơn, chuyển bàn, thanh toán... Hỗ trợ in bếp linh hoạt");
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(TroGiup_Panel.class.getResource("/image2/datban.png")));
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Quản lý thực đơn");
		lblNewLabel_8.setIcon(new ImageIcon(TroGiup_Panel.class.getResource("/image2/longga.png")));
		panel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Giá bán, đơn vị thay đổi dễ dàng Tạo công thức chế biến cho thực đơn rất đơn giản, chính xác. Hệ thống tìm kiếm thực đơn chuyên nghiệp và tiện lợi");
		panel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setIcon(new ImageIcon(TroGiup_Panel.class.getResource("/image2/thudon.png")));
		panel.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Quản lý mặt  hàng");
		lblNewLabel_11.setIcon(new ImageIcon(TroGiup_Panel.class.getResource("/image2/longga.png")));
		panel.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Mặt hàng được thiết kế rõ ràng, rành mạch thể hiện chính xác số lượng tồn kho giúp cho người quản lý định lượng một cách dễ dàng");
		panel.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("");
		lblNewLabel_13.setIcon(new ImageIcon(TroGiup_Panel.class.getResource("/image2/mathang.png")));
		panel.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel(" Quản lý thành viên");
		lblNewLabel_14.setIcon(new ImageIcon(TroGiup_Panel.class.getResource("/image2/longga.png")));
		panel.add(lblNewLabel_14);
		
		JLabel lblNewLabel_18 = new JLabel("Theo dõi hồ sơ nhân viên (Họ tên, điện thoại, quê quán, hình ảnh…..)");
		panel.add(lblNewLabel_18);
		
		JLabel lblNewLabel_15 = new JLabel("");
		lblNewLabel_15.setIcon(new ImageIcon(TroGiup_Panel.class.getResource("/image2/nhanvien.png")));
		panel.add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("Quản lý khach hàng");
	lblNewLabel_16.setIcon(new ImageIcon(TroGiup_Panel.class.getResource("/image2/longga.png")));
		panel.add(lblNewLabel_16);
		
		JLabel lblQunLChi = new JLabel("Quản lý chi tiết khách hàng (Tên khách hàng, điện thoại, địa chỉ, hình ảnh…)");
		panel.add(lblQunLChi);
		
		JLabel lblNewLabel_17 = new JLabel("");
		lblNewLabel_17.setIcon(new ImageIcon(TroGiup_Panel.class.getResource("/image2/khachhang.png")));
		panel.add(lblNewLabel_17);
		
		JLabel lblNewLabel_19 = new JLabel("Tổng hợp các tính năng khác");
lblNewLabel_19	.setIcon(new ImageIcon(TroGiup_Panel.class.getResource("/image2/longga.png")));
		panel.add(lblNewLabel_19);
		
		JLabel lblNewLabel_20 = new JLabel("Tùy chỉnh hóa đơn in ấn dễ hàng");
		lblNewLabel_20.setIcon(new ImageIcon(TroGiup_Panel.class.getResource("/image2/ht.png")));
		panel.add(lblNewLabel_20);
		
		JLabel lblNewLabel_22 = new JLabel("");
		lblNewLabel_22.setIcon(new ImageIcon(TroGiup_Panel.class.getResource("/image2/inan.png")));
		panel.add(lblNewLabel_22);
		
		JLabel lblNewLabel_21 = new JLabel("Xuất thông tin ra excel");
		lblNewLabel_21.setIcon(new ImageIcon(TroGiup_Panel.class.getResource("/image2/ht.png")));
		panel.add(lblNewLabel_21);
		
		JLabel lblNewLabel_23 = new JLabel("");
		lblNewLabel_23.setIcon(new ImageIcon(TroGiup_Panel.class.getResource("/image2/excel.png")));
		panel.add(lblNewLabel_23);
		
		JLabel lblngK = new JLabel(" Đăng ký");
	lblngK.setIcon(new ImageIcon(TroGiup_Panel.class.getResource("/image2/longga.png")));
		panel.add(lblngK);
		
		JLabel lblNewLabel_24 = new JLabel("");
		lblNewLabel_24.setIcon(new ImageIcon(TroGiup_Panel.class.getResource("/image2/Dangki.png")));
		panel.add(lblNewLabel_24);
		
		JLabel lblNewLabel_25 = new JLabel("Đổi mật khẩu");
		lblNewLabel_25.setIcon(new ImageIcon(TroGiup_Panel.class.getResource("/image2/longga.png")));
		panel.add(lblNewLabel_25);
		
		JLabel lblIconmk = new JLabel("");
		lblIconmk.setIcon(new ImageIcon(TroGiup_Panel.class.getResource("/image2/doimatkhau.png")));
		panel.add(lblIconmk);
		
		
		
		

	}
	public static void main(String[] args) throws SQLException {
		JFrame f = new JFrame();

		TroGiup_Panel ds = new TroGiup_Panel();

		f.setDefaultCloseOperation(3);

		f.getContentPane().add(ds);

		f.setVisible(true);
		f.setSize(1190, 450);

	}
}
