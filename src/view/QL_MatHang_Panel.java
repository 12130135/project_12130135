package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.Border;

import model.ChecNgay;
import model.Export_File_Excell;
import model.MatHang;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import controller.Action;
import controller.Controller_MatHang;

import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.xml.ws.handler.MessageContext.Scope;

import org.jdesktop.swingx.JXTaskPane;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class QL_MatHang_Panel extends JPanel implements ActionListener,
		MouseListener {
	private static final long serialVersionUID = 1L;
	private JPanel title_Panel, PB, PA;

	public static JTable table;
	public static JScrollPane scroll;

	static DefaultTableModel datamodel;
	static Vector columnames = new Vector();
	static Vector record = null;

	private JSplitPane splitPane;
	private JXTaskPane taskPane;
	private static JTextField tf_timkiem;
	private static JButton bt_timkiem;
	private static JButton btn_capnhat;

	/**
	 * Create the panel.
	 */
	public QL_MatHang_Panel() {
		setLayout(new BorderLayout(0, 0));
		// Phần Title ============================
		JPanel panel_Title = new JPanel();
		panel_Title.setBorder(new LineBorder(Color.ORANGE, 1, true));
		FlowLayout fl_panel_Title = (FlowLayout) panel_Title.getLayout();
		add(panel_Title, BorderLayout.NORTH);

		title_Panel = new TitlePanel("Quản Lý Mặt Hàng");
		panel_Title.add(title_Panel);
		// End Phần Title ===================

		JPanel panel_Show_Table = new JPanel();
		add(panel_Show_Table, BorderLayout.CENTER);
		panel_Show_Table.setLayout(new BorderLayout(0, 0));

		taskPane = new JXTaskPane();
		taskPane.setToolTipText("Click để thấy thanh chức năng");
		taskPane.setTitle("Chức năng chính");
		taskPane.setCollapsed(true);
		taskPane.setFocusable(false);
		panel_Show_Table.add(taskPane, BorderLayout.NORTH);
		taskPane.getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panel_All = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_All.getLayout();
		flowLayout.setVgap(0);
		taskPane.getContentPane().add(panel_All, BorderLayout.CENTER);

		Panel_Button_AllTextField_MatHang all_button = new Panel_Button_AllTextField_MatHang();
		panel_All.add(all_button);

		JPanel panel_Show = new JPanel();
		panel_Show.setBorder(new TitledBorder(new LineBorder(new Color(0, 255,
				0), 1, true), "Th\u00F4ng tin m\u1EB7t h\u00E0ng",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_Show_Table.add(panel_Show, BorderLayout.CENTER);
		panel_Show.setLayout(new BorderLayout(0, 0));

		// Phần Tìm kiếm ===========================================
		JPanel panel_search = new JPanel();
		panel_search.setBorder(new TitledBorder(new LineBorder(new Color(0, 0,
				255), 1, true), "T\u00ECm ki\u1EBFm", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel_Show.add(panel_search, BorderLayout.SOUTH);
		panel_search.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		JLabel lblTmKim = new JLabel("Tìm Kiếm:   ");
		panel_search.add(lblTmKim);

		tf_timkiem = new JTextField();
		panel_search.add(tf_timkiem);
		tf_timkiem.setColumns(30);

		bt_timkiem = new JButton("  Đi Đến");
		bt_timkiem.setIcon(new ImageIcon(QL_MatHang_Panel.class
				.getResource("/images/calenda/search.png")));
		panel_search.add(bt_timkiem);

		btn_capnhat = new JButton("Cập Nhật");
		btn_capnhat.setIcon(new ImageIcon(QL_MatHang_Panel.class
				.getResource("/images/calenda/Refresh-icon.png")));
		panel_search.add(btn_capnhat);
		// End Phần Tìm kiếm ===========================================

		// JScrollPane scroll = new JScrollPane(table);
		JPanel panel_Show_MatHang = new JPanel();
		panel_Show.add(panel_Show_MatHang, BorderLayout.CENTER);
		table = new JTable();

		columnames.add(" ID MH ");
		columnames.add(" Tên Mặt Hàng ");
		columnames.add(" Giá ");
		columnames.add(" ĐVT ");
		columnames.add(" Số Lượng ");
		columnames.add(" Nhóm Hàng ");
		columnames.add(" Ngày Nhập ");
		columnames.add(" Nhà Cung Cấp ");

		// ++++++Set du lieu cho bang
		datamodel = new DefaultTableModel(record, columnames);
		table.setModel(datamodel);

		// ++++++dieu chinh kich co cua bang
		table.setPreferredScrollableViewportSize(new Dimension(1000, 350));
		table.setFillsViewportHeight(true);

		// ++++++them thanh cuon cho bang
		JScrollPane scroll = new JScrollPane(table);

		scroll = new JScrollPane(table,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		// Table.adjustColumnPreferredWidths(table);
		table.revalidate();
		panel_Show_MatHang.add(scroll);

		bt_timkiem.addActionListener(this);
		btn_capnhat.addActionListener(this);
		table.addMouseListener(this);
		scroll.addMouseListener(this);

	}

	public QL_MatHang_Panel(QL_MatHang_Panel ql_MatHang_Panel) {
		// TODO Auto-generated constructor stub
	}

	// --------------- getters --------------
	public static JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	// Dữ liệu lấy từ Panel_Button_AllTextField_MatHang
	public static void loadDatabase() {
		loadDatabase_DAO();
	}

	private static void loadDatabase_DAO() {
		List<MatHang> list = Controller_MatHang.loadDatabase();
		record = null;
		datamodel = new DefaultTableModel(record, columnames);
		table.setModel(datamodel);

		for (MatHang matHang : list) {
			record = new Vector();
			record.addElement(matHang.getMaMatHang());
			record.addElement(matHang.getTenMatHang());
			record.addElement(matHang.getGiaMatHang());
			record.addElement(matHang.getDonViTinh());
			record.addElement(matHang.getSoLuong());
			record.addElement(matHang.getNhomHang());
			record.addElement(matHang.getNgayNhap());
			record.addElement(matHang.getNhaCungCap());

			datamodel.addRow(record);
		}
	}

	public static void Export_Excell() {
		Export_File_Excell.fillData(table, new File("D:\\ListMatHang.xls"));
	}

	public static void themMatHang(String maMH, String tenMatHang, double gia,
			String donViTinh, int soLuong, String nhomHang, String ngay,
			String nhaCungCap) {

		Controller_MatHang.themMH(maMH, tenMatHang, gia, donViTinh, soLuong,
				nhomHang, ngay, nhaCungCap);

		record = new Vector();
		record.addElement(maMH);
		record.addElement(tenMatHang);
		record.addElement(gia);
		record.addElement(donViTinh);
		record.addElement(soLuong);
		record.addElement(nhomHang);
		record.addElement(ngay);
		record.addElement(nhaCungCap);

		datamodel.addRow(record);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn_capnhat) {
			loadDatabase();
			JOptionPane.showMessageDialog(this, "Đã cập nhật lại data!");
		} else if (e.getSource() == bt_timkiem) {
			String serch = tf_timkiem.getText();
			if (serch.equals("")) {
				loadDatabase();
			} else {
				timkiem(serch);
			}
		}
	}

	private void timkiem(String serch) {
		List<MatHang> list = Controller_MatHang.timKiem(serch);
		record = null;
		datamodel = new DefaultTableModel(record, columnames);
		table.setModel(datamodel);

		for (MatHang matHang : list) {
			record = new Vector();
			record.addElement(matHang.getMaMatHang());
			record.addElement(matHang.getTenMatHang());
			record.addElement(matHang.getGiaMatHang());
			record.addElement(matHang.getDonViTinh());
			record.addElement(matHang.getSoLuong());
			record.addElement(matHang.getNhomHang());
			record.addElement(matHang.getNgayNhap());
			record.addElement(matHang.getNhaCungCap());

			datamodel.addRow(record);
		}
	}

	@Override
	public void mouseClicked(MouseEvent o) {
		if (o.getSource().equals(QL_MatHang_Panel.getTable())) {
		
			table = QL_MatHang_Panel.getTable();

			int row = table.getSelectedRow();

			Panel_Button_AllTextField_MatHang.getTf_MaMatHang().setText(
					(String) datamodel.getValueAt(row, 0));
			Panel_Button_AllTextField_MatHang.getTf_TenMatHang().setText(
					(String) datamodel.getValueAt(row, 1));
			Panel_Button_AllTextField_MatHang.getTf_Gia().setText(
					String.valueOf(datamodel.getValueAt(row, 2)));
			Panel_Button_AllTextField_MatHang.getListDonViTinh()
					.setSelectedItem(table.getModel().getValueAt(row, 3));
			Panel_Button_AllTextField_MatHang.getTf_SoLuong().setText(
					String.valueOf(datamodel.getValueAt(row, 4)));
			Panel_Button_AllTextField_MatHang.getListNhomHang()
					.setSelectedItem(table.getModel().getValueAt(row, 5));
			Panel_Button_AllTextField_MatHang.getDatePicker()
					.getJFormattedTextField()
					.setText((String) table.getModel().getValueAt(row, 6));
			Panel_Button_AllTextField_MatHang.getListNhaCungCap()
					.setSelectedItem(table.getModel().getValueAt(row, 7));

			Panel_Button_AllTextField_MatHang.getTf_MaMatHang().setEditable(
					false);

			return;
		}
	}

	@Override
	public void mouseEntered(MouseEvent o) {
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent o) {
	}

	@Override
	public void mouseReleased(MouseEvent o) {

	}

}
