package view;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TitlePanel extends JPanel{
	private static final long serialVersionUID = 1L;
	JLabel lbl;
	
	public TitlePanel(String title) {
		FlowLayout layout = new FlowLayout();
		layout.setVgap(5);
		setLayout(layout);
		lbl = new JLabel(title);
		lbl.setHorizontalAlignment(JLabel.CENTER);
		lbl.setFont(new Font("Calibri", Font.CENTER_BASELINE, 15));
		add(lbl);
	}
}
