package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import java.awt.Font;

public class GioiThieu_Panel extends JPanel {

	/**
	 * Create the panel.
	 */
	public GioiThieu_Panel() {
		setLayout(null);
		
		JLabel lblChoMngQu = new JLabel("Chào mừng quý khách đến với phần mềm quản lý quán cafe của chúng tôi");
		lblChoMngQu.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblChoMngQu.setForeground(new Color(255, 0, 0));
		lblChoMngQu.setIcon(new ImageIcon(GioiThieu_Panel.class.getResource("/image2/images (12).jpg")));
		lblChoMngQu.setBounds(182, 11, 749, 91);
		add(lblChoMngQu);
		
		JLabel lblNewLabel = new JLabel("Trong thời đại hiện nay  ngày càng có nhiều nhà hàng, khách sạn, quán ăn mở lên ngày càng nhiều và với những quy mô vô cùng lớn ");
		lblNewLabel.setIcon(new ImageIcon(GioiThieu_Panel.class.getResource("/image2/conchim.png")));
		lblNewLabel.setBounds(25, 110, 1038, 38);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Biết được những khó khăn mà các doanh nghiệp đang gặp phải trong quá trình quản lý nên chúng tôi đã ");
		lblNewLabel_1.setIcon(new ImageIcon(GioiThieu_Panel.class.getResource("/image2/conchim.png")));
		lblNewLabel_1.setBounds(25, 180, 827, 38);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Thực hiện bán hàng dễ dàng, hỗ trợ ghi chú món, thêm, hủy món, chuyển bàn, gộp bàn, tách hóa đơn...");
		lblNewLabel_2.setIcon(new ImageIcon(GioiThieu_Panel.class.getResource("/image2/longga.png")));
		lblNewLabel_2.setBounds(91, 316, 805, 29);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Nắm rõ trạng thái phục vụ từng bàn, từng món, tránh để khách đợi quá lâu");
		lblNewLabel_3.setIcon(new ImageIcon(GioiThieu_Panel.class.getResource("/image2/longga.png")));
		lblNewLabel_3.setBounds(91, 345, 608, 38);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Thiết lập danh mục thực đơn, danh mục mặt hàng, cấu hình các khu vực và bàn linh hoạt");
		lblNewLabel_4.setIcon(new ImageIcon(GioiThieu_Panel.class.getResource("/image2/longga.png")));
		lblNewLabel_4.setBounds(91, 383, 608, 29);
		add(lblNewLabel_4);
		
		JLabel lblQunLKho = new JLabel("Quản lý kho hàng chặt chẽ, định lượng tránh thất thoát");
		lblQunLKho.setIcon(new ImageIcon(GioiThieu_Panel.class.getResource("/image2/longga.png")));
		lblQunLKho.setBounds(91, 416, 507, 29);
		add(lblQunLKho);
		
		JLabel lblNewLabel_5 = new JLabel("Tổng hợp thu chi, báo cáo thống kê đầy đủ chi tiết");
		lblNewLabel_5.setIcon(new ImageIcon(GioiThieu_Panel.class.getResource("/image2/longga.png")));
		lblNewLabel_5.setBounds(91, 450, 427, 29);
		add(lblNewLabel_5);
		
		JLabel lblViGiiPhp = new JLabel("Công nghệ phần mềm luôn thay đổi và phát triển, chúng tôi cũng vậy. Các phần mềm và giải pháp mà chúng tôi đã và đang xây dựng ");
		lblViGiiPhp.setIcon(new ImageIcon(GioiThieu_Panel.class.getResource("/image2/conchim.png")));
		lblViGiiPhp.setBounds(25, 478, 1130, 38);
		add(lblViGiiPhp);
		
		JLabel lblKhngChGii = new JLabel(" Giải quyết được những yêu cầu từ phía chủ đầu tư và nhà quản lý  mang đến những giá trị gia tăng tốt nhất dành cho khách hàng");
		lblKhngChGii.setIcon(new ImageIcon(GioiThieu_Panel.class.getResource("/image2/longga.png")));
		lblKhngChGii.setBounds(91, 247, 949, 38);
		add(lblKhngChGii);
		
		JLabel lblGiaoDinn = new JLabel(" Giao diện đơn giản nhưng sinh động theo chuẩn quản lý nhà hàng cà phê, dễ sử dụng");
		lblGiaoDinn.setIcon(new ImageIcon(GioiThieu_Panel.class.getResource("/image2/longga.png")));
		lblGiaoDinn.setBounds(91, 284, 651, 29);
		add(lblGiaoDinn);
		
		JLabel lblNewLabel_6 = new JLabel("vì thế việc quản lý quán cafe  và một vấn đề nan giải đối với nhiều doanh nghiệp");
		lblNewLabel_6.setBounds(66, 153, 582, 29);
		add(lblNewLabel_6);
		
		JLabel lblNewLabel_8 = new JLabel(" sẽ ngày càng phát triển hoàn thiện hơn, đưa ra các tính năng mới, hiệu quả và dễ sử dụng hơn.");
		lblNewLabel_8.setBounds(66, 516, 633, 29);
		add(lblNewLabel_8);
		
		JLabel label = new JLabel(" xây dựng phần mềm quản lý cafe với những ưu điểm vượt bậc nhất");
		label.setBounds(66, 221, 562, 23);
		add(label);

	}

	public static void main(String[] args) throws SQLException {
		JFrame f = new JFrame();

		GioiThieu_Panel ds = new GioiThieu_Panel();

		f.setDefaultCloseOperation(3);

		f.getContentPane().add(ds);

		f.setVisible(true);
		f.setSize(1190, 450);

	}
}
