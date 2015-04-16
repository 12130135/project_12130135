package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import javax.swing.plaf.SliderUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSplitPane;
import javax.swing.border.TitledBorder;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JTextField;

import DAO.DAO_HoaDon;
import controller.Controller_HoaDon;
import controller.Controller_MatHang;
import controller.Controller_ThucDon;
import controller.UpdateAction_HoaDon;
import model.ChecNgay;
import model.HoaDon;
import model.MatHang;
import model.ThucDon;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.Menu;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

public class DatBan_Panel extends JPanel implements ActionListener,
		MouseListener {
	public static String maMH_TD, tenMH_TD, donViTinh_TD;
	public static double gia_TD;

	private static JToolBar toolbar;
	private static JButton btnF, btnP, btnN, btnL, btnAdd, btnSave, btnDelete;
	private static DefaultTableModel dtm;
	private static UpdateAction_HoaDon action;
	private static JLabel statusBar;

	private static ArrayList<HoaDon> lst;
	private static int curPos = 0;// vị trí hiện tại của dòng trên lưới
	private static JLabel lblPos;
	private static int NoExistRecords = 0;// Giữ số mẫu tin cũ
	private JPanel title_Panel, SplitPanel_Right, SplitPanel_Left;;
	private JSplitPane splitPane;
	private JTabbedPane tpKhuVuc;
	private JPanel pkhu, panel_tangtret, panel_tang1, panel_tang2;
	private static JButton bt100, bt101, bt102, bt103, bt104, bt105, bt106,
			bt107, bt108, bt109, bt200, bt201, bt202, bt203, bt204, bt205,
			bt206, bt207, bt208, bt209, bt_01, bt_02, bt_03, bt_04, bt_05,
			bt_06, bt_07, bt_08, bt_09, bt_10, bt_11, bt_12, bt_109, bt_110,
			bt_111, bt_209, bt210, bt211;

	public JPanel gioiThieu_DatBan_Panel, TangTret_1, TangTret_2, TangTret_3,
			TangTret_4, TangTret_5, TangTret_6, TangTret_7, TangTret_8,
			TangTret_9, TangTret_10, TangTret_11, TangTret_12, Tang1_11,
			Tang1_12, Tang1_13, Tang1_14;
	private JPanel panel;
	private JLabel lblChiTitHo;
	private JLabel lblSBn;
	private JLabel lblNgyNhp;
	private static UtilDateModel model;
	private static JDatePanelImpl datePanel;
	private JLabel lblMKh;
	public static JScrollPane scroll;

	// Bàn 1 =============================
	private static JTextField tf_soban_1, tf_soban_2, tf_soban_3, tf_soban_4,
			tf_soban_5, tf_soban_6, tf_soban_7, tf_soban_8, tf_soban_9,
			tf_soban_10, tf_soban_11, tf_soban_12, tf_soban_13, tf_soban_14,
			tf_soban_15, tf_soban_16, tf_soban_17, tf_soban_18, tf_soban_19,
			tf_soban_20, tf_soban_21, tf_soban_22, tf_soban_23, tf_soban_24,
			tf_soban_25, tf_soban_26, tf_soban_27, tf_soban_28, tf_soban_29,
			tf_soban_30, tf_soban_31, tf_soban_32, tf_soban_33, tf_soban_34,
			tf_soban_35, tf_soban_36;

	private JPanel panel_theotungban_1, panel_theotungban_2,
			panel_theotungban_3, panel_theotungban_4, panel_theotungban_5,
			panel_theotungban_6, panel_theotungban_7, panel_theotungban_8,
			panel_theotungban_9, panel_theotungban_10, panel_theotungban_11,
			panel_theotungban_12, panel_theotungban_13, panel_theotungban_14,
			panel_theotungban_15, panel_theotungban_16, panel_theotungban_17,
			panel_theotungban_18, panel_theotungban_19, panel_theotungban_20,
			panel_theotungban_21, panel_theotungban_22, panel_theotungban_23,
			panel_theotungban_24, panel_theotungban_25, panel_theotungban_26,
			panel_theotungban_27, panel_theotungban_28, panel_theotungban_29,
			panel_theotungban_30, panel_theotungban_31, panel_theotungban_32,
			panel_theotungban_33, panel_theotungban_34, panel_theotungban_35,
			panel_theotungban_36;
	private JPanel panel_abc_1, panel_abc_2, panel_abc_3, panel_abc_4,
			panel_abc_5, panel_abc_6, panel_abc_7, panel_abc_8, panel_abc_9,
			panel_abc_10, panel_abc_11, panel_abc_12, panel_abc_13,
			panel_abc_14, panel_abc_15, panel_abc_16, panel_abc_17,
			panel_abc_18, panel_abc_19, panel_abc_20, panel_abc_21,
			panel_abc_22, panel_abc_23, panel_abc_24, panel_abc_25,
			panel_abc_26, panel_abc_27, panel_abc_28, panel_abc_29,
			panel_abc_30, panel_abc_31, panel_abc_32, panel_abc_33,
			panel_abc_34, panel_abc_35, panel_abc_36;
	static int check_1 = 0, check_2 = 0, check_3 = 0, check_4 = 0, check_5 = 0,
			check_6 = 0, check_7 = 0, check_8 = 0, check_9 = 0, check_10 = 0,
			check_11 = 0, check_12 = 0, check_13 = 0, check_14 = 0,
			check_15 = 0, check_16 = 0, check_17 = 0, check_18 = 0,
			check_19 = 0, check_20 = 0, check_21 = 0, check_22 = 0,
			check_23 = 0, check_24 = 0, check_25 = 0, check_26 = 0,
			check_27 = 0, check_28 = 0, check_29 = 0, check_30 = 0,
			check_31 = 0, check_32 = 0, check_33 = 0, check_34 = 0,
			check_35 = 0, check_36 = 0;
	private static JDatePickerImpl datePicker_1, datePicker_2, datePicker_3,
			datePicker_4, datePicker_5, datePicker_6, datePicker_7,
			datePicker_8, datePicker_9, datePicker_10, datePicker_11,
			datePicker_12, datePicker_13, datePicker_14, datePicker_15,
			datePicker_16, datePicker_17, datePicker_18, datePicker_19,
			datePicker_20, datePicker_21, datePicker_22, datePicker_23,
			datePicker_24, datePicker_25, datePicker_26, datePicker_27,
			datePicker_28, datePicker_29, datePicker_30, datePicker_31,
			datePicker_32, datePicker_33, datePicker_34, datePicker_35,
			datePicker_36;
	private static JTextField tf_maKH_HD_1, tf_maKH_HD_2, tf_maKH_HD_3,
			tf_maKH_HD_4, tf_maKH_HD_5, tf_maKH_HD_6, tf_maKH_HD_7,
			tf_maKH_HD_8, tf_maKH_HD_9, tf_maKH_HD_10, tf_maKH_HD_11,
			tf_maKH_HD_12, tf_maKH_HD_13, tf_maKH_HD_14, tf_maKH_HD_15,
			tf_maKH_HD_16, tf_maKH_HD_17, tf_maKH_HD_18, tf_maKH_HD_19,
			tf_maKH_HD_20, tf_maKH_HD_21, tf_maKH_HD_22, tf_maKH_HD_23,
			tf_maKH_HD_24, tf_maKH_HD_25, tf_maKH_HD_26, tf_maKH_HD_27,
			tf_maKH_HD_28, tf_maKH_HD_29, tf_maKH_HD_30, tf_maKH_HD_31,
			tf_maKH_HD_32, tf_maKH_HD_33, tf_maKH_HD_34, tf_maKH_HD_35,
			tf_maKH_HD_36;
	private JPanel panel_acc_1, panel_acc_2, panel_acc_3, panel_acc_4,
			panel_acc_5, panel_acc_6, panel_acc_7, panel_acc_8, panel_acc_9,
			panel_acc_10, panel_acc_11, panel_acc_12, panel_acc_13,
			panel_acc_14, panel_acc_15, panel_acc_16, panel_acc_17,
			panel_acc_18, panel_acc_19, panel_acc_20, panel_acc_21,
			panel_acc_22, panel_acc_23, panel_acc_24, panel_acc_25,
			panel_acc_26, panel_acc_27, panel_acc_28, panel_acc_29,
			panel_acc_30, panel_acc_31, panel_acc_32, panel_acc_33,
			panel_acc_34, panel_acc_35, panel_acc_36;
	private JPanel panel_addc_1, panel_addc_2, panel_addc_3, panel_addc_4,
			panel_addc_5, panel_addc_6, panel_addc_7, panel_addc_8,
			panel_addc_9, panel_addc_10, panel_addc_11, panel_addc_12,
			panel_addc_13, panel_addc_14, panel_addc_15, panel_addc_16,
			panel_addc_17, panel_addc_18, panel_addc_19, panel_addc_20,
			panel_addc_21, panel_addc_22, panel_addc_23, panel_addc_24,
			panel_addc_25, panel_addc_26, panel_addc_27, panel_addc_28,
			panel_addc_29, panel_addc_30, panel_addc_31, panel_addc_32,
			panel_addc_33, panel_addc_34, panel_addc_35, panel_addc_36;
	private static JButton btn_tang_1, btn_tang_2, btn_tang_3, btn_tang_4,
			btn_tang_5, btn_tang_6, btn_tang_7, btn_tang_8, btn_tang_9,
			btn_tang_10, btn_tang_11, btn_tang_12, btn_tang_13, btn_tang_14,
			btn_tang_15, btn_tang_16, btn_tang_17, btn_tang_18, btn_tang_19,
			btn_tang_20, btn_tang_21, btn_tang_22, btn_tang_23, btn_tang_24,
			btn_tang_25, btn_tang_26, btn_tang_27, btn_tang_28, btn_tang_29,
			btn_tang_30, btn_tang_31, btn_tang_32, btn_tang_33, btn_tang_34,
			btn_tang_35, btn_tang_36;
	private static JButton btn_giam_1, btn_giam_2, btn_giam_3, btn_giam_4,
			btn_giam_5, btn_giam_6, btn_giam_7, btn_giam_8, btn_giam_9,
			btn_giam_10, btn_giam_11, btn_giam_12, btn_giam_13, btn_giam_14,
			btn_giam_15, btn_giam_16, btn_giam_17, btn_giam_18, btn_giam_19,
			btn_giam_20, btn_giam_21, btn_giam_22, btn_giam_23, btn_giam_24,
			btn_giam_25, btn_giam_26, btn_giam_27, btn_giam_28, btn_giam_29,
			btn_giam_30, btn_giam_31, btn_giam_32, btn_giam_33, btn_giam_34,
			btn_giam_35, btn_giam_36;
	private static JButton btn_sl_macdinh_1, btn_sl_macdinh_2,
			btn_sl_macdinh_3, btn_sl_macdinh_4, btn_sl_macdinh_5,
			btn_sl_macdinh_6, btn_sl_macdinh_7, btn_sl_macdinh_8,
			btn_sl_macdinh_9, btn_sl_macdinh_10, btn_sl_macdinh_11,
			btn_sl_macdinh_12, btn_sl_macdinh_13, btn_sl_macdinh_14,
			btn_sl_macdinh_15, btn_sl_macdinh_16, btn_sl_macdinh_17,
			btn_sl_macdinh_18, btn_sl_macdinh_19, btn_sl_macdinh_20,
			btn_sl_macdinh_21, btn_sl_macdinh_22, btn_sl_macdinh_23,
			btn_sl_macdinh_24, btn_sl_macdinh_25, btn_sl_macdinh_26,
			btn_sl_macdinh_27, btn_sl_macdinh_28, btn_sl_macdinh_29,
			btn_sl_macdinh_30, btn_sl_macdinh_31, btn_sl_macdinh_32,
			btn_sl_macdinh_33, btn_sl_macdinh_34, btn_sl_macdinh_35,
			btn_sl_macdinh_36;
	private static JButton btn_ghichu_1, btn_ghichu_2, btn_ghichu_3,
			btn_ghichu_4, btn_ghichu_5, btn_ghichu_6, btn_ghichu_7,
			btn_ghichu_8, btn_ghichu_9, btn_ghichu_10, btn_ghichu_11,
			btn_ghichu_12, btn_ghichu_13, btn_ghichu_14, btn_ghichu_15,
			btn_ghichu_16, btn_ghichu_17, btn_ghichu_18, btn_ghichu_19,
			btn_ghichu_20, btn_ghichu_21, btn_ghichu_22, btn_ghichu_23,
			btn_ghichu_24, btn_ghichu_25, btn_ghichu_26, btn_ghichu_27,
			btn_ghichu_28, btn_ghichu_29, btn_ghichu_30, btn_ghichu_31,
			btn_ghichu_32, btn_ghichu_33, btn_ghichu_34, btn_ghichu_35,
			btn_ghichu_36;
	private JPanel panel_dbf_1, panel_dbf_2, panel_dbf_3, panel_dbf_4,
			panel_dbf_5, panel_dbf_6, panel_dbf_7, panel_dbf_8, panel_dbf_9,
			panel_dbf_10, panel_dbf_11, panel_dbf_12, panel_dbf_13,
			panel_dbf_14, panel_dbf_15, panel_dbf_16, panel_dbf_17,
			panel_dbf_18, panel_dbf_19, panel_dbf_20, panel_dbf_21,
			panel_dbf_22, panel_dbf_23, panel_dbf_24, panel_dbf_25,
			panel_dbf_26, panel_dbf_27, panel_dbf_28, panel_dbf_29,
			panel_dbf_30, panel_dbf_31, panel_dbf_32, panel_dbf_33,
			panel_dbf_34, panel_dbf_35, panel_dbf_36;
	private JPanel panel_zx_1, panel_zx_2, panel_zx_3, panel_zx_4, panel_zx_5,
			panel_zx_6, panel_zx_7, panel_zx_8, panel_zx_9, panel_zx_10,
			panel_zx_11, panel_zx_12, panel_zx_13, panel_zx_14, panel_zx_15,
			panel_zx_16, panel_zx_17, panel_zx_18, panel_zx_19, panel_zx_20,
			panel_zx_21, panel_zx_22, panel_zx_23, panel_zx_24, panel_zx_25,
			panel_zx_26, panel_zx_27, panel_zx_28, panel_zx_29, panel_zx_30,
			panel_zx_31, panel_zx_32, panel_zx_33, panel_zx_34, panel_zx_35,
			panel_zx_36;
	private JPanel panel_Show_HoaDon_Table_1, panel_Show_HoaDon_Table_2,
			panel_Show_HoaDon_Table_3, panel_Show_HoaDon_Table_4,
			panel_Show_HoaDon_Table_5, panel_Show_HoaDon_Table_6,
			panel_Show_HoaDon_Table_7, panel_Show_HoaDon_Table_8,
			panel_Show_HoaDon_Table_9, panel_Show_HoaDon_Table_10,
			panel_Show_HoaDon_Table_11, panel_Show_HoaDon_Table_12,
			panel_Show_HoaDon_Table_13, panel_Show_HoaDon_Table_14,
			panel_Show_HoaDon_Table_15, panel_Show_HoaDon_Table_16,
			panel_Show_HoaDon_Table_17, panel_Show_HoaDon_Table_18,
			panel_Show_HoaDon_Table_19, panel_Show_HoaDon_Table_20,
			panel_Show_HoaDon_Table_21, panel_Show_HoaDon_Table_22,
			panel_Show_HoaDon_Table_23, panel_Show_HoaDon_Table_24,
			panel_Show_HoaDon_Table_25, panel_Show_HoaDon_Table_26,
			panel_Show_HoaDon_Table_27, panel_Show_HoaDon_Table_28,
			panel_Show_HoaDon_Table_29, panel_Show_HoaDon_Table_30,
			panel_Show_HoaDon_Table_31, panel_Show_HoaDon_Table_32,
			panel_Show_HoaDon_Table_33, panel_Show_HoaDon_Table_34,
			panel_Show_HoaDon_Table_35, panel_Show_HoaDon_Table_36;
	public static JTable table_1, table_2, table_3, table_4, table_5, table_6,
			table_7, table_8, table_9, table_10, table_11, table_12, table_13,
			table_14, table_15, table_16, table_17, table_18, table_19,
			table_20, table_21, table_22, table_23, table_24, table_25,
			table_26, table_27, table_28, table_29, table_30, table_31,
			table_32, table_33, table_34, table_35, table_36;
	static DefaultTableModel datamodel_1, datamodel_2, datamodel_3,
			datamodel_4, datamodel_5, datamodel_6, datamodel_7, datamodel_8,
			datamodel_9, datamodel_10, datamodel_11, datamodel_12,
			datamodel_13, datamodel_14, datamodel_15, datamodel_16,
			datamodel_17, datamodel_18, datamodel_19, datamodel_20,
			datamodel_21, datamodel_22, datamodel_23, datamodel_24,
			datamodel_25, datamodel_26, datamodel_27, datamodel_28,
			datamodel_29, datamodel_30, datamodel_31, datamodel_32,
			datamodel_33, datamodel_34, datamodel_35, datamodel_36;
	static Vector columnames_1 = new Vector();
	static Vector columnames_2 = new Vector();
	static Vector columnames_3 = new Vector();
	static Vector columnames_4 = new Vector();
	static Vector columnames_5 = new Vector();
	static Vector columnames_6 = new Vector();
	static Vector columnames_7 = new Vector();
	static Vector columnames_8 = new Vector();
	static Vector columnames_9 = new Vector();
	static Vector columnames_10 = new Vector();
	static Vector columnames_11 = new Vector();
	static Vector columnames_12 = new Vector();
	static Vector columnames_13 = new Vector();
	static Vector columnames_14 = new Vector();
	static Vector columnames_15 = new Vector();
	static Vector columnames_16 = new Vector();
	static Vector columnames_17 = new Vector();
	static Vector columnames_18 = new Vector();
	static Vector columnames_19 = new Vector();
	static Vector columnames_20 = new Vector();
	static Vector columnames_21 = new Vector();
	static Vector columnames_22 = new Vector();
	static Vector columnames_23 = new Vector();
	static Vector columnames_24 = new Vector();
	static Vector columnames_25 = new Vector();
	static Vector columnames_26 = new Vector();
	static Vector columnames_27 = new Vector();
	static Vector columnames_28 = new Vector();
	static Vector columnames_29 = new Vector();
	static Vector columnames_30 = new Vector();
	static Vector columnames_31 = new Vector();
	static Vector columnames_32 = new Vector();
	static Vector columnames_33 = new Vector();
	static Vector columnames_34 = new Vector();
	static Vector columnames_35 = new Vector();
	static Vector columnames_36 = new Vector();

	static Vector record_1 = null, record_2 = null, record_3 = null,
			record_4 = null, record_5 = null, record_6 = null, record_7 = null,
			record_8 = null, record_9 = null, record_10 = null,
			record_11 = null, record_12 = null, record_13 = null,
			record_14 = null, record_15 = null, record_16 = null,
			record_17 = null, record_18 = null, record_19 = null,
			record_20 = null, record_21 = null, record_22 = null,
			record_23 = null, record_24 = null, record_25 = null,
			record_26 = null, record_27 = null, record_28 = null,
			record_29 = null, record_30 = null, record_31 = null,
			record_32 = null, record_33 = null, record_34 = null,
			record_35 = null, record_36 = null;
	private JButton btn_thanhtoan_1, btn_thanhtoan_2, btn_thanhtoan_3,
			btn_thanhtoan_4, btn_thanhtoan_5, btn_thanhtoan_6, btn_thanhtoan_7,
			btn_thanhtoan_8, btn_thanhtoan_9, btn_thanhtoan_10,
			btn_thanhtoan_11, btn_thanhtoan_12, btn_thanhtoan_13,
			btn_thanhtoan_14, btn_thanhtoan_15, btn_thanhtoan_16,
			btn_thanhtoan_17, btn_thanhtoan_18, btn_thanhtoan_19,
			btn_thanhtoan_20, btn_thanhtoan_21, btn_thanhtoan_23,
			btn_thanhtoan_24, btn_thanhtoan_25, btn_thanhtoan_26,
			btn_thanhtoan_27, btn_thanhtoan_28, btn_thanhtoan_29,
			btn_thanhtoan_30, btn_thanhtoan_31, btn_thanhtoan_32,
			btn_thanhtoan_33, btn_thanhtoan_34, btn_thanhtoan_35,
			btn_thanhtoan_36, btn_thanhtoan_22;
	private JButton btn_capnhat_1, btn_capnhat_2, btn_capnhat_3, btn_capnhat_4,
			btn_capnhat_5, btn_capnhat_6, btn_capnhat_7, btn_capnhat_8,
			btn_capnhat_9, btn_capnhat_10, btn_capnhat_11, btn_capnhat_12,
			btn_capnhat_13, btn_capnhat_14, btn_capnhat_15, btn_capnhat_16,
			btn_capnhat_17, btn_capnhat_18, btn_capnhat_19, btn_capnhat_20,
			btn_capnhat_21, btn_capnhat_22, btn_capnhat_23, btn_capnhat_24,
			btn_capnhat_25, btn_capnhat_26, btn_capnhat_27, btn_capnhat_28,
			btn_capnhat_29, btn_capnhat_30, btn_capnhat_31, btn_capnhat_32,
			btn_capnhat_33, btn_capnhat_34, btn_capnhat_35, btn_capnhat_36;
	private JButton btn_thucdon_1, btn_thucdon_2, btn_thucdon_3, btn_thucdon_4,
			btn_thucdon_5, btn_thucdon_6, btn_thucdon_7, btn_thucdon_8,
			btn_thucdon_9, btn_thucdon_10, btn_thucdon_11, btn_thucdon_12,
			btn_thucdon_13, btn_thucdon_14, btn_thucdon_15, btn_thucdon_16,
			btn_thucdon_17, btn_thucdon_18, btn_thucdon_19, btn_thucdon_20,
			btn_thucdon_21, btn_thucdon_22, btn_thucdon_23, btn_thucdon_24,
			btn_thucdon_25, btn_thucdon_26, btn_thucdon_27, btn_thucdon_28,
			btn_thucdon_29, btn_thucdon_30, btn_thucdon_31, btn_thucdon_32,
			btn_thucdon_33, btn_thucdon_34, btn_thucdon_35, btn_thucdon_36;

	/**
	 * Create the panel.
	 */
	public DatBan_Panel() {
		setLayout(new BorderLayout(0, 0));
		// Phần Title ============================
		JPanel panel_Title = new JPanel();
		panel_Title.setBorder(new LineBorder(Color.ORANGE, 1, true));
		FlowLayout fl_panel_Title = (FlowLayout) panel_Title.getLayout();
		fl_panel_Title.setHgap(0);
		fl_panel_Title.setVgap(0);
		add(panel_Title, BorderLayout.NORTH);

		title_Panel = new TitlePanel("Quản Lý Mặt Hàng");
		panel_Title.add(title_Panel);
		// End Phần Title ===================

		JPanel panel_Show_Table = new JPanel();
		panel_Show_Table
				.setBorder(new LineBorder(new Color(0, 255, 0), 1, true));
		add(panel_Show_Table, BorderLayout.CENTER);
		panel_Show_Table.setLayout(new BorderLayout(0, 0));
		// SplitPanel_Left ===========================================
		SplitPanel_Left = new JPanel();
		SplitPanel_Left.setBorder(new TitledBorder(new LineBorder(new Color(
				255, 200, 0), 1, true), "Danh s\u00E1ch b\u00E0n",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));

		// SplitPanel_Right ===========================================
		SplitPanel_Right = new JPanel();
		SplitPanel_Right.setBorder(new LineBorder(Color.BLUE, 1, true));

		// ============================================================
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
				SplitPanel_Left, SplitPanel_Right);
		SplitPanel_Right.setLayout(new BorderLayout(0, 0));

		panel = new JPanel();
		SplitPanel_Right.add(panel, BorderLayout.NORTH);

		lblChiTitHo = new JLabel("Chi Tiết Hoá Đơn");
		lblChiTitHo.setFont(new Font("Times New Roman", Font.BOLD, 15));
		panel.add(lblChiTitHo);

		// Bàn 1:======================
		panel_theotungban_1 = new JPanel();
		panel_theotungban_1.setBorder(new TitledBorder(new LineBorder(
				new Color(255, 200, 0), 1, true),
				"Th\u00F4ng tin ho\u00E1 \u0111\u01A1n: ",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		// SplitPanel_Right.add(panel_theotungban_1, BorderLayout.CENTER);
		panel_theotungban_1.setLayout(new BorderLayout(0, 0));

		panel_abc_1 = new JPanel();
		panel_theotungban_1.add(panel_abc_1, BorderLayout.NORTH);
		panel_abc_1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		lblSBn = new JLabel("  Số bàn:  ");
		panel_abc_1.add(lblSBn);

		tf_soban_1 = new JTextField();
		panel_abc_1.add(tf_soban_1);
		tf_soban_1.setColumns(10);
		tf_soban_1.setText(" Bàn 1 ");

		lblNgyNhp = new JLabel("     Ngày nhập: ");
		panel_abc_1.add(lblNgyNhp);
		GridBagConstraints gbc_datePicker_1 = new GridBagConstraints();
		model = new UtilDateModel();
		datePanel = new JDatePanelImpl(model);
		datePicker_1 = new JDatePickerImpl(datePanel);
		datePicker_1.getJFormattedTextField().setToolTipText("Click chọn ngày");
		datePicker_1.getJFormattedTextField().setText(ChecNgay.now1());
		gbc_datePicker_1.gridx = 1;
		gbc_datePicker_1.gridy = 3;
		gbc_datePicker_1.insets = new Insets(0, 0, 15, 5);
		gbc_datePicker_1.anchor = GridBagConstraints.WEST;

		panel_abc_1.add(datePicker_1, gbc_datePicker_1);

		lblMKh = new JLabel("   Mã KH: ");
		panel_abc_1.add(lblMKh);

		tf_maKH_HD_1 = new JTextField();
		panel_abc_1.add(tf_maKH_HD_1);
		tf_maKH_HD_1.setColumns(5);

		panel_acc_1 = new JPanel();
		panel_acc_1.setBorder(new TitledBorder(new LineBorder(new Color(255,
				200, 0), 1, true),
				"Chi ti\u1EBFt c\u00E1c MH \u0111\u00E3 ch\u1ECDn: ",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, null));
		panel_theotungban_1.add(panel_acc_1, BorderLayout.CENTER);
		panel_acc_1.setLayout(new BorderLayout(0, 0));

		panel_addc_1 = new JPanel();
		panel_acc_1.add(panel_addc_1, BorderLayout.NORTH);
		panel_addc_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btn_tang_1 = new JButton(" Tăng");
		btn_tang_1.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/new.png")));
		panel_addc_1.add(btn_tang_1);

		btn_giam_1 = new JButton(" Giảm");
		btn_giam_1.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/giam.png")));
		panel_addc_1.add(btn_giam_1);

		btn_sl_macdinh_1 = new JButton("Đặt SL Mặc Định");
		btn_sl_macdinh_1.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/refresh.png")));
		panel_addc_1.add(btn_sl_macdinh_1);

		btn_ghichu_1 = new JButton("Ghi Chú");
		btn_ghichu_1.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/ghichunote.png")));
		panel_addc_1.add(btn_ghichu_1);

		panel_dbf_1 = new JPanel();
		panel_dbf_1.setBorder(new LineBorder(Color.ORANGE, 1, true));
		panel_acc_1.add(panel_dbf_1, BorderLayout.CENTER);
		panel_dbf_1.setLayout(new BorderLayout(0, 0));

		panel_zx_1 = new JPanel();
		panel_zx_1.setBorder(new TitledBorder(new LineBorder(new Color(255,
				200, 0), 1, true), "Ch\u1EE9c n\u0103ng: ",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_dbf_1.add(panel_zx_1, BorderLayout.SOUTH);
		panel_zx_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btn_thanhtoan_1 = new JButton("Thanh Toán");
		btn_thanhtoan_1.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/edit.png")));
		panel_zx_1.add(btn_thanhtoan_1);

		btn_capnhat_1 = new JButton("Cập Nhật");
		btn_capnhat_1.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/refresh.png")));
		panel_zx_1.add(btn_capnhat_1);
		// Panel Table Hoá Đơn ====================================
		// JScrollPane scroll = new JScrollPane(table);
		panel_Show_HoaDon_Table_1 = new JPanel();
		panel_dbf_1.add(panel_Show_HoaDon_Table_1, BorderLayout.CENTER);
		table_1 = new JTable();

		// action = new UpdateAction_HoaDon();
		// lst = action.getAllRows();
		// String[] title = { " ID MH ", " Tên Mặt Hàng ", " Số Lượng ",
		// " ĐVT ",
		// " Giá ", " Thành Tiền " };
		// dtm = new DefaultTableModel(title, 0) {
		// public boolean isCellEditable(int row, int column) {
		// if (column == 0 && (row == 0 && row <= lst.size()))
		// return false;
		// return true;
		// };
		// };
		columnames_1.add(" ID MH ");
		columnames_1.add(" Tên Mặt Hàng ");
		columnames_1.add(" Số Lượng ");
		columnames_1.add(" ĐVT ");
		columnames_1.add(" Giá ");
		columnames_1.add(" Thành Tiền ");

		// ++++++Set du lieu cho bang
		datamodel_1 = new DefaultTableModel(record_1, columnames_1);
		table_1.setModel(datamodel_1);

		// ++++++dieu chinh kich co cua bang
		table_1.setPreferredScrollableViewportSize(new Dimension(600, 250));
		table_1.setFillsViewportHeight(true);

		// ++++++them thanh cuon cho bang
		JScrollPane scroll_1 = new JScrollPane(table_1);

		scroll_1 = new JScrollPane(table_1,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		// Table.adjustColumnPreferredWidths(table);
		table_1.revalidate();
		panel_Show_HoaDon_Table_1.add(scroll_1);

		// End Panel Table Hoá Đơn ====================================
		// Bàn 1:======================================================
		// Bàn 2:======================
		panel_theotungban_2 = new JPanel();
		panel_theotungban_2.setBorder(new TitledBorder(new LineBorder(
				new Color(255, 200, 0), 1, true),
				"Th\u00F4ng tin ho\u00E1 \u0111\u01A1n: ",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		// SplitPanel_Right.add(panel_theotungban_2, BorderLayout.CENTER);
		panel_theotungban_2.setLayout(new BorderLayout(0, 0));

		panel_abc_2 = new JPanel();
		panel_theotungban_2.add(panel_abc_2, BorderLayout.NORTH);
		panel_abc_2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		lblSBn = new JLabel("  Số bàn:  ");
		panel_abc_2.add(lblSBn);

		tf_soban_2 = new JTextField();
		panel_abc_2.add(tf_soban_2);
		tf_soban_2.setColumns(10);
		tf_soban_2.setText(" Bàn 2 ");

		lblNgyNhp = new JLabel("     Ngày nhập: ");
		panel_abc_2.add(lblNgyNhp);
		GridBagConstraints gbc_datePicker_2 = new GridBagConstraints();
		model = new UtilDateModel();
		datePanel = new JDatePanelImpl(model);
		datePicker_2 = new JDatePickerImpl(datePanel);
		datePicker_2.getJFormattedTextField().setToolTipText("Click chọn ngày");
		// datePicker.getJButton().addKeyListener(action);
		// datePicker.getJFormattedTextField().addKeyListener(action);
		datePicker_2.getJFormattedTextField().setText(ChecNgay.now1());
		gbc_datePicker_2.gridx = 1;
		gbc_datePicker_2.gridy = 3;
		gbc_datePicker_2.insets = new Insets(0, 0, 15, 5);
		gbc_datePicker_2.anchor = GridBagConstraints.WEST;

		panel_abc_2.add(datePicker_2, gbc_datePicker_2);

		lblMKh = new JLabel("   Mã KH: ");
		panel_abc_2.add(lblMKh);

		tf_maKH_HD_2 = new JTextField();
		panel_abc_2.add(tf_maKH_HD_2);
		tf_maKH_HD_2.setColumns(5);

		panel_acc_2 = new JPanel();
		panel_acc_2.setBorder(new TitledBorder(new LineBorder(new Color(255,
				200, 0), 1, true),
				"Chi ti\u1EBFt c\u00E1c MH \u0111\u00E3 ch\u1ECDn: ",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, null));
		panel_theotungban_2.add(panel_acc_2, BorderLayout.CENTER);
		panel_acc_2.setLayout(new BorderLayout(0, 0));

		panel_addc_2 = new JPanel();
		panel_acc_2.add(panel_addc_2, BorderLayout.NORTH);
		panel_addc_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btn_tang_2 = new JButton(" Tăng");
		btn_tang_2.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/new.png")));
		panel_addc_2.add(btn_tang_2);

		btn_giam_2 = new JButton(" Giảm");
		btn_giam_2.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/giam.png")));
		panel_addc_2.add(btn_giam_2);

		btn_sl_macdinh_2 = new JButton("Đặt SL Mặc Định");
		btn_sl_macdinh_2.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/refresh.png")));
		panel_addc_2.add(btn_sl_macdinh_2);

		btn_ghichu_2 = new JButton("Ghi Chú");
		btn_ghichu_2.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/ghichunote.png")));
		panel_addc_2.add(btn_ghichu_2);

		panel_dbf_2 = new JPanel();
		panel_dbf_2.setBorder(new LineBorder(Color.ORANGE, 1, true));
		panel_acc_2.add(panel_dbf_2, BorderLayout.CENTER);
		panel_dbf_2.setLayout(new BorderLayout(0, 0));

		panel_zx_2 = new JPanel();
		panel_zx_2.setBorder(new TitledBorder(new LineBorder(new Color(255,
				200, 0), 1, true), "Ch\u1EE9c n\u0103ng: ",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_dbf_2.add(panel_zx_2, BorderLayout.SOUTH);
		panel_zx_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btn_thanhtoan_2 = new JButton("Thanh Toán");
		btn_thanhtoan_2.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/edit.png")));
		panel_zx_2.add(btn_thanhtoan_2);

		btn_capnhat_2 = new JButton("Cập Nhật");
		btn_capnhat_2.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/refresh.png")));
		panel_zx_2.add(btn_capnhat_2);
		// Panel Table Hoá Đơn ====================================
		// JScrollPane scroll = new JScrollPane(table);
		panel_Show_HoaDon_Table_2 = new JPanel();
		panel_dbf_2.add(panel_Show_HoaDon_Table_2, BorderLayout.CENTER);
		table_2 = new JTable();

		columnames_2.add(" ID MH ");
		columnames_2.add(" Tên Mặt Hàng ");
		columnames_2.add(" Số Lượng ");
		columnames_2.add(" ĐVT ");
		columnames_2.add(" Giá ");
		columnames_2.add(" Thành Tiền ");

		// ++++++Set du lieu cho bang
		datamodel_2 = new DefaultTableModel(record_2, columnames_2);
		table_2.setModel(datamodel_2);

		// ++++++dieu chinh kich co cua bang
		table_2.setPreferredScrollableViewportSize(new Dimension(600, 250));
		table_2.setFillsViewportHeight(true);

		// ++++++them thanh cuon cho bang
		JScrollPane scroll_2 = new JScrollPane(table_2);

		scroll_2 = new JScrollPane(table_2,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		// Table.adjustColumnPreferredWidths(table);
		table_2.revalidate();
		panel_Show_HoaDon_Table_2.add(scroll_2);

		// End Panel Table Hoá Đơn ====================================
		// Bàn 2:======================================================
		// Bàn 3:======================
		panel_theotungban_3 = new JPanel();
		panel_theotungban_3.setBorder(new TitledBorder(new LineBorder(
				new Color(255, 200, 0), 1, true),
				"Th\u00F4ng tin ho\u00E1 \u0111\u01A1n: ",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		// SplitPanel_Right.add(panel_theotungban_3, BorderLayout.CENTER);
		panel_theotungban_3.setLayout(new BorderLayout(0, 0));

		panel_abc_3 = new JPanel();
		panel_theotungban_3.add(panel_abc_3, BorderLayout.NORTH);
		panel_abc_3.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		lblSBn = new JLabel("  Số bàn:  ");
		panel_abc_3.add(lblSBn);

		tf_soban_3 = new JTextField();
		panel_abc_3.add(tf_soban_3);
		tf_soban_3.setColumns(10);
		tf_soban_3.setText(" Bàn 3 ");

		lblNgyNhp = new JLabel("     Ngày nhập: ");
		panel_abc_3.add(lblNgyNhp);
		GridBagConstraints gbc_datePicker_3 = new GridBagConstraints();
		model = new UtilDateModel();
		datePanel = new JDatePanelImpl(model);
		datePicker_3 = new JDatePickerImpl(datePanel);
		datePicker_3.getJFormattedTextField().setToolTipText("Click chọn ngày");
		// datePicker.getJButton().addKeyListener(action);
		// datePicker.getJFormattedTextField().addKeyListener(action);
		datePicker_3.getJFormattedTextField().setText(ChecNgay.now1());
		gbc_datePicker_3.gridx = 1;
		gbc_datePicker_3.gridy = 3;
		gbc_datePicker_3.insets = new Insets(0, 0, 15, 5);
		gbc_datePicker_3.anchor = GridBagConstraints.WEST;

		panel_abc_3.add(datePicker_3, gbc_datePicker_3);

		lblMKh = new JLabel("   Mã KH: ");
		panel_abc_3.add(lblMKh);

		tf_maKH_HD_3 = new JTextField();
		panel_abc_3.add(tf_maKH_HD_3);
		tf_maKH_HD_3.setColumns(5);

		panel_acc_3 = new JPanel();
		panel_acc_3.setBorder(new TitledBorder(new LineBorder(new Color(255,
				200, 0), 1, true),
				"Chi ti\u1EBFt c\u00E1c MH \u0111\u00E3 ch\u1ECDn: ",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, null));
		panel_theotungban_3.add(panel_acc_3, BorderLayout.CENTER);
		panel_acc_3.setLayout(new BorderLayout(0, 0));

		panel_addc_3 = new JPanel();
		panel_acc_3.add(panel_addc_3, BorderLayout.NORTH);
		panel_addc_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btn_tang_3 = new JButton(" Tăng");
		btn_tang_3.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/new.png")));
		panel_addc_3.add(btn_tang_3);

		btn_giam_3 = new JButton(" Giảm");
		btn_giam_3.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/giam.png")));
		panel_addc_3.add(btn_giam_3);

		btn_sl_macdinh_3 = new JButton("Đặt SL Mặc Định");
		btn_sl_macdinh_3.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/refresh.png")));
		panel_addc_3.add(btn_sl_macdinh_3);

		btn_ghichu_3 = new JButton("Ghi Chú");
		btn_ghichu_3.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/ghichunote.png")));
		panel_addc_3.add(btn_ghichu_3);

		panel_dbf_3 = new JPanel();
		panel_dbf_3.setBorder(new LineBorder(Color.ORANGE, 1, true));
		panel_acc_3.add(panel_dbf_3, BorderLayout.CENTER);
		panel_dbf_3.setLayout(new BorderLayout(0, 0));

		panel_zx_3 = new JPanel();
		panel_zx_3.setBorder(new TitledBorder(new LineBorder(new Color(255,
				200, 0), 1, true), "Ch\u1EE9c n\u0103ng: ",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_dbf_3.add(panel_zx_3, BorderLayout.SOUTH);
		panel_zx_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btn_thanhtoan_3 = new JButton("Thanh Toán");
		btn_thanhtoan_3.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/edit.png")));
		panel_zx_3.add(btn_thanhtoan_3);

		btn_capnhat_3 = new JButton("Cập Nhật");
		btn_capnhat_3.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/refresh.png")));
		panel_zx_3.add(btn_capnhat_3);
		// Panel Table Hoá Đơn ====================================
		// JScrollPane scroll = new JScrollPane(table);
		panel_Show_HoaDon_Table_3 = new JPanel();
		panel_dbf_3.add(panel_Show_HoaDon_Table_3, BorderLayout.CENTER);
		table_3 = new JTable();

		columnames_3.add(" ID MH ");
		columnames_3.add(" Tên Mặt Hàng ");
		columnames_3.add(" Số Lượng ");
		columnames_3.add(" ĐVT ");
		columnames_3.add(" Giá ");
		columnames_3.add(" Thành Tiền ");

		// ++++++Set du lieu cho bang
		datamodel_3 = new DefaultTableModel(record_3, columnames_3);
		table_3.setModel(datamodel_3);

		// ++++++dieu chinh kich co cua bang
		table_3.setPreferredScrollableViewportSize(new Dimension(600, 250));
		table_3.setFillsViewportHeight(true);

		// ++++++them thanh cuon cho bang
		JScrollPane scroll_3 = new JScrollPane(table_3);

		scroll_3 = new JScrollPane(table_3,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		// Table.adjustColumnPreferredWidths(table);
		table_3.revalidate();
		panel_Show_HoaDon_Table_3.add(scroll_3);

		// End Panel Table Hoá Đơn ====================================
		// Bàn 3:======================================================
		// Bàn 4:======================
		panel_theotungban_4 = new JPanel();
		panel_theotungban_4.setBorder(new TitledBorder(new LineBorder(
				new Color(255, 200, 0), 1, true),
				"Th\u00F4ng tin ho\u00E1 \u0111\u01A1n: ",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		// SplitPanel_Right.add(panel_theotungban_4, BorderLayout.CENTER);
		panel_theotungban_4.setLayout(new BorderLayout(0, 0));

		panel_abc_4 = new JPanel();
		panel_theotungban_4.add(panel_abc_4, BorderLayout.NORTH);
		panel_abc_4.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		lblSBn = new JLabel("  Số bàn:  ");
		panel_abc_4.add(lblSBn);

		tf_soban_4 = new JTextField();
		panel_abc_4.add(tf_soban_4);
		tf_soban_4.setColumns(10);
		tf_soban_4.setText(" Bàn 4 ");

		lblNgyNhp = new JLabel("     Ngày nhập: ");
		panel_abc_4.add(lblNgyNhp);
		// =============================================================
		GridBagConstraints gbc_datePicker_4 = new GridBagConstraints();
		// =============================================================
		model = new UtilDateModel();
		datePanel = new JDatePanelImpl(model);
		datePicker_4 = new JDatePickerImpl(datePanel);
		datePicker_4.getJFormattedTextField().setToolTipText("Click chọn ngày");
		datePicker_4.getJFormattedTextField().setText(ChecNgay.now1());
		gbc_datePicker_4.gridx = 1;
		gbc_datePicker_4.gridy = 3;
		gbc_datePicker_4.insets = new Insets(0, 0, 15, 5);
		gbc_datePicker_4.anchor = GridBagConstraints.WEST;

		panel_abc_4.add(datePicker_4, gbc_datePicker_4);

		lblMKh = new JLabel("   Mã KH: ");
		panel_abc_4.add(lblMKh);

		tf_maKH_HD_4 = new JTextField();
		panel_abc_4.add(tf_maKH_HD_4);
		tf_maKH_HD_4.setColumns(5);

		panel_acc_4 = new JPanel();
		panel_acc_4.setBorder(new TitledBorder(new LineBorder(new Color(255,
				200, 0), 1, true),
				"Chi ti\u1EBFt c\u00E1c MH \u0111\u00E3 ch\u1ECDn: ",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, null));
		panel_theotungban_4.add(panel_acc_4, BorderLayout.CENTER);
		panel_acc_4.setLayout(new BorderLayout(0, 0));

		panel_addc_4 = new JPanel();
		panel_acc_4.add(panel_addc_4, BorderLayout.NORTH);
		panel_addc_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btn_tang_4 = new JButton(" Tăng");
		btn_tang_4.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/new.png")));
		panel_addc_4.add(btn_tang_4);

		btn_giam_4 = new JButton(" Giảm");
		btn_giam_4.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/giam.png")));
		panel_addc_4.add(btn_giam_4);

		btn_sl_macdinh_4 = new JButton("Đặt SL Mặc Định");
		btn_sl_macdinh_4.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/refresh.png")));
		panel_addc_4.add(btn_sl_macdinh_4);

		btn_ghichu_4 = new JButton("Ghi Chú");
		btn_ghichu_4.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/ghichunote.png")));
		panel_addc_4.add(btn_ghichu_4);

		panel_dbf_4 = new JPanel();
		panel_dbf_4.setBorder(new LineBorder(Color.ORANGE, 1, true));
		panel_acc_4.add(panel_dbf_4, BorderLayout.CENTER);
		panel_dbf_4.setLayout(new BorderLayout(0, 0));

		panel_zx_4 = new JPanel();
		panel_zx_4.setBorder(new TitledBorder(new LineBorder(new Color(255,
				200, 0), 1, true), "Ch\u1EE9c n\u0103ng: ",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_dbf_4.add(panel_zx_4, BorderLayout.SOUTH);
		panel_zx_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btn_thanhtoan_4 = new JButton("Thanh Toán");
		btn_thanhtoan_4.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/edit.png")));
		panel_zx_4.add(btn_thanhtoan_4);

		btn_capnhat_4 = new JButton("Cập Nhật");
		btn_capnhat_4.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/refresh.png")));
		panel_zx_4.add(btn_capnhat_4);
		panel_Show_HoaDon_Table_4 = new JPanel();
		panel_dbf_4.add(panel_Show_HoaDon_Table_4, BorderLayout.CENTER);
		table_4 = new JTable();

		columnames_4.add(" ID MH ");
		columnames_4.add(" Tên Mặt Hàng ");
		columnames_4.add(" Số Lượng ");
		columnames_4.add(" ĐVT ");
		columnames_4.add(" Giá ");
		columnames_4.add(" Thành Tiền ");

		// ++++++Set du lieu cho bang
		datamodel_4 = new DefaultTableModel(record_4, columnames_4);
		table_4.setModel(datamodel_4);

		// ++++++dieu chinh kich co cua bang
		table_4.setPreferredScrollableViewportSize(new Dimension(600, 250));
		table_4.setFillsViewportHeight(true);

		// ++++++them thanh cuon cho bang
		// ======================================================
		JScrollPane scroll_4 = new JScrollPane(table_4);
		// ======================================================

		scroll_4 = new JScrollPane(table_4,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		// Table.adjustColumnPreferredWidths(table);
		table_4.revalidate();
		panel_Show_HoaDon_Table_4.add(scroll_4);

		// End Panel Table Hoá Đơn ====================================
		// Bàn 4:======================================================
		// Bàn 5:======================
		panel_theotungban_5 = new JPanel();
		panel_theotungban_5.setBorder(new TitledBorder(new LineBorder(
				new Color(255, 200, 0), 1, true),
				"Th\u00F4ng tin ho\u00E1 \u0111\u01A1n: ",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		// SplitPanel_Right.add(panel_theotungban_5, BorderLayout.CENTER);
		panel_theotungban_5.setLayout(new BorderLayout(0, 0));

		panel_abc_5 = new JPanel();
		panel_theotungban_5.add(panel_abc_5, BorderLayout.NORTH);
		panel_abc_5.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		lblSBn = new JLabel("  Số bàn:  ");
		panel_abc_5.add(lblSBn);

		tf_soban_5 = new JTextField();
		panel_abc_5.add(tf_soban_5);
		tf_soban_5.setColumns(10);
		tf_soban_5.setText(" Bàn 5 ");

		lblNgyNhp = new JLabel("     Ngày nhập: ");
		panel_abc_5.add(lblNgyNhp);
		// =============================================================
		GridBagConstraints gbc_datePicker_5 = new GridBagConstraints();
		// =============================================================
		model = new UtilDateModel();
		datePanel = new JDatePanelImpl(model);
		datePicker_5 = new JDatePickerImpl(datePanel);
		datePicker_5.getJFormattedTextField().setToolTipText("Click chọn ngày");
		datePicker_5.getJFormattedTextField().setText(ChecNgay.now1());
		gbc_datePicker_5.gridx = 1;
		gbc_datePicker_5.gridy = 3;
		gbc_datePicker_5.insets = new Insets(0, 0, 15, 5);
		gbc_datePicker_5.anchor = GridBagConstraints.WEST;

		panel_abc_5.add(datePicker_5, gbc_datePicker_5);

		lblMKh = new JLabel("   Mã KH: ");
		panel_abc_5.add(lblMKh);

		tf_maKH_HD_5 = new JTextField();
		panel_abc_5.add(tf_maKH_HD_5);
		tf_maKH_HD_5.setColumns(5);

		panel_acc_5 = new JPanel();
		panel_acc_5.setBorder(new TitledBorder(new LineBorder(new Color(255,
				200, 0), 1, true),
				"Chi ti\u1EBFt c\u00E1c MH \u0111\u00E3 ch\u1ECDn: ",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, null));
		panel_theotungban_5.add(panel_acc_5, BorderLayout.CENTER);
		panel_acc_5.setLayout(new BorderLayout(0, 0));

		panel_addc_5 = new JPanel();
		panel_acc_5.add(panel_addc_5, BorderLayout.NORTH);
		panel_addc_5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btn_tang_5 = new JButton(" Tăng");
		btn_tang_5.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/new.png")));
		panel_addc_5.add(btn_tang_5);

		btn_giam_5 = new JButton(" Giảm");
		btn_giam_5.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/giam.png")));
		panel_addc_5.add(btn_giam_5);

		btn_sl_macdinh_5 = new JButton("Đặt SL Mặc Định");
		btn_sl_macdinh_5.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/refresh.png")));
		panel_addc_5.add(btn_sl_macdinh_5);

		btn_ghichu_5 = new JButton("Ghi Chú");
		btn_ghichu_5.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/ghichunote.png")));
		panel_addc_5.add(btn_ghichu_5);

		panel_dbf_5 = new JPanel();
		panel_dbf_5.setBorder(new LineBorder(Color.ORANGE, 1, true));
		panel_acc_5.add(panel_dbf_5, BorderLayout.CENTER);
		panel_dbf_5.setLayout(new BorderLayout(0, 0));

		panel_zx_5 = new JPanel();
		panel_zx_5.setBorder(new TitledBorder(new LineBorder(new Color(255,
				200, 0), 1, true), "Ch\u1EE9c n\u0103ng: ",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_dbf_5.add(panel_zx_5, BorderLayout.SOUTH);
		panel_zx_5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btn_thanhtoan_5 = new JButton("Thanh Toán");
		btn_thanhtoan_5.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/edit.png")));
		panel_zx_5.add(btn_thanhtoan_5);

		btn_capnhat_5 = new JButton("Cập Nhật");
		btn_capnhat_5.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/refresh.png")));
		panel_zx_5.add(btn_capnhat_5);
		panel_Show_HoaDon_Table_5 = new JPanel();
		panel_dbf_5.add(panel_Show_HoaDon_Table_5, BorderLayout.CENTER);
		table_5 = new JTable();

		columnames_5.add(" ID MH ");
		columnames_5.add(" Tên Mặt Hàng ");
		columnames_5.add(" Số Lượng ");
		columnames_5.add(" ĐVT ");
		columnames_5.add(" Giá ");
		columnames_5.add(" Thành Tiền ");

		// ++++++Set du lieu cho bang
		datamodel_5 = new DefaultTableModel(record_5, columnames_5);
		table_5.setModel(datamodel_5);

		// ++++++dieu chinh kich co cua bang
		table_5.setPreferredScrollableViewportSize(new Dimension(600, 250));
		table_5.setFillsViewportHeight(true);

		// ++++++them thanh cuon cho bang
		// ======================================================
		JScrollPane scroll_5 = new JScrollPane(table_5);
		// ======================================================

		scroll_5 = new JScrollPane(table_5,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		// Table.adjustColumnPreferredWidths(table);
		table_5.revalidate();
		panel_Show_HoaDon_Table_5.add(scroll_5);

		// End Panel Table Hoá Đơn ====================================
		// Bàn 5:======================================================
		// Bàn_6:======================
		panel_theotungban_6 = new JPanel();
		panel_theotungban_6.setBorder(new TitledBorder(new LineBorder(
				new Color(255, 200, 0), 1, true),
				"Th\u00F4ng tin ho\u00E1 \u0111\u01A1n: ",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		// SplitPanel_Right.add(panel_theotungban_6, BorderLayout.CENTER);
		panel_theotungban_6.setLayout(new BorderLayout(0, 0));

		panel_abc_6 = new JPanel();
		panel_theotungban_6.add(panel_abc_6, BorderLayout.NORTH);
		panel_abc_6.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		lblSBn = new JLabel("  Số bàn:  ");
		panel_abc_6.add(lblSBn);

		tf_soban_6 = new JTextField();
		panel_abc_6.add(tf_soban_6);
		tf_soban_6.setColumns(10);
		tf_soban_6.setText(" Bàn 6 ");

		lblNgyNhp = new JLabel("     Ngày nhập: ");
		panel_abc_6.add(lblNgyNhp);
		// =============================================================
		GridBagConstraints gbc_datePicker_6 = new GridBagConstraints();
		// =============================================================
		model = new UtilDateModel();
		datePanel = new JDatePanelImpl(model);
		datePicker_6 = new JDatePickerImpl(datePanel);
		datePicker_6.getJFormattedTextField().setToolTipText("Click chọn ngày");
		datePicker_6.getJFormattedTextField().setText(ChecNgay.now1());
		gbc_datePicker_6.gridx = 1;
		gbc_datePicker_6.gridy = 3;
		gbc_datePicker_6.insets = new Insets(0, 0, 15, 5);
		gbc_datePicker_6.anchor = GridBagConstraints.WEST;

		panel_abc_6.add(datePicker_6, gbc_datePicker_6);

		lblMKh = new JLabel("   Mã KH: ");
		panel_abc_6.add(lblMKh);

		tf_maKH_HD_6 = new JTextField();
		panel_abc_6.add(tf_maKH_HD_6);
		tf_maKH_HD_6.setColumns(5);

		panel_acc_6 = new JPanel();
		panel_acc_6.setBorder(new TitledBorder(new LineBorder(new Color(255,
				200, 0), 1, true),
				"Chi ti\u1EBFt c\u00E1c MH \u0111\u00E3 ch\u1ECDn: ",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, null));
		panel_theotungban_6.add(panel_acc_6, BorderLayout.CENTER);
		panel_acc_6.setLayout(new BorderLayout(0, 0));

		panel_addc_6 = new JPanel();
		panel_acc_6.add(panel_addc_6, BorderLayout.NORTH);
		panel_addc_6.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btn_tang_6 = new JButton(" Tăng");
		btn_tang_6.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/new.png")));
		panel_addc_6.add(btn_tang_6);

		btn_giam_6 = new JButton(" Giảm");
		btn_giam_6.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/giam.png")));
		panel_addc_6.add(btn_giam_6);

		btn_sl_macdinh_6 = new JButton("Đặt SL Mặc Định");
		btn_sl_macdinh_6.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/refresh.png")));
		panel_addc_6.add(btn_sl_macdinh_6);

		btn_ghichu_6 = new JButton("Ghi Chú");
		btn_ghichu_6.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/ghichunote.png")));
		panel_addc_6.add(btn_ghichu_6);

		panel_dbf_6 = new JPanel();
		panel_dbf_6.setBorder(new LineBorder(Color.ORANGE, 1, true));
		panel_acc_6.add(panel_dbf_6, BorderLayout.CENTER);
		panel_dbf_6.setLayout(new BorderLayout(0, 0));

		panel_zx_6 = new JPanel();
		panel_zx_6.setBorder(new TitledBorder(new LineBorder(new Color(255,
				200, 0), 1, true), "Ch\u1EE9c n\u0103ng: ",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_dbf_6.add(panel_zx_6, BorderLayout.SOUTH);
		panel_zx_6.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btn_thanhtoan_6 = new JButton("Thanh Toán");
		btn_thanhtoan_6.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/edit.png")));
		panel_zx_6.add(btn_thanhtoan_6);

		btn_capnhat_6 = new JButton("Cập Nhật");
		btn_capnhat_6.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/refresh.png")));
		panel_zx_6.add(btn_capnhat_6);
		panel_Show_HoaDon_Table_6 = new JPanel();
		panel_dbf_6.add(panel_Show_HoaDon_Table_6, BorderLayout.CENTER);
		table_6 = new JTable();

		columnames_6.add(" ID MH ");
		columnames_6.add(" Tên Mặt Hàng ");
		columnames_6.add(" Số Lượng ");
		columnames_6.add(" ĐVT ");
		columnames_6.add(" Giá ");
		columnames_6.add(" Thành Tiền ");

		// ++++++Set du lieu cho bang
		datamodel_6 = new DefaultTableModel(record_6, columnames_6);
		table_6.setModel(datamodel_6);

		// ++++++dieu chinh kich co cua bang
		table_6.setPreferredScrollableViewportSize(new Dimension(600, 250));
		table_6.setFillsViewportHeight(true);

		// ++++++them thanh cuon cho bang
		// ======================================================
		JScrollPane scroll_6 = new JScrollPane(table_6);
		// ======================================================

		scroll_6 = new JScrollPane(table_6,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		// Table.adjustColumnPreferredWidths(table);
		table_6.revalidate();
		panel_Show_HoaDon_Table_6.add(scroll_6);

		// End Panel Table Hoá Đơn ====================================
		// Bàn_6:======================================================
		// Bàn_7:======================
		panel_theotungban_7 = new JPanel();
		panel_theotungban_7.setBorder(new TitledBorder(new LineBorder(
				new Color(255, 200, 0), 1, true),
				"Th\u00F4ng tin ho\u00E1 \u0111\u01A1n: ",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		// SplitPanel_Right.add(panel_theotungban_7, BorderLayout.CENTER);
		panel_theotungban_7.setLayout(new BorderLayout(0, 0));

		panel_abc_7 = new JPanel();
		panel_theotungban_7.add(panel_abc_7, BorderLayout.NORTH);
		panel_abc_7.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		lblSBn = new JLabel("  Số bàn:  ");
		panel_abc_7.add(lblSBn);

		tf_soban_7 = new JTextField();
		panel_abc_7.add(tf_soban_7);
		tf_soban_7.setColumns(10);
		tf_soban_7.setText(" Bàn 7 ");

		lblNgyNhp = new JLabel("     Ngày nhập: ");
		panel_abc_7.add(lblNgyNhp);
		// =============================================================
		GridBagConstraints gbc_datePicker_7 = new GridBagConstraints();
		// =============================================================
		model = new UtilDateModel();
		datePanel = new JDatePanelImpl(model);
		datePicker_7 = new JDatePickerImpl(datePanel);
		datePicker_7.getJFormattedTextField().setToolTipText("Click chọn ngày");
		datePicker_7.getJFormattedTextField().setText(ChecNgay.now1());
		gbc_datePicker_7.gridx = 1;
		gbc_datePicker_7.gridy = 3;
		gbc_datePicker_7.insets = new Insets(0, 0, 15, 5);
		gbc_datePicker_7.anchor = GridBagConstraints.WEST;

		panel_abc_7.add(datePicker_7, gbc_datePicker_7);

		lblMKh = new JLabel("   Mã KH: ");
		panel_abc_7.add(lblMKh);

		tf_maKH_HD_7 = new JTextField();
		panel_abc_7.add(tf_maKH_HD_7);
		tf_maKH_HD_7.setColumns(5);

		panel_acc_7 = new JPanel();
		panel_acc_7.setBorder(new TitledBorder(new LineBorder(new Color(255,
				200, 0), 1, true),
				"Chi ti\u1EBFt c\u00E1c MH \u0111\u00E3 ch\u1ECDn: ",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, null));
		panel_theotungban_7.add(panel_acc_7, BorderLayout.CENTER);
		panel_acc_7.setLayout(new BorderLayout(0, 0));

		panel_addc_7 = new JPanel();
		panel_acc_7.add(panel_addc_7, BorderLayout.NORTH);
		panel_addc_7.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btn_tang_7 = new JButton(" Tăng");
		btn_tang_7.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/new.png")));
		panel_addc_7.add(btn_tang_7);

		btn_giam_7 = new JButton(" Giảm");
		btn_giam_7.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/giam.png")));
		panel_addc_7.add(btn_giam_7);

		btn_sl_macdinh_7 = new JButton("Đặt SL Mặc Định");
		btn_sl_macdinh_7.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/refresh.png")));
		panel_addc_7.add(btn_sl_macdinh_7);

		btn_ghichu_7 = new JButton("Ghi Chú");
		btn_ghichu_7.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/ghichunote.png")));
		panel_addc_7.add(btn_ghichu_7);

		panel_dbf_7 = new JPanel();
		panel_dbf_7.setBorder(new LineBorder(Color.ORANGE, 1, true));
		panel_acc_7.add(panel_dbf_7, BorderLayout.CENTER);
		panel_dbf_7.setLayout(new BorderLayout(0, 0));

		panel_zx_7 = new JPanel();
		panel_zx_7.setBorder(new TitledBorder(new LineBorder(new Color(255,
				200, 0), 1, true), "Ch\u1EE9c n\u0103ng: ",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_dbf_7.add(panel_zx_7, BorderLayout.SOUTH);
		panel_zx_7.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btn_thanhtoan_7 = new JButton("Thanh Toán");
		btn_thanhtoan_7.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/edit.png")));
		panel_zx_7.add(btn_thanhtoan_7);

		btn_capnhat_7 = new JButton("Cập Nhật");
		btn_capnhat_7.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/refresh.png")));
		panel_zx_7.add(btn_capnhat_7);
		panel_Show_HoaDon_Table_7 = new JPanel();
		panel_dbf_7.add(panel_Show_HoaDon_Table_7, BorderLayout.CENTER);
		table_7 = new JTable();

		columnames_7.add(" ID MH ");
		columnames_7.add(" Tên Mặt Hàng ");
		columnames_7.add(" Số Lượng ");
		columnames_7.add(" ĐVT ");
		columnames_7.add(" Giá ");
		columnames_7.add(" Thành Tiền ");

		// ++++++Set du lieu cho bang
		datamodel_7 = new DefaultTableModel(record_7, columnames_7);
		table_7.setModel(datamodel_7);

		// ++++++dieu chinh kich co cua bang
		table_7.setPreferredScrollableViewportSize(new Dimension(600, 250));
		table_7.setFillsViewportHeight(true);

		// ++++++them thanh cuon cho bang
		// ======================================================
		JScrollPane scroll_7 = new JScrollPane(table_7);
		// ======================================================

		scroll_7 = new JScrollPane(table_7,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		// Table.adjustColumnPreferredWidths(table);
		table_7.revalidate();
		panel_Show_HoaDon_Table_7.add(scroll_7);

		// End Panel Table Hoá Đơn ====================================
		// Bàn_7:======================================================
		// Bàn_8:======================
		panel_theotungban_8 = new JPanel();
		panel_theotungban_8.setBorder(new TitledBorder(new LineBorder(
				new Color(255, 200, 0), 1, true),
				"Th\u00F4ng tin ho\u00E1 \u0111\u01A1n: ",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		// SplitPanel_Right.add(panel_theotungban_8, BorderLayout.CENTER);
		panel_theotungban_8.setLayout(new BorderLayout(0, 0));

		panel_abc_8 = new JPanel();
		panel_theotungban_8.add(panel_abc_8, BorderLayout.NORTH);
		panel_abc_8.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		lblSBn = new JLabel("  Số bàn:  ");
		panel_abc_8.add(lblSBn);

		tf_soban_8 = new JTextField();
		panel_abc_8.add(tf_soban_8);
		tf_soban_8.setColumns(10);
		tf_soban_8.setText(" Bàn 8 ");

		lblNgyNhp = new JLabel("     Ngày nhập: ");
		panel_abc_8.add(lblNgyNhp);
		// =============================================================
		GridBagConstraints gbc_datePicker_8 = new GridBagConstraints();
		// =============================================================
		model = new UtilDateModel();
		datePanel = new JDatePanelImpl(model);
		datePicker_8 = new JDatePickerImpl(datePanel);
		datePicker_8.getJFormattedTextField().setToolTipText("Click chọn ngày");
		datePicker_8.getJFormattedTextField().setText(ChecNgay.now1());
		gbc_datePicker_8.gridx = 1;
		gbc_datePicker_8.gridy = 3;
		gbc_datePicker_8.insets = new Insets(0, 0, 15, 5);
		gbc_datePicker_8.anchor = GridBagConstraints.WEST;

		panel_abc_8.add(datePicker_8, gbc_datePicker_8);

		lblMKh = new JLabel("   Mã KH: ");
		panel_abc_8.add(lblMKh);

		tf_maKH_HD_8 = new JTextField();
		panel_abc_8.add(tf_maKH_HD_8);
		tf_maKH_HD_8.setColumns(5);

		panel_acc_8 = new JPanel();
		panel_acc_8.setBorder(new TitledBorder(new LineBorder(new Color(255,
				200, 0), 1, true),
				"Chi ti\u1EBFt c\u00E1c MH \u0111\u00E3 ch\u1ECDn: ",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, null));
		panel_theotungban_8.add(panel_acc_8, BorderLayout.CENTER);
		panel_acc_8.setLayout(new BorderLayout(0, 0));

		panel_addc_8 = new JPanel();
		panel_acc_8.add(panel_addc_8, BorderLayout.NORTH);
		panel_addc_8.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btn_tang_8 = new JButton(" Tăng");
		btn_tang_8.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/new.png")));
		panel_addc_8.add(btn_tang_8);

		btn_giam_8 = new JButton(" Giảm");
		btn_giam_8.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/giam.png")));
		panel_addc_8.add(btn_giam_8);

		btn_sl_macdinh_8 = new JButton("Đặt SL Mặc Định");
		btn_sl_macdinh_8.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/refresh.png")));
		panel_addc_8.add(btn_sl_macdinh_8);

		btn_ghichu_8 = new JButton("Ghi Chú");
		btn_ghichu_8.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/ghichunote.png")));
		panel_addc_8.add(btn_ghichu_8);

		panel_dbf_8 = new JPanel();
		panel_dbf_8.setBorder(new LineBorder(Color.ORANGE, 1, true));
		panel_acc_8.add(panel_dbf_8, BorderLayout.CENTER);
		panel_dbf_8.setLayout(new BorderLayout(0, 0));

		panel_zx_8 = new JPanel();
		panel_zx_8.setBorder(new TitledBorder(new LineBorder(new Color(255,
				200, 0), 1, true), "Ch\u1EE9c n\u0103ng: ",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_dbf_8.add(panel_zx_8, BorderLayout.SOUTH);
		panel_zx_8.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btn_thanhtoan_8 = new JButton("Thanh Toán");
		btn_thanhtoan_8.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/edit.png")));
		panel_zx_8.add(btn_thanhtoan_8);

		btn_capnhat_8 = new JButton("Cập Nhật");
		btn_capnhat_8.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/refresh.png")));
		panel_zx_8.add(btn_capnhat_8);
		panel_Show_HoaDon_Table_8 = new JPanel();
		panel_dbf_8.add(panel_Show_HoaDon_Table_8, BorderLayout.CENTER);
		table_8 = new JTable();

		columnames_8.add(" ID MH ");
		columnames_8.add(" Tên Mặt Hàng ");
		columnames_8.add(" Số Lượng ");
		columnames_8.add(" ĐVT ");
		columnames_8.add(" Giá ");
		columnames_8.add(" Thành Tiền ");

		// ++++++Set du lieu cho bang
		datamodel_8 = new DefaultTableModel(record_8, columnames_8);
		table_8.setModel(datamodel_8);

		// ++++++dieu chinh kich co cua bang
		table_8.setPreferredScrollableViewportSize(new Dimension(600, 250));
		table_8.setFillsViewportHeight(true);

		// ++++++them thanh cuon cho bang
		// ======================================================
		JScrollPane scroll_8 = new JScrollPane(table_8);
		// ======================================================

		scroll_8 = new JScrollPane(table_8,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		// Table.adjustColumnPreferredWidths(table);
		table_8.revalidate();
		panel_Show_HoaDon_Table_8.add(scroll_8);

		// End Panel Table Hoá Đơn ====================================
		// Bàn_8:======================================================
		// Bàn_9:======================
		panel_theotungban_9 = new JPanel();
		panel_theotungban_9.setBorder(new TitledBorder(new LineBorder(
				new Color(255, 200, 0), 1, true),
				"Th\u00F4ng tin ho\u00E1 \u0111\u01A1n: ",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		// SplitPanel_Right.add(panel_theotungban_9, BorderLayout.CENTER);
		panel_theotungban_9.setLayout(new BorderLayout(0, 0));

		panel_abc_9 = new JPanel();
		panel_theotungban_9.add(panel_abc_9, BorderLayout.NORTH);
		panel_abc_9.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		lblSBn = new JLabel("  Số bàn:  ");
		panel_abc_9.add(lblSBn);

		tf_soban_9 = new JTextField();
		panel_abc_9.add(tf_soban_9);
		tf_soban_9.setColumns(10);
		tf_soban_9.setText(" Bàn 9 ");

		lblNgyNhp = new JLabel("     Ngày nhập: ");
		panel_abc_9.add(lblNgyNhp);
		// =============================================================
		GridBagConstraints gbc_datePicker_9 = new GridBagConstraints();
		// =============================================================
		model = new UtilDateModel();
		datePanel = new JDatePanelImpl(model);
		datePicker_9 = new JDatePickerImpl(datePanel);
		datePicker_9.getJFormattedTextField().setToolTipText("Click chọn ngày");
		datePicker_9.getJFormattedTextField().setText(ChecNgay.now1());
		gbc_datePicker_9.gridx = 1;
		gbc_datePicker_9.gridy = 3;
		gbc_datePicker_9.insets = new Insets(0, 0, 15, 5);
		gbc_datePicker_9.anchor = GridBagConstraints.WEST;

		panel_abc_9.add(datePicker_9, gbc_datePicker_9);

		lblMKh = new JLabel("   Mã KH: ");
		panel_abc_9.add(lblMKh);

		tf_maKH_HD_9 = new JTextField();
		panel_abc_9.add(tf_maKH_HD_9);
		tf_maKH_HD_9.setColumns(5);

		panel_acc_9 = new JPanel();
		panel_acc_9.setBorder(new TitledBorder(new LineBorder(new Color(255,
				200, 0), 1, true),
				"Chi ti\u1EBFt c\u00E1c MH \u0111\u00E3 ch\u1ECDn: ",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, null));
		panel_theotungban_9.add(panel_acc_9, BorderLayout.CENTER);
		panel_acc_9.setLayout(new BorderLayout(0, 0));

		panel_addc_9 = new JPanel();
		panel_acc_9.add(panel_addc_9, BorderLayout.NORTH);
		panel_addc_9.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btn_tang_9 = new JButton(" Tăng");
		btn_tang_9.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/new.png")));
		panel_addc_9.add(btn_tang_9);

		btn_giam_9 = new JButton(" Giảm");
		btn_giam_9.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/giam.png")));
		panel_addc_9.add(btn_giam_9);

		btn_sl_macdinh_9 = new JButton("Đặt SL Mặc Định");
		btn_sl_macdinh_9.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/refresh.png")));
		panel_addc_9.add(btn_sl_macdinh_9);

		btn_ghichu_9 = new JButton("Ghi Chú");
		btn_ghichu_9.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/ghichunote.png")));
		panel_addc_9.add(btn_ghichu_9);

		panel_dbf_9 = new JPanel();
		panel_dbf_9.setBorder(new LineBorder(Color.ORANGE, 1, true));
		panel_acc_9.add(panel_dbf_9, BorderLayout.CENTER);
		panel_dbf_9.setLayout(new BorderLayout(0, 0));

		panel_zx_9 = new JPanel();
		panel_zx_9.setBorder(new TitledBorder(new LineBorder(new Color(255,
				200, 0), 1, true), "Ch\u1EE9c n\u0103ng: ",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_dbf_9.add(panel_zx_9, BorderLayout.SOUTH);
		panel_zx_9.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btn_thanhtoan_9 = new JButton("Thanh Toán");
		btn_thanhtoan_9.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/edit.png")));
		panel_zx_9.add(btn_thanhtoan_9);

		btn_capnhat_9 = new JButton("Cập Nhật");
		btn_capnhat_9.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/refresh.png")));
		panel_zx_9.add(btn_capnhat_9);
		panel_Show_HoaDon_Table_9 = new JPanel();
		panel_dbf_9.add(panel_Show_HoaDon_Table_9, BorderLayout.CENTER);
		table_9 = new JTable();

		columnames_9.add(" ID MH ");
		columnames_9.add(" Tên Mặt Hàng ");
		columnames_9.add(" Số Lượng ");
		columnames_9.add(" ĐVT ");
		columnames_9.add(" Giá ");
		columnames_9.add(" Thành Tiền ");

		// ++++++Set du lieu cho bang
		datamodel_9 = new DefaultTableModel(record_9, columnames_9);
		table_9.setModel(datamodel_9);

		// ++++++dieu chinh kich co cua bang
		table_9.setPreferredScrollableViewportSize(new Dimension(600, 250));
		table_9.setFillsViewportHeight(true);

		// ++++++them thanh cuon cho bang
		// ======================================================
		JScrollPane scroll_9 = new JScrollPane(table_9);
		// ======================================================

		scroll_9 = new JScrollPane(table_9,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		// Table.adjustColumnPreferredWidths(table);
		table_9.revalidate();
		panel_Show_HoaDon_Table_9.add(scroll_9);

		// End Panel Table Hoá Đơn ====================================
		// Bàn_9:======================================================
		// Bàn_10:======================
		panel_theotungban_10 = new JPanel();
		panel_theotungban_10.setBorder(new TitledBorder(new LineBorder(
				new Color(255, 200, 0), 1, true),
				"Th\u00F4ng tin ho\u00E1 \u0111\u01A1n: ",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		// SplitPanel_Right.add(panel_theotungban_10, BorderLayout.CENTER);
		panel_theotungban_10.setLayout(new BorderLayout(0, 0));

		panel_abc_10 = new JPanel();
		panel_theotungban_10.add(panel_abc_10, BorderLayout.NORTH);
		panel_abc_10.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		lblSBn = new JLabel("  Số bàn:  ");
		panel_abc_10.add(lblSBn);

		tf_soban_10 = new JTextField();
		panel_abc_10.add(tf_soban_10);
		tf_soban_10.setColumns(10);
		tf_soban_10.setText(" Bàn 10 ");

		lblNgyNhp = new JLabel("     Ngày nhập: ");
		panel_abc_10.add(lblNgyNhp);
		// =============================================================
		GridBagConstraints gbc_datePicker_10 = new GridBagConstraints();
		// =============================================================
		model = new UtilDateModel();
		datePanel = new JDatePanelImpl(model);
		datePicker_10 = new JDatePickerImpl(datePanel);
		datePicker_10.getJFormattedTextField()
				.setToolTipText("Click chọn ngày");
		datePicker_10.getJFormattedTextField().setText(ChecNgay.now1());
		gbc_datePicker_10.gridx = 1;
		gbc_datePicker_10.gridy = 3;
		gbc_datePicker_10.insets = new Insets(0, 0, 15, 5);
		gbc_datePicker_10.anchor = GridBagConstraints.WEST;

		panel_abc_10.add(datePicker_10, gbc_datePicker_10);

		lblMKh = new JLabel("   Mã KH: ");
		panel_abc_10.add(lblMKh);

		tf_maKH_HD_10 = new JTextField();
		panel_abc_10.add(tf_maKH_HD_10);
		tf_maKH_HD_10.setColumns(5);

		panel_acc_10 = new JPanel();
		panel_acc_10.setBorder(new TitledBorder(new LineBorder(new Color(255,
				200, 0), 1, true),
				"Chi ti\u1EBFt c\u00E1c MH \u0111\u00E3 ch\u1ECDn: ",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, null));
		panel_theotungban_10.add(panel_acc_10, BorderLayout.CENTER);
		panel_acc_10.setLayout(new BorderLayout(0, 0));

		panel_addc_10 = new JPanel();
		panel_acc_10.add(panel_addc_10, BorderLayout.NORTH);
		panel_addc_10.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btn_tang_10 = new JButton(" Tăng");
		btn_tang_10.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/new.png")));
		panel_addc_10.add(btn_tang_10);

		btn_giam_10 = new JButton(" Giảm");
		btn_giam_10.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/giam.png")));
		panel_addc_10.add(btn_giam_10);

		btn_sl_macdinh_10 = new JButton("Đặt SL Mặc Định");
		btn_sl_macdinh_10.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/refresh.png")));
		panel_addc_10.add(btn_sl_macdinh_10);

		btn_ghichu_10 = new JButton("Ghi Chú");
		btn_ghichu_10.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/ghichunote.png")));
		panel_addc_10.add(btn_ghichu_10);

		panel_dbf_10 = new JPanel();
		panel_dbf_10.setBorder(new LineBorder(Color.ORANGE, 1, true));
		panel_acc_10.add(panel_dbf_10, BorderLayout.CENTER);
		panel_dbf_10.setLayout(new BorderLayout(0, 0));

		panel_zx_10 = new JPanel();
		panel_zx_10.setBorder(new TitledBorder(new LineBorder(new Color(255,
				200, 0), 1, true), "Ch\u1EE9c n\u0103ng: ",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_dbf_10.add(panel_zx_10, BorderLayout.SOUTH);
		panel_zx_10.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btn_thanhtoan_10 = new JButton("Thanh Toán");
		btn_thanhtoan_10.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/edit.png")));
		panel_zx_10.add(btn_thanhtoan_10);

		btn_capnhat_10 = new JButton("Cập Nhật");
		btn_capnhat_10.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/refresh.png")));
		panel_zx_10.add(btn_capnhat_10);
		panel_Show_HoaDon_Table_10 = new JPanel();
		panel_dbf_10.add(panel_Show_HoaDon_Table_10, BorderLayout.CENTER);
		table_10 = new JTable();

		columnames_10.add(" ID MH ");
		columnames_10.add(" Tên Mặt Hàng ");
		columnames_10.add(" Số Lượng ");
		columnames_10.add(" ĐVT ");
		columnames_10.add(" Giá ");
		columnames_10.add(" Thành Tiền ");

		// ++++++Set du lieu cho bang
		datamodel_10 = new DefaultTableModel(record_10, columnames_10);
		table_10.setModel(datamodel_10);

		// ++++++dieu chinh kich co cua bang
		table_10.setPreferredScrollableViewportSize(new Dimension(600, 250));
		table_10.setFillsViewportHeight(true);

		// ++++++them thanh cuon cho bang
		// ======================================================
		JScrollPane scroll_10 = new JScrollPane(table_10);
		// ======================================================

		scroll_10 = new JScrollPane(table_10,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		// Table.adjustColumnPreferredWidths(table);
		table_10.revalidate();
		panel_Show_HoaDon_Table_10.add(scroll_10);

		// End Panel Table Hoá Đơn ====================================
		// Bàn_10:======================================================
		// Bàn_11:======================
		panel_theotungban_11 = new JPanel();
		panel_theotungban_11.setBorder(new TitledBorder(new LineBorder(
				new Color(255, 200, 0), 1, true),
				"Th\u00F4ng tin ho\u00E1 \u0111\u01A1n: ",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		// SplitPanel_Right.add(panel_theotungban_11, BorderLayout.CENTER);
		panel_theotungban_11.setLayout(new BorderLayout(0, 0));

		panel_abc_11 = new JPanel();
		panel_theotungban_11.add(panel_abc_11, BorderLayout.NORTH);
		panel_abc_11.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		lblSBn = new JLabel("  Số bàn:  ");
		panel_abc_11.add(lblSBn);

		tf_soban_11 = new JTextField();
		panel_abc_11.add(tf_soban_11);
		tf_soban_11.setColumns(10);
		tf_soban_11.setText(" Bàn 11 ");

		lblNgyNhp = new JLabel("     Ngày nhập: ");
		panel_abc_11.add(lblNgyNhp);
		// =============================================================
		GridBagConstraints gbc_datePicker_11 = new GridBagConstraints();
		// =============================================================
		model = new UtilDateModel();
		datePanel = new JDatePanelImpl(model);
		datePicker_11 = new JDatePickerImpl(datePanel);
		datePicker_11.getJFormattedTextField()
				.setToolTipText("Click chọn ngày");
		datePicker_11.getJFormattedTextField().setText(ChecNgay.now1());
		gbc_datePicker_11.gridx = 1;
		gbc_datePicker_11.gridy = 3;
		gbc_datePicker_11.insets = new Insets(0, 0, 15, 5);
		gbc_datePicker_11.anchor = GridBagConstraints.WEST;

		panel_abc_11.add(datePicker_11, gbc_datePicker_11);

		lblMKh = new JLabel("   Mã KH: ");
		panel_abc_11.add(lblMKh);

		tf_maKH_HD_11 = new JTextField();
		panel_abc_11.add(tf_maKH_HD_11);
		tf_maKH_HD_11.setColumns(5);

		panel_acc_11 = new JPanel();
		panel_acc_11.setBorder(new TitledBorder(new LineBorder(new Color(255,
				200, 0), 1, true),
				"Chi ti\u1EBFt c\u00E1c MH \u0111\u00E3 ch\u1ECDn: ",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, null));
		panel_theotungban_11.add(panel_acc_11, BorderLayout.CENTER);
		panel_acc_11.setLayout(new BorderLayout(0, 0));

		panel_addc_11 = new JPanel();
		panel_acc_11.add(panel_addc_11, BorderLayout.NORTH);
		panel_addc_11.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btn_tang_11 = new JButton(" Tăng");
		btn_tang_11.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/new.png")));
		panel_addc_11.add(btn_tang_11);

		btn_giam_11 = new JButton(" Giảm");
		btn_giam_11.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/giam.png")));
		panel_addc_11.add(btn_giam_11);

		btn_sl_macdinh_11 = new JButton("Đặt SL Mặc Định");
		btn_sl_macdinh_11.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/refresh.png")));
		panel_addc_11.add(btn_sl_macdinh_11);

		btn_ghichu_11 = new JButton("Ghi Chú");
		btn_ghichu_11.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/ghichunote.png")));
		panel_addc_11.add(btn_ghichu_11);

		panel_dbf_11 = new JPanel();
		panel_dbf_11.setBorder(new LineBorder(Color.ORANGE, 1, true));
		panel_acc_11.add(panel_dbf_11, BorderLayout.CENTER);
		panel_dbf_11.setLayout(new BorderLayout(0, 0));

		panel_zx_11 = new JPanel();
		panel_zx_11.setBorder(new TitledBorder(new LineBorder(new Color(255,
				200, 0), 1, true), "Ch\u1EE9c n\u0103ng: ",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_dbf_11.add(panel_zx_11, BorderLayout.SOUTH);
		panel_zx_11.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btn_thanhtoan_11 = new JButton("Thanh Toán");
		btn_thanhtoan_11.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/edit.png")));
		panel_zx_11.add(btn_thanhtoan_11);

		btn_capnhat_11 = new JButton("Cập Nhật");
		btn_capnhat_11.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/refresh.png")));
		panel_zx_11.add(btn_capnhat_11);
		panel_Show_HoaDon_Table_11 = new JPanel();
		panel_dbf_11.add(panel_Show_HoaDon_Table_11, BorderLayout.CENTER);
		table_11 = new JTable();

		columnames_11.add(" ID MH ");
		columnames_11.add(" Tên Mặt Hàng ");
		columnames_11.add(" Số Lượng ");
		columnames_11.add(" ĐVT ");
		columnames_11.add(" Giá ");
		columnames_11.add(" Thành Tiền ");

		// ++++++Set du lieu cho bang
		datamodel_11 = new DefaultTableModel(record_11, columnames_11);
		table_11.setModel(datamodel_11);

		// ++++++dieu chinh kich co cua bang
		table_11.setPreferredScrollableViewportSize(new Dimension(600, 250));
		table_11.setFillsViewportHeight(true);

		// ++++++them thanh cuon cho bang
		// ======================================================
		JScrollPane scroll_11 = new JScrollPane(table_11);
		// ======================================================

		scroll_11 = new JScrollPane(table_11,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		// Table.adjustColumnPreferredWidths(table);
		table_11.revalidate();
		panel_Show_HoaDon_Table_11.add(scroll_11);

		// End Panel Table Hoá Đơn ====================================
		// Bàn_11:======================================================
		// Bàn_12:======================
		panel_theotungban_12 = new JPanel();
		panel_theotungban_12.setBorder(new TitledBorder(new LineBorder(
				new Color(255, 200, 0), 1, true),
				"Th\u00F4ng tin ho\u00E1 \u0111\u01A1n: ",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		// SplitPanel_Right.add(panel_theotungban_12, BorderLayout.CENTER);
		panel_theotungban_12.setLayout(new BorderLayout(0, 0));

		panel_abc_12 = new JPanel();
		panel_theotungban_12.add(panel_abc_12, BorderLayout.NORTH);
		panel_abc_12.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		lblSBn = new JLabel("  Số bàn:  ");
		panel_abc_12.add(lblSBn);

		tf_soban_12 = new JTextField();
		panel_abc_12.add(tf_soban_12);
		tf_soban_12.setColumns(10);
		tf_soban_12.setText(" Bàn 12 ");

		lblNgyNhp = new JLabel("     Ngày nhập: ");
		panel_abc_12.add(lblNgyNhp);
		// =============================================================
		GridBagConstraints gbc_datePicker_12 = new GridBagConstraints();
		// =============================================================
		model = new UtilDateModel();
		datePanel = new JDatePanelImpl(model);
		datePicker_12 = new JDatePickerImpl(datePanel);
		datePicker_12.getJFormattedTextField()
				.setToolTipText("Click chọn ngày");
		datePicker_12.getJFormattedTextField().setText(ChecNgay.now1());
		gbc_datePicker_12.gridx = 1;
		gbc_datePicker_12.gridy = 3;
		gbc_datePicker_12.insets = new Insets(0, 0, 15, 5);
		gbc_datePicker_12.anchor = GridBagConstraints.WEST;

		panel_abc_12.add(datePicker_12, gbc_datePicker_12);

		lblMKh = new JLabel("   Mã KH: ");
		panel_abc_12.add(lblMKh);

		tf_maKH_HD_12 = new JTextField();
		panel_abc_12.add(tf_maKH_HD_12);
		tf_maKH_HD_12.setColumns(5);

		panel_acc_12 = new JPanel();
		panel_acc_12.setBorder(new TitledBorder(new LineBorder(new Color(255,
				200, 0), 1, true),
				"Chi ti\u1EBFt c\u00E1c MH \u0111\u00E3 ch\u1ECDn: ",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, null));
		panel_theotungban_12.add(panel_acc_12, BorderLayout.CENTER);
		panel_acc_12.setLayout(new BorderLayout(0, 0));

		panel_addc_12 = new JPanel();
		panel_acc_12.add(panel_addc_12, BorderLayout.NORTH);
		panel_addc_12.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btn_tang_12 = new JButton(" Tăng");
		btn_tang_12.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/new.png")));
		panel_addc_12.add(btn_tang_12);

		btn_giam_12 = new JButton(" Giảm");
		btn_giam_12.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/giam.png")));
		panel_addc_12.add(btn_giam_12);

		btn_sl_macdinh_12 = new JButton("Đặt SL Mặc Định");
		btn_sl_macdinh_12.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/refresh.png")));
		panel_addc_12.add(btn_sl_macdinh_12);

		btn_ghichu_12 = new JButton("Ghi Chú");
		btn_ghichu_12.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/ghichunote.png")));
		panel_addc_12.add(btn_ghichu_12);

		panel_dbf_12 = new JPanel();
		panel_dbf_12.setBorder(new LineBorder(Color.ORANGE, 1, true));
		panel_acc_12.add(panel_dbf_12, BorderLayout.CENTER);
		panel_dbf_12.setLayout(new BorderLayout(0, 0));

		panel_zx_12 = new JPanel();
		panel_zx_12.setBorder(new TitledBorder(new LineBorder(new Color(255,
				200, 0), 1, true), "Ch\u1EE9c n\u0103ng: ",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_dbf_12.add(panel_zx_12, BorderLayout.SOUTH);
		panel_zx_12.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btn_thanhtoan_12 = new JButton("Thanh Toán");
		btn_thanhtoan_12.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/edit.png")));
		panel_zx_12.add(btn_thanhtoan_12);

		btn_capnhat_12 = new JButton("Cập Nhật");
		btn_capnhat_12.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/refresh.png")));
		panel_zx_12.add(btn_capnhat_12);
		panel_Show_HoaDon_Table_12 = new JPanel();
		panel_dbf_12.add(panel_Show_HoaDon_Table_12, BorderLayout.CENTER);
		table_12 = new JTable();

		columnames_12.add(" ID MH ");
		columnames_12.add(" Tên Mặt Hàng ");
		columnames_12.add(" Số Lượng ");
		columnames_12.add(" ĐVT ");
		columnames_12.add(" Giá ");
		columnames_12.add(" Thành Tiền ");

		// ++++++Set du lieu cho bang
		datamodel_12 = new DefaultTableModel(record_12, columnames_12);
		table_12.setModel(datamodel_12);

		// ++++++dieu chinh kich co cua bang
		table_12.setPreferredScrollableViewportSize(new Dimension(600, 250));
		table_12.setFillsViewportHeight(true);

		// ++++++them thanh cuon cho bang
		// ======================================================
		JScrollPane scroll_12 = new JScrollPane(table_12);
		// ======================================================

		scroll_12 = new JScrollPane(table_12,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		// Table.adjustColumnPreferredWidths(table);
		table_12.revalidate();
		panel_Show_HoaDon_Table_12.add(scroll_12);

		// End Panel Table Hoá Đơn ====================================
		// Bàn_12:======================================================
		// Bàn_13:======================
		panel_theotungban_13 = new JPanel();
		panel_theotungban_13.setBorder(new TitledBorder(new LineBorder(
				new Color(255, 200, 0), 1, true),
				"Th\u00F4ng tin ho\u00E1 \u0111\u01A1n: ",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		// SplitPanel_Right.add(panel_theotungban_13, BorderLayout.CENTER);
		panel_theotungban_13.setLayout(new BorderLayout(0, 0));

		panel_abc_13 = new JPanel();
		panel_theotungban_13.add(panel_abc_13, BorderLayout.NORTH);
		panel_abc_13.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		lblSBn = new JLabel("  Số bàn:  ");
		panel_abc_13.add(lblSBn);

		tf_soban_13 = new JTextField();
		panel_abc_13.add(tf_soban_13);
		tf_soban_13.setColumns(10);
		tf_soban_13.setText(" Bàn 13 ");

		lblNgyNhp = new JLabel("     Ngày nhập: ");
		panel_abc_13.add(lblNgyNhp);
		// =============================================================
		GridBagConstraints gbc_datePicker_13 = new GridBagConstraints();
		// =============================================================
		model = new UtilDateModel();
		datePanel = new JDatePanelImpl(model);
		datePicker_13 = new JDatePickerImpl(datePanel);
		datePicker_13.getJFormattedTextField()
				.setToolTipText("Click chọn ngày");
		datePicker_13.getJFormattedTextField().setText(ChecNgay.now1());
		gbc_datePicker_13.gridx = 1;
		gbc_datePicker_13.gridy = 3;
		gbc_datePicker_13.insets = new Insets(0, 0, 15, 5);
		gbc_datePicker_13.anchor = GridBagConstraints.WEST;

		panel_abc_13.add(datePicker_13, gbc_datePicker_13);

		lblMKh = new JLabel("   Mã KH: ");
		panel_abc_13.add(lblMKh);

		tf_maKH_HD_13 = new JTextField();
		panel_abc_13.add(tf_maKH_HD_13);
		tf_maKH_HD_13.setColumns(5);

		panel_acc_13 = new JPanel();
		panel_acc_13.setBorder(new TitledBorder(new LineBorder(new Color(255,
				200, 0), 1, true),
				"Chi ti\u1EBFt c\u00E1c MH \u0111\u00E3 ch\u1ECDn: ",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, null));
		panel_theotungban_13.add(panel_acc_13, BorderLayout.CENTER);
		panel_acc_13.setLayout(new BorderLayout(0, 0));

		panel_addc_13 = new JPanel();
		panel_acc_13.add(panel_addc_13, BorderLayout.NORTH);
		panel_addc_13.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btn_tang_13 = new JButton(" Tăng");
		btn_tang_13.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/new.png")));
		panel_addc_13.add(btn_tang_13);

		btn_giam_13 = new JButton(" Giảm");
		btn_giam_13.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/giam.png")));
		panel_addc_13.add(btn_giam_13);

		btn_sl_macdinh_13 = new JButton("Đặt SL Mặc Định");
		btn_sl_macdinh_13.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/refresh.png")));
		panel_addc_13.add(btn_sl_macdinh_13);

		btn_ghichu_13 = new JButton("Ghi Chú");
		btn_ghichu_13.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/ghichunote.png")));
		panel_addc_13.add(btn_ghichu_13);

		panel_dbf_13 = new JPanel();
		panel_dbf_13.setBorder(new LineBorder(Color.ORANGE, 1, true));
		panel_acc_13.add(panel_dbf_13, BorderLayout.CENTER);
		panel_dbf_13.setLayout(new BorderLayout(0, 0));

		panel_zx_13 = new JPanel();
		panel_zx_13.setBorder(new TitledBorder(new LineBorder(new Color(255,
				200, 0), 1, true), "Ch\u1EE9c n\u0103ng: ",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_dbf_13.add(panel_zx_13, BorderLayout.SOUTH);
		panel_zx_13.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btn_thanhtoan_13 = new JButton("Thanh Toán");
		btn_thanhtoan_13.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/edit.png")));
		panel_zx_13.add(btn_thanhtoan_13);

		btn_capnhat_13 = new JButton("Cập Nhật");
		btn_capnhat_13.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/refresh.png")));
		panel_zx_13.add(btn_capnhat_13);
		panel_Show_HoaDon_Table_13 = new JPanel();
		panel_dbf_13.add(panel_Show_HoaDon_Table_13, BorderLayout.CENTER);
		table_13 = new JTable();

		columnames_13.add(" ID MH ");
		columnames_13.add(" Tên Mặt Hàng ");
		columnames_13.add(" Số Lượng ");
		columnames_13.add(" ĐVT ");
		columnames_13.add(" Giá ");
		columnames_13.add(" Thành Tiền ");

		// ++++++Set du lieu cho bang
		datamodel_13 = new DefaultTableModel(record_13, columnames_13);
		table_13.setModel(datamodel_13);

		// ++++++dieu chinh kich co cua bang
		table_13.setPreferredScrollableViewportSize(new Dimension(600, 250));
		table_13.setFillsViewportHeight(true);

		// ++++++them thanh cuon cho bang
		// ======================================================
		JScrollPane scroll_13 = new JScrollPane(table_13);
		// ======================================================

		scroll_13 = new JScrollPane(table_13,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		// Table.adjustColumnPreferredWidths(table);
		table_13.revalidate();
		panel_Show_HoaDon_Table_13.add(scroll_13);

		// End Panel Table Hoá Đơn ====================================
		// Bàn_13:======================================================
		// Bàn_14:======================
		panel_theotungban_14 = new JPanel();
		panel_theotungban_14.setBorder(new TitledBorder(new LineBorder(
				new Color(255, 200, 0), 1, true),
				"Th\u00F4ng tin ho\u00E1 \u0111\u01A1n: ",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		// SplitPanel_Right.add(panel_theotungban_14, BorderLayout.CENTER);
		panel_theotungban_14.setLayout(new BorderLayout(0, 0));

		panel_abc_14 = new JPanel();
		panel_theotungban_14.add(panel_abc_14, BorderLayout.NORTH);
		panel_abc_14.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		lblSBn = new JLabel("  Số bàn:  ");
		panel_abc_14.add(lblSBn);

		tf_soban_14 = new JTextField();
		panel_abc_14.add(tf_soban_14);
		tf_soban_14.setColumns(10);
		tf_soban_14.setText(" Bàn 14 ");

		lblNgyNhp = new JLabel("     Ngày nhập: ");
		panel_abc_14.add(lblNgyNhp);
		// =============================================================
		GridBagConstraints gbc_datePicker_14 = new GridBagConstraints();
		// =============================================================
		model = new UtilDateModel();
		datePanel = new JDatePanelImpl(model);
		datePicker_14 = new JDatePickerImpl(datePanel);
		datePicker_14.getJFormattedTextField()
				.setToolTipText("Click chọn ngày");
		datePicker_14.getJFormattedTextField().setText(ChecNgay.now1());
		gbc_datePicker_14.gridx = 1;
		gbc_datePicker_14.gridy = 3;
		gbc_datePicker_14.insets = new Insets(0, 0, 15, 5);
		gbc_datePicker_14.anchor = GridBagConstraints.WEST;

		panel_abc_14.add(datePicker_14, gbc_datePicker_14);

		lblMKh = new JLabel("   Mã KH: ");
		panel_abc_14.add(lblMKh);

		tf_maKH_HD_14 = new JTextField();
		panel_abc_14.add(tf_maKH_HD_14);
		tf_maKH_HD_14.setColumns(5);

		panel_acc_14 = new JPanel();
		panel_acc_14.setBorder(new TitledBorder(new LineBorder(new Color(255,
				200, 0), 1, true),
				"Chi ti\u1EBFt c\u00E1c MH \u0111\u00E3 ch\u1ECDn: ",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, null));
		panel_theotungban_14.add(panel_acc_14, BorderLayout.CENTER);
		panel_acc_14.setLayout(new BorderLayout(0, 0));

		panel_addc_14 = new JPanel();
		panel_acc_14.add(panel_addc_14, BorderLayout.NORTH);
		panel_addc_14.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btn_tang_14 = new JButton(" Tăng");
		btn_tang_14.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/new.png")));
		panel_addc_14.add(btn_tang_14);

		btn_giam_14 = new JButton(" Giảm");
		btn_giam_14.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/giam.png")));
		panel_addc_14.add(btn_giam_14);

		btn_sl_macdinh_14 = new JButton("Đặt SL Mặc Định");
		btn_sl_macdinh_14.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/refresh.png")));
		panel_addc_14.add(btn_sl_macdinh_14);

		btn_ghichu_14 = new JButton("Ghi Chú");
		btn_ghichu_14.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/ghichunote.png")));
		panel_addc_14.add(btn_ghichu_14);

		panel_dbf_14 = new JPanel();
		panel_dbf_14.setBorder(new LineBorder(Color.ORANGE, 1, true));
		panel_acc_14.add(panel_dbf_14, BorderLayout.CENTER);
		panel_dbf_14.setLayout(new BorderLayout(0, 0));

		panel_zx_14 = new JPanel();
		panel_zx_14.setBorder(new TitledBorder(new LineBorder(new Color(255,
				200, 0), 1, true), "Ch\u1EE9c n\u0103ng: ",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_dbf_14.add(panel_zx_14, BorderLayout.SOUTH);
		panel_zx_14.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btn_thanhtoan_14 = new JButton("Thanh Toán");
		btn_thanhtoan_14.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/edit.png")));
		panel_zx_14.add(btn_thanhtoan_14);

		btn_capnhat_14 = new JButton("Cập Nhật");
		btn_capnhat_14.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/refresh.png")));
		panel_zx_14.add(btn_capnhat_14);
		panel_Show_HoaDon_Table_14 = new JPanel();
		panel_dbf_14.add(panel_Show_HoaDon_Table_14, BorderLayout.CENTER);
		table_14 = new JTable();

		columnames_14.add(" ID MH ");
		columnames_14.add(" Tên Mặt Hàng ");
		columnames_14.add(" Số Lượng ");
		columnames_14.add(" ĐVT ");
		columnames_14.add(" Giá ");
		columnames_14.add(" Thành Tiền ");

		// ++++++Set du lieu cho bang
		datamodel_14 = new DefaultTableModel(record_14, columnames_14);
		table_14.setModel(datamodel_14);

		// ++++++dieu chinh kich co cua bang
		table_14.setPreferredScrollableViewportSize(new Dimension(600, 250));
		table_14.setFillsViewportHeight(true);

		// ++++++them thanh cuon cho bang
		// ======================================================
		JScrollPane scroll_14 = new JScrollPane(table_14);
		// ======================================================

		scroll_14 = new JScrollPane(table_14,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		// Table.adjustColumnPreferredWidths(table);
		table_14.revalidate();
		panel_Show_HoaDon_Table_14.add(scroll_14);

		// End Panel Table Hoá Đơn ====================================
		// Bàn_14:======================================================
		// Bàn_15:======================
		panel_theotungban_15 = new JPanel();
		panel_theotungban_15.setBorder(new TitledBorder(new LineBorder(
				new Color(255, 200, 0), 1, true),
				"Th\u00F4ng tin ho\u00E1 \u0111\u01A1n: ",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		// SplitPanel_Right.add(panel_theotungban_15, BorderLayout.CENTER);
		panel_theotungban_15.setLayout(new BorderLayout(0, 0));

		panel_abc_15 = new JPanel();
		panel_theotungban_15.add(panel_abc_15, BorderLayout.NORTH);
		panel_abc_15.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		lblSBn = new JLabel("  Số bàn:  ");
		panel_abc_15.add(lblSBn);

		tf_soban_15 = new JTextField();
		panel_abc_15.add(tf_soban_15);
		tf_soban_15.setColumns(10);
		tf_soban_15.setText(" Bàn 15 ");

		lblNgyNhp = new JLabel("     Ngày nhập: ");
		panel_abc_15.add(lblNgyNhp);
		// =============================================================
		GridBagConstraints gbc_datePicker_15 = new GridBagConstraints();
		// =============================================================
		model = new UtilDateModel();
		datePanel = new JDatePanelImpl(model);
		datePicker_15 = new JDatePickerImpl(datePanel);
		datePicker_15.getJFormattedTextField()
				.setToolTipText("Click chọn ngày");
		datePicker_15.getJFormattedTextField().setText(ChecNgay.now1());
		gbc_datePicker_15.gridx = 1;
		gbc_datePicker_15.gridy = 3;
		gbc_datePicker_15.insets = new Insets(0, 0, 15, 5);
		gbc_datePicker_15.anchor = GridBagConstraints.WEST;

		panel_abc_15.add(datePicker_15, gbc_datePicker_15);

		lblMKh = new JLabel("   Mã KH: ");
		panel_abc_15.add(lblMKh);

		tf_maKH_HD_15 = new JTextField();
		panel_abc_15.add(tf_maKH_HD_15);
		tf_maKH_HD_15.setColumns(5);

		panel_acc_15 = new JPanel();
		panel_acc_15.setBorder(new TitledBorder(new LineBorder(new Color(255,
				200, 0), 1, true),
				"Chi ti\u1EBFt c\u00E1c MH \u0111\u00E3 ch\u1ECDn: ",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, null));
		panel_theotungban_15.add(panel_acc_15, BorderLayout.CENTER);
		panel_acc_15.setLayout(new BorderLayout(0, 0));

		panel_addc_15 = new JPanel();
		panel_acc_15.add(panel_addc_15, BorderLayout.NORTH);
		panel_addc_15.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btn_tang_15 = new JButton(" Tăng");
		btn_tang_15.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/new.png")));
		panel_addc_15.add(btn_tang_15);

		btn_giam_15 = new JButton(" Giảm");
		btn_giam_15.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/giam.png")));
		panel_addc_15.add(btn_giam_15);

		btn_sl_macdinh_15 = new JButton("Đặt SL Mặc Định");
		btn_sl_macdinh_15.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/refresh.png")));
		panel_addc_15.add(btn_sl_macdinh_15);

		btn_ghichu_15 = new JButton("Ghi Chú");
		btn_ghichu_15.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/ghichunote.png")));
		panel_addc_15.add(btn_ghichu_15);

		panel_dbf_15 = new JPanel();
		panel_dbf_15.setBorder(new LineBorder(Color.ORANGE, 1, true));
		panel_acc_15.add(panel_dbf_15, BorderLayout.CENTER);
		panel_dbf_15.setLayout(new BorderLayout(0, 0));

		panel_zx_15 = new JPanel();
		panel_zx_15.setBorder(new TitledBorder(new LineBorder(new Color(255,
				200, 0), 1, true), "Ch\u1EE9c n\u0103ng: ",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_dbf_15.add(panel_zx_15, BorderLayout.SOUTH);
		panel_zx_15.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btn_thanhtoan_15 = new JButton("Thanh Toán");
		btn_thanhtoan_15.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/edit.png")));
		panel_zx_15.add(btn_thanhtoan_15);

		btn_capnhat_15 = new JButton("Cập Nhật");
		btn_capnhat_15.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/refresh.png")));
		panel_zx_15.add(btn_capnhat_15);
		panel_Show_HoaDon_Table_15 = new JPanel();
		panel_dbf_15.add(panel_Show_HoaDon_Table_15, BorderLayout.CENTER);
		table_15 = new JTable();

		columnames_15.add(" ID MH ");
		columnames_15.add(" Tên Mặt Hàng ");
		columnames_15.add(" Số Lượng ");
		columnames_15.add(" ĐVT ");
		columnames_15.add(" Giá ");
		columnames_15.add(" Thành Tiền ");

		// ++++++Set du lieu cho bang
		datamodel_15 = new DefaultTableModel(record_15, columnames_15);
		table_15.setModel(datamodel_15);

		// ++++++dieu chinh kich co cua bang
		table_15.setPreferredScrollableViewportSize(new Dimension(600, 250));
		table_15.setFillsViewportHeight(true);

		// ++++++them thanh cuon cho bang
		// ======================================================
		JScrollPane scroll_15 = new JScrollPane(table_15);
		// ======================================================

		scroll_15 = new JScrollPane(table_15,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		// Table.adjustColumnPreferredWidths(table);
		table_15.revalidate();
		panel_Show_HoaDon_Table_15.add(scroll_15);

		// End Panel Table Hoá Đơn ====================================
		// Bàn_15:======================================================
		// Bàn_16:======================
		panel_theotungban_16 = new JPanel();
		panel_theotungban_16.setBorder(new TitledBorder(new LineBorder(
				new Color(255, 200, 0), 1, true),
				"Th\u00F4ng tin ho\u00E1 \u0111\u01A1n: ",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		// SplitPanel_Right.add(panel_theotungban_16, BorderLayout.CENTER);
		panel_theotungban_16.setLayout(new BorderLayout(0, 0));

		panel_abc_16 = new JPanel();
		panel_theotungban_16.add(panel_abc_16, BorderLayout.NORTH);
		panel_abc_16.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		lblSBn = new JLabel("  Số bàn:  ");
		panel_abc_16.add(lblSBn);

		tf_soban_16 = new JTextField();
		panel_abc_16.add(tf_soban_16);
		tf_soban_16.setColumns(10);
		tf_soban_16.setText(" Bàn 16 ");
		lblNgyNhp = new JLabel("     Ngày nhập: ");
		panel_abc_16.add(lblNgyNhp);
		// =============================================================
		GridBagConstraints gbc_datePicker_16 = new GridBagConstraints();
		// =============================================================
		model = new UtilDateModel();
		datePanel = new JDatePanelImpl(model);
		datePicker_16 = new JDatePickerImpl(datePanel);
		datePicker_16.getJFormattedTextField()
				.setToolTipText("Click chọn ngày");
		datePicker_16.getJFormattedTextField().setText(ChecNgay.now1());
		gbc_datePicker_16.gridx = 1;
		gbc_datePicker_16.gridy = 3;
		gbc_datePicker_16.insets = new Insets(0, 0, 15, 5);
		gbc_datePicker_16.anchor = GridBagConstraints.WEST;

		panel_abc_16.add(datePicker_16, gbc_datePicker_16);

		lblMKh = new JLabel("   Mã KH: ");
		panel_abc_16.add(lblMKh);

		tf_maKH_HD_16 = new JTextField();
		panel_abc_16.add(tf_maKH_HD_16);
		tf_maKH_HD_16.setColumns(5);

		panel_acc_16 = new JPanel();
		panel_acc_16.setBorder(new TitledBorder(new LineBorder(new Color(255,
				200, 0), 1, true),
				"Chi ti\u1EBFt c\u00E1c MH \u0111\u00E3 ch\u1ECDn: ",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, null));
		panel_theotungban_16.add(panel_acc_16, BorderLayout.CENTER);
		panel_acc_16.setLayout(new BorderLayout(0, 0));

		panel_addc_16 = new JPanel();
		panel_acc_16.add(panel_addc_16, BorderLayout.NORTH);
		panel_addc_16.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btn_tang_16 = new JButton(" Tăng");
		btn_tang_16.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/new.png")));
		panel_addc_16.add(btn_tang_16);

		btn_giam_16 = new JButton(" Giảm");
		btn_giam_16.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/giam.png")));
		panel_addc_16.add(btn_giam_16);

		btn_sl_macdinh_16 = new JButton("Đặt SL Mặc Định");
		btn_sl_macdinh_16.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/refresh.png")));
		panel_addc_16.add(btn_sl_macdinh_16);

		btn_ghichu_16 = new JButton("Ghi Chú");
		btn_ghichu_16.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/ghichunote.png")));
		panel_addc_16.add(btn_ghichu_16);

		panel_dbf_16 = new JPanel();
		panel_dbf_16.setBorder(new LineBorder(Color.ORANGE, 1, true));
		panel_acc_16.add(panel_dbf_16, BorderLayout.CENTER);
		panel_dbf_16.setLayout(new BorderLayout(0, 0));

		panel_zx_16 = new JPanel();
		panel_zx_16.setBorder(new TitledBorder(new LineBorder(new Color(255,
				200, 0), 1, true), "Ch\u1EE9c n\u0103ng: ",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_dbf_16.add(panel_zx_16, BorderLayout.SOUTH);
		panel_zx_16.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btn_thanhtoan_16 = new JButton("Thanh Toán");
		btn_thanhtoan_16.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/edit.png")));
		panel_zx_16.add(btn_thanhtoan_16);

		btn_capnhat_16 = new JButton("Cập Nhật");
		btn_capnhat_16.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/refresh.png")));
		panel_zx_16.add(btn_capnhat_16);
		panel_Show_HoaDon_Table_16 = new JPanel();
		panel_dbf_16.add(panel_Show_HoaDon_Table_16, BorderLayout.CENTER);
		table_16 = new JTable();

		columnames_16.add(" ID MH ");
		columnames_16.add(" Tên Mặt Hàng ");
		columnames_16.add(" Số Lượng ");
		columnames_16.add(" ĐVT ");
		columnames_16.add(" Giá ");
		columnames_16.add(" Thành Tiền ");

		// ++++++Set du lieu cho bang
		datamodel_16 = new DefaultTableModel(record_16, columnames_16);
		table_16.setModel(datamodel_16);

		// ++++++dieu chinh kich co cua bang
		table_16.setPreferredScrollableViewportSize(new Dimension(600, 250));
		table_16.setFillsViewportHeight(true);

		// ++++++them thanh cuon cho bang
		// ======================================================
		JScrollPane scroll_16 = new JScrollPane(table_16);
		// ======================================================

		scroll_16 = new JScrollPane(table_16,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		// Table.adjustColumnPreferredWidths(table);
		table_16.revalidate();
		panel_Show_HoaDon_Table_16.add(scroll_16);

		// End Panel Table Hoá Đơn ====================================
		// Bàn_16:======================================================
		// Bàn_17:======================
		panel_theotungban_17 = new JPanel();
		panel_theotungban_17.setBorder(new TitledBorder(new LineBorder(
				new Color(255, 200, 0), 1, true),
				"Th\u00F4ng tin ho\u00E1 \u0111\u01A1n: ",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		// SplitPanel_Right.add(panel_theotungban_17, BorderLayout.CENTER);
		panel_theotungban_17.setLayout(new BorderLayout(0, 0));

		panel_abc_17 = new JPanel();
		panel_theotungban_17.add(panel_abc_17, BorderLayout.NORTH);
		panel_abc_17.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		lblSBn = new JLabel("  Số bàn:  ");
		panel_abc_17.add(lblSBn);

		tf_soban_17 = new JTextField();
		panel_abc_17.add(tf_soban_17);
		tf_soban_17.setColumns(10);
		tf_soban_17.setText(" Bàn 17 ");

		lblNgyNhp = new JLabel("     Ngày nhập: ");
		panel_abc_17.add(lblNgyNhp);
		// =============================================================
		GridBagConstraints gbc_datePicker_17 = new GridBagConstraints();
		// =============================================================
		model = new UtilDateModel();
		datePanel = new JDatePanelImpl(model);
		datePicker_17 = new JDatePickerImpl(datePanel);
		datePicker_17.getJFormattedTextField()
				.setToolTipText("Click chọn ngày");
		datePicker_17.getJFormattedTextField().setText(ChecNgay.now1());
		gbc_datePicker_17.gridx = 1;
		gbc_datePicker_17.gridy = 3;
		gbc_datePicker_17.insets = new Insets(0, 0, 15, 5);
		gbc_datePicker_17.anchor = GridBagConstraints.WEST;

		panel_abc_17.add(datePicker_17, gbc_datePicker_17);

		lblMKh = new JLabel("   Mã KH: ");
		panel_abc_17.add(lblMKh);

		tf_maKH_HD_17 = new JTextField();
		panel_abc_17.add(tf_maKH_HD_17);
		tf_maKH_HD_17.setColumns(5);

		panel_acc_17 = new JPanel();
		panel_acc_17.setBorder(new TitledBorder(new LineBorder(new Color(255,
				200, 0), 1, true),
				"Chi ti\u1EBFt c\u00E1c MH \u0111\u00E3 ch\u1ECDn: ",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, null));
		panel_theotungban_17.add(panel_acc_17, BorderLayout.CENTER);
		panel_acc_17.setLayout(new BorderLayout(0, 0));

		panel_addc_17 = new JPanel();
		panel_acc_17.add(panel_addc_17, BorderLayout.NORTH);
		panel_addc_17.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btn_tang_17 = new JButton(" Tăng");
		btn_tang_17.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/new.png")));
		panel_addc_17.add(btn_tang_17);

		btn_giam_17 = new JButton(" Giảm");
		btn_giam_17.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/giam.png")));
		panel_addc_17.add(btn_giam_17);

		btn_sl_macdinh_17 = new JButton("Đặt SL Mặc Định");
		btn_sl_macdinh_17.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/refresh.png")));
		panel_addc_17.add(btn_sl_macdinh_17);

		btn_ghichu_17 = new JButton("Ghi Chú");
		btn_ghichu_17.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/ghichunote.png")));
		panel_addc_17.add(btn_ghichu_17);

		panel_dbf_17 = new JPanel();
		panel_dbf_17.setBorder(new LineBorder(Color.ORANGE, 1, true));
		panel_acc_17.add(panel_dbf_17, BorderLayout.CENTER);
		panel_dbf_17.setLayout(new BorderLayout(0, 0));

		panel_zx_17 = new JPanel();
		panel_zx_17.setBorder(new TitledBorder(new LineBorder(new Color(255,
				200, 0), 1, true), "Ch\u1EE9c n\u0103ng: ",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_dbf_17.add(panel_zx_17, BorderLayout.SOUTH);
		panel_zx_17.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btn_thanhtoan_17 = new JButton("Thanh Toán");
		btn_thanhtoan_17.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/edit.png")));
		panel_zx_17.add(btn_thanhtoan_17);

		btn_capnhat_17 = new JButton("Cập Nhật");
		btn_capnhat_17.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/refresh.png")));
		panel_zx_17.add(btn_capnhat_17);
		panel_Show_HoaDon_Table_17 = new JPanel();
		panel_dbf_17.add(panel_Show_HoaDon_Table_17, BorderLayout.CENTER);
		table_17 = new JTable();

		columnames_17.add(" ID MH ");
		columnames_17.add(" Tên Mặt Hàng ");
		columnames_17.add(" Số Lượng ");
		columnames_17.add(" ĐVT ");
		columnames_17.add(" Giá ");
		columnames_17.add(" Thành Tiền ");

		// ++++++Set du lieu cho bang
		datamodel_17 = new DefaultTableModel(record_17, columnames_17);
		table_17.setModel(datamodel_17);

		// ++++++dieu chinh kich co cua bang
		table_17.setPreferredScrollableViewportSize(new Dimension(600, 250));
		table_17.setFillsViewportHeight(true);

		// ++++++them thanh cuon cho bang
		// ======================================================
		JScrollPane scroll_17 = new JScrollPane(table_17);
		// ======================================================

		scroll_17 = new JScrollPane(table_17,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		// Table.adjustColumnPreferredWidths(table);
		table_17.revalidate();
		panel_Show_HoaDon_Table_17.add(scroll_17);

		// End Panel Table Hoá Đơn ====================================
		// Bàn_17:======================================================
		// Bàn_18:======================
		panel_theotungban_18 = new JPanel();
		panel_theotungban_18.setBorder(new TitledBorder(new LineBorder(
				new Color(255, 200, 0), 1, true),
				"Th\u00F4ng tin ho\u00E1 \u0111\u01A1n: ",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		// SplitPanel_Right.add(panel_theotungban_18, BorderLayout.CENTER);
		panel_theotungban_18.setLayout(new BorderLayout(0, 0));

		panel_abc_18 = new JPanel();
		panel_theotungban_18.add(panel_abc_18, BorderLayout.NORTH);
		panel_abc_18.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		lblSBn = new JLabel("  Số bàn:  ");
		panel_abc_18.add(lblSBn);

		tf_soban_18 = new JTextField();
		panel_abc_18.add(tf_soban_18);
		tf_soban_18.setColumns(10);
		tf_soban_18.setText(" Bàn 18 ");

		lblNgyNhp = new JLabel("     Ngày nhập: ");
		panel_abc_18.add(lblNgyNhp);
		// =============================================================
		GridBagConstraints gbc_datePicker_18 = new GridBagConstraints();
		// =============================================================
		model = new UtilDateModel();
		datePanel = new JDatePanelImpl(model);
		datePicker_18 = new JDatePickerImpl(datePanel);
		datePicker_18.getJFormattedTextField()
				.setToolTipText("Click chọn ngày");
		datePicker_18.getJFormattedTextField().setText(ChecNgay.now1());
		gbc_datePicker_18.gridx = 1;
		gbc_datePicker_18.gridy = 3;
		gbc_datePicker_18.insets = new Insets(0, 0, 15, 5);
		gbc_datePicker_18.anchor = GridBagConstraints.WEST;

		panel_abc_18.add(datePicker_18, gbc_datePicker_18);

		lblMKh = new JLabel("   Mã KH: ");
		panel_abc_18.add(lblMKh);

		tf_maKH_HD_18 = new JTextField();
		panel_abc_18.add(tf_maKH_HD_18);
		tf_maKH_HD_18.setColumns(5);

		panel_acc_18 = new JPanel();
		panel_acc_18.setBorder(new TitledBorder(new LineBorder(new Color(255,
				200, 0), 1, true),
				"Chi ti\u1EBFt c\u00E1c MH \u0111\u00E3 ch\u1ECDn: ",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, null));
		panel_theotungban_18.add(panel_acc_18, BorderLayout.CENTER);
		panel_acc_18.setLayout(new BorderLayout(0, 0));

		panel_addc_18 = new JPanel();
		panel_acc_18.add(panel_addc_18, BorderLayout.NORTH);
		panel_addc_18.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btn_tang_18 = new JButton(" Tăng");
		btn_tang_18.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/new.png")));
		panel_addc_18.add(btn_tang_18);

		btn_giam_18 = new JButton(" Giảm");
		btn_giam_18.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/giam.png")));
		panel_addc_18.add(btn_giam_18);

		btn_sl_macdinh_18 = new JButton("Đặt SL Mặc Định");
		btn_sl_macdinh_18.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/refresh.png")));
		panel_addc_18.add(btn_sl_macdinh_18);

		btn_ghichu_18 = new JButton("Ghi Chú");
		btn_ghichu_18.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/ghichunote.png")));
		panel_addc_18.add(btn_ghichu_18);

		panel_dbf_18 = new JPanel();
		panel_dbf_18.setBorder(new LineBorder(Color.ORANGE, 1, true));
		panel_acc_18.add(panel_dbf_18, BorderLayout.CENTER);
		panel_dbf_18.setLayout(new BorderLayout(0, 0));

		panel_zx_18 = new JPanel();
		panel_zx_18.setBorder(new TitledBorder(new LineBorder(new Color(255,
				200, 0), 1, true), "Ch\u1EE9c n\u0103ng: ",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_dbf_18.add(panel_zx_18, BorderLayout.SOUTH);
		panel_zx_18.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btn_thanhtoan_18 = new JButton("Thanh Toán");
		btn_thanhtoan_18.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/edit.png")));
		panel_zx_18.add(btn_thanhtoan_18);

		btn_capnhat_18 = new JButton("Cập Nhật");
		btn_capnhat_18.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/refresh.png")));
		panel_zx_18.add(btn_capnhat_18);
		panel_Show_HoaDon_Table_18 = new JPanel();
		panel_dbf_18.add(panel_Show_HoaDon_Table_18, BorderLayout.CENTER);
		table_18 = new JTable();

		columnames_18.add(" ID MH ");
		columnames_18.add(" Tên Mặt Hàng ");
		columnames_18.add(" Số Lượng ");
		columnames_18.add(" ĐVT ");
		columnames_18.add(" Giá ");
		columnames_18.add(" Thành Tiền ");

		// ++++++Set du lieu cho bang
		datamodel_18 = new DefaultTableModel(record_18, columnames_18);
		table_18.setModel(datamodel_18);

		// ++++++dieu chinh kich co cua bang
		table_18.setPreferredScrollableViewportSize(new Dimension(600, 250));
		table_18.setFillsViewportHeight(true);

		// ++++++them thanh cuon cho bang
		// ======================================================
		JScrollPane scroll_18 = new JScrollPane(table_18);
		// ======================================================

		scroll_18 = new JScrollPane(table_18,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		// Table.adjustColumnPreferredWidths(table);
		table_18.revalidate();
		panel_Show_HoaDon_Table_18.add(scroll_18);

		// End Panel Table Hoá Đơn ====================================
		// Bàn_18:======================================================
		// Bàn_19:======================
		panel_theotungban_19 = new JPanel();
		panel_theotungban_19.setBorder(new TitledBorder(new LineBorder(
				new Color(255, 200, 0), 1, true),
				"Th\u00F4ng tin ho\u00E1 \u0111\u01A1n: ",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		// SplitPanel_Right.add(panel_theotungban_19, BorderLayout.CENTER);
		panel_theotungban_19.setLayout(new BorderLayout(0, 0));

		panel_abc_19 = new JPanel();
		panel_theotungban_19.add(panel_abc_19, BorderLayout.NORTH);
		panel_abc_19.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		lblSBn = new JLabel("  Số bàn:  ");
		panel_abc_19.add(lblSBn);

		tf_soban_19 = new JTextField();
		panel_abc_19.add(tf_soban_19);
		tf_soban_19.setColumns(10);
		tf_soban_19.setText(" Bàn 19 ");

		lblNgyNhp = new JLabel("     Ngày nhập: ");
		panel_abc_19.add(lblNgyNhp);
		// =============================================================
		GridBagConstraints gbc_datePicker_19 = new GridBagConstraints();
		// =============================================================
		model = new UtilDateModel();
		datePanel = new JDatePanelImpl(model);
		datePicker_19 = new JDatePickerImpl(datePanel);
		datePicker_19.getJFormattedTextField()
				.setToolTipText("Click chọn ngày");
		datePicker_19.getJFormattedTextField().setText(ChecNgay.now1());
		gbc_datePicker_19.gridx = 1;
		gbc_datePicker_19.gridy = 3;
		gbc_datePicker_19.insets = new Insets(0, 0, 15, 5);
		gbc_datePicker_19.anchor = GridBagConstraints.WEST;

		panel_abc_19.add(datePicker_19, gbc_datePicker_19);

		lblMKh = new JLabel("   Mã KH: ");
		panel_abc_19.add(lblMKh);

		tf_maKH_HD_19 = new JTextField();
		panel_abc_19.add(tf_maKH_HD_19);
		tf_maKH_HD_19.setColumns(5);

		panel_acc_19 = new JPanel();
		panel_acc_19.setBorder(new TitledBorder(new LineBorder(new Color(255,
				200, 0), 1, true),
				"Chi ti\u1EBFt c\u00E1c MH \u0111\u00E3 ch\u1ECDn: ",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, null));
		panel_theotungban_19.add(panel_acc_19, BorderLayout.CENTER);
		panel_acc_19.setLayout(new BorderLayout(0, 0));

		panel_addc_19 = new JPanel();
		panel_acc_19.add(panel_addc_19, BorderLayout.NORTH);
		panel_addc_19.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btn_tang_19 = new JButton(" Tăng");
		btn_tang_19.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/new.png")));
		panel_addc_19.add(btn_tang_19);

		btn_giam_19 = new JButton(" Giảm");
		btn_giam_19.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/giam.png")));
		panel_addc_19.add(btn_giam_19);

		btn_sl_macdinh_19 = new JButton("Đặt SL Mặc Định");
		btn_sl_macdinh_19.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/refresh.png")));
		panel_addc_19.add(btn_sl_macdinh_19);

		btn_ghichu_19 = new JButton("Ghi Chú");
		btn_ghichu_19.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/ghichunote.png")));
		panel_addc_19.add(btn_ghichu_19);

		panel_dbf_19 = new JPanel();
		panel_dbf_19.setBorder(new LineBorder(Color.ORANGE, 1, true));
		panel_acc_19.add(panel_dbf_19, BorderLayout.CENTER);
		panel_dbf_19.setLayout(new BorderLayout(0, 0));

		panel_zx_19 = new JPanel();
		panel_zx_19.setBorder(new TitledBorder(new LineBorder(new Color(255,
				200, 0), 1, true), "Ch\u1EE9c n\u0103ng: ",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_dbf_19.add(panel_zx_19, BorderLayout.SOUTH);
		panel_zx_19.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btn_thanhtoan_19 = new JButton("Thanh Toán");
		btn_thanhtoan_19.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/edit.png")));
		panel_zx_19.add(btn_thanhtoan_19);

		btn_capnhat_19 = new JButton("Cập Nhật");
		btn_capnhat_19.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/refresh.png")));
		panel_zx_19.add(btn_capnhat_19);
		panel_Show_HoaDon_Table_19 = new JPanel();
		panel_dbf_19.add(panel_Show_HoaDon_Table_19, BorderLayout.CENTER);
		table_19 = new JTable();

		columnames_19.add(" ID MH ");
		columnames_19.add(" Tên Mặt Hàng ");
		columnames_19.add(" Số Lượng ");
		columnames_19.add(" ĐVT ");
		columnames_19.add(" Giá ");
		columnames_19.add(" Thành Tiền ");

		// ++++++Set du lieu cho bang
		datamodel_19 = new DefaultTableModel(record_19, columnames_19);
		table_19.setModel(datamodel_19);

		// ++++++dieu chinh kich co cua bang
		table_19.setPreferredScrollableViewportSize(new Dimension(600, 250));
		table_19.setFillsViewportHeight(true);

		// ++++++them thanh cuon cho bang
		// ======================================================
		JScrollPane scroll_19 = new JScrollPane(table_19);
		// ======================================================

		scroll_19 = new JScrollPane(table_19,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		// Table.adjustColumnPreferredWidths(table);
		table_19.revalidate();
		panel_Show_HoaDon_Table_19.add(scroll_19);

		// End Panel Table Hoá Đơn ====================================
		// Bàn_19:======================================================
		// Bàn_20:======================
		panel_theotungban_20 = new JPanel();
		panel_theotungban_20.setBorder(new TitledBorder(new LineBorder(
				new Color(255, 200, 0), 1, true),
				"Th\u00F4ng tin ho\u00E1 \u0111\u01A1n: ",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		// SplitPanel_Right.add(panel_theotungban_20, BorderLayout.CENTER);
		panel_theotungban_20.setLayout(new BorderLayout(0, 0));

		panel_abc_20 = new JPanel();
		panel_theotungban_20.add(panel_abc_20, BorderLayout.NORTH);
		panel_abc_20.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		lblSBn = new JLabel("  Số bàn:  ");
		panel_abc_20.add(lblSBn);

		tf_soban_20 = new JTextField();
		panel_abc_20.add(tf_soban_20);
		tf_soban_20.setColumns(10);
		tf_soban_20.setText(" Bàn 20 ");

		lblNgyNhp = new JLabel("     Ngày nhập: ");
		panel_abc_20.add(lblNgyNhp);
		// =============================================================
		GridBagConstraints gbc_datePicker_20 = new GridBagConstraints();
		// =============================================================
		model = new UtilDateModel();
		datePanel = new JDatePanelImpl(model);
		datePicker_20 = new JDatePickerImpl(datePanel);
		datePicker_20.getJFormattedTextField()
				.setToolTipText("Click chọn ngày");
		datePicker_20.getJFormattedTextField().setText(ChecNgay.now1());
		gbc_datePicker_20.gridx = 1;
		gbc_datePicker_20.gridy = 3;
		gbc_datePicker_20.insets = new Insets(0, 0, 15, 5);
		gbc_datePicker_20.anchor = GridBagConstraints.WEST;

		panel_abc_20.add(datePicker_20, gbc_datePicker_20);

		lblMKh = new JLabel("   Mã KH: ");
		panel_abc_20.add(lblMKh);

		tf_maKH_HD_20 = new JTextField();
		panel_abc_20.add(tf_maKH_HD_20);
		tf_maKH_HD_20.setColumns(5);

		panel_acc_20 = new JPanel();
		panel_acc_20.setBorder(new TitledBorder(new LineBorder(new Color(255,
				200, 0), 1, true),
				"Chi ti\u1EBFt c\u00E1c MH \u0111\u00E3 ch\u1ECDn: ",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, null));
		panel_theotungban_20.add(panel_acc_20, BorderLayout.CENTER);
		panel_acc_20.setLayout(new BorderLayout(0, 0));

		panel_addc_20 = new JPanel();
		panel_acc_20.add(panel_addc_20, BorderLayout.NORTH);
		panel_addc_20.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btn_tang_20 = new JButton(" Tăng");
		btn_tang_20.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/new.png")));
		panel_addc_20.add(btn_tang_20);

		btn_giam_20 = new JButton(" Giảm");
		btn_giam_20.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/giam.png")));
		panel_addc_20.add(btn_giam_20);

		btn_sl_macdinh_20 = new JButton("Đặt SL Mặc Định");
		btn_sl_macdinh_20.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/refresh.png")));
		panel_addc_20.add(btn_sl_macdinh_20);

		btn_ghichu_20 = new JButton("Ghi Chú");
		btn_ghichu_20.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/ghichunote.png")));
		panel_addc_20.add(btn_ghichu_20);

		panel_dbf_20 = new JPanel();
		panel_dbf_20.setBorder(new LineBorder(Color.ORANGE, 1, true));
		panel_acc_20.add(panel_dbf_20, BorderLayout.CENTER);
		panel_dbf_20.setLayout(new BorderLayout(0, 0));

		panel_zx_20 = new JPanel();
		panel_zx_20.setBorder(new TitledBorder(new LineBorder(new Color(255,
				200, 0), 1, true), "Ch\u1EE9c n\u0103ng: ",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_dbf_20.add(panel_zx_20, BorderLayout.SOUTH);
		panel_zx_20.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btn_thanhtoan_20 = new JButton("Thanh Toán");
		btn_thanhtoan_20.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/edit.png")));
		panel_zx_20.add(btn_thanhtoan_20);

		btn_capnhat_20 = new JButton("Cập Nhật");
		btn_capnhat_20.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/refresh.png")));
		panel_zx_20.add(btn_capnhat_20);
		panel_Show_HoaDon_Table_20 = new JPanel();
		panel_dbf_20.add(panel_Show_HoaDon_Table_20, BorderLayout.CENTER);
		table_20 = new JTable();

		columnames_20.add(" ID MH ");
		columnames_20.add(" Tên Mặt Hàng ");
		columnames_20.add(" Số Lượng ");
		columnames_20.add(" ĐVT ");
		columnames_20.add(" Giá ");
		columnames_20.add(" Thành Tiền ");

		// ++++++Set du lieu cho bang
		datamodel_20 = new DefaultTableModel(record_20, columnames_20);
		table_20.setModel(datamodel_20);

		// ++++++dieu chinh kich co cua bang
		table_20.setPreferredScrollableViewportSize(new Dimension(600, 250));
		table_20.setFillsViewportHeight(true);

		// ++++++them thanh cuon cho bang
		// ======================================================
		JScrollPane scroll_20 = new JScrollPane(table_20);
		// ======================================================

		scroll_20 = new JScrollPane(table_20,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		// Table.adjustColumnPreferredWidths(table);
		table_20.revalidate();
		panel_Show_HoaDon_Table_20.add(scroll_20);

		// End Panel Table Hoá Đơn ====================================
		// Bàn_20:======================================================
		// Bàn_21:======================
		panel_theotungban_21 = new JPanel();
		panel_theotungban_21.setBorder(new TitledBorder(new LineBorder(
				new Color(255, 200, 0), 1, true),
				"Th\u00F4ng tin ho\u00E1 \u0111\u01A1n: ",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		// SplitPanel_Right.add(panel_theotungban_21, BorderLayout.CENTER);
		panel_theotungban_21.setLayout(new BorderLayout(0, 0));

		panel_abc_21 = new JPanel();
		panel_theotungban_21.add(panel_abc_21, BorderLayout.NORTH);
		panel_abc_21.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		lblSBn = new JLabel("  Số bàn:  ");
		panel_abc_21.add(lblSBn);

		tf_soban_21 = new JTextField();
		panel_abc_21.add(tf_soban_21);
		tf_soban_21.setColumns(10);
		tf_soban_21.setText(" Bàn 21 ");

		lblNgyNhp = new JLabel("     Ngày nhập: ");
		panel_abc_21.add(lblNgyNhp);
		// =============================================================
		GridBagConstraints gbc_datePicker_21 = new GridBagConstraints();
		// =============================================================
		model = new UtilDateModel();
		datePanel = new JDatePanelImpl(model);
		datePicker_21 = new JDatePickerImpl(datePanel);
		datePicker_21.getJFormattedTextField()
				.setToolTipText("Click chọn ngày");
		datePicker_21.getJFormattedTextField().setText(ChecNgay.now1());
		gbc_datePicker_21.gridx = 1;
		gbc_datePicker_21.gridy = 3;
		gbc_datePicker_21.insets = new Insets(0, 0, 15, 5);
		gbc_datePicker_21.anchor = GridBagConstraints.WEST;

		panel_abc_21.add(datePicker_21, gbc_datePicker_21);

		lblMKh = new JLabel("   Mã KH: ");
		panel_abc_21.add(lblMKh);

		tf_maKH_HD_21 = new JTextField();
		panel_abc_21.add(tf_maKH_HD_21);
		tf_maKH_HD_21.setColumns(5);

		panel_acc_21 = new JPanel();
		panel_acc_21.setBorder(new TitledBorder(new LineBorder(new Color(255,
				200, 0), 1, true),
				"Chi ti\u1EBFt c\u00E1c MH \u0111\u00E3 ch\u1ECDn: ",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, null));
		panel_theotungban_21.add(panel_acc_21, BorderLayout.CENTER);
		panel_acc_21.setLayout(new BorderLayout(0, 0));

		panel_addc_21 = new JPanel();
		panel_acc_21.add(panel_addc_21, BorderLayout.NORTH);
		panel_addc_21.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btn_tang_21 = new JButton(" Tăng");
		btn_tang_21.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/new.png")));
		panel_addc_21.add(btn_tang_21);

		btn_giam_21 = new JButton(" Giảm");
		btn_giam_21.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/giam.png")));
		panel_addc_21.add(btn_giam_21);

		btn_sl_macdinh_21 = new JButton("Đặt SL Mặc Định");
		btn_sl_macdinh_21.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/refresh.png")));
		panel_addc_21.add(btn_sl_macdinh_21);

		btn_ghichu_21 = new JButton("Ghi Chú");
		btn_ghichu_21.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/ghichunote.png")));
		panel_addc_21.add(btn_ghichu_21);

		panel_dbf_21 = new JPanel();
		panel_dbf_21.setBorder(new LineBorder(Color.ORANGE, 1, true));
		panel_acc_21.add(panel_dbf_21, BorderLayout.CENTER);
		panel_dbf_21.setLayout(new BorderLayout(0, 0));

		panel_zx_21 = new JPanel();
		panel_zx_21.setBorder(new TitledBorder(new LineBorder(new Color(255,
				200, 0), 1, true), "Ch\u1EE9c n\u0103ng: ",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_dbf_21.add(panel_zx_21, BorderLayout.SOUTH);
		panel_zx_21.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btn_thanhtoan_21 = new JButton("Thanh Toán");
		btn_thanhtoan_21.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/edit.png")));
		panel_zx_21.add(btn_thanhtoan_21);

		btn_capnhat_21 = new JButton("Cập Nhật");
		btn_capnhat_21.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/refresh.png")));
		panel_zx_21.add(btn_capnhat_21);
		panel_Show_HoaDon_Table_21 = new JPanel();
		panel_dbf_21.add(panel_Show_HoaDon_Table_21, BorderLayout.CENTER);
		table_21 = new JTable();

		columnames_21.add(" ID MH ");
		columnames_21.add(" Tên Mặt Hàng ");
		columnames_21.add(" Số Lượng ");
		columnames_21.add(" ĐVT ");
		columnames_21.add(" Giá ");
		columnames_21.add(" Thành Tiền ");

		// ++++++Set du lieu cho bang
		datamodel_21 = new DefaultTableModel(record_21, columnames_21);
		table_21.setModel(datamodel_21);

		// ++++++dieu chinh kich co cua bang
		table_21.setPreferredScrollableViewportSize(new Dimension(600, 250));
		table_21.setFillsViewportHeight(true);

		// ++++++them thanh cuon cho bang
		// ======================================================
		JScrollPane scroll_21 = new JScrollPane(table_21);
		// ======================================================

		scroll_21 = new JScrollPane(table_21,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		// Table.adjustColumnPreferredWidths(table);
		table_21.revalidate();
		panel_Show_HoaDon_Table_21.add(scroll_21);

		// End Panel Table Hoá Đơn ====================================
		// Bàn_21:======================================================
		// Bàn_22:======================
		panel_theotungban_22 = new JPanel();
		panel_theotungban_22.setBorder(new TitledBorder(new LineBorder(
				new Color(255, 200, 0), 1, true),
				"Th\u00F4ng tin ho\u00E1 \u0111\u01A1n: ",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		// SplitPanel_Right.add(panel_theotungban_22, BorderLayout.CENTER);
		panel_theotungban_22.setLayout(new BorderLayout(0, 0));

		panel_abc_22 = new JPanel();
		panel_theotungban_22.add(panel_abc_22, BorderLayout.NORTH);
		panel_abc_22.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		lblSBn = new JLabel("  Số bàn:  ");
		panel_abc_22.add(lblSBn);

		tf_soban_22 = new JTextField();
		panel_abc_22.add(tf_soban_22);
		tf_soban_22.setColumns(10);
		tf_soban_22.setText(" Bàn 22 ");

		lblNgyNhp = new JLabel("     Ngày nhập: ");
		panel_abc_22.add(lblNgyNhp);
		// =============================================================
		GridBagConstraints gbc_datePicker_22 = new GridBagConstraints();
		// =============================================================
		model = new UtilDateModel();
		datePanel = new JDatePanelImpl(model);
		datePicker_22 = new JDatePickerImpl(datePanel);
		datePicker_22.getJFormattedTextField()
				.setToolTipText("Click chọn ngày");
		datePicker_22.getJFormattedTextField().setText(ChecNgay.now1());
		gbc_datePicker_22.gridx = 1;
		gbc_datePicker_22.gridy = 3;
		gbc_datePicker_22.insets = new Insets(0, 0, 15, 5);
		gbc_datePicker_22.anchor = GridBagConstraints.WEST;

		panel_abc_22.add(datePicker_22, gbc_datePicker_22);

		lblMKh = new JLabel("   Mã KH: ");
		panel_abc_22.add(lblMKh);

		tf_maKH_HD_22 = new JTextField();
		panel_abc_22.add(tf_maKH_HD_22);
		tf_maKH_HD_22.setColumns(5);

		panel_acc_22 = new JPanel();
		panel_acc_22.setBorder(new TitledBorder(new LineBorder(new Color(255,
				200, 0), 1, true),
				"Chi ti\u1EBFt c\u00E1c MH \u0111\u00E3 ch\u1ECDn: ",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, null));
		panel_theotungban_22.add(panel_acc_22, BorderLayout.CENTER);
		panel_acc_22.setLayout(new BorderLayout(0, 0));

		panel_addc_22 = new JPanel();
		panel_acc_22.add(panel_addc_22, BorderLayout.NORTH);
		panel_addc_22.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btn_tang_22 = new JButton(" Tăng");
		btn_tang_22.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/new.png")));
		panel_addc_22.add(btn_tang_22);

		btn_giam_22 = new JButton(" Giảm");
		btn_giam_22.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/giam.png")));
		panel_addc_22.add(btn_giam_22);

		btn_sl_macdinh_22 = new JButton("Đặt SL Mặc Định");
		btn_sl_macdinh_22.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/refresh.png")));
		panel_addc_22.add(btn_sl_macdinh_22);

		btn_ghichu_22 = new JButton("Ghi Chú");
		btn_ghichu_22.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/ghichunote.png")));
		panel_addc_22.add(btn_ghichu_22);

		panel_dbf_22 = new JPanel();
		panel_dbf_22.setBorder(new LineBorder(Color.ORANGE, 1, true));
		panel_acc_22.add(panel_dbf_22, BorderLayout.CENTER);
		panel_dbf_22.setLayout(new BorderLayout(0, 0));

		panel_zx_22 = new JPanel();
		panel_zx_22.setBorder(new TitledBorder(new LineBorder(new Color(255,
				200, 0), 1, true), "Ch\u1EE9c n\u0103ng: ",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_dbf_22.add(panel_zx_22, BorderLayout.SOUTH);
		panel_zx_22.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btn_thanhtoan_22 = new JButton("Thanh Toán");
		btn_thanhtoan_22.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/edit.png")));
		panel_zx_22.add(btn_thanhtoan_22);

		btn_capnhat_22 = new JButton("Cập Nhật");
		btn_capnhat_22.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/refresh.png")));
		panel_zx_22.add(btn_capnhat_22);
		panel_Show_HoaDon_Table_22 = new JPanel();
		panel_dbf_22.add(panel_Show_HoaDon_Table_22, BorderLayout.CENTER);
		table_22 = new JTable();

		columnames_22.add(" ID MH ");
		columnames_22.add(" Tên Mặt Hàng ");
		columnames_22.add(" Số Lượng ");
		columnames_22.add(" ĐVT ");
		columnames_22.add(" Giá ");
		columnames_22.add(" Thành Tiền ");

		// ++++++Set du lieu cho bang
		datamodel_22 = new DefaultTableModel(record_22, columnames_22);
		table_22.setModel(datamodel_22);

		// ++++++dieu chinh kich co cua bang
		table_22.setPreferredScrollableViewportSize(new Dimension(600, 250));
		table_22.setFillsViewportHeight(true);

		// ++++++them thanh cuon cho bang
		// ======================================================
		JScrollPane scroll_22 = new JScrollPane(table_22);
		// ======================================================

		scroll_22 = new JScrollPane(table_22,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		// Table.adjustColumnPreferredWidths(table);
		table_22.revalidate();
		panel_Show_HoaDon_Table_22.add(scroll_22);

		// End Panel Table Hoá Đơn ====================================
		// Bàn_22:======================================================
		// Bàn_23:======================
		panel_theotungban_23 = new JPanel();
		panel_theotungban_23.setBorder(new TitledBorder(new LineBorder(
				new Color(255, 200, 0), 1, true),
				"Th\u00F4ng tin ho\u00E1 \u0111\u01A1n: ",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		// SplitPanel_Right.add(panel_theotungban_23, BorderLayout.CENTER);
		panel_theotungban_23.setLayout(new BorderLayout(0, 0));

		panel_abc_23 = new JPanel();
		panel_theotungban_23.add(panel_abc_23, BorderLayout.NORTH);
		panel_abc_23.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		lblSBn = new JLabel("  Số bàn:  ");
		panel_abc_23.add(lblSBn);

		tf_soban_23 = new JTextField();
		panel_abc_23.add(tf_soban_23);
		tf_soban_23.setColumns(10);
		tf_soban_23.setText(" Bàn 23 ");

		lblNgyNhp = new JLabel("     Ngày nhập: ");
		panel_abc_23.add(lblNgyNhp);
		// =============================================================
		GridBagConstraints gbc_datePicker_23 = new GridBagConstraints();
		// =============================================================
		model = new UtilDateModel();
		datePanel = new JDatePanelImpl(model);
		datePicker_23 = new JDatePickerImpl(datePanel);
		datePicker_23.getJFormattedTextField()
				.setToolTipText("Click chọn ngày");
		datePicker_23.getJFormattedTextField().setText(ChecNgay.now1());
		gbc_datePicker_23.gridx = 1;
		gbc_datePicker_23.gridy = 3;
		gbc_datePicker_23.insets = new Insets(0, 0, 15, 5);
		gbc_datePicker_23.anchor = GridBagConstraints.WEST;

		panel_abc_23.add(datePicker_23, gbc_datePicker_23);

		lblMKh = new JLabel("   Mã KH: ");
		panel_abc_23.add(lblMKh);

		tf_maKH_HD_23 = new JTextField();
		panel_abc_23.add(tf_maKH_HD_23);
		tf_maKH_HD_23.setColumns(5);

		panel_acc_23 = new JPanel();
		panel_acc_23.setBorder(new TitledBorder(new LineBorder(new Color(255,
				200, 0), 1, true),
				"Chi ti\u1EBFt c\u00E1c MH \u0111\u00E3 ch\u1ECDn: ",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, null));
		panel_theotungban_23.add(panel_acc_23, BorderLayout.CENTER);
		panel_acc_23.setLayout(new BorderLayout(0, 0));

		panel_addc_23 = new JPanel();
		panel_acc_23.add(panel_addc_23, BorderLayout.NORTH);
		panel_addc_23.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btn_tang_23 = new JButton(" Tăng");
		btn_tang_23.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/new.png")));
		panel_addc_23.add(btn_tang_23);

		btn_giam_23 = new JButton(" Giảm");
		btn_giam_23.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/giam.png")));
		panel_addc_23.add(btn_giam_23);

		btn_sl_macdinh_23 = new JButton("Đặt SL Mặc Định");
		btn_sl_macdinh_23.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/refresh.png")));
		panel_addc_23.add(btn_sl_macdinh_23);

		btn_ghichu_23 = new JButton("Ghi Chú");
		btn_ghichu_23.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/ghichunote.png")));
		panel_addc_23.add(btn_ghichu_23);

		panel_dbf_23 = new JPanel();
		panel_dbf_23.setBorder(new LineBorder(Color.ORANGE, 1, true));
		panel_acc_23.add(panel_dbf_23, BorderLayout.CENTER);
		panel_dbf_23.setLayout(new BorderLayout(0, 0));

		panel_zx_23 = new JPanel();
		panel_zx_23.setBorder(new TitledBorder(new LineBorder(new Color(255,
				200, 0), 1, true), "Ch\u1EE9c n\u0103ng: ",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_dbf_23.add(panel_zx_23, BorderLayout.SOUTH);
		panel_zx_23.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btn_thanhtoan_23 = new JButton("Thanh Toán");
		btn_thanhtoan_23.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/edit.png")));
		panel_zx_23.add(btn_thanhtoan_23);

		btn_capnhat_23 = new JButton("Cập Nhật");
		btn_capnhat_23.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/refresh.png")));
		panel_zx_23.add(btn_capnhat_23);
		panel_Show_HoaDon_Table_23 = new JPanel();
		panel_dbf_23.add(panel_Show_HoaDon_Table_23, BorderLayout.CENTER);
		table_23 = new JTable();

		columnames_23.add(" ID MH ");
		columnames_23.add(" Tên Mặt Hàng ");
		columnames_23.add(" Số Lượng ");
		columnames_23.add(" ĐVT ");
		columnames_23.add(" Giá ");
		columnames_23.add(" Thành Tiền ");

		// ++++++Set du lieu cho bang
		datamodel_23 = new DefaultTableModel(record_23, columnames_23);
		table_23.setModel(datamodel_23);

		// ++++++dieu chinh kich co cua bang
		table_23.setPreferredScrollableViewportSize(new Dimension(600, 250));
		table_23.setFillsViewportHeight(true);

		// ++++++them thanh cuon cho bang
		// ======================================================
		JScrollPane scroll_23 = new JScrollPane(table_23);
		// ======================================================

		scroll_23 = new JScrollPane(table_23,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		// Table.adjustColumnPreferredWidths(table);
		table_23.revalidate();
		panel_Show_HoaDon_Table_23.add(scroll_23);

		// End Panel Table Hoá Đơn ====================================
		// Bàn_23:======================================================
		// Bàn_24:======================
		panel_theotungban_24 = new JPanel();
		panel_theotungban_24.setBorder(new TitledBorder(new LineBorder(
				new Color(255, 200, 0), 1, true),
				"Th\u00F4ng tin ho\u00E1 \u0111\u01A1n: ",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		// SplitPanel_Right.add(panel_theotungban_24, BorderLayout.CENTER);
		panel_theotungban_24.setLayout(new BorderLayout(0, 0));

		panel_abc_24 = new JPanel();
		panel_theotungban_24.add(panel_abc_24, BorderLayout.NORTH);
		panel_abc_24.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		lblSBn = new JLabel("  Số bàn:  ");
		panel_abc_24.add(lblSBn);

		tf_soban_24 = new JTextField();
		panel_abc_24.add(tf_soban_24);
		tf_soban_24.setColumns(10);
		tf_soban_24.setText(" Bàn 24 ");

		lblNgyNhp = new JLabel("     Ngày nhập: ");
		panel_abc_24.add(lblNgyNhp);
		// =============================================================
		GridBagConstraints gbc_datePicker_24 = new GridBagConstraints();
		// =============================================================
		model = new UtilDateModel();
		datePanel = new JDatePanelImpl(model);
		datePicker_24 = new JDatePickerImpl(datePanel);
		datePicker_24.getJFormattedTextField()
				.setToolTipText("Click chọn ngày");
		datePicker_24.getJFormattedTextField().setText(ChecNgay.now1());
		gbc_datePicker_24.gridx = 1;
		gbc_datePicker_24.gridy = 3;
		gbc_datePicker_24.insets = new Insets(0, 0, 15, 5);
		gbc_datePicker_24.anchor = GridBagConstraints.WEST;

		panel_abc_24.add(datePicker_24, gbc_datePicker_24);

		lblMKh = new JLabel("   Mã KH: ");
		panel_abc_24.add(lblMKh);

		tf_maKH_HD_24 = new JTextField();
		panel_abc_24.add(tf_maKH_HD_24);
		tf_maKH_HD_24.setColumns(5);

		panel_acc_24 = new JPanel();
		panel_acc_24.setBorder(new TitledBorder(new LineBorder(new Color(255,
				200, 0), 1, true),
				"Chi ti\u1EBFt c\u00E1c MH \u0111\u00E3 ch\u1ECDn: ",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, null));
		panel_theotungban_24.add(panel_acc_24, BorderLayout.CENTER);
		panel_acc_24.setLayout(new BorderLayout(0, 0));

		panel_addc_24 = new JPanel();
		panel_acc_24.add(panel_addc_24, BorderLayout.NORTH);
		panel_addc_24.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btn_tang_24 = new JButton(" Tăng");
		btn_tang_24.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/new.png")));
		panel_addc_24.add(btn_tang_24);

		btn_giam_24 = new JButton(" Giảm");
		btn_giam_24.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/giam.png")));
		panel_addc_24.add(btn_giam_24);

		btn_sl_macdinh_24 = new JButton("Đặt SL Mặc Định");
		btn_sl_macdinh_24.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/refresh.png")));
		panel_addc_24.add(btn_sl_macdinh_24);

		btn_ghichu_24 = new JButton("Ghi Chú");
		btn_ghichu_24.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/ghichunote.png")));
		panel_addc_24.add(btn_ghichu_24);

		panel_dbf_24 = new JPanel();
		panel_dbf_24.setBorder(new LineBorder(Color.ORANGE, 1, true));
		panel_acc_24.add(panel_dbf_24, BorderLayout.CENTER);
		panel_dbf_24.setLayout(new BorderLayout(0, 0));

		panel_zx_24 = new JPanel();
		panel_zx_24.setBorder(new TitledBorder(new LineBorder(new Color(255,
				200, 0), 1, true), "Ch\u1EE9c n\u0103ng: ",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_dbf_24.add(panel_zx_24, BorderLayout.SOUTH);
		panel_zx_24.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btn_thanhtoan_24 = new JButton("Thanh Toán");
		btn_thanhtoan_24.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/edit.png")));
		panel_zx_24.add(btn_thanhtoan_24);

		btn_capnhat_24 = new JButton("Cập Nhật");
		btn_capnhat_24.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/refresh.png")));
		panel_zx_24.add(btn_capnhat_24);
		panel_Show_HoaDon_Table_24 = new JPanel();
		panel_dbf_24.add(panel_Show_HoaDon_Table_24, BorderLayout.CENTER);
		table_24 = new JTable();

		columnames_24.add(" ID MH ");
		columnames_24.add(" Tên Mặt Hàng ");
		columnames_24.add(" Số Lượng ");
		columnames_24.add(" ĐVT ");
		columnames_24.add(" Giá ");
		columnames_24.add(" Thành Tiền ");

		// ++++++Set du lieu cho bang
		datamodel_24 = new DefaultTableModel(record_24, columnames_24);
		table_24.setModel(datamodel_24);

		// ++++++dieu chinh kich co cua bang
		table_24.setPreferredScrollableViewportSize(new Dimension(600, 250));
		table_24.setFillsViewportHeight(true);

		// ++++++them thanh cuon cho bang
		// ======================================================
		JScrollPane scroll_24 = new JScrollPane(table_24);
		// ======================================================

		scroll_24 = new JScrollPane(table_24,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		// Table.adjustColumnPreferredWidths(table);
		table_24.revalidate();
		panel_Show_HoaDon_Table_24.add(scroll_24);

		// End Panel Table Hoá Đơn ====================================
		// Bàn_24:======================================================
		// Bàn_25:======================
		panel_theotungban_25 = new JPanel();
		panel_theotungban_25.setBorder(new TitledBorder(new LineBorder(
				new Color(255, 200, 0), 1, true),
				"Th\u00F4ng tin ho\u00E1 \u0111\u01A1n: ",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		// SplitPanel_Right.add(panel_theotungban_25, BorderLayout.CENTER);
		panel_theotungban_25.setLayout(new BorderLayout(0, 0));

		panel_abc_25 = new JPanel();
		panel_theotungban_25.add(panel_abc_25, BorderLayout.NORTH);
		panel_abc_25.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		lblSBn = new JLabel("  Số bàn:  ");
		panel_abc_25.add(lblSBn);

		tf_soban_25 = new JTextField();
		panel_abc_25.add(tf_soban_25);
		tf_soban_25.setColumns(10);

		lblNgyNhp = new JLabel("     Ngày nhập: ");
		panel_abc_25.add(lblNgyNhp);
		// =============================================================
		GridBagConstraints gbc_datePicker_25 = new GridBagConstraints();
		// =============================================================
		model = new UtilDateModel();
		datePanel = new JDatePanelImpl(model);
		datePicker_25 = new JDatePickerImpl(datePanel);
		datePicker_25.getJFormattedTextField()
				.setToolTipText("Click chọn ngày");
		datePicker_25.getJFormattedTextField().setText(ChecNgay.now1());
		gbc_datePicker_25.gridx = 1;
		gbc_datePicker_25.gridy = 3;
		gbc_datePicker_25.insets = new Insets(0, 0, 15, 5);
		gbc_datePicker_25.anchor = GridBagConstraints.WEST;

		panel_abc_25.add(datePicker_25, gbc_datePicker_25);

		lblMKh = new JLabel("   Mã KH: ");
		panel_abc_25.add(lblMKh);

		tf_maKH_HD_25 = new JTextField();
		panel_abc_25.add(tf_maKH_HD_25);
		tf_maKH_HD_25.setColumns(5);

		panel_acc_25 = new JPanel();
		panel_acc_25.setBorder(new TitledBorder(new LineBorder(new Color(255,
				200, 0), 1, true),
				"Chi ti\u1EBFt c\u00E1c MH \u0111\u00E3 ch\u1ECDn: ",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, null));
		panel_theotungban_25.add(panel_acc_25, BorderLayout.CENTER);
		panel_acc_25.setLayout(new BorderLayout(0, 0));

		panel_addc_25 = new JPanel();
		panel_acc_25.add(panel_addc_25, BorderLayout.NORTH);
		panel_addc_25.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btn_tang_25 = new JButton(" Tăng");
		btn_tang_25.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/new.png")));
		panel_addc_25.add(btn_tang_25);

		btn_giam_25 = new JButton(" Giảm");
		btn_giam_25.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/giam.png")));
		panel_addc_25.add(btn_giam_25);

		btn_sl_macdinh_25 = new JButton("Đặt SL Mặc Định");
		btn_sl_macdinh_25.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/refresh.png")));
		panel_addc_25.add(btn_sl_macdinh_25);

		btn_ghichu_25 = new JButton("Ghi Chú");
		btn_ghichu_25.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/ghichunote.png")));
		panel_addc_25.add(btn_ghichu_25);

		panel_dbf_25 = new JPanel();
		panel_dbf_25.setBorder(new LineBorder(Color.ORANGE, 1, true));
		panel_acc_25.add(panel_dbf_25, BorderLayout.CENTER);
		panel_dbf_25.setLayout(new BorderLayout(0, 0));

		panel_zx_25 = new JPanel();
		panel_zx_25.setBorder(new TitledBorder(new LineBorder(new Color(255,
				200, 0), 1, true), "Ch\u1EE9c n\u0103ng: ",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_dbf_25.add(panel_zx_25, BorderLayout.SOUTH);
		panel_zx_25.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btn_thanhtoan_25 = new JButton("Thanh Toán");
		btn_thanhtoan_25.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/edit.png")));
		panel_zx_25.add(btn_thanhtoan_25);

		btn_capnhat_25 = new JButton("Cập Nhật");
		btn_capnhat_25.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/refresh.png")));
		panel_zx_25.add(btn_capnhat_25);
		panel_Show_HoaDon_Table_25 = new JPanel();
		panel_dbf_25.add(panel_Show_HoaDon_Table_25, BorderLayout.CENTER);
		table_25 = new JTable();

		columnames_25.add(" ID MH ");
		columnames_25.add(" Tên Mặt Hàng ");
		columnames_25.add(" Số Lượng ");
		columnames_25.add(" ĐVT ");
		columnames_25.add(" Giá ");
		columnames_25.add(" Thành Tiền ");

		// ++++++Set du lieu cho bang
		datamodel_25 = new DefaultTableModel(record_25, columnames_25);
		table_25.setModel(datamodel_25);

		// ++++++dieu chinh kich co cua bang
		table_25.setPreferredScrollableViewportSize(new Dimension(600, 250));
		table_25.setFillsViewportHeight(true);

		// ++++++them thanh cuon cho bang
		// ======================================================
		JScrollPane scroll_25 = new JScrollPane(table_25);
		// ======================================================

		scroll_25 = new JScrollPane(table_25,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		// Table.adjustColumnPreferredWidths(table);
		table_25.revalidate();
		panel_Show_HoaDon_Table_25.add(scroll_25);

		// End Panel Table Hoá Đơn ====================================
		// Bàn_25:======================================================
		// Bàn_26:======================
		panel_theotungban_26 = new JPanel();
		panel_theotungban_26.setBorder(new TitledBorder(new LineBorder(
				new Color(255, 200, 0), 1, true),
				"Th\u00F4ng tin ho\u00E1 \u0111\u01A1n: ",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		// SplitPanel_Right.add(panel_theotungban_26, BorderLayout.CENTER);
		panel_theotungban_26.setLayout(new BorderLayout(0, 0));

		panel_abc_26 = new JPanel();
		panel_theotungban_26.add(panel_abc_26, BorderLayout.NORTH);
		panel_abc_26.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		lblSBn = new JLabel("  Số bàn:  ");
		panel_abc_26.add(lblSBn);

		tf_soban_26 = new JTextField();
		panel_abc_26.add(tf_soban_26);
		tf_soban_26.setColumns(10);

		lblNgyNhp = new JLabel("     Ngày nhập: ");
		panel_abc_26.add(lblNgyNhp);
		// =============================================================
		GridBagConstraints gbc_datePicker_26 = new GridBagConstraints();
		// =============================================================
		model = new UtilDateModel();
		datePanel = new JDatePanelImpl(model);
		datePicker_26 = new JDatePickerImpl(datePanel);
		datePicker_26.getJFormattedTextField()
				.setToolTipText("Click chọn ngày");
		datePicker_26.getJFormattedTextField().setText(ChecNgay.now1());
		gbc_datePicker_26.gridx = 1;
		gbc_datePicker_26.gridy = 3;
		gbc_datePicker_26.insets = new Insets(0, 0, 15, 5);
		gbc_datePicker_26.anchor = GridBagConstraints.WEST;

		panel_abc_26.add(datePicker_26, gbc_datePicker_26);

		lblMKh = new JLabel("   Mã KH: ");
		panel_abc_26.add(lblMKh);

		tf_maKH_HD_26 = new JTextField();
		panel_abc_26.add(tf_maKH_HD_26);
		tf_maKH_HD_26.setColumns(5);

		panel_acc_26 = new JPanel();
		panel_acc_26.setBorder(new TitledBorder(new LineBorder(new Color(255,
				200, 0), 1, true),
				"Chi ti\u1EBFt c\u00E1c MH \u0111\u00E3 ch\u1ECDn: ",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, null));
		panel_theotungban_26.add(panel_acc_26, BorderLayout.CENTER);
		panel_acc_26.setLayout(new BorderLayout(0, 0));

		panel_addc_26 = new JPanel();
		panel_acc_26.add(panel_addc_26, BorderLayout.NORTH);
		panel_addc_26.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btn_tang_26 = new JButton(" Tăng");
		btn_tang_26.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/new.png")));
		panel_addc_26.add(btn_tang_26);

		btn_giam_26 = new JButton(" Giảm");
		btn_giam_26.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/giam.png")));
		panel_addc_26.add(btn_giam_26);

		btn_sl_macdinh_26 = new JButton("Đặt SL Mặc Định");
		btn_sl_macdinh_26.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/refresh.png")));
		panel_addc_26.add(btn_sl_macdinh_26);

		btn_ghichu_26 = new JButton("Ghi Chú");
		btn_ghichu_26.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/ghichunote.png")));
		panel_addc_26.add(btn_ghichu_26);

		panel_dbf_26 = new JPanel();
		panel_dbf_26.setBorder(new LineBorder(Color.ORANGE, 1, true));
		panel_acc_26.add(panel_dbf_26, BorderLayout.CENTER);
		panel_dbf_26.setLayout(new BorderLayout(0, 0));

		panel_zx_26 = new JPanel();
		panel_zx_26.setBorder(new TitledBorder(new LineBorder(new Color(255,
				200, 0), 1, true), "Ch\u1EE9c n\u0103ng: ",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_dbf_26.add(panel_zx_26, BorderLayout.SOUTH);
		panel_zx_26.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btn_thanhtoan_26 = new JButton("Thanh Toán");
		btn_thanhtoan_26.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/edit.png")));
		panel_zx_26.add(btn_thanhtoan_26);

		btn_capnhat_26 = new JButton("Cập Nhật");
		btn_capnhat_26.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/refresh.png")));
		panel_zx_26.add(btn_capnhat_26);
		panel_Show_HoaDon_Table_26 = new JPanel();
		panel_dbf_26.add(panel_Show_HoaDon_Table_26, BorderLayout.CENTER);
		table_26 = new JTable();

		columnames_26.add(" ID MH ");
		columnames_26.add(" Tên Mặt Hàng ");
		columnames_26.add(" Số Lượng ");
		columnames_26.add(" ĐVT ");
		columnames_26.add(" Giá ");
		columnames_26.add(" Thành Tiền ");

		// ++++++Set du lieu cho bang
		datamodel_26 = new DefaultTableModel(record_26, columnames_26);
		table_26.setModel(datamodel_26);

		// ++++++dieu chinh kich co cua bang
		table_26.setPreferredScrollableViewportSize(new Dimension(600, 250));
		table_26.setFillsViewportHeight(true);

		// ++++++them thanh cuon cho bang
		// ======================================================
		JScrollPane scroll_26 = new JScrollPane(table_26);
		// ======================================================

		scroll_26 = new JScrollPane(table_26,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		// Table.adjustColumnPreferredWidths(table);
		table_26.revalidate();
		panel_Show_HoaDon_Table_26.add(scroll_26);

		// End Panel Table Hoá Đơn ====================================
		// Bàn_26:======================================================
		// Bàn_27:======================
		panel_theotungban_27 = new JPanel();
		panel_theotungban_27.setBorder(new TitledBorder(new LineBorder(
				new Color(255, 200, 0), 1, true),
				"Th\u00F4ng tin ho\u00E1 \u0111\u01A1n: ",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		// SplitPanel_Right.add(panel_theotungban_27, BorderLayout.CENTER);
		panel_theotungban_27.setLayout(new BorderLayout(0, 0));

		panel_abc_27 = new JPanel();
		panel_theotungban_27.add(panel_abc_27, BorderLayout.NORTH);
		panel_abc_27.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		lblSBn = new JLabel("  Số bàn:  ");
		panel_abc_27.add(lblSBn);

		tf_soban_27 = new JTextField();
		panel_abc_27.add(tf_soban_27);
		tf_soban_27.setColumns(10);

		lblNgyNhp = new JLabel("     Ngày nhập: ");
		panel_abc_27.add(lblNgyNhp);
		// =============================================================
		GridBagConstraints gbc_datePicker_27 = new GridBagConstraints();
		// =============================================================
		model = new UtilDateModel();
		datePanel = new JDatePanelImpl(model);
		datePicker_27 = new JDatePickerImpl(datePanel);
		datePicker_27.getJFormattedTextField()
				.setToolTipText("Click chọn ngày");
		datePicker_27.getJFormattedTextField().setText(ChecNgay.now1());
		gbc_datePicker_27.gridx = 1;
		gbc_datePicker_27.gridy = 3;
		gbc_datePicker_27.insets = new Insets(0, 0, 15, 5);
		gbc_datePicker_27.anchor = GridBagConstraints.WEST;

		panel_abc_27.add(datePicker_27, gbc_datePicker_27);

		lblMKh = new JLabel("   Mã KH: ");
		panel_abc_27.add(lblMKh);

		tf_maKH_HD_27 = new JTextField();
		panel_abc_27.add(tf_maKH_HD_27);
		tf_maKH_HD_27.setColumns(5);

		panel_acc_27 = new JPanel();
		panel_acc_27.setBorder(new TitledBorder(new LineBorder(new Color(255,
				200, 0), 1, true),
				"Chi ti\u1EBFt c\u00E1c MH \u0111\u00E3 ch\u1ECDn: ",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, null));
		panel_theotungban_27.add(panel_acc_27, BorderLayout.CENTER);
		panel_acc_27.setLayout(new BorderLayout(0, 0));

		panel_addc_27 = new JPanel();
		panel_acc_27.add(panel_addc_27, BorderLayout.NORTH);
		panel_addc_27.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btn_tang_27 = new JButton(" Tăng");
		btn_tang_27.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/new.png")));
		panel_addc_27.add(btn_tang_27);

		btn_giam_27 = new JButton(" Giảm");
		btn_giam_27.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/giam.png")));
		panel_addc_27.add(btn_giam_27);

		btn_sl_macdinh_27 = new JButton("Đặt SL Mặc Định");
		btn_sl_macdinh_27.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/refresh.png")));
		panel_addc_27.add(btn_sl_macdinh_27);

		btn_ghichu_27 = new JButton("Ghi Chú");
		btn_ghichu_27.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/ghichunote.png")));
		panel_addc_27.add(btn_ghichu_27);

		panel_dbf_27 = new JPanel();
		panel_dbf_27.setBorder(new LineBorder(Color.ORANGE, 1, true));
		panel_acc_27.add(panel_dbf_27, BorderLayout.CENTER);
		panel_dbf_27.setLayout(new BorderLayout(0, 0));

		panel_zx_27 = new JPanel();
		panel_zx_27.setBorder(new TitledBorder(new LineBorder(new Color(255,
				200, 0), 1, true), "Ch\u1EE9c n\u0103ng: ",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_dbf_27.add(panel_zx_27, BorderLayout.SOUTH);
		panel_zx_27.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btn_thanhtoan_27 = new JButton("Thanh Toán");
		btn_thanhtoan_27.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/edit.png")));
		panel_zx_27.add(btn_thanhtoan_27);

		btn_capnhat_27 = new JButton("Cập Nhật");
		btn_capnhat_27.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/refresh.png")));
		panel_zx_27.add(btn_capnhat_27);
		panel_Show_HoaDon_Table_27 = new JPanel();
		panel_dbf_27.add(panel_Show_HoaDon_Table_27, BorderLayout.CENTER);
		table_27 = new JTable();

		columnames_27.add(" ID MH ");
		columnames_27.add(" Tên Mặt Hàng ");
		columnames_27.add(" Số Lượng ");
		columnames_27.add(" ĐVT ");
		columnames_27.add(" Giá ");
		columnames_27.add(" Thành Tiền ");

		// ++++++Set du lieu cho bang
		datamodel_27 = new DefaultTableModel(record_27, columnames_27);
		table_27.setModel(datamodel_27);

		// ++++++dieu chinh kich co cua bang
		table_27.setPreferredScrollableViewportSize(new Dimension(600, 250));
		table_27.setFillsViewportHeight(true);

		// ++++++them thanh cuon cho bang
		// ======================================================
		JScrollPane scroll_27 = new JScrollPane(table_27);
		// ======================================================

		scroll_27 = new JScrollPane(table_27,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		// Table.adjustColumnPreferredWidths(table);
		table_27.revalidate();
		panel_Show_HoaDon_Table_27.add(scroll_27);

		// End Panel Table Hoá Đơn ====================================
		// Bàn_27:======================================================
		// Bàn_28:======================
		panel_theotungban_28 = new JPanel();
		panel_theotungban_28.setBorder(new TitledBorder(new LineBorder(
				new Color(255, 200, 0), 1, true),
				"Th\u00F4ng tin ho\u00E1 \u0111\u01A1n: ",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		// SplitPanel_Right.add(panel_theotungban_28, BorderLayout.CENTER);
		panel_theotungban_28.setLayout(new BorderLayout(0, 0));

		panel_abc_28 = new JPanel();
		panel_theotungban_28.add(panel_abc_28, BorderLayout.NORTH);
		panel_abc_28.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		lblSBn = new JLabel("  Số bàn:  ");
		panel_abc_28.add(lblSBn);

		tf_soban_28 = new JTextField();
		panel_abc_28.add(tf_soban_28);
		tf_soban_28.setColumns(10);

		lblNgyNhp = new JLabel("     Ngày nhập: ");
		panel_abc_28.add(lblNgyNhp);
		// =============================================================
		GridBagConstraints gbc_datePicker_28 = new GridBagConstraints();
		// =============================================================
		model = new UtilDateModel();
		datePanel = new JDatePanelImpl(model);
		datePicker_28 = new JDatePickerImpl(datePanel);
		datePicker_28.getJFormattedTextField()
				.setToolTipText("Click chọn ngày");
		datePicker_28.getJFormattedTextField().setText(ChecNgay.now1());
		gbc_datePicker_28.gridx = 1;
		gbc_datePicker_28.gridy = 3;
		gbc_datePicker_28.insets = new Insets(0, 0, 15, 5);
		gbc_datePicker_28.anchor = GridBagConstraints.WEST;

		panel_abc_28.add(datePicker_28, gbc_datePicker_28);

		lblMKh = new JLabel("   Mã KH: ");
		panel_abc_28.add(lblMKh);

		tf_maKH_HD_28 = new JTextField();
		panel_abc_28.add(tf_maKH_HD_28);
		tf_maKH_HD_28.setColumns(5);

		panel_acc_28 = new JPanel();
		panel_acc_28.setBorder(new TitledBorder(new LineBorder(new Color(255,
				200, 0), 1, true),
				"Chi ti\u1EBFt c\u00E1c MH \u0111\u00E3 ch\u1ECDn: ",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, null));
		panel_theotungban_28.add(panel_acc_28, BorderLayout.CENTER);
		panel_acc_28.setLayout(new BorderLayout(0, 0));

		panel_addc_28 = new JPanel();
		panel_acc_28.add(panel_addc_28, BorderLayout.NORTH);
		panel_addc_28.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btn_tang_28 = new JButton(" Tăng");
		btn_tang_28.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/new.png")));
		panel_addc_28.add(btn_tang_28);

		btn_giam_28 = new JButton(" Giảm");
		btn_giam_28.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/giam.png")));
		panel_addc_28.add(btn_giam_28);

		btn_sl_macdinh_28 = new JButton("Đặt SL Mặc Định");
		btn_sl_macdinh_28.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/refresh.png")));
		panel_addc_28.add(btn_sl_macdinh_28);

		btn_ghichu_28 = new JButton("Ghi Chú");
		btn_ghichu_28.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/ghichunote.png")));
		panel_addc_28.add(btn_ghichu_28);

		panel_dbf_28 = new JPanel();
		panel_dbf_28.setBorder(new LineBorder(Color.ORANGE, 1, true));
		panel_acc_28.add(panel_dbf_28, BorderLayout.CENTER);
		panel_dbf_28.setLayout(new BorderLayout(0, 0));

		panel_zx_28 = new JPanel();
		panel_zx_28.setBorder(new TitledBorder(new LineBorder(new Color(255,
				200, 0), 1, true), "Ch\u1EE9c n\u0103ng: ",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_dbf_28.add(panel_zx_28, BorderLayout.SOUTH);
		panel_zx_28.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btn_thanhtoan_28 = new JButton("Thanh Toán");
		btn_thanhtoan_28.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/edit.png")));
		panel_zx_28.add(btn_thanhtoan_28);

		btn_capnhat_28 = new JButton("Cập Nhật");
		btn_capnhat_28.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/refresh.png")));
		panel_zx_28.add(btn_capnhat_28);
		panel_Show_HoaDon_Table_28 = new JPanel();
		panel_dbf_28.add(panel_Show_HoaDon_Table_28, BorderLayout.CENTER);
		table_28 = new JTable();

		columnames_28.add(" ID MH ");
		columnames_28.add(" Tên Mặt Hàng ");
		columnames_28.add(" Số Lượng ");
		columnames_28.add(" ĐVT ");
		columnames_28.add(" Giá ");
		columnames_28.add(" Thành Tiền ");

		// ++++++Set du lieu cho bang
		datamodel_28 = new DefaultTableModel(record_28, columnames_28);
		table_28.setModel(datamodel_28);

		// ++++++dieu chinh kich co cua bang
		table_28.setPreferredScrollableViewportSize(new Dimension(600, 250));
		table_28.setFillsViewportHeight(true);

		// ++++++them thanh cuon cho bang
		// ======================================================
		JScrollPane scroll_28 = new JScrollPane(table_28);
		// ======================================================

		scroll_28 = new JScrollPane(table_28,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		// Table.adjustColumnPreferredWidths(table);
		table_28.revalidate();
		panel_Show_HoaDon_Table_28.add(scroll_28);

		// End Panel Table Hoá Đơn ====================================
		// Bàn_28:======================================================
		// Bàn_29:======================
		panel_theotungban_29 = new JPanel();
		panel_theotungban_29.setBorder(new TitledBorder(new LineBorder(
				new Color(255, 200, 0), 1, true),
				"Th\u00F4ng tin ho\u00E1 \u0111\u01A1n: ",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		// SplitPanel_Right.add(panel_theotungban_29, BorderLayout.CENTER);
		panel_theotungban_29.setLayout(new BorderLayout(0, 0));

		panel_abc_29 = new JPanel();
		panel_theotungban_29.add(panel_abc_29, BorderLayout.NORTH);
		panel_abc_29.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		lblSBn = new JLabel("  Số bàn:  ");
		panel_abc_29.add(lblSBn);

		tf_soban_29 = new JTextField();
		panel_abc_29.add(tf_soban_29);
		tf_soban_29.setColumns(10);

		lblNgyNhp = new JLabel("     Ngày nhập: ");
		panel_abc_29.add(lblNgyNhp);
		// =============================================================
		GridBagConstraints gbc_datePicker_29 = new GridBagConstraints();
		// =============================================================
		model = new UtilDateModel();
		datePanel = new JDatePanelImpl(model);
		datePicker_29 = new JDatePickerImpl(datePanel);
		datePicker_29.getJFormattedTextField()
				.setToolTipText("Click chọn ngày");
		datePicker_29.getJFormattedTextField().setText(ChecNgay.now1());
		gbc_datePicker_29.gridx = 1;
		gbc_datePicker_29.gridy = 3;
		gbc_datePicker_29.insets = new Insets(0, 0, 15, 5);
		gbc_datePicker_29.anchor = GridBagConstraints.WEST;

		panel_abc_29.add(datePicker_29, gbc_datePicker_29);

		lblMKh = new JLabel("   Mã KH: ");
		panel_abc_29.add(lblMKh);

		tf_maKH_HD_29 = new JTextField();
		panel_abc_29.add(tf_maKH_HD_29);
		tf_maKH_HD_29.setColumns(5);

		panel_acc_29 = new JPanel();
		panel_acc_29.setBorder(new TitledBorder(new LineBorder(new Color(255,
				200, 0), 1, true),
				"Chi ti\u1EBFt c\u00E1c MH \u0111\u00E3 ch\u1ECDn: ",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, null));
		panel_theotungban_29.add(panel_acc_29, BorderLayout.CENTER);
		panel_acc_29.setLayout(new BorderLayout(0, 0));

		panel_addc_29 = new JPanel();
		panel_acc_29.add(panel_addc_29, BorderLayout.NORTH);
		panel_addc_29.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btn_tang_29 = new JButton(" Tăng");
		btn_tang_29.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/new.png")));
		panel_addc_29.add(btn_tang_29);

		btn_giam_29 = new JButton(" Giảm");
		btn_giam_29.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/giam.png")));
		panel_addc_29.add(btn_giam_29);

		btn_sl_macdinh_29 = new JButton("Đặt SL Mặc Định");
		btn_sl_macdinh_29.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/refresh.png")));
		panel_addc_29.add(btn_sl_macdinh_29);

		btn_ghichu_29 = new JButton("Ghi Chú");
		btn_ghichu_29.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/ghichunote.png")));
		panel_addc_29.add(btn_ghichu_29);

		panel_dbf_29 = new JPanel();
		panel_dbf_29.setBorder(new LineBorder(Color.ORANGE, 1, true));
		panel_acc_29.add(panel_dbf_29, BorderLayout.CENTER);
		panel_dbf_29.setLayout(new BorderLayout(0, 0));

		panel_zx_29 = new JPanel();
		panel_zx_29.setBorder(new TitledBorder(new LineBorder(new Color(255,
				200, 0), 1, true), "Ch\u1EE9c n\u0103ng: ",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_dbf_29.add(panel_zx_29, BorderLayout.SOUTH);
		panel_zx_29.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btn_thanhtoan_29 = new JButton("Thanh Toán");
		btn_thanhtoan_29.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/edit.png")));
		panel_zx_29.add(btn_thanhtoan_29);

		btn_capnhat_29 = new JButton("Cập Nhật");
		btn_capnhat_29.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/refresh.png")));
		panel_zx_29.add(btn_capnhat_29);
		panel_Show_HoaDon_Table_29 = new JPanel();
		panel_dbf_29.add(panel_Show_HoaDon_Table_29, BorderLayout.CENTER);
		table_29 = new JTable();

		columnames_29.add(" ID MH ");
		columnames_29.add(" Tên Mặt Hàng ");
		columnames_29.add(" Số Lượng ");
		columnames_29.add(" ĐVT ");
		columnames_29.add(" Giá ");
		columnames_29.add(" Thành Tiền ");

		// ++++++Set du lieu cho bang
		datamodel_29 = new DefaultTableModel(record_29, columnames_29);
		table_29.setModel(datamodel_29);

		// ++++++dieu chinh kich co cua bang
		table_29.setPreferredScrollableViewportSize(new Dimension(600, 250));
		table_29.setFillsViewportHeight(true);

		// ++++++them thanh cuon cho bang
		// ======================================================
		JScrollPane scroll_29 = new JScrollPane(table_29);
		// ======================================================

		scroll_29 = new JScrollPane(table_29,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		// Table.adjustColumnPreferredWidths(table);
		table_29.revalidate();
		panel_Show_HoaDon_Table_29.add(scroll_29);

		// End Panel Table Hoá Đơn ====================================
		// Bàn_29:======================================================
		// Bàn_30:======================
		panel_theotungban_30 = new JPanel();
		panel_theotungban_30.setBorder(new TitledBorder(new LineBorder(
				new Color(255, 200, 0), 1, true),
				"Th\u00F4ng tin ho\u00E1 \u0111\u01A1n: ",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		// SplitPanel_Right.add(panel_theotungban_30, BorderLayout.CENTER);
		panel_theotungban_30.setLayout(new BorderLayout(0, 0));

		panel_abc_30 = new JPanel();
		panel_theotungban_30.add(panel_abc_30, BorderLayout.NORTH);
		panel_abc_30.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		lblSBn = new JLabel("  Số bàn:  ");
		panel_abc_30.add(lblSBn);

		tf_soban_30 = new JTextField();
		panel_abc_30.add(tf_soban_30);
		tf_soban_30.setColumns(10);

		lblNgyNhp = new JLabel("     Ngày nhập: ");
		panel_abc_30.add(lblNgyNhp);
		// =============================================================
		GridBagConstraints gbc_datePicker_30 = new GridBagConstraints();
		// =============================================================
		model = new UtilDateModel();
		datePanel = new JDatePanelImpl(model);
		datePicker_30 = new JDatePickerImpl(datePanel);
		datePicker_30.getJFormattedTextField()
				.setToolTipText("Click chọn ngày");
		datePicker_30.getJFormattedTextField().setText(ChecNgay.now1());
		gbc_datePicker_30.gridx = 1;
		gbc_datePicker_30.gridy = 3;
		gbc_datePicker_30.insets = new Insets(0, 0, 15, 5);
		gbc_datePicker_30.anchor = GridBagConstraints.WEST;

		panel_abc_30.add(datePicker_30, gbc_datePicker_30);

		lblMKh = new JLabel("   Mã KH: ");
		panel_abc_30.add(lblMKh);

		tf_maKH_HD_30 = new JTextField();
		panel_abc_30.add(tf_maKH_HD_30);
		tf_maKH_HD_30.setColumns(5);

		panel_acc_30 = new JPanel();
		panel_acc_30.setBorder(new TitledBorder(new LineBorder(new Color(255,
				200, 0), 1, true),
				"Chi ti\u1EBFt c\u00E1c MH \u0111\u00E3 ch\u1ECDn: ",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, null));
		panel_theotungban_30.add(panel_acc_30, BorderLayout.CENTER);
		panel_acc_30.setLayout(new BorderLayout(0, 0));

		panel_addc_30 = new JPanel();
		panel_acc_30.add(panel_addc_30, BorderLayout.NORTH);
		panel_addc_30.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btn_tang_30 = new JButton(" Tăng");
		btn_tang_30.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/new.png")));
		panel_addc_30.add(btn_tang_30);

		btn_giam_30 = new JButton(" Giảm");
		btn_giam_30.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/giam.png")));
		panel_addc_30.add(btn_giam_30);

		btn_sl_macdinh_30 = new JButton("Đặt SL Mặc Định");
		btn_sl_macdinh_30.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/refresh.png")));
		panel_addc_30.add(btn_sl_macdinh_30);

		btn_ghichu_30 = new JButton("Ghi Chú");
		btn_ghichu_30.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/ghichunote.png")));
		panel_addc_30.add(btn_ghichu_30);

		panel_dbf_30 = new JPanel();
		panel_dbf_30.setBorder(new LineBorder(Color.ORANGE, 1, true));
		panel_acc_30.add(panel_dbf_30, BorderLayout.CENTER);
		panel_dbf_30.setLayout(new BorderLayout(0, 0));

		panel_zx_30 = new JPanel();
		panel_zx_30.setBorder(new TitledBorder(new LineBorder(new Color(255,
				200, 0), 1, true), "Ch\u1EE9c n\u0103ng: ",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_dbf_30.add(panel_zx_30, BorderLayout.SOUTH);
		panel_zx_30.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btn_thanhtoan_30 = new JButton("Thanh Toán");
		btn_thanhtoan_30.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/edit.png")));
		panel_zx_30.add(btn_thanhtoan_30);

		btn_capnhat_30 = new JButton("Cập Nhật");
		btn_capnhat_30.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/refresh.png")));
		panel_zx_30.add(btn_capnhat_30);
		panel_Show_HoaDon_Table_30 = new JPanel();
		panel_dbf_30.add(panel_Show_HoaDon_Table_30, BorderLayout.CENTER);
		table_30 = new JTable();

		columnames_30.add(" ID MH ");
		columnames_30.add(" Tên Mặt Hàng ");
		columnames_30.add(" Số Lượng ");
		columnames_30.add(" ĐVT ");
		columnames_30.add(" Giá ");
		columnames_30.add(" Thành Tiền ");

		// ++++++Set du lieu cho bang
		datamodel_30 = new DefaultTableModel(record_30, columnames_30);
		table_30.setModel(datamodel_30);

		// ++++++dieu chinh kich co cua bang
		table_30.setPreferredScrollableViewportSize(new Dimension(600, 250));
		table_30.setFillsViewportHeight(true);

		// ++++++them thanh cuon cho bang
		// ======================================================
		JScrollPane scroll_30 = new JScrollPane(table_30);
		// ======================================================

		scroll_30 = new JScrollPane(table_30,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		// Table.adjustColumnPreferredWidths(table);
		table_30.revalidate();
		panel_Show_HoaDon_Table_30.add(scroll_30);

		// End Panel Table Hoá Đơn ====================================
		// Bàn_30:======================================================
		// Bàn_31:======================
		panel_theotungban_31 = new JPanel();
		panel_theotungban_31.setBorder(new TitledBorder(new LineBorder(
				new Color(255, 200, 0), 1, true),
				"Th\u00F4ng tin ho\u00E1 \u0111\u01A1n: ",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		// SplitPanel_Right.add(panel_theotungban_31, BorderLayout.CENTER);
		panel_theotungban_31.setLayout(new BorderLayout(0, 0));

		panel_abc_31 = new JPanel();
		panel_theotungban_31.add(panel_abc_31, BorderLayout.NORTH);
		panel_abc_31.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		lblSBn = new JLabel("  Số bàn:  ");
		panel_abc_31.add(lblSBn);

		tf_soban_31 = new JTextField();
		panel_abc_31.add(tf_soban_31);
		tf_soban_31.setColumns(10);

		lblNgyNhp = new JLabel("     Ngày nhập: ");
		panel_abc_31.add(lblNgyNhp);
		// =============================================================
		GridBagConstraints gbc_datePicker_31 = new GridBagConstraints();
		// =============================================================
		model = new UtilDateModel();
		datePanel = new JDatePanelImpl(model);
		datePicker_31 = new JDatePickerImpl(datePanel);
		datePicker_31.getJFormattedTextField()
				.setToolTipText("Click chọn ngày");
		datePicker_31.getJFormattedTextField().setText(ChecNgay.now1());
		gbc_datePicker_31.gridx = 1;
		gbc_datePicker_31.gridy = 3;
		gbc_datePicker_31.insets = new Insets(0, 0, 15, 5);
		gbc_datePicker_31.anchor = GridBagConstraints.WEST;

		panel_abc_31.add(datePicker_31, gbc_datePicker_31);

		lblMKh = new JLabel("   Mã KH: ");
		panel_abc_31.add(lblMKh);

		tf_maKH_HD_31 = new JTextField();
		panel_abc_31.add(tf_maKH_HD_31);
		tf_maKH_HD_31.setColumns(5);

		panel_acc_31 = new JPanel();
		panel_acc_31.setBorder(new TitledBorder(new LineBorder(new Color(255,
				200, 0), 1, true),
				"Chi ti\u1EBFt c\u00E1c MH \u0111\u00E3 ch\u1ECDn: ",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, null));
		panel_theotungban_31.add(panel_acc_31, BorderLayout.CENTER);
		panel_acc_31.setLayout(new BorderLayout(0, 0));

		panel_addc_31 = new JPanel();
		panel_acc_31.add(panel_addc_31, BorderLayout.NORTH);
		panel_addc_31.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btn_tang_31 = new JButton(" Tăng");
		btn_tang_31.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/new.png")));
		panel_addc_31.add(btn_tang_31);

		btn_giam_31 = new JButton(" Giảm");
		btn_giam_31.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/giam.png")));
		panel_addc_31.add(btn_giam_31);

		btn_sl_macdinh_31 = new JButton("Đặt SL Mặc Định");
		btn_sl_macdinh_31.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/refresh.png")));
		panel_addc_31.add(btn_sl_macdinh_31);

		btn_ghichu_31 = new JButton("Ghi Chú");
		btn_ghichu_31.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/ghichunote.png")));
		panel_addc_31.add(btn_ghichu_31);

		panel_dbf_31 = new JPanel();
		panel_dbf_31.setBorder(new LineBorder(Color.ORANGE, 1, true));
		panel_acc_31.add(panel_dbf_31, BorderLayout.CENTER);
		panel_dbf_31.setLayout(new BorderLayout(0, 0));

		panel_zx_31 = new JPanel();
		panel_zx_31.setBorder(new TitledBorder(new LineBorder(new Color(255,
				200, 0), 1, true), "Ch\u1EE9c n\u0103ng: ",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_dbf_31.add(panel_zx_31, BorderLayout.SOUTH);
		panel_zx_31.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btn_thanhtoan_31 = new JButton("Thanh Toán");
		btn_thanhtoan_31.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/edit.png")));
		panel_zx_31.add(btn_thanhtoan_31);

		btn_capnhat_31 = new JButton("Cập Nhật");
		btn_capnhat_31.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/refresh.png")));
		panel_zx_31.add(btn_capnhat_31);
		panel_Show_HoaDon_Table_31 = new JPanel();
		panel_dbf_31.add(panel_Show_HoaDon_Table_31, BorderLayout.CENTER);
		table_31 = new JTable();

		columnames_31.add(" ID MH ");
		columnames_31.add(" Tên Mặt Hàng ");
		columnames_31.add(" Số Lượng ");
		columnames_31.add(" ĐVT ");
		columnames_31.add(" Giá ");
		columnames_31.add(" Thành Tiền ");

		// ++++++Set du lieu cho bang
		datamodel_31 = new DefaultTableModel(record_31, columnames_31);
		table_31.setModel(datamodel_31);

		// ++++++dieu chinh kich co cua bang
		table_31.setPreferredScrollableViewportSize(new Dimension(600, 250));
		table_31.setFillsViewportHeight(true);

		// ++++++them thanh cuon cho bang
		// ======================================================
		JScrollPane scroll_31 = new JScrollPane(table_31);
		// ======================================================

		scroll_31 = new JScrollPane(table_31,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		// Table.adjustColumnPreferredWidths(table);
		table_31.revalidate();
		panel_Show_HoaDon_Table_31.add(scroll_31);

		// End Panel Table Hoá Đơn ====================================
		// Bàn_31:======================================================
		// Bàn_32:======================
		panel_theotungban_32 = new JPanel();
		panel_theotungban_32.setBorder(new TitledBorder(new LineBorder(
				new Color(255, 200, 0), 1, true),
				"Th\u00F4ng tin ho\u00E1 \u0111\u01A1n: ",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		// SplitPanel_Right.add(panel_theotungban_32, BorderLayout.CENTER);
		panel_theotungban_32.setLayout(new BorderLayout(0, 0));

		panel_abc_32 = new JPanel();
		panel_theotungban_32.add(panel_abc_32, BorderLayout.NORTH);
		panel_abc_32.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		lblSBn = new JLabel("  Số bàn:  ");
		panel_abc_32.add(lblSBn);

		tf_soban_32 = new JTextField();
		panel_abc_32.add(tf_soban_32);
		tf_soban_32.setColumns(10);

		lblNgyNhp = new JLabel("     Ngày nhập: ");
		panel_abc_32.add(lblNgyNhp);
		// =============================================================
		GridBagConstraints gbc_datePicker_32 = new GridBagConstraints();
		// =============================================================
		model = new UtilDateModel();
		datePanel = new JDatePanelImpl(model);
		datePicker_32 = new JDatePickerImpl(datePanel);
		datePicker_32.getJFormattedTextField()
				.setToolTipText("Click chọn ngày");
		datePicker_32.getJFormattedTextField().setText(ChecNgay.now1());
		gbc_datePicker_32.gridx = 1;
		gbc_datePicker_32.gridy = 3;
		gbc_datePicker_32.insets = new Insets(0, 0, 15, 5);
		gbc_datePicker_32.anchor = GridBagConstraints.WEST;

		panel_abc_32.add(datePicker_32, gbc_datePicker_32);

		lblMKh = new JLabel("   Mã KH: ");
		panel_abc_32.add(lblMKh);

		tf_maKH_HD_32 = new JTextField();
		panel_abc_32.add(tf_maKH_HD_32);
		tf_maKH_HD_32.setColumns(5);

		panel_acc_32 = new JPanel();
		panel_acc_32.setBorder(new TitledBorder(new LineBorder(new Color(255,
				200, 0), 1, true),
				"Chi ti\u1EBFt c\u00E1c MH \u0111\u00E3 ch\u1ECDn: ",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, null));
		panel_theotungban_32.add(panel_acc_32, BorderLayout.CENTER);
		panel_acc_32.setLayout(new BorderLayout(0, 0));

		panel_addc_32 = new JPanel();
		panel_acc_32.add(panel_addc_32, BorderLayout.NORTH);
		panel_addc_32.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btn_tang_32 = new JButton(" Tăng");
		btn_tang_32.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/new.png")));
		panel_addc_32.add(btn_tang_32);

		btn_giam_32 = new JButton(" Giảm");
		btn_giam_32.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/giam.png")));
		panel_addc_32.add(btn_giam_32);

		btn_sl_macdinh_32 = new JButton("Đặt SL Mặc Định");
		btn_sl_macdinh_32.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/refresh.png")));
		panel_addc_32.add(btn_sl_macdinh_32);

		btn_ghichu_32 = new JButton("Ghi Chú");
		btn_ghichu_32.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/ghichunote.png")));
		panel_addc_32.add(btn_ghichu_32);

		panel_dbf_32 = new JPanel();
		panel_dbf_32.setBorder(new LineBorder(Color.ORANGE, 1, true));
		panel_acc_32.add(panel_dbf_32, BorderLayout.CENTER);
		panel_dbf_32.setLayout(new BorderLayout(0, 0));

		panel_zx_32 = new JPanel();
		panel_zx_32.setBorder(new TitledBorder(new LineBorder(new Color(255,
				200, 0), 1, true), "Ch\u1EE9c n\u0103ng: ",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_dbf_32.add(panel_zx_32, BorderLayout.SOUTH);
		panel_zx_32.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btn_thanhtoan_32 = new JButton("Thanh Toán");
		btn_thanhtoan_32.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/edit.png")));
		panel_zx_32.add(btn_thanhtoan_32);

		btn_capnhat_32 = new JButton("Cập Nhật");
		btn_capnhat_32.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/refresh.png")));
		panel_zx_32.add(btn_capnhat_32);
		panel_Show_HoaDon_Table_32 = new JPanel();
		panel_dbf_32.add(panel_Show_HoaDon_Table_32, BorderLayout.CENTER);
		table_32 = new JTable();

		columnames_32.add(" ID MH ");
		columnames_32.add(" Tên Mặt Hàng ");
		columnames_32.add(" Số Lượng ");
		columnames_32.add(" ĐVT ");
		columnames_32.add(" Giá ");
		columnames_32.add(" Thành Tiền ");

		// ++++++Set du lieu cho bang
		datamodel_32 = new DefaultTableModel(record_32, columnames_32);
		table_32.setModel(datamodel_32);

		// ++++++dieu chinh kich co cua bang
		table_32.setPreferredScrollableViewportSize(new Dimension(600, 250));
		table_32.setFillsViewportHeight(true);

		// ++++++them thanh cuon cho bang
		// ======================================================
		JScrollPane scroll_32 = new JScrollPane(table_32);
		// ======================================================

		scroll_32 = new JScrollPane(table_32,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		// Table.adjustColumnPreferredWidths(table);
		table_32.revalidate();
		panel_Show_HoaDon_Table_32.add(scroll_32);

		// End Panel Table Hoá Đơn ====================================
		// Bàn_32:======================================================

		SplitPanel_Left.setLayout(new BorderLayout(50, 50));

		tpKhuVuc = new JTabbedPane();
		SplitPanel_Left.add(tpKhuVuc, BorderLayout.NORTH);

		splitPane.setPreferredSize(new Dimension(1022, 466));
		splitPane.setOneTouchExpandable(true);
		splitPane.setBorder(BorderFactory.createEtchedBorder());
		panel_Show_Table.add(splitPane);
		// Panel Tầng Trệt
		panel_tangtret = new JPanel();
		tpKhuVuc.addTab("Tầng trệt", null, panel_tangtret, null);
		GridBagLayout gbl_panel_tangtret = new GridBagLayout();
		gbl_panel_tangtret.columnWidths = new int[] { 99, 99, 99, 0 };
		gbl_panel_tangtret.rowHeights = new int[] { 55, 43, 55, 55, 0 };
		gbl_panel_tangtret.columnWeights = new double[] { 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_panel_tangtret.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		panel_tangtret.setLayout(gbl_panel_tangtret);

		bt_01 = new JButton("01");
		bt_01.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/image/coffee_dong.png")));
		GridBagConstraints gbc_bt_01 = new GridBagConstraints();
		gbc_bt_01.insets = new Insets(10, 10, 10, 10);
		gbc_bt_01.gridx = 0;
		gbc_bt_01.gridy = 0;
		panel_tangtret.add(bt_01, gbc_bt_01);

		bt_02 = new JButton("02");
		bt_02.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/image/coffee_dong.png")));
		GridBagConstraints gbc_bt_02 = new GridBagConstraints();
		gbc_bt_02.insets = new Insets(10, 10, 10, 10);
		gbc_bt_02.gridx = 1;
		gbc_bt_02.gridy = 0;
		panel_tangtret.add(bt_02, gbc_bt_02);

		bt_03 = new JButton("03");
		bt_03.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/image/coffee_dong.png")));
		GridBagConstraints gbc_bt_03 = new GridBagConstraints();
		gbc_bt_03.insets = new Insets(10, 10, 10, 10);
		gbc_bt_03.gridx = 2;
		gbc_bt_03.gridy = 0;
		panel_tangtret.add(bt_03, gbc_bt_03);

		bt_04 = new JButton("04");
		bt_04.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/image/coffee_dong.png")));
		GridBagConstraints gbc_bt_04 = new GridBagConstraints();
		gbc_bt_04.insets = new Insets(10, 10, 10, 10);
		gbc_bt_04.gridx = 0;
		gbc_bt_04.gridy = 1;
		panel_tangtret.add(bt_04, gbc_bt_04);

		bt_05 = new JButton("05");
		bt_05.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/image/coffee_dong.png")));
		GridBagConstraints gbc_bt_05 = new GridBagConstraints();
		gbc_bt_05.insets = new Insets(10, 10, 10, 10);
		gbc_bt_05.gridx = 1;
		gbc_bt_05.gridy = 1;
		panel_tangtret.add(bt_05, gbc_bt_05);

		bt_06 = new JButton("06");
		bt_06.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/image/coffee_dong.png")));
		GridBagConstraints gbc_bt_06 = new GridBagConstraints();
		gbc_bt_06.insets = new Insets(10, 10, 10, 10);
		gbc_bt_06.gridx = 2;
		gbc_bt_06.gridy = 1;
		panel_tangtret.add(bt_06, gbc_bt_06);

		bt_07 = new JButton("07");
		bt_07.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/image/coffee_dong.png")));
		GridBagConstraints gbc_bt_07 = new GridBagConstraints();
		gbc_bt_07.insets = new Insets(10, 10, 10, 10);
		gbc_bt_07.gridx = 0;
		gbc_bt_07.gridy = 2;
		panel_tangtret.add(bt_07, gbc_bt_07);

		bt_08 = new JButton("08");
		bt_08.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/image/coffee_dong.png")));
		GridBagConstraints gbc_bt_08 = new GridBagConstraints();
		gbc_bt_08.insets = new Insets(10, 10, 10, 10);
		gbc_bt_08.gridx = 1;
		gbc_bt_08.gridy = 2;
		panel_tangtret.add(bt_08, gbc_bt_08);

		bt_09 = new JButton("09");
		bt_09.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/image/coffee_dong.png")));
		GridBagConstraints gbc_bt_09 = new GridBagConstraints();
		gbc_bt_09.insets = new Insets(10, 10, 10, 10);
		gbc_bt_09.gridx = 2;
		gbc_bt_09.gridy = 2;
		panel_tangtret.add(bt_09, gbc_bt_09);

		bt_10 = new JButton("10");
		bt_10.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/image/coffee_dong.png")));
		GridBagConstraints gbc_bt_10 = new GridBagConstraints();
		gbc_bt_10.insets = new Insets(10, 10, 10, 10);
		gbc_bt_10.gridx = 0;
		gbc_bt_10.gridy = 3;
		panel_tangtret.add(bt_10, gbc_bt_10);

		bt_11 = new JButton("11");
		bt_11.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/image/coffee_dong.png")));
		GridBagConstraints gbc_bt_11 = new GridBagConstraints();
		gbc_bt_11.insets = new Insets(10, 10, 10, 10);
		gbc_bt_11.gridx = 1;
		gbc_bt_11.gridy = 3;
		panel_tangtret.add(bt_11, gbc_bt_11);

		bt_12 = new JButton("12");
		bt_12.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/image/coffee_dong.png")));
		GridBagConstraints gbc_bt_12 = new GridBagConstraints();
		gbc_bt_12.insets = new Insets(10, 10, 10, 10);
		gbc_bt_12.gridx = 2;
		gbc_bt_12.gridy = 3;
		panel_tangtret.add(bt_12, gbc_bt_12);

		// Panel Tầng 1
		panel_tang1 = new JPanel();
		tpKhuVuc.addTab("Tầng 1", null, panel_tang1, null);
		GridBagLayout gbl_panel_tang1 = new GridBagLayout();
		gbl_panel_tang1.columnWidths = new int[] { 99, 99, 99, 0 };
		gbl_panel_tang1.rowHeights = new int[] { 55, 43, 55, 55, 0 };
		gbl_panel_tang1.columnWeights = new double[] { 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_panel_tang1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		panel_tang1.setLayout(gbl_panel_tang1);

		bt100 = new JButton("11");
		bt100.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/image/coffee_dong.png")));

		GridBagConstraints gbc_bt100 = new GridBagConstraints();
		gbc_bt100.anchor = GridBagConstraints.BELOW_BASELINE;
		gbc_bt100.fill = GridBagConstraints.HORIZONTAL;
		gbc_bt100.insets = new Insets(10, 10, 10, 10);
		gbc_bt100.gridx = 0;
		gbc_bt100.gridy = 0;
		panel_tang1.add(bt100, gbc_bt100);

		bt101 = new JButton("12");
		bt101.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/image/coffee_dong.png")));
		GridBagConstraints gbc_bt101 = new GridBagConstraints();
		gbc_bt101.fill = GridBagConstraints.HORIZONTAL;
		gbc_bt101.insets = new Insets(10, 10, 10, 10);
		gbc_bt101.gridx = 1;
		gbc_bt101.gridy = 0;
		panel_tang1.add(bt101, gbc_bt101);

		bt102 = new JButton("13");
		bt102.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/image/coffee_dong.png")));
		GridBagConstraints gbc_bt102 = new GridBagConstraints();
		gbc_bt102.anchor = GridBagConstraints.BELOW_BASELINE;
		gbc_bt102.fill = GridBagConstraints.HORIZONTAL;
		gbc_bt102.insets = new Insets(10, 10, 10, 10);
		gbc_bt102.gridx = 2;
		gbc_bt102.gridy = 0;
		panel_tang1.add(bt102, gbc_bt102);

		bt103 = new JButton("14");
		bt103.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/image/coffee_dong.png")));
		GridBagConstraints gbc_bt103 = new GridBagConstraints();
		gbc_bt103.anchor = GridBagConstraints.NORTH;
		gbc_bt103.fill = GridBagConstraints.HORIZONTAL;
		gbc_bt103.insets = new Insets(10, 10, 10, 10);
		gbc_bt103.gridx = 0;
		gbc_bt103.gridy = 1;
		panel_tang1.add(bt103, gbc_bt103);

		bt104 = new JButton("15");
		bt104.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/image/coffee_dong.png")));
		GridBagConstraints gbc_bt104 = new GridBagConstraints();
		gbc_bt104.anchor = GridBagConstraints.NORTH;
		gbc_bt104.fill = GridBagConstraints.HORIZONTAL;
		gbc_bt104.insets = new Insets(10, 10, 10, 10);
		gbc_bt104.gridx = 1;
		gbc_bt104.gridy = 1;
		panel_tang1.add(bt104, gbc_bt104);

		bt105 = new JButton("16");
		bt105.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/image/coffee_dong.png")));
		GridBagConstraints gbc_bt105 = new GridBagConstraints();
		gbc_bt105.anchor = GridBagConstraints.NORTH;
		gbc_bt105.fill = GridBagConstraints.HORIZONTAL;
		gbc_bt105.insets = new Insets(10, 10, 10, 10);
		gbc_bt105.gridx = 2;
		gbc_bt105.gridy = 1;
		panel_tang1.add(bt105, gbc_bt105);

		bt106 = new JButton("17");
		bt106.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/image/coffee_dong.png")));
		GridBagConstraints gbc_bt106 = new GridBagConstraints();
		gbc_bt106.anchor = GridBagConstraints.NORTH;
		gbc_bt106.fill = GridBagConstraints.HORIZONTAL;
		gbc_bt106.insets = new Insets(10, 10, 10, 10);
		gbc_bt106.gridx = 0;
		gbc_bt106.gridy = 2;
		panel_tang1.add(bt106, gbc_bt106);

		bt107 = new JButton("18");
		bt107.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/image/coffee_dong.png")));
		GridBagConstraints gbc_bt107 = new GridBagConstraints();
		gbc_bt107.anchor = GridBagConstraints.NORTH;
		gbc_bt107.fill = GridBagConstraints.HORIZONTAL;
		gbc_bt107.insets = new Insets(10, 10, 10, 10);
		gbc_bt107.gridx = 1;
		gbc_bt107.gridy = 2;
		panel_tang1.add(bt107, gbc_bt107);

		bt108 = new JButton("19");
		bt108.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/image/coffee_dong.png")));
		GridBagConstraints gbc_bt108 = new GridBagConstraints();
		gbc_bt108.insets = new Insets(10, 10, 10, 10);
		gbc_bt108.anchor = GridBagConstraints.NORTH;
		gbc_bt108.fill = GridBagConstraints.HORIZONTAL;
		gbc_bt108.gridx = 2;
		gbc_bt108.gridy = 2;
		panel_tang1.add(bt108, gbc_bt108);

		bt_109 = new JButton("120");
		bt_109.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/image/coffee_dong.png")));
		GridBagConstraints gbc_bt_109 = new GridBagConstraints();
		gbc_bt_109.insets = new Insets(10, 10, 10, 10);
		gbc_bt_109.gridx = 0;
		gbc_bt_109.gridy = 3;
		panel_tang1.add(bt_109, gbc_bt_109);

		bt_110 = new JButton("122");
		bt_110.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/image/coffee_dong.png")));
		GridBagConstraints gbc_bt_110 = new GridBagConstraints();
		gbc_bt_110.insets = new Insets(10, 10, 10, 10);
		gbc_bt_110.gridx = 1;
		gbc_bt_110.gridy = 3;
		panel_tang1.add(bt_110, gbc_bt_110);

		bt_111 = new JButton("123");
		bt_111.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/image/coffee_dong.png")));
		GridBagConstraints gbc_bt_111 = new GridBagConstraints();
		gbc_bt_111.insets = new Insets(10, 10, 10, 10);
		gbc_bt_111.gridx = 2;
		gbc_bt_111.gridy = 3;
		panel_tang1.add(bt_111, gbc_bt_111);

		// Panel Tầng 2
		panel_tang2 = new JPanel();
		tpKhuVuc.addTab("Tầng 2", null, panel_tang2, null);
		GridBagLayout gbl_panel_tang2 = new GridBagLayout();
		gbl_panel_tang2.columnWidths = new int[] { 99, 99, 99, 0 };
		gbl_panel_tang2.rowHeights = new int[] { 55, 43, 55, 55, 0 };
		gbl_panel_tang2.columnWeights = new double[] { 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_panel_tang2.rowWeights = new double[] { 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		panel_tang2.setLayout(gbl_panel_tang2);

		bt200 = new JButton("21");

		bt200.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/image/coffee_dong.png")));
		GridBagConstraints gbc_bt200 = new GridBagConstraints();
		gbc_bt200.anchor = GridBagConstraints.ABOVE_BASELINE;
		gbc_bt200.fill = GridBagConstraints.HORIZONTAL;
		gbc_bt200.insets = new Insets(10, 10, 10, 10);
		gbc_bt200.gridx = 0;
		gbc_bt200.gridy = 0;
		panel_tang2.add(bt200, gbc_bt200);

		bt201 = new JButton("22");
		bt201.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/image/coffee_dong.png")));
		GridBagConstraints gbc_bt201 = new GridBagConstraints();
		gbc_bt201.anchor = GridBagConstraints.ABOVE_BASELINE;
		gbc_bt201.fill = GridBagConstraints.HORIZONTAL;
		gbc_bt201.insets = new Insets(10, 10, 10, 10);
		gbc_bt201.gridx = 1;
		gbc_bt201.gridy = 0;
		panel_tang2.add(bt201, gbc_bt201);

		bt202 = new JButton("23");
		bt202.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/image/coffee_dong.png")));
		GridBagConstraints gbc_bt202 = new GridBagConstraints();
		gbc_bt202.anchor = GridBagConstraints.ABOVE_BASELINE;
		gbc_bt202.fill = GridBagConstraints.HORIZONTAL;
		gbc_bt202.insets = new Insets(10, 10, 10, 10);
		gbc_bt202.gridx = 2;
		gbc_bt202.gridy = 0;
		panel_tang2.add(bt202, gbc_bt202);

		bt203 = new JButton("24");
		bt203.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/image/coffee_dong.png")));
		GridBagConstraints gbc_bt203 = new GridBagConstraints();
		gbc_bt203.anchor = GridBagConstraints.NORTH;
		gbc_bt203.fill = GridBagConstraints.HORIZONTAL;
		gbc_bt203.insets = new Insets(10, 10, 10, 10);
		gbc_bt203.gridx = 0;
		gbc_bt203.gridy = 1;
		panel_tang2.add(bt203, gbc_bt203);

		bt204 = new JButton("25");
		bt204.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/image/coffee_dong.png")));
		GridBagConstraints gbc_bt204 = new GridBagConstraints();
		gbc_bt204.anchor = GridBagConstraints.NORTH;
		gbc_bt204.fill = GridBagConstraints.HORIZONTAL;
		gbc_bt204.insets = new Insets(10, 10, 10, 10);
		gbc_bt204.gridx = 1;
		gbc_bt204.gridy = 1;
		panel_tang2.add(bt204, gbc_bt204);

		bt205 = new JButton("26");
		bt205.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/image/coffee_dong.png")));
		GridBagConstraints gbc_bt205 = new GridBagConstraints();
		gbc_bt205.anchor = GridBagConstraints.NORTH;
		gbc_bt205.fill = GridBagConstraints.HORIZONTAL;
		gbc_bt205.insets = new Insets(10, 10, 10, 10);
		gbc_bt205.gridx = 2;
		gbc_bt205.gridy = 1;
		panel_tang2.add(bt205, gbc_bt205);

		bt207 = new JButton("27");
		bt207.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/image/coffee_dong.png")));
		GridBagConstraints gbc_bt207 = new GridBagConstraints();
		gbc_bt207.anchor = GridBagConstraints.NORTH;
		gbc_bt207.fill = GridBagConstraints.HORIZONTAL;
		gbc_bt207.insets = new Insets(10, 10, 10, 10);
		gbc_bt207.gridx = 0;
		gbc_bt207.gridy = 2;
		panel_tang2.add(bt207, gbc_bt207);

		bt208 = new JButton("28");
		bt208.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/image/coffee_dong.png")));
		GridBagConstraints gbc_bt208 = new GridBagConstraints();
		gbc_bt208.anchor = GridBagConstraints.NORTH;
		gbc_bt208.fill = GridBagConstraints.HORIZONTAL;
		gbc_bt208.insets = new Insets(10, 10, 10, 10);
		gbc_bt208.gridx = 1;
		gbc_bt208.gridy = 2;
		panel_tang2.add(bt208, gbc_bt208);

		bt206 = new JButton("29");
		bt206.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/image/coffee_dong.png")));
		GridBagConstraints gbc_bt206 = new GridBagConstraints();
		gbc_bt206.insets = new Insets(10, 10, 10, 10);
		gbc_bt206.anchor = GridBagConstraints.NORTH;
		gbc_bt206.fill = GridBagConstraints.HORIZONTAL;
		gbc_bt206.gridx = 2;
		gbc_bt206.gridy = 2;
		panel_tang2.add(bt206, gbc_bt206);

		bt_209 = new JButton("210");
		bt_209.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/image/coffee_dong.png")));
		GridBagConstraints gbc_bt_209 = new GridBagConstraints();
		gbc_bt_209.insets = new Insets(10, 10, 10, 10);
		gbc_bt_209.anchor = GridBagConstraints.NORTH;
		gbc_bt_209.fill = GridBagConstraints.HORIZONTAL;
		gbc_bt_209.gridx = 0;
		gbc_bt_209.gridy = 3;
		panel_tang2.add(bt_209, gbc_bt_209);

		bt210 = new JButton("211");
		bt210.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/image/coffee_dong.png")));
		GridBagConstraints gbc_bt210 = new GridBagConstraints();
		gbc_bt210.insets = new Insets(10, 10, 10, 10);
		gbc_bt210.anchor = GridBagConstraints.NORTH;
		gbc_bt210.fill = GridBagConstraints.HORIZONTAL;
		gbc_bt210.gridx = 1;
		gbc_bt210.gridy = 3;
		panel_tang2.add(bt210, gbc_bt210);

		bt211 = new JButton("212");
		bt211.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/image/coffee_dong.png")));
		GridBagConstraints gbc_bt211 = new GridBagConstraints();
		gbc_bt211.insets = new Insets(10, 10, 10, 10);
		gbc_bt211.anchor = GridBagConstraints.NORTH;
		gbc_bt211.fill = GridBagConstraints.HORIZONTAL;
		gbc_bt211.gridx = 2;
		gbc_bt211.gridy = 3;
		panel_tang2.add(bt211, gbc_bt211);

		btn_thucdon_1 = new JButton("Thực Đơn");
		btn_thucdon_1.setIcon(new ImageIcon(DatBan_Panel.class
				.getResource("/images/edit.png")));
		panel_zx_1.add(btn_thucdon_1);

		bt_01.addActionListener(this);
		bt_02.addActionListener(this);
		bt_03.addActionListener(this);
		bt_04.addActionListener(this);
		bt_05.addActionListener(this);
		bt_06.addActionListener(this);
		bt_07.addActionListener(this);
		bt_08.addActionListener(this);
		bt_09.addActionListener(this);
		bt_10.addActionListener(this);
		bt_11.addActionListener(this);
		bt_12.addActionListener(this);

		bt100.addActionListener(this);
		bt101.addActionListener(this);
		bt102.addActionListener(this);
		bt103.addActionListener(this);
		bt104.addActionListener(this);
		bt105.addActionListener(this);
		bt106.addActionListener(this);
		bt107.addActionListener(this);
		bt108.addActionListener(this);
		bt_109.addActionListener(this);
		bt_110.addActionListener(this);
		bt_111.addActionListener(this);

		bt200.addActionListener(this);
		bt201.addActionListener(this);
		bt202.addActionListener(this);
		bt203.addActionListener(this);
		bt204.addActionListener(this);
		bt205.addActionListener(this);
		bt206.addActionListener(this);
		bt207.addActionListener(this);
		bt208.addActionListener(this);
		// // nut su kien
		btn_tang_1.addActionListener(this);
		btn_giam_1.addActionListener(this);
		btn_sl_macdinh_1.addActionListener(this);
		btn_ghichu_1.addActionListener(this);
		btn_thanhtoan_1.addActionListener(this);
		btn_capnhat_1.addActionListener(this);
		btn_thucdon_1.addActionListener(this);
		//

		tf_soban_1.setEditable(false);
		tf_maKH_HD_1.setEditable(false);
		btn_tang_1.setEnabled(false);
		btn_giam_1.setEnabled(false);
		btn_sl_macdinh_1.setEnabled(false);
		btn_ghichu_1.setEnabled(false);
		btn_thanhtoan_1.setEnabled(false);
		btn_capnhat_1.setEnabled(false);

	}

	public static JToolBar getToolbar() {
		return toolbar;
	}

	public static JButton getBtnF() {
		return btnF;
	}

	public static JButton getBtnP() {
		return btnP;
	}

	public static JButton getBtnN() {
		return btnN;
	}

	public static JButton getBtnL() {
		return btnL;
	}

	public static JButton getBtnAdd() {
		return btnAdd;
	}

	public static JButton getBtnSave() {
		return btnSave;
	}

	public static JButton getBtnDelete() {
		return btnDelete;
	}

	public static DefaultTableModel getDtm() {
		return dtm;
	}

	public static UpdateAction_HoaDon getAction() {
		return action;
	}

	public static JLabel getStatusBar() {
		return statusBar;
	}

	public static ArrayList<HoaDon> getLst() {
		return lst;
	}

	public static int getCurPos() {
		return curPos;
	}

	public static JLabel getLblPos() {
		return lblPos;
	}

	public static int getNoExistRecords() {
		return NoExistRecords;
	}

	public JPanel getTitle_Panel() {
		return title_Panel;
	}

	public JPanel getSplitPanel_Right() {
		return SplitPanel_Right;
	}

	public JPanel getSplitPanel_Left() {
		return SplitPanel_Left;
	}

	public JSplitPane getSplitPane() {
		return splitPane;
	}

	public JTabbedPane getTpKhuVuc() {
		return tpKhuVuc;
	}

	public JPanel getPkhu() {
		return pkhu;
	}

	public JPanel getPanel_tangtret() {
		return panel_tangtret;
	}

	public JPanel getPanel_tang1() {
		return panel_tang1;
	}

	public JPanel getPanel_tang2() {
		return panel_tang2;
	}

	public static JButton getBt100() {
		return bt100;
	}

	public static JButton getBt101() {
		return bt101;
	}

	public static JButton getBt102() {
		return bt102;
	}

	public static JButton getBt103() {
		return bt103;
	}

	public static JButton getBt104() {
		return bt104;
	}

	public static JButton getBt105() {
		return bt105;
	}

	public static JButton getBt106() {
		return bt106;
	}

	public static JButton getBt107() {
		return bt107;
	}

	public static JButton getBt108() {
		return bt108;
	}

	public static JButton getBt109() {
		return bt109;
	}

	public static JButton getBt200() {
		return bt200;
	}

	public static JButton getBt201() {
		return bt201;
	}

	public static JButton getBt202() {
		return bt202;
	}

	public static JButton getBt203() {
		return bt203;
	}

	public static JButton getBt204() {
		return bt204;
	}

	public static JButton getBt205() {
		return bt205;
	}

	public static JButton getBt206() {
		return bt206;
	}

	public static JButton getBt207() {
		return bt207;
	}

	public static JButton getBt208() {
		return bt208;
	}

	public static JButton getBt209() {
		return bt209;
	}

	public static JButton getBt_01() {
		return bt_01;
	}

	public static JButton getBt_02() {
		return bt_02;
	}

	public static JButton getBt_03() {
		return bt_03;
	}

	public static JButton getBt_04() {
		return bt_04;
	}

	public static JButton getBt_05() {
		return bt_05;
	}

	public static JButton getBt_06() {
		return bt_06;
	}

	public static JButton getBt_07() {
		return bt_07;
	}

	public static JButton getBt_08() {
		return bt_08;
	}

	public static JButton getBt_09() {
		return bt_09;
	}

	public static JButton getBt_10() {
		return bt_10;
	}

	public static JButton getBt_11() {
		return bt_11;
	}

	public static JButton getBt_12() {
		return bt_12;
	}

	public static JButton getBt_109() {
		return bt_109;
	}

	public static JButton getBt_110() {
		return bt_110;
	}

	public static JButton getBt_111() {
		return bt_111;
	}

	public static JButton getBt_209() {
		return bt_209;
	}

	public static JButton getBt210() {
		return bt210;
	}

	public static JButton getBt211() {
		return bt211;
	}

	public JPanel getGioiThieu_DatBan_Panel() {
		return gioiThieu_DatBan_Panel;
	}

	public JPanel getTangTret_1() {
		return TangTret_1;
	}

	public JPanel getTangTret_2() {
		return TangTret_2;
	}

	public JPanel getTangTret_3() {
		return TangTret_3;
	}

	public JPanel getTangTret_4() {
		return TangTret_4;
	}

	public JPanel getTangTret_5() {
		return TangTret_5;
	}

	public JPanel getTangTret_6() {
		return TangTret_6;
	}

	public JPanel getTangTret_7() {
		return TangTret_7;
	}

	public JPanel getTangTret_8() {
		return TangTret_8;
	}

	public JPanel getTangTret_9() {
		return TangTret_9;
	}

	public JPanel getTangTret_10() {
		return TangTret_10;
	}

	public JPanel getTangTret_11() {
		return TangTret_11;
	}

	public JPanel getTangTret_12() {
		return TangTret_12;
	}

	public JPanel getTang1_11() {
		return Tang1_11;
	}

	public JPanel getTang1_12() {
		return Tang1_12;
	}

	public JPanel getTang1_13() {
		return Tang1_13;
	}

	public JPanel getTang1_14() {
		return Tang1_14;
	}

	public JPanel getPanel() {
		return panel;
	}

	public JLabel getLblChiTitHo() {
		return lblChiTitHo;
	}

	public JLabel getLblSBn() {
		return lblSBn;
	}

	public JLabel getLblNgyNhp() {
		return lblNgyNhp;
	}

	public static UtilDateModel getModel() {
		return model;
	}

	public static JDatePanelImpl getDatePanel() {
		return datePanel;
	}

	public JLabel getLblMKh() {
		return lblMKh;
	}

	public static JScrollPane getScroll() {
		return scroll;
	}

	public static JTextField getTf_soban_1() {
		return tf_soban_1;
	}

	public static JTextField getTf_soban_2() {
		return tf_soban_2;
	}

	public static JTextField getTf_soban_3() {
		return tf_soban_3;
	}

	public static JTextField getTf_soban_4() {
		return tf_soban_4;
	}

	public static JTextField getTf_soban_5() {
		return tf_soban_5;
	}

	public static JTextField getTf_soban_6() {
		return tf_soban_6;
	}

	public static JTextField getTf_soban_7() {
		return tf_soban_7;
	}

	public static JTextField getTf_soban_8() {
		return tf_soban_8;
	}

	public static JTextField getTf_soban_9() {
		return tf_soban_9;
	}

	public static JTextField getTf_soban_10() {
		return tf_soban_10;
	}

	public static JTextField getTf_soban_11() {
		return tf_soban_11;
	}

	public static JTextField getTf_soban_12() {
		return tf_soban_12;
	}

	public static JTextField getTf_soban_13() {
		return tf_soban_13;
	}

	public static JTextField getTf_soban_14() {
		return tf_soban_14;
	}

	public static JTextField getTf_soban_15() {
		return tf_soban_15;
	}

	public static JTextField getTf_soban_16() {
		return tf_soban_16;
	}

	public static JTextField getTf_soban_17() {
		return tf_soban_17;
	}

	public static JTextField getTf_soban_18() {
		return tf_soban_18;
	}

	public static JTextField getTf_soban_19() {
		return tf_soban_19;
	}

	public static JTextField getTf_soban_20() {
		return tf_soban_20;
	}

	public static JTextField getTf_soban_21() {
		return tf_soban_21;
	}

	public static JTextField getTf_soban_22() {
		return tf_soban_22;
	}

	public static JTextField getTf_soban_23() {
		return tf_soban_23;
	}

	public static JTextField getTf_soban_24() {
		return tf_soban_24;
	}

	public static JTextField getTf_soban_25() {
		return tf_soban_25;
	}

	public static JTextField getTf_soban_26() {
		return tf_soban_26;
	}

	public static JTextField getTf_soban_27() {
		return tf_soban_27;
	}

	public static JTextField getTf_soban_28() {
		return tf_soban_28;
	}

	public static JTextField getTf_soban_29() {
		return tf_soban_29;
	}

	public static JTextField getTf_soban_30() {
		return tf_soban_30;
	}

	public static JTextField getTf_soban_31() {
		return tf_soban_31;
	}

	public static JTextField getTf_soban_32() {
		return tf_soban_32;
	}

	public static JTextField getTf_soban_33() {
		return tf_soban_33;
	}

	public static JTextField getTf_soban_34() {
		return tf_soban_34;
	}

	public static JTextField getTf_soban_35() {
		return tf_soban_35;
	}

	public static JTextField getTf_soban_36() {
		return tf_soban_36;
	}

	public JPanel getPanel_theotungban_1() {
		return panel_theotungban_1;
	}

	public JPanel getPanel_theotungban_2() {
		return panel_theotungban_2;
	}

	public JPanel getPanel_theotungban_3() {
		return panel_theotungban_3;
	}

	public JPanel getPanel_theotungban_4() {
		return panel_theotungban_4;
	}

	public JPanel getPanel_theotungban_5() {
		return panel_theotungban_5;
	}

	public JPanel getPanel_theotungban_6() {
		return panel_theotungban_6;
	}

	public JPanel getPanel_theotungban_7() {
		return panel_theotungban_7;
	}

	public JPanel getPanel_theotungban_8() {
		return panel_theotungban_8;
	}

	public JPanel getPanel_theotungban_9() {
		return panel_theotungban_9;
	}

	public JPanel getPanel_theotungban_10() {
		return panel_theotungban_10;
	}

	public JPanel getPanel_theotungban_11() {
		return panel_theotungban_11;
	}

	public JPanel getPanel_theotungban_12() {
		return panel_theotungban_12;
	}

	public JPanel getPanel_theotungban_13() {
		return panel_theotungban_13;
	}

	public JPanel getPanel_theotungban_14() {
		return panel_theotungban_14;
	}

	public JPanel getPanel_theotungban_15() {
		return panel_theotungban_15;
	}

	public JPanel getPanel_theotungban_16() {
		return panel_theotungban_16;
	}

	public JPanel getPanel_theotungban_17() {
		return panel_theotungban_17;
	}

	public JPanel getPanel_theotungban_18() {
		return panel_theotungban_18;
	}

	public JPanel getPanel_theotungban_19() {
		return panel_theotungban_19;
	}

	public JPanel getPanel_theotungban_20() {
		return panel_theotungban_20;
	}

	public JPanel getPanel_theotungban_21() {
		return panel_theotungban_21;
	}

	public JPanel getPanel_theotungban_22() {
		return panel_theotungban_22;
	}

	public JPanel getPanel_theotungban_23() {
		return panel_theotungban_23;
	}

	public JPanel getPanel_theotungban_24() {
		return panel_theotungban_24;
	}

	public JPanel getPanel_theotungban_25() {
		return panel_theotungban_25;
	}

	public JPanel getPanel_theotungban_26() {
		return panel_theotungban_26;
	}

	public JPanel getPanel_theotungban_27() {
		return panel_theotungban_27;
	}

	public JPanel getPanel_theotungban_28() {
		return panel_theotungban_28;
	}

	public JPanel getPanel_theotungban_29() {
		return panel_theotungban_29;
	}

	public JPanel getPanel_theotungban_30() {
		return panel_theotungban_30;
	}

	public JPanel getPanel_theotungban_31() {
		return panel_theotungban_31;
	}

	public JPanel getPanel_theotungban_32() {
		return panel_theotungban_32;
	}

	public JPanel getPanel_theotungban_33() {
		return panel_theotungban_33;
	}

	public JPanel getPanel_theotungban_34() {
		return panel_theotungban_34;
	}

	public JPanel getPanel_theotungban_35() {
		return panel_theotungban_35;
	}

	public JPanel getPanel_theotungban_36() {
		return panel_theotungban_36;
	}

	public JPanel getPanel_abc_1() {
		return panel_abc_1;
	}

	public JPanel getPanel_abc_2() {
		return panel_abc_2;
	}

	public JPanel getPanel_abc_3() {
		return panel_abc_3;
	}

	public JPanel getPanel_abc_4() {
		return panel_abc_4;
	}

	public JPanel getPanel_abc_5() {
		return panel_abc_5;
	}

	public JPanel getPanel_abc_6() {
		return panel_abc_6;
	}

	public JPanel getPanel_abc_7() {
		return panel_abc_7;
	}

	public JPanel getPanel_abc_8() {
		return panel_abc_8;
	}

	public JPanel getPanel_abc_9() {
		return panel_abc_9;
	}

	public JPanel getPanel_abc_10() {
		return panel_abc_10;
	}

	public JPanel getPanel_abc_11() {
		return panel_abc_11;
	}

	public JPanel getPanel_abc_12() {
		return panel_abc_12;
	}

	public JPanel getPanel_abc_13() {
		return panel_abc_13;
	}

	public JPanel getPanel_abc_14() {
		return panel_abc_14;
	}

	public JPanel getPanel_abc_15() {
		return panel_abc_15;
	}

	public JPanel getPanel_abc_16() {
		return panel_abc_16;
	}

	public JPanel getPanel_abc_17() {
		return panel_abc_17;
	}

	public JPanel getPanel_abc_18() {
		return panel_abc_18;
	}

	public JPanel getPanel_abc_19() {
		return panel_abc_19;
	}

	public JPanel getPanel_abc_20() {
		return panel_abc_20;
	}

	public JPanel getPanel_abc_21() {
		return panel_abc_21;
	}

	public JPanel getPanel_abc_22() {
		return panel_abc_22;
	}

	public JPanel getPanel_abc_23() {
		return panel_abc_23;
	}

	public JPanel getPanel_abc_24() {
		return panel_abc_24;
	}

	public JPanel getPanel_abc_25() {
		return panel_abc_25;
	}

	public JPanel getPanel_abc_26() {
		return panel_abc_26;
	}

	public JPanel getPanel_abc_27() {
		return panel_abc_27;
	}

	public JPanel getPanel_abc_28() {
		return panel_abc_28;
	}

	public JPanel getPanel_abc_29() {
		return panel_abc_29;
	}

	public JPanel getPanel_abc_30() {
		return panel_abc_30;
	}

	public JPanel getPanel_abc_31() {
		return panel_abc_31;
	}

	public JPanel getPanel_abc_32() {
		return panel_abc_32;
	}

	public JPanel getPanel_abc_33() {
		return panel_abc_33;
	}

	public JPanel getPanel_abc_34() {
		return panel_abc_34;
	}

	public JPanel getPanel_abc_35() {
		return panel_abc_35;
	}

	public JPanel getPanel_abc_36() {
		return panel_abc_36;
	}

	public static int getCheck_1() {
		return check_1;
	}

	public static int getCheck_2() {
		return check_2;
	}

	public static int getCheck_3() {
		return check_3;
	}

	public static int getCheck_4() {
		return check_4;
	}

	public static int getCheck_5() {
		return check_5;
	}

	public static int getCheck_6() {
		return check_6;
	}

	public static int getCheck_7() {
		return check_7;
	}

	public static int getCheck_8() {
		return check_8;
	}

	public static int getCheck_9() {
		return check_9;
	}

	public static int getCheck_10() {
		return check_10;
	}

	public static int getCheck_11() {
		return check_11;
	}

	public static int getCheck_12() {
		return check_12;
	}

	public static int getCheck_13() {
		return check_13;
	}

	public static int getCheck_14() {
		return check_14;
	}

	public static int getCheck_15() {
		return check_15;
	}

	public static int getCheck_16() {
		return check_16;
	}

	public static int getCheck_17() {
		return check_17;
	}

	public static int getCheck_18() {
		return check_18;
	}

	public static int getCheck_19() {
		return check_19;
	}

	public static int getCheck_20() {
		return check_20;
	}

	public static int getCheck_21() {
		return check_21;
	}

	public static int getCheck_22() {
		return check_22;
	}

	public static int getCheck_23() {
		return check_23;
	}

	public static int getCheck_24() {
		return check_24;
	}

	public static int getCheck_25() {
		return check_25;
	}

	public static int getCheck_26() {
		return check_26;
	}

	public static int getCheck_27() {
		return check_27;
	}

	public static int getCheck_28() {
		return check_28;
	}

	public static int getCheck_29() {
		return check_29;
	}

	public static int getCheck_30() {
		return check_30;
	}

	public static int getCheck_31() {
		return check_31;
	}

	public static int getCheck_32() {
		return check_32;
	}

	public static int getCheck_33() {
		return check_33;
	}

	public static int getCheck_34() {
		return check_34;
	}

	public static int getCheck_35() {
		return check_35;
	}

	public static int getCheck_36() {
		return check_36;
	}

	public static JDatePickerImpl getDatePicker_1() {
		return datePicker_1;
	}

	public static JDatePickerImpl getDatePicker_2() {
		return datePicker_2;
	}

	public static JDatePickerImpl getDatePicker_3() {
		return datePicker_3;
	}

	public static JDatePickerImpl getDatePicker_4() {
		return datePicker_4;
	}

	public static JDatePickerImpl getDatePicker_5() {
		return datePicker_5;
	}

	public static JDatePickerImpl getDatePicker_6() {
		return datePicker_6;
	}

	public static JDatePickerImpl getDatePicker_7() {
		return datePicker_7;
	}

	public static JDatePickerImpl getDatePicker_8() {
		return datePicker_8;
	}

	public static JDatePickerImpl getDatePicker_9() {
		return datePicker_9;
	}

	public static JDatePickerImpl getDatePicker_10() {
		return datePicker_10;
	}

	public static JDatePickerImpl getDatePicker_11() {
		return datePicker_11;
	}

	public static JDatePickerImpl getDatePicker_12() {
		return datePicker_12;
	}

	public static JDatePickerImpl getDatePicker_13() {
		return datePicker_13;
	}

	public static JDatePickerImpl getDatePicker_14() {
		return datePicker_14;
	}

	public static JDatePickerImpl getDatePicker_15() {
		return datePicker_15;
	}

	public static JDatePickerImpl getDatePicker_16() {
		return datePicker_16;
	}

	public static JDatePickerImpl getDatePicker_17() {
		return datePicker_17;
	}

	public static JDatePickerImpl getDatePicker_18() {
		return datePicker_18;
	}

	public static JDatePickerImpl getDatePicker_19() {
		return datePicker_19;
	}

	public static JDatePickerImpl getDatePicker_20() {
		return datePicker_20;
	}

	public static JDatePickerImpl getDatePicker_21() {
		return datePicker_21;
	}

	public static JDatePickerImpl getDatePicker_22() {
		return datePicker_22;
	}

	public static JDatePickerImpl getDatePicker_23() {
		return datePicker_23;
	}

	public static JDatePickerImpl getDatePicker_24() {
		return datePicker_24;
	}

	public static JDatePickerImpl getDatePicker_25() {
		return datePicker_25;
	}

	public static JDatePickerImpl getDatePicker_26() {
		return datePicker_26;
	}

	public static JDatePickerImpl getDatePicker_27() {
		return datePicker_27;
	}

	public static JDatePickerImpl getDatePicker_28() {
		return datePicker_28;
	}

	public static JDatePickerImpl getDatePicker_29() {
		return datePicker_29;
	}

	public static JDatePickerImpl getDatePicker_30() {
		return datePicker_30;
	}

	public static JDatePickerImpl getDatePicker_31() {
		return datePicker_31;
	}

	public static JDatePickerImpl getDatePicker_32() {
		return datePicker_32;
	}

	public static JDatePickerImpl getDatePicker_33() {
		return datePicker_33;
	}

	public static JDatePickerImpl getDatePicker_34() {
		return datePicker_34;
	}

	public static JDatePickerImpl getDatePicker_35() {
		return datePicker_35;
	}

	public static JDatePickerImpl getDatePicker_36() {
		return datePicker_36;
	}

	public static JTextField getTf_maKH_HD_1() {
		return tf_maKH_HD_1;
	}

	public static JTextField getTf_maKH_HD_2() {
		return tf_maKH_HD_2;
	}

	public static JTextField getTf_maKH_HD_3() {
		return tf_maKH_HD_3;
	}

	public static JTextField getTf_maKH_HD_4() {
		return tf_maKH_HD_4;
	}

	public static JTextField getTf_maKH_HD_5() {
		return tf_maKH_HD_5;
	}

	public static JTextField getTf_maKH_HD_6() {
		return tf_maKH_HD_6;
	}

	public static JTextField getTf_maKH_HD_7() {
		return tf_maKH_HD_7;
	}

	public static JTextField getTf_maKH_HD_8() {
		return tf_maKH_HD_8;
	}

	public static JTextField getTf_maKH_HD_9() {
		return tf_maKH_HD_9;
	}

	public static JTextField getTf_maKH_HD_10() {
		return tf_maKH_HD_10;
	}

	public static JTextField getTf_maKH_HD_11() {
		return tf_maKH_HD_11;
	}

	public static JTextField getTf_maKH_HD_12() {
		return tf_maKH_HD_12;
	}

	public static JTextField getTf_maKH_HD_13() {
		return tf_maKH_HD_13;
	}

	public static JTextField getTf_maKH_HD_14() {
		return tf_maKH_HD_14;
	}

	public static JTextField getTf_maKH_HD_15() {
		return tf_maKH_HD_15;
	}

	public static JTextField getTf_maKH_HD_16() {
		return tf_maKH_HD_16;
	}

	public static JTextField getTf_maKH_HD_17() {
		return tf_maKH_HD_17;
	}

	public static JTextField getTf_maKH_HD_18() {
		return tf_maKH_HD_18;
	}

	public static JTextField getTf_maKH_HD_19() {
		return tf_maKH_HD_19;
	}

	public static JTextField getTf_maKH_HD_20() {
		return tf_maKH_HD_20;
	}

	public static JTextField getTf_maKH_HD_21() {
		return tf_maKH_HD_21;
	}

	public static JTextField getTf_maKH_HD_22() {
		return tf_maKH_HD_22;
	}

	public static JTextField getTf_maKH_HD_23() {
		return tf_maKH_HD_23;
	}

	public static JTextField getTf_maKH_HD_24() {
		return tf_maKH_HD_24;
	}

	public static JTextField getTf_maKH_HD_25() {
		return tf_maKH_HD_25;
	}

	public static JTextField getTf_maKH_HD_26() {
		return tf_maKH_HD_26;
	}

	public static JTextField getTf_maKH_HD_27() {
		return tf_maKH_HD_27;
	}

	public static JTextField getTf_maKH_HD_28() {
		return tf_maKH_HD_28;
	}

	public static JTextField getTf_maKH_HD_29() {
		return tf_maKH_HD_29;
	}

	public static JTextField getTf_maKH_HD_30() {
		return tf_maKH_HD_30;
	}

	public static JTextField getTf_maKH_HD_31() {
		return tf_maKH_HD_31;
	}

	public static JTextField getTf_maKH_HD_32() {
		return tf_maKH_HD_32;
	}

	public static JTextField getTf_maKH_HD_33() {
		return tf_maKH_HD_33;
	}

	public static JTextField getTf_maKH_HD_34() {
		return tf_maKH_HD_34;
	}

	public static JTextField getTf_maKH_HD_35() {
		return tf_maKH_HD_35;
	}

	public static JTextField getTf_maKH_HD_36() {
		return tf_maKH_HD_36;
	}

	public JPanel getPanel_acc_1() {
		return panel_acc_1;
	}

	public JPanel getPanel_acc_2() {
		return panel_acc_2;
	}

	public JPanel getPanel_acc_3() {
		return panel_acc_3;
	}

	public JPanel getPanel_acc_4() {
		return panel_acc_4;
	}

	public JPanel getPanel_acc_5() {
		return panel_acc_5;
	}

	public JPanel getPanel_acc_6() {
		return panel_acc_6;
	}

	public JPanel getPanel_acc_7() {
		return panel_acc_7;
	}

	public JPanel getPanel_acc_8() {
		return panel_acc_8;
	}

	public JPanel getPanel_acc_9() {
		return panel_acc_9;
	}

	public JPanel getPanel_acc_10() {
		return panel_acc_10;
	}

	public JPanel getPanel_acc_11() {
		return panel_acc_11;
	}

	public JPanel getPanel_acc_12() {
		return panel_acc_12;
	}

	public JPanel getPanel_acc_13() {
		return panel_acc_13;
	}

	public JPanel getPanel_acc_14() {
		return panel_acc_14;
	}

	public JPanel getPanel_acc_15() {
		return panel_acc_15;
	}

	public JPanel getPanel_acc_16() {
		return panel_acc_16;
	}

	public JPanel getPanel_acc_17() {
		return panel_acc_17;
	}

	public JPanel getPanel_acc_18() {
		return panel_acc_18;
	}

	public JPanel getPanel_acc_19() {
		return panel_acc_19;
	}

	public JPanel getPanel_acc_20() {
		return panel_acc_20;
	}

	public JPanel getPanel_acc_21() {
		return panel_acc_21;
	}

	public JPanel getPanel_acc_22() {
		return panel_acc_22;
	}

	public JPanel getPanel_acc_23() {
		return panel_acc_23;
	}

	public JPanel getPanel_acc_24() {
		return panel_acc_24;
	}

	public JPanel getPanel_acc_25() {
		return panel_acc_25;
	}

	public JPanel getPanel_acc_26() {
		return panel_acc_26;
	}

	public JPanel getPanel_acc_27() {
		return panel_acc_27;
	}

	public JPanel getPanel_acc_28() {
		return panel_acc_28;
	}

	public JPanel getPanel_acc_29() {
		return panel_acc_29;
	}

	public JPanel getPanel_acc_30() {
		return panel_acc_30;
	}

	public JPanel getPanel_acc_31() {
		return panel_acc_31;
	}

	public JPanel getPanel_acc_32() {
		return panel_acc_32;
	}

	public JPanel getPanel_acc_33() {
		return panel_acc_33;
	}

	public JPanel getPanel_acc_34() {
		return panel_acc_34;
	}

	public JPanel getPanel_acc_35() {
		return panel_acc_35;
	}

	public JPanel getPanel_acc_36() {
		return panel_acc_36;
	}

	public JPanel getPanel_addc_1() {
		return panel_addc_1;
	}

	public JPanel getPanel_addc_2() {
		return panel_addc_2;
	}

	public JPanel getPanel_addc_3() {
		return panel_addc_3;
	}

	public JPanel getPanel_addc_4() {
		return panel_addc_4;
	}

	public JPanel getPanel_addc_5() {
		return panel_addc_5;
	}

	public JPanel getPanel_addc_6() {
		return panel_addc_6;
	}

	public JPanel getPanel_addc_7() {
		return panel_addc_7;
	}

	public JPanel getPanel_addc_8() {
		return panel_addc_8;
	}

	public JPanel getPanel_addc_9() {
		return panel_addc_9;
	}

	public JPanel getPanel_addc_10() {
		return panel_addc_10;
	}

	public JPanel getPanel_addc_11() {
		return panel_addc_11;
	}

	public JPanel getPanel_addc_12() {
		return panel_addc_12;
	}

	public JPanel getPanel_addc_13() {
		return panel_addc_13;
	}

	public JPanel getPanel_addc_14() {
		return panel_addc_14;
	}

	public JPanel getPanel_addc_15() {
		return panel_addc_15;
	}

	public JPanel getPanel_addc_16() {
		return panel_addc_16;
	}

	public JPanel getPanel_addc_17() {
		return panel_addc_17;
	}

	public JPanel getPanel_addc_18() {
		return panel_addc_18;
	}

	public JPanel getPanel_addc_19() {
		return panel_addc_19;
	}

	public JPanel getPanel_addc_20() {
		return panel_addc_20;
	}

	public JPanel getPanel_addc_21() {
		return panel_addc_21;
	}

	public JPanel getPanel_addc_22() {
		return panel_addc_22;
	}

	public JPanel getPanel_addc_23() {
		return panel_addc_23;
	}

	public JPanel getPanel_addc_24() {
		return panel_addc_24;
	}

	public JPanel getPanel_addc_25() {
		return panel_addc_25;
	}

	public JPanel getPanel_addc_26() {
		return panel_addc_26;
	}

	public JPanel getPanel_addc_27() {
		return panel_addc_27;
	}

	public JPanel getPanel_addc_28() {
		return panel_addc_28;
	}

	public JPanel getPanel_addc_29() {
		return panel_addc_29;
	}

	public JPanel getPanel_addc_30() {
		return panel_addc_30;
	}

	public JPanel getPanel_addc_31() {
		return panel_addc_31;
	}

	public JPanel getPanel_addc_32() {
		return panel_addc_32;
	}

	public JPanel getPanel_addc_33() {
		return panel_addc_33;
	}

	public JPanel getPanel_addc_34() {
		return panel_addc_34;
	}

	public JPanel getPanel_addc_35() {
		return panel_addc_35;
	}

	public JPanel getPanel_addc_36() {
		return panel_addc_36;
	}

	public static JButton getBtn_tang_1() {
		return btn_tang_1;
	}

	public static JButton getBtn_tang_2() {
		return btn_tang_2;
	}

	public static JButton getBtn_tang_3() {
		return btn_tang_3;
	}

	public static JButton getBtn_tang_4() {
		return btn_tang_4;
	}

	public static JButton getBtn_tang_5() {
		return btn_tang_5;
	}

	public static JButton getBtn_tang_6() {
		return btn_tang_6;
	}

	public static JButton getBtn_tang_7() {
		return btn_tang_7;
	}

	public static JButton getBtn_tang_8() {
		return btn_tang_8;
	}

	public static JButton getBtn_tang_9() {
		return btn_tang_9;
	}

	public static JButton getBtn_tang_10() {
		return btn_tang_10;
	}

	public static JButton getBtn_tang_11() {
		return btn_tang_11;
	}

	public static JButton getBtn_tang_12() {
		return btn_tang_12;
	}

	public static JButton getBtn_tang_13() {
		return btn_tang_13;
	}

	public static JButton getBtn_tang_14() {
		return btn_tang_14;
	}

	public static JButton getBtn_tang_15() {
		return btn_tang_15;
	}

	public static JButton getBtn_tang_16() {
		return btn_tang_16;
	}

	public static JButton getBtn_tang_17() {
		return btn_tang_17;
	}

	public static JButton getBtn_tang_18() {
		return btn_tang_18;
	}

	public static JButton getBtn_tang_19() {
		return btn_tang_19;
	}

	public static JButton getBtn_tang_20() {
		return btn_tang_20;
	}

	public static JButton getBtn_tang_21() {
		return btn_tang_21;
	}

	public static JButton getBtn_tang_22() {
		return btn_tang_22;
	}

	public static JButton getBtn_tang_23() {
		return btn_tang_23;
	}

	public static JButton getBtn_tang_24() {
		return btn_tang_24;
	}

	public static JButton getBtn_tang_25() {
		return btn_tang_25;
	}

	public static JButton getBtn_tang_26() {
		return btn_tang_26;
	}

	public static JButton getBtn_tang_27() {
		return btn_tang_27;
	}

	public static JButton getBtn_tang_28() {
		return btn_tang_28;
	}

	public static JButton getBtn_tang_29() {
		return btn_tang_29;
	}

	public static JButton getBtn_tang_30() {
		return btn_tang_30;
	}

	public static JButton getBtn_tang_31() {
		return btn_tang_31;
	}

	public static JButton getBtn_tang_32() {
		return btn_tang_32;
	}

	public static JButton getBtn_tang_33() {
		return btn_tang_33;
	}

	public static JButton getBtn_tang_34() {
		return btn_tang_34;
	}

	public static JButton getBtn_tang_35() {
		return btn_tang_35;
	}

	public static JButton getBtn_tang_36() {
		return btn_tang_36;
	}

	public static JButton getBtn_giam_1() {
		return btn_giam_1;
	}

	public static JButton getBtn_giam_2() {
		return btn_giam_2;
	}

	public static JButton getBtn_giam_3() {
		return btn_giam_3;
	}

	public static JButton getBtn_giam_4() {
		return btn_giam_4;
	}

	public static JButton getBtn_giam_5() {
		return btn_giam_5;
	}

	public static JButton getBtn_giam_6() {
		return btn_giam_6;
	}

	public static JButton getBtn_giam_7() {
		return btn_giam_7;
	}

	public static JButton getBtn_giam_8() {
		return btn_giam_8;
	}

	public static JButton getBtn_giam_9() {
		return btn_giam_9;
	}

	public static JButton getBtn_giam_10() {
		return btn_giam_10;
	}

	public static JButton getBtn_giam_11() {
		return btn_giam_11;
	}

	public static JButton getBtn_giam_12() {
		return btn_giam_12;
	}

	public static JButton getBtn_giam_13() {
		return btn_giam_13;
	}

	public static JButton getBtn_giam_14() {
		return btn_giam_14;
	}

	public static JButton getBtn_giam_15() {
		return btn_giam_15;
	}

	public static JButton getBtn_giam_16() {
		return btn_giam_16;
	}

	public static JButton getBtn_giam_17() {
		return btn_giam_17;
	}

	public static JButton getBtn_giam_18() {
		return btn_giam_18;
	}

	public static JButton getBtn_giam_19() {
		return btn_giam_19;
	}

	public static JButton getBtn_giam_20() {
		return btn_giam_20;
	}

	public static JButton getBtn_giam_21() {
		return btn_giam_21;
	}

	public static JButton getBtn_giam_22() {
		return btn_giam_22;
	}

	public static JButton getBtn_giam_23() {
		return btn_giam_23;
	}

	public static JButton getBtn_giam_24() {
		return btn_giam_24;
	}

	public static JButton getBtn_giam_25() {
		return btn_giam_25;
	}

	public static JButton getBtn_giam_26() {
		return btn_giam_26;
	}

	public static JButton getBtn_giam_27() {
		return btn_giam_27;
	}

	public static JButton getBtn_giam_28() {
		return btn_giam_28;
	}

	public static JButton getBtn_giam_29() {
		return btn_giam_29;
	}

	public static JButton getBtn_giam_30() {
		return btn_giam_30;
	}

	public static JButton getBtn_giam_31() {
		return btn_giam_31;
	}

	public static JButton getBtn_giam_32() {
		return btn_giam_32;
	}

	public static JButton getBtn_giam_33() {
		return btn_giam_33;
	}

	public static JButton getBtn_giam_34() {
		return btn_giam_34;
	}

	public static JButton getBtn_giam_35() {
		return btn_giam_35;
	}

	public static JButton getBtn_giam_36() {
		return btn_giam_36;
	}

	public static JButton getBtn_sl_macdinh_1() {
		return btn_sl_macdinh_1;
	}

	public static JButton getBtn_sl_macdinh_2() {
		return btn_sl_macdinh_2;
	}

	public static JButton getBtn_sl_macdinh_3() {
		return btn_sl_macdinh_3;
	}

	public static JButton getBtn_sl_macdinh_4() {
		return btn_sl_macdinh_4;
	}

	public static JButton getBtn_sl_macdinh_5() {
		return btn_sl_macdinh_5;
	}

	public static JButton getBtn_sl_macdinh_6() {
		return btn_sl_macdinh_6;
	}

	public static JButton getBtn_sl_macdinh_7() {
		return btn_sl_macdinh_7;
	}

	public static JButton getBtn_sl_macdinh_8() {
		return btn_sl_macdinh_8;
	}

	public static JButton getBtn_sl_macdinh_9() {
		return btn_sl_macdinh_9;
	}

	public static JButton getBtn_sl_macdinh_10() {
		return btn_sl_macdinh_10;
	}

	public static JButton getBtn_sl_macdinh_11() {
		return btn_sl_macdinh_11;
	}

	public static JButton getBtn_sl_macdinh_12() {
		return btn_sl_macdinh_12;
	}

	public static JButton getBtn_sl_macdinh_13() {
		return btn_sl_macdinh_13;
	}

	public static JButton getBtn_sl_macdinh_14() {
		return btn_sl_macdinh_14;
	}

	public static JButton getBtn_sl_macdinh_15() {
		return btn_sl_macdinh_15;
	}

	public static JButton getBtn_sl_macdinh_16() {
		return btn_sl_macdinh_16;
	}

	public static JButton getBtn_sl_macdinh_17() {
		return btn_sl_macdinh_17;
	}

	public static JButton getBtn_sl_macdinh_18() {
		return btn_sl_macdinh_18;
	}

	public static JButton getBtn_sl_macdinh_19() {
		return btn_sl_macdinh_19;
	}

	public static JButton getBtn_sl_macdinh_20() {
		return btn_sl_macdinh_20;
	}

	public static JButton getBtn_sl_macdinh_21() {
		return btn_sl_macdinh_21;
	}

	public static JButton getBtn_sl_macdinh_22() {
		return btn_sl_macdinh_22;
	}

	public static JButton getBtn_sl_macdinh_23() {
		return btn_sl_macdinh_23;
	}

	public static JButton getBtn_sl_macdinh_24() {
		return btn_sl_macdinh_24;
	}

	public static JButton getBtn_sl_macdinh_25() {
		return btn_sl_macdinh_25;
	}

	public static JButton getBtn_sl_macdinh_26() {
		return btn_sl_macdinh_26;
	}

	public static JButton getBtn_sl_macdinh_27() {
		return btn_sl_macdinh_27;
	}

	public static JButton getBtn_sl_macdinh_28() {
		return btn_sl_macdinh_28;
	}

	public static JButton getBtn_sl_macdinh_29() {
		return btn_sl_macdinh_29;
	}

	public static JButton getBtn_sl_macdinh_30() {
		return btn_sl_macdinh_30;
	}

	public static JButton getBtn_sl_macdinh_31() {
		return btn_sl_macdinh_31;
	}

	public static JButton getBtn_sl_macdinh_32() {
		return btn_sl_macdinh_32;
	}

	public static JButton getBtn_sl_macdinh_33() {
		return btn_sl_macdinh_33;
	}

	public static JButton getBtn_sl_macdinh_34() {
		return btn_sl_macdinh_34;
	}

	public static JButton getBtn_sl_macdinh_35() {
		return btn_sl_macdinh_35;
	}

	public static JButton getBtn_sl_macdinh_36() {
		return btn_sl_macdinh_36;
	}

	public static JButton getBtn_ghichu_1() {
		return btn_ghichu_1;
	}

	public static JButton getBtn_ghichu_2() {
		return btn_ghichu_2;
	}

	public static JButton getBtn_ghichu_3() {
		return btn_ghichu_3;
	}

	public static JButton getBtn_ghichu_4() {
		return btn_ghichu_4;
	}

	public static JButton getBtn_ghichu_5() {
		return btn_ghichu_5;
	}

	public static JButton getBtn_ghichu_6() {
		return btn_ghichu_6;
	}

	public static JButton getBtn_ghichu_7() {
		return btn_ghichu_7;
	}

	public static JButton getBtn_ghichu_8() {
		return btn_ghichu_8;
	}

	public static JButton getBtn_ghichu_9() {
		return btn_ghichu_9;
	}

	public static JButton getBtn_ghichu_10() {
		return btn_ghichu_10;
	}

	public static JButton getBtn_ghichu_11() {
		return btn_ghichu_11;
	}

	public static JButton getBtn_ghichu_12() {
		return btn_ghichu_12;
	}

	public static JButton getBtn_ghichu_13() {
		return btn_ghichu_13;
	}

	public static JButton getBtn_ghichu_14() {
		return btn_ghichu_14;
	}

	public static JButton getBtn_ghichu_15() {
		return btn_ghichu_15;
	}

	public static JButton getBtn_ghichu_16() {
		return btn_ghichu_16;
	}

	public static JButton getBtn_ghichu_17() {
		return btn_ghichu_17;
	}

	public static JButton getBtn_ghichu_18() {
		return btn_ghichu_18;
	}

	public static JButton getBtn_ghichu_19() {
		return btn_ghichu_19;
	}

	public static JButton getBtn_ghichu_20() {
		return btn_ghichu_20;
	}

	public static JButton getBtn_ghichu_21() {
		return btn_ghichu_21;
	}

	public static JButton getBtn_ghichu_22() {
		return btn_ghichu_22;
	}

	public static JButton getBtn_ghichu_23() {
		return btn_ghichu_23;
	}

	public static JButton getBtn_ghichu_24() {
		return btn_ghichu_24;
	}

	public static JButton getBtn_ghichu_25() {
		return btn_ghichu_25;
	}

	public static JButton getBtn_ghichu_26() {
		return btn_ghichu_26;
	}

	public static JButton getBtn_ghichu_27() {
		return btn_ghichu_27;
	}

	public static JButton getBtn_ghichu_28() {
		return btn_ghichu_28;
	}

	public static JButton getBtn_ghichu_29() {
		return btn_ghichu_29;
	}

	public static JButton getBtn_ghichu_30() {
		return btn_ghichu_30;
	}

	public static JButton getBtn_ghichu_31() {
		return btn_ghichu_31;
	}

	public static JButton getBtn_ghichu_32() {
		return btn_ghichu_32;
	}

	public static JButton getBtn_ghichu_33() {
		return btn_ghichu_33;
	}

	public static JButton getBtn_ghichu_34() {
		return btn_ghichu_34;
	}

	public static JButton getBtn_ghichu_35() {
		return btn_ghichu_35;
	}

	public static JButton getBtn_ghichu_36() {
		return btn_ghichu_36;
	}

	public JPanel getPanel_dbf_1() {
		return panel_dbf_1;
	}

	public JPanel getPanel_dbf_2() {
		return panel_dbf_2;
	}

	public JPanel getPanel_dbf_3() {
		return panel_dbf_3;
	}

	public JPanel getPanel_dbf_4() {
		return panel_dbf_4;
	}

	public JPanel getPanel_dbf_5() {
		return panel_dbf_5;
	}

	public JPanel getPanel_dbf_6() {
		return panel_dbf_6;
	}

	public JPanel getPanel_dbf_7() {
		return panel_dbf_7;
	}

	public JPanel getPanel_dbf_8() {
		return panel_dbf_8;
	}

	public JPanel getPanel_dbf_9() {
		return panel_dbf_9;
	}

	public JPanel getPanel_dbf_10() {
		return panel_dbf_10;
	}

	public JPanel getPanel_dbf_11() {
		return panel_dbf_11;
	}

	public JPanel getPanel_dbf_12() {
		return panel_dbf_12;
	}

	public JPanel getPanel_dbf_13() {
		return panel_dbf_13;
	}

	public JPanel getPanel_dbf_14() {
		return panel_dbf_14;
	}

	public JPanel getPanel_dbf_15() {
		return panel_dbf_15;
	}

	public JPanel getPanel_dbf_16() {
		return panel_dbf_16;
	}

	public JPanel getPanel_dbf_17() {
		return panel_dbf_17;
	}

	public JPanel getPanel_dbf_18() {
		return panel_dbf_18;
	}

	public JPanel getPanel_dbf_19() {
		return panel_dbf_19;
	}

	public JPanel getPanel_dbf_20() {
		return panel_dbf_20;
	}

	public JPanel getPanel_dbf_21() {
		return panel_dbf_21;
	}

	public JPanel getPanel_dbf_22() {
		return panel_dbf_22;
	}

	public JPanel getPanel_dbf_23() {
		return panel_dbf_23;
	}

	public JPanel getPanel_dbf_24() {
		return panel_dbf_24;
	}

	public JPanel getPanel_dbf_25() {
		return panel_dbf_25;
	}

	public JPanel getPanel_dbf_26() {
		return panel_dbf_26;
	}

	public JPanel getPanel_dbf_27() {
		return panel_dbf_27;
	}

	public JPanel getPanel_dbf_28() {
		return panel_dbf_28;
	}

	public JPanel getPanel_dbf_29() {
		return panel_dbf_29;
	}

	public JPanel getPanel_dbf_30() {
		return panel_dbf_30;
	}

	public JPanel getPanel_dbf_31() {
		return panel_dbf_31;
	}

	public JPanel getPanel_dbf_32() {
		return panel_dbf_32;
	}

	public JPanel getPanel_dbf_33() {
		return panel_dbf_33;
	}

	public JPanel getPanel_dbf_34() {
		return panel_dbf_34;
	}

	public JPanel getPanel_dbf_35() {
		return panel_dbf_35;
	}

	public JPanel getPanel_dbf_36() {
		return panel_dbf_36;
	}

	public JPanel getPanel_zx_1() {
		return panel_zx_1;
	}

	public JPanel getPanel_zx_2() {
		return panel_zx_2;
	}

	public JPanel getPanel_zx_3() {
		return panel_zx_3;
	}

	public JPanel getPanel_zx_4() {
		return panel_zx_4;
	}

	public JPanel getPanel_zx_5() {
		return panel_zx_5;
	}

	public JPanel getPanel_zx_6() {
		return panel_zx_6;
	}

	public JPanel getPanel_zx_7() {
		return panel_zx_7;
	}

	public JPanel getPanel_zx_8() {
		return panel_zx_8;
	}

	public JPanel getPanel_zx_9() {
		return panel_zx_9;
	}

	public JPanel getPanel_zx_10() {
		return panel_zx_10;
	}

	public JPanel getPanel_zx_11() {
		return panel_zx_11;
	}

	public JPanel getPanel_zx_12() {
		return panel_zx_12;
	}

	public JPanel getPanel_zx_13() {
		return panel_zx_13;
	}

	public JPanel getPanel_zx_14() {
		return panel_zx_14;
	}

	public JPanel getPanel_zx_15() {
		return panel_zx_15;
	}

	public JPanel getPanel_zx_16() {
		return panel_zx_16;
	}

	public JPanel getPanel_zx_17() {
		return panel_zx_17;
	}

	public JPanel getPanel_zx_18() {
		return panel_zx_18;
	}

	public JPanel getPanel_zx_19() {
		return panel_zx_19;
	}

	public JPanel getPanel_zx_20() {
		return panel_zx_20;
	}

	public JPanel getPanel_zx_21() {
		return panel_zx_21;
	}

	public JPanel getPanel_zx_22() {
		return panel_zx_22;
	}

	public JPanel getPanel_zx_23() {
		return panel_zx_23;
	}

	public JPanel getPanel_zx_24() {
		return panel_zx_24;
	}

	public JPanel getPanel_zx_25() {
		return panel_zx_25;
	}

	public JPanel getPanel_zx_26() {
		return panel_zx_26;
	}

	public JPanel getPanel_zx_27() {
		return panel_zx_27;
	}

	public JPanel getPanel_zx_28() {
		return panel_zx_28;
	}

	public JPanel getPanel_zx_29() {
		return panel_zx_29;
	}

	public JPanel getPanel_zx_30() {
		return panel_zx_30;
	}

	public JPanel getPanel_zx_31() {
		return panel_zx_31;
	}

	public JPanel getPanel_zx_32() {
		return panel_zx_32;
	}

	public JPanel getPanel_zx_33() {
		return panel_zx_33;
	}

	public JPanel getPanel_zx_34() {
		return panel_zx_34;
	}

	public JPanel getPanel_zx_35() {
		return panel_zx_35;
	}

	public JPanel getPanel_zx_36() {
		return panel_zx_36;
	}

	public JPanel getPanel_Show_HoaDon_Table_1() {
		return panel_Show_HoaDon_Table_1;
	}

	public JPanel getPanel_Show_HoaDon_Table_2() {
		return panel_Show_HoaDon_Table_2;
	}

	public JPanel getPanel_Show_HoaDon_Table_3() {
		return panel_Show_HoaDon_Table_3;
	}

	public JPanel getPanel_Show_HoaDon_Table_4() {
		return panel_Show_HoaDon_Table_4;
	}

	public JPanel getPanel_Show_HoaDon_Table_5() {
		return panel_Show_HoaDon_Table_5;
	}

	public JPanel getPanel_Show_HoaDon_Table_6() {
		return panel_Show_HoaDon_Table_6;
	}

	public JPanel getPanel_Show_HoaDon_Table_7() {
		return panel_Show_HoaDon_Table_7;
	}

	public JPanel getPanel_Show_HoaDon_Table_8() {
		return panel_Show_HoaDon_Table_8;
	}

	public JPanel getPanel_Show_HoaDon_Table_9() {
		return panel_Show_HoaDon_Table_9;
	}

	public JPanel getPanel_Show_HoaDon_Table_10() {
		return panel_Show_HoaDon_Table_10;
	}

	public JPanel getPanel_Show_HoaDon_Table_11() {
		return panel_Show_HoaDon_Table_11;
	}

	public JPanel getPanel_Show_HoaDon_Table_12() {
		return panel_Show_HoaDon_Table_12;
	}

	public JPanel getPanel_Show_HoaDon_Table_13() {
		return panel_Show_HoaDon_Table_13;
	}

	public JPanel getPanel_Show_HoaDon_Table_14() {
		return panel_Show_HoaDon_Table_14;
	}

	public JPanel getPanel_Show_HoaDon_Table_15() {
		return panel_Show_HoaDon_Table_15;
	}

	public JPanel getPanel_Show_HoaDon_Table_16() {
		return panel_Show_HoaDon_Table_16;
	}

	public JPanel getPanel_Show_HoaDon_Table_17() {
		return panel_Show_HoaDon_Table_17;
	}

	public JPanel getPanel_Show_HoaDon_Table_18() {
		return panel_Show_HoaDon_Table_18;
	}

	public JPanel getPanel_Show_HoaDon_Table_19() {
		return panel_Show_HoaDon_Table_19;
	}

	public JPanel getPanel_Show_HoaDon_Table_20() {
		return panel_Show_HoaDon_Table_20;
	}

	public JPanel getPanel_Show_HoaDon_Table_21() {
		return panel_Show_HoaDon_Table_21;
	}

	public JPanel getPanel_Show_HoaDon_Table_22() {
		return panel_Show_HoaDon_Table_22;
	}

	public JPanel getPanel_Show_HoaDon_Table_23() {
		return panel_Show_HoaDon_Table_23;
	}

	public JPanel getPanel_Show_HoaDon_Table_24() {
		return panel_Show_HoaDon_Table_24;
	}

	public JPanel getPanel_Show_HoaDon_Table_25() {
		return panel_Show_HoaDon_Table_25;
	}

	public JPanel getPanel_Show_HoaDon_Table_26() {
		return panel_Show_HoaDon_Table_26;
	}

	public JPanel getPanel_Show_HoaDon_Table_27() {
		return panel_Show_HoaDon_Table_27;
	}

	public JPanel getPanel_Show_HoaDon_Table_28() {
		return panel_Show_HoaDon_Table_28;
	}

	public JPanel getPanel_Show_HoaDon_Table_29() {
		return panel_Show_HoaDon_Table_29;
	}

	public JPanel getPanel_Show_HoaDon_Table_30() {
		return panel_Show_HoaDon_Table_30;
	}

	public JPanel getPanel_Show_HoaDon_Table_31() {
		return panel_Show_HoaDon_Table_31;
	}

	public JPanel getPanel_Show_HoaDon_Table_32() {
		return panel_Show_HoaDon_Table_32;
	}

	public JPanel getPanel_Show_HoaDon_Table_33() {
		return panel_Show_HoaDon_Table_33;
	}

	public JPanel getPanel_Show_HoaDon_Table_34() {
		return panel_Show_HoaDon_Table_34;
	}

	public JPanel getPanel_Show_HoaDon_Table_35() {
		return panel_Show_HoaDon_Table_35;
	}

	public JPanel getPanel_Show_HoaDon_Table_36() {
		return panel_Show_HoaDon_Table_36;
	}

	public static JTable getTable_1() {
		return table_1;
	}

	public static JTable getTable_2() {
		return table_2;
	}

	public static JTable getTable_3() {
		return table_3;
	}

	public static JTable getTable_4() {
		return table_4;
	}

	public static JTable getTable_5() {
		return table_5;
	}

	public static JTable getTable_6() {
		return table_6;
	}

	public static JTable getTable_7() {
		return table_7;
	}

	public static JTable getTable_8() {
		return table_8;
	}

	public static JTable getTable_9() {
		return table_9;
	}

	public static JTable getTable_10() {
		return table_10;
	}

	public static JTable getTable_11() {
		return table_11;
	}

	public static JTable getTable_12() {
		return table_12;
	}

	public static JTable getTable_13() {
		return table_13;
	}

	public static JTable getTable_14() {
		return table_14;
	}

	public static JTable getTable_15() {
		return table_15;
	}

	public static JTable getTable_16() {
		return table_16;
	}

	public static JTable getTable_17() {
		return table_17;
	}

	public static JTable getTable_18() {
		return table_18;
	}

	public static JTable getTable_19() {
		return table_19;
	}

	public static JTable getTable_20() {
		return table_20;
	}

	public static JTable getTable_21() {
		return table_21;
	}

	public static JTable getTable_22() {
		return table_22;
	}

	public static JTable getTable_23() {
		return table_23;
	}

	public static JTable getTable_24() {
		return table_24;
	}

	public static JTable getTable_25() {
		return table_25;
	}

	public static JTable getTable_26() {
		return table_26;
	}

	public static JTable getTable_27() {
		return table_27;
	}

	public static JTable getTable_28() {
		return table_28;
	}

	public static JTable getTable_29() {
		return table_29;
	}

	public static JTable getTable_30() {
		return table_30;
	}

	public static JTable getTable_31() {
		return table_31;
	}

	public static JTable getTable_32() {
		return table_32;
	}

	public static JTable getTable_33() {
		return table_33;
	}

	public static JTable getTable_34() {
		return table_34;
	}

	public static JTable getTable_35() {
		return table_35;
	}

	public static JTable getTable_36() {
		return table_36;
	}

	public static DefaultTableModel getDatamodel_1() {
		return datamodel_1;
	}

	public static DefaultTableModel getDatamodel_2() {
		return datamodel_2;
	}

	public static DefaultTableModel getDatamodel_3() {
		return datamodel_3;
	}

	public static DefaultTableModel getDatamodel_4() {
		return datamodel_4;
	}

	public static DefaultTableModel getDatamodel_5() {
		return datamodel_5;
	}

	public static DefaultTableModel getDatamodel_6() {
		return datamodel_6;
	}

	public static DefaultTableModel getDatamodel_7() {
		return datamodel_7;
	}

	public static DefaultTableModel getDatamodel_8() {
		return datamodel_8;
	}

	public static DefaultTableModel getDatamodel_9() {
		return datamodel_9;
	}

	public static DefaultTableModel getDatamodel_10() {
		return datamodel_10;
	}

	public static DefaultTableModel getDatamodel_11() {
		return datamodel_11;
	}

	public static DefaultTableModel getDatamodel_12() {
		return datamodel_12;
	}

	public static DefaultTableModel getDatamodel_13() {
		return datamodel_13;
	}

	public static DefaultTableModel getDatamodel_14() {
		return datamodel_14;
	}

	public static DefaultTableModel getDatamodel_15() {
		return datamodel_15;
	}

	public static DefaultTableModel getDatamodel_16() {
		return datamodel_16;
	}

	public static DefaultTableModel getDatamodel_17() {
		return datamodel_17;
	}

	public static DefaultTableModel getDatamodel_18() {
		return datamodel_18;
	}

	public static DefaultTableModel getDatamodel_19() {
		return datamodel_19;
	}

	public static DefaultTableModel getDatamodel_20() {
		return datamodel_20;
	}

	public static DefaultTableModel getDatamodel_21() {
		return datamodel_21;
	}

	public static DefaultTableModel getDatamodel_22() {
		return datamodel_22;
	}

	public static DefaultTableModel getDatamodel_23() {
		return datamodel_23;
	}

	public static DefaultTableModel getDatamodel_24() {
		return datamodel_24;
	}

	public static DefaultTableModel getDatamodel_25() {
		return datamodel_25;
	}

	public static DefaultTableModel getDatamodel_26() {
		return datamodel_26;
	}

	public static DefaultTableModel getDatamodel_27() {
		return datamodel_27;
	}

	public static DefaultTableModel getDatamodel_28() {
		return datamodel_28;
	}

	public static DefaultTableModel getDatamodel_29() {
		return datamodel_29;
	}

	public static DefaultTableModel getDatamodel_30() {
		return datamodel_30;
	}

	public static DefaultTableModel getDatamodel_31() {
		return datamodel_31;
	}

	public static DefaultTableModel getDatamodel_32() {
		return datamodel_32;
	}

	public static DefaultTableModel getDatamodel_33() {
		return datamodel_33;
	}

	public static DefaultTableModel getDatamodel_34() {
		return datamodel_34;
	}

	public static DefaultTableModel getDatamodel_35() {
		return datamodel_35;
	}

	public static DefaultTableModel getDatamodel_36() {
		return datamodel_36;
	}

	public static Vector getColumnames_1() {
		return columnames_1;
	}

	public static Vector getColumnames_2() {
		return columnames_2;
	}

	public static Vector getColumnames_3() {
		return columnames_3;
	}

	public static Vector getColumnames_4() {
		return columnames_4;
	}

	public static Vector getColumnames_5() {
		return columnames_5;
	}

	public static Vector getColumnames_6() {
		return columnames_6;
	}

	public static Vector getColumnames_7() {
		return columnames_7;
	}

	public static Vector getColumnames_8() {
		return columnames_8;
	}

	public static Vector getColumnames_9() {
		return columnames_9;
	}

	public static Vector getColumnames_10() {
		return columnames_10;
	}

	public static Vector getColumnames_11() {
		return columnames_11;
	}

	public static Vector getColumnames_12() {
		return columnames_12;
	}

	public static Vector getColumnames_13() {
		return columnames_13;
	}

	public static Vector getColumnames_14() {
		return columnames_14;
	}

	public static Vector getColumnames_15() {
		return columnames_15;
	}

	public static Vector getColumnames_16() {
		return columnames_16;
	}

	public static Vector getColumnames_17() {
		return columnames_17;
	}

	public static Vector getColumnames_18() {
		return columnames_18;
	}

	public static Vector getColumnames_19() {
		return columnames_19;
	}

	public static Vector getColumnames_20() {
		return columnames_20;
	}

	public static Vector getColumnames_21() {
		return columnames_21;
	}

	public static Vector getColumnames_22() {
		return columnames_22;
	}

	public static Vector getColumnames_23() {
		return columnames_23;
	}

	public static Vector getColumnames_24() {
		return columnames_24;
	}

	public static Vector getColumnames_25() {
		return columnames_25;
	}

	public static Vector getColumnames_26() {
		return columnames_26;
	}

	public static Vector getColumnames_27() {
		return columnames_27;
	}

	public static Vector getColumnames_28() {
		return columnames_28;
	}

	public static Vector getColumnames_29() {
		return columnames_29;
	}

	public static Vector getColumnames_30() {
		return columnames_30;
	}

	public static Vector getColumnames_31() {
		return columnames_31;
	}

	public static Vector getColumnames_32() {
		return columnames_32;
	}

	public static Vector getColumnames_33() {
		return columnames_33;
	}

	public static Vector getColumnames_34() {
		return columnames_34;
	}

	public static Vector getColumnames_35() {
		return columnames_35;
	}

	public static Vector getColumnames_36() {
		return columnames_36;
	}

	public static Vector getRecord_1() {
		return record_1;
	}

	public static Vector getRecord_2() {
		return record_2;
	}

	public static Vector getRecord_3() {
		return record_3;
	}

	public static Vector getRecord_4() {
		return record_4;
	}

	public static Vector getRecord_5() {
		return record_5;
	}

	public static Vector getRecord_6() {
		return record_6;
	}

	public static Vector getRecord_7() {
		return record_7;
	}

	public static Vector getRecord_8() {
		return record_8;
	}

	public static Vector getRecord_9() {
		return record_9;
	}

	public static Vector getRecord_10() {
		return record_10;
	}

	public static Vector getRecord_11() {
		return record_11;
	}

	public static Vector getRecord_12() {
		return record_12;
	}

	public static Vector getRecord_13() {
		return record_13;
	}

	public static Vector getRecord_14() {
		return record_14;
	}

	public static Vector getRecord_15() {
		return record_15;
	}

	public static Vector getRecord_16() {
		return record_16;
	}

	public static Vector getRecord_17() {
		return record_17;
	}

	public static Vector getRecord_18() {
		return record_18;
	}

	public static Vector getRecord_19() {
		return record_19;
	}

	public static Vector getRecord_20() {
		return record_20;
	}

	public static Vector getRecord_21() {
		return record_21;
	}

	public static Vector getRecord_22() {
		return record_22;
	}

	public static Vector getRecord_23() {
		return record_23;
	}

	public static Vector getRecord_24() {
		return record_24;
	}

	public static Vector getRecord_25() {
		return record_25;
	}

	public static Vector getRecord_26() {
		return record_26;
	}

	public static Vector getRecord_27() {
		return record_27;
	}

	public static Vector getRecord_28() {
		return record_28;
	}

	public static Vector getRecord_29() {
		return record_29;
	}

	public static Vector getRecord_30() {
		return record_30;
	}

	public static Vector getRecord_31() {
		return record_31;
	}

	public static Vector getRecord_32() {
		return record_32;
	}

	public static Vector getRecord_33() {
		return record_33;
	}

	public static Vector getRecord_34() {
		return record_34;
	}

	public static Vector getRecord_35() {
		return record_35;
	}

	public static Vector getRecord_36() {
		return record_36;
	}

	public JButton getBtn_thanhtoan_1() {
		return btn_thanhtoan_1;
	}

	public JButton getBtn_thanhtoan_2() {
		return btn_thanhtoan_2;
	}

	public JButton getBtn_thanhtoan_3() {
		return btn_thanhtoan_3;
	}

	public JButton getBtn_thanhtoan_4() {
		return btn_thanhtoan_4;
	}

	public JButton getBtn_thanhtoan_5() {
		return btn_thanhtoan_5;
	}

	public JButton getBtn_thanhtoan_6() {
		return btn_thanhtoan_6;
	}

	public JButton getBtn_thanhtoan_7() {
		return btn_thanhtoan_7;
	}

	public JButton getBtn_thanhtoan_8() {
		return btn_thanhtoan_8;
	}

	public JButton getBtn_thanhtoan_9() {
		return btn_thanhtoan_9;
	}

	public JButton getBtn_thanhtoan_10() {
		return btn_thanhtoan_10;
	}

	public JButton getBtn_thanhtoan_11() {
		return btn_thanhtoan_11;
	}

	public JButton getBtn_thanhtoan_12() {
		return btn_thanhtoan_12;
	}

	public JButton getBtn_thanhtoan_13() {
		return btn_thanhtoan_13;
	}

	public JButton getBtn_thanhtoan_14() {
		return btn_thanhtoan_14;
	}

	public JButton getBtn_thanhtoan_15() {
		return btn_thanhtoan_15;
	}

	public JButton getBtn_thanhtoan_16() {
		return btn_thanhtoan_16;
	}

	public JButton getBtn_thanhtoan_17() {
		return btn_thanhtoan_17;
	}

	public JButton getBtn_thanhtoan_18() {
		return btn_thanhtoan_18;
	}

	public JButton getBtn_thanhtoan_19() {
		return btn_thanhtoan_19;
	}

	public JButton getBtn_thanhtoan_20() {
		return btn_thanhtoan_20;
	}

	public JButton getBtn_thanhtoan_21() {
		return btn_thanhtoan_21;
	}

	public JButton getBtn_thanhtoan_23() {
		return btn_thanhtoan_23;
	}

	public JButton getBtn_thanhtoan_24() {
		return btn_thanhtoan_24;
	}

	public JButton getBtn_thanhtoan_25() {
		return btn_thanhtoan_25;
	}

	public JButton getBtn_thanhtoan_26() {
		return btn_thanhtoan_26;
	}

	public JButton getBtn_thanhtoan_27() {
		return btn_thanhtoan_27;
	}

	public JButton getBtn_thanhtoan_28() {
		return btn_thanhtoan_28;
	}

	public JButton getBtn_thanhtoan_29() {
		return btn_thanhtoan_29;
	}

	public JButton getBtn_thanhtoan_30() {
		return btn_thanhtoan_30;
	}

	public JButton getBtn_thanhtoan_31() {
		return btn_thanhtoan_31;
	}

	public JButton getBtn_thanhtoan_32() {
		return btn_thanhtoan_32;
	}

	public JButton getBtn_thanhtoan_33() {
		return btn_thanhtoan_33;
	}

	public JButton getBtn_thanhtoan_34() {
		return btn_thanhtoan_34;
	}

	public JButton getBtn_thanhtoan_35() {
		return btn_thanhtoan_35;
	}

	public JButton getBtn_thanhtoan_36() {
		return btn_thanhtoan_36;
	}

	public JButton getBtn_thanhtoan_22() {
		return btn_thanhtoan_22;
	}

	public JButton getBtn_capnhat_1() {
		return btn_capnhat_1;
	}

	public JButton getBtn_capnhat_2() {
		return btn_capnhat_2;
	}

	public JButton getBtn_capnhat_3() {
		return btn_capnhat_3;
	}

	public JButton getBtn_capnhat_4() {
		return btn_capnhat_4;
	}

	public JButton getBtn_capnhat_5() {
		return btn_capnhat_5;
	}

	public JButton getBtn_capnhat_6() {
		return btn_capnhat_6;
	}

	public JButton getBtn_capnhat_7() {
		return btn_capnhat_7;
	}

	public JButton getBtn_capnhat_8() {
		return btn_capnhat_8;
	}

	public JButton getBtn_capnhat_9() {
		return btn_capnhat_9;
	}

	public JButton getBtn_capnhat_10() {
		return btn_capnhat_10;
	}

	public JButton getBtn_capnhat_11() {
		return btn_capnhat_11;
	}

	public JButton getBtn_capnhat_12() {
		return btn_capnhat_12;
	}

	public JButton getBtn_capnhat_13() {
		return btn_capnhat_13;
	}

	public JButton getBtn_capnhat_14() {
		return btn_capnhat_14;
	}

	public JButton getBtn_capnhat_15() {
		return btn_capnhat_15;
	}

	public JButton getBtn_capnhat_16() {
		return btn_capnhat_16;
	}

	public JButton getBtn_capnhat_17() {
		return btn_capnhat_17;
	}

	public JButton getBtn_capnhat_18() {
		return btn_capnhat_18;
	}

	public JButton getBtn_capnhat_19() {
		return btn_capnhat_19;
	}

	public JButton getBtn_capnhat_20() {
		return btn_capnhat_20;
	}

	public JButton getBtn_capnhat_21() {
		return btn_capnhat_21;
	}

	public JButton getBtn_capnhat_22() {
		return btn_capnhat_22;
	}

	public JButton getBtn_capnhat_23() {
		return btn_capnhat_23;
	}

	public JButton getBtn_capnhat_24() {
		return btn_capnhat_24;
	}

	public JButton getBtn_capnhat_25() {
		return btn_capnhat_25;
	}

	public JButton getBtn_capnhat_26() {
		return btn_capnhat_26;
	}

	public JButton getBtn_capnhat_27() {
		return btn_capnhat_27;
	}

	public JButton getBtn_capnhat_28() {
		return btn_capnhat_28;
	}

	public JButton getBtn_capnhat_29() {
		return btn_capnhat_29;
	}

	public JButton getBtn_capnhat_30() {
		return btn_capnhat_30;
	}

	public JButton getBtn_capnhat_31() {
		return btn_capnhat_31;
	}

	public JButton getBtn_capnhat_32() {
		return btn_capnhat_32;
	}

	public JButton getBtn_capnhat_33() {
		return btn_capnhat_33;
	}

	public JButton getBtn_capnhat_34() {
		return btn_capnhat_34;
	}

	public JButton getBtn_capnhat_35() {
		return btn_capnhat_35;
	}

	public JButton getBtn_capnhat_36() {
		return btn_capnhat_36;
	}

	public JButton getBtn_thucdon_1() {
		return btn_thucdon_1;
	}

	public JButton getBtn_thucdon_2() {
		return btn_thucdon_2;
	}

	public JButton getBtn_thucdon_3() {
		return btn_thucdon_3;
	}

	public JButton getBtn_thucdon_4() {
		return btn_thucdon_4;
	}

	public JButton getBtn_thucdon_5() {
		return btn_thucdon_5;
	}

	public JButton getBtn_thucdon_6() {
		return btn_thucdon_6;
	}

	public JButton getBtn_thucdon_7() {
		return btn_thucdon_7;
	}

	public JButton getBtn_thucdon_8() {
		return btn_thucdon_8;
	}

	public JButton getBtn_thucdon_9() {
		return btn_thucdon_9;
	}

	public JButton getBtn_thucdon_10() {
		return btn_thucdon_10;
	}

	public JButton getBtn_thucdon_11() {
		return btn_thucdon_11;
	}

	public JButton getBtn_thucdon_12() {
		return btn_thucdon_12;
	}

	public JButton getBtn_thucdon_13() {
		return btn_thucdon_13;
	}

	public JButton getBtn_thucdon_14() {
		return btn_thucdon_14;
	}

	public JButton getBtn_thucdon_15() {
		return btn_thucdon_15;
	}

	public JButton getBtn_thucdon_16() {
		return btn_thucdon_16;
	}

	public JButton getBtn_thucdon_17() {
		return btn_thucdon_17;
	}

	public JButton getBtn_thucdon_18() {
		return btn_thucdon_18;
	}

	public JButton getBtn_thucdon_19() {
		return btn_thucdon_19;
	}

	public JButton getBtn_thucdon_20() {
		return btn_thucdon_20;
	}

	public JButton getBtn_thucdon_21() {
		return btn_thucdon_21;
	}

	public JButton getBtn_thucdon_22() {
		return btn_thucdon_22;
	}

	public JButton getBtn_thucdon_23() {
		return btn_thucdon_23;
	}

	public JButton getBtn_thucdon_24() {
		return btn_thucdon_24;
	}

	public JButton getBtn_thucdon_25() {
		return btn_thucdon_25;
	}

	public JButton getBtn_thucdon_26() {
		return btn_thucdon_26;
	}

	public JButton getBtn_thucdon_27() {
		return btn_thucdon_27;
	}

	public JButton getBtn_thucdon_28() {
		return btn_thucdon_28;
	}

	public JButton getBtn_thucdon_29() {
		return btn_thucdon_29;
	}

	public JButton getBtn_thucdon_30() {
		return btn_thucdon_30;
	}

	public JButton getBtn_thucdon_31() {
		return btn_thucdon_31;
	}

	public JButton getBtn_thucdon_32() {
		return btn_thucdon_32;
	}

	public JButton getBtn_thucdon_33() {
		return btn_thucdon_33;
	}

	public JButton getBtn_thucdon_34() {
		return btn_thucdon_34;
	}

	public JButton getBtn_thucdon_35() {
		return btn_thucdon_35;
	}

	public JButton getBtn_thucdon_36() {
		return btn_thucdon_36;
	}

	public static void setToolbar(JToolBar toolbar) {
		DatBan_Panel.toolbar = toolbar;
	}

	public static void setBtnF(JButton btnF) {
		DatBan_Panel.btnF = btnF;
	}

	public static void setBtnP(JButton btnP) {
		DatBan_Panel.btnP = btnP;
	}

	public static void setBtnN(JButton btnN) {
		DatBan_Panel.btnN = btnN;
	}

	public static void setBtnL(JButton btnL) {
		DatBan_Panel.btnL = btnL;
	}

	public static void setBtnAdd(JButton btnAdd) {
		DatBan_Panel.btnAdd = btnAdd;
	}

	public static void setBtnSave(JButton btnSave) {
		DatBan_Panel.btnSave = btnSave;
	}

	public static void setBtnDelete(JButton btnDelete) {
		DatBan_Panel.btnDelete = btnDelete;
	}

	public static void setDtm(DefaultTableModel dtm) {
		DatBan_Panel.dtm = dtm;
	}

	public static void setAction(UpdateAction_HoaDon action) {
		DatBan_Panel.action = action;
	}

	public static void setStatusBar(JLabel statusBar) {
		DatBan_Panel.statusBar = statusBar;
	}

	public static void setLst(ArrayList<HoaDon> lst) {
		DatBan_Panel.lst = lst;
	}

	public static void setCurPos(int curPos) {
		DatBan_Panel.curPos = curPos;
	}

	public static void setLblPos(JLabel lblPos) {
		DatBan_Panel.lblPos = lblPos;
	}

	public static void setNoExistRecords(int noExistRecords) {
		NoExistRecords = noExistRecords;
	}

	public void setTitle_Panel(JPanel title_Panel) {
		this.title_Panel = title_Panel;
	}

	public void setSplitPanel_Right(JPanel splitPanel_Right) {
		SplitPanel_Right = splitPanel_Right;
	}

	public void setSplitPanel_Left(JPanel splitPanel_Left) {
		SplitPanel_Left = splitPanel_Left;
	}

	public void setSplitPane(JSplitPane splitPane) {
		this.splitPane = splitPane;
	}

	public void setTpKhuVuc(JTabbedPane tpKhuVuc) {
		this.tpKhuVuc = tpKhuVuc;
	}

	public void setPkhu(JPanel pkhu) {
		this.pkhu = pkhu;
	}

	public void setPanel_tangtret(JPanel panel_tangtret) {
		this.panel_tangtret = panel_tangtret;
	}

	public void setPanel_tang1(JPanel panel_tang1) {
		this.panel_tang1 = panel_tang1;
	}

	public void setPanel_tang2(JPanel panel_tang2) {
		this.panel_tang2 = panel_tang2;
	}

	public static void setBt100(JButton bt100) {
		DatBan_Panel.bt100 = bt100;
	}

	public static void setBt101(JButton bt101) {
		DatBan_Panel.bt101 = bt101;
	}

	public static void setBt102(JButton bt102) {
		DatBan_Panel.bt102 = bt102;
	}

	public static void setBt103(JButton bt103) {
		DatBan_Panel.bt103 = bt103;
	}

	public static void setBt104(JButton bt104) {
		DatBan_Panel.bt104 = bt104;
	}

	public static void setBt105(JButton bt105) {
		DatBan_Panel.bt105 = bt105;
	}

	public static void setBt106(JButton bt106) {
		DatBan_Panel.bt106 = bt106;
	}

	public static void setBt107(JButton bt107) {
		DatBan_Panel.bt107 = bt107;
	}

	public static void setBt108(JButton bt108) {
		DatBan_Panel.bt108 = bt108;
	}

	public static void setBt109(JButton bt109) {
		DatBan_Panel.bt109 = bt109;
	}

	public static void setBt200(JButton bt200) {
		DatBan_Panel.bt200 = bt200;
	}

	public static void setBt201(JButton bt201) {
		DatBan_Panel.bt201 = bt201;
	}

	public static void setBt202(JButton bt202) {
		DatBan_Panel.bt202 = bt202;
	}

	public static void setBt203(JButton bt203) {
		DatBan_Panel.bt203 = bt203;
	}

	public static void setBt204(JButton bt204) {
		DatBan_Panel.bt204 = bt204;
	}

	public static void setBt205(JButton bt205) {
		DatBan_Panel.bt205 = bt205;
	}

	public static void setBt206(JButton bt206) {
		DatBan_Panel.bt206 = bt206;
	}

	public static void setBt207(JButton bt207) {
		DatBan_Panel.bt207 = bt207;
	}

	public static void setBt208(JButton bt208) {
		DatBan_Panel.bt208 = bt208;
	}

	public static void setBt209(JButton bt209) {
		DatBan_Panel.bt209 = bt209;
	}

	public static void setBt_01(JButton bt_01) {
		DatBan_Panel.bt_01 = bt_01;
	}

	public static void setBt_02(JButton bt_02) {
		DatBan_Panel.bt_02 = bt_02;
	}

	public static void setBt_03(JButton bt_03) {
		DatBan_Panel.bt_03 = bt_03;
	}

	public static void setBt_04(JButton bt_04) {
		DatBan_Panel.bt_04 = bt_04;
	}

	public static void setBt_05(JButton bt_05) {
		DatBan_Panel.bt_05 = bt_05;
	}

	public static void setBt_06(JButton bt_06) {
		DatBan_Panel.bt_06 = bt_06;
	}

	public static void setBt_07(JButton bt_07) {
		DatBan_Panel.bt_07 = bt_07;
	}

	public static void setBt_08(JButton bt_08) {
		DatBan_Panel.bt_08 = bt_08;
	}

	public static void setBt_09(JButton bt_09) {
		DatBan_Panel.bt_09 = bt_09;
	}

	public static void setBt_10(JButton bt_10) {
		DatBan_Panel.bt_10 = bt_10;
	}

	public static void setBt_11(JButton bt_11) {
		DatBan_Panel.bt_11 = bt_11;
	}

	public static void setBt_12(JButton bt_12) {
		DatBan_Panel.bt_12 = bt_12;
	}

	public static void setBt_109(JButton bt_109) {
		DatBan_Panel.bt_109 = bt_109;
	}

	public static void setBt_110(JButton bt_110) {
		DatBan_Panel.bt_110 = bt_110;
	}

	public static void setBt_111(JButton bt_111) {
		DatBan_Panel.bt_111 = bt_111;
	}

	public static void setBt_209(JButton bt_209) {
		DatBan_Panel.bt_209 = bt_209;
	}

	public static void setBt210(JButton bt210) {
		DatBan_Panel.bt210 = bt210;
	}

	public static void setBt211(JButton bt211) {
		DatBan_Panel.bt211 = bt211;
	}

	public void setGioiThieu_DatBan_Panel(JPanel gioiThieu_DatBan_Panel) {
		this.gioiThieu_DatBan_Panel = gioiThieu_DatBan_Panel;
	}

	public void setTangTret_1(JPanel tangTret_1) {
		TangTret_1 = tangTret_1;
	}

	public void setTangTret_2(JPanel tangTret_2) {
		TangTret_2 = tangTret_2;
	}

	public void setTangTret_3(JPanel tangTret_3) {
		TangTret_3 = tangTret_3;
	}

	public void setTangTret_4(JPanel tangTret_4) {
		TangTret_4 = tangTret_4;
	}

	public void setTangTret_5(JPanel tangTret_5) {
		TangTret_5 = tangTret_5;
	}

	public void setTangTret_6(JPanel tangTret_6) {
		TangTret_6 = tangTret_6;
	}

	public void setTangTret_7(JPanel tangTret_7) {
		TangTret_7 = tangTret_7;
	}

	public void setTangTret_8(JPanel tangTret_8) {
		TangTret_8 = tangTret_8;
	}

	public void setTangTret_9(JPanel tangTret_9) {
		TangTret_9 = tangTret_9;
	}

	public void setTangTret_10(JPanel tangTret_10) {
		TangTret_10 = tangTret_10;
	}

	public void setTangTret_11(JPanel tangTret_11) {
		TangTret_11 = tangTret_11;
	}

	public void setTangTret_12(JPanel tangTret_12) {
		TangTret_12 = tangTret_12;
	}

	public void setTang1_11(JPanel tang1_11) {
		Tang1_11 = tang1_11;
	}

	public void setTang1_12(JPanel tang1_12) {
		Tang1_12 = tang1_12;
	}

	public void setTang1_13(JPanel tang1_13) {
		Tang1_13 = tang1_13;
	}

	public void setTang1_14(JPanel tang1_14) {
		Tang1_14 = tang1_14;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public void setLblChiTitHo(JLabel lblChiTitHo) {
		this.lblChiTitHo = lblChiTitHo;
	}

	public void setLblSBn(JLabel lblSBn) {
		this.lblSBn = lblSBn;
	}

	public void setLblNgyNhp(JLabel lblNgyNhp) {
		this.lblNgyNhp = lblNgyNhp;
	}

	public static void setModel(UtilDateModel model) {
		DatBan_Panel.model = model;
	}

	public static void setDatePanel(JDatePanelImpl datePanel) {
		DatBan_Panel.datePanel = datePanel;
	}

	public void setLblMKh(JLabel lblMKh) {
		this.lblMKh = lblMKh;
	}

	public static void setScroll(JScrollPane scroll) {
		DatBan_Panel.scroll = scroll;
	}

	public static void setTf_soban_1(JTextField tf_soban_1) {
		DatBan_Panel.tf_soban_1 = tf_soban_1;
	}

	public static void setTf_soban_2(JTextField tf_soban_2) {
		DatBan_Panel.tf_soban_2 = tf_soban_2;
	}

	public static void setTf_soban_3(JTextField tf_soban_3) {
		DatBan_Panel.tf_soban_3 = tf_soban_3;
	}

	public static void setTf_soban_4(JTextField tf_soban_4) {
		DatBan_Panel.tf_soban_4 = tf_soban_4;
	}

	public static void setTf_soban_5(JTextField tf_soban_5) {
		DatBan_Panel.tf_soban_5 = tf_soban_5;
	}

	public static void setTf_soban_6(JTextField tf_soban_6) {
		DatBan_Panel.tf_soban_6 = tf_soban_6;
	}

	public static void setTf_soban_7(JTextField tf_soban_7) {
		DatBan_Panel.tf_soban_7 = tf_soban_7;
	}

	public static void setTf_soban_8(JTextField tf_soban_8) {
		DatBan_Panel.tf_soban_8 = tf_soban_8;
	}

	public static void setTf_soban_9(JTextField tf_soban_9) {
		DatBan_Panel.tf_soban_9 = tf_soban_9;
	}

	public static void setTf_soban_10(JTextField tf_soban_10) {
		DatBan_Panel.tf_soban_10 = tf_soban_10;
	}

	public static void setTf_soban_11(JTextField tf_soban_11) {
		DatBan_Panel.tf_soban_11 = tf_soban_11;
	}

	public static void setTf_soban_12(JTextField tf_soban_12) {
		DatBan_Panel.tf_soban_12 = tf_soban_12;
	}

	public static void setTf_soban_13(JTextField tf_soban_13) {
		DatBan_Panel.tf_soban_13 = tf_soban_13;
	}

	public static void setTf_soban_14(JTextField tf_soban_14) {
		DatBan_Panel.tf_soban_14 = tf_soban_14;
	}

	public static void setTf_soban_15(JTextField tf_soban_15) {
		DatBan_Panel.tf_soban_15 = tf_soban_15;
	}

	public static void setTf_soban_16(JTextField tf_soban_16) {
		DatBan_Panel.tf_soban_16 = tf_soban_16;
	}

	public static void setTf_soban_17(JTextField tf_soban_17) {
		DatBan_Panel.tf_soban_17 = tf_soban_17;
	}

	public static void setTf_soban_18(JTextField tf_soban_18) {
		DatBan_Panel.tf_soban_18 = tf_soban_18;
	}

	public static void setTf_soban_19(JTextField tf_soban_19) {
		DatBan_Panel.tf_soban_19 = tf_soban_19;
	}

	public static void setTf_soban_20(JTextField tf_soban_20) {
		DatBan_Panel.tf_soban_20 = tf_soban_20;
	}

	public static void setTf_soban_21(JTextField tf_soban_21) {
		DatBan_Panel.tf_soban_21 = tf_soban_21;
	}

	public static void setTf_soban_22(JTextField tf_soban_22) {
		DatBan_Panel.tf_soban_22 = tf_soban_22;
	}

	public static void setTf_soban_23(JTextField tf_soban_23) {
		DatBan_Panel.tf_soban_23 = tf_soban_23;
	}

	public static void setTf_soban_24(JTextField tf_soban_24) {
		DatBan_Panel.tf_soban_24 = tf_soban_24;
	}

	public static void setTf_soban_25(JTextField tf_soban_25) {
		DatBan_Panel.tf_soban_25 = tf_soban_25;
	}

	public static void setTf_soban_26(JTextField tf_soban_26) {
		DatBan_Panel.tf_soban_26 = tf_soban_26;
	}

	public static void setTf_soban_27(JTextField tf_soban_27) {
		DatBan_Panel.tf_soban_27 = tf_soban_27;
	}

	public static void setTf_soban_28(JTextField tf_soban_28) {
		DatBan_Panel.tf_soban_28 = tf_soban_28;
	}

	public static void setTf_soban_29(JTextField tf_soban_29) {
		DatBan_Panel.tf_soban_29 = tf_soban_29;
	}

	public static void setTf_soban_30(JTextField tf_soban_30) {
		DatBan_Panel.tf_soban_30 = tf_soban_30;
	}

	public static void setTf_soban_31(JTextField tf_soban_31) {
		DatBan_Panel.tf_soban_31 = tf_soban_31;
	}

	public static void setTf_soban_32(JTextField tf_soban_32) {
		DatBan_Panel.tf_soban_32 = tf_soban_32;
	}

	public static void setTf_soban_33(JTextField tf_soban_33) {
		DatBan_Panel.tf_soban_33 = tf_soban_33;
	}

	public static void setTf_soban_34(JTextField tf_soban_34) {
		DatBan_Panel.tf_soban_34 = tf_soban_34;
	}

	public static void setTf_soban_35(JTextField tf_soban_35) {
		DatBan_Panel.tf_soban_35 = tf_soban_35;
	}

	public static void setTf_soban_36(JTextField tf_soban_36) {
		DatBan_Panel.tf_soban_36 = tf_soban_36;
	}

	public void setPanel_theotungban_1(JPanel panel_theotungban_1) {
		this.panel_theotungban_1 = panel_theotungban_1;
	}

	public void setPanel_theotungban_2(JPanel panel_theotungban_2) {
		this.panel_theotungban_2 = panel_theotungban_2;
	}

	public void setPanel_theotungban_3(JPanel panel_theotungban_3) {
		this.panel_theotungban_3 = panel_theotungban_3;
	}

	public void setPanel_theotungban_4(JPanel panel_theotungban_4) {
		this.panel_theotungban_4 = panel_theotungban_4;
	}

	public void setPanel_theotungban_5(JPanel panel_theotungban_5) {
		this.panel_theotungban_5 = panel_theotungban_5;
	}

	public void setPanel_theotungban_6(JPanel panel_theotungban_6) {
		this.panel_theotungban_6 = panel_theotungban_6;
	}

	public void setPanel_theotungban_7(JPanel panel_theotungban_7) {
		this.panel_theotungban_7 = panel_theotungban_7;
	}

	public void setPanel_theotungban_8(JPanel panel_theotungban_8) {
		this.panel_theotungban_8 = panel_theotungban_8;
	}

	public void setPanel_theotungban_9(JPanel panel_theotungban_9) {
		this.panel_theotungban_9 = panel_theotungban_9;
	}

	public void setPanel_theotungban_10(JPanel panel_theotungban_10) {
		this.panel_theotungban_10 = panel_theotungban_10;
	}

	public void setPanel_theotungban_11(JPanel panel_theotungban_11) {
		this.panel_theotungban_11 = panel_theotungban_11;
	}

	public void setPanel_theotungban_12(JPanel panel_theotungban_12) {
		this.panel_theotungban_12 = panel_theotungban_12;
	}

	public void setPanel_theotungban_13(JPanel panel_theotungban_13) {
		this.panel_theotungban_13 = panel_theotungban_13;
	}

	public void setPanel_theotungban_14(JPanel panel_theotungban_14) {
		this.panel_theotungban_14 = panel_theotungban_14;
	}

	public void setPanel_theotungban_15(JPanel panel_theotungban_15) {
		this.panel_theotungban_15 = panel_theotungban_15;
	}

	public void setPanel_theotungban_16(JPanel panel_theotungban_16) {
		this.panel_theotungban_16 = panel_theotungban_16;
	}

	public void setPanel_theotungban_17(JPanel panel_theotungban_17) {
		this.panel_theotungban_17 = panel_theotungban_17;
	}

	public void setPanel_theotungban_18(JPanel panel_theotungban_18) {
		this.panel_theotungban_18 = panel_theotungban_18;
	}

	public void setPanel_theotungban_19(JPanel panel_theotungban_19) {
		this.panel_theotungban_19 = panel_theotungban_19;
	}

	public void setPanel_theotungban_20(JPanel panel_theotungban_20) {
		this.panel_theotungban_20 = panel_theotungban_20;
	}

	public void setPanel_theotungban_21(JPanel panel_theotungban_21) {
		this.panel_theotungban_21 = panel_theotungban_21;
	}

	public void setPanel_theotungban_22(JPanel panel_theotungban_22) {
		this.panel_theotungban_22 = panel_theotungban_22;
	}

	public void setPanel_theotungban_23(JPanel panel_theotungban_23) {
		this.panel_theotungban_23 = panel_theotungban_23;
	}

	public void setPanel_theotungban_24(JPanel panel_theotungban_24) {
		this.panel_theotungban_24 = panel_theotungban_24;
	}

	public void setPanel_theotungban_25(JPanel panel_theotungban_25) {
		this.panel_theotungban_25 = panel_theotungban_25;
	}

	public void setPanel_theotungban_26(JPanel panel_theotungban_26) {
		this.panel_theotungban_26 = panel_theotungban_26;
	}

	public void setPanel_theotungban_27(JPanel panel_theotungban_27) {
		this.panel_theotungban_27 = panel_theotungban_27;
	}

	public void setPanel_theotungban_28(JPanel panel_theotungban_28) {
		this.panel_theotungban_28 = panel_theotungban_28;
	}

	public void setPanel_theotungban_29(JPanel panel_theotungban_29) {
		this.panel_theotungban_29 = panel_theotungban_29;
	}

	public void setPanel_theotungban_30(JPanel panel_theotungban_30) {
		this.panel_theotungban_30 = panel_theotungban_30;
	}

	public void setPanel_theotungban_31(JPanel panel_theotungban_31) {
		this.panel_theotungban_31 = panel_theotungban_31;
	}

	public void setPanel_theotungban_32(JPanel panel_theotungban_32) {
		this.panel_theotungban_32 = panel_theotungban_32;
	}

	public void setPanel_theotungban_33(JPanel panel_theotungban_33) {
		this.panel_theotungban_33 = panel_theotungban_33;
	}

	public void setPanel_theotungban_34(JPanel panel_theotungban_34) {
		this.panel_theotungban_34 = panel_theotungban_34;
	}

	public void setPanel_theotungban_35(JPanel panel_theotungban_35) {
		this.panel_theotungban_35 = panel_theotungban_35;
	}

	public void setPanel_theotungban_36(JPanel panel_theotungban_36) {
		this.panel_theotungban_36 = panel_theotungban_36;
	}

	public void setPanel_abc_1(JPanel panel_abc_1) {
		this.panel_abc_1 = panel_abc_1;
	}

	public void setPanel_abc_2(JPanel panel_abc_2) {
		this.panel_abc_2 = panel_abc_2;
	}

	public void setPanel_abc_3(JPanel panel_abc_3) {
		this.panel_abc_3 = panel_abc_3;
	}

	public void setPanel_abc_4(JPanel panel_abc_4) {
		this.panel_abc_4 = panel_abc_4;
	}

	public void setPanel_abc_5(JPanel panel_abc_5) {
		this.panel_abc_5 = panel_abc_5;
	}

	public void setPanel_abc_6(JPanel panel_abc_6) {
		this.panel_abc_6 = panel_abc_6;
	}

	public void setPanel_abc_7(JPanel panel_abc_7) {
		this.panel_abc_7 = panel_abc_7;
	}

	public void setPanel_abc_8(JPanel panel_abc_8) {
		this.panel_abc_8 = panel_abc_8;
	}

	public void setPanel_abc_9(JPanel panel_abc_9) {
		this.panel_abc_9 = panel_abc_9;
	}

	public void setPanel_abc_10(JPanel panel_abc_10) {
		this.panel_abc_10 = panel_abc_10;
	}

	public void setPanel_abc_11(JPanel panel_abc_11) {
		this.panel_abc_11 = panel_abc_11;
	}

	public void setPanel_abc_12(JPanel panel_abc_12) {
		this.panel_abc_12 = panel_abc_12;
	}

	public void setPanel_abc_13(JPanel panel_abc_13) {
		this.panel_abc_13 = panel_abc_13;
	}

	public void setPanel_abc_14(JPanel panel_abc_14) {
		this.panel_abc_14 = panel_abc_14;
	}

	public void setPanel_abc_15(JPanel panel_abc_15) {
		this.panel_abc_15 = panel_abc_15;
	}

	public void setPanel_abc_16(JPanel panel_abc_16) {
		this.panel_abc_16 = panel_abc_16;
	}

	public void setPanel_abc_17(JPanel panel_abc_17) {
		this.panel_abc_17 = panel_abc_17;
	}

	public void setPanel_abc_18(JPanel panel_abc_18) {
		this.panel_abc_18 = panel_abc_18;
	}

	public void setPanel_abc_19(JPanel panel_abc_19) {
		this.panel_abc_19 = panel_abc_19;
	}

	public void setPanel_abc_20(JPanel panel_abc_20) {
		this.panel_abc_20 = panel_abc_20;
	}

	public void setPanel_abc_21(JPanel panel_abc_21) {
		this.panel_abc_21 = panel_abc_21;
	}

	public void setPanel_abc_22(JPanel panel_abc_22) {
		this.panel_abc_22 = panel_abc_22;
	}

	public void setPanel_abc_23(JPanel panel_abc_23) {
		this.panel_abc_23 = panel_abc_23;
	}

	public void setPanel_abc_24(JPanel panel_abc_24) {
		this.panel_abc_24 = panel_abc_24;
	}

	public void setPanel_abc_25(JPanel panel_abc_25) {
		this.panel_abc_25 = panel_abc_25;
	}

	public void setPanel_abc_26(JPanel panel_abc_26) {
		this.panel_abc_26 = panel_abc_26;
	}

	public void setPanel_abc_27(JPanel panel_abc_27) {
		this.panel_abc_27 = panel_abc_27;
	}

	public void setPanel_abc_28(JPanel panel_abc_28) {
		this.panel_abc_28 = panel_abc_28;
	}

	public void setPanel_abc_29(JPanel panel_abc_29) {
		this.panel_abc_29 = panel_abc_29;
	}

	public void setPanel_abc_30(JPanel panel_abc_30) {
		this.panel_abc_30 = panel_abc_30;
	}

	public void setPanel_abc_31(JPanel panel_abc_31) {
		this.panel_abc_31 = panel_abc_31;
	}

	public void setPanel_abc_32(JPanel panel_abc_32) {
		this.panel_abc_32 = panel_abc_32;
	}

	public void setPanel_abc_33(JPanel panel_abc_33) {
		this.panel_abc_33 = panel_abc_33;
	}

	public void setPanel_abc_34(JPanel panel_abc_34) {
		this.panel_abc_34 = panel_abc_34;
	}

	public void setPanel_abc_35(JPanel panel_abc_35) {
		this.panel_abc_35 = panel_abc_35;
	}

	public void setPanel_abc_36(JPanel panel_abc_36) {
		this.panel_abc_36 = panel_abc_36;
	}

	public static void setCheck_1(int check_1) {
		DatBan_Panel.check_1 = check_1;
	}

	public static void setCheck_2(int check_2) {
		DatBan_Panel.check_2 = check_2;
	}

	public static void setCheck_3(int check_3) {
		DatBan_Panel.check_3 = check_3;
	}

	public static void setCheck_4(int check_4) {
		DatBan_Panel.check_4 = check_4;
	}

	public static void setCheck_5(int check_5) {
		DatBan_Panel.check_5 = check_5;
	}

	public static void setCheck_6(int check_6) {
		DatBan_Panel.check_6 = check_6;
	}

	public static void setCheck_7(int check_7) {
		DatBan_Panel.check_7 = check_7;
	}

	public static void setCheck_8(int check_8) {
		DatBan_Panel.check_8 = check_8;
	}

	public static void setCheck_9(int check_9) {
		DatBan_Panel.check_9 = check_9;
	}

	public static void setCheck_10(int check_10) {
		DatBan_Panel.check_10 = check_10;
	}

	public static void setCheck_11(int check_11) {
		DatBan_Panel.check_11 = check_11;
	}

	public static void setCheck_12(int check_12) {
		DatBan_Panel.check_12 = check_12;
	}

	public static void setCheck_13(int check_13) {
		DatBan_Panel.check_13 = check_13;
	}

	public static void setCheck_14(int check_14) {
		DatBan_Panel.check_14 = check_14;
	}

	public static void setCheck_15(int check_15) {
		DatBan_Panel.check_15 = check_15;
	}

	public static void setCheck_16(int check_16) {
		DatBan_Panel.check_16 = check_16;
	}

	public static void setCheck_17(int check_17) {
		DatBan_Panel.check_17 = check_17;
	}

	public static void setCheck_18(int check_18) {
		DatBan_Panel.check_18 = check_18;
	}

	public static void setCheck_19(int check_19) {
		DatBan_Panel.check_19 = check_19;
	}

	public static void setCheck_20(int check_20) {
		DatBan_Panel.check_20 = check_20;
	}

	public static void setCheck_21(int check_21) {
		DatBan_Panel.check_21 = check_21;
	}

	public static void setCheck_22(int check_22) {
		DatBan_Panel.check_22 = check_22;
	}

	public static void setCheck_23(int check_23) {
		DatBan_Panel.check_23 = check_23;
	}

	public static void setCheck_24(int check_24) {
		DatBan_Panel.check_24 = check_24;
	}

	public static void setCheck_25(int check_25) {
		DatBan_Panel.check_25 = check_25;
	}

	public static void setCheck_26(int check_26) {
		DatBan_Panel.check_26 = check_26;
	}

	public static void setCheck_27(int check_27) {
		DatBan_Panel.check_27 = check_27;
	}

	public static void setCheck_28(int check_28) {
		DatBan_Panel.check_28 = check_28;
	}

	public static void setCheck_29(int check_29) {
		DatBan_Panel.check_29 = check_29;
	}

	public static void setCheck_30(int check_30) {
		DatBan_Panel.check_30 = check_30;
	}

	public static void setCheck_31(int check_31) {
		DatBan_Panel.check_31 = check_31;
	}

	public static void setCheck_32(int check_32) {
		DatBan_Panel.check_32 = check_32;
	}

	public static void setCheck_33(int check_33) {
		DatBan_Panel.check_33 = check_33;
	}

	public static void setCheck_34(int check_34) {
		DatBan_Panel.check_34 = check_34;
	}

	public static void setCheck_35(int check_35) {
		DatBan_Panel.check_35 = check_35;
	}

	public static void setCheck_36(int check_36) {
		DatBan_Panel.check_36 = check_36;
	}

	public static void setDatePicker_1(JDatePickerImpl datePicker_1) {
		DatBan_Panel.datePicker_1 = datePicker_1;
	}

	public static void setDatePicker_2(JDatePickerImpl datePicker_2) {
		DatBan_Panel.datePicker_2 = datePicker_2;
	}

	public static void setDatePicker_3(JDatePickerImpl datePicker_3) {
		DatBan_Panel.datePicker_3 = datePicker_3;
	}

	public static void setDatePicker_4(JDatePickerImpl datePicker_4) {
		DatBan_Panel.datePicker_4 = datePicker_4;
	}

	public static void setDatePicker_5(JDatePickerImpl datePicker_5) {
		DatBan_Panel.datePicker_5 = datePicker_5;
	}

	public static void setDatePicker_6(JDatePickerImpl datePicker_6) {
		DatBan_Panel.datePicker_6 = datePicker_6;
	}

	public static void setDatePicker_7(JDatePickerImpl datePicker_7) {
		DatBan_Panel.datePicker_7 = datePicker_7;
	}

	public static void setDatePicker_8(JDatePickerImpl datePicker_8) {
		DatBan_Panel.datePicker_8 = datePicker_8;
	}

	public static void setDatePicker_9(JDatePickerImpl datePicker_9) {
		DatBan_Panel.datePicker_9 = datePicker_9;
	}

	public static void setDatePicker_10(JDatePickerImpl datePicker_10) {
		DatBan_Panel.datePicker_10 = datePicker_10;
	}

	public static void setDatePicker_11(JDatePickerImpl datePicker_11) {
		DatBan_Panel.datePicker_11 = datePicker_11;
	}

	public static void setDatePicker_12(JDatePickerImpl datePicker_12) {
		DatBan_Panel.datePicker_12 = datePicker_12;
	}

	public static void setDatePicker_13(JDatePickerImpl datePicker_13) {
		DatBan_Panel.datePicker_13 = datePicker_13;
	}

	public static void setDatePicker_14(JDatePickerImpl datePicker_14) {
		DatBan_Panel.datePicker_14 = datePicker_14;
	}

	public static void setDatePicker_15(JDatePickerImpl datePicker_15) {
		DatBan_Panel.datePicker_15 = datePicker_15;
	}

	public static void setDatePicker_16(JDatePickerImpl datePicker_16) {
		DatBan_Panel.datePicker_16 = datePicker_16;
	}

	public static void setDatePicker_17(JDatePickerImpl datePicker_17) {
		DatBan_Panel.datePicker_17 = datePicker_17;
	}

	public static void setDatePicker_18(JDatePickerImpl datePicker_18) {
		DatBan_Panel.datePicker_18 = datePicker_18;
	}

	public static void setDatePicker_19(JDatePickerImpl datePicker_19) {
		DatBan_Panel.datePicker_19 = datePicker_19;
	}

	public static void setDatePicker_20(JDatePickerImpl datePicker_20) {
		DatBan_Panel.datePicker_20 = datePicker_20;
	}

	public static void setDatePicker_21(JDatePickerImpl datePicker_21) {
		DatBan_Panel.datePicker_21 = datePicker_21;
	}

	public static void setDatePicker_22(JDatePickerImpl datePicker_22) {
		DatBan_Panel.datePicker_22 = datePicker_22;
	}

	public static void setDatePicker_23(JDatePickerImpl datePicker_23) {
		DatBan_Panel.datePicker_23 = datePicker_23;
	}

	public static void setDatePicker_24(JDatePickerImpl datePicker_24) {
		DatBan_Panel.datePicker_24 = datePicker_24;
	}

	public static void setDatePicker_25(JDatePickerImpl datePicker_25) {
		DatBan_Panel.datePicker_25 = datePicker_25;
	}

	public static void setDatePicker_26(JDatePickerImpl datePicker_26) {
		DatBan_Panel.datePicker_26 = datePicker_26;
	}

	public static void setDatePicker_27(JDatePickerImpl datePicker_27) {
		DatBan_Panel.datePicker_27 = datePicker_27;
	}

	public static void setDatePicker_28(JDatePickerImpl datePicker_28) {
		DatBan_Panel.datePicker_28 = datePicker_28;
	}

	public static void setDatePicker_29(JDatePickerImpl datePicker_29) {
		DatBan_Panel.datePicker_29 = datePicker_29;
	}

	public static void setDatePicker_30(JDatePickerImpl datePicker_30) {
		DatBan_Panel.datePicker_30 = datePicker_30;
	}

	public static void setDatePicker_31(JDatePickerImpl datePicker_31) {
		DatBan_Panel.datePicker_31 = datePicker_31;
	}

	public static void setDatePicker_32(JDatePickerImpl datePicker_32) {
		DatBan_Panel.datePicker_32 = datePicker_32;
	}

	public static void setDatePicker_33(JDatePickerImpl datePicker_33) {
		DatBan_Panel.datePicker_33 = datePicker_33;
	}

	public static void setDatePicker_34(JDatePickerImpl datePicker_34) {
		DatBan_Panel.datePicker_34 = datePicker_34;
	}

	public static void setDatePicker_35(JDatePickerImpl datePicker_35) {
		DatBan_Panel.datePicker_35 = datePicker_35;
	}

	public static void setDatePicker_36(JDatePickerImpl datePicker_36) {
		DatBan_Panel.datePicker_36 = datePicker_36;
	}

	public static void setTf_maKH_HD_1(JTextField tf_maKH_HD_1) {
		DatBan_Panel.tf_maKH_HD_1 = tf_maKH_HD_1;
	}

	public static void setTf_maKH_HD_2(JTextField tf_maKH_HD_2) {
		DatBan_Panel.tf_maKH_HD_2 = tf_maKH_HD_2;
	}

	public static void setTf_maKH_HD_3(JTextField tf_maKH_HD_3) {
		DatBan_Panel.tf_maKH_HD_3 = tf_maKH_HD_3;
	}

	public static void setTf_maKH_HD_4(JTextField tf_maKH_HD_4) {
		DatBan_Panel.tf_maKH_HD_4 = tf_maKH_HD_4;
	}

	public static void setTf_maKH_HD_5(JTextField tf_maKH_HD_5) {
		DatBan_Panel.tf_maKH_HD_5 = tf_maKH_HD_5;
	}

	public static void setTf_maKH_HD_6(JTextField tf_maKH_HD_6) {
		DatBan_Panel.tf_maKH_HD_6 = tf_maKH_HD_6;
	}

	public static void setTf_maKH_HD_7(JTextField tf_maKH_HD_7) {
		DatBan_Panel.tf_maKH_HD_7 = tf_maKH_HD_7;
	}

	public static void setTf_maKH_HD_8(JTextField tf_maKH_HD_8) {
		DatBan_Panel.tf_maKH_HD_8 = tf_maKH_HD_8;
	}

	public static void setTf_maKH_HD_9(JTextField tf_maKH_HD_9) {
		DatBan_Panel.tf_maKH_HD_9 = tf_maKH_HD_9;
	}

	public static void setTf_maKH_HD_10(JTextField tf_maKH_HD_10) {
		DatBan_Panel.tf_maKH_HD_10 = tf_maKH_HD_10;
	}

	public static void setTf_maKH_HD_11(JTextField tf_maKH_HD_11) {
		DatBan_Panel.tf_maKH_HD_11 = tf_maKH_HD_11;
	}

	public static void setTf_maKH_HD_12(JTextField tf_maKH_HD_12) {
		DatBan_Panel.tf_maKH_HD_12 = tf_maKH_HD_12;
	}

	public static void setTf_maKH_HD_13(JTextField tf_maKH_HD_13) {
		DatBan_Panel.tf_maKH_HD_13 = tf_maKH_HD_13;
	}

	public static void setTf_maKH_HD_14(JTextField tf_maKH_HD_14) {
		DatBan_Panel.tf_maKH_HD_14 = tf_maKH_HD_14;
	}

	public static void setTf_maKH_HD_15(JTextField tf_maKH_HD_15) {
		DatBan_Panel.tf_maKH_HD_15 = tf_maKH_HD_15;
	}

	public static void setTf_maKH_HD_16(JTextField tf_maKH_HD_16) {
		DatBan_Panel.tf_maKH_HD_16 = tf_maKH_HD_16;
	}

	public static void setTf_maKH_HD_17(JTextField tf_maKH_HD_17) {
		DatBan_Panel.tf_maKH_HD_17 = tf_maKH_HD_17;
	}

	public static void setTf_maKH_HD_18(JTextField tf_maKH_HD_18) {
		DatBan_Panel.tf_maKH_HD_18 = tf_maKH_HD_18;
	}

	public static void setTf_maKH_HD_19(JTextField tf_maKH_HD_19) {
		DatBan_Panel.tf_maKH_HD_19 = tf_maKH_HD_19;
	}

	public static void setTf_maKH_HD_20(JTextField tf_maKH_HD_20) {
		DatBan_Panel.tf_maKH_HD_20 = tf_maKH_HD_20;
	}

	public static void setTf_maKH_HD_21(JTextField tf_maKH_HD_21) {
		DatBan_Panel.tf_maKH_HD_21 = tf_maKH_HD_21;
	}

	public static void setTf_maKH_HD_22(JTextField tf_maKH_HD_22) {
		DatBan_Panel.tf_maKH_HD_22 = tf_maKH_HD_22;
	}

	public static void setTf_maKH_HD_23(JTextField tf_maKH_HD_23) {
		DatBan_Panel.tf_maKH_HD_23 = tf_maKH_HD_23;
	}

	public static void setTf_maKH_HD_24(JTextField tf_maKH_HD_24) {
		DatBan_Panel.tf_maKH_HD_24 = tf_maKH_HD_24;
	}

	public static void setTf_maKH_HD_25(JTextField tf_maKH_HD_25) {
		DatBan_Panel.tf_maKH_HD_25 = tf_maKH_HD_25;
	}

	public static void setTf_maKH_HD_26(JTextField tf_maKH_HD_26) {
		DatBan_Panel.tf_maKH_HD_26 = tf_maKH_HD_26;
	}

	public static void setTf_maKH_HD_27(JTextField tf_maKH_HD_27) {
		DatBan_Panel.tf_maKH_HD_27 = tf_maKH_HD_27;
	}

	public static void setTf_maKH_HD_28(JTextField tf_maKH_HD_28) {
		DatBan_Panel.tf_maKH_HD_28 = tf_maKH_HD_28;
	}

	public static void setTf_maKH_HD_29(JTextField tf_maKH_HD_29) {
		DatBan_Panel.tf_maKH_HD_29 = tf_maKH_HD_29;
	}

	public static void setTf_maKH_HD_30(JTextField tf_maKH_HD_30) {
		DatBan_Panel.tf_maKH_HD_30 = tf_maKH_HD_30;
	}

	public static void setTf_maKH_HD_31(JTextField tf_maKH_HD_31) {
		DatBan_Panel.tf_maKH_HD_31 = tf_maKH_HD_31;
	}

	public static void setTf_maKH_HD_32(JTextField tf_maKH_HD_32) {
		DatBan_Panel.tf_maKH_HD_32 = tf_maKH_HD_32;
	}

	public static void setTf_maKH_HD_33(JTextField tf_maKH_HD_33) {
		DatBan_Panel.tf_maKH_HD_33 = tf_maKH_HD_33;
	}

	public static void setTf_maKH_HD_34(JTextField tf_maKH_HD_34) {
		DatBan_Panel.tf_maKH_HD_34 = tf_maKH_HD_34;
	}

	public static void setTf_maKH_HD_35(JTextField tf_maKH_HD_35) {
		DatBan_Panel.tf_maKH_HD_35 = tf_maKH_HD_35;
	}

	public static void setTf_maKH_HD_36(JTextField tf_maKH_HD_36) {
		DatBan_Panel.tf_maKH_HD_36 = tf_maKH_HD_36;
	}

	public void setPanel_acc_1(JPanel panel_acc_1) {
		this.panel_acc_1 = panel_acc_1;
	}

	public void setPanel_acc_2(JPanel panel_acc_2) {
		this.panel_acc_2 = panel_acc_2;
	}

	public void setPanel_acc_3(JPanel panel_acc_3) {
		this.panel_acc_3 = panel_acc_3;
	}

	public void setPanel_acc_4(JPanel panel_acc_4) {
		this.panel_acc_4 = panel_acc_4;
	}

	public void setPanel_acc_5(JPanel panel_acc_5) {
		this.panel_acc_5 = panel_acc_5;
	}

	public void setPanel_acc_6(JPanel panel_acc_6) {
		this.panel_acc_6 = panel_acc_6;
	}

	public void setPanel_acc_7(JPanel panel_acc_7) {
		this.panel_acc_7 = panel_acc_7;
	}

	public void setPanel_acc_8(JPanel panel_acc_8) {
		this.panel_acc_8 = panel_acc_8;
	}

	public void setPanel_acc_9(JPanel panel_acc_9) {
		this.panel_acc_9 = panel_acc_9;
	}

	public void setPanel_acc_10(JPanel panel_acc_10) {
		this.panel_acc_10 = panel_acc_10;
	}

	public void setPanel_acc_11(JPanel panel_acc_11) {
		this.panel_acc_11 = panel_acc_11;
	}

	public void setPanel_acc_12(JPanel panel_acc_12) {
		this.panel_acc_12 = panel_acc_12;
	}

	public void setPanel_acc_13(JPanel panel_acc_13) {
		this.panel_acc_13 = panel_acc_13;
	}

	public void setPanel_acc_14(JPanel panel_acc_14) {
		this.panel_acc_14 = panel_acc_14;
	}

	public void setPanel_acc_15(JPanel panel_acc_15) {
		this.panel_acc_15 = panel_acc_15;
	}

	public void setPanel_acc_16(JPanel panel_acc_16) {
		this.panel_acc_16 = panel_acc_16;
	}

	public void setPanel_acc_17(JPanel panel_acc_17) {
		this.panel_acc_17 = panel_acc_17;
	}

	public void setPanel_acc_18(JPanel panel_acc_18) {
		this.panel_acc_18 = panel_acc_18;
	}

	public void setPanel_acc_19(JPanel panel_acc_19) {
		this.panel_acc_19 = panel_acc_19;
	}

	public void setPanel_acc_20(JPanel panel_acc_20) {
		this.panel_acc_20 = panel_acc_20;
	}

	public void setPanel_acc_21(JPanel panel_acc_21) {
		this.panel_acc_21 = panel_acc_21;
	}

	public void setPanel_acc_22(JPanel panel_acc_22) {
		this.panel_acc_22 = panel_acc_22;
	}

	public void setPanel_acc_23(JPanel panel_acc_23) {
		this.panel_acc_23 = panel_acc_23;
	}

	public void setPanel_acc_24(JPanel panel_acc_24) {
		this.panel_acc_24 = panel_acc_24;
	}

	public void setPanel_acc_25(JPanel panel_acc_25) {
		this.panel_acc_25 = panel_acc_25;
	}

	public void setPanel_acc_26(JPanel panel_acc_26) {
		this.panel_acc_26 = panel_acc_26;
	}

	public void setPanel_acc_27(JPanel panel_acc_27) {
		this.panel_acc_27 = panel_acc_27;
	}

	public void setPanel_acc_28(JPanel panel_acc_28) {
		this.panel_acc_28 = panel_acc_28;
	}

	public void setPanel_acc_29(JPanel panel_acc_29) {
		this.panel_acc_29 = panel_acc_29;
	}

	public void setPanel_acc_30(JPanel panel_acc_30) {
		this.panel_acc_30 = panel_acc_30;
	}

	public void setPanel_acc_31(JPanel panel_acc_31) {
		this.panel_acc_31 = panel_acc_31;
	}

	public void setPanel_acc_32(JPanel panel_acc_32) {
		this.panel_acc_32 = panel_acc_32;
	}

	public void setPanel_acc_33(JPanel panel_acc_33) {
		this.panel_acc_33 = panel_acc_33;
	}

	public void setPanel_acc_34(JPanel panel_acc_34) {
		this.panel_acc_34 = panel_acc_34;
	}

	public void setPanel_acc_35(JPanel panel_acc_35) {
		this.panel_acc_35 = panel_acc_35;
	}

	public void setPanel_acc_36(JPanel panel_acc_36) {
		this.panel_acc_36 = panel_acc_36;
	}

	public void setPanel_addc_1(JPanel panel_addc_1) {
		this.panel_addc_1 = panel_addc_1;
	}

	public void setPanel_addc_2(JPanel panel_addc_2) {
		this.panel_addc_2 = panel_addc_2;
	}

	public void setPanel_addc_3(JPanel panel_addc_3) {
		this.panel_addc_3 = panel_addc_3;
	}

	public void setPanel_addc_4(JPanel panel_addc_4) {
		this.panel_addc_4 = panel_addc_4;
	}

	public void setPanel_addc_5(JPanel panel_addc_5) {
		this.panel_addc_5 = panel_addc_5;
	}

	public void setPanel_addc_6(JPanel panel_addc_6) {
		this.panel_addc_6 = panel_addc_6;
	}

	public void setPanel_addc_7(JPanel panel_addc_7) {
		this.panel_addc_7 = panel_addc_7;
	}

	public void setPanel_addc_8(JPanel panel_addc_8) {
		this.panel_addc_8 = panel_addc_8;
	}

	public void setPanel_addc_9(JPanel panel_addc_9) {
		this.panel_addc_9 = panel_addc_9;
	}

	public void setPanel_addc_10(JPanel panel_addc_10) {
		this.panel_addc_10 = panel_addc_10;
	}

	public void setPanel_addc_11(JPanel panel_addc_11) {
		this.panel_addc_11 = panel_addc_11;
	}

	public void setPanel_addc_12(JPanel panel_addc_12) {
		this.panel_addc_12 = panel_addc_12;
	}

	public void setPanel_addc_13(JPanel panel_addc_13) {
		this.panel_addc_13 = panel_addc_13;
	}

	public void setPanel_addc_14(JPanel panel_addc_14) {
		this.panel_addc_14 = panel_addc_14;
	}

	public void setPanel_addc_15(JPanel panel_addc_15) {
		this.panel_addc_15 = panel_addc_15;
	}

	public void setPanel_addc_16(JPanel panel_addc_16) {
		this.panel_addc_16 = panel_addc_16;
	}

	public void setPanel_addc_17(JPanel panel_addc_17) {
		this.panel_addc_17 = panel_addc_17;
	}

	public void setPanel_addc_18(JPanel panel_addc_18) {
		this.panel_addc_18 = panel_addc_18;
	}

	public void setPanel_addc_19(JPanel panel_addc_19) {
		this.panel_addc_19 = panel_addc_19;
	}

	public void setPanel_addc_20(JPanel panel_addc_20) {
		this.panel_addc_20 = panel_addc_20;
	}

	public void setPanel_addc_21(JPanel panel_addc_21) {
		this.panel_addc_21 = panel_addc_21;
	}

	public void setPanel_addc_22(JPanel panel_addc_22) {
		this.panel_addc_22 = panel_addc_22;
	}

	public void setPanel_addc_23(JPanel panel_addc_23) {
		this.panel_addc_23 = panel_addc_23;
	}

	public void setPanel_addc_24(JPanel panel_addc_24) {
		this.panel_addc_24 = panel_addc_24;
	}

	public void setPanel_addc_25(JPanel panel_addc_25) {
		this.panel_addc_25 = panel_addc_25;
	}

	public void setPanel_addc_26(JPanel panel_addc_26) {
		this.panel_addc_26 = panel_addc_26;
	}

	public void setPanel_addc_27(JPanel panel_addc_27) {
		this.panel_addc_27 = panel_addc_27;
	}

	public void setPanel_addc_28(JPanel panel_addc_28) {
		this.panel_addc_28 = panel_addc_28;
	}

	public void setPanel_addc_29(JPanel panel_addc_29) {
		this.panel_addc_29 = panel_addc_29;
	}

	public void setPanel_addc_30(JPanel panel_addc_30) {
		this.panel_addc_30 = panel_addc_30;
	}

	public void setPanel_addc_31(JPanel panel_addc_31) {
		this.panel_addc_31 = panel_addc_31;
	}

	public void setPanel_addc_32(JPanel panel_addc_32) {
		this.panel_addc_32 = panel_addc_32;
	}

	public void setPanel_addc_33(JPanel panel_addc_33) {
		this.panel_addc_33 = panel_addc_33;
	}

	public void setPanel_addc_34(JPanel panel_addc_34) {
		this.panel_addc_34 = panel_addc_34;
	}

	public void setPanel_addc_35(JPanel panel_addc_35) {
		this.panel_addc_35 = panel_addc_35;
	}

	public void setPanel_addc_36(JPanel panel_addc_36) {
		this.panel_addc_36 = panel_addc_36;
	}

	public static void setBtn_tang_1(JButton btn_tang_1) {
		DatBan_Panel.btn_tang_1 = btn_tang_1;
	}

	public static void setBtn_tang_2(JButton btn_tang_2) {
		DatBan_Panel.btn_tang_2 = btn_tang_2;
	}

	public static void setBtn_tang_3(JButton btn_tang_3) {
		DatBan_Panel.btn_tang_3 = btn_tang_3;
	}

	public static void setBtn_tang_4(JButton btn_tang_4) {
		DatBan_Panel.btn_tang_4 = btn_tang_4;
	}

	public static void setBtn_tang_5(JButton btn_tang_5) {
		DatBan_Panel.btn_tang_5 = btn_tang_5;
	}

	public static void setBtn_tang_6(JButton btn_tang_6) {
		DatBan_Panel.btn_tang_6 = btn_tang_6;
	}

	public static void setBtn_tang_7(JButton btn_tang_7) {
		DatBan_Panel.btn_tang_7 = btn_tang_7;
	}

	public static void setBtn_tang_8(JButton btn_tang_8) {
		DatBan_Panel.btn_tang_8 = btn_tang_8;
	}

	public static void setBtn_tang_9(JButton btn_tang_9) {
		DatBan_Panel.btn_tang_9 = btn_tang_9;
	}

	public static void setBtn_tang_10(JButton btn_tang_10) {
		DatBan_Panel.btn_tang_10 = btn_tang_10;
	}

	public static void setBtn_tang_11(JButton btn_tang_11) {
		DatBan_Panel.btn_tang_11 = btn_tang_11;
	}

	public static void setBtn_tang_12(JButton btn_tang_12) {
		DatBan_Panel.btn_tang_12 = btn_tang_12;
	}

	public static void setBtn_tang_13(JButton btn_tang_13) {
		DatBan_Panel.btn_tang_13 = btn_tang_13;
	}

	public static void setBtn_tang_14(JButton btn_tang_14) {
		DatBan_Panel.btn_tang_14 = btn_tang_14;
	}

	public static void setBtn_tang_15(JButton btn_tang_15) {
		DatBan_Panel.btn_tang_15 = btn_tang_15;
	}

	public static void setBtn_tang_16(JButton btn_tang_16) {
		DatBan_Panel.btn_tang_16 = btn_tang_16;
	}

	public static void setBtn_tang_17(JButton btn_tang_17) {
		DatBan_Panel.btn_tang_17 = btn_tang_17;
	}

	public static void setBtn_tang_18(JButton btn_tang_18) {
		DatBan_Panel.btn_tang_18 = btn_tang_18;
	}

	public static void setBtn_tang_19(JButton btn_tang_19) {
		DatBan_Panel.btn_tang_19 = btn_tang_19;
	}

	public static void setBtn_tang_20(JButton btn_tang_20) {
		DatBan_Panel.btn_tang_20 = btn_tang_20;
	}

	public static void setBtn_tang_21(JButton btn_tang_21) {
		DatBan_Panel.btn_tang_21 = btn_tang_21;
	}

	public static void setBtn_tang_22(JButton btn_tang_22) {
		DatBan_Panel.btn_tang_22 = btn_tang_22;
	}

	public static void setBtn_tang_23(JButton btn_tang_23) {
		DatBan_Panel.btn_tang_23 = btn_tang_23;
	}

	public static void setBtn_tang_24(JButton btn_tang_24) {
		DatBan_Panel.btn_tang_24 = btn_tang_24;
	}

	public static void setBtn_tang_25(JButton btn_tang_25) {
		DatBan_Panel.btn_tang_25 = btn_tang_25;
	}

	public static void setBtn_tang_26(JButton btn_tang_26) {
		DatBan_Panel.btn_tang_26 = btn_tang_26;
	}

	public static void setBtn_tang_27(JButton btn_tang_27) {
		DatBan_Panel.btn_tang_27 = btn_tang_27;
	}

	public static void setBtn_tang_28(JButton btn_tang_28) {
		DatBan_Panel.btn_tang_28 = btn_tang_28;
	}

	public static void setBtn_tang_29(JButton btn_tang_29) {
		DatBan_Panel.btn_tang_29 = btn_tang_29;
	}

	public static void setBtn_tang_30(JButton btn_tang_30) {
		DatBan_Panel.btn_tang_30 = btn_tang_30;
	}

	public static void setBtn_tang_31(JButton btn_tang_31) {
		DatBan_Panel.btn_tang_31 = btn_tang_31;
	}

	public static void setBtn_tang_32(JButton btn_tang_32) {
		DatBan_Panel.btn_tang_32 = btn_tang_32;
	}

	public static void setBtn_tang_33(JButton btn_tang_33) {
		DatBan_Panel.btn_tang_33 = btn_tang_33;
	}

	public static void setBtn_tang_34(JButton btn_tang_34) {
		DatBan_Panel.btn_tang_34 = btn_tang_34;
	}

	public static void setBtn_tang_35(JButton btn_tang_35) {
		DatBan_Panel.btn_tang_35 = btn_tang_35;
	}

	public static void setBtn_tang_36(JButton btn_tang_36) {
		DatBan_Panel.btn_tang_36 = btn_tang_36;
	}

	public static void setBtn_giam_1(JButton btn_giam_1) {
		DatBan_Panel.btn_giam_1 = btn_giam_1;
	}

	public static void setBtn_giam_2(JButton btn_giam_2) {
		DatBan_Panel.btn_giam_2 = btn_giam_2;
	}

	public static void setBtn_giam_3(JButton btn_giam_3) {
		DatBan_Panel.btn_giam_3 = btn_giam_3;
	}

	public static void setBtn_giam_4(JButton btn_giam_4) {
		DatBan_Panel.btn_giam_4 = btn_giam_4;
	}

	public static void setBtn_giam_5(JButton btn_giam_5) {
		DatBan_Panel.btn_giam_5 = btn_giam_5;
	}

	public static void setBtn_giam_6(JButton btn_giam_6) {
		DatBan_Panel.btn_giam_6 = btn_giam_6;
	}

	public static void setBtn_giam_7(JButton btn_giam_7) {
		DatBan_Panel.btn_giam_7 = btn_giam_7;
	}

	public static void setBtn_giam_8(JButton btn_giam_8) {
		DatBan_Panel.btn_giam_8 = btn_giam_8;
	}

	public static void setBtn_giam_9(JButton btn_giam_9) {
		DatBan_Panel.btn_giam_9 = btn_giam_9;
	}

	public static void setBtn_giam_10(JButton btn_giam_10) {
		DatBan_Panel.btn_giam_10 = btn_giam_10;
	}

	public static void setBtn_giam_11(JButton btn_giam_11) {
		DatBan_Panel.btn_giam_11 = btn_giam_11;
	}

	public static void setBtn_giam_12(JButton btn_giam_12) {
		DatBan_Panel.btn_giam_12 = btn_giam_12;
	}

	public static void setBtn_giam_13(JButton btn_giam_13) {
		DatBan_Panel.btn_giam_13 = btn_giam_13;
	}

	public static void setBtn_giam_14(JButton btn_giam_14) {
		DatBan_Panel.btn_giam_14 = btn_giam_14;
	}

	public static void setBtn_giam_15(JButton btn_giam_15) {
		DatBan_Panel.btn_giam_15 = btn_giam_15;
	}

	public static void setBtn_giam_16(JButton btn_giam_16) {
		DatBan_Panel.btn_giam_16 = btn_giam_16;
	}

	public static void setBtn_giam_17(JButton btn_giam_17) {
		DatBan_Panel.btn_giam_17 = btn_giam_17;
	}

	public static void setBtn_giam_18(JButton btn_giam_18) {
		DatBan_Panel.btn_giam_18 = btn_giam_18;
	}

	public static void setBtn_giam_19(JButton btn_giam_19) {
		DatBan_Panel.btn_giam_19 = btn_giam_19;
	}

	public static void setBtn_giam_20(JButton btn_giam_20) {
		DatBan_Panel.btn_giam_20 = btn_giam_20;
	}

	public static void setBtn_giam_21(JButton btn_giam_21) {
		DatBan_Panel.btn_giam_21 = btn_giam_21;
	}

	public static void setBtn_giam_22(JButton btn_giam_22) {
		DatBan_Panel.btn_giam_22 = btn_giam_22;
	}

	public static void setBtn_giam_23(JButton btn_giam_23) {
		DatBan_Panel.btn_giam_23 = btn_giam_23;
	}

	public static void setBtn_giam_24(JButton btn_giam_24) {
		DatBan_Panel.btn_giam_24 = btn_giam_24;
	}

	public static void setBtn_giam_25(JButton btn_giam_25) {
		DatBan_Panel.btn_giam_25 = btn_giam_25;
	}

	public static void setBtn_giam_26(JButton btn_giam_26) {
		DatBan_Panel.btn_giam_26 = btn_giam_26;
	}

	public static void setBtn_giam_27(JButton btn_giam_27) {
		DatBan_Panel.btn_giam_27 = btn_giam_27;
	}

	public static void setBtn_giam_28(JButton btn_giam_28) {
		DatBan_Panel.btn_giam_28 = btn_giam_28;
	}

	public static void setBtn_giam_29(JButton btn_giam_29) {
		DatBan_Panel.btn_giam_29 = btn_giam_29;
	}

	public static void setBtn_giam_30(JButton btn_giam_30) {
		DatBan_Panel.btn_giam_30 = btn_giam_30;
	}

	public static void setBtn_giam_31(JButton btn_giam_31) {
		DatBan_Panel.btn_giam_31 = btn_giam_31;
	}

	public static void setBtn_giam_32(JButton btn_giam_32) {
		DatBan_Panel.btn_giam_32 = btn_giam_32;
	}

	public static void setBtn_giam_33(JButton btn_giam_33) {
		DatBan_Panel.btn_giam_33 = btn_giam_33;
	}

	public static void setBtn_giam_34(JButton btn_giam_34) {
		DatBan_Panel.btn_giam_34 = btn_giam_34;
	}

	public static void setBtn_giam_35(JButton btn_giam_35) {
		DatBan_Panel.btn_giam_35 = btn_giam_35;
	}

	public static void setBtn_giam_36(JButton btn_giam_36) {
		DatBan_Panel.btn_giam_36 = btn_giam_36;
	}

	public static void setBtn_sl_macdinh_1(JButton btn_sl_macdinh_1) {
		DatBan_Panel.btn_sl_macdinh_1 = btn_sl_macdinh_1;
	}

	public static void setBtn_sl_macdinh_2(JButton btn_sl_macdinh_2) {
		DatBan_Panel.btn_sl_macdinh_2 = btn_sl_macdinh_2;
	}

	public static void setBtn_sl_macdinh_3(JButton btn_sl_macdinh_3) {
		DatBan_Panel.btn_sl_macdinh_3 = btn_sl_macdinh_3;
	}

	public static void setBtn_sl_macdinh_4(JButton btn_sl_macdinh_4) {
		DatBan_Panel.btn_sl_macdinh_4 = btn_sl_macdinh_4;
	}

	public static void setBtn_sl_macdinh_5(JButton btn_sl_macdinh_5) {
		DatBan_Panel.btn_sl_macdinh_5 = btn_sl_macdinh_5;
	}

	public static void setBtn_sl_macdinh_6(JButton btn_sl_macdinh_6) {
		DatBan_Panel.btn_sl_macdinh_6 = btn_sl_macdinh_6;
	}

	public static void setBtn_sl_macdinh_7(JButton btn_sl_macdinh_7) {
		DatBan_Panel.btn_sl_macdinh_7 = btn_sl_macdinh_7;
	}

	public static void setBtn_sl_macdinh_8(JButton btn_sl_macdinh_8) {
		DatBan_Panel.btn_sl_macdinh_8 = btn_sl_macdinh_8;
	}

	public static void setBtn_sl_macdinh_9(JButton btn_sl_macdinh_9) {
		DatBan_Panel.btn_sl_macdinh_9 = btn_sl_macdinh_9;
	}

	public static void setBtn_sl_macdinh_10(JButton btn_sl_macdinh_10) {
		DatBan_Panel.btn_sl_macdinh_10 = btn_sl_macdinh_10;
	}

	public static void setBtn_sl_macdinh_11(JButton btn_sl_macdinh_11) {
		DatBan_Panel.btn_sl_macdinh_11 = btn_sl_macdinh_11;
	}

	public static void setBtn_sl_macdinh_12(JButton btn_sl_macdinh_12) {
		DatBan_Panel.btn_sl_macdinh_12 = btn_sl_macdinh_12;
	}

	public static void setBtn_sl_macdinh_13(JButton btn_sl_macdinh_13) {
		DatBan_Panel.btn_sl_macdinh_13 = btn_sl_macdinh_13;
	}

	public static void setBtn_sl_macdinh_14(JButton btn_sl_macdinh_14) {
		DatBan_Panel.btn_sl_macdinh_14 = btn_sl_macdinh_14;
	}

	public static void setBtn_sl_macdinh_15(JButton btn_sl_macdinh_15) {
		DatBan_Panel.btn_sl_macdinh_15 = btn_sl_macdinh_15;
	}

	public static void setBtn_sl_macdinh_16(JButton btn_sl_macdinh_16) {
		DatBan_Panel.btn_sl_macdinh_16 = btn_sl_macdinh_16;
	}

	public static void setBtn_sl_macdinh_17(JButton btn_sl_macdinh_17) {
		DatBan_Panel.btn_sl_macdinh_17 = btn_sl_macdinh_17;
	}

	public static void setBtn_sl_macdinh_18(JButton btn_sl_macdinh_18) {
		DatBan_Panel.btn_sl_macdinh_18 = btn_sl_macdinh_18;
	}

	public static void setBtn_sl_macdinh_19(JButton btn_sl_macdinh_19) {
		DatBan_Panel.btn_sl_macdinh_19 = btn_sl_macdinh_19;
	}

	public static void setBtn_sl_macdinh_20(JButton btn_sl_macdinh_20) {
		DatBan_Panel.btn_sl_macdinh_20 = btn_sl_macdinh_20;
	}

	public static void setBtn_sl_macdinh_21(JButton btn_sl_macdinh_21) {
		DatBan_Panel.btn_sl_macdinh_21 = btn_sl_macdinh_21;
	}

	public static void setBtn_sl_macdinh_22(JButton btn_sl_macdinh_22) {
		DatBan_Panel.btn_sl_macdinh_22 = btn_sl_macdinh_22;
	}

	public static void setBtn_sl_macdinh_23(JButton btn_sl_macdinh_23) {
		DatBan_Panel.btn_sl_macdinh_23 = btn_sl_macdinh_23;
	}

	public static void setBtn_sl_macdinh_24(JButton btn_sl_macdinh_24) {
		DatBan_Panel.btn_sl_macdinh_24 = btn_sl_macdinh_24;
	}

	public static void setBtn_sl_macdinh_25(JButton btn_sl_macdinh_25) {
		DatBan_Panel.btn_sl_macdinh_25 = btn_sl_macdinh_25;
	}

	public static void setBtn_sl_macdinh_26(JButton btn_sl_macdinh_26) {
		DatBan_Panel.btn_sl_macdinh_26 = btn_sl_macdinh_26;
	}

	public static void setBtn_sl_macdinh_27(JButton btn_sl_macdinh_27) {
		DatBan_Panel.btn_sl_macdinh_27 = btn_sl_macdinh_27;
	}

	public static void setBtn_sl_macdinh_28(JButton btn_sl_macdinh_28) {
		DatBan_Panel.btn_sl_macdinh_28 = btn_sl_macdinh_28;
	}

	public static void setBtn_sl_macdinh_29(JButton btn_sl_macdinh_29) {
		DatBan_Panel.btn_sl_macdinh_29 = btn_sl_macdinh_29;
	}

	public static void setBtn_sl_macdinh_30(JButton btn_sl_macdinh_30) {
		DatBan_Panel.btn_sl_macdinh_30 = btn_sl_macdinh_30;
	}

	public static void setBtn_sl_macdinh_31(JButton btn_sl_macdinh_31) {
		DatBan_Panel.btn_sl_macdinh_31 = btn_sl_macdinh_31;
	}

	public static void setBtn_sl_macdinh_32(JButton btn_sl_macdinh_32) {
		DatBan_Panel.btn_sl_macdinh_32 = btn_sl_macdinh_32;
	}

	public static void setBtn_sl_macdinh_33(JButton btn_sl_macdinh_33) {
		DatBan_Panel.btn_sl_macdinh_33 = btn_sl_macdinh_33;
	}

	public static void setBtn_sl_macdinh_34(JButton btn_sl_macdinh_34) {
		DatBan_Panel.btn_sl_macdinh_34 = btn_sl_macdinh_34;
	}

	public static void setBtn_sl_macdinh_35(JButton btn_sl_macdinh_35) {
		DatBan_Panel.btn_sl_macdinh_35 = btn_sl_macdinh_35;
	}

	public static void setBtn_sl_macdinh_36(JButton btn_sl_macdinh_36) {
		DatBan_Panel.btn_sl_macdinh_36 = btn_sl_macdinh_36;
	}

	public static void setBtn_ghichu_1(JButton btn_ghichu_1) {
		DatBan_Panel.btn_ghichu_1 = btn_ghichu_1;
	}

	public static void setBtn_ghichu_2(JButton btn_ghichu_2) {
		DatBan_Panel.btn_ghichu_2 = btn_ghichu_2;
	}

	public static void setBtn_ghichu_3(JButton btn_ghichu_3) {
		DatBan_Panel.btn_ghichu_3 = btn_ghichu_3;
	}

	public static void setBtn_ghichu_4(JButton btn_ghichu_4) {
		DatBan_Panel.btn_ghichu_4 = btn_ghichu_4;
	}

	public static void setBtn_ghichu_5(JButton btn_ghichu_5) {
		DatBan_Panel.btn_ghichu_5 = btn_ghichu_5;
	}

	public static void setBtn_ghichu_6(JButton btn_ghichu_6) {
		DatBan_Panel.btn_ghichu_6 = btn_ghichu_6;
	}

	public static void setBtn_ghichu_7(JButton btn_ghichu_7) {
		DatBan_Panel.btn_ghichu_7 = btn_ghichu_7;
	}

	public static void setBtn_ghichu_8(JButton btn_ghichu_8) {
		DatBan_Panel.btn_ghichu_8 = btn_ghichu_8;
	}

	public static void setBtn_ghichu_9(JButton btn_ghichu_9) {
		DatBan_Panel.btn_ghichu_9 = btn_ghichu_9;
	}

	public static void setBtn_ghichu_10(JButton btn_ghichu_10) {
		DatBan_Panel.btn_ghichu_10 = btn_ghichu_10;
	}

	public static void setBtn_ghichu_11(JButton btn_ghichu_11) {
		DatBan_Panel.btn_ghichu_11 = btn_ghichu_11;
	}

	public static void setBtn_ghichu_12(JButton btn_ghichu_12) {
		DatBan_Panel.btn_ghichu_12 = btn_ghichu_12;
	}

	public static void setBtn_ghichu_13(JButton btn_ghichu_13) {
		DatBan_Panel.btn_ghichu_13 = btn_ghichu_13;
	}

	public static void setBtn_ghichu_14(JButton btn_ghichu_14) {
		DatBan_Panel.btn_ghichu_14 = btn_ghichu_14;
	}

	public static void setBtn_ghichu_15(JButton btn_ghichu_15) {
		DatBan_Panel.btn_ghichu_15 = btn_ghichu_15;
	}

	public static void setBtn_ghichu_16(JButton btn_ghichu_16) {
		DatBan_Panel.btn_ghichu_16 = btn_ghichu_16;
	}

	public static void setBtn_ghichu_17(JButton btn_ghichu_17) {
		DatBan_Panel.btn_ghichu_17 = btn_ghichu_17;
	}

	public static void setBtn_ghichu_18(JButton btn_ghichu_18) {
		DatBan_Panel.btn_ghichu_18 = btn_ghichu_18;
	}

	public static void setBtn_ghichu_19(JButton btn_ghichu_19) {
		DatBan_Panel.btn_ghichu_19 = btn_ghichu_19;
	}

	public static void setBtn_ghichu_20(JButton btn_ghichu_20) {
		DatBan_Panel.btn_ghichu_20 = btn_ghichu_20;
	}

	public static void setBtn_ghichu_21(JButton btn_ghichu_21) {
		DatBan_Panel.btn_ghichu_21 = btn_ghichu_21;
	}

	public static void setBtn_ghichu_22(JButton btn_ghichu_22) {
		DatBan_Panel.btn_ghichu_22 = btn_ghichu_22;
	}

	public static void setBtn_ghichu_23(JButton btn_ghichu_23) {
		DatBan_Panel.btn_ghichu_23 = btn_ghichu_23;
	}

	public static void setBtn_ghichu_24(JButton btn_ghichu_24) {
		DatBan_Panel.btn_ghichu_24 = btn_ghichu_24;
	}

	public static void setBtn_ghichu_25(JButton btn_ghichu_25) {
		DatBan_Panel.btn_ghichu_25 = btn_ghichu_25;
	}

	public static void setBtn_ghichu_26(JButton btn_ghichu_26) {
		DatBan_Panel.btn_ghichu_26 = btn_ghichu_26;
	}

	public static void setBtn_ghichu_27(JButton btn_ghichu_27) {
		DatBan_Panel.btn_ghichu_27 = btn_ghichu_27;
	}

	public static void setBtn_ghichu_28(JButton btn_ghichu_28) {
		DatBan_Panel.btn_ghichu_28 = btn_ghichu_28;
	}

	public static void setBtn_ghichu_29(JButton btn_ghichu_29) {
		DatBan_Panel.btn_ghichu_29 = btn_ghichu_29;
	}

	public static void setBtn_ghichu_30(JButton btn_ghichu_30) {
		DatBan_Panel.btn_ghichu_30 = btn_ghichu_30;
	}

	public static void setBtn_ghichu_31(JButton btn_ghichu_31) {
		DatBan_Panel.btn_ghichu_31 = btn_ghichu_31;
	}

	public static void setBtn_ghichu_32(JButton btn_ghichu_32) {
		DatBan_Panel.btn_ghichu_32 = btn_ghichu_32;
	}

	public static void setBtn_ghichu_33(JButton btn_ghichu_33) {
		DatBan_Panel.btn_ghichu_33 = btn_ghichu_33;
	}

	public static void setBtn_ghichu_34(JButton btn_ghichu_34) {
		DatBan_Panel.btn_ghichu_34 = btn_ghichu_34;
	}

	public static void setBtn_ghichu_35(JButton btn_ghichu_35) {
		DatBan_Panel.btn_ghichu_35 = btn_ghichu_35;
	}

	public static void setBtn_ghichu_36(JButton btn_ghichu_36) {
		DatBan_Panel.btn_ghichu_36 = btn_ghichu_36;
	}

	public void setPanel_dbf_1(JPanel panel_dbf_1) {
		this.panel_dbf_1 = panel_dbf_1;
	}

	public void setPanel_dbf_2(JPanel panel_dbf_2) {
		this.panel_dbf_2 = panel_dbf_2;
	}

	public void setPanel_dbf_3(JPanel panel_dbf_3) {
		this.panel_dbf_3 = panel_dbf_3;
	}

	public void setPanel_dbf_4(JPanel panel_dbf_4) {
		this.panel_dbf_4 = panel_dbf_4;
	}

	public void setPanel_dbf_5(JPanel panel_dbf_5) {
		this.panel_dbf_5 = panel_dbf_5;
	}

	public void setPanel_dbf_6(JPanel panel_dbf_6) {
		this.panel_dbf_6 = panel_dbf_6;
	}

	public void setPanel_dbf_7(JPanel panel_dbf_7) {
		this.panel_dbf_7 = panel_dbf_7;
	}

	public void setPanel_dbf_8(JPanel panel_dbf_8) {
		this.panel_dbf_8 = panel_dbf_8;
	}

	public void setPanel_dbf_9(JPanel panel_dbf_9) {
		this.panel_dbf_9 = panel_dbf_9;
	}

	public void setPanel_dbf_10(JPanel panel_dbf_10) {
		this.panel_dbf_10 = panel_dbf_10;
	}

	public void setPanel_dbf_11(JPanel panel_dbf_11) {
		this.panel_dbf_11 = panel_dbf_11;
	}

	public void setPanel_dbf_12(JPanel panel_dbf_12) {
		this.panel_dbf_12 = panel_dbf_12;
	}

	public void setPanel_dbf_13(JPanel panel_dbf_13) {
		this.panel_dbf_13 = panel_dbf_13;
	}

	public void setPanel_dbf_14(JPanel panel_dbf_14) {
		this.panel_dbf_14 = panel_dbf_14;
	}

	public void setPanel_dbf_15(JPanel panel_dbf_15) {
		this.panel_dbf_15 = panel_dbf_15;
	}

	public void setPanel_dbf_16(JPanel panel_dbf_16) {
		this.panel_dbf_16 = panel_dbf_16;
	}

	public void setPanel_dbf_17(JPanel panel_dbf_17) {
		this.panel_dbf_17 = panel_dbf_17;
	}

	public void setPanel_dbf_18(JPanel panel_dbf_18) {
		this.panel_dbf_18 = panel_dbf_18;
	}

	public void setPanel_dbf_19(JPanel panel_dbf_19) {
		this.panel_dbf_19 = panel_dbf_19;
	}

	public void setPanel_dbf_20(JPanel panel_dbf_20) {
		this.panel_dbf_20 = panel_dbf_20;
	}

	public void setPanel_dbf_21(JPanel panel_dbf_21) {
		this.panel_dbf_21 = panel_dbf_21;
	}

	public void setPanel_dbf_22(JPanel panel_dbf_22) {
		this.panel_dbf_22 = panel_dbf_22;
	}

	public void setPanel_dbf_23(JPanel panel_dbf_23) {
		this.panel_dbf_23 = panel_dbf_23;
	}

	public void setPanel_dbf_24(JPanel panel_dbf_24) {
		this.panel_dbf_24 = panel_dbf_24;
	}

	public void setPanel_dbf_25(JPanel panel_dbf_25) {
		this.panel_dbf_25 = panel_dbf_25;
	}

	public void setPanel_dbf_26(JPanel panel_dbf_26) {
		this.panel_dbf_26 = panel_dbf_26;
	}

	public void setPanel_dbf_27(JPanel panel_dbf_27) {
		this.panel_dbf_27 = panel_dbf_27;
	}

	public void setPanel_dbf_28(JPanel panel_dbf_28) {
		this.panel_dbf_28 = panel_dbf_28;
	}

	public void setPanel_dbf_29(JPanel panel_dbf_29) {
		this.panel_dbf_29 = panel_dbf_29;
	}

	public void setPanel_dbf_30(JPanel panel_dbf_30) {
		this.panel_dbf_30 = panel_dbf_30;
	}

	public void setPanel_dbf_31(JPanel panel_dbf_31) {
		this.panel_dbf_31 = panel_dbf_31;
	}

	public void setPanel_dbf_32(JPanel panel_dbf_32) {
		this.panel_dbf_32 = panel_dbf_32;
	}

	public void setPanel_dbf_33(JPanel panel_dbf_33) {
		this.panel_dbf_33 = panel_dbf_33;
	}

	public void setPanel_dbf_34(JPanel panel_dbf_34) {
		this.panel_dbf_34 = panel_dbf_34;
	}

	public void setPanel_dbf_35(JPanel panel_dbf_35) {
		this.panel_dbf_35 = panel_dbf_35;
	}

	public void setPanel_dbf_36(JPanel panel_dbf_36) {
		this.panel_dbf_36 = panel_dbf_36;
	}

	public void setPanel_zx_1(JPanel panel_zx_1) {
		this.panel_zx_1 = panel_zx_1;
	}

	public void setPanel_zx_2(JPanel panel_zx_2) {
		this.panel_zx_2 = panel_zx_2;
	}

	public void setPanel_zx_3(JPanel panel_zx_3) {
		this.panel_zx_3 = panel_zx_3;
	}

	public void setPanel_zx_4(JPanel panel_zx_4) {
		this.panel_zx_4 = panel_zx_4;
	}

	public void setPanel_zx_5(JPanel panel_zx_5) {
		this.panel_zx_5 = panel_zx_5;
	}

	public void setPanel_zx_6(JPanel panel_zx_6) {
		this.panel_zx_6 = panel_zx_6;
	}

	public void setPanel_zx_7(JPanel panel_zx_7) {
		this.panel_zx_7 = panel_zx_7;
	}

	public void setPanel_zx_8(JPanel panel_zx_8) {
		this.panel_zx_8 = panel_zx_8;
	}

	public void setPanel_zx_9(JPanel panel_zx_9) {
		this.panel_zx_9 = panel_zx_9;
	}

	public void setPanel_zx_10(JPanel panel_zx_10) {
		this.panel_zx_10 = panel_zx_10;
	}

	public void setPanel_zx_11(JPanel panel_zx_11) {
		this.panel_zx_11 = panel_zx_11;
	}

	public void setPanel_zx_12(JPanel panel_zx_12) {
		this.panel_zx_12 = panel_zx_12;
	}

	public void setPanel_zx_13(JPanel panel_zx_13) {
		this.panel_zx_13 = panel_zx_13;
	}

	public void setPanel_zx_14(JPanel panel_zx_14) {
		this.panel_zx_14 = panel_zx_14;
	}

	public void setPanel_zx_15(JPanel panel_zx_15) {
		this.panel_zx_15 = panel_zx_15;
	}

	public void setPanel_zx_16(JPanel panel_zx_16) {
		this.panel_zx_16 = panel_zx_16;
	}

	public void setPanel_zx_17(JPanel panel_zx_17) {
		this.panel_zx_17 = panel_zx_17;
	}

	public void setPanel_zx_18(JPanel panel_zx_18) {
		this.panel_zx_18 = panel_zx_18;
	}

	public void setPanel_zx_19(JPanel panel_zx_19) {
		this.panel_zx_19 = panel_zx_19;
	}

	public void setPanel_zx_20(JPanel panel_zx_20) {
		this.panel_zx_20 = panel_zx_20;
	}

	public void setPanel_zx_21(JPanel panel_zx_21) {
		this.panel_zx_21 = panel_zx_21;
	}

	public void setPanel_zx_22(JPanel panel_zx_22) {
		this.panel_zx_22 = panel_zx_22;
	}

	public void setPanel_zx_23(JPanel panel_zx_23) {
		this.panel_zx_23 = panel_zx_23;
	}

	public void setPanel_zx_24(JPanel panel_zx_24) {
		this.panel_zx_24 = panel_zx_24;
	}

	public void setPanel_zx_25(JPanel panel_zx_25) {
		this.panel_zx_25 = panel_zx_25;
	}

	public void setPanel_zx_26(JPanel panel_zx_26) {
		this.panel_zx_26 = panel_zx_26;
	}

	public void setPanel_zx_27(JPanel panel_zx_27) {
		this.panel_zx_27 = panel_zx_27;
	}

	public void setPanel_zx_28(JPanel panel_zx_28) {
		this.panel_zx_28 = panel_zx_28;
	}

	public void setPanel_zx_29(JPanel panel_zx_29) {
		this.panel_zx_29 = panel_zx_29;
	}

	public void setPanel_zx_30(JPanel panel_zx_30) {
		this.panel_zx_30 = panel_zx_30;
	}

	public void setPanel_zx_31(JPanel panel_zx_31) {
		this.panel_zx_31 = panel_zx_31;
	}

	public void setPanel_zx_32(JPanel panel_zx_32) {
		this.panel_zx_32 = panel_zx_32;
	}

	public void setPanel_zx_33(JPanel panel_zx_33) {
		this.panel_zx_33 = panel_zx_33;
	}

	public void setPanel_zx_34(JPanel panel_zx_34) {
		this.panel_zx_34 = panel_zx_34;
	}

	public void setPanel_zx_35(JPanel panel_zx_35) {
		this.panel_zx_35 = panel_zx_35;
	}

	public void setPanel_zx_36(JPanel panel_zx_36) {
		this.panel_zx_36 = panel_zx_36;
	}

	public void setPanel_Show_HoaDon_Table_1(JPanel panel_Show_HoaDon_Table_1) {
		this.panel_Show_HoaDon_Table_1 = panel_Show_HoaDon_Table_1;
	}

	public void setPanel_Show_HoaDon_Table_2(JPanel panel_Show_HoaDon_Table_2) {
		this.panel_Show_HoaDon_Table_2 = panel_Show_HoaDon_Table_2;
	}

	public void setPanel_Show_HoaDon_Table_3(JPanel panel_Show_HoaDon_Table_3) {
		this.panel_Show_HoaDon_Table_3 = panel_Show_HoaDon_Table_3;
	}

	public void setPanel_Show_HoaDon_Table_4(JPanel panel_Show_HoaDon_Table_4) {
		this.panel_Show_HoaDon_Table_4 = panel_Show_HoaDon_Table_4;
	}

	public void setPanel_Show_HoaDon_Table_5(JPanel panel_Show_HoaDon_Table_5) {
		this.panel_Show_HoaDon_Table_5 = panel_Show_HoaDon_Table_5;
	}

	public void setPanel_Show_HoaDon_Table_6(JPanel panel_Show_HoaDon_Table_6) {
		this.panel_Show_HoaDon_Table_6 = panel_Show_HoaDon_Table_6;
	}

	public void setPanel_Show_HoaDon_Table_7(JPanel panel_Show_HoaDon_Table_7) {
		this.panel_Show_HoaDon_Table_7 = panel_Show_HoaDon_Table_7;
	}

	public void setPanel_Show_HoaDon_Table_8(JPanel panel_Show_HoaDon_Table_8) {
		this.panel_Show_HoaDon_Table_8 = panel_Show_HoaDon_Table_8;
	}

	public void setPanel_Show_HoaDon_Table_9(JPanel panel_Show_HoaDon_Table_9) {
		this.panel_Show_HoaDon_Table_9 = panel_Show_HoaDon_Table_9;
	}

	public void setPanel_Show_HoaDon_Table_10(JPanel panel_Show_HoaDon_Table_10) {
		this.panel_Show_HoaDon_Table_10 = panel_Show_HoaDon_Table_10;
	}

	public void setPanel_Show_HoaDon_Table_11(JPanel panel_Show_HoaDon_Table_11) {
		this.panel_Show_HoaDon_Table_11 = panel_Show_HoaDon_Table_11;
	}

	public void setPanel_Show_HoaDon_Table_12(JPanel panel_Show_HoaDon_Table_12) {
		this.panel_Show_HoaDon_Table_12 = panel_Show_HoaDon_Table_12;
	}

	public void setPanel_Show_HoaDon_Table_13(JPanel panel_Show_HoaDon_Table_13) {
		this.panel_Show_HoaDon_Table_13 = panel_Show_HoaDon_Table_13;
	}

	public void setPanel_Show_HoaDon_Table_14(JPanel panel_Show_HoaDon_Table_14) {
		this.panel_Show_HoaDon_Table_14 = panel_Show_HoaDon_Table_14;
	}

	public void setPanel_Show_HoaDon_Table_15(JPanel panel_Show_HoaDon_Table_15) {
		this.panel_Show_HoaDon_Table_15 = panel_Show_HoaDon_Table_15;
	}

	public void setPanel_Show_HoaDon_Table_16(JPanel panel_Show_HoaDon_Table_16) {
		this.panel_Show_HoaDon_Table_16 = panel_Show_HoaDon_Table_16;
	}

	public void setPanel_Show_HoaDon_Table_17(JPanel panel_Show_HoaDon_Table_17) {
		this.panel_Show_HoaDon_Table_17 = panel_Show_HoaDon_Table_17;
	}

	public void setPanel_Show_HoaDon_Table_18(JPanel panel_Show_HoaDon_Table_18) {
		this.panel_Show_HoaDon_Table_18 = panel_Show_HoaDon_Table_18;
	}

	public void setPanel_Show_HoaDon_Table_19(JPanel panel_Show_HoaDon_Table_19) {
		this.panel_Show_HoaDon_Table_19 = panel_Show_HoaDon_Table_19;
	}

	public void setPanel_Show_HoaDon_Table_20(JPanel panel_Show_HoaDon_Table_20) {
		this.panel_Show_HoaDon_Table_20 = panel_Show_HoaDon_Table_20;
	}

	public void setPanel_Show_HoaDon_Table_21(JPanel panel_Show_HoaDon_Table_21) {
		this.panel_Show_HoaDon_Table_21 = panel_Show_HoaDon_Table_21;
	}

	public void setPanel_Show_HoaDon_Table_22(JPanel panel_Show_HoaDon_Table_22) {
		this.panel_Show_HoaDon_Table_22 = panel_Show_HoaDon_Table_22;
	}

	public void setPanel_Show_HoaDon_Table_23(JPanel panel_Show_HoaDon_Table_23) {
		this.panel_Show_HoaDon_Table_23 = panel_Show_HoaDon_Table_23;
	}

	public void setPanel_Show_HoaDon_Table_24(JPanel panel_Show_HoaDon_Table_24) {
		this.panel_Show_HoaDon_Table_24 = panel_Show_HoaDon_Table_24;
	}

	public void setPanel_Show_HoaDon_Table_25(JPanel panel_Show_HoaDon_Table_25) {
		this.panel_Show_HoaDon_Table_25 = panel_Show_HoaDon_Table_25;
	}

	public void setPanel_Show_HoaDon_Table_26(JPanel panel_Show_HoaDon_Table_26) {
		this.panel_Show_HoaDon_Table_26 = panel_Show_HoaDon_Table_26;
	}

	public void setPanel_Show_HoaDon_Table_27(JPanel panel_Show_HoaDon_Table_27) {
		this.panel_Show_HoaDon_Table_27 = panel_Show_HoaDon_Table_27;
	}

	public void setPanel_Show_HoaDon_Table_28(JPanel panel_Show_HoaDon_Table_28) {
		this.panel_Show_HoaDon_Table_28 = panel_Show_HoaDon_Table_28;
	}

	public void setPanel_Show_HoaDon_Table_29(JPanel panel_Show_HoaDon_Table_29) {
		this.panel_Show_HoaDon_Table_29 = panel_Show_HoaDon_Table_29;
	}

	public void setPanel_Show_HoaDon_Table_30(JPanel panel_Show_HoaDon_Table_30) {
		this.panel_Show_HoaDon_Table_30 = panel_Show_HoaDon_Table_30;
	}

	public void setPanel_Show_HoaDon_Table_31(JPanel panel_Show_HoaDon_Table_31) {
		this.panel_Show_HoaDon_Table_31 = panel_Show_HoaDon_Table_31;
	}

	public void setPanel_Show_HoaDon_Table_32(JPanel panel_Show_HoaDon_Table_32) {
		this.panel_Show_HoaDon_Table_32 = panel_Show_HoaDon_Table_32;
	}

	public void setPanel_Show_HoaDon_Table_33(JPanel panel_Show_HoaDon_Table_33) {
		this.panel_Show_HoaDon_Table_33 = panel_Show_HoaDon_Table_33;
	}

	public void setPanel_Show_HoaDon_Table_34(JPanel panel_Show_HoaDon_Table_34) {
		this.panel_Show_HoaDon_Table_34 = panel_Show_HoaDon_Table_34;
	}

	public void setPanel_Show_HoaDon_Table_35(JPanel panel_Show_HoaDon_Table_35) {
		this.panel_Show_HoaDon_Table_35 = panel_Show_HoaDon_Table_35;
	}

	public void setPanel_Show_HoaDon_Table_36(JPanel panel_Show_HoaDon_Table_36) {
		this.panel_Show_HoaDon_Table_36 = panel_Show_HoaDon_Table_36;
	}

	public static void setTable_1(JTable table_1) {
		DatBan_Panel.table_1 = table_1;
	}

	public static void setTable_2(JTable table_2) {
		DatBan_Panel.table_2 = table_2;
	}

	public static void setTable_3(JTable table_3) {
		DatBan_Panel.table_3 = table_3;
	}

	public static void setTable_4(JTable table_4) {
		DatBan_Panel.table_4 = table_4;
	}

	public static void setTable_5(JTable table_5) {
		DatBan_Panel.table_5 = table_5;
	}

	public static void setTable_6(JTable table_6) {
		DatBan_Panel.table_6 = table_6;
	}

	public static void setTable_7(JTable table_7) {
		DatBan_Panel.table_7 = table_7;
	}

	public static void setTable_8(JTable table_8) {
		DatBan_Panel.table_8 = table_8;
	}

	public static void setTable_9(JTable table_9) {
		DatBan_Panel.table_9 = table_9;
	}

	public static void setTable_10(JTable table_10) {
		DatBan_Panel.table_10 = table_10;
	}

	public static void setTable_11(JTable table_11) {
		DatBan_Panel.table_11 = table_11;
	}

	public static void setTable_12(JTable table_12) {
		DatBan_Panel.table_12 = table_12;
	}

	public static void setTable_13(JTable table_13) {
		DatBan_Panel.table_13 = table_13;
	}

	public static void setTable_14(JTable table_14) {
		DatBan_Panel.table_14 = table_14;
	}

	public static void setTable_15(JTable table_15) {
		DatBan_Panel.table_15 = table_15;
	}

	public static void setTable_16(JTable table_16) {
		DatBan_Panel.table_16 = table_16;
	}

	public static void setTable_17(JTable table_17) {
		DatBan_Panel.table_17 = table_17;
	}

	public static void setTable_18(JTable table_18) {
		DatBan_Panel.table_18 = table_18;
	}

	public static void setTable_19(JTable table_19) {
		DatBan_Panel.table_19 = table_19;
	}

	public static void setTable_20(JTable table_20) {
		DatBan_Panel.table_20 = table_20;
	}

	public static void setTable_21(JTable table_21) {
		DatBan_Panel.table_21 = table_21;
	}

	public static void setTable_22(JTable table_22) {
		DatBan_Panel.table_22 = table_22;
	}

	public static void setTable_23(JTable table_23) {
		DatBan_Panel.table_23 = table_23;
	}

	public static void setTable_24(JTable table_24) {
		DatBan_Panel.table_24 = table_24;
	}

	public static void setTable_25(JTable table_25) {
		DatBan_Panel.table_25 = table_25;
	}

	public static void setTable_26(JTable table_26) {
		DatBan_Panel.table_26 = table_26;
	}

	public static void setTable_27(JTable table_27) {
		DatBan_Panel.table_27 = table_27;
	}

	public static void setTable_28(JTable table_28) {
		DatBan_Panel.table_28 = table_28;
	}

	public static void setTable_29(JTable table_29) {
		DatBan_Panel.table_29 = table_29;
	}

	public static void setTable_30(JTable table_30) {
		DatBan_Panel.table_30 = table_30;
	}

	public static void setTable_31(JTable table_31) {
		DatBan_Panel.table_31 = table_31;
	}

	public static void setTable_32(JTable table_32) {
		DatBan_Panel.table_32 = table_32;
	}

	public static void setTable_33(JTable table_33) {
		DatBan_Panel.table_33 = table_33;
	}

	public static void setTable_34(JTable table_34) {
		DatBan_Panel.table_34 = table_34;
	}

	public static void setTable_35(JTable table_35) {
		DatBan_Panel.table_35 = table_35;
	}

	public static void setTable_36(JTable table_36) {
		DatBan_Panel.table_36 = table_36;
	}

	public static void setDatamodel_1(DefaultTableModel datamodel_1) {
		DatBan_Panel.datamodel_1 = datamodel_1;
	}

	public static void setDatamodel_2(DefaultTableModel datamodel_2) {
		DatBan_Panel.datamodel_2 = datamodel_2;
	}

	public static void setDatamodel_3(DefaultTableModel datamodel_3) {
		DatBan_Panel.datamodel_3 = datamodel_3;
	}

	public static void setDatamodel_4(DefaultTableModel datamodel_4) {
		DatBan_Panel.datamodel_4 = datamodel_4;
	}

	public static void setDatamodel_5(DefaultTableModel datamodel_5) {
		DatBan_Panel.datamodel_5 = datamodel_5;
	}

	public static void setDatamodel_6(DefaultTableModel datamodel_6) {
		DatBan_Panel.datamodel_6 = datamodel_6;
	}

	public static void setDatamodel_7(DefaultTableModel datamodel_7) {
		DatBan_Panel.datamodel_7 = datamodel_7;
	}

	public static void setDatamodel_8(DefaultTableModel datamodel_8) {
		DatBan_Panel.datamodel_8 = datamodel_8;
	}

	public static void setDatamodel_9(DefaultTableModel datamodel_9) {
		DatBan_Panel.datamodel_9 = datamodel_9;
	}

	public static void setDatamodel_10(DefaultTableModel datamodel_10) {
		DatBan_Panel.datamodel_10 = datamodel_10;
	}

	public static void setDatamodel_11(DefaultTableModel datamodel_11) {
		DatBan_Panel.datamodel_11 = datamodel_11;
	}

	public static void setDatamodel_12(DefaultTableModel datamodel_12) {
		DatBan_Panel.datamodel_12 = datamodel_12;
	}

	public static void setDatamodel_13(DefaultTableModel datamodel_13) {
		DatBan_Panel.datamodel_13 = datamodel_13;
	}

	public static void setDatamodel_14(DefaultTableModel datamodel_14) {
		DatBan_Panel.datamodel_14 = datamodel_14;
	}

	public static void setDatamodel_15(DefaultTableModel datamodel_15) {
		DatBan_Panel.datamodel_15 = datamodel_15;
	}

	public static void setDatamodel_16(DefaultTableModel datamodel_16) {
		DatBan_Panel.datamodel_16 = datamodel_16;
	}

	public static void setDatamodel_17(DefaultTableModel datamodel_17) {
		DatBan_Panel.datamodel_17 = datamodel_17;
	}

	public static void setDatamodel_18(DefaultTableModel datamodel_18) {
		DatBan_Panel.datamodel_18 = datamodel_18;
	}

	public static void setDatamodel_19(DefaultTableModel datamodel_19) {
		DatBan_Panel.datamodel_19 = datamodel_19;
	}

	public static void setDatamodel_20(DefaultTableModel datamodel_20) {
		DatBan_Panel.datamodel_20 = datamodel_20;
	}

	public static void setDatamodel_21(DefaultTableModel datamodel_21) {
		DatBan_Panel.datamodel_21 = datamodel_21;
	}

	public static void setDatamodel_22(DefaultTableModel datamodel_22) {
		DatBan_Panel.datamodel_22 = datamodel_22;
	}

	public static void setDatamodel_23(DefaultTableModel datamodel_23) {
		DatBan_Panel.datamodel_23 = datamodel_23;
	}

	public static void setDatamodel_24(DefaultTableModel datamodel_24) {
		DatBan_Panel.datamodel_24 = datamodel_24;
	}

	public static void setDatamodel_25(DefaultTableModel datamodel_25) {
		DatBan_Panel.datamodel_25 = datamodel_25;
	}

	public static void setDatamodel_26(DefaultTableModel datamodel_26) {
		DatBan_Panel.datamodel_26 = datamodel_26;
	}

	public static void setDatamodel_27(DefaultTableModel datamodel_27) {
		DatBan_Panel.datamodel_27 = datamodel_27;
	}

	public static void setDatamodel_28(DefaultTableModel datamodel_28) {
		DatBan_Panel.datamodel_28 = datamodel_28;
	}

	public static void setDatamodel_29(DefaultTableModel datamodel_29) {
		DatBan_Panel.datamodel_29 = datamodel_29;
	}

	public static void setDatamodel_30(DefaultTableModel datamodel_30) {
		DatBan_Panel.datamodel_30 = datamodel_30;
	}

	public static void setDatamodel_31(DefaultTableModel datamodel_31) {
		DatBan_Panel.datamodel_31 = datamodel_31;
	}

	public static void setDatamodel_32(DefaultTableModel datamodel_32) {
		DatBan_Panel.datamodel_32 = datamodel_32;
	}

	public static void setDatamodel_33(DefaultTableModel datamodel_33) {
		DatBan_Panel.datamodel_33 = datamodel_33;
	}

	public static void setDatamodel_34(DefaultTableModel datamodel_34) {
		DatBan_Panel.datamodel_34 = datamodel_34;
	}

	public static void setDatamodel_35(DefaultTableModel datamodel_35) {
		DatBan_Panel.datamodel_35 = datamodel_35;
	}

	public static void setDatamodel_36(DefaultTableModel datamodel_36) {
		DatBan_Panel.datamodel_36 = datamodel_36;
	}

	public static void setColumnames_1(Vector columnames_1) {
		DatBan_Panel.columnames_1 = columnames_1;
	}

	public static void setColumnames_2(Vector columnames_2) {
		DatBan_Panel.columnames_2 = columnames_2;
	}

	public static void setColumnames_3(Vector columnames_3) {
		DatBan_Panel.columnames_3 = columnames_3;
	}

	public static void setColumnames_4(Vector columnames_4) {
		DatBan_Panel.columnames_4 = columnames_4;
	}

	public static void setColumnames_5(Vector columnames_5) {
		DatBan_Panel.columnames_5 = columnames_5;
	}

	public static void setColumnames_6(Vector columnames_6) {
		DatBan_Panel.columnames_6 = columnames_6;
	}

	public static void setColumnames_7(Vector columnames_7) {
		DatBan_Panel.columnames_7 = columnames_7;
	}

	public static void setColumnames_8(Vector columnames_8) {
		DatBan_Panel.columnames_8 = columnames_8;
	}

	public static void setColumnames_9(Vector columnames_9) {
		DatBan_Panel.columnames_9 = columnames_9;
	}

	public static void setColumnames_10(Vector columnames_10) {
		DatBan_Panel.columnames_10 = columnames_10;
	}

	public static void setColumnames_11(Vector columnames_11) {
		DatBan_Panel.columnames_11 = columnames_11;
	}

	public static void setColumnames_12(Vector columnames_12) {
		DatBan_Panel.columnames_12 = columnames_12;
	}

	public static void setColumnames_13(Vector columnames_13) {
		DatBan_Panel.columnames_13 = columnames_13;
	}

	public static void setColumnames_14(Vector columnames_14) {
		DatBan_Panel.columnames_14 = columnames_14;
	}

	public static void setColumnames_15(Vector columnames_15) {
		DatBan_Panel.columnames_15 = columnames_15;
	}

	public static void setColumnames_16(Vector columnames_16) {
		DatBan_Panel.columnames_16 = columnames_16;
	}

	public static void setColumnames_17(Vector columnames_17) {
		DatBan_Panel.columnames_17 = columnames_17;
	}

	public static void setColumnames_18(Vector columnames_18) {
		DatBan_Panel.columnames_18 = columnames_18;
	}

	public static void setColumnames_19(Vector columnames_19) {
		DatBan_Panel.columnames_19 = columnames_19;
	}

	public static void setColumnames_20(Vector columnames_20) {
		DatBan_Panel.columnames_20 = columnames_20;
	}

	public static void setColumnames_21(Vector columnames_21) {
		DatBan_Panel.columnames_21 = columnames_21;
	}

	public static void setColumnames_22(Vector columnames_22) {
		DatBan_Panel.columnames_22 = columnames_22;
	}

	public static void setColumnames_23(Vector columnames_23) {
		DatBan_Panel.columnames_23 = columnames_23;
	}

	public static void setColumnames_24(Vector columnames_24) {
		DatBan_Panel.columnames_24 = columnames_24;
	}

	public static void setColumnames_25(Vector columnames_25) {
		DatBan_Panel.columnames_25 = columnames_25;
	}

	public static void setColumnames_26(Vector columnames_26) {
		DatBan_Panel.columnames_26 = columnames_26;
	}

	public static void setColumnames_27(Vector columnames_27) {
		DatBan_Panel.columnames_27 = columnames_27;
	}

	public static void setColumnames_28(Vector columnames_28) {
		DatBan_Panel.columnames_28 = columnames_28;
	}

	public static void setColumnames_29(Vector columnames_29) {
		DatBan_Panel.columnames_29 = columnames_29;
	}

	public static void setColumnames_30(Vector columnames_30) {
		DatBan_Panel.columnames_30 = columnames_30;
	}

	public static void setColumnames_31(Vector columnames_31) {
		DatBan_Panel.columnames_31 = columnames_31;
	}

	public static void setColumnames_32(Vector columnames_32) {
		DatBan_Panel.columnames_32 = columnames_32;
	}

	public static void setColumnames_33(Vector columnames_33) {
		DatBan_Panel.columnames_33 = columnames_33;
	}

	public static void setColumnames_34(Vector columnames_34) {
		DatBan_Panel.columnames_34 = columnames_34;
	}

	public static void setColumnames_35(Vector columnames_35) {
		DatBan_Panel.columnames_35 = columnames_35;
	}

	public static void setColumnames_36(Vector columnames_36) {
		DatBan_Panel.columnames_36 = columnames_36;
	}

	public static void setRecord_1(Vector record_1) {
		DatBan_Panel.record_1 = record_1;
	}

	public static void setRecord_2(Vector record_2) {
		DatBan_Panel.record_2 = record_2;
	}

	public static void setRecord_3(Vector record_3) {
		DatBan_Panel.record_3 = record_3;
	}

	public static void setRecord_4(Vector record_4) {
		DatBan_Panel.record_4 = record_4;
	}

	public static void setRecord_5(Vector record_5) {
		DatBan_Panel.record_5 = record_5;
	}

	public static void setRecord_6(Vector record_6) {
		DatBan_Panel.record_6 = record_6;
	}

	public static void setRecord_7(Vector record_7) {
		DatBan_Panel.record_7 = record_7;
	}

	public static void setRecord_8(Vector record_8) {
		DatBan_Panel.record_8 = record_8;
	}

	public static void setRecord_9(Vector record_9) {
		DatBan_Panel.record_9 = record_9;
	}

	public static void setRecord_10(Vector record_10) {
		DatBan_Panel.record_10 = record_10;
	}

	public static void setRecord_11(Vector record_11) {
		DatBan_Panel.record_11 = record_11;
	}

	public static void setRecord_12(Vector record_12) {
		DatBan_Panel.record_12 = record_12;
	}

	public static void setRecord_13(Vector record_13) {
		DatBan_Panel.record_13 = record_13;
	}

	public static void setRecord_14(Vector record_14) {
		DatBan_Panel.record_14 = record_14;
	}

	public static void setRecord_15(Vector record_15) {
		DatBan_Panel.record_15 = record_15;
	}

	public static void setRecord_16(Vector record_16) {
		DatBan_Panel.record_16 = record_16;
	}

	public static void setRecord_17(Vector record_17) {
		DatBan_Panel.record_17 = record_17;
	}

	public static void setRecord_18(Vector record_18) {
		DatBan_Panel.record_18 = record_18;
	}

	public static void setRecord_19(Vector record_19) {
		DatBan_Panel.record_19 = record_19;
	}

	public static void setRecord_20(Vector record_20) {
		DatBan_Panel.record_20 = record_20;
	}

	public static void setRecord_21(Vector record_21) {
		DatBan_Panel.record_21 = record_21;
	}

	public static void setRecord_22(Vector record_22) {
		DatBan_Panel.record_22 = record_22;
	}

	public static void setRecord_23(Vector record_23) {
		DatBan_Panel.record_23 = record_23;
	}

	public static void setRecord_24(Vector record_24) {
		DatBan_Panel.record_24 = record_24;
	}

	public static void setRecord_25(Vector record_25) {
		DatBan_Panel.record_25 = record_25;
	}

	public static void setRecord_26(Vector record_26) {
		DatBan_Panel.record_26 = record_26;
	}

	public static void setRecord_27(Vector record_27) {
		DatBan_Panel.record_27 = record_27;
	}

	public static void setRecord_28(Vector record_28) {
		DatBan_Panel.record_28 = record_28;
	}

	public static void setRecord_29(Vector record_29) {
		DatBan_Panel.record_29 = record_29;
	}

	public static void setRecord_30(Vector record_30) {
		DatBan_Panel.record_30 = record_30;
	}

	public static void setRecord_31(Vector record_31) {
		DatBan_Panel.record_31 = record_31;
	}

	public static void setRecord_32(Vector record_32) {
		DatBan_Panel.record_32 = record_32;
	}

	public static void setRecord_33(Vector record_33) {
		DatBan_Panel.record_33 = record_33;
	}

	public static void setRecord_34(Vector record_34) {
		DatBan_Panel.record_34 = record_34;
	}

	public static void setRecord_35(Vector record_35) {
		DatBan_Panel.record_35 = record_35;
	}

	public static void setRecord_36(Vector record_36) {
		DatBan_Panel.record_36 = record_36;
	}

	public void setBtn_thanhtoan_1(JButton btn_thanhtoan_1) {
		this.btn_thanhtoan_1 = btn_thanhtoan_1;
	}

	public void setBtn_thanhtoan_2(JButton btn_thanhtoan_2) {
		this.btn_thanhtoan_2 = btn_thanhtoan_2;
	}

	public void setBtn_thanhtoan_3(JButton btn_thanhtoan_3) {
		this.btn_thanhtoan_3 = btn_thanhtoan_3;
	}

	public void setBtn_thanhtoan_4(JButton btn_thanhtoan_4) {
		this.btn_thanhtoan_4 = btn_thanhtoan_4;
	}

	public void setBtn_thanhtoan_5(JButton btn_thanhtoan_5) {
		this.btn_thanhtoan_5 = btn_thanhtoan_5;
	}

	public void setBtn_thanhtoan_6(JButton btn_thanhtoan_6) {
		this.btn_thanhtoan_6 = btn_thanhtoan_6;
	}

	public void setBtn_thanhtoan_7(JButton btn_thanhtoan_7) {
		this.btn_thanhtoan_7 = btn_thanhtoan_7;
	}

	public void setBtn_thanhtoan_8(JButton btn_thanhtoan_8) {
		this.btn_thanhtoan_8 = btn_thanhtoan_8;
	}

	public void setBtn_thanhtoan_9(JButton btn_thanhtoan_9) {
		this.btn_thanhtoan_9 = btn_thanhtoan_9;
	}

	public void setBtn_thanhtoan_10(JButton btn_thanhtoan_10) {
		this.btn_thanhtoan_10 = btn_thanhtoan_10;
	}

	public void setBtn_thanhtoan_11(JButton btn_thanhtoan_11) {
		this.btn_thanhtoan_11 = btn_thanhtoan_11;
	}

	public void setBtn_thanhtoan_12(JButton btn_thanhtoan_12) {
		this.btn_thanhtoan_12 = btn_thanhtoan_12;
	}

	public void setBtn_thanhtoan_13(JButton btn_thanhtoan_13) {
		this.btn_thanhtoan_13 = btn_thanhtoan_13;
	}

	public void setBtn_thanhtoan_14(JButton btn_thanhtoan_14) {
		this.btn_thanhtoan_14 = btn_thanhtoan_14;
	}

	public void setBtn_thanhtoan_15(JButton btn_thanhtoan_15) {
		this.btn_thanhtoan_15 = btn_thanhtoan_15;
	}

	public void setBtn_thanhtoan_16(JButton btn_thanhtoan_16) {
		this.btn_thanhtoan_16 = btn_thanhtoan_16;
	}

	public void setBtn_thanhtoan_17(JButton btn_thanhtoan_17) {
		this.btn_thanhtoan_17 = btn_thanhtoan_17;
	}

	public void setBtn_thanhtoan_18(JButton btn_thanhtoan_18) {
		this.btn_thanhtoan_18 = btn_thanhtoan_18;
	}

	public void setBtn_thanhtoan_19(JButton btn_thanhtoan_19) {
		this.btn_thanhtoan_19 = btn_thanhtoan_19;
	}

	public void setBtn_thanhtoan_20(JButton btn_thanhtoan_20) {
		this.btn_thanhtoan_20 = btn_thanhtoan_20;
	}

	public void setBtn_thanhtoan_21(JButton btn_thanhtoan_21) {
		this.btn_thanhtoan_21 = btn_thanhtoan_21;
	}

	public void setBtn_thanhtoan_23(JButton btn_thanhtoan_23) {
		this.btn_thanhtoan_23 = btn_thanhtoan_23;
	}

	public void setBtn_thanhtoan_24(JButton btn_thanhtoan_24) {
		this.btn_thanhtoan_24 = btn_thanhtoan_24;
	}

	public void setBtn_thanhtoan_25(JButton btn_thanhtoan_25) {
		this.btn_thanhtoan_25 = btn_thanhtoan_25;
	}

	public void setBtn_thanhtoan_26(JButton btn_thanhtoan_26) {
		this.btn_thanhtoan_26 = btn_thanhtoan_26;
	}

	public void setBtn_thanhtoan_27(JButton btn_thanhtoan_27) {
		this.btn_thanhtoan_27 = btn_thanhtoan_27;
	}

	public void setBtn_thanhtoan_28(JButton btn_thanhtoan_28) {
		this.btn_thanhtoan_28 = btn_thanhtoan_28;
	}

	public void setBtn_thanhtoan_29(JButton btn_thanhtoan_29) {
		this.btn_thanhtoan_29 = btn_thanhtoan_29;
	}

	public void setBtn_thanhtoan_30(JButton btn_thanhtoan_30) {
		this.btn_thanhtoan_30 = btn_thanhtoan_30;
	}

	public void setBtn_thanhtoan_31(JButton btn_thanhtoan_31) {
		this.btn_thanhtoan_31 = btn_thanhtoan_31;
	}

	public void setBtn_thanhtoan_32(JButton btn_thanhtoan_32) {
		this.btn_thanhtoan_32 = btn_thanhtoan_32;
	}

	public void setBtn_thanhtoan_33(JButton btn_thanhtoan_33) {
		this.btn_thanhtoan_33 = btn_thanhtoan_33;
	}

	public void setBtn_thanhtoan_34(JButton btn_thanhtoan_34) {
		this.btn_thanhtoan_34 = btn_thanhtoan_34;
	}

	public void setBtn_thanhtoan_35(JButton btn_thanhtoan_35) {
		this.btn_thanhtoan_35 = btn_thanhtoan_35;
	}

	public void setBtn_thanhtoan_36(JButton btn_thanhtoan_36) {
		this.btn_thanhtoan_36 = btn_thanhtoan_36;
	}

	public void setBtn_thanhtoan_22(JButton btn_thanhtoan_22) {
		this.btn_thanhtoan_22 = btn_thanhtoan_22;
	}

	public void setBtn_capnhat_1(JButton btn_capnhat_1) {
		this.btn_capnhat_1 = btn_capnhat_1;
	}

	public void setBtn_capnhat_2(JButton btn_capnhat_2) {
		this.btn_capnhat_2 = btn_capnhat_2;
	}

	public void setBtn_capnhat_3(JButton btn_capnhat_3) {
		this.btn_capnhat_3 = btn_capnhat_3;
	}

	public void setBtn_capnhat_4(JButton btn_capnhat_4) {
		this.btn_capnhat_4 = btn_capnhat_4;
	}

	public void setBtn_capnhat_5(JButton btn_capnhat_5) {
		this.btn_capnhat_5 = btn_capnhat_5;
	}

	public void setBtn_capnhat_6(JButton btn_capnhat_6) {
		this.btn_capnhat_6 = btn_capnhat_6;
	}

	public void setBtn_capnhat_7(JButton btn_capnhat_7) {
		this.btn_capnhat_7 = btn_capnhat_7;
	}

	public void setBtn_capnhat_8(JButton btn_capnhat_8) {
		this.btn_capnhat_8 = btn_capnhat_8;
	}

	public void setBtn_capnhat_9(JButton btn_capnhat_9) {
		this.btn_capnhat_9 = btn_capnhat_9;
	}

	public void setBtn_capnhat_10(JButton btn_capnhat_10) {
		this.btn_capnhat_10 = btn_capnhat_10;
	}

	public void setBtn_capnhat_11(JButton btn_capnhat_11) {
		this.btn_capnhat_11 = btn_capnhat_11;
	}

	public void setBtn_capnhat_12(JButton btn_capnhat_12) {
		this.btn_capnhat_12 = btn_capnhat_12;
	}

	public void setBtn_capnhat_13(JButton btn_capnhat_13) {
		this.btn_capnhat_13 = btn_capnhat_13;
	}

	public void setBtn_capnhat_14(JButton btn_capnhat_14) {
		this.btn_capnhat_14 = btn_capnhat_14;
	}

	public void setBtn_capnhat_15(JButton btn_capnhat_15) {
		this.btn_capnhat_15 = btn_capnhat_15;
	}

	public void setBtn_capnhat_16(JButton btn_capnhat_16) {
		this.btn_capnhat_16 = btn_capnhat_16;
	}

	public void setBtn_capnhat_17(JButton btn_capnhat_17) {
		this.btn_capnhat_17 = btn_capnhat_17;
	}

	public void setBtn_capnhat_18(JButton btn_capnhat_18) {
		this.btn_capnhat_18 = btn_capnhat_18;
	}

	public void setBtn_capnhat_19(JButton btn_capnhat_19) {
		this.btn_capnhat_19 = btn_capnhat_19;
	}

	public void setBtn_capnhat_20(JButton btn_capnhat_20) {
		this.btn_capnhat_20 = btn_capnhat_20;
	}

	public void setBtn_capnhat_21(JButton btn_capnhat_21) {
		this.btn_capnhat_21 = btn_capnhat_21;
	}

	public void setBtn_capnhat_22(JButton btn_capnhat_22) {
		this.btn_capnhat_22 = btn_capnhat_22;
	}

	public void setBtn_capnhat_23(JButton btn_capnhat_23) {
		this.btn_capnhat_23 = btn_capnhat_23;
	}

	public void setBtn_capnhat_24(JButton btn_capnhat_24) {
		this.btn_capnhat_24 = btn_capnhat_24;
	}

	public void setBtn_capnhat_25(JButton btn_capnhat_25) {
		this.btn_capnhat_25 = btn_capnhat_25;
	}

	public void setBtn_capnhat_26(JButton btn_capnhat_26) {
		this.btn_capnhat_26 = btn_capnhat_26;
	}

	public void setBtn_capnhat_27(JButton btn_capnhat_27) {
		this.btn_capnhat_27 = btn_capnhat_27;
	}

	public void setBtn_capnhat_28(JButton btn_capnhat_28) {
		this.btn_capnhat_28 = btn_capnhat_28;
	}

	public void setBtn_capnhat_29(JButton btn_capnhat_29) {
		this.btn_capnhat_29 = btn_capnhat_29;
	}

	public void setBtn_capnhat_30(JButton btn_capnhat_30) {
		this.btn_capnhat_30 = btn_capnhat_30;
	}

	public void setBtn_capnhat_31(JButton btn_capnhat_31) {
		this.btn_capnhat_31 = btn_capnhat_31;
	}

	public void setBtn_capnhat_32(JButton btn_capnhat_32) {
		this.btn_capnhat_32 = btn_capnhat_32;
	}

	public void setBtn_capnhat_33(JButton btn_capnhat_33) {
		this.btn_capnhat_33 = btn_capnhat_33;
	}

	public void setBtn_capnhat_34(JButton btn_capnhat_34) {
		this.btn_capnhat_34 = btn_capnhat_34;
	}

	public void setBtn_capnhat_35(JButton btn_capnhat_35) {
		this.btn_capnhat_35 = btn_capnhat_35;
	}

	public void setBtn_capnhat_36(JButton btn_capnhat_36) {
		this.btn_capnhat_36 = btn_capnhat_36;
	}

	public void setBtn_thucdon_1(JButton btn_thucdon_1) {
		this.btn_thucdon_1 = btn_thucdon_1;
	}

	public void setBtn_thucdon_2(JButton btn_thucdon_2) {
		this.btn_thucdon_2 = btn_thucdon_2;
	}

	public void setBtn_thucdon_3(JButton btn_thucdon_3) {
		this.btn_thucdon_3 = btn_thucdon_3;
	}

	public void setBtn_thucdon_4(JButton btn_thucdon_4) {
		this.btn_thucdon_4 = btn_thucdon_4;
	}

	public void setBtn_thucdon_5(JButton btn_thucdon_5) {
		this.btn_thucdon_5 = btn_thucdon_5;
	}

	public void setBtn_thucdon_6(JButton btn_thucdon_6) {
		this.btn_thucdon_6 = btn_thucdon_6;
	}

	public void setBtn_thucdon_7(JButton btn_thucdon_7) {
		this.btn_thucdon_7 = btn_thucdon_7;
	}

	public void setBtn_thucdon_8(JButton btn_thucdon_8) {
		this.btn_thucdon_8 = btn_thucdon_8;
	}

	public void setBtn_thucdon_9(JButton btn_thucdon_9) {
		this.btn_thucdon_9 = btn_thucdon_9;
	}

	public void setBtn_thucdon_10(JButton btn_thucdon_10) {
		this.btn_thucdon_10 = btn_thucdon_10;
	}

	public void setBtn_thucdon_11(JButton btn_thucdon_11) {
		this.btn_thucdon_11 = btn_thucdon_11;
	}

	public void setBtn_thucdon_12(JButton btn_thucdon_12) {
		this.btn_thucdon_12 = btn_thucdon_12;
	}

	public void setBtn_thucdon_13(JButton btn_thucdon_13) {
		this.btn_thucdon_13 = btn_thucdon_13;
	}

	public void setBtn_thucdon_14(JButton btn_thucdon_14) {
		this.btn_thucdon_14 = btn_thucdon_14;
	}

	public void setBtn_thucdon_15(JButton btn_thucdon_15) {
		this.btn_thucdon_15 = btn_thucdon_15;
	}

	public void setBtn_thucdon_16(JButton btn_thucdon_16) {
		this.btn_thucdon_16 = btn_thucdon_16;
	}

	public void setBtn_thucdon_17(JButton btn_thucdon_17) {
		this.btn_thucdon_17 = btn_thucdon_17;
	}

	public void setBtn_thucdon_18(JButton btn_thucdon_18) {
		this.btn_thucdon_18 = btn_thucdon_18;
	}

	public void setBtn_thucdon_19(JButton btn_thucdon_19) {
		this.btn_thucdon_19 = btn_thucdon_19;
	}

	public void setBtn_thucdon_20(JButton btn_thucdon_20) {
		this.btn_thucdon_20 = btn_thucdon_20;
	}

	public void setBtn_thucdon_21(JButton btn_thucdon_21) {
		this.btn_thucdon_21 = btn_thucdon_21;
	}

	public void setBtn_thucdon_22(JButton btn_thucdon_22) {
		this.btn_thucdon_22 = btn_thucdon_22;
	}

	public void setBtn_thucdon_23(JButton btn_thucdon_23) {
		this.btn_thucdon_23 = btn_thucdon_23;
	}

	public void setBtn_thucdon_24(JButton btn_thucdon_24) {
		this.btn_thucdon_24 = btn_thucdon_24;
	}

	public void setBtn_thucdon_25(JButton btn_thucdon_25) {
		this.btn_thucdon_25 = btn_thucdon_25;
	}

	public void setBtn_thucdon_26(JButton btn_thucdon_26) {
		this.btn_thucdon_26 = btn_thucdon_26;
	}

	public void setBtn_thucdon_27(JButton btn_thucdon_27) {
		this.btn_thucdon_27 = btn_thucdon_27;
	}

	public void setBtn_thucdon_28(JButton btn_thucdon_28) {
		this.btn_thucdon_28 = btn_thucdon_28;
	}

	public void setBtn_thucdon_29(JButton btn_thucdon_29) {
		this.btn_thucdon_29 = btn_thucdon_29;
	}

	public void setBtn_thucdon_30(JButton btn_thucdon_30) {
		this.btn_thucdon_30 = btn_thucdon_30;
	}

	public void setBtn_thucdon_31(JButton btn_thucdon_31) {
		this.btn_thucdon_31 = btn_thucdon_31;
	}

	public void setBtn_thucdon_32(JButton btn_thucdon_32) {
		this.btn_thucdon_32 = btn_thucdon_32;
	}

	public void setBtn_thucdon_33(JButton btn_thucdon_33) {
		this.btn_thucdon_33 = btn_thucdon_33;
	}

	public void setBtn_thucdon_34(JButton btn_thucdon_34) {
		this.btn_thucdon_34 = btn_thucdon_34;
	}

	public void setBtn_thucdon_35(JButton btn_thucdon_35) {
		this.btn_thucdon_35 = btn_thucdon_35;
	}

	public void setBtn_thucdon_36(JButton btn_thucdon_36) {
		this.btn_thucdon_36 = btn_thucdon_36;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		int row = -1;
		row = table_1.getSelectedRow();
		if (e.getSource() == bt_01) {
			if (check_1 == 0) {
				check_1 = 1;
				int i = JOptionPane.showConfirmDialog(null,
						"Bạn muốn mở bàn này ?", "Thoát",
						JOptionPane.YES_NO_OPTION);
				if (i == JOptionPane.YES_OPTION) {
					// =================================
					panel_theotungban_1.setVisible(true);
					panel_theotungban_2.setVisible(false);
					panel_theotungban_3.setVisible(false);
					panel_theotungban_4.setVisible(false);
					panel_theotungban_5.setVisible(false);
					panel_theotungban_6.setVisible(false);
					panel_theotungban_7.setVisible(false);
					panel_theotungban_8.setVisible(false);
					panel_theotungban_9.setVisible(false);
					panel_theotungban_10.setVisible(false);
					panel_theotungban_11.setVisible(false);
					panel_theotungban_12.setVisible(false);

					// =================================

					// DAO_HoaDon.xoaHD();

					bt_01.setIcon(new ImageIcon(DatBan_Panel.class
							.getResource("/image/coffee_mo.png")));
					SplitPanel_Right.add(panel_theotungban_1,
							BorderLayout.CENTER);
					tf_maKH_HD_1.setEditable(true);
					btn_tang_1.setEnabled(true);
					btn_giam_1.setEnabled(true);
					btn_sl_macdinh_1.setEnabled(true);
					btn_ghichu_1.setEnabled(true);
					btn_thanhtoan_1.setEnabled(true);
					btn_capnhat_1.setEnabled(true);
				} else if (i == JOptionPane.NO_OPTION) {
					check_1 = 0;
				}
			} else {
				panel_theotungban_1.setVisible(true);
				panel_theotungban_2.setVisible(false);
				panel_theotungban_3.setVisible(false);
				panel_theotungban_4.setVisible(false);
				panel_theotungban_5.setVisible(false);
				panel_theotungban_6.setVisible(false);
				panel_theotungban_7.setVisible(false);
				panel_theotungban_8.setVisible(false);
				panel_theotungban_9.setVisible(false);
				panel_theotungban_10.setVisible(false);
				panel_theotungban_11.setVisible(false);
				panel_theotungban_12.setVisible(false);
				loadDatabase_1();
			}

		} else if (e.getSource() == bt_02) {
			if (check_2 == 0) {
				check_2 = 1;
				int i = JOptionPane.showConfirmDialog(null,
						"Bạn muốn mở bàn này ?", "Thoát",
						JOptionPane.YES_NO_OPTION);

				if (i == JOptionPane.YES_OPTION) {
					bt_02.setIcon(new ImageIcon(DatBan_Panel.class
							.getResource("/image/coffee_mo.png")));
					panel_theotungban_1.setVisible(false);
					SplitPanel_Right.add(panel_theotungban_2,
							BorderLayout.CENTER);

					panel_theotungban_1.setVisible(false);
					panel_theotungban_2.setVisible(true);
					panel_theotungban_3.setVisible(false);
					panel_theotungban_4.setVisible(false);
					panel_theotungban_5.setVisible(false);
					panel_theotungban_6.setVisible(false);
					panel_theotungban_7.setVisible(false);
					panel_theotungban_8.setVisible(false);
					panel_theotungban_9.setVisible(false);
					panel_theotungban_10.setVisible(false);
					panel_theotungban_11.setVisible(false);
					panel_theotungban_12.setVisible(false);
					tf_soban_2.setEditable(false);
					tf_maKH_HD_2.setEditable(true);
					btn_tang_2.setEnabled(true);
					btn_giam_2.setEnabled(true);
					btn_sl_macdinh_2.setEnabled(true);
					btn_ghichu_2.setEnabled(true);
					btn_thanhtoan_2.setEnabled(true);
					btn_capnhat_2.setEnabled(true);
				} else if (i == JOptionPane.NO_OPTION) {
					check_2 = 0;
				}
			} else {
				panel_theotungban_1.setVisible(false);
				panel_theotungban_2.setVisible(true);
				panel_theotungban_3.setVisible(false);
				panel_theotungban_4.setVisible(false);
				panel_theotungban_5.setVisible(false);
				panel_theotungban_6.setVisible(false);
				panel_theotungban_7.setVisible(false);
				panel_theotungban_8.setVisible(false);
				panel_theotungban_9.setVisible(false);
				panel_theotungban_10.setVisible(false);
				panel_theotungban_11.setVisible(false);
				panel_theotungban_12.setVisible(false);
			}
		} else if (e.getSource() == bt_03) {
			if (check_3 == 0) {
				check_3 = 1;
				int i = JOptionPane.showConfirmDialog(null,
						"Bạn muốn mở bàn này ?", "Thoát",
						JOptionPane.YES_NO_OPTION);

				if (i == JOptionPane.YES_OPTION) {
					bt_03.setIcon(new ImageIcon(DatBan_Panel.class
							.getResource("/image/coffee_mo.png")));
					panel_theotungban_3.setVisible(false);
					SplitPanel_Right.add(panel_theotungban_3,
							BorderLayout.CENTER);

					panel_theotungban_1.setVisible(false);
					panel_theotungban_2.setVisible(false);
					panel_theotungban_3.setVisible(true);
					panel_theotungban_4.setVisible(false);
					panel_theotungban_5.setVisible(false);
					panel_theotungban_6.setVisible(false);
					panel_theotungban_7.setVisible(false);
					panel_theotungban_8.setVisible(false);
					panel_theotungban_9.setVisible(false);
					panel_theotungban_10.setVisible(false);
					panel_theotungban_11.setVisible(false);
					panel_theotungban_12.setVisible(false);
					tf_soban_3.setEditable(false);
					tf_maKH_HD_3.setEditable(true);
					btn_tang_3.setEnabled(true);
					btn_giam_3.setEnabled(true);
					btn_sl_macdinh_3.setEnabled(true);
					btn_ghichu_3.setEnabled(true);
					btn_thanhtoan_3.setEnabled(true);
					btn_capnhat_3.setEnabled(true);

					List<HoaDon> hoaDon = new ArrayList<HoaDon>();

				} else if (i == JOptionPane.NO_OPTION) {
					check_3 = 0;
				}
			} else {
				panel_theotungban_1.setVisible(false);
				panel_theotungban_2.setVisible(false);
				panel_theotungban_3.setVisible(true);
				panel_theotungban_4.setVisible(false);
				panel_theotungban_5.setVisible(false);
				panel_theotungban_6.setVisible(false);
				panel_theotungban_7.setVisible(false);
				panel_theotungban_8.setVisible(false);
				panel_theotungban_9.setVisible(false);
				panel_theotungban_10.setVisible(false);
				panel_theotungban_11.setVisible(false);
				panel_theotungban_12.setVisible(false);
			}
		} else if (e.getSource() == btn_capnhat_1) {
			loadDatabase_1();
		} else if (e.getSource() == btn_thucdon_1) {
			int check = 0;
			if (check == 0) {
				new DatBan_ThucDon().setVisible(true);
				check = 1;
			} else {

			}

		} else if (e.getSource() == btn_thanhtoan_1) {
			ThanhToan_1 tt1 = new ThanhToan_1();
			tt1.setVisible(true);
		} else if (e.getSource() == btn_giam_1) {
			if (row == -1) {
				JOptionPane.showMessageDialog(this,
						"Bạn chưa chọn dòng cần tăng!");
			} else {

				// int row = table_1.getSelectedRow();
				String maMHHD = (String) datamodel_1.getValueAt(row, 0);
				String nameMH = (String) datamodel_1.getValueAt(row, 1);
				int soluo = (int) datamodel_1.getValueAt(row, 2);
				int ab = Controller_HoaDon.laySoLuong(maMHHD);

				if (soluo == 0) {
					int ahg = Controller_HoaDon.xoaHD(maMHHD);
					if(ahg==1){
						JOptionPane.showMessageDialog(this, "Đã remove mặt hàng!");
						loadDatabase_1();
					}
				}
				ab = ab - 1;
				int y = Controller_HoaDon.updateSoLuong(maMHHD, ab);
				if (y == 1) {
					loadDatabase_1();
					JOptionPane.showMessageDialog(null,
							"Đã giảm số lượng Mặt Hàng: " + nameMH);

				} else {
					JOptionPane.showMessageDialog(null,
							"Chưa giảm số lượng Mặt Hàng: " + nameMH);
				}
			}
		} else if (e.getSource() == btn_tang_1) {
			// int row = table_1.getSelectedRow();
			if (row == -1) {
				JOptionPane.showMessageDialog(this,
						"Bạn chưa chọn dòng cần tăng!");
			} else {
				String maMHHD = (String) datamodel_1.getValueAt(row, 0);
				String nameMH = (String) datamodel_1.getValueAt(row, 1);
				int soluo = (int) datamodel_1.getValueAt(row, 2);
				int ab = Controller_HoaDon.laySoLuong(maMHHD);
				ab = ab + 1;
				int y = Controller_HoaDon.updateSoLuong(maMHHD, ab);
				if (y == 1) {
					loadDatabase_1();
					JOptionPane.showMessageDialog(null,
							"Đã tăng số lượng Mặt Hàng: " + nameMH);

				} else {
					JOptionPane.showMessageDialog(null,
							"Chưa tăng số lượng Mặt Hàng: " + nameMH);
				}
			}
		} else if (e.getSource() == btn_sl_macdinh_1) {
			if (row == -1) {
				JOptionPane.showMessageDialog(this, "Bạn chưa chọn dòng!");
			} else {
				String maMHHD = (String) datamodel_1.getValueAt(row, 0);
				String nameMH = (String) datamodel_1.getValueAt(row, 1);
				int soluo = (int) datamodel_1.getValueAt(row, 2);
				int ab = Controller_HoaDon.laySoLuong(maMHHD);
				int c = 1;
				int y = Controller_HoaDon.updateSoLuong(maMHHD, c);
				if (y == 1) {
					loadDatabase_1();
					JOptionPane.showMessageDialog(null,
							"Đã đặt số lượng Mặt Hàng: " + nameMH
									+ " về mặc định là 1");

				} else {
					JOptionPane.showMessageDialog(null, "Nothing!: " + nameMH);
				}
			}
		} else if (e.getSource() == btn_ghichu_1) {
			String string = JOptionPane.showInputDialog("Thêm ghi chú!");

		}
	}

	public static void loadDatabase_1() {
		loadDatabase_DAO_1();

	}

	private static void loadDatabase_DAO_1() {
		List<HoaDon> list = Controller_HoaDon.loadDatabase_1();
		record_1 = null;
		datamodel_1 = new DefaultTableModel(record_1, columnames_1);
		table_1.setModel(datamodel_1);

		for (HoaDon hoaDon : list) {
			record_1 = new Vector();
			record_1.addElement(hoaDon.getMaMatHang());
			record_1.addElement(hoaDon.getTenMatHang());
			record_1.addElement(hoaDon.getSoLuong());
			record_1.addElement(hoaDon.getDonViTinh());
			record_1.addElement(hoaDon.getGia());
			record_1.addElement(hoaDon.getThanhtien());
			// record_1.addElement(hoaDon.getId_Ban());
			// record_1.addElement(hoaDon.getNgay());
			// record_1.addElement(hoaDon.getMaKhachHang());
			datamodel_1.addRow(record_1);
		}

	}

	public static int addMatHangVaoHoaDon_1(String maMH, String tenMH,
			String donvitinh, String gia) {
		int asa = 0;
		if (Controller_MatHang.checkMaMatHang(maMH) == true) {
			if (Controller_HoaDon.checkMaHoaDon(maMH) == true) {
				int i = Controller_HoaDon.laySoLuong(maMH);
				i = i + 1;
				int y = Controller_HoaDon.updateSoLuong(maMH, i);
				if (y == 1) {
				} else {
					JOptionPane.showMessageDialog(null,
							"Chưa tăng được số lượng Mặt Hàng có mã là: "
									+ maMH);
				}
			} else {
				double g = Double.parseDouble(gia);
				int soluong = 1;
				double thanhtien = g * soluong;
				String id_ban = tf_soban_1.getText();
				String ngay = getDatePicker_1().getJFormattedTextField()
						.getText();
				String makhachhang = tf_maKH_HD_1.getText();

				boolean i = Controller_HoaDon.themHD(maMH, tenMH, soluong,
						donvitinh, g, thanhtien, id_ban, ngay, makhachhang);
				if (i == true) {
					JOptionPane.showMessageDialog(null, "+ Đã thêm");
				} else {
					JOptionPane.showMessageDialog(null, "+ Chưa thêm");
				}
			}
			asa = 1;
		} else {
			JOptionPane.showMessageDialog(null, "Mã không tồn tại!");
		}
		return asa;
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

	public static String getMaMH_TD() {
		return maMH_TD;
	}

	public static String getTenMH_TD() {
		return tenMH_TD;
	}

	public static String getDonViTinh_TD() {
		return donViTinh_TD;
	}

	public static double getGia_TD() {
		return gia_TD;
	}

	public static void setMaMH_TD(String maMH_TD) {
		DatBan_Panel.maMH_TD = maMH_TD;
	}

	public static void setTenMH_TD(String tenMH_TD) {
		DatBan_Panel.tenMH_TD = tenMH_TD;
	}

	public static void setDonViTinh_TD(String donViTinh_TD) {
		DatBan_Panel.donViTinh_TD = donViTinh_TD;
	}

	public static void setGia_TD(double gia_TD) {
		DatBan_Panel.gia_TD = gia_TD;
	}

}
