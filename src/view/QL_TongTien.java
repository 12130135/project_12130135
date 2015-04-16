package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class QL_TongTien extends JPanel {
	private JTextField tf_Ban1;
	private JTextField tf_Ban2;
	private JTextField tf_Ban4;
	private JTextField tf_Ban5;
	private JTextField tf_Ban6;
	private JTextField tf_Ban7;
	private JTextField tf_Ban8;
	private JTextField tf_Ban9;
	private JTextField tf_Ban31;

	/**
	 * Create the panel.
	 */
	public QL_TongTien() {
		setLayout(null);
		
		JLabel lblBn = new JLabel("Bàn 1:  ");
		lblBn.setBounds(23, 14, 46, 14);
		add(lblBn);
		
		tf_Ban1 = new JTextField();
		tf_Ban1.setBounds(58, 11, 86, 20);
		add(tf_Ban1);
		tf_Ban1.setColumns(10);
		
		JLabel lblBn_1 = new JLabel("Bàn 2:");
		lblBn_1.setBounds(23, 42, 46, 14);
		add(lblBn_1);
		
		tf_Ban2 = new JTextField();
		tf_Ban2.setBounds(58, 39, 86, 20);
		add(tf_Ban2);
		tf_Ban2.setColumns(10);
		
		JLabel lblBn_2 = new JLabel("Bàn 4:  ");
		lblBn_2.setBounds(23, 96, 46, 14);
		add(lblBn_2);
		
		tf_Ban4 = new JTextField();
		tf_Ban4.setBounds(58, 93, 86, 20);
		add(tf_Ban4);
		tf_Ban4.setColumns(10);
		
		JLabel lblBn_3 = new JLabel("Bàn 5:  ");
		lblBn_3.setBounds(23, 124, 46, 14);
		add(lblBn_3);
		
		tf_Ban5 = new JTextField();
		tf_Ban5.setColumns(10);
		tf_Ban5.setBounds(58, 121, 86, 20);
		add(tf_Ban5);
		
		tf_Ban6 = new JTextField();
		tf_Ban6.setColumns(10);
		tf_Ban6.setBounds(58, 152, 86, 20);
		add(tf_Ban6);
		
		JLabel lblBn_4 = new JLabel("Bàn 6:  ");
		lblBn_4.setBounds(23, 155, 46, 14);
		add(lblBn_4);
		
		tf_Ban7 = new JTextField();
		tf_Ban7.setColumns(10);
		tf_Ban7.setBounds(58, 183, 86, 20);
		add(tf_Ban7);
		
		JLabel lblBn_5 = new JLabel("Bàn 7:  ");
		lblBn_5.setBounds(23, 186, 46, 14);
		add(lblBn_5);
		
		tf_Ban8 = new JTextField();
		tf_Ban8.setColumns(10);
		tf_Ban8.setBounds(58, 214, 86, 20);
		add(tf_Ban8);
		
		JLabel lblBn_6 = new JLabel("Bàn 8:  ");
		lblBn_6.setBounds(23, 217, 46, 14);
		add(lblBn_6);
		
		JLabel lblBn_7 = new JLabel("Bàn 9:  ");
		lblBn_7.setBounds(23, 245, 46, 14);
		add(lblBn_7);
		
		tf_Ban9 = new JTextField();
		tf_Ban9.setColumns(10);
		tf_Ban9.setBounds(58, 242, 86, 20);
		add(tf_Ban9);
		
		JLabel lblBi = new JLabel("Bàn 3");
		lblBi.setBounds(23, 67, 46, 14);
		add(lblBi);
		
		tf_Ban31 = new JTextField();
		tf_Ban31.setBounds(58, 67, 86, 20);
		add(tf_Ban31);
		tf_Ban31.setColumns(10);

	}
}
