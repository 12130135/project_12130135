package view;

import java.awt.CardLayout;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class MainFrame {
	private static JFrame frame;

	// Panel cho JMenu Hệ thống
	private JPanel dangKy, doiMatKhau, datBan;
	// Panel cho JMenu Quản Lý
	private JPanel QL_HoaDon_Panel, QL_KhachHang_Panel, QL_MatHang_Panel,
			QL_NhanVien_Panel, QL_ThucDon_Panel;
	// Panel cho JMenu Thống Kê
	private JPanel QL_ThongKe_Panel, QL_TongTien_Panel;
	// Panel cho JMenu Tìm Kiếm
	// chưa có gì===================================
	// Panel cho JMenu Trợ Giúp
	private JPanel GioiThieu, TroGiup, ThongTin;

	private MenuBar mBar;
	private JPanel p;
	private CardLayout card;

	public MainFrame() {
		frame = new JFrame();
		card = new CardLayout();
		p = new JPanel(card);
		frame.setTitle("Quản Lý Quán Coffee");
		frame.setDefaultCloseOperation(3);
		frame.setSize(1050, 600);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
				V_DangNhap.class.getResource("/images/home.png")));
//		frame.setIconImage(new ImageIcon("images/iconlogo.png").getImage());
		int x = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2 - (frame
				.getWidth() / 2));
		int y = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2 - (frame
				.getHeight() / 2));
		frame.setLocation(x, y);
		frame.setResizable(false);
		frame.setVisible(true);

		mBar = new MenuBar(this);
		frame.setJMenuBar(mBar);

		try {

			GioiThieu = new GioiThieu_Panel();

			// Hệ Thống
			datBan = new DatBan_Panel();
			dangKy = new DangKy_Panel();
			doiMatKhau = new DoiMatKhau_Panel();

			// Quản Lý
			QL_HoaDon_Panel = new QL_HoaDon_Panel();
			QL_KhachHang_Panel = new QL_KhachHang_Panel();
			QL_MatHang_Panel = new QL_MatHang_Panel();
			QL_NhanVien_Panel = new QL_NhanVien_Panel();
			QL_ThucDon_Panel = new QL_ThucDon_Panel();

			// Thống Kê
			QL_ThongKe_Panel = new QL_ThongKe_Panel();
			QL_TongTien_Panel = new QL_TongTien();

			// Trợ Giúp
			TroGiup = new TroGiup_Panel();
			ThongTin = new ThongTin_Panel();

			// giới thiệu
			p.add("gioithieu", GioiThieu);

			// đăng ký, đổi nật khẩu
			p.add("datban", datBan);
			p.add("dangky", dangKy);
			p.add("doimatkhau", doiMatKhau);

			// Quản Lý
//			p.add("hoadon", QL_HoaDon_Panel);
			p.add("khachhang", QL_KhachHang_Panel);
			p.add("mathang", QL_MatHang_Panel);
			p.add("nhanvien", QL_NhanVien_Panel);
//			p.add("thucdon", QL_ThucDon_Panel);

			// Thống Kê
			p.add("thongke", QL_ThongKe_Panel);
			p.add("tongtien", QL_TongTien_Panel);

			// Trợ Giúp
			p.add("trogiup", TroGiup);
			p.add("thongtin", ThongTin);

			// cho mọi thứ vào Frame
			frame.add(p);
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, e1.toString());
		}
	}

	// ----------- getter -------------

	public static JFrame getFrame() {
		return frame;
	}

	public MenuBar getmBar() {
		return mBar;
	}

	public JPanel getP() {
		return p;
	}

	public CardLayout getCard() {
		return card;
	}
}
