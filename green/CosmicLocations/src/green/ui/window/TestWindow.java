package green.ui.window;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SpringLayout;

import green.util.DateTimeUtils;

@SuppressWarnings("serial")
public class TestWindow extends JFrame {
	
	public JLabel lblDate = new JLabel("Date");
	public JLabel lblTime = new JLabel("00:00:00");
	
	public TestWindow() {
		setTitle("Test-Pane");
		this.setSize(1280, 720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new CardLayout(0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setDividerSize(5);
		splitPane.setResizeWeight(0.02);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		getContentPane().add(splitPane, "name_491958230787156");
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setDividerSize(5);
		splitPane_1.setResizeWeight(0.15);
		splitPane.setRightComponent(splitPane_1);
		
		JSplitPane splitPane_2 = new JSplitPane();
		splitPane_2.setDividerSize(5);
		splitPane_2.setResizeWeight(0.5);
		splitPane_2.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_1.setLeftComponent(splitPane_2);
		
		JPanel navPanel = new JPanel();
		navPanel.setBackground(SystemColor.controlShadow);
		splitPane_2.setLeftComponent(navPanel);
		
		JPanel infoPanel = new JPanel();
		infoPanel.setBackground(SystemColor.info);
		splitPane_2.setRightComponent(infoPanel);
		SpringLayout sl_infoPanel = new SpringLayout();
		infoPanel.setLayout(sl_infoPanel);
		
		
		lblTime.setFont(new Font("Tahoma", Font.PLAIN, 42));
		sl_infoPanel.putConstraint(SpringLayout.NORTH, lblTime, 10, SpringLayout.NORTH, infoPanel);
		sl_infoPanel.putConstraint(SpringLayout.WEST, lblTime, 10, SpringLayout.WEST, infoPanel);
		infoPanel.add(lblTime);
		
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		sl_infoPanel.putConstraint(SpringLayout.NORTH, lblDate, 6, SpringLayout.SOUTH, lblTime);
		sl_infoPanel.putConstraint(SpringLayout.WEST, lblDate, 10, SpringLayout.WEST, infoPanel);
		infoPanel.add(lblDate);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(SystemColor.textHighlight);
		splitPane_1.setRightComponent(mainPanel);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.menu);
		splitPane.setLeftComponent(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{169, 0};
		gbl_panel.rowHeights = new int[]{14, 0};
		gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblSomeStuffWill = new JLabel("Some stuff will go here. Menu Stuff");
		GridBagConstraints gbc_lblSomeStuffWill = new GridBagConstraints();
		gbc_lblSomeStuffWill.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblSomeStuffWill.gridx = 0;
		gbc_lblSomeStuffWill.gridy = 0;
		panel.add(lblSomeStuffWill, gbc_lblSomeStuffWill);
		
		this.setVisible(true);
	}
	
	@Override
	public void repaint() {
		super.repaint();
		lblTime.setText(DateTimeUtils.getTimeInfo());
		lblDate.setText(DateTimeUtils.getDateInfo());
	}
}
