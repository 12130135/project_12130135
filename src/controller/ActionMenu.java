package controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import view.MenuBar;
import view.QL_KhachHang_Panel;
import view.QL_MatHang_Panel;
import view.QL_NhanVien_Panel;
import view.V_DangNhap;

public class ActionMenu extends Action {
	private MenuBar m;

	public ActionMenu(MenuBar m) {
		this.m = m;
	}

	// public void setPQ() {
	// if (!V_DangNhap.getPhanQuyen(V_DangNhap.getTextField_user().getText())
	// .equals("1")) {
	// m.getDangKy().setEnabled(false);
	// }
	// }

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("datban")) {
			m.getMainFrame().getCard().show(m.getMainFrame().getP(), cmd);
			
		} else if (cmd.equals("doimatkhau")) {
			m.getMainFrame().getCard().show(m.getMainFrame().getP(), cmd);
		} else if (cmd.equals("dangky")) {
			m.getMainFrame().getCard().show(m.getMainFrame().getP(), cmd);
		} else if (cmd.equals("thoat")) {
			System.exit(0);

		} else if (cmd.equals("hoadon")) {
			m.getMainFrame().getCard().show(m.getMainFrame().getP(), cmd);
		} else if (cmd.equals("thucdon")) {
			m.getMainFrame().getCard().show(m.getMainFrame().getP(), cmd);
		} else if (cmd.equals("khachhang")) {
			m.getMainFrame().getCard().show(m.getMainFrame().getP(), cmd);
			QL_KhachHang_Panel.loadDatabase();
		} else if (cmd.equals("mathang")) {
			m.getMainFrame().getCard().show(m.getMainFrame().getP(), cmd);
			QL_MatHang_Panel.loadDatabase();
		} else if (cmd.equals("nhanvien")) {
			m.getMainFrame().getCard().show(m.getMainFrame().getP(), cmd);
//			QL_NhanVien_Panel.
		} else if (cmd.equals("thongke")) {
			m.getMainFrame().getCard().show(m.getMainFrame().getP(), cmd);
		} else if (cmd.equals("tongtien")) {
			m.getMainFrame().getCard().show(m.getMainFrame().getP(), cmd);

		} else if (cmd.equals("gioithieu")) {
			m.getMainFrame().getCard().show(m.getMainFrame().getP(), cmd);
		} else if (cmd.equals("trogiup")) {
			m.getMainFrame().getCard().show(m.getMainFrame().getP(), cmd);
		} else if (cmd.equals("thongtin")) {
			m.getMainFrame().getCard().show(m.getMainFrame().getP(), cmd);
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
