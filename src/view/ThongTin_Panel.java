package view;

import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;

public class ThongTin_Panel extends JPanel {

	/**
	 * Create the panel.
	 */
	public ThongTin_Panel() {
		setLayout(null);
		
		JLabel lblPhnMmQun = new JLabel("Phần mềm quản lý cafe TNXH ra đời vào ngày 1/2/2015");
		lblPhnMmQun.setBackground(Color.BLACK);
		lblPhnMmQun.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPhnMmQun.setIcon(new ImageIcon(ThongTin_Panel.class.getResource("/image2/thongtin.png")));
		lblPhnMmQun.setBounds(20, 11, 448, 32);
		add(lblPhnMmQun);
		
		JLabel lblNewLabel = new JLabel("<html> Chúng tôi  xin chân thành cảm ơn sự giúp đỡ và hướng dẫn tận tình của cô  <b> Nguyễn Thị Tú Mi</b>  và cô  <b> Trần Thị Thanh Nga </b> </html> ");
		lblNewLabel.setIcon(new ImageIcon(ThongTin_Panel.class.getResource("/image2/thongtin.png")));
		lblNewLabel.setBounds(20, 52, 921, 25);
		add(lblNewLabel);
		
		JLabel lblNguynThT = new JLabel(" đã có những đóng góp ý kiến trong quá trình  chúng tôi xây dựng phần mềm biết những hạn chế về giao diện cũng như nội dung để chúng tôi sữa chữa kịp thời  ");
		lblNguynThT.setBounds(60, 88, 934, 25);
		add(lblNguynThT);
		
		JLabel lblNewLabel_1 = new JLabel("Cám ơn đội ngũ lập trình viên gồm: ");
		lblNewLabel_1.setIcon(new ImageIcon(ThongTin_Panel.class.getResource("/image2/thongtin.png")));
		lblNewLabel_1.setBounds(20, 117, 262, 32);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(" Võ Thị Kim Hạnh ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setIcon(new ImageIcon(ThongTin_Panel.class.getResource("/image2/cc.png")));
		lblNewLabel_2.setBounds(71, 149, 248, 32);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(" Phạm Thị Diễm Hương");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setIcon(new ImageIcon(ThongTin_Panel.class.getResource("/image2/cc.png")));
		lblNewLabel_3.setBounds(71, 181, 286, 25);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel(" Trần Thị Diễm Xuân");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setIcon(new ImageIcon(ThongTin_Panel.class.getResource("/image2/cc.png")));
		lblNewLabel_4.setBounds(71, 211, 248, 26);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel(" Vũ Ngọc Thiện");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_5.setForeground(Color.RED);
		lblNewLabel_5.setIcon(new ImageIcon(ThongTin_Panel.class.getResource("/image2/cc.png")));
		lblNewLabel_5.setBounds(71, 242, 206, 27);
		add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel(" Nguyễn Thành Nguyên");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_6.setForeground(Color.RED);
		lblNewLabel_6.setIcon(new ImageIcon(ThongTin_Panel.class.getResource("/image2/cc.png")));
		lblNewLabel_6.setBounds(71, 274, 211, 27);
		add(lblNewLabel_6);
		
		
		
		JLabel lblHKhng = new JLabel(" Đội ngũ lập trình viên đã không ngại vất vả sửa đi sữa lại rất nhiều lần để có được giao diện đệp và nội dung ứng dụng một cách tốt nhất");
		lblHKhng.setBounds(60, 312, 859, 32);
		add(lblHKhng);
		JLabel label = new JLabel(" đồng thời thức khuya dậy sớm để hoàn thành dự án đúng thời gian đặt ra");
		label.setBounds(60, 355, 565, 14);
		add(label);
		
		JLabel lblNewLabel_7 = new JLabel("Phần mền nào cũng vậy khi mới ra đời đều gặp phải những lỗi không mong muốn!  ");
		lblNewLabel_7.setIcon(new ImageIcon(ThongTin_Panel.class.getResource("/image2/thongtin.png")));
		lblNewLabel_7.setBounds(10, 380, 677, 32);
		add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("nên phần mềm quản lý cafe TNXH cũng không ngoại lệ và còn hạn chế một số tín năng mong được khách hàng thông cảm");
		lblNewLabel_8.setBounds(60, 418, 788, 32);
		add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Những đóng góp của khách hàng cùng với những khinh nghiệm có được khi xây dựng phần mềm này chúng tôi tin chắc   ");
		lblNewLabel_9.setIcon(new ImageIcon(ThongTin_Panel.class.getResource("/image2/thongtin.png")));
		lblNewLabel_9.setBounds(12, 445, 907, 39);
		add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("sau này sẽ có những phiên bản tốt nhất không phụ lòng sự tin tưởng của khách hàng vào chúng tôi");
		lblNewLabel_10.setBounds(60, 484, 859, 25);
		add(lblNewLabel_10);

	}
	public static void main(String[] args) throws SQLException {
		JFrame f = new JFrame();

		ThongTin_Panel ds = new ThongTin_Panel();

		f.setDefaultCloseOperation(3);

		f.getContentPane().add(ds);

		f.setVisible(true);
		f.setSize(1190, 450);

	}
}
