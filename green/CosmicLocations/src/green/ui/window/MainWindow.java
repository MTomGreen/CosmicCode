package green.ui.window;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

import green.util.DateTimeUtils;

@SuppressWarnings("serial")
public class MainWindow extends JFrame{
	public static JMenuBar menu;
	
	public static String dateString;
	public static String timeString;
	
	public JLabel lblSystemTime;
	public JLabel lblDate;
	
	public MainWindow() {
		this.setPreferredSize(new Dimension(1280,720));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(this.getPreferredSize());
		this.setTitle("Marling Cosmic Ray Software");
		
		
		JPanel navPanel = new JPanel();
		navPanel.setBackground(SystemColor.inactiveCaption);
		navPanel.setBorder(BorderFactory.createLoweredBevelBorder());
		JPanel mainPanel = new JPanel();
		mainPanel.setBorder(BorderFactory.createLoweredBevelBorder());
		mainPanel.setBackground(SystemColor.activeCaptionBorder);
		
		JPanel infoPanel = new JPanel();
		infoPanel.setBorder(BorderFactory.createLoweredBevelBorder());
		infoPanel.setBackground(SystemColor.info);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(infoPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(navPanel, GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, 941, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(navPanel, GroupLayout.PREFERRED_SIZE, 329, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(infoPanel, GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE))
		);
		
		lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		lblSystemTime = new JLabel(timeString);
		lblSystemTime.setFont(new Font("Tahoma", Font.PLAIN, 42));
		GroupLayout gl_infoPanel = new GroupLayout(infoPanel);
		gl_infoPanel.setHorizontalGroup(
			gl_infoPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_infoPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_infoPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSystemTime, GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
						.addComponent(lblDate))
					.addContainerGap())
		);
		gl_infoPanel.setVerticalGroup(
			gl_infoPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_infoPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSystemTime, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblDate)
					.addContainerGap(238, Short.MAX_VALUE))
		);
		infoPanel.setLayout(gl_infoPanel);
		getContentPane().setLayout(groupLayout);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menu = new JMenuBar();
		
		this.setVisible(true);
		
	}
	
	@Override
	public void repaint() {
		super.repaint();
		lblSystemTime.setText(DateTimeUtils.getTimeInfo());
		lblDate.setText(DateTimeUtils.getDateInfo());
	}
}
