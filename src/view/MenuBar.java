package view;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import controller.ActionMenu;

public class MenuBar extends JMenuBar {
	private static final long serialVersionUID = 1L;

	private JMenu heThong, quanLy, thongKe, timKiem, troGiup;

	// Hệ Thống
	private JMenuItem dangKy, doiMatKhau, thoat;
	// Quản Lý
	private JMenuItem qLy_HoaDon, qLy_KhachHang, qLy_MatHang, qLy_NhanVien,
			qLy_ThucDon, datBan;
	// Thống Kê
	private JMenuItem qLy_ThongKe, qLy_TongTien;
	// Panel cho JMenuItem Tìm Kiếm
	// chưa có gì===================================
	// Trợ Giúp
	private JMenuItem gioiThieu, troGiup_Item, thongTin;

	private ActionMenu action = new ActionMenu(this);

	public MainFrame getMainFrame() {
		return mainFrame;
	}

	private MainFrame mainFrame;

	// public static String pq = checkPQ

	public MenuBar(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		// JMenu
		heThong = new JMenu(" Hệ Thống ");
		quanLy = new JMenu(" Quản Lý ");
		thongKe = new JMenu(" Thống Kê ");
		timKiem = new JMenu(" Tìm Kiếm ");
		troGiup = new JMenu(" Trợ Giúp ");

		// JMenuItem của JMenu Hệ Thống
		datBan = new JMenuItem(" Đặt Bàn ");
		datBan.setActionCommand("datban");
		datBan.addActionListener(action);

		dangKy = new JMenuItem(" Đăng Ký ");
		dangKy.setActionCommand("dangky");
		dangKy.addActionListener(action);

		doiMatKhau = new JMenuItem(" Đổi Mật Khẩu ");
		doiMatKhau.setActionCommand("doimatkhau");
		doiMatKhau.addActionListener(action);

		thoat = new JMenuItem(" Thoát ");
		thoat.setAccelerator(KeyStroke
				.getKeyStroke('T', KeyEvent.ALT_DOWN_MASK));
		thoat.setActionCommand("thoat");
		thoat.addActionListener(action);

		// JMenuItem của JMenu Quản Lý
		qLy_HoaDon = new JMenuItem(" Hoá Đơn ");
		qLy_HoaDon.setActionCommand("hoadon");
		qLy_HoaDon.addActionListener(action);
		qLy_HoaDon.setAccelerator(KeyStroke.getKeyStroke('H',
				KeyEvent.CTRL_DOWN_MASK));

		qLy_KhachHang = new JMenuItem(" Khách Hàng ");
		qLy_KhachHang.setActionCommand("khachhang");
		qLy_KhachHang.addActionListener(action);
		qLy_KhachHang.setAccelerator(KeyStroke.getKeyStroke('K',
				KeyEvent.CTRL_DOWN_MASK));

		qLy_MatHang = new JMenuItem(" Mặt Hàng ");
		qLy_MatHang.setActionCommand("mathang");
		qLy_MatHang.addActionListener(action);
		qLy_MatHang.setAccelerator(KeyStroke.getKeyStroke('M',
				KeyEvent.CTRL_DOWN_MASK));

		qLy_NhanVien = new JMenuItem(" Nhân Viên ");
		qLy_NhanVien.setActionCommand("nhanvien");
		qLy_NhanVien.addActionListener(action);
		qLy_NhanVien.setAccelerator(KeyStroke.getKeyStroke('N',
				KeyEvent.CTRL_DOWN_MASK));

		qLy_ThucDon = new JMenuItem(" Thực Đơn ");
		qLy_ThucDon.setActionCommand("thucdon");
		qLy_ThucDon.addActionListener(action);
		qLy_ThucDon.setAccelerator(KeyStroke.getKeyStroke('D',
				KeyEvent.CTRL_DOWN_MASK));

		// JMenuItem của JMenu Thống Kê
		qLy_ThongKe = new JMenuItem(" Thống Kê ");
		qLy_ThongKe.setActionCommand("thongke");
		qLy_ThongKe.addActionListener(action);

		qLy_TongTien = new JMenuItem(" Tổng Tiền ");
		qLy_TongTien.setActionCommand("tongtien");
		qLy_TongTien.addActionListener(action);

		// JMenuItem của JMenu Trợ Giúp
		gioiThieu = new JMenuItem(" Giới Thiệu ");
		gioiThieu.setActionCommand("gioithieu");
		gioiThieu.addActionListener(action);

		troGiup_Item = new JMenuItem(" Trợ Giúp ");
		troGiup_Item.setActionCommand("trogiup");
		troGiup_Item.addActionListener(action);

		thongTin = new JMenuItem(" Thông Tin ");
		thongTin.setActionCommand("thongtin");
		thongTin.addActionListener(action);
		// End phần JMenuItem

		// action.setPQ();
		heThong.add(datBan);
		heThong.add(dangKy);
		heThong.add(doiMatKhau);
		heThong.add(thoat);

//		quanLy.add(qLy_HoaDon);
//		quanLy.add(qLy_ThucDon);
		quanLy.add(qLy_KhachHang);
		quanLy.add(qLy_MatHang);
		quanLy.add(qLy_NhanVien);

		thongKe.add(qLy_ThongKe);
		thongKe.add(qLy_TongTien);

		// chưa có gì để thêm cả
		// timKiem.add();

		troGiup.add(gioiThieu);
		troGiup.add(troGiup_Item);
		troGiup.add(thongTin);

		// if (!pq.equals("1")) {
		// dKy.setEnabled(false);
		// qLyNV.setEnabled(false);
		// theoPhim.setEnabled(false);
		// tatCa.setEnabled(false);
		// theoPhong.setEnabled(false);
		// tKiemNV.setEnabled(false);
		// }

		this.add(heThong);
		this.add(quanLy);
		this.add(thongKe);
		this.add(timKiem);
		this.add(troGiup);

	}

	public JMenuItem getDatBan() {
		return datBan;
	}

	public void setDatBan(JMenuItem datBan) {
		this.datBan = datBan;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	// ==================================================

	public JMenu getHeThong() {
		return heThong;
	}

	public void setHeThong(JMenu heThong) {
		this.heThong = heThong;
	}

	public JMenu getQuanLy() {
		return quanLy;
	}

	public void setQuanLy(JMenu quanLy) {
		this.quanLy = quanLy;
	}

	public JMenu getThongKe() {
		return thongKe;
	}

	public void setThongKe(JMenu thongKe) {
		this.thongKe = thongKe;
	}

	public JMenu getTimKiem() {
		return timKiem;
	}

	public void setTimKiem(JMenu timKiem) {
		this.timKiem = timKiem;
	}

	public JMenu getTroGiup() {
		return troGiup;
	}

	public void setTroGiup(JMenu troGiup) {
		this.troGiup = troGiup;
	}

	public JMenuItem getDangKy() {
		return dangKy;
	}

	public void setDangKy(JMenuItem dangKy) {
		this.dangKy = dangKy;
	}

	public JMenuItem getDoiMatKhau() {
		return doiMatKhau;
	}

	public void setDoiMatKhau(JMenuItem doiMatKhau) {
		this.doiMatKhau = doiMatKhau;
	}

	public JMenuItem getThoat() {
		return thoat;
	}

	public void setThoat(JMenuItem thoat) {
		this.thoat = thoat;
	}

	public JMenuItem getqLy_HoaDon() {
		return qLy_HoaDon;
	}

	public void setqLy_HoaDon(JMenuItem qLy_HoaDon) {
		this.qLy_HoaDon = qLy_HoaDon;
	}

	public JMenuItem getqLy_KhachHang() {
		return qLy_KhachHang;
	}

	public void setqLy_KhachHang(JMenuItem qLy_KhachHang) {
		this.qLy_KhachHang = qLy_KhachHang;
	}

	public JMenuItem getqLy_MatHang() {
		return qLy_MatHang;
	}

	public void setqLy_MatHang(JMenuItem qLy_MatHang) {
		this.qLy_MatHang = qLy_MatHang;
	}

	public JMenuItem getqLy_NhanVien() {
		return qLy_NhanVien;
	}

	public void setqLy_NhanVien(JMenuItem qLy_NhanVien) {
		this.qLy_NhanVien = qLy_NhanVien;
	}

	public JMenuItem getqLy_ThucDon() {
		return qLy_ThucDon;
	}

	public void setqLy_ThucDon(JMenuItem qLy_ThucDon) {
		this.qLy_ThucDon = qLy_ThucDon;
	}

	public JMenuItem getqLy_ThongKe() {
		return qLy_ThongKe;
	}

	public void setqLy_ThongKe(JMenuItem qLy_ThongKe) {
		this.qLy_ThongKe = qLy_ThongKe;
	}

	public JMenuItem getqLy_TongTien() {
		return qLy_TongTien;
	}

	public void setqLy_TongTien(JMenuItem qLy_TongTien) {
		this.qLy_TongTien = qLy_TongTien;
	}

	public JMenuItem getGioiThieu() {
		return gioiThieu;
	}

	public void setGioiThieu(JMenuItem gioiThieu) {
		this.gioiThieu = gioiThieu;
	}

	public JMenuItem getTroGiup_Item() {
		return troGiup_Item;
	}

	public void setTroGiup_Item(JMenuItem troGiup_Item) {
		this.troGiup_Item = troGiup_Item;
	}

	public JMenuItem getThongTin() {
		return thongTin;
	}

	public void setThongTin(JMenuItem thongTin) {
		this.thongTin = thongTin;
	}

	// thêm hành động (chuyển hướng)
	public static void addAction(JMenuItem menu, ActionListener action) {
		menu.addActionListener(action);
	}

	public static void main(String[] args) {
		// System.out.println(pq);
	}
}
