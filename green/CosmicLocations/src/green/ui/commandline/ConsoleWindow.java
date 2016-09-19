package green.ui.commandline;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.filechooser.FileNameExtensionFilter;

import green.math.LocationMathFinal;
import green.util.FileUtils;

public class ConsoleWindow extends JFrame{
	
	private String fileName;
	private File file;

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	
	JLabel fileLabel = new JLabel("No file selected");
	JTextArea logArea = new JTextArea();
	
	public ConsoleWindow() {
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 10, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, 338, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, 424, SpringLayout.WEST, getContentPane());
		getContentPane().add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JButton btnSelectData = new JButton("Select Data");
		btnSelectData.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				//JFrame newFrame = new JFrame();
				JFileChooser chooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Tab Seperated Value Files (.tsv)", "tsv");
				chooser.setFileFilter(filter);
				//newFrame.setSize(400, 400);
				//newFrame.add(chooser);
				//newFrame.setVisible(true);
				int returnVal = chooser.showOpenDialog(getParent());
				if(returnVal == JFileChooser.APPROVE_OPTION){
					fileName = chooser.getSelectedFile().getName();
					file = chooser.getSelectedFile();
					fileLabel.setText(fileName);
					//fileLabel.repaint();
					//MainThread.win.repaint();
				}
				if(returnVal == JFileChooser.CANCEL_OPTION){
					System.out.println("Cancelled");
				}
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
			}
			
		});
		sl_panel.putConstraint(SpringLayout.NORTH, btnSelectData, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, btnSelectData, 10, SpringLayout.WEST, panel);
		panel.add(btnSelectData);
		
		sl_panel.putConstraint(SpringLayout.NORTH, fileLabel, 14, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, fileLabel, 6, SpringLayout.EAST, btnSelectData);
		sl_panel.putConstraint(SpringLayout.EAST, fileLabel, -28, SpringLayout.EAST, panel);
		panel.add(fileLabel);
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				ArrayList<String> log = new ArrayList<String>();
				LocationMathFinal.getAnglesForCoincidenceWithLog(FileUtils.getCoincidenceFromDataFile(file), log);
				StringBuilder b = new StringBuilder();
				
				for(String s : log){
					b.append(s + "\n");
				}
				StringSelection selection = new StringSelection(b.toString());
				Clipboard board = Toolkit.getDefaultToolkit().getSystemClipboard();
				board.setContents(selection, null);
				logArea.append("Copied log to clipboard");
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
			}
			
		});
		sl_panel.putConstraint(SpringLayout.NORTH, btnCalculate, 24, SpringLayout.SOUTH, btnSelectData);
		sl_panel.putConstraint(SpringLayout.WEST, btnCalculate, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnCalculate, 0, SpringLayout.EAST, btnSelectData);
		panel.add(btnCalculate);
		
		JLabel lblResults = new JLabel("Results:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblResults, 22, SpringLayout.SOUTH, btnCalculate);
		sl_panel.putConstraint(SpringLayout.WEST, lblResults, 10, SpringLayout.WEST, panel);
		panel.add(lblResults);
		
		JLabel lblAzimuth = new JLabel("Azimuth");
		sl_panel.putConstraint(SpringLayout.NORTH, lblAzimuth, 6, SpringLayout.SOUTH, lblResults);
		sl_panel.putConstraint(SpringLayout.WEST, lblAzimuth, 0, SpringLayout.WEST, btnSelectData);
		panel.add(lblAzimuth);
		
		JLabel lblZenith = new JLabel("Zenith");
		sl_panel.putConstraint(SpringLayout.NORTH, lblZenith, 6, SpringLayout.SOUTH, lblAzimuth);
		sl_panel.putConstraint(SpringLayout.WEST, lblZenith, 0, SpringLayout.WEST, btnSelectData);
		panel.add(lblZenith);
		
		textField = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField, 0, SpringLayout.NORTH, lblAzimuth);
		sl_panel.putConstraint(SpringLayout.WEST, textField, 6, SpringLayout.EAST, lblAzimuth);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField_1, 6, SpringLayout.SOUTH, lblAzimuth);
		sl_panel.putConstraint(SpringLayout.EAST, textField_1, 0, SpringLayout.EAST, textField);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblExtraInfo = new JLabel("Extra Info");
		sl_panel.putConstraint(SpringLayout.NORTH, lblExtraInfo, 22, SpringLayout.SOUTH, textField_1);
		sl_panel.putConstraint(SpringLayout.WEST, lblExtraInfo, 0, SpringLayout.WEST, btnSelectData);
		panel.add(lblExtraInfo);
		
		
		sl_panel.putConstraint(SpringLayout.NORTH, logArea, 6, SpringLayout.SOUTH, lblExtraInfo);
		sl_panel.putConstraint(SpringLayout.WEST, logArea, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, logArea, 120, SpringLayout.SOUTH, lblExtraInfo);
		sl_panel.putConstraint(SpringLayout.EAST, logArea, 404, SpringLayout.WEST, panel);
		panel.add(logArea);
	}
	
	@Override
	public void repaint() {
		System.out.println("painting");
		super.repaint();
	}
}
