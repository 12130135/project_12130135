package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import controller.Controller_HoaDon;

import javax.swing.JButton;
import javax.swing.ImageIcon;

public class ThanhToan_1 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tf_thanhtoan1;
	private static JButton bt_thoat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThanhToan_1 frame = new ThanhToan_1();
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
	public ThanhToan_1() {
		setTitle("Thanh Toán");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 306, 88);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		JLabel lblTngTinTr = new JLabel("Tổng tiền trả: ");
		lblTngTinTr.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblTngTinTr);

		tf_thanhtoan1 = new JTextField();
		contentPane.add(tf_thanhtoan1);
		tf_thanhtoan1.setColumns(10);

		double is = thanhtoan();

		tf_thanhtoan1.setText(" " + is);
		tf_thanhtoan1.setEditable(false);

		bt_thoat = new JButton("");
		bt_thoat.setIcon(new ImageIcon(ThanhToan_1.class
				.getResource("/images/cancel.png")));
		contentPane.add(bt_thoat);

		bt_thoat.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnExitActionPerformed(evt);
			}
		});
	}

	private void btnExitActionPerformed(ActionEvent evt) {
		this.dispose();
	}

	public double thanhtoan() {
		double abc = Controller_HoaDon.thanhtoan();
		return abc;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}
}
