package view;

import java.awt.BorderLayout; 
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.color.CMMException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;


import controller.NhanVienDB;

import model.Export_File_Excell;

import model.ThongTinNhanVien;
import javax.swing.JComboBox;

public class QL_NhanVien_Panel extends JPanel implements ActionListener{
	private static NhanVienDB nv = new NhanVienDB();

	private ButtonGroup bg;
	JButton btThem;
	JButton btSua;
	JButton btXoa;
	JButton btLuu;

	JButton btnXutRaExcel;
	JButton btRefresh;
	JButton btsearch;
	JComboBox cbNgaysinh;
	JComboBox cbthangsinh;
	JComboBox cbNamsinh;

	JRadioButton rdnam;

	JRadioButton rdnu;
	private boolean isupdate = true;
	private JTextField tfmnv;
	private JTextField tfhoten;
	private JTextField tfsodienthoai;
	private JTextField tfdiachi;
	private JTextField tfcmnd;
	private static JTable tbNhanVien;
	private JTextField tfsearch;

	/**
	 * Create the panel.
	 */
	public QL_NhanVien_Panel() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(panel, BorderLayout.NORTH);

		btThem = new JButton("Thêm");
		btThem.setIcon(new ImageIcon(QL_NhanVien_Panel.class.getResource("/image2/them.png")));
		btThem.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(btThem);

		btSua = new JButton(" Sửa");
		btSua.setIcon(new ImageIcon(QL_NhanVien_Panel.class.getResource("/image2/sua2.png")));
		panel.add(btSua);

		btXoa = new JButton(" Xóa");
		btXoa.setIcon(new ImageIcon(QL_NhanVien_Panel.class.getResource("/image2/xoa.jpg")));
		panel.add(btXoa);
		btLuu = new JButton(" Lưu");
		btLuu.setIcon(new ImageIcon(QL_NhanVien_Panel.class.getResource("/image2/save.png")));
		panel.add(btLuu);

		btRefresh = new JButton("Refresh");
		btRefresh.setIcon(new ImageIcon(QL_NhanVien_Panel.class.getResource("/image2/Refresh.png")));
		panel.add(btRefresh);

		btnXutRaExcel = new JButton("Excel");
		btnXutRaExcel.setIcon(new ImageIcon(QL_NhanVien_Panel.class.getResource("/image2/excelnv.png")));
		panel.add(btnXutRaExcel);

		JLabel lblTmKim = new JLabel(" Tìm kiếm");
		panel.add(lblTmKim);

		tfsearch = new JTextField();
		panel.add(tfsearch);
		tfsearch.setColumns(20);

		btsearch = new JButton("");
		btsearch.setIcon(new ImageIcon(QL_NhanVien_Panel.class.getResource("/image2/search.png")));
		panel.add(btsearch);

		JSplitPane splitPane = new JSplitPane();
		splitPane.setOneTouchExpandable(true);
		add(splitPane, BorderLayout.CENTER);

		JPanel panel_1 = new JPanel();
		splitPane.setLeftComponent(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 50, 250 };
		gbl_panel_2.rowHeights = new int[] {44, 40, 40, 40, 40, 40, 40, 40, 0};
		gbl_panel_2.columnWeights = new double[] { 0.0, 1.0 };
		gbl_panel_2.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0 };
		panel_2.setLayout(gbl_panel_2);

		JLabel lbMnv = new JLabel(" Mã nhân viên");
		GridBagConstraints gbc_lbMnv = new GridBagConstraints();
		gbc_lbMnv.anchor = GridBagConstraints.WEST;
		gbc_lbMnv.insets = new Insets(0, 0, 5, 5);
		gbc_lbMnv.gridx = 0;
		gbc_lbMnv.gridy = 0;
		panel_2.add(lbMnv, gbc_lbMnv);

		tfmnv = new JTextField();
		GridBagConstraints gbc_tfmnv = new GridBagConstraints();
		gbc_tfmnv.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfmnv.insets = new Insets(0, 0, 5, 0);
		gbc_tfmnv.gridx = 1;
		gbc_tfmnv.gridy = 0;
		panel_2.add(tfmnv, gbc_tfmnv);
		tfmnv.setColumns(25);

		JLabel lblHTn = new JLabel("Họ tên");
		GridBagConstraints gbc_lblHTn = new GridBagConstraints();
		gbc_lblHTn.anchor = GridBagConstraints.WEST;
		gbc_lblHTn.insets = new Insets(0, 0, 5, 5);
		gbc_lblHTn.gridx = 0;
		gbc_lblHTn.gridy = 1;
		panel_2.add(lblHTn, gbc_lblHTn);

		tfhoten = new JTextField();
		GridBagConstraints gbc_tfhoten = new GridBagConstraints();
		gbc_tfhoten.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfhoten.insets = new Insets(0, 0, 5, 0);
		gbc_tfhoten.gridx = 1;
		gbc_tfhoten.gridy = 1;
		panel_2.add(tfhoten, gbc_tfhoten);
		tfhoten.setColumns(25);

		JLabel lblSCmnd = new JLabel("Ngày sinh");
		GridBagConstraints gbc_lblSCmnd = new GridBagConstraints();
		gbc_lblSCmnd.anchor = GridBagConstraints.WEST;
		gbc_lblSCmnd.insets = new Insets(0, 0, 5, 5);
		gbc_lblSCmnd.gridx = 0;
		gbc_lblSCmnd.gridy = 2;
		panel_2.add(lblSCmnd, gbc_lblSCmnd);

		JPanel panel_5 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_5.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.anchor = GridBagConstraints.WEST;
		gbc_panel_5.insets = new Insets(0, 0, 5, 0);
		gbc_panel_5.fill = GridBagConstraints.VERTICAL;
		gbc_panel_5.gridx = 1;
		gbc_panel_5.gridy = 2;
		panel_2.add(panel_5, gbc_panel_5);

		cbNgaysinh = new JComboBox();
		panel_5.add(cbNgaysinh);
		DefaultComboBoxModel modelngay = new DefaultComboBoxModel<>();
		for (int i = 1; i < 31; i++) {
			modelngay.addElement(i);
		}
		cbNgaysinh.setModel(modelngay);

		cbthangsinh = new JComboBox();
		panel_5.add(cbthangsinh);
		DefaultComboBoxModel modelthang = new DefaultComboBoxModel<>();
		for (int i = 1; i < 12; i++) {
			modelthang.addElement(i);
		}
		cbthangsinh.setModel(modelthang);

		cbNamsinh = new JComboBox();
		panel_5.add(cbNamsinh);
		DefaultComboBoxModel modelnam = new DefaultComboBoxModel<>();
		for (int i = 1989; i < 2005; i++) {
			modelnam.addElement(i);
		}
		cbNamsinh.setModel(modelnam);

		JLabel lblGiiTnh = new JLabel(" Giới tính");
		GridBagConstraints gbc_lblGiiTnh = new GridBagConstraints();
		gbc_lblGiiTnh.anchor = GridBagConstraints.WEST;
		gbc_lblGiiTnh.insets = new Insets(0, 0, 5, 5);
		gbc_lblGiiTnh.gridx = 0;
		gbc_lblGiiTnh.gridy = 3;
		panel_2.add(lblGiiTnh, gbc_lblGiiTnh);

		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_4.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.insets = new Insets(0, 0, 5, 0);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 1;
		gbc_panel_4.gridy = 3;
		panel_2.add(panel_4, gbc_panel_4);
		bg = new ButtonGroup();
		rdnam = new JRadioButton("Nam");
		panel_4.add(rdnam);
		bg.add(rdnam);
		rdnu = new JRadioButton("Nữ");
		panel_4.add(rdnu);
		bg.add(rdnu);

		JLabel lblNgySinh = new JLabel("Số cmnd");
		GridBagConstraints gbc_lblNgySinh = new GridBagConstraints();
		gbc_lblNgySinh.anchor = GridBagConstraints.WEST;
		gbc_lblNgySinh.insets = new Insets(0, 0, 5, 5);
		gbc_lblNgySinh.gridx = 0;
		gbc_lblNgySinh.gridy = 4;
		panel_2.add(lblNgySinh, gbc_lblNgySinh);

		tfcmnd = new JTextField();
		GridBagConstraints gbc_tfcmnd = new GridBagConstraints();
		gbc_tfcmnd.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfcmnd.insets = new Insets(0, 0, 5, 0);
		gbc_tfcmnd.gridx = 1;
		gbc_tfcmnd.gridy = 4;
		panel_2.add(tfcmnd, gbc_tfcmnd);
		tfcmnd.setColumns(25);

		JLabel lblGf = new JLabel("Số điện thoại");
		GridBagConstraints gbc_lblGf = new GridBagConstraints();
		gbc_lblGf.anchor = GridBagConstraints.WEST;
		gbc_lblGf.insets = new Insets(0, 0, 5, 5);
		gbc_lblGf.gridx = 0;
		gbc_lblGf.gridy = 5;
		panel_2.add(lblGf, gbc_lblGf);

		tfsodienthoai = new JTextField();
		GridBagConstraints gbc_tfsodienthoai = new GridBagConstraints();
		gbc_tfsodienthoai.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfsodienthoai.insets = new Insets(0, 0, 5, 0);
		gbc_tfsodienthoai.gridx = 1;
		gbc_tfsodienthoai.gridy = 5;
		panel_2.add(tfsodienthoai, gbc_tfsodienthoai);
		tfsodienthoai.setColumns(25);

		JLabel lblaCh = new JLabel("Địa chỉ");
		GridBagConstraints gbc_lblaCh = new GridBagConstraints();
		gbc_lblaCh.anchor = GridBagConstraints.WEST;
		gbc_lblaCh.insets = new Insets(0, 0, 0, 5);
		gbc_lblaCh.gridx = 0;
		gbc_lblaCh.gridy = 6;
		panel_2.add(lblaCh, gbc_lblaCh);

		tfdiachi = new JTextField();
		GridBagConstraints gbc_tfdiachi = new GridBagConstraints();
		gbc_tfdiachi.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfdiachi.gridx = 1;
		gbc_tfdiachi.gridy = 6;
		panel_2.add(tfdiachi, gbc_tfdiachi);
		tfdiachi.setColumns(25);

		
		

		tbNhanVien = new JTable();
		JScrollPane scrollPane = new JScrollPane(tbNhanVien);
		splitPane.setRightComponent(scrollPane);
		btThem.addActionListener(this);
		btSua.addActionListener(this);
		btXoa.addActionListener(this);
		btLuu.addActionListener(this);
		btRefresh.addActionListener(this);
		btnXutRaExcel.addActionListener(this);
		btsearch.addActionListener(this);
		

loadData();
setDislayInput(false, false);
	}

	public void loadData() {
		DefaultTableModel df = new DefaultTableModel();
		 String[] nvien = { " Mã nhân viên", " Họ tên",
			 " Ngày sinh", " Giới tính","Số CMND ", " Số điện thoại", "Địa chỉ" };

df.setColumnIdentifiers(nvien);
		ResultSet rs = nv.getdata();
		try {
			ResultSetMetaData md = rs.getMetaData();
			int colNumber = md.getColumnCount();
			String[] name = new String[colNumber];

			
			
		
			while (rs.next()) {
				for (int i = 0; i < colNumber; i++) {
					name[i] = rs.getString(i + 1);
					
				}
	
			
				df.addRow(name);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
tbNhanVien.setModel(df);
	
	}
	
	public boolean setDislayInput(boolean dislay, boolean update) {
		if (update && tbNhanVien.getSelectedRow() < 0) {
			return false;

		} else if (update) {
			int row = tbNhanVien.getSelectedRow();
			tfmnv.setText((String) tbNhanVien.getValueAt(row, 0));
			tfhoten.setText((String) tbNhanVien.getValueAt(row, 1));
			
			if (tbNhanVien.getValueAt(row, 3).equals(rdnam.getText())) {
				rdnam.setSelected(true);

			} else if (tbNhanVien.getValueAt(row, 3).equals(rdnu.getText())) {
				rdnu.setSelected(true);

			}

			// if(tbNhanVien.getValueAt(row,
			// 4).equals(cbNgaysinh.toString()+"/"+cbthangsinh+"/"+cbNamsinh)){
			// cbNgaysinh.getSelectedItem();
			//
			// }
			tfcmnd.setText((String) tbNhanVien.getValueAt(row, 4));
			tfsodienthoai.setText((String) tbNhanVien.getValueAt(row, 5));
			tfdiachi.setText((String) tbNhanVien.getValueAt(row, 6));
			
		}

		tfmnv.setEnabled(dislay);
		tfhoten.setEnabled(dislay);
		tfcmnd.setEnabled(dislay);
		rdnam.setEnabled(dislay);
		rdnu.setEnabled(dislay);
		cbNamsinh.setEnabled(dislay);
		cbthangsinh.setEnabled(dislay);
		cbNgaysinh.setEnabled(dislay);

		tfsodienthoai.setEnabled(dislay);
		tfdiachi.setEnabled(dislay);

		return true;

	}

	// public static void main(String[] args) throws SQLException {
	// JFrame f = new JFrame();
	//
	// QL_NhanVien_Panel ds = new QL_NhanVien_Panel();
	//
	// f.setDefaultCloseOperation(3);
	//
	// f.getContentPane().add(ds);
	//
	// f.setVisible(true);
	// f.setSize(1190, 450);
	//
	// }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton bt=(JButton) e.getSource();
		if(bt==btXoa){
			
			delete();
		}
		if(bt==btSua){
			
			sua();
		}
		if(bt==btThem){
			Them();
		}
		if (e.getSource() == btsearch) {
			String tk = tfsearch.getText();
			if (tk.equals("")) {
				JOptionPane.showMessageDialog(this,
						"Bạn chưa nhập thông tin tìm kiếm!");
				loadData();
			} else {
				timkiem(tk);
			}
			
		}
			
		if(bt==btRefresh){
			loadData();
clear();
			
			setDislayInput(false, false);
		}
		if(bt==btLuu){
		
			themOrSua();
		}
		if (e.getSource() == btnXutRaExcel) {
			int i = JOptionPane
					.showConfirmDialog(
							this,
							"Bạn thực sự muốn In ra File Excel với Path là: D:\\ListNhanVien.xls",
							"In Thống Kê", JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE);
			if (i == 0) {
				Export_Excell();
				JOptionPane.showMessageDialog(this, "Xuất File thành công!");
			}
		}
	}

	
		private void timkiem(String tk) {
			DefaultTableModel df = new DefaultTableModel();
			 String[] nvien = { " Mã nhân viên", " Họ tên",
				 " Ngày sinh", " Giới tính","Số CMND ", " Số điện thoại", "Địa chỉ" };

	df.setColumnIdentifiers(nvien);
			ResultSet rs = nv.timKiem(tk);
			try {
				ResultSetMetaData md = rs.getMetaData();
				int colNumber = md.getColumnCount();
				String[] name = new String[colNumber];

				
				
			
				while (rs.next()) {
					for (int i = 0; i < colNumber; i++) {
						name[i] = rs.getString(i + 1);
						
					}
		
				
					df.addRow(name);
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	tbNhanVien.setModel(df);
		
	}

		public static void Export_Excell() {
			Export_File_Excell.fillData(tbNhanVien, new File("D:\\ListNhanVien.xls"));
		
	}

	private void clear() {
		// TODO Auto-generated method stub
		tfmnv.setText("");
		tfhoten.setText("");
		tfsodienthoai.setText("");
		rdnam.setSelected(false);
		rdnu.setSelected(false);
			
		tfdiachi.setText("");
		tfcmnd.setText("");
	}

	private void themOrSua() {
		// TODO Auto-generated method stub
		ThongTinNhanVien n=getNhanVien();
		if(n!=null){
			if(isupdate){
		nv.updateID(n.getMnv(), n);
		loadData();
		
		isupdate=false;
		
			}
	
			else {
				boolean check=nv.check(getNhanVien().getMnv());
				if(check==true){
					JOptionPane.showMessageDialog(null, " mã nhân viên bị trùng");
					
				}
				else{
				nv.insert(n);
				loadData();
				}
			}
			clear();
	setDislayInput(false, false);
		}else {
			
			JOptionPane.showMessageDialog(null,"Dữ liệu nhập sai","Err",JOptionPane.ERROR_MESSAGE);
		}
	}

	private ThongTinNhanVien getNhanVien() {
		
		String mnv=tfmnv.getText().trim();
		String ten=tfhoten.getText().trim();
		String ngay=cbNgaysinh.getSelectedItem().toString();
		String thang=cbthangsinh.getSelectedItem().toString();
		String nam=cbNamsinh.getSelectedItem().toString();
		String ntm=ngay+"/"+thang+"/"+nam;
		String socmnd1=tfcmnd.getText().trim();
		
		String gioitinhnu= rdnu.getText().trim();
		String gioitinhnam= rdnam.getText().trim();
	    
		String dienthoai1=tfsodienthoai.getText().trim();
		String diachi=tfdiachi.getText().trim();
		String socmnd ="";
	try {
		
		if(socmnd1.length()==9){
			int a=Integer.parseInt(socmnd1);
			socmnd+=String.valueOf(a);
		}
		else{
			JOptionPane.showMessageDialog(null, "số cmnd phải có 9 số");
		}
		
	} catch (Exception e) {
		// TODO: handle exception
		JOptionPane.showMessageDialog(null, "số cmnd phải là số và có 9 số");
	}
	String dienthoai="";
	try {
		if(dienthoai1.length()==10||dienthoai1.length()==11){
			dienthoai+="0";
		int a=Integer.parseInt(dienthoai1);
		dienthoai+=String.valueOf(a);
		}
		else if (dienthoai1.length()<9||dienthoai1.length()>10){
			JOptionPane.showMessageDialog(null, "số điện thoại phải có 10 hoặc 11 số");
		
		}
	} catch (Exception e) {
		// TODO: handle exception
		JOptionPane.showMessageDialog(null, "số điện thoai phải là số");
	}
					
		
		if(mnv.equals("")||ten.equals("")||diachi.equals("")||dienthoai.equals("")||socmnd.equals("")){
			return null;
		}
		ThongTinNhanVien nv= new ThongTinNhanVien(mnv, ten, socmnd, rdnam.isSelected()?gioitinhnam:gioitinhnu,ntm, dienthoai,diachi) ;
		return nv;
		
	}

	private void search() {
		// TODO Auto-generated method stub
		
	}

	private void Them() {
		// TODO Auto-generated method stub
		setDislayInput(true, false);
	}

	private void sua() {
		// TODO Auto-generated method stub
		if(setDislayInput(true, true)){
			isupdate=true;
		}
		else{
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn nhân viên update ");
		}
	}

	private void delete() {
		// TODO Auto-generated method stub
		int row=tbNhanVien.getSelectedRow();
		if(row<0){
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn nhân viên xóa ");
			return;
		}
		
		int chon=	JOptionPane.showConfirmDialog(null,"Bạn có muốn xóa nhân viên này ko?","delete",JOptionPane.YES_NO_OPTION);
			if(chon==JOptionPane.YES_OPTION){
				nv.deleteID((String) tbNhanVien.getValueAt(row, 0));
		loadData();
			
		}
	}
}
