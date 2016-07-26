package green.detector;

import java.util.ArrayList;
import java.util.Date;

import green.objects.HitEvent;

public class DetectorEventLog {
	
	public Detector detector;
	public int detectorID = detector.getStationID();
	public ArrayList<HitEvent> event;
	
	public void updateData(){
		//Reach out to WebUtils
	}
	
	public void getEventsInTheLast(Date time){
			
	}
	
	public DetectorEventLog(Detector d) {
		this.detector = d;
	}

}
