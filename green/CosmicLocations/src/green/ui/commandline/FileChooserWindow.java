package green.ui.commandline;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class FileChooserWindow extends JFrame{
	public FileChooserWindow() {
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		JTextPane textPane = new JTextPane();
		springLayout.putConstraint(SpringLayout.NORTH, textPane, 10, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, textPane, 21, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, textPane, 205, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, textPane, 252, SpringLayout.WEST, getContentPane());
		getContentPane().add(textPane);
	}
}
