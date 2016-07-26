package green.thread;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import green.ui.window.TestWindow;

public class GUIThread extends Thread{
	
	public MainThread main;
	public static TestWindow window;
	
	@Override
	public synchronized void start() {
		super.start();	
		
		
	}
	
	public GUIThread(MainThread thread) {
		this.main = thread;
//		/window = new TestWindow();
		
		ActionListener taskPerformer = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//window.repaint();
			}
		};
		
		Timer t = new Timer(16, taskPerformer);
		t.setRepeats(true);
		t.start();
		
	}
	
	
}
