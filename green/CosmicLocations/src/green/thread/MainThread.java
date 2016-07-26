package green.thread;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.math.BigDecimal;

import javax.swing.Timer;

import green.detector.Detector;
import green.math.ExtTime;
import green.math.LocationMath;
import green.util.DetectorUtils;
import green.util.WebUtils;

public class MainThread extends Thread {
	
	private static String timeString;
	private static String dateString;
	
	public static GUIThread gui;
	
	@Override
	public synchronized void start() {
		super.start();
		gui = new GUIThread(this);
		gui.start();

		DetectorUtils.init();
		
		ActionListener taskPerformer = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				update();}};
		
		Timer t = new Timer(1000, taskPerformer); //Once per second
		t.setRepeats(true);
		t.start();
		
		//This should now be on GitHub.
		
	}
	
	boolean done = false;
	public void update(){
	
	}

	public static String getTime() {
		return timeString;
	}

	public static void setTime(String Time) {
		timeString = Time;
	}

	public static String getDate() {
		return dateString;
	}

	public static void setDate(String date) {
		dateString = date;
	}
	
	
	

}
